/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasindu.automated.printer.automated.printing.system.services;

import com.hasindu.automated.printer.automated.printing.system.services.custom.impl.InkServiceImpl;
import com.hasindu.automated.printer.automated.printing.system.services.custom.impl.PaperServiceImpl;
import com.hasindu.automated.printer.automated.printing.system.services.custom.impl.PrinterServiceImpl;

/**
 *
 * @author Hasindu
 */
public class ServiceFactory {
     private static ServiceFactory serviceFactory;
     private  final Object MUTEX_INK;
     private  final Object MUTEX_PAPER;
    
    private ServiceFactory(){
        MUTEX_INK = new Object();
        MUTEX_PAPER = new Object();
        
    }
    
    public static ServiceFactory getInstance(){
        if(serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
       
        return serviceFactory;
    }
    
    public <T extends SuperService> T getService(ServiceTypes serviceType){
        
             switch (serviceType) {
            case PRINT:
                return (T) new PrinterServiceImpl(MUTEX_INK,MUTEX_PAPER);
            case INK:
                 return (T) new InkServiceImpl(MUTEX_INK);
                 case PAPER:
                 return (T) new PaperServiceImpl(MUTEX_PAPER);
            default:
                return null;
        }
        
    }
    
}
