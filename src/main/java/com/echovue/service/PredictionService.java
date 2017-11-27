package com.echovue.service;

import com.amazonaws.services.machinelearning.model.PredictResult;
import com.echovue.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.amazonaws.services.machinelearning.AmazonMachineLearningClient;
import com.amazonaws.services.machinelearning.model.GetMLModelRequest;
import com.amazonaws.services.machinelearning.model.GetMLModelResult;
import com.amazonaws.services.machinelearning.model.PredictRequest;

@Service
public class PredictionService {
    private static final Logger LOGGER = Logger.getLogger("PredictionService");
    private static final String MODEL_ID = "ml-hLR6cepAThT";
    private AmazonMachineLearningClient client;
    private String modelEndpoint;

    public Optional<Boolean> getPrediction(final Customer customer) {
        AmazonMachineLearningClient client = new AmazonMachineLearningClient();
        Map<String, String> customerMap = new ObjectMapper().convertValue(customer, Map.class);

        setModelEndpoint();
        PredictRequest request = new PredictRequest()
                .withMLModelId(MODEL_ID)
                .withPredictEndpoint(modelEndpoint)
                .withRecord(customerMap);
        PredictResult result = client.predict(request);
        LOGGER.log(Level.ALL, "*** PREDICTED VALUE: " + result.getPrediction().getPredictedLabel());
        return Optional.of(result.getPrediction().getPredictedValue() > 0);

/*        try {
            zipcodeapi = new URL("https://www.zipcodeapi.com/rest/");

        RestTemplate restTemplate = new RestTemplate();
        return Optional.of(restTemplate.getForObject(
                zipcodeapi.toString() + apiKey + "/distance.json/"
                + zipCode1 + "/" + zipCode2 + "/mile", Distance.class).getDistance());

        } catch (MalformedURLException urlException) {
            LOGGER.log(Level.SEVERE, "Invalid URL for ZipCodeApi");
        } catch (org.springframework.web.client.HttpClientErrorException ex) {
            LOGGER.log(Level.SEVERE, "Bad request");
        }*/
    }

    /**
     * finds the realtime endpoint for this ML Model
     */
    private void setModelEndpoint() {
        GetMLModelRequest request = new GetMLModelRequest().withMLModelId(MODEL_ID);
        GetMLModelResult model = client.getMLModel(request);
        modelEndpoint = model.getEndpointInfo().getEndpointUrl();
    }
}
