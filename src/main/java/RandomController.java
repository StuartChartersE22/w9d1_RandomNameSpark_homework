import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class RandomController {
    public static void main(String[] args) {
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        staticFileLocation("/public");
        final ArrayList<String> maleFirstNames = new ArrayList<>();
        ArrayList<String> femaleFirstNames = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();

        maleFirstNames.add("Philip");
        maleFirstNames.add("John");
        maleFirstNames.add("Greg");
        maleFirstNames.add("Lewis");

        femaleFirstNames.add("Rachel");
        femaleFirstNames.add("Sarah");
        femaleFirstNames.add("Sophie");
        femaleFirstNames.add("Grace");

        lastNames.add("McLeaod");
        lastNames.add("Charters");
        lastNames.add("Robertson");

        get("/random_name/male/first", (req, res) -> {
            ArrayList<String> names = new ArrayList<>();
            names.add(RandomSelector.getRandomEntry(maleFirstNames));
            HashMap<String, Object> model = new HashMap<>();
            model.put("names",names);
            model.put("template", "nameGenerator.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);

        get("/random_name/female/first", (req, res) -> {
            ArrayList<String> names = new ArrayList<>();
            names.add(RandomSelector.getRandomEntry(femaleFirstNames));
            HashMap<String, Object> model = new HashMap<>();
            model.put("names",names);
            model.put("template", "nameGenerator.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);
    }
}
