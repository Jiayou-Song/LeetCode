public class Solution {
    private Map<Integer,Double> map = new HashMap<Integer,Double>();
    public double pow(double x, int n) {
        map.put(0,1.0);
        findPow(x,n);
        return map.get(n);
    }
    public void findPow(double x, int n) {
        if(n == 0)
            return;
        findPow(x,n/2);
        if(n % 2 == 0) {
            map.put(n,map.get(n/2)*map.get(n/2));
        }
        else if(n > 0) {
            map.put(n,x*map.get(n/2)*map.get(n/2));
        }
        else
            map.put(n,(1/x)*map.get(n/2)*map.get(n/2));
    }
}
