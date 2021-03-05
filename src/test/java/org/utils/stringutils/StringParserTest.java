package org.utils.stringutils;

import org.junit.jupiter.api.Test;
import org.utils.exceptions.InvalidStringInputException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    //3-part format: methodBeingTest_inputGiven_expectedOutput
    //take note escape sequence for variable "separator"
    //run 1 of these methods to run a test
    //OR run all tests in "test" folder

    /**
     * Tests the successful case: Happy path
     */
    @Test
    void splitString_oneSeparator_expectTwoParts() throws InvalidStringInputException {
        StringParser sp = new StringParser();
        String inputString = "Hello|World";
        String separator = "\\|";
        List<String> stringParts = sp.splitString(inputString, separator);
        assertEquals(2, stringParts.size());
    }

    /**
     * Tests the case where expected input is null instead of string
     */
    @Test
    void splitString_nullInput_expectException() {
        StringParser sp = new StringParser();
        String inputString = null;
        String separator = "\\|";

        //expects object of this class, executing this anonymous function (nothing inside)
        assertThrows(InvalidStringInputException.class, () -> {
            sp.splitString(inputString, separator);
        });
    }
}
