class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0;
        int j=0;
        int cnt=0;
        while(i<players.length&&j<trainers.length){
            if(players[i]<=trainers[j]){
            i++;
            j++;
            cnt++;
            }
            else{
                j++;
            }
        }
        return cnt;
    }
}