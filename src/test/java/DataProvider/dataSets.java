package DataProvider;

import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import java.util.HashMap;
import java.util.Map;
import static DataProvider.dataProvider.*;
import static DataProvider.dataProvider.bordSufix;

import static methodes.DELETE_Request.DELETERequest;
import static methodes.POST_Request.POSTRequest;

public class dataSets {
    public static String API_Key = Key;

    public String boardID  ;
    public  static String API_Token= Token;

    @BeforeGroups(
            groups = {"CreateBoard"},
            alwaysRun = true,
            description = "Creating new board"
    )
    public void  newBoards(){

        Map<String,String> qvery = new HashMap<>();
        qvery.put("name","new_board");
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        Response response = POSTRequest(baseURL,"Connection","keep-alive",mapAssString,"",bordSufix,true,200,"name","new_board","src/test/resources/json_schemas/board/create_board_schema.json");

       boardID = response.jsonPath().get("id");
       System.out.println(boardID);

    }


    @BeforeGroups(
            groups = {"CreateBoardWithList"},
            alwaysRun = true,
            description = "Creating new board with list"
    )
    public void newBoardWithList(){

        Map<String,String> qvery = new HashMap<>();
        qvery.put("name","new_board_withList");
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");

        Response response = POSTRequest(baseURL,"Connection","keep-alive",mapAssString,"",bordSufix+boardID+"/lists",false,200,"","","");

    }

    @AfterGroups(
            groups = {"CreateBoard","CreateBoardWithList"},
            alwaysRun = true,
            description = "Creating new board with list"
    )
    public void deleteClosedBoard(){
        Map<String,String> qvery = new HashMap<>();
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        DELETERequest(baseURL,mapAssString,"",bordSufix+boardID,true,200,"_value","null","src/test/resources/json_schemas/delete_board_schema.json");

    }



}
