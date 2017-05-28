import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by martin on 28.05.17.
 */
public class GsonExample {
    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException, IOException {
//        Map<String, boolean[][]> map = new HashMap<String, boolean[][]>();
//        boolean[][] innerList = {{true, true}};
//        map.put("test", innerList);
//
        Gson gson = new GsonBuilder().create();
//        String json = gson.toJson(map);
//        System.out.println(json);

        Type typeOfHashMap = new TypeToken<Map<String, boolean[][]>>() {
        }.getType();

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

        StringBuilder toBePlayed = new StringBuilder();

        String[] notes = {"A", "B", "C", "D", "E", "F", "G"};
//        boolean[][] notes =
        for (boolean[][] notesAll : newMap.values()) {
            System.out.println("new");
            for (int noteIndexOut = 0; noteIndexOut < notesAll[0].length; noteIndexOut++) {
                for (int noteIndex = 0; noteIndex < notesAll.length; noteIndex++) {
                    boolean print = notesAll[noteIndex][noteIndexOut];
//                    System.out.println(notesAll[noteIndex][noteIndexOut] + " " + noteIndex + " " + noteIndexOut);
                    if (print) {
//                        System.out.println(notes[noteIndex]);
                        toBePlayed.append(notes[noteIndex]);
                    }
                }
//                System.out.println();
                toBePlayed.append(" ");
            }
        }
        System.out.println(toBePlayed);

        PlayerPiano.main(new String[]{"-i", "115", toBePlayed.toString()});
    }

}
