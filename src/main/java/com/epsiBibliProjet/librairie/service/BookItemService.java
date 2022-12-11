package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.dto.BookDto;
import com.epsiBibliProjet.librairie.dto.BookItemDto;
import com.epsiBibliProjet.librairie.enumator.BookStatus;
import com.epsiBibliProjet.librairie.model.Author;
import com.epsiBibliProjet.librairie.model.Book;
import com.epsiBibliProjet.librairie.model.BookItem;
import com.epsiBibliProjet.librairie.model.Library;
import com.epsiBibliProjet.librairie.repository.BookItemRepository;
import com.epsiBibliProjet.librairie.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookItemService {

    private final BookItemRepository bookItemRepository;
    private final LibraryRepository libraryRepository;

    @Autowired
    private final AuthorService authorService;

    public void addBookItem(BookDto bookItem){
        BookItem book = new BookItem();
        Library library = libraryRepository.findLibraryByName(bookItem.getLibrary());
        book.setIsbn(bookItem.getIsbn());
        book.setName(bookItem.getName());
        book.setOverview(bookItem.getOverview());
        book.setPublisher(bookItem.getPublisher());
        book.setPublicationDate(bookItem.getPublicationDate());
        book.setSubject(bookItem.getSubject());
        book.setLang(bookItem.getLang());
        if (bookItem.getAuthorIds().isEmpty()) {
            throw new IllegalArgumentException("you need atleast on author");
        } else {
            // sinon on crée une liste d'auteur et on donne au livre
            List<Author> authors = new ArrayList();
            for (Long authorId : bookItem.getAuthorIds()) {
                Author author = authorService.getAuthor(authorId);
                authors.add(author);
            }
            book.setAuthors(authors);
        }
        book.setBarcode(bookItem.getBarcode());
        book.setNumberOfPages(bookItem.getNumberOfPages());
        book.setIsbn(book.getIsbn());
        book.setTag(bookItem.getTitle());
        book.setFormat(bookItem.getFormat());
        book.setLanguage(bookItem.getLanguage());
        book.setTitle(book.getName());
        book.setSubject(book.getSubject());
        book.setLibrary(library.getName());
        book.setStatus(BookStatus.FREE);

        bookItemRepository.save(book);
    }

    public List<BookItem> getAll(){
        return bookItemRepository.findAll();
    }
}
