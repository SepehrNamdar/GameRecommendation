import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationShould {

    @Test
    void works() {
        Application a = new Application();

        boolean applicationIsWorking = a.isWorking();

        assertThat(applicationIsWorking).isTrue();
    }

}
