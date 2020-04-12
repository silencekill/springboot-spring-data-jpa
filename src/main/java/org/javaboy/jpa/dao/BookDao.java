package org.javaboy.jpa.dao;

import org.javaboy.jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Integer> {


}
