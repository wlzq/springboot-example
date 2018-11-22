package org.allen.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.allen.demo.domain.Book;
import org.allen.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="book", description = "book操作Api", position=1, protocols = "http")
@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value="BOOK列表", notes="全部BOOK列表", response = List.class)
    @GetMapping(value="books")
    public List<Book> books(){
        return bookService.findAll();
    }

    @ApiOperation(value="根据ID获取BOOK对象", notes="根据ID获取BOOK对象", response = Book.class)
    @GetMapping(value="book/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.findById(id);
    }

    @ApiOperation(value="创建BOOK对象", notes="创建BOOK对象", response = String.class)
    @PostMapping(value="book")
    public String save(@RequestBody Book book){
        bookService.save(book);
        return "create success";
    }

    @ApiOperation(value="根据ID删除BOOK对象", notes="根据ID删除BOOK对象")
    @DeleteMapping(value="delete/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }

    @ApiOperation(value="修改BOOK对象", notes="根据ID修改BOOK对象", response = String.class)
    @PutMapping("book")
    public String update(@RequestBody Book book){
        bookService.update(book);
        return "update success";
    }

}
