public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int diff = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> values = new ArrayList<Integer>();
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++) {
            if(!values.contains(num[i])) {
                values.add(num[i]);
                int front = i+1;
                int tail = num.length-1;
                list.clear();
                list.add(num[i]);
                list.add(num[front]);
                list.add(num[tail]);
                while(front < tail) {
                    int sum = list.get(0)+list.get(1)+list.get(2);
                    if(sum == target) {
                        return sum;
                    }
                    else if(sum < target) {
                        if(target-sum < Math.abs(diff)) {
                            diff = target - sum;
                        }
                        front ++;
                        list.set(1,num[front]);
                    }
                    else {
                        if(sum-target < Math.abs(diff)) {
                            diff = target - sum;
                        }
                        tail --;
                        list.set(2,num[tail]);
                    }
                }
            }
        }
        return target-diff;
    }
}
