package com.sebastian_daschner.japan_tour;

import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("mascots")
public class MascotsResource {

    @GET
    public JsonArray mascots() {
        return Json.createArrayBuilder()
                .add("Duke")
                .add("Kumamon")
                .add("Totoro")
                .build();
    }

}
