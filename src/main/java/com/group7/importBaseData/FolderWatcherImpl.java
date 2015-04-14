package com.group7.importBaseData;
 
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
 
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
 
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
 
import jxl.read.biff.BiffException;
 
import com.group7.entities.BaseData;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;
import com.group7.serviceInterface.BaseDataServiceLocal;
 
 
 
@Stateless
@Local
public class FolderWatcherImpl implements FolderWatcher {
 
    private String folder="/home/giovanni/RemoteUploads";
    private WatchService watcher;
    private Map<WatchKey,Path> keys;
    private java.nio.file.Path dir ;
    private boolean running=true;
     
    @Inject
    private BaseDataServiceLocal service;
    private BaseDataValidation bvd = BaseDataValidation.getInstance();
     
    public FolderWatcherImpl() throws BiffException, IOException{
        this.dir=   Paths.get(this.folder);
        this.watcher=FileSystems.getDefault().newWatchService();
        this.keys=new HashMap<WatchKey,Path>();
         
        register(dir);
         
    }
     
    private void register(Path dir) throws IOException {
        WatchKey key = dir.register(watcher, ENTRY_CREATE);
        keys.put(key, dir);
    }
     
    @SuppressWarnings("unchecked")
    static <T> WatchEvent <T> cast(WatchEvent<?> event){
        return (WatchEvent<T>) event;
    }
     
    @Asynchronous
    public void runner() throws BiffException, IOException {
            System.out.println("runner called");
            System.out.println("Watch Service registered for dir: " + dir.getFileName());
              
            while (running) {
                System.out.println("loop");
                WatchKey key = null;
                try {
                    key = watcher.take();
                } catch (InterruptedException ex) {
                    //return;
                }
                 
                Path dir = keys.get(key);
                if(dir == null){
                    System.err.println("watchkey not recognized");
                    continue;
                }
                 
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    if(running==false)
                        break;
                     
                    WatchEvent<Path> ev =cast(event);
                    Path name=ev.context();
                    Path child=dir.resolve(name);
                     
                    System.out.println(event.kind().name()+": "+child);
                     
                    String extension="";
                    int index=child.toString().lastIndexOf('.');
                    if(index>0){
                        extension=child.toString().substring(index+1);
                    }
                     
                    System.out.println("    Extension "+extension);
                     
                    if ((kind == ENTRY_CREATE) && (extension.equals("xls"))) {
                         
                        try{
                            BaseDataExcelRead bdxr = new BaseDataExcelRead(
                                    child.toString());
                            Collection<Network> networkData = bdxr.readNetworkTable();
                            Collection<UE> ueData = bdxr.readUETable();
                            Collection<EventCause> eventCauseData = bdxr
                                    .readEventCauseTable();
                            Collection<Failure> failureData = bdxr.readFailureClassTable();
                             
                             
                            // Filling the cache
                            bvd.setEventCauses(eventCauseData);
                            bvd.setFailures(failureData);
                            bvd.setNetworks(networkData);
                            bvd.setUeObjects(ueData);
     
                            Collection<BaseData> bd = bdxr.readExcelFile(service.getLastRowId());
                            // Filling the Datasbase
                            System.out.println("begin insert data");
                            service.putNetworkData(networkData);
                            service.putUEData(ueData);
                            service.putEventCauseData(eventCauseData);
                            service.putFailureData(failureData);
                            service.putData(bd);
                            System.out.println("finished inset data");
                            // Should I make these Collection null now??
                            networkData = null;
                            ueData = null;
                            eventCauseData = null;
                            failureData = null;
                            bd = null;
                        }
                        catch(Exception e){
                            File file = new File(child.toString());
                             
                             
                            //file.renameTo(child.toString());
                            file.renameTo(file);
                        }
                         
                         
                        }
                         
                         
                         
                     
                     
                     
                }
                 
                boolean valid=key.reset();
                if(!valid){
                    keys.remove(key);
                     
                    if(keys.isEmpty()){
                        break;
                    }
                }
           }
    }
 
    @Override
    public void stopRunner() {
        // TODO Auto-generated method stub
        running=false;
    }
}