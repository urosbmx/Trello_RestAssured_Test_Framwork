package tests.board;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import DataProvider.dataSets;

import static DataProvider.dataProvider.*;
import static methodes.POST_Request.POSTRequest;


public class TC_01_create_board extends dataSets {


    @Test(groups = {"CreateBoard","delete_board"})
    public void  CreateNewBoards(){

        Map<String,String> qvery = new HashMap<>();
        qvery.put("name","new_board");
        qvery.put("key",API_Key);
        qvery.put("token",API_Token);
        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
        POSTRequest(baseURL,"Connection","keep-alive",mapAssString,"",bordSufix,true,200,"name","new_board","src/test/resources/json_schemas/board/create_board_schema.json");

    }




}
