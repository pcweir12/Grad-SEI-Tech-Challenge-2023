package org.solution;

/**
 * Class contains method to check for special characters in input values.
 */
public class ValidateNoSpecialChar implements IValidate {

    @Override
    public boolean isValid(String input) {
        char[] inputArray = input.toCharArray();
        for (char c : inputArray) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

}
