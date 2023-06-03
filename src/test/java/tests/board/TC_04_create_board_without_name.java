package tests.board;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static DataProvider.dataProvider.*;
import static DataProvider.dataProvider.Token;
import static methodes.POST_Request.POSTRequest;

public class TC_04_create_board_without_name {
    String API_Key = Key;
    String API_Token= Token;

    @Test
    public void createBoardWithOutName(){
        Map<String,String> qvery = new HashMap<>();
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        POSTRequest(baseURL,"Connection","keep-alive",mapAssString,"",bordSufix,true,400,"message","invalid value for name","src/test/resources/json_schemas/common/error_without_name.json");
    }
}
