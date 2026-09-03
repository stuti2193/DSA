class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int digit = num & 15; 

            if (digit < 10) {
                sb.append((char)('0' + digit));
            } else {
                sb.append((char)('a' + digit - 10));
            }

            num = num >>> 4;  
        }

        return sb.reverse().toString();
    }
}