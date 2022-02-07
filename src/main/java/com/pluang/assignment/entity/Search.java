package com.pluang.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long searchId;
    private long searchItem;
    private String result;
    private LocalDateTime firstInsertDateTime;
    private LocalDateTime lastSearchDateTime;
    private long searchCount;

    public Search(String result) {
        this.result = result;
    }
}
