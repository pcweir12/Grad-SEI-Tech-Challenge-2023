package org.solution;

public class ValidatorFactory {

    public static IValidate createValidation(String checkType) {

        switch (checkType) {
            case "spaces":
                return new ValidateNoSpace();
            case "numbers":
                return new ValidateNoNumbers();
            case "special":
                return new ValidateNoSpecialChar();
        }
        return null;
    }
}
