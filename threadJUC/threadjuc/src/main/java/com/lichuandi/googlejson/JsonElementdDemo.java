package com.lichuandi.googlejson;

import com.google.gson.*;

import java.io.IOException;

/**
 * @Auther digege
 * @Date 2021/3/23
 * @Description：com.lichuandi.googlejson version：
 */
public class JsonElementdDemo {
    private final boolean fixLegacyUserId;

    public JsonElementdDemo(boolean fixLegacyUserId) {
        this.fixLegacyUserId = fixLegacyUserId;
    }

    public boolean isFixLegacyUserId() {
        return fixLegacyUserId;
    }

    public static void main(String[] args) {
        String str = "{\n" +
                "  \"account\" : \"\",\n" +
                "  \"activation_mode\" : \"3\",\n" +
                "  \"authWay\" : \"8\",\n" +
                "  \"credentialType\" : \"CimsCredential\",\n" +
                "  \"email\" : \"huangkai1@hopebank.com\",\n" +
                "  \"employeenum\" : \"huangkai1\",\n" +
                "  \"otherInfos\" : \"{\\\"userid\\\":\\\"c1b97c854e954e54b2b6eb7a723c9188\\\",\\\"createTime\\\":\\\"2021-02-24\\\",\\\"updateTime\\\":\\\"2021-03-12\\\",\\\"email\\\":\\\"huangkai1@hopebank.com\\\",\\\"employeeStatus\\\":1,\\\"employeenum\\\":\\\"huangkai1\\\",\\\"phone\\\":\\\"15632154987\\\",\\\"realname\\\":\\\"??1\\\",\\\"spid\\\":\\\"1000002\\\",\\\"attrs\\\":{\\\"job_num\\\":\\\"0133\\\",\\\"leadership\\\":\\\"\\\",\\\"sex\\\":\\\"male\\\",\\\"userkind\\\":\\\"formal\\\",\\\"company\\\":\\\"????\\\",\\\"cn\\\":\\\"??1\\\",\\\"department\\\":\\\"?????\\\",\\\"desc\\\":\\\"????\\\"},\\\"appCount\\\":0,\\\"dataSignCount\\\":0}\",\n" +
                "  \"permissions\" : \"\",\n" +
                "  \"phone\" : \"15632154987\",\n" +
                "  \"realname\" : \"??1\",\n" +
                "  \"roles\" : \"\",\n" +
                "  \"userid\" : \"c1b97c854e954e54b2b6eb7a723c9188\",\n" +
                "  \"id\" : \"huangkai1\"\n" +
                "}";
        System.out.println(str.toString());
        String string = str.toString();
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
        // js.addProperty("otherInfos","");
        JsonElement userid = jsonObject.get("userid");
        // js.add("otherInfos",userid);
        // System.out.println(userid);
        //System.out.println(js);
        //JsonObject jsonObject = new JsonObject();
        //jsonObject.addProperty("otherInfos", String.valueOf(js));
        //System.out.println(jsonObject);
        //JsonElement type = str.get("authWay");
        // jsonObject.get("")
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
            //  throw new IOException(String.format("CAS response missing id: %s", ""response.getBody()""));
        }

        // JsonElement attrListJson = jsonObject.get("attributes");
        JsonElement attrListJson = jsonObject.get("otherInfos");
        System.out.println("我是用信息"+attrListJson);
        System.out.println(attrListJson.isJsonPrimitive());
        if (attrListJson == null) {
            System.out.println("没有");
            //  throw new IOException(
            //        String.format("CAS response missing attributes: %s", "AAA");
        }
        JsonElement emails = jsonObject.get("email");
        System.out.println(emails);
        JsonElement employeenum = jsonObject.get("employeenum");
        JsonElement logins = jsonObject.get("id");
        //JsonObject asJsonObject = emails.getAsJsonObject();
       // System.out.println(emails.getAsJsonObject());
        String email = getStringElement(jsonObject, "email");
        String name = getStringElement(jsonObject, "employeenum");
        String login = getStringElement(jsonObject, "id");
        System.out.println("邮箱"+email+":名称"+name+":登录名称"+login);
       /* if (property != null) email = property;
        property = getStringElement(obj, "name");
        if (property != null) name = property;
        property = getStringElement(obj, "login");
        if (property != null) login = property;*/
        //  String email = null, name = null, login = null;
        //attrListJson.toString();
     //   JsonObject returnData = new JsonParser().parse(attrListJson.toString()).getAsJsonObject();
       // System.out.println("我是JsonObject"+returnData);

        if (attrListJson.isJsonPrimitive()) {
            System.out.println("bushi");
            // It is possible for CAS to be configured to not return any attributes (email, name,
            // login),
            // in which case,
            // CAS returns an empty JSON object "attributes":{}, rather than "null" or an empty JSON
            // array
            // "attributes": []
            JsonPrimitive asJsonPrimitive = attrListJson.getAsJsonPrimitive();
            asJsonPrimitive.getAsString();
            JsonObject returnData = new JsonParser().parse(asJsonPrimitive.getAsString()).getAsJsonObject();
          //  System.out.println(returnData.isJsonObject());
            System.out.println("returnData"+returnData);
            String email1 = getStringElement(returnData, "job_num");
            String realname = getStringElement(returnData, "sex");
            String employeenums = getStringElement(returnData, "userkind");
            System.out.println(email1+realname+employeenums);

            if (returnData == null || !returnData.isJsonObject()) {
                System.out.println("returnData"+returnData);
                // throw new IOException(String.format("Invalid JSON '%s': not a JSON Object", elem));
            }
          //  String email = getStringElement(returnData, "email");
            //String name = getStringElement(returnData, "realname");
            //String login = getStringElement(returnData, "employeenum");

            /*String property = getStringElement(returnData, "email");
            if (property != null) email = property;
            property = getStringElement(obj, "realname");
            if (property != null) name = property;
            property = getStringElement(obj, "employeenum");
            if (property != null) login = property;*/


            System.out.println(attrListJson.getAsJsonPrimitive());
            //JsonArray attrJson = attrListJson.getAsJsonArray();
           /* for (JsonElement elem : attrJson) {
                if (elem == null || !elem.isJsonObject()) {
                    // throw new IOException(String.format("Invalid JSON '%s': not a JSON Object", elem));
                }
                JsonObject obj = elem.getAsJsonObject();

             *//*   String property = getStringElement(obj, "email");
                if (property != null) email = property;
                property = getStringElement(obj, "name");
                if (property != null) name = property;
                property = getStringElement(obj, "login");
                if (property != null) login = property;*//*
            }*/
        }
        //System.out.println(type);
        //OAuthUserInfo userInfo = new OAuthUserInfo();
        try {
            OAuthUserInfo userInfo = new OAuthUserInfoS().getUserInfo();
            OAuthUserInfo userInfo2 = new OAuthUserInfo2().getUserInfo();
            System.out.println(userInfo2);

            System.out.println(userInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getStringElement(JsonObject o, String name) {
        JsonElement elem = o.get(name);
        if (elem == null || elem.isJsonNull()) return null;

        return elem.getAsString();
    }


}
