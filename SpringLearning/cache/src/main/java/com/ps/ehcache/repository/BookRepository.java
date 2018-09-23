package com.ps.ehcache.repository;

import com.ps.ehcache.model.Book;

public interface BookRepository {
    Book getByIsbn(String isbn);
}
