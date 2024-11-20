package tests.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class SkippedTests {

    @Test
    @Disabled
    void some1Test() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void some2Test() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void some3Test() {
        assertTrue(true);
    }

    @Test
    @Disabled("Some reason")
    void some4Test() {
        assertTrue(true);
    }
}
