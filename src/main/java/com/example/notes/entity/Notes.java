package com.example.notes.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table (name = "notes")
@Entity
public class Notes {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "note")
    String notes;

}
