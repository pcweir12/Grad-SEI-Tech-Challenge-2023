package org.solution;

/**
 * Class contains method to check for numbers in input values.
 */
public class ValidateNoNumbers implements IValidate {

    /**
     * Method validates the given input for numbers.
     *
     * @param input The input to be validated
     * @return true if input doesn't contain numbers.
     */
    @Override
    public boolean isValid(String input) {
        char[] inputArray = input.toCharArray();
        for (char c : inputArray) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
