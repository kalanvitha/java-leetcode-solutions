class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int prices=0;
        int n=costs.length/2;
        Arrays.sort(costs,(a,b)->
         (a[0]-a[1])-(b[0]-b[1])
        );
        for(int i=0;i<costs.length;i++){
            if(i<n){
                prices+=costs[i][0];
            }else{
                prices+=costs[i][1];
            }
        }
        return prices;
    }
}