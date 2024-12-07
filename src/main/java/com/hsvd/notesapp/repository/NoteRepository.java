package com.hsvd.notesapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.hsvd.notesapp.entity.Note;

public interface NoteRepository extends CrudRepository<Note, Long> {
    
}
