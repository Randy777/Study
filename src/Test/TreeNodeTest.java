package Test;

import Tools.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Tools.TreeNodeSolution.stringToTreeNode;

public class TreeNodeTest {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int sum = Integer.parseInt(line);

            int ret = new Solution().pathSum(root, sum);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
class Solution {
    public int pathSum(TreeNode root, int sum) {
        return sum;
    }
}
