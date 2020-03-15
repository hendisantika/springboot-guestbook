package com.hendisantika.springbootguestbook.controller;

import com.hendisantika.springbootguestbook.domain.GuestBook;
import com.hendisantika.springbootguestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-guestbook
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/03/20
 * Time: 06.47
 */
@RequestMapping("/api")
@RestController
public class GuestBookRestController {

    @Autowired
    private GuestBookService guestBookService;

    @GetMapping("/comments")
    public List<GuestBook> testMapping() {
        return guestBookService.findAllEntries();
    }

    @GetMapping("/comment/{id}")
    public GuestBook findGuestBookEntryById(@PathVariable("id") Integer id) {
        return this.guestBookService.findGuestBookEntryById(id);
    }

    @GetMapping("/user/{user}")
    public List<GuestBook> findGuestBookEntriesByUser(@PathVariable("user") String user) {
        return this.guestBookService.findGuestBookEntriesByUser(user);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteGuestBookEntryById(@PathVariable("id") Integer id) {
        this.guestBookService.deleteGuestBookEntryById(id);
    }

    @PostMapping("/add")
    public void addComment(@RequestBody GuestBook guestBookEntry) {
        this.guestBookService.save(guestBookEntry);
    }

    @PostMapping("/update")
    public void updateComment(@RequestBody GuestBook guestBookEntry) {
        this.guestBookService.save(guestBookEntry);
    }
}
