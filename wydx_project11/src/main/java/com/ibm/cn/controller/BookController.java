package com.ibm.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.ibm.cn.entity.Book;
import com.ibm.cn.service.BookService;

@Controller
@ResponseBody
public class BookController {
	
    //自动注入
	@Autowired
	BookService bookService;
	
	//新增书籍
	@PostMapping("/addBook")
	public void addBook(@RequestBody Book b) {
		
		bookService.addBook(b);
		System.out.println("成功");
	}
	
	//查询书籍
	@GetMapping("/findAll")
	public List<Book> getAllBooks() {
		PageHelper.startPage(1,2);//第一个参数是第几页，第二个参数是一页有几条
		List<Book> book = bookService.getAllBooks();
		System.out.println(book);
		return book;
	}
	
	//删除书籍
	@GetMapping("/delete/{id}")
	public void deleteBookById(@PathVariable int id) {
		bookService.deleteBookById(id);
		System.out.println("删除成功");
	}
	
	//修改书籍
	@PutMapping("/updata")
	public void updateBookById(@RequestBody Book book) {
		bookService.updateBookById(book);
		System.out.println("更新成功");
	}
}
