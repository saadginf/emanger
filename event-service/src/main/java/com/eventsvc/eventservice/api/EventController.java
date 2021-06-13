package com.eventsvc.eventservice.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.eventsvc.eventservice.entities.Event;
import com.eventsvc.eventservice.entities.Theme;
import com.eventsvc.eventservice.exceptions.LibbeleException;
import com.eventsvc.eventservice.services.EventService;
import com.eventsvc.eventservice.services.ThemeService;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("api/events")
public class EventController {

    @Autowired
    EventService eService;
    @Autowired
    ThemeService thService;
    @Value("${file.upload-event}")
    private String path;

    @PostMapping("")
    public ResponseEntity<?> createSurvey(@RequestPart(required = true) Event e,
            @RequestPart(value = "file", required = true) final MultipartFile file) {

        if (!file.getContentType().equals("application/pdf")) {
            throw new LibbeleException("Erreur Fatale");
        }
        e.setFileLink(file.getOriginalFilename());
        Event event = eService.addEvent(e);

        try {
            Files.write(Paths.get(path + "/" + event.getId() + "_" + event.getFileLink()), file.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Event>(event, HttpStatus.OK);

    }

    @GetMapping("")
    public List<Event> getAllProjects() {

        return eService.getAllEvents();

    }

    @GetMapping("th/{thId}")
    public ResponseEntity<?> getEventByTh(@PathVariable Long thId) {

        Theme th = thService.findById(thId);
        if (th == null) {
            throw new LibbeleException("Erreur Fatale");
        }
        List<Event> p = eService.getEventsByTh(th);
        return new ResponseEntity<List<Event>>(p, HttpStatus.OK);
    }

    @GetMapping(path = "/download/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getFile(@PathVariable("id") Long id) throws Exception {

        Event u = eService.getById(id);
        return Files.readAllBytes(Paths.get(path + "/" + u.getId() + "_" + u.getFileLink()));
    }

}