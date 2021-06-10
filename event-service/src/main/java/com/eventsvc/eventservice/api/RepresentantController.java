package com.eventsvc.eventservice.api;

import java.util.List;

import javax.validation.Valid;

import com.eventsvc.eventservice.entities.Representant;
import com.eventsvc.eventservice.services.MapVAlidationErrorService;
import com.eventsvc.eventservice.services.RepresentantService;

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
@RequestMapping("api/events/representants")
public class RepresentantController {
    @Autowired
    RepresentantService repService;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> addTheme(@Valid @RequestBody Representant rep,BindingResult result){
          
        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Representant representant = repService.addRepres(rep);
        return new ResponseEntity<Representant>(representant,HttpStatus.OK);

    }
    @GetMapping("")
    public List<Representant> getAllProjects() {
        return  repService.getAllRepresentants();
    } 

}