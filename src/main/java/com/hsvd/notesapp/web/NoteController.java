package com.hsvd.notesapp.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsvd.notesapp.entity.Note;
import com.hsvd.notesapp.service.NoteService;

@RestController
public class NoteController {
    
    @Autowired
    private NoteService noteService;

    @GetMapping("/getnotes")
    public ResponseEntity<List<Note>> getNotes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Note> notes = noteService.getNotesForUsername(authentication.getPrincipal().toString());
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @PostMapping("/createnote")
    public ResponseEntity<HttpStatus> createNote(@Valid @RequestBody Note note) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getPrincipal().toString();
        noteService.createNote(note, username);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
