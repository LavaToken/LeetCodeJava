class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[] currentArray = new int[matrix[0].length];
        int max = 0;
        for(int rows = 0; rows < matrix.length; rows++){
            for(int cols = 0; cols < matrix[rows].length; cols++){
                if(matrix[rows][cols] == '1'){
                    currentArray[cols]++;
                } else {
                    currentArray[cols] = 0;
                }
            }
        }
    }
}

// int max = 0;
//         int count = 0;

//         for(int row = 0; row < matrix.length; row++){
//             for(int cols = 0; cols < matrix[row].length; cols++){
//                 currentArray[cols] += matrix[row][cols] - '0';
//             }
//         }
        
//         for(int curr = 0; curr < currentArray.length; curr++){
//             if(currentArray[curr] >= 0){
//                 count += currentArray[curr];
//                 if(count > max){
//                     max = count;
//                 }
//             }
//             if(currentArray[curr] == 0){
//                 count = 0;
//             }
//         }
//         return max;