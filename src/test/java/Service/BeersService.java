package Service;

import Client.BeersClient;
import GetAllBeers.beers;
import io.restassured.response.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BeersService {


    public beers getAllBeers() {
        Response response = new BeersClient().getALlBeers();
        beers beer = getBeers(response);
        return beer;
    }

    public beers getAllBeersBrewedBeforeDate(String date) {
        Response response = new BeersClient().GetAllBeersBrewedBeforeADate(date);
        beers beer = getBeers(response);
        return beer;
    }

    public beers getAllBeersAbvGreaterThan6(int abv_gt) {
        Response response = new BeersClient().GetAllBeersAbvGreaterThan6(abv_gt);
        beers beer = getBeers(response);
        return beer;
    }

    public beers getBeersWithPagination(int page_no,int per_page) {
        Response response = new BeersClient().GetBeersWithPagination(page_no,per_page);
        beers beer = getBeers(response);
        return beer;
    }

    private beers getBeers(Response response) {
        beers beer = beers.builder().beersList(Arrays.asList(response.as(beers.Beers[].class))).build();
        beer.setStatusCode(response.getStatusCode());

        response.then().log().body();
        return beer;
    }


}
