package springtemplate.dao.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotNull
  @Size(min = 3, max = 80)
  private String email;
  
  @NotNull
  @Size(min = 2, max = 80)
  private String name;
  
  @NotNull
  @Size(min = 2, max = 50)
  private String username;
  
  @NotNull
  @Size(min = 2, max = 255)
  private String password;
  

  public User(long id) { 
    this.id = id;
  }

  public User(String name, String email, String username, String password) {
    this.email = email;
    this.name = name;
    this.username = username;
    this.password = password;
  }
  
} 
