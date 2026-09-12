class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch != '-') {
                sb.append(Character.toUpperCase(ch));
            }
        }

        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = sb.length() - 1; i >= 0; i--) {

            if (count == k) {
                result.append('-');
                count = 0;
            }

            result.append(sb.charAt(i));
            count++;
        }

        return result.reverse().toString();
    }
}