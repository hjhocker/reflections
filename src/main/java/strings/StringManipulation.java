package strings;

public class StringManipulation {

    public String reverse(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i=str.length()-1;i>=0;i--) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
    
    public boolean isPlanindrome(String str) {
         return str.equals(reverse(str));
    }
    
}
