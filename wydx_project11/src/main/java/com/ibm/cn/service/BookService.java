package com.ibm.cn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.cn.entity.Book;
import com.ibm.cn.mapper.BookMapper;

@Service
public class BookService {
	@Autowired
	BookMapper bookMapper;

	public int addBook(Book book) {
		return bookMapper.addBook(book);
	}

	public int deleteBookById(int id) {
		return bookMapper.deleteBookById(id);
	}

	public int updateBookById(Book book) {
		return bookMapper.updateBookById(book);
	}

	public Book getbookById() {
		return bookMapper.getbookById();
	}

	public List<Book> getAllBooks() {
		return bookMapper.getAllBooks();
	}

	public List<Book> queryBooksBySql(int currPage, int pageSize) {
		Map<String, Object> data = new HashMap();
		data.put("currIndex", (currPage - 1) * pageSize);
		data.put("pageSize", pageSize);
		return bookMapper.queryBooksBySql(data);
	}
}
