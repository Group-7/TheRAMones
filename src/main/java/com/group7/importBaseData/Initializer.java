package com.group7.importBaseData;
 
import java.io.IOException;
 
import javax.ejb.Asynchronous;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 
import jxl.read.biff.BiffException;
 
 
public class Initializer implements ServletContextListener {
 
    @Inject
    private FolderWatcher fw;
     
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        fw.stopRunner();
    }
 
     
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
         
        try {
            System.out.println("async call");
            fw.runner();
            System.out.println("aynce call return");
        } catch (BiffException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
}