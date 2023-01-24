package alex.klimchuk.spring.web.app.bootstrap;

import alex.klimchuk.spring.web.app.entities.AuthorEntity;
import alex.klimchuk.spring.web.app.entities.BookEntity;
import alex.klimchuk.spring.web.app.entities.PublisherEntity;
import alex.klimchuk.spring.web.app.repositories.AuthorRepository;
import alex.klimchuk.spring.web.app.repositories.BookRepository;
import alex.klimchuk.spring.web.app.repositories.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Copyright Alex Klimchuk (c) 23.12.2019.
 */
@Slf4j
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {
        log.info("Started in Bootstrap");

        PublisherEntity publisher = new PublisherEntity();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        log.info("Publisher Count: " + publisherRepository.count());

        AuthorEntity eric = new AuthorEntity("Eric", "Evans");
        BookEntity ddd = new BookEntity("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        AuthorEntity rod = new AuthorEntity("Rod", "Johnson");
        BookEntity noEJB = new BookEntity("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        log.info("Number of Books: " + bookRepository.count());
        log.info("Publisher Number of Books: " + publisher.getBooks().size());
    }

}
