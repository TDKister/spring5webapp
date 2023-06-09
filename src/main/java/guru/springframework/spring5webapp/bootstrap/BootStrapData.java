package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("tyler", "kister");
        Book aNewBook = new Book("book", "1234" );

        author.getBooks().add(aNewBook);

        Author author2 = new Author("Joe", "Bob");
        Book aNewBook2 = new Book("book2", "54321" );
        Book aNewBook3 = new Book("book3", "13579" );

        Set<Book> bookList = new HashSet<Book>();
        bookList.add(aNewBook2);
        author2.setBooks(bookList);

        System.out.println("BootStrapProgramStart");
        System.out.println("number of books = " + author2.getBooks().size());
    }
}
