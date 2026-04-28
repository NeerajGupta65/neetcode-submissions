class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int buy=prices[0];
        for(int i=0;i<prices.length;i++){
            if(buy<prices[i]){
                max=Math.max(prices[i]-buy,max);
            }else{
                buy=prices[i];
            }
        }
        return max;
    }
}
