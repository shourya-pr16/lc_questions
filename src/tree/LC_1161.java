package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC_1161 {
    // bfs at every level and evaluate sum of elements in queue

    public static int maxLevelSum(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        int maxSum = node.val;
        queue.offer(node);
        TreeNode r;
        while (!queue.isEmpty()) {
            r = queue.poll();
            queue.offer(r.left);
            queue.offer(r.right);
        }
        return maxSum;
    }
}
