package com.echovue.controller;

import com.echovue.model.Customer;
import com.echovue.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PredictionController {

    private PredictionService predictionService;

    @Autowired
    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @RequestMapping(value = "/prediction", method = POST)
    public Optional<Boolean> getPredication(@RequestBody Customer customer) {
        return predictionService.getPrediction(customer);
    }
}
