package restassured;

import org.junit.Test;

import static io.restassured.RestAssured.given;

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
    }

}
