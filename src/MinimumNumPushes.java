public class MinimumNumPushes {
    public static void main(String[] args) {
        String word1 = "abcde";
        int expected1 = 5;
        int result1 = minimumPushes(word1);
        System.out.println("Expected: " + expected1 + " Result: " + result1);

        String word2 = "xycdefghij";
        int expected2 = 12;
        int result2 = minimumPushes(word2);
        System.out.println("Expected: " + expected2 + " Result: " + result2);

        String word3 = "zyxwvutsrqponmlkjihgfedcba";
        int expected3 = 56;
        int result3 = minimumPushes(word3);
        System.out.println("Expected: " + expected3 + " Result: " + result3);

    }

    public static int minimumPushes(String word){
        int n = word.length();
        int count = 0;
        if(n > 24){
            count += (n-24)*4;
            n = 24;
        }
        if(n > 16){
            count += (n-16)*3;
            n = 16;
        }
        if(n > 8){
            count += (n-8)*2;
            n = 8;
        }
        if(n <= 8){
            count += n;
        }
        return count;
    }
}
