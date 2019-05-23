package com.codecool.wuff.wuffproject;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTests {


    // ---------- IndexController endpoint tests -----------------
    @Test
    public void indexStatusCode200(){

        given().
                when().
                get("http://localhost:8888").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void newsFeedCommentStatusCode302(){

        given().
                when().
                param("inComment", "macska").
                post("http://localhost:8888/comment").
                then().
                statusCode(302);
    }

    // ---------- DogController endpoint tests -----------------


    @Test
    public void registrationStatusCode302(){

        given().
                when().
                param("email", "a@a.com").
                param("password1", "abcd").
                param("password2", "abcd").
                param("dogName", "a").
                param("ownerName", "a").
                post("http://localhost:8888/registration").
                then().
                statusCode(302);
    }

    @Test
    public void loginStatusCode302(){

        given().
                when().
                param("email", "a@a.com").
                param("password1", "aaa").
                post("http://localhost:8888/login").
                then().
                statusCode(302);
    }

    @Test
    public void logoutStatusCode302(){

        given().
                when().
                post("http://localhost:8888/logout").
                then().
                statusCode(302);
    }

    // ---------- SpotController endpoint tests -----------------

    @Test
    public void listStatusCode200(){

        given().
                when().
                get("http://localhost:8888/spot/list").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void spotStatusCode200(){

        given().
                when().
                get("http://localhost:8888/spot/2").
                then().
                statusCode(200);
    }

    @Test
    public void commentOnSpotsStatusCode302(){

        given().
                when().
                param("comment", "Szeretem az őszt!").
                post("http://localhost:8888/spot/2/comment").
                then().
                statusCode(302);
    }

}
