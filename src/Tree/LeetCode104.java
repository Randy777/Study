package Tree;
import Tools.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Tools.TreeNodeSolution.stringToTreeNode;

/**
 *给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * */
public class LeetCode104 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int sum = Integer.parseInt(line);
            int ret = new Solution104().maxDepth(root);
            String out = String.valueOf(ret);
            System.out.print(out);
        }
    }
}
class Solution104 {
    public static int maxDepth(TreeNode root) {
        return 1;
    }
}
