# Targeted Marketing Prediction Microservice

A Spring based microservice which predicts the success of a targeted marketing campaign for a particular customer based on an AWS Machine Learning Model.

To build the project, download it into a local directory.
 
You will need to create your own ML Model to use in the example.

Use the sample applications provided by AWS Labs at:

https://github.com/awslabs/machine-learning-samples

To run the program, execute the following from the commandline:

`./gradlew clean build bootRun`

An example request which you can **POST** to the _/prediction_ endpoint with Content-Type set to _application/json_ is:

`{"age":30,"job":"professional","marital":"married","education":"basic.9y",
"housing":"yes","loan":"yes","contact":"cellular","month":"dec","dayOfWeek":"mon",
"duration":487,"campaign":2,"previous":0,"emp_var_rate":-1.8,
"cons_price_idx":92.893,"cons_conf_idx":-46.2,"euribor3m":1.313,
"nr_employed":5099.1,"default":"no","pdays":50,"poutcome":"nonexistent"}`


And the response should be similar to:

`Chance of response is 31%`





