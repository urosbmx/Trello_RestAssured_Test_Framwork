package tests.board;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static DataProvider.dataProvider.*;
import static DataProvider.dataProvider.Token;
import static methodes.DELETE_Request.DELETERequest;

public class TC_03_delete_non_existing_board {

    String API_Key = Key;
    String API_Token= Token;
    @Test
    public void deleteNoneExistingBoard(){
        String nonExistingBoard = "64739531a86cfcceef46687c";
        Map<String,String> qvery = new HashMap<>();
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        DELETERequest(baseURL,mapAssString,"",bordSufix+nonExistingBoard,true,404,"","The requested resource was not found.","");
    }
}
