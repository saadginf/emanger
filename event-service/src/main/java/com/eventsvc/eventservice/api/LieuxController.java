package com.eventsvc.eventservice.api;

import java.util.List;

import javax.validation.Valid;

import com.eventsvc.eventservice.entities.Lieux;

import com.eventsvc.eventservice.services.LieuxService;
import com.eventsvc.eventservice.services.MapVAlidationErrorService;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/events/lieux")
public class LieuxController {
    @Autowired
    LieuxService liservice;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> addTheme(@Valid @RequestBody Lieux li, BindingResult result) {

        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        Lieux lieux = liservice.addLieux(li);
        return new ResponseEntity<Lieux>(lieux, HttpStatus.OK);

    }

    @GetMapping("")
    public List<Lieux> getAllProjects() {

        return liservice.getAllLieux();

    }

}