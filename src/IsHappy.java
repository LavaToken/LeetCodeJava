class IsHappy {
    public boolean isHappy(int n) {
        if(n == 1 || n == 7){
            return true;
        }
        int sum = n;
        int num = n;
        int i = 0;
        while(sum != 1){
            if(i > 9){
                return false;
            }
            num = sum;
            sum = 0;
            while(num > 0){
                sum += Math.pow(num % 10, 2);
                num /= 10;
            }
            i++;
        }
        return true;
    }
}