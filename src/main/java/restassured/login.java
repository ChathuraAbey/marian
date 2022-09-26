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
    }

    @Test
    public void getUserFunction()
    {

       Response resp = given().header("Authorization", "Bearer "+"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJoWjc0X0ltME92emUwLThxYldlRFY3bnZJbU95WkRBWE51dDhhNThPdzRvIn0.eyJleHAiOjE2NjQxODAyOTcsImlhdCI6MTY2NDE3NjY5NywianRpIjoiYWIzMTc0MDMtYTQxYi00N2Y2LTg4YTQtMTk0NmU3NDkxNjgzIiwiaXNzIjoiaHR0cHM6Ly9pZnNjbG91ZDIycjFibnQtY21iLnJuZC5pZnNkZXZ3b3JsZC5jb20vYXV0aC9yZWFsbXMvaWZzY2xvdWQyMnIxYm50LWNtYiIsImF1ZCI6WyJpZnNjbG91ZDIycjFibnQtY21iIiwiYWNjb3VudCJdLCJzdWIiOiJkYWIyODIwOS04YjVlLTRlNGUtOTU0MS0yODM5MTBiZWY2NTMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJJRlNfYXVyZW5hIiwic2Vzc2lvbl9zdGF0ZSI6IjNmNjY0OGExLTcyNTQtNDlkNS1hMDcxLThhMTAzMjQ5NDQwZiIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cHM6Ly9pZnNjbG91ZDIycjFibnQtY21iLnJuZC5pZnNkZXZ3b3JsZC5jb20iLCJodHRwczovL2lmc2Nsb3VkMjJyMWJudGNtYi1leHQtcm5kLmNvcnBvcmF0ZS5pZnMuY29tIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIiwiZGVmYXVsdC1yb2xlcy1pZnNjbG91ZDIycjFibnQtY21iIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgYXVkaWVuY2UgZW1haWwgbWljcm9wcm9maWxlLWp3dCBwcm9maWxlIiwidXBuIjoiYWxhaW4iLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImdyb3VwcyI6WyJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIiwiZGVmYXVsdC1yb2xlcy1pZnNjbG91ZDIycjFibnQtY21iIl0sInByZWZlcnJlZF91c2VybmFtZSI6ImFsYWluIiwiZW1haWwiOiJhbGFpbkBzZXJ2ZXJuYW1lIn0.nN0COxBsJhXEhim3lSsjDuXJW1o7zWzuiHTN8eVm7fMH0P2e9o1qEVD9951vJEm8svO-i-TNBBZKGYugKrLjTYar4y-BvYEEfgXhvNSSobJv6ACtWTrhZcLw9WT31-W4TJm1ASE8D6klvfBuix61Ew3lofmhWGcfp5Gf3doX5X3w1WxqwAHZr1MkrA5qrnGwDU-XOjWKwCeXx6xz_o0VBHmBZ8gkpYQhYhkMfauoMJ7bdSoGv7vjx1gEOChIBdw4b1cBk3ST_4BJT8hHEtm6kScASVNZIdqN760be_7MJlcaA9H7fcZhDXwLUygTD3vPmb3C77_wx92UGzpDDgvETg\n").
                post("https://ifscloud22r1bnt-cmb.rnd.ifsdevworld.com/auth/realms/ifscloud22r1bnt-cmb/protocol/openid-connect/userinfo");
        resp.prettyPrint();

//        int ss=resp.getStatusCode();
//        System.out.println(ss);


    }


}
