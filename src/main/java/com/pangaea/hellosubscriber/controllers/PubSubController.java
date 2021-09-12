package com.pangaea.hellosubscriber.controllers;

import com.pangaea.hellosubscriber.service.ConsumerMessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class PubSubController {

    private static final Logger logger = LogManager.getLogger(PubSubController.class);
    private final ConsumerMessageService helloMessageService;

    @Autowired
    public PubSubController(ConsumerMessageService helloMessageService) {
        this.helloMessageService = helloMessageService;
    }

    @RequestMapping(value = ("/{test}"), method = RequestMethod.POST)
    public ResponseEntity<Object> postSubscriberTest(@PathVariable String test, @RequestBody Map<String, Object> body){
        logger.info("Received data from publisher server ".concat(test));
        helloMessageService.processMessage(body);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @RequestMapping(value = "*")
    public ResponseEntity<String> any(){
        logger.info("You don't belong here");
        return new ResponseEntity<>("Welcome to Hello World Subscriber. How you got here remains a mystery", HttpStatus.OK);
    }
}
