import java.util.List;
import java.util.ArrayList;

public class Leetcode1415{
    public static void main(String[] args) {
        System.out.println(getHappyString(3,3));
    }
    public static String getHappyString(int n, int k) {
        List<String> ans = helper(n);
        if(k>ans.size()){
            return "";
        }else{
            return ans.get(k-1);
        }
    }
    public static List<String> helper(int n) {
        List<List<String>> lol = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        lol.add(list);
        if(n==1){
            return list;
        }
        int x = 0;
        while(n>1){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<lol.get(x).size();i++){
                StringBuffer s = new StringBuffer(lol.get(x).get(i));
                if(s.charAt(s.length()-1) == 'a'){
                    s.append("b");
                    temp.add(s.toString());
                    s.delete(s.length()-1,s.length());
                    s.append("c");
                    temp.add(s.toString());
                }
                else if(s.charAt(s.length()-1) == 'b'){
                    s.append("a");
                    temp.add(s.toString());
                    s.delete(s.length()-1,s.length());
                    s.append("c");
                    temp.add(s.toString());
                }
                else {
                    s.append("a");
                    temp.add(s.toString());
                    s.delete(s.length()-1,s.length());
                    s.append("b");
                    temp.add(s.toString());
                }
            }
            lol.add(temp);
            n--;
            x++;
        }
        return lol.get(x);
    }
}