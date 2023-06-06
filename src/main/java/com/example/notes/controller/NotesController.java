package com.example.notes.controller;

import com.example.notes.entity.Notes;
import com.example.notes.payload.CreateNotes;
import com.example.notes.repository.NotesRepository;
import com.example.notes.service.serviceImpl.NotesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NotesController {
    @Autowired
    private NotesServiceImpl notesService;

    @CrossOrigin(origins = "*")
    @GetMapping
    private List<Notes> getListAllNotes() {
        List<Notes> notes = notesService.getListNotes();
        return notes;
    }
    @PostMapping
    public Notes createNotes(@RequestBody CreateNotes createNotes) {
        Notes newNotes = notesService.createNotes(createNotes);
        return newNotes;
    }
    @DeleteMapping("/{id}")
    public boolean deleteNote(@PathVariable("id") Long id) {
        return notesService.deleteNote(id);
    }

    @PutMapping("/{id}")
    public Notes upDateNote(@PathVariable("id") Long id, @RequestBody CreateNotes createNotes) {
        Optional<Notes> optionalNotes = notesService.updateNote(id, createNotes);
        return optionalNotes.orElse(null);
    }
}
