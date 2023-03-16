package com.library.book.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.book.entity.Book;

@Repository
public class BookDao {
	@Autowired
	SessionFactory sf;

	public List<Book> getAllBook() {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Book.class);
		return cri.list();
	}

	public String insertBook(List<Book> b) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		for (Book bk : b) {
			session.save(bk);
		}
		tr.commit();
		return "Data Inserted Succesffully";
	}

	public String deleteBook(int id) {
		System.out.println("In dao = " + id);
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Book bb = session.load(Book.class, id);
		session.delete(bb);
		tr.commit();
		return "Data Deleted Succesffuly";
	}

	public String updateBook(Book b) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(b);
		tr.commit();

		return "Data updated Successfully";
	}

	public Book searchById(int id) {
		Session session = sf.openSession();
		return session.get(Book.class, id);

	}

	public List<Book> lessThan(double price) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Book.class);
		cri.add(Restrictions.lt("price", price));
		return cri.list();

	}

	public List<Book> lessThanEqual(double price) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Book.class);
		cri.add(Restrictions.le("price", price));
		return cri.list();

	}

	public List<Book> greaterThan(double price) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Book.class);
		cri.add(Restrictions.gt("price", price));
		return cri.list();
	}

	public List<Book> greaterThanEqual(double price) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Book.class);
		cri.add(Restrictions.gt("price", price));

		return cri.list();
	}

	public List<Book> betweenPrice(double first, double last) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Book.class);
		cri.add(Restrictions.between("price", first, last));

		return cri.list();
	}

	public List<Book> notEqual(int id) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Book.class);
		cri.add(Restrictions.ne("id", id));

		return cri.list();
	}

	public List<Book> startWithAuthor(String name) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Book.class);
		cri.add(Restrictions.like("author", name + "%"));

		return cri.list();
	}

	public List<Book> startWithBook(String name) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Book.class);
		cri.add(Restrictions.ilike("name", name + "%"));
		return cri.list();
	}

	public List<Book> searchByName(String name) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Book.class);
		cri.add(Restrictions.eq("name", name));
		return cri.list();
	}

}
