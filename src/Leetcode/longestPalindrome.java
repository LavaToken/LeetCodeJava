import java.util.ArrayList;

public class longestPalindrome {
    public static void main(String[] args){
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String str){
        if(str.contains("b")){
            return "true";
        }
        return "false";
    }

    public static ArrayList<String> longestPalindromeTwo(String str){
        ArrayList<String> holder = new ArrayList<>();
        ArrayList<String> longest = new ArrayList<>();
        int count = 0;
        int maxIndexStart = 0;
        int maxIndexEnd = 0;
        int max = 0;
        for(int i = 0; i < str.length(); i++){
            if(!holder.contains(str.substring(i, i+1))){
                holder.add(str.substring(i, i+1));
                count = holder.size();
                if (count > max) {
                    max = count;
                }
            }else{
                ArrayList<String> temp = new ArrayList<>();
                int index = holder.indexOf(str.substring(i, i+1));
                for(int j = index; j < holder.size(); i++){
                    temp.add(holder.get(j));
                }
                holder = temp;
                if(holder.size() >= longest.size()){
                    longest = holder;
                }
            }
        }
        return longest;
    }
}
