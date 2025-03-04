import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start ");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.left.left = new TreeNode(7);
        root.left.right.left.left.left = new TreeNode(8);

        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(9);
        root.right.right.right.right = new TreeNode(15);
        List<Integer> result = getTopDownView(root);
        for(int i : result) {
            System.out.print(i + " ");
        }

    }

    public static List<Integer> getTopDownViewBFS(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{ root , 0 });

        while(!queue.isEmpty()) {
            Object[] curr = queue.poll();
            TreeNode currNode = (TreeNode) curr[0];
            Integer currIndex = (Integer) curr[1];
            map.putIfAbsent(currIndex, currNode.val);

            if(currNode.left != null) {
                queue.offer(new Object[]{ currNode.left , currIndex - 1 });
            }

            if( currNode.right != null) {
                queue.offer(new Object[]{ currNode.right , currIndex + 1 });
            }
        }

        int minIndex = Collections.min(map.keySet());
        for(int i = minIndex ; map.containsKey(i) ; i++ ) {
            result.add(map.get(i));
        }
        return result;
    }


    public static List<Integer> getTopDownView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        helper(root , 0 , map);
        int minIndex = Collections.min(map.keySet());
        for(int i = minIndex ; map.containsKey(i) ; i++ ) {
            result.add(map.get(i));
        }
        return result;
    }

    public static void helper(TreeNode root, int index, Map<Integer, Integer> map )
    {
        if(root != null) {
            map.putIfAbsent(index, root.val);
            helper(root.left, index - 1, map);
            helper(root.right, index + 1, map);
        }
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
