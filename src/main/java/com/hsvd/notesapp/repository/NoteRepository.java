package com.hsvd.notesapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hsvd.notesapp.entity.Note;
import com.hsvd.notesapp.entity.User;

public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findAllByAuthor(User authorId);
}
