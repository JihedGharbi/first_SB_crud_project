package com.fstg.mediatechs.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "role_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    @Id
    private Integer roleId;
    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name="user_roles" , joinColumns = @JoinColumn(name = "roleId") , inverseJoinColumns = @JoinColumn(name="userID"))
    private List<User> users;
}
