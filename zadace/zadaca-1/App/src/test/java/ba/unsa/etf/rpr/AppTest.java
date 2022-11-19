package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class for testing App class
 * @author Taner Bajrovic
 */
public class AppTest {

    /**
     * Passing more than one argument is not valid.
     */
    @Test
    public void passingMoreThanOneArgument() {
        String[] invalidArguments = {"( 3 + 2 ) * 6", ""};
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {App.validateConsoleInput(invalidArguments);});
        assertEquals("No arguments or more than one argument was passed.", exception.getMessage());
    }

    /**
     * Passing no arguments at all is not valid.
     */
    @Test
    public void passingNoArguments() {
        String[] noArguments = {};
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {App.validateConsoleInput(noArguments);});
        assertEquals("No arguments or more than one argument was passed.", exception.getMessage());
    }
}
