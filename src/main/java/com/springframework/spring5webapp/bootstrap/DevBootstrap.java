package com.springframework.spring5webapp.bootstrap;

import com.springframework.spring5webapp.model.Author;
import com.springframework.spring5webapp.model.Book;
import com.springframework.spring5webapp.model.Publisher;
import com.springframework.spring5webapp.repositories.AuthorRepository;
import com.springframework.spring5webapp.repositories.BookRepository;
import com.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.EventListener;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authRepo;
    private BookRepository bookRepo;
    private PublisherRepository pubRepo;

    public DevBootstrap() {
    }

    public DevBootstrap(AuthorRepository authRepo, BookRepository bookRepo, PublisherRepository pubRepo) {
        this.authRepo = authRepo;
        this.bookRepo = bookRepo;
        this.pubRepo = pubRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
    public void initData() {
        // Eric
        Author eric = new Author("Eric","Evans");
        Publisher collins =
                new Publisher();
        collins.setName("Collins Harper");
        collins.setAddress("North London");
        pubRepo.save(collins);
        Book ddd = new Book("domain driven design","1234",
               collins);

        System.out.println(eric);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authRepo.save(eric);
        bookRepo.save(ddd);


        //Rod
        Author rod = new Author("Rod","Johnson");
        Publisher worx =  new Publisher();
        worx.setName("Worx");
        pubRepo.save(worx);
        Book jee = new Book("JEE development","1235",
              worx );

        rod.getBooks().add(jee);
        authRepo.save(rod);
        bookRepo.save(jee);

    }
}
