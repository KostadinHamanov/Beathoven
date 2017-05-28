package org.sort.linear.gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser {

	public static Map<String, Boolean[][]> parse() throws IOException {
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader("/home/geshh/Desktop/data.json"));

		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");

		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);

		}
		String finalString = stringBuilder.toString();

		JSONObject obj = new JSONObject(finalString);
		String objName = null;
		Map<String, Boolean[][]> map = new HashMap<>();

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
				map.put(objName, boolMatr);
			}
		}
		return map;
	}

}
