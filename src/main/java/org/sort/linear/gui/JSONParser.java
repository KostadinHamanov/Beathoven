package org.sort.linear.gui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.MidiUnavailableException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.json.JSONArray;
import org.json.JSONObject;
import org.sort.linear.sound.SoundParser;


@Path("/data")
public class JSONParser {
	
	@POST
	public void getPost(String json){
		try {
			Map<Integer, Boolean[][]> map = parse(json);
			SoundParser.parse(map);
		} catch (MidiUnavailableException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Map<Integer, Boolean[][]> parse(String json) throws IOException {
		
		Map<String,Integer> instrumentColor = new HashMap<>();
		instrumentColor.put("black", 32);
		instrumentColor.put("red", 55);
		instrumentColor.put("orange", 107);
		instrumentColor.put("yellow", 113);
		instrumentColor.put("blue", 118);
		instrumentColor.put("green", 127);
		JSONObject obj = new JSONObject(json);
		String objName = null;
		Map<Integer, Boolean[][]> map = new HashMap<>();

		Boolean[][] boolMatr = new Boolean[6][15];

		for (int i = 0; i < obj.names().length(); i++) {
			objName = obj.names().getString(i);

			JSONArray ja = (JSONArray) obj.get(objName);
			for (int j = 0; j < ja.length(); j++) {
				JSONArray ja2 = (JSONArray) ja.get(j);
				
				for (int k = 0; k < ja2.length(); k++) {
					System.out.println(ja2.get(k));
					boolMatr[j][k] = (Boolean) ja2.get(k);
				}
				map.put(instrumentColor.get(objName), boolMatr);
			}
		}
		return map;
	}

}
