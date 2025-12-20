class Solution {
    public int countBattleships(char[][] board) {
        int count =0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'){
                    dfs(board,i,j);
                    count++;
                }
            }
        }

        return count;
        
    }

    private void dfs(char arr[][], int i, int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]=='.')
        return;
        
        arr[i][j]='.';
        dfs(arr,i+1,j);
        dfs(arr,i,j+1);
        dfs(arr,i-1,j);
        dfs(arr,i,j-1);
    }
}