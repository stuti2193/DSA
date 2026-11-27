import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        // Step 1: add all elements
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;
        
        // Step 2: check sequences
        for (int num : set) {
            
            // start of sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                
                // expand sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                
                longest = Math.max(longest, count);
            }
        }
        
        return longest;
    }
}