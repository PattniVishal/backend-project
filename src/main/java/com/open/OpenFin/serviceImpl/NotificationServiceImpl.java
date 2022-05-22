package com.open.OpenFin.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.open.OpenFin.dto.SendNotificationDTO;
import com.open.OpenFin.model.Developer;
import com.open.OpenFin.model.Team;
import com.open.OpenFin.repository.TeamRepository;
import com.open.OpenFin.service.NotificationService;
import com.open.OpenFin.service.SMSService;

@Service
public class NotificationServiceImpl implements NotificationService {

  @Autowired
  TeamRepository teamRepository;

  @Autowired
  SMSService smsService;

  @Override
  public Object sendNotification(SendNotificationDTO body) {
    Long teamId = body.getTeamId();
    String msg = body.getMessage();

    Optional<Team> teamFromDB = teamRepository.findById(teamId);
    Team existingTeam = null;

    if (teamFromDB.isPresent()) {
      existingTeam = teamFromDB.get();
    }

    List<Developer> devs = existingTeam.getDevelopers();
    Developer developer = devs.get(0);

    String responseFromSMS = smsService.sendSMS(developer.getPhoneNumber(), msg);

    return responseFromSMS;
  }

}
