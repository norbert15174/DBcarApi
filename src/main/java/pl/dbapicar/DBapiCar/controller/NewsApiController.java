package pl.dbapicar.DBapiCar.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.dbapicar.DBapiCar.models.CarNews;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class NewsApiController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${appid}")
    private String appid;

    //Initialization data to the database, if you want to init it, just uncomment

//    @EventListener(ApplicationReadyEvent.class)
//    public void initDataToDB() throws UnsupportedEncodingException {
//
//        MultiValueMap<String,String> headers = new HttpHeaders();
//        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//        String redirectURI = "new cars";
//        UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromHttpUrl("http://newsapi.org/v2/everything?")
//                .queryParam("q", URLEncoder.encode(redirectURI,"UTF-8" ))
//                .queryParam("from","2020-10-28")
//                .queryParam("apiKey","4ff2736e44c34706985b0fcb8a424a10");
//
//        HttpEntity httpEntity = new HttpEntity((headers));
//
//        RestTemplate restTemplate = new RestTemplate();
//        JsonNode jsonNode = restTemplate.exchange(componentsBuilder.toUriString(),HttpMethod.GET,httpEntity,JsonNode.class)
//                .getBody()
//                .get("articles");
//        int a = 1;
//        for(JsonNode value : jsonNode){
//
//                    String author = value.get("author").toString().replaceAll("\"", "");
//                    String title = value.get("title").toString().replaceAll("\"", "");
//                    String description = value.get("description").toString().replaceAll("\"", "");
//                    String url = value.get("url").toString().replaceAll("\"", "");
//                    String urlToImage = value.get("urlToImage").toString().replaceAll("\"", "");
//                    String content  = value.get("content").toString().replaceAll("\"", "");
//                    String query = "INSERT INTO CarNews VALUES(?,?,?,?,?,?,?)";
//
//                    jdbcTemplate.update(query,author,title,description,url,urlToImage,content,a++);
//        }
//
//    }



}
