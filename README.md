# survey-app

  Web app similar to Survey Monkey created with the purpose of practicing clean code principles in a simple web 
application and to serve as a playground for research and development. 
I'm focused on writing code as close as possible to production quality. I will use it as a template for a future 
microservice architecture.


Backend

Technology used Spring Boot 2, Spring Data JPA, Spring Data REST, Spring Security, Gradle 5

Database setup Create a Postgres database named surveyDb. Create a user called postgres and make sure the password from application.yml matches.

Profiles There is the dev and the test profile.

Testing The H2 in memory database is used to run the integration tests. The tests are using Junit 4, Mockito and RestAssured.

Code analysis The code is analysed using a local SonarQube server. The test coverage is performed by Jacoco.

Running the app The backend server runs at http://localhost:8083

Docs Visualise the API docs in swagger UI by going to http://localhost:8083/survey-app/docs/ui/index.html

CI / CD I will setup a local GitLab server and create a pipeline with the following steps: Compile / Unit Test > Integration Test > Code analysis > Docker build / push

Frontend

To be developed in a future release. I will develop an Angular 7 app in order to research front end best practices and get a full stack experience.
