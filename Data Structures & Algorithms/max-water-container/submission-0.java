class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;
        while (l < r) {
            int height = Math.min(heights[l], heights[r]);
            int area = (r - l) * height;
            maxArea = area > maxArea ? area : maxArea;
            System.out.println("area between heights["+l+"]= "+heights[l] +" and heights[" +r+ "]= " + heights[r] + " is: " + area);
            r--;
            if (l == r) {
                l++;
                r = heights.length - 1;
            }
        }
        return maxArea;

    }
}
