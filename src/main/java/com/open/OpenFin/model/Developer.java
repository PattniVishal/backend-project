package com.open.OpenFin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity(name = "developers")
public class Developer {
  @Id()
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String phoneNumber;
  @ManyToOne
  @JoinColumn(name = "team_id", referencedColumnName = "id")
  @JsonIgnore
  private Team team;
}
