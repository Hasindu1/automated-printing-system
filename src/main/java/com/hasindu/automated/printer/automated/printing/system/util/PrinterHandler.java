/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasindu.automated.printer.automated.printing.system.util;

import com.hasindu.automated.printer.automated.printing.system.dto.TaskDTO;
import com.hasindu.automated.printer.automated.printing.system.services.ServiceFactory;
import com.hasindu.automated.printer.automated.printing.system.services.ServiceTypes;
import com.hasindu.automated.printer.automated.printing.system.services.custom.PrinterService;
import java.util.List;

/**
 *
 * @author Hasindu
 */
public class PrinterHandler implements Runnable {
       private PrinterService printerService = ServiceFactory.getInstance().getService(ServiceTypes.PRINT);
       private boolean status;
       private boolean printStatus;
        private static PrinterHandler instance;    
      private PrinterHandler(){
          
      }
      public static PrinterHandler getInstance(){
        if(instance ==null){
            synchronized(PrinterHandler.class){
                if(instance == null){
                    instance = new PrinterHandler();
                }
            }
        
          
      }
          return  instance;
      }
      

    @Override
    public void run() {
        while(status){
            System.out.println("came on");
            while(printStatus){
             System.out.println("came print");
        if(printerService.print()){
           this.printStatus =false; 
        }
            }
        
        }
        System.out.println("Offed");
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PrinterService getPrinterService() {
        return printerService;
    }

    public void setPrinterService(PrinterService printerService) {
        this.printerService = printerService;
    }

    public boolean isPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(boolean printStatus) {
        this.printStatus = printStatus;
    }
    
    
}
