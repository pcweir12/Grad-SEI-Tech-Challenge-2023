# Grad-SEI-Tech-Challenge-2023

## Intorduction:
This program is an anagram checker app, designed to check whether a user's two input words are anagrams of each other.
The program will prompt the user for their name and their choice of two words, it validates these input values ensuring no spaces, numbers, or special characters. The user's entry is checked against a cache memory (cache memory is an ArrayList that is populated from a long-term storage file (AnagramList.csv) on program startup), to determine if the entry is a duplicate entry for that user. If the entry is novel, the program then determines if the user's words are anagrams and displays the results to the user in the console. The user's entry and the associated result are then appended to the long-term storage file as a string and a User object is created and added to the cache memory. Finally, the program will prompt the user if they wish to try another entry, and the program will continue to run util the user decides to exit.   

## How to Run
To run the Anagram Checker Application:
Open the project in a Java development environment.
Locate the AnagramCheckerApp class in the org.solution package.
Run the main method in the AnagramCheckerApp class.

## Assumptions:
Users' names are treated as case sensitive. Therefore, John and john will be treated as separate users. 
The anagram checker is case insensitive e.g., act and CAT would be classified as anagrams.
