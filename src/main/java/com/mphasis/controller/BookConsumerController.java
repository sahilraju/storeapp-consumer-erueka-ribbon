package com.mphasis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mphasis.domain.Book;

@RestController
@RequestMapping("/consumer/book")
public class BookConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) {
		
		System.out.println(id+"//////////////");

		Book book = restTemplate.getForObject("http://book-service/book/" + id, Book.class);

		return book;

	}

}
