import java.util.Arrays;

public class maxProbability {
    public static void main(String[] args){
        int[][] in1 = {{0,1},{1,2},{0,2}};
        double[] prob1 = {0.5, 0.5, 0.2};
        System.out.println(maxProb(3, in1, prob1, 0, 2));

        int[][] in2 = {{0,1},{1,2},{0,2}};
        double[] prob2 = {0.5, 0.5, 0.3};
        System.out.println(maxProb(3, in2, prob2, 0, 2));

        int[][] in3 = {{0,1}};
        double[] prob3 = {0.5};
        System.out.println(maxProb(3, in3, prob3, 0, 2));
    }

    public static double maxProb(int n, int[][] edges, double[] succProb, int start_node, int end_node){
        double[] maxProb = new double[n];
        Arrays.fill(maxProb, 0.0);
        maxProb[start_node] = 1.0;

        double[] max = new double[n];
        Arrays.fill(max, 0.0);

        boolean updated = true;
        while(updated){
            updated = false;
            for(int i = 0; i < edges.length; i++){
                int x = edges[i][0];
                int y = edges[i][1];
                double prob = succProb[i];

                if(maxProb[x] * prob > maxProb[y]){
                    maxProb[y] = maxProb[x] * prob;
                    updated = true;
                }

                if(maxProb[y] * prob > maxProb[x]){
                    maxProb[x] = maxProb[y] * prob;
                    updated = true;
                }
            }
        }
        return maxProb[end_node];
    }
}