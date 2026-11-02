public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Move from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If current digit is less than 9, just add 1 and we are done
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If it's 9, it becomes 0 and the loop carries over to the next index
            digits[i] = 0;
        }

        // If we are here, it means all digits were 9 (e.g., 999 -> 1000)
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        // The rest of the array defaults to 0 in Java, so no need to fill them
        return newNumber;
    }
}