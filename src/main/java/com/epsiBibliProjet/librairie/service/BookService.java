package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.dto.BookDto;
import com.epsiBibliProjet.librairie.dto.BookResponseDto;
import com.epsiBibliProjet.librairie.enumator.BookStatus;
import com.epsiBibliProjet.librairie.model.Author;
import com.epsiBibliProjet.librairie.model.Book;
import com.epsiBibliProjet.librairie.model.BookItem;
import com.epsiBibliProjet.librairie.model.Library;
import com.epsiBibliProjet.librairie.repository.AuthorRepository;
import com.epsiBibliProjet.librairie.repository.BookItemRepository;
import com.epsiBibliProjet.librairie.repository.BookRepository;
import com.epsiBibliProjet.librairie.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements Search, Manage {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookItemRepository bookItemRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @GetMapping("all")
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public void addBook(BookDto transBook) {

        BookItem book = new BookItem();
        Library library = libraryRepository.findLibraryByName(transBook.getLibrary());
        book.setIsbn(transBook.getIsbn());
        book.setName(transBook.getName());
        book.setOverview(transBook.getOverview());
        book.setPublisher(transBook.getPublisher());
        book.setPublicationDate(transBook.getPublicationDate());
        book.setSubject(transBook.getSubject());
        book.setLang(transBook.getLang());
        if (transBook.getAuthorIds().isEmpty()) {
            throw new IllegalArgumentException("you need atleast on author");
        } else {
            // sinon on crée une liste d'auteur et on donne au livre
            List<Author> authors = new ArrayList();
            for (Long authorId : transBook.getAuthorIds()) {
                Author author = authorService.getAuthor(authorId);
                authors.add(author);
            }
            book.setAuthors(authors);
        }
        book.setBarcode(transBook.getBarcode());
        book.setNumberOfPages(transBook.getNumberOfPages());
        book.setIsbn(book.getIsbn());
        book.setTag(transBook.getTitle());
        book.setFormat(transBook.getFormat());
        book.setSubject(book.getSubject());
        book.setLibrary(library.getName());
        book.setStatus(BookStatus.FREE);

        bookRepository.save(book);
    }




    @Override
    public List<Book> searchByTitle(String term) {
        List<Book> bookItemsFinded = bookRepository.findBookByName(term);
        return bookItemsFinded;
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }
    @Override
    public List<Book> searchByAuthorName(String nameAuthor) {
        List<Book> bookItemsFinded = new ArrayList<>();
        BookItem bookItem = (BookItem) authorRepository.findByName(nameAuthor);
        if (bookItem == null) {
            //Exception
        }
        bookItemsFinded.add(bookItem);
        return bookItemsFinded;
    }

    public Book getBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new IllegalArgumentException("cannot find book with id: " + bookId));
        return book;
    }

    public BookResponseDto addAuthorToBook(Long bookId, Long authorId) {
        Book book = getBook(bookId);
        Author author = authorService.getAuthor(authorId);
        if (author.getBooks().contains(author)) {
            throw new IllegalArgumentException("this author is already assigned to this book");
        }
        book.addAuthor(author);
        author.addBook(book);

        return null;
    }


    public BookResponseDto deleteAuthorFromBook(Long bookId, Long authorId) {
        Book book = getBook(bookId);
        Author author = authorService.getAuthor(authorId);
        if (!(author.getBooks().contains(book))) {
            throw new IllegalArgumentException("book does not have this author");
        }
        author.removeBook(book);
        book.deleteAuthor(author);
        return null;
    }


    @Override
    public Book edit(Book book, long id) {
        return null;
    }

    @Override
    public void delete(long bookId) {
        Book book = getBook(bookId);
        this.bookRepository.delete(book);
    }


}