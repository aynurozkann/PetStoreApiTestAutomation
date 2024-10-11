import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

@Feature("User Test Senaryoları")
public class PetStoreApiTest {

    @Test(description = "Kullanıcı Oluşturma Adım Kontrolü")
    public void UserCreate() {
        String payLoad = "{\n" +
                "  \"id\": 1234567,\n" +
                "  \"username\": \"user2.2\",\n" +
                "  \"firstName\": \"Oğuzcan\",\n" +
                "  \"lastName\": \"Özkan\",\n" +
                "  \"email\": \"aynurozkan@gmail.com\",\n" +
                "  \"password\": \"aynur1515\",\n" +
                "  \"phone\": \"444444444\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        RestAssured.given().body(payLoad).contentType(ContentType.JSON).when().post("https://petstore.swagger.io/v2/user").then().statusCode(200);
    }

    @Test(description = "Kullanıcı Güncelleme Adım Kontrolü")
    public void UpdateUser() {
        String payLoad = "{\n" +
                "  \"id\": 12345,\n" +
                "  \"username\": \"user2\",\n" +
                "  \"firstName\": \"Aynur\",\n" +
                "  \"lastName\": \"Özkan\",\n" +
                "  \"email\": \"nur@gmail.com\",\n" +
                "  \"password\": \"aynur16\",\n" +
                "  \"phone\": \"22222222\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        RestAssured.given().body(payLoad).contentType(ContentType.JSON).when().put("https://petstore.swagger.io/v2/user/user2.1").then().statusCode(200);
    }

    @Test(description = "Kullanıcı Kontrolü")
    public void GetUserInfo() {
        RestAssured.get("https://petstore.swagger.io/v2/user/user2");
    }

    @Test(description = "Kullanıcı Silme Kontrolü")
    public void DeleteUser() {
        RestAssured.given().contentType(ContentType.JSON).when().delete("https://petstore.swagger.io/v2/user/user2.1").then().statusCode(200);
    }

    @Test(description = "Kullanıcı Girişi Kontrolü")
    public void LoginUser() {
        String payLoad = "{\n" +
                "  \"username\": \"user1\",\n" +
                "  \"password\": \"aynur1515\",\n" +
                "}";
        RestAssured.given().queryParam(payLoad).contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/login").then().statusCode(200);
    }

    @Test(description = "Kullanıcı Çıkış Yapma Adım Kontrolü")
    public void LogoutUser() {
        RestAssured.get("https://petstore.swagger.io/v2/user/logout");
    }

}
