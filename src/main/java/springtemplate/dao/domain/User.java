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

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotNull
  @Size(min = 3, max = 80)
  private String email;
  
  @NotNull
  @Size(min = 2, max = 80)
  private String name;

  public User(long id) { 
    this.id = id;
  }

  public User(String email, String name) {
    this.email = email;
    this.name = name;
  }
  
} 
