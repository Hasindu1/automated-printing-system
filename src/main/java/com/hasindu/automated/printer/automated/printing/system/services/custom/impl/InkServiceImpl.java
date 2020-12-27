/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasindu.automated.printer.automated.printing.system.services.custom.impl;

import com.hasindu.automated.printer.automated.printing.system.services.custom.InkService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hasindu
 */
public class InkServiceImpl implements InkService{
     private final Object MUTEX_INK;

  
    
    

    public InkServiceImpl(Object MUTEX_INK) {
       
        this.MUTEX_INK= MUTEX_INK;
        
    }


    @Override
    public void refilInk() {
        synchronized(MUTEX_INK){
            while(PrinterServiceImpl.remainingCatridgeCount != 0){
            try {
                MUTEX_INK.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(InkServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            try {
                Thread.sleep(2000);
                PrinterServiceImpl.remainingCatridgeCount = 500;
                System.out.println("REFILLEEEEDDDD");
            } catch (InterruptedException ex) {
                Logger.getLogger(InkServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           MUTEX_INK.notifyAll();
        }
        
    }
    
}
