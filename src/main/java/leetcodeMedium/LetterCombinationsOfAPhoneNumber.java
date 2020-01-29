package leetcodeMedium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public HashMap<String, String> phoneNumberToLetters = new HashMap<String, String>() {{

        phoneNumberToLetters.put("2", "abc");
        phoneNumberToLetters.put("3", "def");
        phoneNumberToLetters.put("4", "ghi");
        phoneNumberToLetters.put("5", "jkl");
        phoneNumberToLetters.put("6", "mno");
        phoneNumberToLetters.put("7", "pqrs");
        phoneNumberToLetters.put("8", "tuv");
        phoneNumberToLetters.put("9", "wxyz");
    }};

    List<String> output = new LinkedList<>();

    public List<String> letterCombinations(String digits) {

        backTrack("", digits);
        return output;
    }

    public void backTrack(String combination, String nextDigit) {

        // if there is no more digits to check
        if (nextDigit.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map the next available digit
            String digit = nextDigit.substring(0, 1);
            String letters = phoneNumberToLetters.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phoneNumberToLetters.get(digit).substring(i, i + 1);
                // append the current letter to the combination and proceed to the next digits
                backTrack(combination + letter, nextDigit.substring(1));
            }
        }
    }

    public static void main(String[] args) {

        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();

        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("23"));
    }
}
