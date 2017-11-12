package guru.springFramework.spring5webapp.bootstrap;

import guru.springFramework.spring5webapp.model.Author;
import guru.springFramework.spring5webapp.model.Book;
import guru.springFramework.spring5webapp.model.Publisher;
import guru.springFramework.spring5webapp.repositories.AuthorRepository;
import guru.springFramework.spring5webapp.repositories.BookRepository;
import guru.springFramework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher HarperC = new Publisher("Harper Collins", "some weird add");
        publisherRepository.save(HarperC);
        Book ddd = new Book("Domain Driven Design", "1234", HarperC);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "Other fancy address");
        publisherRepository.save(worx);
        Book noEJB = new Book("J2EE Development without EJB", "2344", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
