package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Collections;

public class Application extends Controller {

    public static Result index() {
        ObjectNode result = Json.newObject();
        result.put("stringFiled", "foobar");
        result.put("intField", Integer.valueOf(1));
        return ok(result);
    }

    @BodyParser.Of(BodyParser.Json.class)
    public static Result post() {
        JsonNode json = request().body().asJson();
        ObjectNode result = Json.newObject();
        String name = json.findPath("name").asText();
        if(name == null) {
            result.put("status", "KO");
            result.put("message", "Missing parameter [name]");
            return badRequest(result);
        } else {
            result.put("status", "OK");
            result.put("message", "Hello " + name);
            return ok(result);
        }
    }
}
