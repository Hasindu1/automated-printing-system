/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasindu.automated.printer.automated.printing.system.services.custom.impl;

import com.hasindu.automated.printer.automated.printing.system.dto.NotificationDTO;
import com.hasindu.automated.printer.automated.printing.system.dto.TaskDTO;
import com.hasindu.automated.printer.automated.printing.system.services.custom.PrinterService;
import com.hasindu.automated.printer.automated.printing.system.util.TaskTypes;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hasindu
 */
public class PrinterServiceImpl implements PrinterService {

    public static volatile SortedSet<TaskDTO> tasksSet;
    private static NotificationDTO notificationDTO;
    public static volatile Integer remainingCatridgeCount;
    public static volatile Integer remainingPaperCount;
    private final Object MUTEX_INK;
    private final Object MUTEX_PAPER;
    private TaskDTO pausedTaskDTO;
    
    

    public PrinterServiceImpl(Object MUTEX_INK,Object MUTEX_PAPER) {
        if (tasksSet == null) {
            tasksSet = new TreeSet<>();
        }
        this.MUTEX_INK= MUTEX_INK;
        this.MUTEX_PAPER= MUTEX_PAPER;
        remainingCatridgeCount = 500;
        remainingPaperCount=250;
        
    }

    @Override
    public boolean print() {
        System.out.println("Noti" + notificationDTO);
        if(isRemaining()){
            System.out.println("Paper" + remainingPaperCount);
            System.out.println("Here");
        synchronized(MUTEX_PAPER){
            System.out.println("Didn't came");
//            while(remainingPaperCount == 0){
//                 try {
//                MUTEX_PAPER.wait();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(PrinterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            }
          
            synchronized(MUTEX_INK){
//                while(remainingCatridgeCount == 0){
//                    try {
//                        MUTEX_INK.wait();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(PrinterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//            }

//             if(pausedTaskDTO !=null){
//                 for(int i = pausedTaskDTO.getCompletedAmount() +1 ; i<= pausedTaskDTO.getNoOfPages();i++){
//                  
//                    if(PrinterServiceImpl.remainingCatridgeCount ==0 || PrinterServiceImpl.remainingPaperCount == 0){
//                        if(PrinterServiceImpl.remainingCatridgeCount == 0){
//                            MUTEX_INK.notifyAll();
//                            try {
//                                MUTEX_INK.wait();
//                            } catch (InterruptedException ex) {
//                                Logger.getLogger(PrinterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            
//                        }if (this.remainingPaperCount == 0){
//                             MUTEX_PAPER.notifyAll();
//                             try {
//                                MUTEX_PAPER.wait();
//                            } catch (InterruptedException ex) {
//                                Logger.getLogger(PrinterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                             
//                        }
//                         
//                         
//                    }
//                       PrinterServiceImpl.remainingCatridgeCount --;
//                    PrinterServiceImpl.remainingPaperCount --;
//                    pausedTaskDTO.setCompletedAmount(i);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(PrinterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//                        return false;
//                    }
//                 }
//                 refreshRemainingTasks(pausedTaskDTO);
//            
//
//               
//                   notificationDTO.getOnGoingTask().setText(TaskTypes.IDLE.toString());
//                   pausedTaskDTO.setTaskType(TaskTypes.COMPLETED);
//                    notificationDTO.getcBoxCompleted().addItem(pausedTaskDTO.getTaskId().toString());
//                    pausedTaskDTO = null;
//                    
//                    
//                 
//             }     
             outer: for (TaskDTO taskDTO : tasksSet) {
            if (taskDTO.getTaskType().equals(TaskTypes.WAIT)) {
                   
                    taskDTO.setTaskType(TaskTypes.PROGRESS);
                     notificationDTO.getOnGoingTask().setText(taskDTO.getTaskId().toString());
                for(int i = 1 ; i<=taskDTO.getNoOfPages() ;i++ ){
                   
                    while(PrinterServiceImpl.remainingCatridgeCount ==0 || PrinterServiceImpl.remainingPaperCount == 0){
                             pausedTaskDTO = taskDTO;
                        if(PrinterServiceImpl.remainingCatridgeCount == 0){
                            MUTEX_INK.notifyAll();
                                 try {
                                     MUTEX_INK.wait();
                                 } catch (InterruptedException ex) {
                                     Logger.getLogger(PrinterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                                 }
                            
                        }if (PrinterServiceImpl.remainingPaperCount == 0){
                             MUTEX_PAPER.notifyAll();
                                 try {
                                     MUTEX_PAPER.wait();
                                 } catch (InterruptedException ex) {
                                     Logger.getLogger(PrinterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                                 }
                             
                        }
                        
                        
                   
                    }
                     PrinterServiceImpl.remainingCatridgeCount --;
                    PrinterServiceImpl.remainingPaperCount --;
                    notificationDTO.getCurrentInkLevel().setText((remainingCatridgeCount.toString()));
                          notificationDTO.getCurrentPaperLevel().setText((remainingPaperCount.toString()));
                    taskDTO.setCompletedAmount(i);
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PrinterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                    }
                }
                 refreshRemainingTasks(taskDTO);
            

               
                   notificationDTO.getOnGoingTask().setText(TaskTypes.IDLE.toString());
                    taskDTO.setTaskType(TaskTypes.COMPLETED);
                    notificationDTO.getcBoxCompleted().addItem(taskDTO.getTaskId().toString());
                    
                    
                    

         
                   
                
            }
        }
            

        return true;
            }
        
        }
        }
        return true;
        
    }
private void refreshRemainingTasks(TaskDTO taskDTO){
    for(int i = 0 ; i <  PrinterServiceImpl.notificationDTO.getcBoxRemainingTasks().getItemCount();i++ ){
        if(PrinterServiceImpl.notificationDTO.getcBoxRemainingTasks().getItemAt(i).equals(taskDTO.getTaskId().toString())){
           PrinterServiceImpl.notificationDTO.getcBoxRemainingTasks().removeItemAt(i);
        }
    }
    
}
private boolean isRemaining(){
    for(TaskDTO taksDTO :tasksSet){
        if(taksDTO.getTaskType().equals(TaskTypes.WAIT)){
            return true;
        }
    }
    return false;
}
    @Override
    public TaskDTO generateTaskId(TaskDTO taskDTO) {
        if(tasksSet.size() ==0 ){
            taskDTO.setTaskId(1);
               tasksSet.add(taskDTO);
               return taskDTO;
        }
        int taskId = tasksSet.last().getTaskId() + 1;

        taskDTO.setTaskId(taskId);
        tasksSet.add(taskDTO);
        return taskDTO;

    }

    @Override
    public void register(NotificationDTO notificationDTO) {
        System.out.println("came111");
        System.out.println("No" + notificationDTO);
        PrinterServiceImpl.notificationDTO = notificationDTO;
    }

   

    @Override
    public void addTask(TaskDTO taskDTO) {
        tasksSet.add(taskDTO);
        System.out.println(notificationDTO);
        notificationDTO.getcBoxRemainingTasks().addItem(taskDTO.getTaskId().toString());
    }



}
