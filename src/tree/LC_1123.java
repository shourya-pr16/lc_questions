package tree;

public class LC_1123 {

    public static class Pair {
        int level;
        TreeNode node;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
    public static Pair f(TreeNode n, int currentDepth) {
        if(n == null) {
            return new Pair(-1, null);
        }

        if(n.left == null && n.right == null) {
            return new Pair(currentDepth, n);
        }

        Pair l_lca = f(n.left, currentDepth+1);
        Pair r_lca = f(n.right, currentDepth+1);

        if(l_lca.level !=- 1 && (l_lca.level == r_lca.level)) {
            return new Pair(l_lca.level, n);
        }

        return l_lca.level > r_lca.level ? l_lca : r_lca;

    }
    public static TreeNode lcaDeepestLevel(TreeNode root) {
        return f(root, 0).node;
    }

    public static void main(String[] args) {
//        TreeNode r = new TreeNode(3);
//        r.left = new TreeNode(5);
//        r.right = new TreeNode(1);
//
//        r.left.left = new TreeNode(6);
//        r.left.right = new TreeNode(2);
//        r.left.right.left = new TreeNode(7);
//        r.left.right.right = new TreeNode(4);
//
//        r.right.left = new TreeNode(0);
//        r.right.right = new TreeNode(8);
        System.out.println(lcaDeepestLevel(new TreeNode(1)).val);
    }
}
