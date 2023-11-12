package org.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateNoNumbersTest {

    ValidateNoNumbers validateNoNumbers;
    String validInput ,invalidInput;


    @BeforeEach
    void setUp() {
       validateNoNumbers = new ValidateNoNumbers();
       validInput = "abc";
       invalidInput ="abc123";
    }

    @Test
    void testIsValidTrue() {
        assertTrue(validateNoNumbers.isValid(validInput));
    }

    @Test
    void testIsValidFalse(){
        assertFalse(validateNoNumbers.isValid(invalidInput));
    }
}