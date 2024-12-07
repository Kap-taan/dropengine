package com.hsvd.notesapp.service;

import java.util.List;

import com.hsvd.notesapp.entity.Note;

public interface NoteService {
    
    List<Note> getAllNotes();
    void createNote(Note note, Long userId);

}
