package org.allen.demo.service;

import org.allen.demo.domain.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * bookService,使用ConcurrentHashMap模拟数据库操作
 */
@Service
public class BookService {

    private static AtomicLong idCreater = new AtomicLong();
    private final ConcurrentMap<Long, Book> books = new ConcurrentHashMap<>();

    public List<Book> findAll(){
        List<Book> books = new ArrayList<>();
        books.addAll(this.books.values());
        return books;
    }

    public Book findById(Long id){
        Book book = this.books.get(id);
        return book;
    }

    public void save(Book book){
        Long id = book.getId();
        if(id == null){
            id = idCreater.incrementAndGet();
            book.setId(id);
        }
        books.put(id, book);
    }

    public void delete(Long id){
        this.books.remove(id);
    }

    public void update(Book book){
        Long id = book.getId();
        this.books.put(id, book);
    }

}
