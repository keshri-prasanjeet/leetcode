/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> serializedTree = new ArrayList<>();
        preOrderSerializer(root, serializedTree);
        return String.join(",",serializedTree);
    }

    private void preOrderSerializer(TreeNode root, List<String> serializedTree){
        if(root == null){
            serializedTree.add("NULL");
            return;
        }
        serializedTree.add(String.valueOf(root.val));
        preOrderSerializer(root.left, serializedTree);
        preOrderSerializer(root.right, serializedTree);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splitData = data.split(",");
        index = 0;
        return deserializer(splitData);
    }

    private TreeNode deserializer(String[] data){
        if(data[index].equals("NULL")){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data[index++]));
        node.left = deserializer(data);
        node.right = deserializer(data);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));