package tests.board;

import DataProvider.dataSets;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import static DataProvider.dataProvider.*;
import static methodes.PUT_Request.PUTRequest;

public class TC_05_update_description extends dataSets {

    @Test(groups = {"CreateBoard","delete_board"})
    public void updateBoard_description(){
        String boradid = boardID;
        Map<String,String> qvery = new HashMap<>();
        qvery.put("desc","this-is-a-new-board");
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        PUTRequest(baseURL,mapAssString,"",bordSufix+boradid,true,200,"desc","this-is-a-new-board","src/test/resources/json_schemas/board/update_description_board_schema.json");
    }
}
