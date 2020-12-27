/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasindu.automated.printer.automated.printing.system.util;

import com.hasindu.automated.printer.automated.printing.system.services.ServiceFactory;
import com.hasindu.automated.printer.automated.printing.system.services.ServiceTypes;
import com.hasindu.automated.printer.automated.printing.system.services.custom.PrinterService;

/**
 *
 * @author Hasindu
 */
public class InkHandler implements Runnable{
      private com.hasindu.automated.printer.automated.printing.system.services.custom.InkService inkService = ServiceFactory.getInstance().getService(ServiceTypes.INK);

      
       private static InkHandler instance;    
      private InkHandler(){
          
      }
      public static InkHandler getInstance(){
        if(instance ==null){
            synchronized(InkHandler.class){
                if(instance == null){
                    instance = new InkHandler();
                }
            }
        
          
      }
          return  instance;
      }
    @Override
    public void run() {
     while(true){
          System.out.println("came Ink");
         inkService.refilInk();
     }
    }
    
    
}
