class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }
        int[] count = new int[nums.length];
        count[0] = nums[0];
        count[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            count[i] = Math.max(count[i-2]+nums[i], count[i-1]);
        }
        return count[count.length-1];
    }
}