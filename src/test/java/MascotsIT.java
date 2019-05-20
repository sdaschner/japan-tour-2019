import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MascotsIT {

    private final JapanTourSystem japanTourSystem = new JapanTourSystem();

    @Test
    void test() {
        List<String> mascots = japanTourSystem.getMascots();

        assertThat(mascots)
                .containsExactlyInAnyOrder("Duke", "Kumamon", "Totoro");
    }

}
