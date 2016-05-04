import java.util.HashMap;
import java.util.Set;

public class StringScramble { 
    public StringScramble(){
        
    }
    /* Helper for using HashMap*/
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
        
        /* s1, s2 both length <= 3, same characters with different permutation*/
        if(s1.length() <= 3){
            return true;
        }
        
        /* Refresh*/
        count.clear();
        
        /*Splitting the string from left hand side*/
        boolean allzero=false;
        for(int i = 0; i < s1.length(); i++){
            add(count,s1.charAt(i),1);
            add(count,s2.charAt(i),-1);
            allzero = true;
            for(char test : count.keySet()){
                if(count.get(test) != 0){
                    allzero = false;
                    break;
                }
            }
            if(allzero){
                if(isScramble(s1.substring(i+1),s2.substring(i+1))){
                    return true;
                }
            }
            
        }
        
        return false; 
    } 
    public static void main(String args[]){
       StringScramble SAMPLE=new StringScramble();
       System.out.println(SAMPLE.isScramble("123123","456biaklsd"));
       System.out.println(SAMPLE.isScramble("asdf","asdg"));
       System.out.println(SAMPLE.isScramble("asdfghj","asdfjgh"));
    }
}