package com.open.OpenFin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.open.OpenFin.model.Team;
import com.open.OpenFin.serviceImpl.TeamService;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

  @Autowired
  TeamService teamService;

  @PostMapping("/")
  public Team createTeam(@RequestBody Team newTeam) {
    try {
      Team team = teamService.createTeam(newTeam);
      return team;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

}
