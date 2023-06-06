package com.example.notes.service.serviceImpl;

import com.example.notes.entity.Notes;
import com.example.notes.payload.CreateNotes;
import com.example.notes.repository.NotesRepository;
import com.example.notes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService {
    @Autowired
    private NotesRepository notesRepository;


    @Override
    public List<Notes> getListNotes() {
        List<Notes> notes = notesRepository.findAll();
        return notes;
    }

    @Override
     public Notes createNotes(CreateNotes createNotes) {
        Notes newNote = new Notes();
        newNote.setNotes(createNotes.getNotes());
        newNote = notesRepository.save(newNote);
        return newNote;
    }

    @Override
    public Optional<Notes> updateNote(Long id, CreateNotes createNotes) {
        Optional<Notes> optionalNotes = notesRepository.findById(id);
        if (optionalNotes.isPresent()) {
            Notes notes = optionalNotes.get();
            notes.setNotes(createNotes.getNotes());
            return Optional.of(notesRepository.save(notes));
        }
        return Optional.empty();
    }

    @Override
    public  Boolean deleteNote(Long id) {
        Optional<Notes> optionalNotes = notesRepository.findById(id);
        if (optionalNotes.isPresent()) {
            notesRepository.delete(optionalNotes.get());
            return true;
        }
        return false;
    }


}
