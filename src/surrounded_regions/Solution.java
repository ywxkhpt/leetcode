package surrounded_regions;

//dfs解决 从四周边界开始 碰到O深度优先遍历 并将走过的O变为*
//最后*变O  O变x
public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)  return;
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){ //第一列 最后一列
            if(board[i][0] == 'O') dfs(board,i,0);
            if(board[i][n-1] == 'O') dfs(board,i,n-1);
        }
        for(int i=0;i<n;i++){ //第一行 最后一行
            if(board[0][i] == 'O') dfs(board,0,i);
            if(board[m-1][i] == 'O') dfs(board,m-1,i);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                    continue;
                }
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                    continue;
                }
            }
        }
    }

    private void dfs(char[][] board,int i,int j){
        if(i<0 || i>= board.length || j < 0 || j>= board[0].length || board[i][j] != 'O') return;
        board[i][j] = '*';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }

    public static void main(String[] args) {
        char[][] board = {{'O'}};
        Solution solution = new Solution();
        solution.solve(board);
    }
}
