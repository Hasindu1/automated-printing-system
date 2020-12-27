/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasindu.automated.printer.automated.printing.system.services.custom;

import com.hasindu.automated.printer.automated.printing.system.dto.NotificationDTO;
import com.hasindu.automated.printer.automated.printing.system.services.*;
import com.hasindu.automated.printer.automated.printing.system.dto.TaskDTO;

/**
 *
 * @author Hasindu
 */
public interface PrinterService extends SuperService {
    boolean print();
    TaskDTO generateTaskId(TaskDTO taskDTO);
    void addTask(TaskDTO taskDTO);
    void register(NotificationDTO notificationDTO);
  
    
}
