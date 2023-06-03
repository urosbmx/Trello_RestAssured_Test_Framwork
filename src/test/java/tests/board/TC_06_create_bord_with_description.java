package tests.board;

import DataProvider.dataSets;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static DataProvider.dataProvider.*;
import static DataProvider.dataProvider.bordSufix;
import static methodes.POST_Request.POSTRequest;

public class TC_06_create_bord_with_description extends dataSets {


    @Test(groups = "CreateBoard")
    public void createBoardWithDescription(){
        Map<String,String> qvery = new HashMap<>();
        qvery.put("name","New-board_name");
        qvery.put("desc","this-is-a-new-board");
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        POSTRequest(baseURL,"Connection","keep-alive",mapAssString,"",bordSufix,true,200,"desc","this-is-a-new-board","src/test/resources/json_schemas/board/create_board_with_description_schema.json");
    }
}
