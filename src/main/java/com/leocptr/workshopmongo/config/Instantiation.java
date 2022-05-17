package com.leocptr.workshopmongo.config;

import com.leocptr.workshopmongo.domain.Book;
import com.leocptr.workshopmongo.domain.User;
import com.leocptr.workshopmongo.repository.BookRepository;
import com.leocptr.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        bookRepository.deleteAll();

        User user1 = new User(null, "Maria Eduarda Corrá", "maria@gmail.com");
        User user2 = new User(null, "Rafael Corrá", "rafael@gmail.com");
        User user3 = new User(null, "Bianca Corrá", "bianca@gmail.com");

        Book book1 = new Book(null,"Guia do Mochileiro das Galáxias", "Douglas Adams", sdf.parse("12/10/1979"));
        Book book2 = new Book(null,"The Hobbit", "J. R. R. Tolkien", sdf.parse("21/09/1937"));
        book1.setReader(user1);

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        bookRepository.saveAll(Arrays.asList(book1,book2));
    }
}
