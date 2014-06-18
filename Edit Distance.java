public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0)
            return word2.length();
        if(word2.length() == 0)
            return word1.length();
        int[][] solutions = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++)
            solutions[i][0] = i;
        for(int i=0;i<=word2.length();i++)
            solutions[0][i] = i;
        for(int i=1;i<=word1.length();i++) {
            for(int j=1;j<=word2.length();j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    solutions[i][j] = solutions[i-1][j-1];
                else
                    solutions[i][j] = Math.min(Math.min(solutions[i-1][j],solutions[i][j-1])+1,solutions[i-1][j-1]+1);
            }
        }
        return solutions[word1.length()][word2.length()];
    }
}

