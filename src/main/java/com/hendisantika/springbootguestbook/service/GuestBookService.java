package com.hendisantika.springbootguestbook.service;

import com.hendisantika.springbootguestbook.repository.GuestBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
