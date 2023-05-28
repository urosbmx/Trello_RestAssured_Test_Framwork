package tests.board;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

import static DataProvider.dataProvider.*;
import static io.restassured.RestAssured.given;
import static methodes.DELETE_Request.DELETERequest;
import static methodes.POST_Request.POSTRequest;
import static methodes.PUT_Request.PUTRequest;
import static preconditions.createBoard.*;
public class TC_01_create_board {

    String API_Key = Key;
    String API_Token= Token;
    String ID = newBoards();

    @Test(priority=1)
public void renameBoard(){
        Map<String,String> qvery = new HashMap<>();
        qvery.put("name","New board name");
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        PUTRequest(baseURL,mapAssString,"",bordSufix+ID,true,200,"name","New board name");
    }



    @Test(priority=2)
    public void deleteBoard(){
        Map<String,String> qvery = new HashMap<>();
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        DELETERequest(baseURL,mapAssString,"",bordSufix+ID,true,200,"_value","null");

    }

    @Test
    public void createBoardWithOutName(){
        Map<String,String> qvery = new HashMap<>();
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        POSTRequest(baseURL,"Connection","keep-alive",mapAssString,"",bordSufix,true,400,"message","invalid value for name");
    }
    String newBord=newBoards();
    @Test
    public void closeBord(){

        Map<String,String> qvery = new HashMap<>();
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        qvery.put("closed", String.valueOf(true));
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");

        PUTRequest(baseURL,mapAssString,"",bordSufix+newBord,false,200,"test","test");

    }

    @AfterClass
    public void deleteClosedBoard(){
        Map<String,String> qvery = new HashMap<>();
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        DELETERequest(baseURL,mapAssString,"",bordSufix+newBord,true,200,"_value","null");

    }

    @Test
    public void deleteNoneExistingBoard(){
        String nonExistingBoard = "64739531a86cfcceef46687c";
        Map<String,String> qvery = new HashMap<>();
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        DELETERequest(baseURL,mapAssString,"",bordSufix+nonExistingBoard,true,404,"","The requested resource was not found.");
    }


}
