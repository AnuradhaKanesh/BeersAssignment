package Client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class BeersClient {

    public Response getALlBeers() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.punkapi.com/v2/beers");

    }


    public Response GetAllBeersBrewedBeforeADate(String brewed_before) {
        return given()
                    .contentType(ContentType.JSON)
                .when()
                    .pathParam("brewed_before", brewed_before)
                .get("https://api.punkapi.com/v2/beers?brewed_before={brewed_before}");
    }

    public Response GetAllBeersAbvGreaterThan6(int abv_gt) {
        return given()
                .   contentType(ContentType.JSON)
                .when()
                    .pathParam("abv_gt", abv_gt)
                .get("https://api.punkapi.com/v2/beers?abv_gt={abv_gt}");
    }

    public Response GetBeersWithPagination(int page, int per_page) {
        return given()
                .   contentType(ContentType.JSON)
                .when()
                .pathParam("page", page)
                .pathParam("per_page", per_page)
                .get("https://api.punkapi.com/v2/beers?page={page}&per_page={per_page}");
    }
}
