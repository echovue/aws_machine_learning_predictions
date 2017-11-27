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
    public String getPredication(@RequestBody Customer customer) {
        Optional result = predictionService.getPrediction(customer);
        if (result.isPresent()) {
            return "Chance of response is " + String.format("%.0f", (Float) result.get() * 100) + "%";
        }
        return "Error when calculate probability of response";
    }
}
