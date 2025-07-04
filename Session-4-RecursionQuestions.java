class Main {
    public static String removeXHelper(String s, int low, int high) {
        if (low>high) {
            // this means the string has 0 characters
            return "";
        }
        if (low==high) {
            // this means the string has 1 character only
            if (s.charAt(low)=='x') {
                return "";
            } else {
                return s.charAt(low)+"";
            }
        }
        String smallerProblem = s.charAt(low)+"";
        String smallerAnswer;
        if (smallerProblem.equals("x")) {
            smallerAnswer = "";
        } else {
            smallerAnswer = smallerProblem;
        }
        String biggerAnswer = removeXHelper(s, low+1, high);
        String finalAnswer = smallerAnswer + biggerAnswer;
        return finalAnswer;
    }
    public static String removeAllX(String s) {
        return removeXHelper(s, 0, s.length()-1);
    }

    public static String removeConsecutiveDuplicatesHelper(String s, int low, int high) {
        if (low>high) {
            // this means the string has 0 elements
            return "";
        }
        if (low==high) {
            // this means string has just 1 character
            return s.charAt(low)+"";
        }
        String smallerProblem = s.charAt(low)+""; // smallerProblem will be the first character which I will solve
        String smallerAnswer = smallerProblem;
        String biggerAnswer = removeConsecutiveDuplicatesHelper(s, low+1, high);
        if (smallerAnswer.charAt(0)==biggerAnswer.charAt(0)) {
            String finalAnswer = biggerAnswer;
            return finalAnswer;
        } else {
            String finalanswer = smallerAnswer + biggerAnswer;
            return finalanswer;
        }
    }
    public static String removeConsecutiveDuplicates(String s) {
        return removeConsecutiveDuplicatesHelper(s, 0, s.length()-1);
    }

    public static boolean checkPalindromeHelper(String s, int low, int high) {
        if (low>=high) {
            // this means the string is either empty with 0 characters or has character only
            return true;
        }
        if (s.charAt(low)!=s.charAt(high)) {
            boolean finalAnswer = false;
            return finalAnswer;
            // even if just 1 pair is not matching, then I can confirm that the whole string is not palindrome
        } else {
            boolean biggerAnswer = checkPalindromeHelper(s, low+1, high-1);
            // for the next function call, the string under consideration is from low+1 to high-1
            boolean finalAnswer = biggerAnswer;
            return finalAnswer;
        }
    }

    public static boolean checkPalindrome(String s) {
        return checkPalindromeHelper(s, 0, s.length()-1);
    }

    public static void main(String[] args) {
        String s = "m";
        System.out.println(checkPalindrome(s));
    }
}