import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        boolean[] present = new boolean[n + 1];

        // Mark the numbers that are present
        for (int num : nums) {
            present[num] = true;
        }

        List<Integer> result = new ArrayList<>();

        // Find missing numbers
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                result.add(i);
            }
        }

        return result;
    }
}