package org.sort.linear.gui;

import org.json.JSONObject;

public class JSONParser {
	public static void main(String[] args) {
		JSONObject obj = new JSONObject("{\"name\": \"John\"}");
		System.out.println(obj.getString("name")); // John

	}
}
