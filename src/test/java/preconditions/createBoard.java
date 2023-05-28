package preconditions;

import static DataProvider.dataProvider.*;
import static DataProvider.dataProvider.Token;
import static io.restassured.RestAssured.given;

public class createBoard {
    static String API_Key = Key;
   static String API_Token= Token;


    public static String newBoards(){
        String Response =  given()
                .baseUri(baseURL)
                .log()
                .all()
                .queryParam("name","UrosTest")
                .queryParam("key", API_Key)
                .queryParam("token",API_Token)
                .body("")
                .post(bordSufix)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
        return Response;
    }
}
