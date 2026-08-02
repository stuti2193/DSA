class Solution {
    public int thirdMax(int[] nums) {

        Long first = null;
        Long second = null;
        Long third = null;

        for (int num : nums) {

            // Skip duplicate values
            if ((first != null && num == first) ||
                (second != null && num == second) ||
                (third != null && num == third)) {
                continue;
            }

            if (first == null || num > first) {
                third = second;
                second = first;
                first = (long) num;
            }
            else if (second == null || num > second) {
                third = second;
                second = (long) num;
            }
            else if (third == null || num > third) {
                third = (long) num;
            }
        }

        // If third maximum doesn't exist, return the maximum
        if (third == null) {
            return first.intValue();
        }

        return third.intValue();
    }
}