package tests.card;
import DataProvider.dataSets;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static DataProvider.dataProvider.*;
import static methodes.DELETE_Request.DELETERequest;
import static methodes.POST_Request.POSTRequest;


//public class TC_01_create_card extends dataSets {
//
//    String API_Key = Key;
//    String API_Token= Token;
////    String newBord =  newBoards("New_test_board",API_Key,API_Token);
////    String newList = createBoardWithList(newBord);
//
//    @Test(groups = {"Regresion","Smoke","CreateBoard"})
//    public void createNewCard(){
//        Map<String,String> qvery = new HashMap<>();
//        qvery.put("name","New_card");
//        qvery.put("idList",newList);
//        qvery.put("key",API_Key);
//        qvery.put("token",API_Token);
//        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
//        POSTRequest(baseURL,"Accept","application/json", mapAssString,"",cardSufix,false,200,"","","src/test/resources/json_schemas/create_card_schema.json");
//    }
//
//
//
//
//
//    @AfterClass
//    public void deleteClosedBoard(){
//        Map<String,String> qvery = new HashMap<>();
//        qvery.put("key",API_Key);
//        qvery.put("token",API_Token);
//        String mapAssString = StringUtils.join(qvery.entrySet(),"&");
//        DELETERequest(baseURL,mapAssString,"",bordSufix+newBord,true,200,"_value","null","src/test/resources/json_schemas/delete_board_schema.json");
//
//    }
//}
