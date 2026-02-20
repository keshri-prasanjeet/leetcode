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
    List<String> serializedData;
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serializedData = new ArrayList<>();
        preOrderSerializeree(root);
        return String.join(",", serializedData);
    }

    private void preOrderSerializeree(TreeNode node){
        if(node == null){
            serializedData.add("NULL");
            return;
        }
        serializedData.add(String.valueOf(node.val));
        preOrderSerializeree(node.left);
        preOrderSerializeree(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splitData = data.split(",");
        if(splitData.length == 0) return null;
        return preOrderDeserializer(splitData);
    }

    private TreeNode preOrderDeserializer(String[] data){
        if(data[index].equals("NULL")){
            index++;
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(data[index++]));
        newNode.left = preOrderDeserializer(data);
        newNode.right = preOrderDeserializer(data);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));