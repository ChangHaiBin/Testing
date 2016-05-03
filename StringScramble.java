public class StringScramble { 
    public StringScramble(){
        
    }
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        
        return true; 
    } 
    public static void main(String args[]){
       StringScramble SAMPLE=new StringScramble();
       System.out.println(SAMPLE.isScramble("123123","456biaklsd"));
    }
}