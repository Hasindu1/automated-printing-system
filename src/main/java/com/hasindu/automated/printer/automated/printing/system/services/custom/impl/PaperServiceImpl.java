/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasindu.automated.printer.automated.printing.system.services.custom.impl;

import com.hasindu.automated.printer.automated.printing.system.services.custom.PaperService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hasindu
 */
public class PaperServiceImpl implements PaperService{

     private final Object MUTEX_PAPER;

  
    
    

    public PaperServiceImpl(Object MUTEX_INK) {
       
        this.MUTEX_PAPER= MUTEX_INK;
        
    }


    @Override
    public void refilInk() {
        synchronized(MUTEX_PAPER){
            while(PrinterServiceImpl.remainingPaperCount != 0){
            try {
                MUTEX_PAPER.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(InkServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            try {
                Thread.sleep(2000);
                PrinterServiceImpl.remainingPaperCount = 250;
            } catch (InterruptedException ex) {
                Logger.getLogger(InkServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           MUTEX_PAPER.notifyAll();
        }
        
    }
}
