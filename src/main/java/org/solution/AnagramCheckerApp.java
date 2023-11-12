package org.solution;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

/**
 * App for checking user inputs as anagrams
 */
public class AnagramCheckerApp {

    // Constants
    //Check types to be passed to a validator factory class.
    private static final String NO_SPACES = "spaces";
    private static final String NO_NUMBERS = "numbers";
    private static final String NO_SPECIAL = "special";


    /**
     * This program prompts the user to input their name and two words, it then
     * validates the input to ensure it meets specific criteria. If validation
     * checks are passed the program will then check if the entry is a duplicate
     * entry for that user. If the entry is novel then the system will check if
     * the input words are anagrams, and then provide the result, and write it to file.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> cache = new ArrayList<>();
        boolean running = true;

        //Checking for the long term storage file and creating a new file if one doesn't exist.
        AnagramUtilMethods.storageFileCheck();

        //Populating cache with previous results stored in .csv file
        AnagramUtilMethods.populateCache(cache);

        do {
            try {
                String name = null;
                String word1 = null;
                String word2 = null;
                String result;
                boolean nameFlag, wordFlag;
                boolean isDuplicate = true;

                //// Creating validators for input validation
                IValidate spaceValidator = ValidatorFactory.createValidation(NO_SPACES);
                IValidate numberValidator = ValidatorFactory.createValidation(NO_NUMBERS);
                IValidate specialValidator = ValidatorFactory.createValidation(NO_SPECIAL);


                while (isDuplicate) {
                    //Validate user input
                    //Validating user's name value.
                    do {
                        nameFlag = false;
                        System.out.println("Please type your name and press enter:");
                        name = scanner.nextLine();
                        if (name.isEmpty() || !spaceValidator.isValid(name) || !numberValidator.isValid(name) || !specialValidator.isValid(name)) {
                            System.out.println("Please enter a name that does not contain spaces, numbers or special characters");
                        } else {
                            nameFlag = true;
                        }
                    } while (!nameFlag);

                    //Validating user's input values.
                    do {
                        wordFlag = false;
                        System.out.println("Please type your first word and press enter:");
                        word1 = scanner.nextLine();
                        System.out.println("Please type your second word and press enter:");
                        word2 = scanner.nextLine();

                        if (word1.isEmpty() || !spaceValidator.isValid(word1) || !numberValidator.isValid(word1) || !specialValidator.isValid(word1) || word2.isEmpty() || !spaceValidator.isValid(word2) || !numberValidator.isValid(word2) || !specialValidator.isValid(word2)) {
                            System.out.println("Please enter words that do not contain spaces, numbers or special characters");
                        } else {
                            wordFlag = true;
                        }
                    } while (!wordFlag);

                    //Check for duplicate entry.
                    isDuplicate = AnagramUtilMethods.isDuplicateEntry(cache, name, word1, word2);
                }

                //Check for anagram and notify user of result.
                result = AnagramUtilMethods.anagramCheck(word1, word2);
                if (result.equals("Anagrams")) {
                    System.out.println(word1 + " and " + word2 + " are anagrams of each other.");
                } else {
                    System.out.println(word1 + " and " + word2 + " are not anagrams of each other.");
                }

                //Writing inputs and result to file as one string.
                String dataEntry = (name + "," + word1 + "," + word2 + "," + result);
                AnagramUtilMethods.addToFileStorage(dataEntry);

                //Creating user with current inputs and result and adding to cache memory.
                User user = new User(name, word1, word2, result);
                cache.add(user);

                //Prompting user to try again.
                boolean prompting = true;
                while (prompting) {
                    System.out.println("Would you like to try again (Y or N)?");
                    String choice = scanner.nextLine().trim();
                    switch (choice.toLowerCase()) {
                        case "y":
                            System.out.println("Lets go again!");
                            prompting = false;
                            break;
                        case "n":
                            System.out.println("Goodbye!");
                            running = false;
                            prompting = false;
                            break;
                        default:
                            System.out.println("Sorry please try that again...");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Something seems to have went wrong, please try again");
            }
        } while (running);
    }


}