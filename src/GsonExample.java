import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by martin on 28.05.17.
 */
public class GsonExample {
    public static void main(String[] args) {
        Map<String, boolean[][]> map = new HashMap<String, boolean[][]>();
        boolean[][] innerList = {{true, true}};
        map.put("test", innerList);

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(map);
        System.out.println(json);


        Type typeOfHashMap = new TypeToken<Map<String, boolean[][]>>() { }.getType();

        String json2 = "{\"black\":[\n" +
                "[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false],\n" +
                "[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false],\n" +
                "[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false],\n" +
                "[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false],\n" +
                "[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false],\n" +
                "[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false]\n" +
                "],\n" +
                "\"yellow\":[\n" +
                "[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false],\n" +
                "[false,true,true,true,true,true,true,true,true,false,false,false,false,false,false],\n" +
                "[true,true,true,true,true,true,true,true,true,false,false,false,false,false,false],\n" +
                "[true,true,true,true,true,true,true,true,false,false,false,false,false,false,false],\n" +
                "[false,false,false,false,false,false,true,false,false,false,false,false,false,false,false],\n" +
                "[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false]\n" +
                "],\n" +
                "\"blue\":[\n" +
                "[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false],\n" +
                "[false,false,false,false,false,false,false,true,true,false,false,false,true,false,false],\n" +
                "[false,false,false,false,false,false,true,true,true,true,true,true,true,false,false],\n" +
                "[false,false,false,false,false,false,true,true,true,true,true,true,true,false,false],\n" +
                "[false,false,false,false,false,false,true,true,false,false,false,false,false,false,false],\n" +
                "[false,false,false,false,false,false,false,false,false,false,false,false,false,false,false]\n" +
                "]}";
        Map<String, boolean[][]> newMap = gson.fromJson(json2, typeOfHashMap); // This type must match TypeToken
        System.out.println(newMap);
    }

}
