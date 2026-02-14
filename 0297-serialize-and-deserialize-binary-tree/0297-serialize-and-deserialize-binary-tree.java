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

    int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        List<String> serializedData = new ArrayList<>();
        serializer(root, serializedData);
        return String.join(",", serializedData);
    }

    private void serializer(TreeNode root, List<String> serializedData){
        if(root == null){
            serializedData.add("NULL");
            return;
        }
        serializedData.add(String.valueOf(root.val));
        serializer(root.left, serializedData);
        serializer(root.right, serializedData);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] splitData = data.split(",");
        index = 0;
        return deserializer(splitData);
    }

    private TreeNode deserializer(String[] data){
        if(data[index].equals("NULL")){
            index++;
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(data[index++]));
        newNode.left  = deserializer(data);
        newNode.right = deserializer(data);
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));