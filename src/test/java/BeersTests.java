import GetAllBeers.beers;
import Service.BeersService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.stream.Collectors;

public class BeersTests {
    @Test(groups = "regression")
    public void TC001_Verify_Get_AllBeers() {

        beers beer = new BeersService().getAllBeers();

        Assert.assertEquals(beer.getStatusCode(), 200);
        Assert.assertEquals(beer.getBeersList().get(0).getId(), 1);
        Assert.assertEquals(beer.getBeersList().get(0).getName(), "Buzz");
        Assert.assertEquals(beer.getBeersList().get(0).getDescription(), "A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.");
        Assert.assertEquals(beer.getBeersList().get(0).getAbv(), 4.5);
    }

    @Test(groups = "smoke")
    public void TC002_Verify_Get_AllBeersBrewedBeforeCertainDate() {

        beers beer = new BeersService().getAllBeersBrewedBeforeDate("07/2007");

        Assert.assertEquals(beer.getStatusCode(), 200);
        Assert.assertEquals(beer.getBeersList().size(), 6);
        Assert.assertEquals(beer.getBeersList().get(0).getId(), 45);
        Assert.assertEquals(beer.getBeersList().get(0).getName(), "The Physics");
        Assert.assertEquals(beer.getBeersList().get(0).getDescription(), "A hoppy Amber " +
                "Ale that won World's Best Amber Beer in the World Beer Awards 2007. " +
                "Malt and hops are in perfect harmony in this incredibly balanced beer. " +
                "Biscuity, bitter and packing a surprisingly hoppy punch, this beer ultimately " +
                "morphed into 5AM Saint.");
        Assert.assertEquals(beer.getBeersList().get(0).getAbv(), 5);
    }

    @Test(groups = "regression")
    public void TC003_Verify_Get_AllBeersWithAbvGreaterThan6() {

        beers beer = new BeersService().getAllBeersAbvGreaterThan6(6);

        Assert.assertEquals(beer.getStatusCode(), 200);
        Assert.assertEquals(beer.getBeersList().stream().filter(beers -> beers.getAbv() > 6).collect(Collectors.toList()).size(), 25);
        Assert.assertEquals(beer.getBeersList().get(0).getId(), 4);
        Assert.assertEquals(beer.getBeersList().get(0).getName(), "Pilsen Lager");
        Assert.assertEquals(beer.getBeersList().get(0).getDescription(), "Our Unleash the Yeast series was an epic " +
                "experiment into the differences in aroma and flavour provided by switching up your yeast. " +
                "We brewed up a wort with a light caramel note and some toasty biscuit flavour, and hopped " +
                "it with Amarillo and Centennial for a citrusy bitterness. Everything else is down to the " +
                "yeast. Pilsner yeast ferments with no fruity esters or spicy phenols, although it can add " +
                "a hint of butterscotch.");
        Assert.assertEquals(beer.getBeersList().get(0).getAbv(), 6.3);
    }

    @Test(groups = "smoke")
    public void TC004_Verify_if_pagination_is_working_as_expected() {

        beers beer = new BeersService().getBeersWithPagination(2, 5);

        Assert.assertEquals(beer.getStatusCode(), 200);
        Assert.assertEquals(beer.getBeersList().size(), 5);

    }

}
