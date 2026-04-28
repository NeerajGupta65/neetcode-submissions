class Solution {
    public int maxArea(int[] heights) {
        int maxwater=0;
        int l = 0;
        int r = heights.length-1;

        while(l<r){
            int h = Math.min(heights[l],heights[r]);
            int w = r-l;
            int area = h*w;
            maxwater = Math.max(maxwater,area);

            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }
    return maxwater;
    }
}
