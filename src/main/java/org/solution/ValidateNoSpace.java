package org.solution;

/**
 * Class contains method to check for spaces in input values.
 */
public class ValidateNoSpace implements IValidate {

    /**
     * Method validates the given input for white space.
     * 
     * @param input The input to be validated 
     * @return true if input doesn't contain white space.
     */
    @Override
    public boolean isValid(String input) {
        if (input.contains(" ")) {
            return false;
        }
        return true;
    }

}
