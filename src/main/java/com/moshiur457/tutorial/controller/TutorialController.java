package com.moshiur457.tutorial.controller;

import com.moshiur457.tutorial.TutorialApplication;
import com.moshiur457.tutorial.model.Tutorial;
import com.moshiur457.tutorial.repository.TutorialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TutorialApplication.class) ;
    @Autowired
    TutorialRepository tutorialRepository ;

    @GetMapping("/")
    public ResponseEntity<List<Tutorial>> getAllTutorials(){
        try{
            List<Tutorial> tutorials = new ArrayList<>();
                tutorialRepository.findAll().forEach(tutorials::add);

            if(tutorials.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else{
                LOGGER.info("============================");
                LOGGER.info("tutorial found....");
                tutorials.forEach(System.out::println);
                LOGGER.info("============================");
            }
            return new ResponseEntity<>(tutorials,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id")int id){
        Optional<Tutorial> tutorial = tutorialRepository.findById(id);

        if(tutorial.isPresent())
            return new ResponseEntity<>(tutorial.get(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
        try{
            Tutorial tutorial1 = tutorialRepository.save(new Tutorial(tutorial.getTitle(),
                    tutorial.getAuthor(),tutorial.getBody())) ;
            return new ResponseEntity<>(tutorial1,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id")int id,@RequestBody Tutorial tutorial){
        Optional<Tutorial> retrievedTutorial = tutorialRepository.findById(id);

        if(retrievedTutorial.isPresent()){
            Tutorial tutorialToBeSaved = retrievedTutorial.get() ;
            tutorialToBeSaved.setAuthor(tutorial.getAuthor());
            tutorialToBeSaved.setTitle(tutorial.getTitle());
            tutorialToBeSaved.setBody(tutorial.getBody());

            return new ResponseEntity<>(tutorialToBeSaved,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tutorial> deleteTutorialById(@PathVariable("id") int id){
        try
        {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
