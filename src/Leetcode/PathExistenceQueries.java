import java.util.Arrays;

// 3534. Path Existence Queries in a Graph II
// https://leetcode.com/problems/path-existence-queries-in-a-graph-ii/description/
public class PathExistenceQueries {
    public static void main(String[] args){
        PathExistenceQueries pathExistenceQueries = new PathExistenceQueries();
        int[] nums = {1, 8, 3, 4, 2};
        int maxDiff = 3;
        int[][] queries = {{0, 3}, {2, 4}};
        int[] results = pathExistenceQueries.pathExistenceQueries(5, nums, maxDiff, queries);
        System.out.println(Arrays.toString(results));
    }

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries){
        // 1. Sort node indices by value
        Integer[] orderBoxed = new Integer[n];
        for (int i = 0; i < n; i++) orderBoxed[i] = i;
        Arrays.sort(orderBoxed, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] order = new int[n];
        int[] val = new int[n];
        int[] pos = new int[n]; // original node id -> sorted position
        for (int sp = 0; sp < n; sp++) {
            order[sp] = orderBoxed[sp];
            val[sp] = nums[order[sp]];
            pos[order[sp]] = sp;
        }

        // 2. Component ids based on consecutive gaps
        int[] comp = new int[n];
        int cid = 0;
        for (int i = 1; i < n; i++) {
            if (val[i] - val[i - 1] > maxDiff) cid++;
            comp[i] = cid;
        }

        // 3. Farthest reachable position in one hop (two-pointer)
        int[] nxt = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            j = Math.max(j, i);
            while (j + 1 < n && comp[j + 1] == comp[i] && val[j + 1] - val[i] <= maxDiff) {
                j++;
            }
            nxt[i] = j;
        }

        // 4. Binary lifting table
        int LOG = Math.max(1, 32 - Integer.numberOfLeadingZeros(Math.max(n, 1)));
        int[][] up = new int[LOG][n];
        up[0] = nxt.clone();
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        // 5. Answer queries
        int q = queries.length;
        int[] answer = new int[q];
        for (int idx = 0; idx < q; idx++) {
            int u = queries[idx][0], v = queries[idx][1];
            int pu = pos[u], pv = pos[v];
            if (comp[pu] != comp[pv]) {
                answer[idx] = -1;
            } else {
                int lo = Math.min(pu, pv), hi = Math.max(pu, pv);
                answer[idx] = minHops(up, LOG, lo, hi);
            }
        }
        return answer;
    }

    private int minHops(int[][] up, int LOG, int lo, int hi) {
        if (lo == hi) return 0;
        int cur = lo, count = 0;
        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][cur] < hi) {
                cur = up[k][cur];
                count += (1 << k);
            }
        }
        return count + 1;
    }
}
