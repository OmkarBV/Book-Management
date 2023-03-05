package com.library.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.book.dao.BookDao;
import com.library.book.entity.Book;

@Service
public class BookServices {

	@Autowired
	BookDao dao;

	public List<Book> getAllBook() {
		return dao.getAllBook();
	}

	public String insertBook(List<Book> b) {
		return dao.insertBook(b);
	}

	public String deleteBook(int id) {
		return dao.deleteBook(id);
	}

	public String updateBook(Book b) {
		return dao.updateBook(b);
	}

	public Book searchById(int id) {
		return dao.searchById(id);
	}

	public List<Book> lessThan(double price) {
		return dao.lessThan(price);
	}

	public List<Book> lessThanEqual(double price) {
		return dao.lessThanEqual(price);
	}

	public List<Book> greaterThan(double price) {
		return dao.greaterThan(price);
	}

	public List<Book> greaterThanEqual(double price) {
		return dao.greaterThanEqual(price);
	}

	public List<Book> betweenPrice(double first, double last) {
		return dao.betweenPrice(first, last);
	}

	public List<Book> notEqual(int id) {
		return dao.notEqual(id);
	}

	public List<Book> startWithAuthor(String name) {
		return dao.startWithAuthor(name);
	}

	public List<Book> startWithBook(String name) {
		return dao.startWithBook(name);
	}

	public List<Book> searchByName(String name) {
		return dao.searchByName(name);
	}

}
