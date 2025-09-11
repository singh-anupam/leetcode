class Solution {
    public List<List<String>> solveNQueens(int n) {
      
List<List<String>> list = new ArrayList();
char[][] chess = new char[n][n];

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            chess[i][j] = '.';
        }
    }
    printNqueen(chess,0,list);
    return list;
}
public  void printNqueen(char[][] chess, int row,List<List<String>> list){
    if(row > chess.length - 1){
        list.add(tostring(chess));
        return;
    }
    
    for(int col = 0; col < chess[0].length; col++){
        if(isSafe(chess,row,col) == true){
            chess[row][col] = 'Q';
            printNqueen(chess, row + 1,list);
            chess[row][col] = '.';
        }
    }
}
public  boolean isSafe(char [][]chess, int row, int col){
    
    for(int i = 0; i < row; i++){
        if(chess[i][col] == 'Q'){
            return false;
        }
    }
    
    for(int i = row - 1, j = col - 1; i >=0 && j >= 0 ; i--,j--){
        if(chess[i][j] == 'Q'){
            return false;
        }
    }
    for(int i = row - 1, j = col + 1; i >=0 && j < chess[0].length ; i--,j++){
        if(chess[i][j] == 'Q'){
            return false;
        }
    }
    return true;
}

public  List<String> tostring(char [][] board){
    List<String>result = new ArrayList();
    
    for(char []ch: board){
        result.add(String.valueOf(ch));
    }
    return result;
}
    
}
