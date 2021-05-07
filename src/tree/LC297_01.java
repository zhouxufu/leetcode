package tree;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhouxufu
 */
public class LC297_01 {

    public static void main(String[] args) {
        Codec codec = new Codec();
        final TreeNode deserialize = codec.deserialize("{1,2,3,#,#,4,5,6,7}");


        codec.serialize(deserialize);
    }
}

//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 104] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 设计
// 👍 555 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        for (int i = 0; i < list.size(); i++) {
            TreeNode treeNode = list.get(i);
            if (treeNode == null) {
                continue;
            }
            list.add(treeNode.left);
            list.add(treeNode.right);
        }
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (TreeNode treeNode : list) {
            if (treeNode == null) {
                sb.append("#,");
            } else {
                sb.append(treeNode.val + ",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data.trim()) || "{}".equals(data.trim())) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(Integer.valueOf(split[0])));
        int index = 0;
        boolean left = true;
        for (int i = 1; i < split.length; i++) {
            TreeNode current = list.get(index);
            if (current==null){
                left=true;
                i--;
                index++;
                continue;
            }
            TreeNode child = null;
            if (!"#".equals(split[i])) {
                child = new TreeNode(Integer.parseInt(split[i]));
            }
            if (current != null) {
                if (left) {
                    current.left = child;
                } else {
                    current.right = child;
                }
            }
            if (!left) {
                index++;
            }
            left = !left;
            list.add(child);
        }
        return list.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
