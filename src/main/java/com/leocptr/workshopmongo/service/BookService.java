package com.leocptr.workshopmongo.service;

import com.leocptr.workshopmongo.domain.Book;
import com.leocptr.workshopmongo.domain.User;
import com.leocptr.workshopmongo.dto.UserDTO;
import com.leocptr.workshopmongo.repository.BookRepository;
import com.leocptr.workshopmongo.repository.UserRepository;
import com.leocptr.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public List<Book> findAll(){
        return repo.findAll();
    }

    public Book findById(String id) {
        Optional<Book> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
