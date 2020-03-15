package com.hendisantika.springbootguestbook.controller;

import com.hendisantika.springbootguestbook.domain.GuestBook;
import com.hendisantika.springbootguestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @GetMapping("/delete/{id}")
    public String deleteComment(@PathVariable Integer id) {
        this.guestBookService.deleteGuestBookEntryById(id);

        return HOMEPAGE_REDIRECT;
    }

    @PostMapping("/")
    public String addComment(Model model,
                             @Valid @ModelAttribute(NEW_ENTRY_TEMPLATE_ID) GuestBook newEntry,
                             BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            this.guestBookService.save(newEntry);
            return HOMEPAGE_REDIRECT;
        } else {
            model.addAttribute(GUESTBOOK_FORM_HEADER_ID, "Please Correct the Comment");
            model.addAttribute(ENTRIES_TEMPLATE_ID, this.guestBookService.findAllEntries());
            return GUESTBOOK_TEMPLATE;
        }
    }

    @GetMapping("update/{id}")
    public String editComment(Model model, @PathVariable Integer id) {

        model.addAttribute(GUESTBOOK_FORM_HEADER_ID, "Please Change the Comment");
        model.addAttribute(ENTRIES_TEMPLATE_ID, this.guestBookService.findAllEntries());
        model.addAttribute(NEW_ENTRY_TEMPLATE_ID, this.guestBookService.findGuestBookEntryById(id));

        return GUESTBOOK_TEMPLATE;
    }

    @PostMapping("update/{id}")
    public String saveComment(Model model,
                              @PathVariable Integer id,
                              @Valid @ModelAttribute(NEW_ENTRY_TEMPLATE_ID) GuestBook newEntry,
                              BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            GuestBook current = this.guestBookService.findGuestBookEntryById(id);

            current.setUser(newEntry.getUser());
            current.setComment(newEntry.getComment());

            this.guestBookService.save(current);

            return HOMEPAGE_REDIRECT;
        } else {
            model.addAttribute(GUESTBOOK_FORM_HEADER_ID, "Please Correct the Comment");
            model.addAttribute(ENTRIES_TEMPLATE_ID, this.guestBookService.findAllEntries());
            return GUESTBOOK_TEMPLATE;
        }
    }
}
