package com.mgi.util;


import com.mgi.service.HttpClientService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 获取SF的token信息,
 */
@Service
public class SendToSF {
    @Autowired
    private  HttpClientService httpClientService;
    private  ObjectMapper mapper = new ObjectMapper();
    @Value("${getToken.url}")
    private String getTokenUrl;

    public  String getToken() {
        JsonNode token = null;
        try {
            String result = httpClientService.doPosttoSFGetToken(getTokenUrl);
            JsonNode jsonNode = mapper.readTree(result);
            token = jsonNode.get("access_token");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Bearer " + token.textValue();
    }
}
