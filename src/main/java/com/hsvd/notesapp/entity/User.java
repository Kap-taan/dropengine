package com.hsvd.notesapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    @NotBlank(message =  "Name cannot be empty")
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    @JsonProperty("username")
    @NotBlank(message =  "Username cannot be empty")
    private String username;

    @Column(name = "avatar", nullable = false, length = 3000)
    @JsonProperty("avatar")
    @NotBlank(message =  "Avatar cannot be empty")
    private String avatar;

    @NonNull
    @Column(name = "password", nullable = false)
    @JsonProperty("password")
    @NotBlank(message =  "Password cannot be empty")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Note> notes;

}
