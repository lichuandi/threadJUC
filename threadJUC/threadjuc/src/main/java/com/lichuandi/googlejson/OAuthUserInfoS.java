package com.lichuandi.googlejson;

import com.google.gson.*;
import java.io.IOException;

/**
 * @Auther digege
 * @Date 2021/3/23
 * @Description：com.lichuandi.googlejson version：
 */
public class OAuthUserInfoS {
    private boolean fixLegacyUserId;
    public OAuthUserInfo getUserInfo() throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("account", "");
        jsonObject.addProperty("activation_mode", "3");
        jsonObject.addProperty("authWay", "8");
        jsonObject.addProperty("credentialType", "CimsCredential");
        jsonObject.addProperty("email", "huangkai1@hopebank.com");
        jsonObject.addProperty("permissions", "");
        jsonObject.addProperty("phone", "15632154987");
        jsonObject.addProperty("realname", "??1");
        jsonObject.addProperty("employeenum", "huangkai1");
        jsonObject.addProperty("roles", "");
        jsonObject.addProperty("userid", "c1b97c854e954e54b2b6eb7a723c9188");
        jsonObject.addProperty("id", "huangkai1");
        JsonElement userid = jsonObject.get("userid");
        JsonObject otherInfos = new JsonObject();
        otherInfos.addProperty("userid", "c1b97c854e954e54b2b6eb7a723c9188");
        otherInfos.addProperty("createTime", "2021-02-24");
        otherInfos.addProperty("updateTime", "2021-03-12");
        otherInfos.addProperty("email", "huangkai1@hopebank.com");
        otherInfos.addProperty("employeeStatus", "1");
        otherInfos.addProperty("employeenum", "huangkai1");
        otherInfos.addProperty("phone", "15632154987");
        otherInfos.addProperty("realname", "??1");
        otherInfos.addProperty("spid", "1000002");
        otherInfos.addProperty("appCount", "0");
        otherInfos.addProperty("dataSignCount", "0");
        JsonObject attrs = new JsonObject();
        attrs.addProperty("job_num", "0133");
        attrs.addProperty("leadership", "");
        attrs.addProperty("sex", "male");
        attrs.addProperty("userkind", "formal");
        attrs.addProperty("company", "");
        attrs.addProperty("cn", "");
        attrs.addProperty("department", "");
        attrs.addProperty("desc", "");
        jsonObject.addProperty("otherInfos", String.valueOf(attrs));
        jsonObject.addProperty("attrs", String.valueOf(otherInfos));
        System.out.println(jsonObject);
        JsonElement id = jsonObject.get("userid");
        if (id == null || id.isJsonNull()) {
              throw new IOException(String.format("CAS response missing id: %s", "报错"));
        }
        // JsonElement attrListJson = jsonObject.get("attributes");
        JsonElement attrListJson = jsonObject.get("otherInfos");
        System.out.println(attrListJson);
        if (attrListJson == null)
            throw new IOException(String.format("CAS response missing otherInfos: %s", new Object[]{
                    jsonObject
            }));

        String email = null;
        String name = null;
        String login = null;
        //字符串类型otherInfos信息
        /*if(attrListJson.isJsonPrimitive())
        {
           // JsonArray attrJson = attrListJson.getAsJsonArray();
            //转换为对象 一人一邮箱，名称，登录号  没有循环
            //格式 otherInfos{login: ,email: ,name: , ....}
            JsonPrimitive asJsonPrimitive = attrListJson.getAsJsonPrimitive();
            JsonObject returnData = new JsonParser().parse(asJsonPrimitive.getAsString()).getAsJsonObject();
            if(returnData == null || !returnData.isJsonObject()){
                throw new IOException(String.format("Invalid JSON '%s': not a JSON Object", returnData));}
            //获取用户信息
             email = getStringElement(returnData, "email");
             name = getStringElement(returnData, "realname");
             login = getStringElement(returnData, "employeenum");
        }*/
       /* if (attrListJson.isJsonPrimitive()) {
            JsonPrimitive asJsonPrimitive = attrListJson.getAsJsonPrimitive();
            JsonObject elem = new JsonParser().parse(asJsonPrimitive.getAsString()).getAsJsonObject();
            if (elem == null || !elem.isJsonObject()) {
                throw new IOException(String.format("Invalid JSON '%s': not a JSON Object", elem));
            }
            email = getStringElement(elem, "email");
            name = getStringElement(elem, "realname");
            login = getStringElement(elem, "employeenum");
        }*/
       // if (attrListJson == null || !attrListJson.isJsonObject())
         //   throw new IOException(String.format("Invalid JSON '%s': not a JSON Object", new Object[] { attrListJson }));
       // JsonObject obj = attrListJson.getAsJsonObject();
       // JsonPrimitive obj = attrListJson.getAsJsonPrimitive();
       /* JsonObject obj = new JsonParser().parse(attrListJson.getAsString()).getAsJsonObject();
        String property = getStringElement(obj, "email");
        if (property != null)
            email = property;
        property = getStringElement(obj, "realname");
        if (property != null)
            name = property;
        property = getStringElement(obj, "employeenum");
        if (property != null)
            login = property;*/
        if (attrListJson.isJsonPrimitive()) {
            JsonPrimitive asJsonPrimitive = attrListJson.getAsJsonPrimitive();
            JsonObject elem = new JsonParser().parse(asJsonPrimitive.getAsString()).getAsJsonObject();
            if (elem == null || !elem.isJsonObject()) {
                throw new IOException(String.format("Invalid JSON '%s': not a JSON Object", elem));
            }
            email = getStringElement(elem, "email");
            name = getStringElement(elem, "realname");
            login = getStringElement(elem, "employeenum");
        }
        return new OAuthUserInfo((new StringBuilder()).append("cas-oauth:").append(id.getAsString()).toString(), login, email, name, fixLegacyUserId ? id.getAsString() : null);
    }
    private static String getStringElement(JsonObject o, String name) {
        JsonElement elem = o.get(name);
        if (elem == null || elem.isJsonNull()) return null;

        return elem.getAsString();
    }
}
