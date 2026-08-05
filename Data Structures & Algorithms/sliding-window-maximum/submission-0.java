class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[]=new int[nums.length-k+1];
        int t=0;
        for(int i=0;i<nums.length-k+1;i++){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                max=Math.max(max, nums[j]);
            }
            ans[t++]=max;
        }
        return ans;
    }
}
