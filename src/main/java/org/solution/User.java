package org.solution;


public class User {

    //Instance vars
    private String name;
    private String word1;
    private String word2;
    private String anagramResult;

    //Constructors

    /**
     * Default constructor with no args
     */
    public User() {
    }

    /**
     * Constructor with no args
     *
     * @param name          the name of the current user.
     * @param word1         the first input word of the user.
     * @param word2         the second input word of the user.
     * @param anagramResult the result of the anagram check.
     */
    public User(String name, String word1, String word2, String anagramResult) {
        this.name = name;
        this.word1 = word1;
        this.word2 = word2;
        this.anagramResult = anagramResult;
    }

    //Methods

    /**
     * Getter for the user's name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for user's name.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the first word.
     *
     * @return word1
     */
    public String getWord1() {
        return word1;
    }

    /**
     * Setter for the first word.
     *
     * @param word1
     */
    public void setWord1(String word1) {
        this.word1 = word1;
    }

    /**
     * Getter for the second word.
     *
     * @return word2
     */
    public String getWord2() {
        return word2;
    }

    /**
     * Setter for the second word
     *
     * @param word2
     */
    public void setWord2(String word2) {
        this.word2 = word2;
    }

    /**
     * Getter for the anagram check result.
     *
     * @return anagramResult
     */
    public String getAnagramResult() {
        return anagramResult;
    }

    /**
     * Setter for the anagram check result.
     *
     * @param anagramResult
     */
    public void setAnagramResult(String anagramResult) {
        this.anagramResult = anagramResult;
    }
}
