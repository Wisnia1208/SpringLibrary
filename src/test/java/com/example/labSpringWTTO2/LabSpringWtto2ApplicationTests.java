package com.example.labSpringWTTO2;

import com.example.labSpringWTTO2.model.Author;
import com.example.labSpringWTTO2.model.Book;
import com.example.labSpringWTTO2.repository.AuthorRepository;
import com.example.labSpringWTTO2.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthorControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private AuthorRepository authorRepository;

	@Test
	void shouldCreateAuthor() throws Exception {
		mockMvc.perform(post("/authors")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"name\":\"Jakub Wiśniewski\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Jakub Wiśniewski"));
	}

	@Test
	void shouldGetAllAuthors() throws Exception {
		authorRepository.save(new Author("Jan Kowalski"));

		mockMvc.perform(get("/authors")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[?(@.name == 'Jan Kowalski')]").exists());
	}

	@Test
	void shouldUpdateAuthor() throws Exception {
		Author author = authorRepository.save(new Author("Jan Kowalski"));

		mockMvc.perform(put("/authors/" + author.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"name\":\"Jan Nowak\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Jan Nowak"));
	}

	@Test
	void shouldDeleteAuthor() throws Exception {
		Author author = authorRepository.save(new Author("Jan Kowalski"));

		mockMvc.perform(delete("/authors/" + author.getId()))
				.andExpect(status().isOk());
	}
}