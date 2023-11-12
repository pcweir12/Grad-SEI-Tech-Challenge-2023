package org.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnagramUtilMethodsTest {

    ArrayList<User> emptyCache;
    ArrayList<User> populatedCache;
    User userA;
    String nameA, nameB, wordA, wordB, wordC, wordD, resultsA, resultB;


    @BeforeEach
    void setUp() {
        emptyCache = new ArrayList<>();
        populatedCache = new ArrayList<>();
        nameA = "joe";
        nameB = "sarah";
        wordA = "wordA";
        wordB = "wordB";
        wordC = "wordC";
        wordD = "wordC";
        resultsA = "Not anagrams";
        resultB = "Anagrams";

        userA = new User(nameA, wordA, wordB, resultsA);

        populatedCache.add(userA);
    }

    @Test
    void testPopulateCache() {
        //check to confirm that cache is initially empty.
        assertTrue(emptyCache.isEmpty());

        /*Populate cache and ensure it contains the expected value.
          to pass, this test requires AnagramList.csv to contain
          results.
        */
        AnagramUtilMethods.populateCache(emptyCache);
        assertFalse(emptyCache.isEmpty());
    }

    @Test
    void testIsDuplicateEntry() {
        //Check duplicate combinations. True is returned from isDuplicateEntry.
        assertTrue(AnagramUtilMethods.isDuplicateEntry(populatedCache, nameA, wordA, wordB));
        assertTrue(AnagramUtilMethods.isDuplicateEntry(populatedCache, nameA, wordB, wordA));

        //Check non-duplicate i.e. false is returned from isDuplicateEntry.
        assertFalse(AnagramUtilMethods.isDuplicateEntry(populatedCache, nameA, wordB, wordD));
    }

    @Test
    void anagramCheck() {
        //Not anagrams
        assertEquals(resultsA, AnagramUtilMethods.anagramCheck(wordA, wordB));

        //Anagrams
        assertEquals(resultB, AnagramUtilMethods.anagramCheck(wordC, wordD));

    }
}