package methodes;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.urlEncodingEnabled;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class POST_Request {

    public static Response POSTRequest(String URL, String header, String headerValue, String queryParams, String body, String URL_Sufix, Boolean extraStep, int expectStatusCode, String parametarResponse, String expactValue, String jsonSchema_Path){
        urlEncodingEnabled = false;
        Response response =null;
        try {
                response = expect()
                        .given()
                        .baseUri(URL)
                        .header(header,headerValue)
                        .queryParam(queryParams)
                        .body(body)
                        .log()
                        .all()
                        .post(URL_Sufix)
                        .then()
                        .log()
                        .all()
                        .body(JsonSchemaValidator.matchesJsonSchema(new File(jsonSchema_Path)))
                        .extract()
                        .response();

                int responseCode = response.statusCode();
                if(extraStep){

                    if(responseCode == expectStatusCode ){

                        if(!parametarResponse.equals("")){
                            JsonPath jsonPath= response.jsonPath();
                            String parametar = jsonPath.get(parametarResponse);


                            if(parametar.equals(expactValue)){
                                Assert.assertEquals(parametar,expactValue);
                            }
                            else{
                                Assert.fail("Wron response");
                            }
                        }

                    }else{
                        Assert.fail("Wrong status code expected"+ expectStatusCode + " received" + responseCode);
                    }
                }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return response;
    }
}
