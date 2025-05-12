package com.example.labSpringWTTO2.controller;

import com.example.labSpringWTTO2.model.Publisher;
import com.example.labSpringWTTO2.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Publisher getPublisherById(@PathVariable Long id) {
        return publisherRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @PutMapping("/{id}")
    public Publisher updatePublisher(@PathVariable Long id, @RequestBody Publisher publisher) {
        publisher.setId(id);
        return publisherRepository.save(publisher);
    }

    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable Long id) {
        publisherRepository.deleteById(id);
    }
}