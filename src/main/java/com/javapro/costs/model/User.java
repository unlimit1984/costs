package com.javapro.costs.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User extends DomainObject {

  @Column(name = "email")
  private String email;

  @Column(name = "name")
  private String name;

  @Column(name = "created_date")
  private LocalDate createdDate;

  public User() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (!(o instanceof User)) return false;

    User user = (User) o;

    return new EqualsBuilder()
        .append(email, user.email)
        .append(name, user.name)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(email)
        .append(name)
        .toHashCode();
  }
}
