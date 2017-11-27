package com.echovue.service;

import com.amazonaws.services.machinelearning.AmazonMachineLearning;
import com.amazonaws.services.machinelearning.AmazonMachineLearningClientBuilder;
import com.amazonaws.services.machinelearning.model.PredictResult;
import com.echovue.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.amazonaws.services.machinelearning.model.GetMLModelRequest;
import com.amazonaws.services.machinelearning.model.GetMLModelResult;
import com.amazonaws.services.machinelearning.model.PredictRequest;

@Service
public class PredictionService {
    private static final String MODEL_ID = "ml-hLR6cepAThT";
    private AmazonMachineLearning client;

    public Optional<Float> getPrediction(final Customer customer) {
        client = AmazonMachineLearningClientBuilder.defaultClient();
        PredictResult result = client.predict(buildPredictionRequest(customer));
        Map<String,Float> resultMap = result.getPrediction().getPredictedScores();
        if (resultMap.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(resultMap.get("0"));
    }

    private Map<String, String> buildCustomerMap(final Customer customer) {
        Map<String, String> customerMap = new ObjectMapper().convertValue(customer, Map.class);
        Map<String, String> customerStringMap = new HashMap<>();
        for (Map.Entry entry : customerMap.entrySet()) {
            customerStringMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return customerStringMap;
    }

    private PredictRequest buildPredictionRequest(final Customer customer) {
        Map<String, String> customerMap = buildCustomerMap(customer);
        return new PredictRequest()
                .withMLModelId(MODEL_ID)
                .withPredictEndpoint(getModelEndpoint())
                .withRecord(customerMap);
    }

    private String getModelEndpoint() {
        GetMLModelRequest request = new GetMLModelRequest().withMLModelId(MODEL_ID);
        GetMLModelResult model = client.getMLModel(request);
        return model.getEndpointInfo().getEndpointUrl();
    }
}
