package tests.board;

import DataProvider.dataSets;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static DataProvider.dataProvider.*;
import static methodes.PUT_Request.PUTRequest;

public class TC_07_close_board extends dataSets {


    @Test(groups = {"CreateBoard","delete_board"})
    public void closeBord(){
        Map<String,String> qvery = new HashMap<>();
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        qvery.put("closed", String.valueOf(true));
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");

        PUTRequest(baseURL,mapAssString,"",bordSufix+boardID,true,200,"closed","true","src/test/resources/json_schemas/close_board_schema.json");

    }


}
