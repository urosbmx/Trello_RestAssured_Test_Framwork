package preconditions;

import io.restassured.response.Response;

import static DataProvider.dataProvider.*;
import static DataProvider.dataProvider.Token;
import static io.restassured.RestAssured.given;
import static DataProvider.dataProvider.*;
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

    public static String createBoardWithList(String id_bord){
        String List =  given()
                .baseUri(baseURL)
                .log()
                .all()
                .queryParam("name","UrosList")
                .queryParam("key", API_Key)
                .queryParam("token",API_Token)
                .body("")
                .post(bordSufix+id_bord+"/lists")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");


        return List;
    }
    }
