import models.EndangeredSpecie;
import models.Sightings;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.staticFileLocation;
import static spark.route.HttpMethod.post;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
    }
}
