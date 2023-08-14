package com.niuma.huaapi.constant;

/**
 * @Author hua
 * @Create 2023/8/10 20:28
 */
public class InterfaceInfoConstant {
    public static final String MAPPING_TEMPLATE = "{\n" +
            "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"id\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"name\": {\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_max_word\",\n" +
            "        \"copy_to\": \"all\"\n" +
            "      },\n" +
            "      \"methodName\": {\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": \"false\"\n" +
            "      },\n" +
            "      \"url\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"requestHeader\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"description\": {\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_max_word\",\n" +
            "        \"copy_to\": \"all\"\n" +
            "      },\n" +
            "      \"status\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"method\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"responseHeader\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"createTime\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"updateTime\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"requestParams\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"userId\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"all\": {\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_max_word\"\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
