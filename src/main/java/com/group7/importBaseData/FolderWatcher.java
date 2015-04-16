package com.group7.importBaseData;
 
import java.io.IOException;
 
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Stateless;
 
import jxl.read.biff.BiffException;
 
@Stateless
@Local
public interface FolderWatcher {
 
    @Asynchronous
    public void runner() throws BiffException, IOException;
 
    public void stopRunner();
     
}