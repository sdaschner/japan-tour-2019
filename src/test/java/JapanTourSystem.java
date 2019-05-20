import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class JapanTourSystem {

    private final Client client;
    private final WebTarget target;

    public JapanTourSystem() {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:9080/japan-tour/resources/mascots");
    }

    public List<String> getMascots() {
        GenericType<List<String>> listType = new GenericType<>() {
        };

        return target.request(MediaType.APPLICATION_JSON_TYPE)
                .get(listType);

    }
}
