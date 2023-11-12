package org.solution;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class holds the utility methods to be used within the main AnagramCheckerApp class.
 */
public class AnagramUtilMethods {

    //Constants
    //Storage file name
    private static final String STORAGE_FILE = "AnagramList.csv";

    /**
     * This method is used to check if the storage file exists.
     * If no file exists, then this method will create a new file
     * with the name AnagramList.csv.
     */
    public static void storageFileCheck() {
        File file = new File(STORAGE_FILE);

        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("Name, Text Value 1, Text Value 2, Result \n");
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * This method populates the cache ArrayList with previous entries that are stored in the long term file storage.
     *
     * @param cache the ArrayList which will act as the cache of previous entries.
     */
    public static void populateCache(ArrayList<User> cache) {
        File file = new File(STORAGE_FILE);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //Reading the first line to clear the headings
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();

            while (line != null) {
                //Assign users variables to a String array
                String[] userVars = line.split(",");

                //Create users and add to Cache
                User user = new User(userVars[0], userVars[1], userVars[2], userVars[3]);
                cache.add(user);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (Exception e) {
            System.out.println("Error populating cache.");
        }
    }

    /**
     * This method checks the current user entry against the user's previous entries in cache.
     * If a duplicate entry is found the user is alerted of this and of the result.
     *
     * @param cache the cache of previous entries.
     * @param name  the current user's name.
     * @param word1 the current user's first input word.
     * @param word2 the current user's second input word.
     * @return true if the entry is a duplicate, false if not.
     */
    public static boolean isDuplicateEntry(ArrayList<User> cache, String name, String word1, String word2) {
        for (User u : cache) {
            //This check is case-sensitive
            if (u.getName().equals(name)) {
                //checking for duplicates
                if ((u.getWord1().equalsIgnoreCase(word1) && u.getWord2().equalsIgnoreCase(word2) || (u.getWord1().equalsIgnoreCase(word2) && u.getWord2().equalsIgnoreCase(word1)))) {
                    //if duplicate entry, then get result and make user aware of previous entry and result.
                    System.out.println("You have previously checked these words and they were " + u.getAnagramResult() + " of each other. Please try again...");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method determines if two words are an anagram of each other and returns the result as string value.
     *
     * @param word1 the first input word of the user.
     * @param word2 the second input word of the user.
     * @return result
     */
    public static String anagramCheck(String word1, String word2) {
        String result;
        //Convert all characters to lower case
        String word1Lower = word1.toLowerCase();
        String word2Lower = word2.toLowerCase();

        //Store text values as char arrays
        char[] charArray1 = word1Lower.toCharArray();
        char[] charArray2 = word2Lower.toCharArray();

        //Sort arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        //check for anagram and return result
        if (Arrays.equals(charArray1, charArray2)) {
            result = "Anagrams";
        } else {
            result = "Not anagrams";
        }
        return result;
    }

    /**
     * Method appends the data entry to a long term file storage ("AnagramList.csv").
     *
     * @param dataEntry the string containing the user's inputs and the anagram check result.
     */
    public static void addToFileStorage(String dataEntry) {

        try {
            File file = new File(STORAGE_FILE);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(dataEntry + "\n");

            // Closing resources
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (Exception e) {
            System.out.println("Error.");
        }
    }
}
