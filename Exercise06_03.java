public class Exercise06_03 { // Class name updated to match the new file name

    /**
     * Returns the reversal of a NON-NEGATIVE integer.
     * For example, reverse(456) returns 654.
     *
     * @param number The non-negative integer to reverse.
     * @return The reversed integer.
     */
    public static int reverse(int number) {
        // We only expect non-negative numbers here (handled by isPalindrome)
        int reversedNumber = 0;
        int temp = number;

        while (temp != 0) {
            // Get the last digit of the number
            int digit = temp % 10;
            
            // Build the reversed number: shift existing digits left by multiplying by 10, then add the new digit
            reversedNumber = reversedNumber * 10 + digit;
            
            // Remove the last digit from the original number
            temp /= 10;
        }

        return reversedNumber;
    }

    /**
     * Returns true if the number is a palindrome (reads the same forwards and backwards).
     * Compares the absolute value of the number with the reversal of its absolute value.
     *
     * @param number The integer to check.
     * @return True if the number is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(int number) {
        // Use Math.abs() to handle negative numbers by treating them as non-palindromic 
        // in terms of the number's sequence of digits alone.
        int absoluteNumber = Math.abs(number);
        
        // A number is a palindrome if it equals the reversal of its absolute value.
        // For example, 121 == reverse(121).
        return absoluteNumber == reverse(absoluteNumber);
    }

    /**
     * Main method to test the reverse and isPalindrome methods using hardcoded values.
     */
    public static void main(String[] args) {
        // Array of integers to test: Palindromes (121, 3333), Non-Palindromes (456, 1234), Negative (-121)
        int[] testNumbers = {121, 456, 3333, 1234, -121, 5, 0};

        System.out.println("--- Palindrome Checker Test Cases ---");
        
        for (int num : testNumbers) {
            int absoluteNum = Math.abs(num);
            int reversed = reverse(absoluteNum);
            
            String result = isPalindrome(num) ? "is a palindrome" : "is NOT a palindrome";

            System.out.println("------------------------------------");
            System.out.println("Input Number: " + num);
            System.out.println("Reversed Digits: " + reversed);
            System.out.println(num + " " + result + ".");
        }
        System.out.println("------------------------------------");
    }
}