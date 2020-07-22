package vip.kelvin.leetCode.w197;

import vip.kelvin.leetCode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kelvin范显
 * @date 2020/7/7 上午10:44
 */
public class Q112_hasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t.left == null && t.right == null) {
                if(t.val == sum) return true;
                continue;
            }
            if (t.left != null) {
                q.offer(t.left);
                t.val += t.left.val;
            }
            if (t.right != null) {
                q.offer(t.right);
                t.val += t.right.val;
            }
        }
        return false;
    }
}
