package com.ibm.cn.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ibm.cn.entity.Book;

@Mapper
public interface BookMapper {
	public int addBook(Book book);

	public int deleteBookById(int id);

	public int updateBookById(Book book);

	public Book getbookById();

	public List<Book> getAllBooks();

	public List<Book> queryBooksBySql(Map<String, Object> data);
}
