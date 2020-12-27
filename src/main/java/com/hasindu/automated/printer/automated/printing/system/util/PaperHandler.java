/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasindu.automated.printer.automated.printing.system.util;

import com.hasindu.automated.printer.automated.printing.system.services.ServiceFactory;
import com.hasindu.automated.printer.automated.printing.system.services.ServiceTypes;

/**
 *
 * @author Hasindu
 */
public class PaperHandler implements Runnable{
    
      private com.hasindu.automated.printer.automated.printing.system.services.custom.PaperService paperService = ServiceFactory.getInstance().getService(ServiceTypes.PAPER);
      private static PaperHandler instance;    
      private PaperHandler(){
          
      }
      public static PaperHandler getInstance(){
        if(instance ==null){
            synchronized(PaperHandler.class){
                if(instance == null){
                    instance = new PaperHandler();
                }
            }
        
          
      }
          return  instance;
      }
    @Override
    public void run() {
     while(true){
          System.out.println("came paper");
         paperService.refilInk();
     }
    }
    
}
