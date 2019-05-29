import com.sebastian_daschner.japan_tour.MascotsResource;
import org.junit.jupiter.api.Test;

import static javax.json.Json.createValue;
import static org.assertj.core.api.Assertions.assertThat;

public class MascotsResourceTest {

    private final MascotsResource resource = new MascotsResource();

    @Test
    void test() {
        assertThat(resource.mascots()).containsExactly(
                createValue("Duke"),
                createValue("Kumamon"),
                createValue("Totoro"));
    }

}
