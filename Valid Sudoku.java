public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean flag = true;
        for(int i=0;i<9;i++) {
            List<Character> list = new ArrayList<Character>();
            for(int j=0;j<9;j++) {
                if(board[i][j] != '.') {
                    if(list.contains(board[i][j]))
                        flag = false;
                    else
                        list.add(board[i][j]);
                }
            }
        }
        for(int j=0;j<9;j++) {
            List<Character> list = new ArrayList<Character>();
            for(int i=0;i<9;i++) {
                if(board[i][j] != '.') {
                    if(list.contains(board[i][j]))
                        flag = false;
                    else
                        list.add(board[i][j]);
                }
            }
        }
        for(int row=0;row<3;row++) {
            for(int col=0;col<3;col++) {
                List<Character> list = new ArrayList<Character>();
                for(int i=row*3;i<row*3+3;i++) {
                    for(int j=col*3;j<col*3+3;j++) {
                        if(board[i][j] != '.') {
                            if(list.contains(board[i][j]))
                                flag = false;
                            else
                                list.add(board[i][j]);
                        }
                    }
                }
            }
        }
        return flag;
    }
}
