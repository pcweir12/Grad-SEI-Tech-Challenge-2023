package org.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorFactoryTest {

    String createSpaceValidator, createNumbValidator, createSpecialValidator, createNull;

    @BeforeEach
    void setUp() {
        createSpaceValidator = "spaces";
        createNumbValidator = "numbers";
        createSpecialValidator = "special";
        createNull = "other";
    }

    @Test
    void testCreateValidationSpaces() {
        IValidate validator = ValidatorFactory.createValidation(createSpaceValidator);
        assertTrue(validator instanceof ValidateNoSpace);
    }

    @Test
    void testCreateValidationNumbers() {
        IValidate validator = ValidatorFactory.createValidation(createNumbValidator);
        assertTrue(validator instanceof ValidateNoNumbers);
    }

    @Test
    void testCreateValidationSpecial() {
        IValidate validator = ValidatorFactory.createValidation(createSpecialValidator);
        assertTrue(validator instanceof ValidateNoSpecialChar);
    }

    @Test
    void testCreateValidationNull() {
        IValidate validate = ValidatorFactory.createValidation(createNull);
        assertNull(validate);
    }
}