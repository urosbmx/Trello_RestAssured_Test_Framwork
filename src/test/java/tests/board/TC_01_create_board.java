package tests.board.Create_Board;

import DataProvider.propertyReader;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static DataProvider.dataProvider.Key;
import static DataProvider.dataProvider.Token;

import static io.restassured.RestAssured.given;

public class TC_01_create_board {

    String API_Key = Key;
    String API_Token= Token;
    public String createBoard(){
        RestAssured.baseURI="https://api.trello.com/1/boards/";
        String Response =  given()
                .log()
                .all()
                .queryParam("name","UrosTest")
                .queryParam("key", API_Key)
                .queryParam("token",API_Token)
                .body("")
                .post()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
        return Response;
    }
    String ID=createBoard();
    @Test(priority=1)
public void renameBoard(){
        RestAssured.baseURI="https://api.trello.com/1/boards/";
        given()
                .log()
                .all()
                .queryParam("name","Zikica_Test_board")
                .queryParam("key", API_Key)
                .queryParam("token",API_Token)
                .body("")
                .put(ID)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);
    }


    @Test(priority=2)
    public void deleteBoard(){
        RestAssured.baseURI="https://api.trello.com/1/boards/";
        given()
                .queryParam("key", API_Key)
                .queryParam("token",API_Token)
                .body("")
                .log()
                .all()
                .delete(ID)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

}
