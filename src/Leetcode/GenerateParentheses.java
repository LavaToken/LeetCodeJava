package Leetcode;
// 22. Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/description/
public class GenerateParentheses {
    public static void main(String[] args){
        GenerateParentheses generateParentheses = new GenerateParentheses();
        int n = 3;
        List<String> results = generateParentheses.generateParentheses(n);
        System.out.println(results);
    }

    public List<String> generateParentheses(int n){
        List<String> results = new ArrayList<>();
        generateParentheses(results, "", n, n);
        return results;
    }

    public void generateParentheses(List<String> results, String current, int left, int right){
        if(left == 0 && right == 0){
            results.add(current);
            return;
        }
        if(left > 0){
            generateParentheses(results, current + "(", left - 1, right);
        }
        if(right > left){
            generateParentheses(results, current + ")", left, right - 1);
        }
    }
}