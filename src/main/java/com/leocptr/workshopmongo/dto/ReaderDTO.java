package com.leocptr.workshopmongo.dto;

import com.leocptr.workshopmongo.domain.User;

import java.io.Serializable;

public class ReaderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public ReaderDTO() {
    }

    public ReaderDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }
}
