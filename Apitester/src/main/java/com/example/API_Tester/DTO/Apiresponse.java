package com.example.API_Tester.DTO;

import java.util.Map;

public class Apiresponse {
    private int status;
    private long response;
    private Map<String,String> header;
    private String Body;

    public Apiresponse(){

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getResponse() {
        return response;
    }

    public void setResponse(long response) {
        this.response = response;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }
}
