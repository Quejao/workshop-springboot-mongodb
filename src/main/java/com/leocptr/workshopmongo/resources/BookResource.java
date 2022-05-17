package com.leocptr.workshopmongo.resources;

import com.leocptr.workshopmongo.domain.Book;
import com.leocptr.workshopmongo.domain.User;
import com.leocptr.workshopmongo.dto.UserDTO;
import com.leocptr.workshopmongo.service.BookService;
import com.leocptr.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/books")
public class BookResource {
    @Autowired
    private BookService service;
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Book>> findAll(){
        List<Book> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public ResponseEntity<Book> findById(@PathVariable String id){
        Book book = service.findById(id);
        return ResponseEntity.ok().body(book);
    }
}
