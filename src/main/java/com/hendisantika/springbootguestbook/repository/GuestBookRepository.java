package com.hendisantika.springbootguestbook.repository;

import com.hendisantika.springbootguestbook.domain.GuestBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-guestbook
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 15/03/20
 * Time: 10.44
 */
public interface GuestBookRepository extends CrudRepository<GuestBook, Integer> {
    @Override
    List<GuestBook> findAll();

    GuestBook findGuestBookEntryById(Integer id);

    List<GuestBook> findGuestBookEntriesByUser(String user);

    @Transactional
    void deleteGuestBookEntryById(Integer id);
}
