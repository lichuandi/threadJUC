package com.lichuandi.googlejson;

import com.google.gson.*;
import java.io.IOException;

/**
 * @Auther digege
 * @Date 2021/3/23
 * @Description：com.lichuandi.googlejson version：
 */
public class OAuthUserInfo2 {
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
        String email = null;
        String name = null;
        String login = null;
        if (id != null || !id.isJsonNull()) {
            JsonElement attrListJson = jsonObject.get("otherInfos");
            if (attrListJson == null) {
                throw new IOException(String.format("CAS response missing attributes: %s", attrListJson));
            } else {
                if (attrListJson.isJsonPrimitive() && ((JsonPrimitive) attrListJson).isString()) {
                    
                    // attrListJson = (JsonElement)OutputFormat.JSON.newGson().fromJson(((JsonPrimitive)attrListJson).getAsString(), JsonElement.class);
                    boolean jsonPrimitive = attrListJson.isJsonPrimitive();
                    JsonPrimitive asJsonPrimitive = attrListJson.getAsJsonPrimitive();
                    attrListJson = new JsonParser().parse(asJsonPrimitive.getAsString()).getAsJsonObject();
                }


                if (attrListJson != null && attrListJson.isJsonObject()) {
                    JsonObject obj = attrListJson.getAsJsonObject();
                    String property = this.getStringElement(obj, "job_num");
                    System.out.println(property);
                    if (property != null) {
                        email = property;
                    }

                    property = this.getStringElement(obj, "sex");
                    System.out.println(property);
                    if (property != null) {
                        name = property;
                    }

                    property = this.getStringElement(obj, "userkind");
                    System.out.println(property);
                    if (property != null) {
                        login = property;
                    }


                }
            }
        }
       // return
        System.out.println(login+email+name);
        return new OAuthUserInfo("cas-oauth:" + id.getAsString(), login, email, name, this.fixLegacyUserId ? id.getAsString() : null);
    }

    private static String getStringElement(JsonObject o, String name) {
        JsonElement elem = o.get(name);
        if (elem == null || elem.isJsonNull()) return null;

        return elem.getAsString();
    }
}
