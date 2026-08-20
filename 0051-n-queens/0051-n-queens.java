class Solution {
    private boolean isSafe(int row,int col,char[][] cboard,int n){
        //vertical check
        for(int i=0;i<row;i++){
            if(cboard[i][col]=='Q'){
                return false;
            }
        }
       
        //left diagnoal check
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(cboard[i][j]=='Q'){
                return false;
            }
        }
        //right diagonal check
         for(int i=row-1, j=col+1;i>=0&&j<n;i--,j++){
            if(cboard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
     public void backTracking(int row,int n,char[][] cboard,List<List<String>> res){
        if(row==n){
               List<String> currentboard = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                currentboard.add(new String(cboard[i]));
            }

            res.add(currentboard);
            return;
        }
        
        //placing the queens on the board
             for(int col=0;col<n;col++){
                if(isSafe(row,col,cboard,n)){
                    cboard[row][col]='Q';
                    backTracking(row+1,n,cboard,res);
                    cboard[row][col]='.';
                }
             }
        }
     
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char [][] cboard=new char[n][n];
        for(char c[]:cboard){
            Arrays.fill(c,'.');
        }
        backTracking(0,n,cboard,res);
        return res;
    }
}