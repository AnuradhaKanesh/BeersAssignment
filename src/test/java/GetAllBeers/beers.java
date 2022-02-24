package GetAllBeers;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class beers {

    @Setter
    private int statusCode;

    List<Beers> beersList;

    @Getter
    public static class Beers {
        private String first_brewed;
        private String attenuation_level;
        private Method method;
        private String target_og;
        private String image_url;
        private Boil_volume boil_volume;
        private String ebc;
        private String description;
        private String target_fg;
        private String srm;
        private Volume volume;
        private String contributed_by;
        private String abv;
        private String[] food_pairing;
        private String name;
        private String ph;
        private String tagline;
        private Ingredients ingredients;
        private String id;
        private String ibu;
        private String brewers_tips;
    }

    @Getter
    public static class Ingredients {
        private Hops[] hops;
        private String yeast;
        private Malt[] malt;
    }

    @Getter
    public static class Amount {
        private String unit;
        private String value;
    }

    @Getter
    public static class Hops {
        private String add;
        private Amount amount;
        private String name;
        private String attribute;
    }

    @Getter
    public static class Malt {
        private Amount amount;
        private String name;
    }

    @Getter
    public static class Method {
        private Mash_temp[] mash_temp;
        private Fermentation fermentation;
        private String twist;
    }

    @Getter
    public static class Fermentation {
        private Temp temp;
    }

    @Getter
    public static class Mash_temp {
        private int duration;
        private Temp temp;
    }

    @Getter
    public static class Temp {
        private String unit;
        private String value;
    }

    @Getter
    public static class Boil_volume {
        private String unit;
        private String value;
    }

    @Getter
    public static class Volume {
        private String unit;
        private String value;
    }

}
