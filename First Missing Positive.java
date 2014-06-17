public class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i=0;i<A.length;i++) {
            if(A[i] > 0 && A[i] <= A.length && A[A[i]-1] != A[i]) {
                if(A[i] == i+1)
                    continue;
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
                i--;
            }
        }
        for(int i=0;i<A.length;i++) {
            if(A[i] != i+1)
                return i+1;
        }
        return A.length+1;
    }
}
