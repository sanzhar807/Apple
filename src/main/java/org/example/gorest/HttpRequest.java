package org.example.gorest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
@Data
public class HttpRequest {

    protected String url;
    protected RequestSpecification requestSpecification;
    protected Response response;

    private static final String Slash = "/";

    public HttpRequest(String url) {
        this.url = url;
        this.requestSpecification = given()
                .baseUri(url)
                .header("Authorization", "Bearer " + ConfigurationManager.getBaseConfig().bearerToken())
                .contentType(ContentType.JSON);
    }

    public Response get(String endPoint) {
        log.info("Performed GET {}", endPoint);
        this.response = given().spec(requestSpecification).get(endPoint);
        logResponse();
        return this.response;
    }

    public Response post(String endPoint, String body){
        log.info("Performed POST {}", endPoint);
        log.info("Body is {}", body);
        this.response = given().spec(requestSpecification).body(body).post(endPoint);
        logResponse();
        return this.response;
    }

    public Response put(String endPoint, String body) {
        this.response = given()
                .spec(requestSpecification)
                .body(body)
                .put(endPoint);
        return this.response;
    }

    public Response patch(String endPoint, String body) {
        this.response = given()
                .spec(requestSpecification)
                .body(body)
                .patch(endPoint);
        return this.response;
    }

    public Response delete(String endPoint) {
        this.response = given()
                .spec(requestSpecification)
                .delete(endPoint);
        return this.response;
    }

    private void logResponse() {
        log.warn("Response is: ");
        log.warn(getResponse().getBody().asPrettyString());
        log.warn("Status code is: {}", getResponse().getStatusCode());
    }

    public String getEndPoint(String... endpoints) {
        StringBuilder endpoint = new StringBuilder();
        for (String arg : endpoints) {
            endpoint.append(arg).append(Slash);
        }
        return endpoint.substring(0, endpoint.length() - 1);
    }
}