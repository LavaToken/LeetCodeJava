/*
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
*/

class Solution {
    public int romanToInt(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                count++;
            }else if(s.charAt(i) == 'V'){
                count += 5;
            }else if(s.charAt(i) == 'X'){
                count += 10;
            }else if(s.charAt(i) == 'L'){
                count += 50;
            }else if(s.charAt(i) == 'C'){
                count += 100;
            }else if(s.charAt(i) == 'D'){
                count += 500;
            }else if(s.charAt(i) == 'M'){
                count += 1000;
            }
        }
        return count;
    }
}