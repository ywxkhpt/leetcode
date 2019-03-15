package sudoku_solver;

//需要三组数据结构 分别存储九行 九列 九个个格子的已经填充的数字
//递归加回溯
//首先进行预扫描 将board中已有的数字进行状态的设置
//然后一个一个填充单元格 填充每一个单元格的时候从1到9进行尝试 当已经使用过该数字 则跳过
//填充完一个单元格后 继续递归填充下一个单元格 当所有单元格都填充完毕后 返回true 否则返回false
public class Solution {
    boolean[][] row;//记录行的状态
    boolean[][] col;//记录列的状态
    boolean[][] ceil;//记录单元格的状态

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        row = new boolean[9][10];
        col = new boolean[9][10];
        ceil = new boolean[9][10];
        for (int i = 0; i < board.length; i++) { //预扫描 枝剪 提高效率
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int c = board[i][j] - '0';
                    row[i][c] = true;
                    col[j][c] = true;
                    int bx = i / 3;
                    int by = j / 3;
                    int cIndex = bx + by * 3;
                    ceil[cIndex][c] = true;
                }
            }
        }
        fill(board, 0, 0);
    }

    private boolean fill(char[][] board, int x, int y) { //竖向填充
        if (y == 9) return true;
        int nx = (x + 1) % 9; //下一个填充的位置
        int ny = (nx == 0) ? y + 1 : y; //下一个填充的位置
        if (board[x][y] != '.') return fill(board, nx, ny);
        int bx = x / 3;
        int by = y / 3;
        int box_key = by * 3 + bx;
        for (char c = '1'; c <= '9'; c++) {
            int loc = c - '0';
            if (!row[x][loc] && !col[y][loc] && !ceil[box_key][loc]) {
                board[x][y] = c;//设置状态
                row[x][loc] = true;
                col[y][loc] = true;
                ceil[box_key][loc] = true;
                if (fill(board, nx, ny)) return true; //因为是递归回溯 所以后面的格子全部填充完毕
                board[x][y] = '.'; //回溯 恢复状态
                row[x][loc] = false;
                col[y][loc] = false;
                ceil[box_key][loc] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        Solution solution = new Solution();
        solution.solveSudoku(board);
    }
}
