package com.echovue.controller;

import com.echovue.model.Customer;
import com.echovue.service.PredictionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.runtime.options.Options;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;

import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

public class PredictionControllerTest {

    @Mock
    private PredictionService predictionService;

    @InjectMocks
    @Resource
    PredictionController predictionController = new PredictionController(predictionService);

    @Before
    public void setupMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPrediction() throws Exception {
        when(predictionService.getPrediction(anyObject()))
                .thenReturn(Optional.of(new Boolean(true)));
        Optional<Boolean> result = predictionController.getPredication(createCustomer());
        assertEquals(true, result.get());
    }


 /*   @Test
    public void getDistanceRoundUp() throws Exception {
        when(predictionService.getDistance(anyString(), anyString()))
                .thenReturn(Optional.of(new Double("532.94")));
        String result = zipcodeController.getDistance("97035", "94016");
        assertEquals("533 miles", result);
    }


    @Test
    public void getDistanceRoundDown() throws Exception {
        when(predictionService.getDistance(anyString(), anyString()))
                .thenReturn(Optional.of(new Double("533.14")));
        String result = zipcodeController.getDistance("97035", "94016");
        assertEquals("533 miles", result);
    }

    @Test
    public void getDistanceVoid() throws Exception {
        when(predictionService.getDistance(anyString(), anyString()))
                .thenReturn(Optional.empty());
        String result = zipcodeController.getDistance("97035", "94016");
        assertEquals("Unable to calculate distance", result);
    }*/
    private Customer createCustomer() {
        ObjectMapper mapper = new ObjectMapper();
        String customerJson = getCustomerJson();

        Customer customer = null;
        try {
            customer = mapper.readValue(customerJson, Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customer;
    }

    private String getCustomerJson() {
        return "{\"age\":30,\"job\":\"blue-collar\",\"marital\":\"married\",\"education\":\"basic.9y\","
             + "\"housing\":\"yes\",\"loan\":\"no\",\"contact\":\"cellular\",\"month\":\"may\",\"dayOfWeek\":\"fri\","
             + "\"duration\":487,\"campaign\":2,\"previous\":0,\"emp_var_rate\":-1.8,\"cons_price_idx\":92.893,"
             + "\"cons_conf_idx\":-46.2,\"euribor3m\":1.313,\"nr_employed\":5099.1,\"default\":\"no\",\"pdays\":999,"
             + "\"poutcome\":\"nonexistent\"}";
    }

    private Customer buildCustomer() {
        Customer customer = new Customer();

        customer.setAge(30L);
        customer.setJob("blue-collar");
        customer.setMarital("married");
        customer.setEducation("basic.9y");
        customer.setDefault("no");
        customer.setHousing("yes");
        customer.setLoan("no");
        customer.setContact("cellular");
        customer.setMonth("may");
        customer.setDayOfWeek("fri");
        customer.setDuration(487L);
        customer.setCampaign(2L);
        customer.setPDays(999L);
        customer.setPrevious(0);
        customer.setPOutcome("nonexistent");
        customer.setEmpVarRate(new Double(-1.8));
        customer.setConsPriceIdx(92.893);
        customer.setConsConfIdx(-46.2);
        customer.setEuribor3m(1.313);
        customer.setNrEmployed(5099.1);

        return customer;
    }


}