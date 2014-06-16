public class Solution {
    private List<String[]> solutions = new ArrayList<String[]>();
    public List<String[]> solveNQueens(int n) {
        int[] queens = new int[n];
        String[] string = new String[n];
        nQueens(n,0,string,queens);
        return solutions;
    }
    public void nQueens(int n,int col,String[] string,int[] queens) {
        for(int i=0;i<n;i++) {
            if(!conflict(col,i,queens)) {
                queens[col] = i;
                string[col] = "";
                for(int j=0;j<n;j++) {
                    if(j == i)
                        string[col] += 'Q';
                    else
                        string[col] += '.';
                }
                if(n == col+1) {
                    String[] copy = new String[n];
                    System.arraycopy(string, 0, copy, 0, n);
                    solutions.add(copy);
                }
                else
                    nQueens(n,col + 1,string,queens);
                    
            }
        }
    }
    public boolean conflict(int col, int row,int[] queens) {
        for(int i=0;i<col;i++) {
            if(queens[i] == row || col-i == Math.abs(row-queens[i])) 
                return true;
        }
        return false;
    }
}
