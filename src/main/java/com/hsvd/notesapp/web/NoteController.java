package com.hsvd.notesapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<Note> notes = noteService.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @PostMapping("/createnote/{userId}")
    public ResponseEntity<HttpStatus> createNote(@RequestBody Note note, @PathVariable String userId) {
        noteService.createNote(note, Long.valueOf(userId));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
