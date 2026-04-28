class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> s = new Stack<>();
        int[] nsr = new int[heights.length];
        int[] nsl = new int[heights.length];

         for (int i = heights.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsr[i] = heights.length;
            } else {
                nsr[i]= s.peek();
            }

            s.push(i);
        }

        s.clear();

        for (int i = 0 ; i <= heights.length - 1; i++) {

            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i]= s.peek();
            }

            s.push(i);
        }

  
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = height * width;
            max = Math.max(max, area);
        }
        return max;


    }
}