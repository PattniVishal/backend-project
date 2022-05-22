package com.open.OpenFin.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.open.OpenFin.model.Developer;
import com.open.OpenFin.model.Team;
import com.open.OpenFin.repository.TeamRepository;

@Service
public class TeamService {

  @Autowired
  TeamRepository teamRepository;

  public Team createTeam(Team team) {
    List<Developer> devs = team.getDevelopers();
    for (Developer dev : devs) {
      dev.setTeam(team);
    }
    Team newTeam = teamRepository.save(team);
    return newTeam;
  }

}
