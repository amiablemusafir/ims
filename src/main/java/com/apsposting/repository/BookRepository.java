package com.apsposting.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apsposting.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
