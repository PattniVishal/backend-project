package com.open.OpenFin.service;

import com.open.OpenFin.dto.SendNotificationDTO;

public interface NotificationService {
  public Object sendNotification(SendNotificationDTO body);
}
