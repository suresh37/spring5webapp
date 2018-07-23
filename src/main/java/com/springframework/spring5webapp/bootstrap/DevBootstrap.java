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
        Publisher hc = new Publisher("Harper Collins", "New York");
        Book ddd = new Book("domain driven design","1234",
               hc);

     //   System.out.println(eric);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authRepo.save(eric);
        pubRepo.save(hc);
        bookRepo.save(ddd);


        //Rod
        Author rod = new Author("Rod","Johnson");
        Publisher work = new Publisher("Work", "New Mexico");
        Book jee = new Book("JEE development","1235",
              work );

        rod.getBooks().add(jee);
        jee.getAuthors().add(rod);

        authRepo.save(rod);
        pubRepo.save(work);
        bookRepo.save(jee);

    }
}
