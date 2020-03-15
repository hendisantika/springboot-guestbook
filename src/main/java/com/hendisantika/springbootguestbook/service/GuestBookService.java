package com.hendisantika.springbootguestbook.service;

import com.hendisantika.springbootguestbook.domain.GuestBook;
import com.hendisantika.springbootguestbook.repository.GuestBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-guestbook
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 15/03/20
 * Time: 10.46
 */
@Service
public class GuestBookService {
    @Autowired
    private GuestBookRepository guestBookRepository;

    public List<GuestBook> findAllEntries() {
        return this.guestBookRepository.findAll();
    }

    public GuestBook findGuestBookEntryById(Integer id) {
        return this.guestBookRepository.findGuestBookEntryById(id);
    }
}
