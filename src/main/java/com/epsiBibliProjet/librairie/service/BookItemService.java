package com.epsiBibliProjet.librairie.service;

import com.epsiBibliProjet.librairie.dto.BookItemDto;
import com.epsiBibliProjet.librairie.model.Book;
import com.epsiBibliProjet.librairie.model.BookItem;
import com.epsiBibliProjet.librairie.repository.BookItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookItemService {

    private final BookItemRepository bookItemRepository;

    private final BookService bookService;

    public void addBookItem(BookItem bookItem){
        BookItem book = bookItemRepository.findById(bookItem.getBookId()).get();
        book.setBarcode(bookItem.getBarcode());
        book.setNumberOfPages(bookItem.getNumberOfPages());
        book.setRfid(bookItem.getRfid());
        book.setFormats(bookItem.getFormats());
        book.setLanguage(bookItem.getLanguage());

        bookItemRepository.save(book);
    }

    public List<BookItem> getAll(){
        return bookItemRepository.findAll();
    }
}
