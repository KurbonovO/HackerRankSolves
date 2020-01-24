package leetcodeEasy;

public class ValidPalindrome {

    public static boolean validPalindrome(String input) {

        System.out.println(input);

        StringBuilder sb = new StringBuilder();

        char[] charOfInput = input.toCharArray();

        for (int i = charOfInput.length - 1; i >= 0; i--) {

            sb.append(charOfInput[i]);
        }

        System.out.println(sb.toString());

        if (input.trim().equals(sb.toString())) {

            return true;

        } else {

            return false;
        }
    }

    public static boolean validPalindromeLeetCode(String input) {

        char[] inputInCharArr = input.toCharArray();
        for (int i = 0, j = inputInCharArr.length - 1; i < j; ) {

            if (!Character.isLetterOrDigit(inputInCharArr[i])) {

                i++;

            } else if (!Character.isLetterOrDigit(inputInCharArr[j])) {

                j--;

            } else if (Character.toLowerCase(inputInCharArr[i++]) != Character.toLowerCase(inputInCharArr[j--])) {

                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(validPalindrome("A man, a plan, a canal: Panama"));
    }
}
