package com.hendisantika.springbootguestbook.controller;

import com.hendisantika.springbootguestbook.domain.GuestBook;
import com.hendisantika.springbootguestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-guestbook
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 16/03/20
 * Time: 06.50
 */
@Controller
public class GuestBookWebController {

    private static final String ENTRIES_TEMPLATE_ID = "entries";
    private static final String NEW_ENTRY_TEMPLATE_ID = "newEntry";
    private static final String GUESTBOOK_FORM_HEADER_ID = "formHeader";
    private static final String GUESTBOOK_TEMPLATE = "guestbook";
    private static final String HOMEPAGE_REDIRECT = "redirect:/";

    @Autowired
    private GuestBookService guestBookService;

    @GetMapping("/")
    public String displayGuestBook(Model model) {

        model.addAttribute(GUESTBOOK_FORM_HEADER_ID, "Add a New Comment");
        model.addAttribute(ENTRIES_TEMPLATE_ID, this.guestBookService.findAllEntries());
        model.addAttribute(NEW_ENTRY_TEMPLATE_ID, new GuestBook());

        return GUESTBOOK_TEMPLATE;
    }
}
