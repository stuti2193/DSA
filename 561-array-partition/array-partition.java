import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {

        // Sort the array
        Arrays.sort(nums);

        int sum = 0;

        // Add every first element of each pair
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}