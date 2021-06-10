package com.eventsvc.eventservice.api;

import java.util.List;

import javax.validation.Valid;

import com.eventsvc.eventservice.entities.Theme;
import com.eventsvc.eventservice.services.MapVAlidationErrorService;
import com.eventsvc.eventservice.services.ThemeService;

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
@RequestMapping("api/events/themes")
public class ThemeController {
    @Autowired
    ThemeService thService;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> addTheme(@Valid @RequestBody Theme thm,BindingResult result){
          
        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Theme theme = thService.addTheme(thm);
        return new ResponseEntity<Theme>(theme,HttpStatus.OK);

    }
    @GetMapping("")
    public List<Theme> getAllProjects() {

        return thService.getAllThemes();

    } 

}