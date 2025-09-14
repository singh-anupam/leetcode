class Solution {
    public int majorityElement(int[] nums) {
       int maj=-1;
       int cnt =0;
       for(int i=0;i<nums.length;i++){
        if(cnt==0){
            maj =nums[i];
            cnt++;
        }else if(nums[i]==maj){
            cnt++;
        }else{
            cnt--;
        }
       }
       return maj;
        
    }
}