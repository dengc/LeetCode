//84. Largest Rectangle in Histogram
//

public class Solution {
    public int largestRectangleArea(int[] h) {
        int l = h.length;
        int max = 0;
        int[] stack = new int[l + 1];
        int is = -1;
        for (int i = 0; i <= l; i++) {
            int height = (i == l) ? 0 : h[i];
            while (is != -1 && height < h[stack[is]]) {
                int hh = h[stack[is--]];
                int width = (is == -1) ? i : i - 1 - stack[is];
                max = Math.max(max, hh * width);
            }
            stack[++is] = i;
        }
        return max;
    }
}