package com.example.pwmanager.controllers;

import com.example.pwmanager.models.EntryItem;
import com.example.pwmanager.services.EntryItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EntryFormController {
    @Autowired
    private EntryItemService entryItemService;

    @GetMapping("/create-entry")
    public String showCreateForm(EntryItem entryItem) {
        return "new-entry-item";
    }

    @PostMapping("/entry")
    public String createEntryItem (@Valid EntryItem entryItem, BindingResult result, Model model){
        EntryItem item = new EntryItem();
        item.setUrl(entryItem.getUrl());

        entryItemService.save(entryItem);
        return "redirect:/";
    }
}
