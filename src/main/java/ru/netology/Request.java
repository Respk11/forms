package ru.netology;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.stream.Collectors;

public class Request {
    private final String path;
    private final String method;
    private String params;
    private Map<String, String> keyValues;


    public Request(String requestPath, String requestMethod) {
        this.path = requestPath;
        this.method = requestMethod;
        this.params = StringUtils.substringAfter(path, "?");
        this.keyValues = URLEncodedUtils.parse(params, Charset.defaultCharset())
                .stream().collect(Collectors.toMap(NameValuePair::getName,NameValuePair::getValue));
    }
    public String getQueryParam(String name){
        return keyValues.get(name);
    }

    public String getQueryParams() {
        return params;
    }

}
