package com.hsvd.notesapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsvd.notesapp.entity.Note;
import com.hsvd.notesapp.entity.User;
import com.hsvd.notesapp.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {
    
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Note> getAllNotes() {
        List<Note> notes = (List<Note>)noteRepository.findAll();
        return notes;
    }

    @Override
    public void createNote(Note note, Long userId) {
        User user = userService.findUserById(userId);
        note.setAuthor(user);
        note.setLikes(0L);
        note.setCreatedAt(new Date());
        noteRepository.save(note);
    }

    

}