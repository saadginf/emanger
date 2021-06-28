package com.eventsvc.eventservice.api;

import com.eventsvc.eventservice.outils.Fields;
import com.eventsvc.eventservice.services.FieldsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/events/fields")
public class FieldsController {
    @Autowired
    FieldsService fiservice;

    @GetMapping("")
    public Fields getFields() {
        return fiservice.getAll();
    }

}