class Solution {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            int low=0;
            int high=nums.length-1;
            int mid=(high+low/2);

                if(nums[i]==target){
                    return i;
                }else if(nums[i]<target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
        }
        return -1;
    }
}
