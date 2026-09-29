class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {

        int maxGreen = 0;

        int[] velunoraxi = arrivalTime;

        for (int light : lights) {
            maxGreen = Math.max(maxGreen, light);
        }

        int answer = 0;

        for (int time : velunoraxi) {
            int r = time % period;

            if (r >= maxGreen) {
                int wait = period - r;
                answer = Math.max(answer, wait);
            }
        }

        return answer;
    }
}