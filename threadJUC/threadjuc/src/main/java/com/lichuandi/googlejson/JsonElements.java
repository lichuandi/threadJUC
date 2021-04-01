package com.lichuandi.googlejson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @Auther digege
 * @Date 2021/3/23
 * @Description：com.lichuandi.googlejson version：1
 */
public class JsonElements {
    public static void main(String[] args) {

        JsonObject js = new JsonObject();
        js.addProperty("name", "phone");
        js.addProperty("price", 999);
        js.addProperty("type", "mi");

        System.out.println("js-->" + js);
        String jsStr = js.toString();
        System.out.println("str-->" + jsStr);
        System.out.println("------------------");

        if("mi".equals(js.get("type"))){
            System.out.println("这是xiaomi");
        }else{
            System.out.println("这不是xiaomi");
        }

        if("mi".equals(js.get("type").toString())){
            System.out.println("这是xiaomi");
        }else{
            System.out.println("这不是xiaomi");
        }
        JsonElement type = js.get("type");
        System.out.println("JSONElEMent"+type);
        System.out.println("JSONElEMent"+type.toString());
        String typeStr=js.get("type").isJsonNull()?"":js.get("type").getAsString();
        System.out.println(typeStr);
        System.out.println("___________________");
       /* int prc=((JsonElement)js.get("price")).isJsonNull()? -1:js.get("pricre").getAsInt();
        System.out.println(prc);
        if ((prc==999)) {
            System.out.println("yes");
        }else {
            System.out.println("bu");
        }*/
        }

}
