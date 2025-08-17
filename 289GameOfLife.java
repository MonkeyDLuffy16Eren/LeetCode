class Solution {
    public void gameOfLife(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        int[][] clone = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                clone[i][j] = board[i][j];
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(clone[i][j] == 1){
                    int live = findLive(i,j,clone);
                    if(live == 2 || live==3){
                        board[i][j]=1;
                    }else{
                        board[i][j]=0;
                    }
                }else{//taking about dead shell 0.
                    if(findLive(i,j,clone) == 3){
                        board[i][j] =1;
                    }else{
                        board[i][j]=0;
                    }
                }
            }
        }
    }
    private int findLive(int i,int j,int[][] board){
        int live=0;
        if(i+1<board.length && board[i+1][j] == 1) live++;
        if(j+1<board[0].length && board[i][j+1] == 1) live++;
        if(i-1>=0 && board[i-1][j] == 1) live++;
        if(j-1>=0 && board[i][j-1] == 1) live++;
        if (i + 1 < board.length && j + 1 < board[0].length && board[i + 1][j + 1] == 1) live++;
        if (i + 1 < board.length && j - 1 >= 0 && board[i + 1][j - 1] == 1) live++;
        if (i - 1 >= 0 && j + 1 < board[0].length && board[i - 1][j + 1] == 1) live++;
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) live++;
    return live;
    }
}