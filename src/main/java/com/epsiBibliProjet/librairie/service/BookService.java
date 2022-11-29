package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.model.Author;
import com.epsiBibliProjet.librairie.model.Book;
import com.epsiBibliProjet.librairie.model.BookItem;
import com.epsiBibliProjet.librairie.repository.AuthorRepository;
import com.epsiBibliProjet.librairie.repository.BookItemRepository;
import com.epsiBibliProjet.librairie.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements Search, Manage{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookItemRepository bookItemRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorRepository authorRepository;


    @GetMapping("all")
    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }
    @Override
    public void addBook(Book transBook) {

            Book book = new Book();
            book.setISBN(transBook.getISBN());
            book.setName(transBook.getName());
            book.setOverview(transBook.getOverview());
            book.setPublisher(transBook.getPublisher());
            book.setPublicationDate(transBook.getPublicationDate());
            if (book.getAuthors().isEmpty()) {
                throw new IllegalArgumentException("Un livre doit avoir au moins un auteur");
            } else {
                List<Author> authors = new ArrayList();
                for (Author author: book.getAuthors()) {
                    Author authorForBook = authorService.getAuthor(author.getId());
                    authors.add(authorForBook);
                }
                book.setAuthors(authors);

                bookRepository.save(book);
            }
        }


    @Override
    public List<Book> searchByTitle(String term) {
        List<Book> bookItemsFinded = bookRepository.findBookByName(term);
        return bookItemsFinded;
    }

    @Override
    public List<Book> searchByAuthorName(String nameAuthor) {
        List<Book> bookItemsFinded = new ArrayList<>();
        BookItem bookItem = (BookItem) authorRepository.findByName(nameAuthor);
        if (bookItem == null){
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