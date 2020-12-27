/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasindu.automated.printer.automated.printing.system.dto;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Hasindu
 */
public class NotificationDTO {
   private javax.swing.JComboBox<String> cBoxCompleted;;
     private javax.swing.JComboBox<String> cBoxRemainingTasks;
    private javax.swing.JTextField onGoingTask;
     private javax.swing.JTextField currentInkLevel;
     private javax.swing.JTextField currentPaperLevel;
    public NotificationDTO() {
    }

    public NotificationDTO(JComboBox<String> cBoxCompleted, JComboBox<String> cBoxRemainingTasks, JTextField onGoingTask, JTextField currentInkLevel, JTextField currentPaperLevel) {
        this.cBoxCompleted = cBoxCompleted;
        this.cBoxRemainingTasks = cBoxRemainingTasks;
        this.onGoingTask = onGoingTask;
        this.currentInkLevel = currentInkLevel;
        this.currentPaperLevel = currentPaperLevel;
    }
    


    

    public JComboBox<String> getcBoxCompleted() {
        return cBoxCompleted;
    }

    public void setcBoxCompleted(JComboBox<String> cBoxCompleted) {
        this.cBoxCompleted = cBoxCompleted;
    }

    public JComboBox<String> getcBoxRemainingTasks() {
        return cBoxRemainingTasks;
    }

    public void setcBoxRemainingTasks(JComboBox<String> cBoxRemainingTasks) {
        this.cBoxRemainingTasks = cBoxRemainingTasks;
    }

    public JTextField getOnGoingTask() {
        return onGoingTask;
    }

    public void setOnGoingTask(JTextField onGoingTask) {
        this.onGoingTask = onGoingTask;
    }

    public JTextField getCurrentInkLevel() {
        return currentInkLevel;
    }

    public void setCurrentInkLevel(JTextField currentInkLevel) {
        this.currentInkLevel = currentInkLevel;
    }

    public JTextField getCurrentPaperLevel() {
        return currentPaperLevel;
    }

    public void setCurrentPaperLevel(JTextField currentPaperLevel) {
        this.currentPaperLevel = currentPaperLevel;
    }
    

    public void update(NotificationDTO notificationDTO){
        this.setOnGoingTask(notificationDTO.getOnGoingTask());
          this.setcBoxCompleted(notificationDTO.getcBoxCompleted());
            this.setcBoxRemainingTasks(notificationDTO.getcBoxRemainingTasks());
    }

    @Override
    public String toString() {
        return "NotificationDTO{" + "cBoxCompleted=" + cBoxCompleted + ", cBoxRemainingTasks=" + cBoxRemainingTasks + ", onGoingTask=" + onGoingTask + ", currentInkLevel=" + currentInkLevel + ", currentPaperLevel=" + currentPaperLevel + '}';
    }
    

   

   
    
    
}
