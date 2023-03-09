package com.example.gridview_image;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ItemData {
    private static Context context;

    public static void init(Context context) {
        ItemData.context = context;
    }

    private static String loadJsonFromAsset(String fileName) throws IOException {
        String jsonString;
        InputStream inputStream = context.getAssets().open(fileName);
        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();
        jsonString = new String(buffer, "UTF-8" );
        return jsonString;
    }

    public static ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<>();

        try {
            String jsonString = loadJsonFromAsset("data.json");
            JSONArray jsonArray = new JSONArray(jsonString);

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String image = jsonObject.getString("image");
                String title = jsonObject.getString("title");
                String description = jsonObject.getString("description");
                items.add(new Item(id, image, title, description));
            }
        }
        catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static Item getItemById(int id) {
        Item item = null;
        try {
            String jsonString = loadJsonFromAsset("data.json");
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int itemId = jsonObject.getInt("id");

                if (itemId == id) {
                    String image = jsonObject.getString("image");
                    String title = jsonObject.getString("title");
                    String description = jsonObject.getString("description");
                    item = new Item(id, image, title, description);
                    break;
                }
            }
        }
        catch (JSONException | IOException e) {
            e.printStackTrace();
            item = new Item(id, "https://www.vngia.vn/wp-content/uploads/2022/08/Thuong-thuc-do-uong-tai-Cheese-Coffee.jpg", "title", "description");
        }
        return item;
    }

}
