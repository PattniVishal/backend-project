package com.open.OpenFin.serviceImpl;

import org.springframework.stereotype.Service;
import com.open.OpenFin.service.SMSService;

@Service
public class SMSServiceProviderA implements SMSService {

  @Override
  public String sendSMS(String phoneNumber, String message) {
    try {
      System.out.println("The SMS sent to " + phoneNumber + " is : " + message);
      return "Sent Successfully !!";
    } catch (Exception e) {
      return "SMS not sent !!";
    }
  }

}
