package com.open.OpenFin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.open.OpenFin.dto.SendNotificationDTO;
import com.open.OpenFin.service.NotificationService;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

  @Autowired
  NotificationService notificationService;

  @PostMapping("/sms")
  public Object sendSMS(@RequestBody SendNotificationDTO body) {
    try {
      Object response = notificationService.sendNotification(body);
      return response;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

}
