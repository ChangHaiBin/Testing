import java.util.HashMap;
import java.util.Set;

public class StringScramble { 
    public StringScramble(){
        
    }
    public void add(HashMap<Character,Integer> count, char temp, int X){
        if(count.containsKey(temp)){
            int K = count.get(temp);
            count.put(temp,K+X);
        }else{
            count.put(temp,X);
        }
    }
    public boolean isScramble(String s1, String s2) {
        /* Trivial Case*/
        if(s1.length() != s2.length()){
            return false;
        }
        
        /* Test characters*/
        HashMap<Character,Integer> count=new HashMap<Character,Integer>();
        char temp = ' ';
        for(int i = 0; i < s1.length(); i++){
            temp = s1.charAt(i);
            add(count,temp,1);
            temp =s2.charAt(i);
            add(count,temp,-1);
        }
        for(char test : count.keySet()){
            if(count.get(test) != 0){
                return false;
            }
        }
        
        return true; 
    } 
    public static void main(String args[]){
       StringScramble SAMPLE=new StringScramble();
       System.out.println(SAMPLE.isScramble("123123","456biaklsd"));
       System.out.println(SAMPLE.isScramble("asdf","asdg"));
    }
}