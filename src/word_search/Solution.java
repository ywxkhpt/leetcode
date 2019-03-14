package word_search;

//dfs 深度搜索 当一条路走不动时 回溯
//visited记录是否走过这条路
public class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0) && search(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board,int i,int j,String word,int length){
        if(length == word.length()) return true;
        if( i<0 || i >= board.length || j<0 || j>= board[0].length || visited[i][j] || board[i][j] != word.charAt(length)) return false;
        visited[i][j] = true;
        if(search(board,i-1,j,word,length + 1) ||
                search(board,i+1,j,word,length + 1) ||
                search(board,i,j-1,word,length + 1) ||
                search(board,i,j+1,word,length + 1)){
            return true;
        }
        visited[i][j] = false; //回溯
        return false;
    }
}
