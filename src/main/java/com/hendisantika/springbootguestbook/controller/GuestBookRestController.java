package com.hendisantika.springbootguestbook.controller;

import com.hendisantika.springbootguestbook.domain.GuestBook;
import com.hendisantika.springbootguestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
