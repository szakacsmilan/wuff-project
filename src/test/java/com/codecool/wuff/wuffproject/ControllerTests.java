package com.codecool.wuff.wuffproject;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTests {

    @Test
    public void indexStatusCode200(){

        given().
                when().
                get("http://localhost:8888").
                then().
                statusCode(200);
    }

    @Test
    public void newsfeedCommentStatusCode302(){

        given().
                when().
                param("inComment", "macska").
                post("http://localhost:8888/comment").
                then().
                statusCode(302);
    }




}
