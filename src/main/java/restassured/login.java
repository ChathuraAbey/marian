package restassured;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.response.Response;
import org.junit.runner.Request;

import static io.restassured.RestAssured.*;

public class login {

    public void function()
    {
        //method deficnition

    }
    @Test
    public void loginFunction()
    {
        String token =   given().formParam("grant_type", "password").
                formParam("client_id", "IFS_aurena").
                formParam("client_secret", "2Rpi5yNFwU8YzrOdeCi7").
                formParam("scope", "openid").
                formParam("username", "alain").
                formParam("password", "alain").
                when().post("https://ifscloud22r1bnt-cmb.rnd.ifsdevworld.com/auth/realms/ifscloud22r1bnt-cmb/protocol/openid-connect/token").
                then().extract().response().jsonPath().getString("access_token");
        System.out.println(token);
        Assert.assertNotEquals(String.valueOf(token) , null);
        Response resp=RestAssured.get("https://ifscloud22r1bnt-cmb.rnd.ifsdevworld.com/auth/realms/ifscloud22r1bnt-cmb/protocol/openid-connect/token");
        System.out.println(resp.getStatusCode());
    }

    @Test
    public void getUserFunction()
    {

       Response resp = given().header("Authorization", "Bearer "+"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJoWjc0X0ltME92emUwLThxYldlRFY3bnZJbU95WkRBWE51dDhhNThPdzRvIn0.eyJleHAiOjE2NjQyNzk4OTYsImlhdCI6MTY2NDI3NjI5NiwianRpIjoiYTVmYTk4MGYtZGM4Mi00ZGE2LTg2NTUtMTJmNTI4ODY4YjdhIiwiaXNzIjoiaHR0cHM6Ly9pZnNjbG91ZDIycjFibnQtY21iLnJuZC5pZnNkZXZ3b3JsZC5jb20vYXV0aC9yZWFsbXMvaWZzY2xvdWQyMnIxYm50LWNtYiIsImF1ZCI6WyJpZnNjbG91ZDIycjFibnQtY21iIiwiYWNjb3VudCJdLCJzdWIiOiJkYWIyODIwOS04YjVlLTRlNGUtOTU0MS0yODM5MTBiZWY2NTMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJJRlNfYXVyZW5hIiwic2Vzc2lvbl9zdGF0ZSI6Ijg4ZGY0NmU0LWFkZmQtNDVjZi1iMzFkLTc4YzM0NDNkNGE4NyIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cHM6Ly9pZnNjbG91ZDIycjFibnQtY21iLnJuZC5pZnNkZXZ3b3JsZC5jb20iLCJodHRwczovL2lmc2Nsb3VkMjJyMWJudGNtYi1leHQtcm5kLmNvcnBvcmF0ZS5pZnMuY29tIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIiwiZGVmYXVsdC1yb2xlcy1pZnNjbG91ZDIycjFibnQtY21iIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgYXVkaWVuY2UgZW1haWwgbWljcm9wcm9maWxlLWp3dCBwcm9maWxlIiwidXBuIjoiYWxhaW4iLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImdyb3VwcyI6WyJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIiwiZGVmYXVsdC1yb2xlcy1pZnNjbG91ZDIycjFibnQtY21iIl0sInByZWZlcnJlZF91c2VybmFtZSI6ImFsYWluIiwiZW1haWwiOiJhbGFpbkBzZXJ2ZXJuYW1lIn0.Wb9VeCIunS9CsAa3KR7QAw7k_XCqyJuyYuwj4q3god51FGamkulv71is9ys0SAT2U6CqTrfUlx2H0B7gVWJAM6dufdQCFAN2OaQRNeZh5MeUBWRP2gW_juDpKDhTTfZAAKloGrOazWz4UkFq1fX297K4_VPnbhtf13df1q1limY0wjCweYTQw4EaHY76m9cFJ_ptpABTW3LqQ1EelKKdUAZs9S1Ot1CSBV0dp3CFnyOUcbu7GiAnrYHWrz94IznLDbJw3sYE125PYxgcFhXCT3Q1kxg9Q3a3XCYD9_DlTMxQjJML3RN28sD1MZs447qWat7VvSDIhn_uWHKzuZXn2g\n").
                post("https://ifscloud22r1bnt-cmb.rnd.ifsdevworld.com/auth/realms/ifscloud22r1bnt-cmb/protocol/openid-connect/userinfo");
        resp.prettyPrint();

        //Getting the status code
        Response resp1= (Response) RestAssured.get("https://ifscloud22r1bnt-cmb.rnd.ifsdevworld.com/auth/realms/ifscloud22r1bnt-cmb/protocol/openid-connect/userinfo").
                then().assertThat().statusCode(200);

        //Validating whether username is alain
        String name=given().header("Authorization", "Bearer "+"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJoWjc0X0ltME92emUwLThxYldlRFY3bnZJbU95WkRBWE51dDhhNThPdzRvIn0.eyJleHAiOjE2NjQyNzk4OTYsImlhdCI6MTY2NDI3NjI5NiwianRpIjoiYTVmYTk4MGYtZGM4Mi00ZGE2LTg2NTUtMTJmNTI4ODY4YjdhIiwiaXNzIjoiaHR0cHM6Ly9pZnNjbG91ZDIycjFibnQtY21iLnJuZC5pZnNkZXZ3b3JsZC5jb20vYXV0aC9yZWFsbXMvaWZzY2xvdWQyMnIxYm50LWNtYiIsImF1ZCI6WyJpZnNjbG91ZDIycjFibnQtY21iIiwiYWNjb3VudCJdLCJzdWIiOiJkYWIyODIwOS04YjVlLTRlNGUtOTU0MS0yODM5MTBiZWY2NTMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJJRlNfYXVyZW5hIiwic2Vzc2lvbl9zdGF0ZSI6Ijg4ZGY0NmU0LWFkZmQtNDVjZi1iMzFkLTc4YzM0NDNkNGE4NyIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cHM6Ly9pZnNjbG91ZDIycjFibnQtY21iLnJuZC5pZnNkZXZ3b3JsZC5jb20iLCJodHRwczovL2lmc2Nsb3VkMjJyMWJudGNtYi1leHQtcm5kLmNvcnBvcmF0ZS5pZnMuY29tIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIiwiZGVmYXVsdC1yb2xlcy1pZnNjbG91ZDIycjFibnQtY21iIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgYXVkaWVuY2UgZW1haWwgbWljcm9wcm9maWxlLWp3dCBwcm9maWxlIiwidXBuIjoiYWxhaW4iLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImdyb3VwcyI6WyJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIiwiZGVmYXVsdC1yb2xlcy1pZnNjbG91ZDIycjFibnQtY21iIl0sInByZWZlcnJlZF91c2VybmFtZSI6ImFsYWluIiwiZW1haWwiOiJhbGFpbkBzZXJ2ZXJuYW1lIn0.Wb9VeCIunS9CsAa3KR7QAw7k_XCqyJuyYuwj4q3god51FGamkulv71is9ys0SAT2U6CqTrfUlx2H0B7gVWJAM6dufdQCFAN2OaQRNeZh5MeUBWRP2gW_juDpKDhTTfZAAKloGrOazWz4UkFq1fX297K4_VPnbhtf13df1q1limY0wjCweYTQw4EaHY76m9cFJ_ptpABTW3LqQ1EelKKdUAZs9S1Ot1CSBV0dp3CFnyOUcbu7GiAnrYHWrz94IznLDbJw3sYE125PYxgcFhXCT3Q1kxg9Q3a3XCYD9_DlTMxQjJML3RN28sD1MZs447qWat7VvSDIhn_uWHKzuZXn2g\n")
        .when().get("https://ifscloud22r1bnt-cmb.rnd.ifsdevworld.com/auth/realms/ifscloud22r1bnt-cmb/protocol/openid-connect/userinfo").
                then().extract().path("preferred_username");
        Assert.assertEquals("alain", name);
        System.out.println(name);
    }


}
