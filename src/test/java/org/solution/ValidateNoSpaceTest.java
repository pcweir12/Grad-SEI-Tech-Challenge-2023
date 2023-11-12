package org.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateNoSpaceTest {

    ValidateNoSpace validateNoSpace;
    String validInput, invalidInput;

    @BeforeEach
    void setUp() {
        validateNoSpace = new ValidateNoSpace();
        validInput = "abc";
        invalidInput = "a b c";
    }

    @Test
    void testIsValidTrue() {
        assertTrue(validateNoSpace.isValid(validInput));
    }

    @Test
    void testIsValidFalse() {
        assertFalse(validateNoSpace.isValid(invalidInput));
    }
}