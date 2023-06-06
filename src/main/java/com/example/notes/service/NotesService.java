package com.example.notes.service;

import com.example.notes.entity.Notes;
import com.example.notes.payload.CreateNotes;

import java.util.List;
import java.util.Optional;

public interface NotesService {

    List<Notes> getListNotes();

    Notes createNotes(CreateNotes createNotes);

    Optional<Notes> updateNote(Long id, CreateNotes createNotes);

    Boolean deleteNote(Long id);
}
