// 3348. Smallest Divisible Digit Product II
// https://leetcode.com/problems/smallest-divisible-digit-product-ii/

package Leetcode;

public class SmallestDivisibleDigitProduct2 {
    public static void main(String[] args) {
        String num1 = "1234"; long t1 = 256;
        String expected1 = "1488", actual1 = smallestNumer(num1, t1);
        System.out.println("Expected: " + expected1 + ", Actual: " + actual1);

        String num2 = "12355"; long t2 = 50;
        String expected2 = "12355", actual2 = smallestNumer(num2, t2);
        System.out.println("Expected: " + expected2 + ", Actual: " + actual2);
    }
    public static String smallestNumer(String num, long t) {
        int[][] FACTORS = {
            {0,0,0,0}, {0,0,0,0}, {1,0,0,0}, {0,1,0,0}, {2,0,0,0},
            {0,0,1,0}, {1,1,0,0}, {0,0,0,1}, {3,0,0,0}, {0,2,0,0}
        };
        int[] twoThreeDigits = {2,3,4,6,8,9};

        int e2=0,e3=0,e5=0,e7=0;
        long tt = t;
        while (tt % 2 == 0) { tt/=2; e2++; }
        while (tt % 3 == 0) { tt/=3; e3++; }
        while (tt % 5 == 0) { tt/=5; e5++; }
        while (tt % 7 == 0) { tt/=7; e7++; }
        if (tt != 1) return "-1";

        int[][] minDigits = new int[e2+1][e3+1];
        for (int a=0;a<=e2;a++){
            for (int b=0;b<=e3;b++){
                if (a==0 && b==0) { minDigits[a][b]=0; continue; }
                int best = Integer.MAX_VALUE;
                for (int d: twoThreeDigits) {
                    int pa = Math.max(0, a-FACTORS[d][0]);
                    int pb = Math.max(0, b-FACTORS[d][1]);
                    if (pa==a && pb==b) continue;
                    best = Math.min(best, 1+minDigits[pa][pb]);
                }
                minDigits[a][b]=best;
            }
        }

        int n = num.length();

        int firstZeroIndex = n;
        for (int i=0;i<n;i++){ if(num.charAt(i)=='0'){ firstZeroIndex=i; break; } }
        if (firstZeroIndex==n) {
            int r2=e2,r3=e3,r5=e5,r7=e7;
            for (int i=0;i<n;i++){
                int d = num.charAt(i)-'0';
                r2=Math.max(0,r2-FACTORS[d][0]);
                r3=Math.max(0,r3-FACTORS[d][1]);
                r5=Math.max(0,r5-FACTORS[d][2]);
                r7=Math.max(0,r7-FACTORS[d][3]);
            }
            if (r2==0&&r3==0&&r5==0&&r7==0) return num;
        }

        int[] pr2=new int[n+1], pr3=new int[n+1], pr5=new int[n+1], pr7=new int[n+1];
        pr2[0]=e2; pr3[0]=e3; pr5[0]=e5; pr7[0]=e7;
        for (int i=0;i<n;i++){
            if (i<firstZeroIndex) {
                int d = num.charAt(i)-'0';
                pr2[i+1]=Math.max(0,pr2[i]-FACTORS[d][0]);
                pr3[i+1]=Math.max(0,pr3[i]-FACTORS[d][1]);
                pr5[i+1]=Math.max(0,pr5[i]-FACTORS[d][2]);
                pr7[i+1]=Math.max(0,pr7[i]-FACTORS[d][3]);
            } else {
                pr2[i+1]=pr2[i]; pr3[i+1]=pr3[i]; pr5[i+1]=pr5[i]; pr7[i+1]=pr7[i];
            }
        }

        String result = null;
        for (int i=n-1;i>=0 && result==null;i--){
            if (i>firstZeroIndex) continue;
            int rb2=pr2[i], rb3=pr3[i], rb5=pr5[i], rb7=pr7[i];
            int space = n-1-i;
            int curDigit = num.charAt(i)-'0';
            for (int d=curDigit+1; d<=9; d++){
                int a2=Math.max(0,rb2-FACTORS[d][0]);
                int a3=Math.max(0,rb3-FACTORS[d][1]);
                int a5=Math.max(0,rb5-FACTORS[d][2]);
                int a7=Math.max(0,rb7-FACTORS[d][3]);
                int need = a5+a7+minDigits[Math.min(a2,e2)][Math.min(a3,e3)];
                if (need<=space){
                    StringBuilder sb = new StringBuilder();
                    int cr2=a2, cr3=a3, cr5=a5, cr7=a7, left=space;
                    while (left>0){
                        for (int dd=1; dd<=9; dd++){
                            int n2=Math.max(0,cr2-FACTORS[dd][0]);
                            int n3=Math.max(0,cr3-FACTORS[dd][1]);
                            int n5=Math.max(0,cr5-FACTORS[dd][2]);
                            int n7=Math.max(0,cr7-FACTORS[dd][3]);
                            int needAfter = n5+n7+minDigits[Math.min(n2,e2)][Math.min(n3,e3)];
                            if (needAfter <= left-1){
                                sb.append((char)('0'+dd));
                                cr2=n2;cr3=n3;cr5=n5;cr7=n7;
                                left--;
                                break;
                            }
                        }
                    }
                    result = num.substring(0,i) + (char)('0'+d) + sb;
                    break;
                }
            }
        }
        if (result != null) return result;

        int needFull = e5+e7+minDigits[e2][e3];
        int k = Math.max(n+1, needFull);
        StringBuilder sb = new StringBuilder();
        int cr2=e2,cr3=e3,cr5=e5,cr7=e7,left=k;
        while (left>0){
            for (int dd=1; dd<=9; dd++){
                int n2=Math.max(0,cr2-FACTORS[dd][0]);
                int n3=Math.max(0,cr3-FACTORS[dd][1]);
                int n5=Math.max(0,cr5-FACTORS[dd][2]);
                int n7=Math.max(0,cr7-FACTORS[dd][3]);
                int needAfter = n5+n7+minDigits[Math.min(n2,e2)][Math.min(n3,e3)];
                if (needAfter <= left-1){
                    sb.append((char)('0'+dd));
                    cr2=n2;cr3=n3;cr5=n5;cr7=n7;
                    left--;
                    break;
                }
            }
        }
        return sb.toString();
    }
}