package com.hsvd.notesapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

enum Status {
    PUBLIC,
    PRIVATE;
}

@Entity
@Table(name = "note")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    @NotBlank(message =  "Title cannot be empty")
    
    private String title;

    @Column(name = "description", nullable = false)
    @NotBlank(message =  "Description cannot be empty")
    private String description;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User author;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "likes", nullable = false)
    private Long likes;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    

}
