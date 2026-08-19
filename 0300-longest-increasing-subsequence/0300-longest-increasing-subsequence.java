class Solution {
    public int lengthOfLIS(int[] nums) {
        int len=1;
        int n=nums.length;
        int [] tab=new int[n];
        Arrays.fill(tab,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    tab[i]=Math.max(tab[i],tab[j]+1);
                }
            }
            len=Math.max(len,tab[i]);
        }
        
        return len;
    }
}