class Solution {
    static int[] parent;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        for (int i = 0; i <= n-1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i <= n-1; i++) {
            for (int j = i + 1; j <= n-1; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        HashSet<Integer> distinct = new HashSet<Integer>();
        for (int i = 0; i <= n-1; i++) {
            distinct.add(find(i));
        }
        return distinct.size();
    }

    static int find(int node) {
        if (parent[node] == node) {
            return parent[node];
        }

        parent[node] = find(parent[node]);
        return parent[node];
    }

    static void union(int a, int b) {
        int c = find(a), d = find(b);
        if (c == d) {
            return;
        }

        parent[d] = c;
    }
}
