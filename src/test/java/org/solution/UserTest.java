package org.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    String name, word1, word2, anagramResult;

    @BeforeEach
    void setUp() {
        user = new User();
        name = "John";
        word1 = "friend";
        word2 = "finder";
        anagramResult = "Anagram";
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(user);
    }

    @Test
    void testGetName() {
        user.setName(name);
        assertEquals(name, user.getName());
    }

    @Test
    void testGetWord1() {
        user.setWord1(word1);
        assertEquals(word1, user.getWord1());
    }

    @Test
    void testGetWord2() {
        user.setWord2(word2);
        assertEquals(word2, user.getWord2());
    }

    @Test
    void testGetAnagramResult() {
        user.setAnagramResult(anagramResult);
        assertEquals(anagramResult, user.getAnagramResult());
    }

    @Test
    void testConstructorWithArgs() {
        User user2 = new User(name, word1, word2, anagramResult);

        assertEquals(name, user2.getName());
        assertEquals(word1, user2.getWord1());
        assertEquals(word2, user2.getWord2());
        assertEquals(anagramResult, user2.getAnagramResult());
    }

}