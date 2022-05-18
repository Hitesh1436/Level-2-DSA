// ========================Vertical Order ===================================== 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    class Pair implements Comparable<Pair> {
        TreeNode node;
        int w;
        int d;

        Pair(TreeNode node, int w, int d) {
            this.node = node;
            this.w = w;
            this.d = d;
        }

        // this - other means increasing
        // other - this means decreasing
        public int compareTo(Pair other) {
            if (this.d == other.d) {
                return this.node.val - other.node.val; // agr depth brabr h toh value ke basis pr sort kro
            } else {
                return this.d - other.d; // agr depth alag h toh depth ke basis pr sort krdo
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root, 0, 1));

        int lmw = 0, rmw = 0; // leftMost width and rightMost Width

        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        while (qu.size() > 0) {
            Pair rem = qu.remove();

            if (rem.w < lmw) {
                lmw = rem.w;
            }
            if (rem.w > rmw) {
                rmw = rem.w;
            }

            if (map.containsKey(rem.w) == false) {
                map.put(rem.w, new ArrayList<>());
                map.get(rem.w).add(rem);
            } else {
                map.get(rem.w).add(rem);
            }
            if (rem.node.left != null) {
                qu.add(new Pair(rem.node.left, rem.w - 1, rem.d + 1));
            }
            if (rem.node.right != null) {
                qu.add(new Pair(rem.node.right, rem.w + 1, rem.d + 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int width = lmw; width <= rmw; width++) {
            ArrayList<Integer> al = new ArrayList<>();
            ArrayList<Pair> unsortedList = map.get(width);
            Collections.sort(unsortedList);

            for (Pair temp : unsortedList) {
                al.add(temp.node.val);
            }
            ans.add(al);
        }
        return ans;
    }
}