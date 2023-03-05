package com.library.book.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.book.entity.Book;
import com.library.book.services.BookServices;

@RestController
public class BookController {

	@Autowired
	BookServices service;

	@GetMapping("/alldata")
	public List<Book> getAllBook() {
		return service.getAllBook();
	}

	@PostMapping("/insert")
	public String insertBook(@RequestBody List<Book> b) {
		return service.insertBook(b);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		return service.deleteBook(id);
	}

	@PutMapping("/update")

	public String updateBook(@RequestBody Book b) {
		return service.updateBook(b);
	}

	@PostMapping("/searchbyid/{id}")

	public Book searchById(@PathVariable int id) {
		return service.searchById(id);
	}

	@GetMapping("/lt")
	public List<Book> lessThan(@RequestBody double price) {
		return service.lessThan(price);
	}

	@PostMapping("/le/{price}")

	public List<Book> lessThanEqual(@PathVariable double price) {
		return service.lessThanEqual(price);
	}

	@PostMapping("/gt")
	public List<Book> greaterThan(@RequestBody double price) {
		return service.greaterThan(price);
	}

	@GetMapping("/ge/{price}")

	public List<Book> greaterThanEqual(@PathVariable double price) {
		return service.greaterThanEqual(price);
	}

	@GetMapping("/between/{first}/{last}")

	public List<Book> betweenPrice(@PathVariable double first, double last) {
		return service.betweenPrice(first, last);
	}

	@GetMapping("/notequal/{id}")

	public List<Book> notEqual(@PathVariable int id) {
		return service.notEqual(id);
	}

	@GetMapping("/startwithauthor/{name}")

	public List<Book> startWithAuthor(@PathVariable String name) {
		return service.startWithAuthor(name);
	}

	@GetMapping("startwithbook/{name}")
	public List<Book> startWithBook(@PathVariable String name) {
		return service.startWithBook(name);
	}

	@GetMapping("/searchbyname/{name}")

	public List<Book> searchByName(@PathVariable String name) {
		return service.searchByName(name);
	}
}
