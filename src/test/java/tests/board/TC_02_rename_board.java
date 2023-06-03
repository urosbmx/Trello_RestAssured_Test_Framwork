package tests.board;

import DataProvider.dataSets;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static DataProvider.dataProvider.*;
import static DataProvider.dataProvider.bordSufix;
import static methodes.PUT_Request.PUTRequest;

public class TC_02_rename_board extends dataSets {

    String API_Key = Key;
    String API_Token= Token;

    @Test(priority=1,
            groups = "CreateBoard")
    public void renameBoard(){
        String boradid = boardID;
        Map<String,String> qvery = new HashMap<>();
        qvery.put("name","New-board_name");
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        PUTRequest(baseURL,mapAssString,"",bordSufix+boradid,true,200,"name","New-board_name","src/test/resources/json_schemas/board/rename_board_schema.json");
    }

}
