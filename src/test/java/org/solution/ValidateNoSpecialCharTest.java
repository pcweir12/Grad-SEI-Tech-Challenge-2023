package org.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateNoSpecialCharTest {

    ValidateNoSpecialChar validateNoSpecialChar;
    String validInput, invalidInput;

    @BeforeEach
    void setUp() {
        validateNoSpecialChar = new ValidateNoSpecialChar();
        validInput = "abc";
        invalidInput = "abc*";
    }

    @Test
    void testIsValidTrue() {
        assertTrue(validateNoSpecialChar.isValid(validInput));
    }

    @Test
    void testIsValidFalse() {
        assertFalse(validateNoSpecialChar.isValid(invalidInput));
    }
}