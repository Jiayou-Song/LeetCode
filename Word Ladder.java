public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        int length = 1;
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add(start);
        ArrayList<String> temp1 = new ArrayList<String>();
        Set<String> set1 = new HashSet<String>();
        set1.add(start);
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add(end);
        ArrayList<String> temp2 = new ArrayList<String>();
        Set<String> set2 = new HashSet<String>();
        set2.add(end);
        while(true) {
            if(!list1.isEmpty()) {
                for(String str: list1) {
                    for(int i=0;i<str.length();i++) {
                        char chr = str.charAt(i);
                        for(char c='a';c<='z';c++) {
                            if(c != chr) {
                                String s = str.substring(0,i) + Character.toString(c) + str.substring(i+1);
                                if(dict.contains(s) && !set1.contains(s)) {
                                    if(set2.contains(s)) {
                                        return length*2;
                                    }
                                    else {
                                        temp1.add(s);
                                        set1.add(s);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else
                return 0;
            list1 = new ArrayList(temp1);
            temp1.clear();
            if(!list2.isEmpty()) {
                for(String str: list2) {
                    for(int i=0;i<str.length();i++) {
                        char chr = str.charAt(i);
                        for(char c='a';c<='z';c++) {
                            if(c != chr) {
                                String s = str.substring(0,i) + Character.toString(c) + str.substring(i+1);
                                if(dict.contains(s) && !set2.contains(s)) {
                                    if(set1.contains(s)) {
                                        return length*2+1;
                                    }
                                    else {
                                        temp2.add(s);
                                        set2.add(s);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            list2 = new ArrayList(temp2);
            temp2.clear();
            length ++;
        }
    }
}
