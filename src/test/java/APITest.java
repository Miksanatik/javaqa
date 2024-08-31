import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITest {
    @Test
    @DisplayName("GET requests")
    public void testGet() {
        given()
                .baseUri("https://postman-echo.com")
                .param("firstName", "Abraham")
                .param("lastName", "Lincoln")
                .when()
                .get("/get")
                .then()
                .assertThat()
                .statusCode(200)
                .body("args.firstName", equalTo("Abraham"))
                .body("args.lastName", equalTo("Lincoln"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto",equalTo("http"))
                .body("headers.connection",equalTo("close"))
                .body("url",equalTo("http://postman-echo.com/get?firstName=Abraham&lastName=Lincoln"));
    }

    @Test
    @DisplayName("POST requests from RAW text")
    public void testPostRawText() {
         given()
                .baseUri("https://postman-echo.com")
                .body("{\"name\": \"Abraham Lincoln\", \"age\": 55}")
                .contentType("application/json")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data.name", equalTo("Abraham Lincoln"))
                .body("data.age", equalTo(55))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto",equalTo("http"))
                .body("headers.connection",equalTo("close"))
                .body("url",equalTo("http://postman-echo.com/post"));
    }
    @Test
    @DisplayName("POST requests from form data")
    public void testPostFormData() {
        given().baseUri("https://postman-echo.com")
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("name", "Abraham Lincoln")
                .formParam("age", "55")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.name", equalTo("Abraham Lincoln"))
                .body("form.age", equalTo("55"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto",equalTo("http"))
                .body("headers.connection",equalTo("close"))
                .body("url",equalTo("http://postman-echo.com/post"));
    }

    @Test
    @DisplayName("PUT requests")
    public void testPut(){
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body("{\"name\": \"Abraham Lincoln\", \"age\": 65}")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data.name", equalTo("Abraham Lincoln"))
                .body("data.age", equalTo(65))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto",equalTo("http"))
                .body("headers.connection",equalTo("close"))
                .body("url",equalTo("http://postman-echo.com/put"));
    }

    @Test
    @DisplayName("PATCH requests")
    public void testPatch() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body("{\"name\": \"Abraham Lincoln\"}")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.name", equalTo("Abraham Lincoln"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto",equalTo("http"))
                .body("headers.connection",equalTo("close"))
                .body("url",equalTo("http://postman-echo.com/patch"));
    }

    @Test
    @DisplayName("DELETE requests")
    public void testDelete() {
        given()
                .baseUri("https://postman-echo.com")
                .param("id","1")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.id", equalTo("1"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto",equalTo("http"))
                .body("headers.connection",equalTo("close"))
                .body("url",equalTo("http://postman-echo.com/delete?id=1"));
    }
}
