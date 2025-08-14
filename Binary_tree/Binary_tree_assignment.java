import java.util.*;

public class Binary_tree_assignment {
     public static class node {
        int data;
        node left;
        node right;

        public node(int data) {
            this.data = data;
        }
    }

    public static node insert(int val, node root) {
        if(root == null) {
            node newNode = new node(val);
            root = newNode;
            return root;
        }

        if(root.data > val) {
            root.left = insert(val, root.left);
        } else {
            root.right = insert(val, root.right);
        }

        return root;
    }
    public static void inOrder(node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void preOrder(node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //Q1 , TC - O(N)
    public static boolean isUnivalued(node root, int val) {
        if(root == null) {
            return true;
        }
        if(root.data != val) {
            return false;
        }
        return isUnivalued(root.left, val) &&
                isUnivalued(root.right, val);
    }
    //Q2 , TC - O(N)
    public static node mirrorTree(node root) {
        if(root == null) {
            return null;
        }
        
        node leftMirror = mirrorTree(root.left);
        node rightMirror = mirrorTree(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }
    
    //Q3 , TC - O(N)
    public static node deleteLeaf(node root, int x) {
        if(root == null) {
            return null;
        }

        if(root.left == null && root.right == null && root.data == x) {
            return null;
        }

        root.left = deleteLeaf(root.left, x);
        root.right = deleteLeaf(root.right, x);

         if(root.left == null && root.right == null && root.data == x) {
            return null;
        }
        return root;
    }
    //Q4 , TC - O(n) , SC - O(n)
    public static String serialize(node root, ArrayList<node> res, HashMap<String, Integer> map) {
        if(root == null) {
            return "N";
        }

        String left = serialize(root.left, res, map);
        String right = serialize(root.right, res, map);

        String serial = root.data + "," + left + "," + right;

        map.put(serial, map.getOrDefault(serial, 0) + 1);

        if(map.get(serial) == 2) {
            res.add(root);
        }

        return serial;
    }

    public static ArrayList<node> findDuplicateSubtree(node root) {
        ArrayList<node> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        serialize(root, res, map);
        return res;
    }

    public static void main(String[] args) {
        // node root = new node(1);
        // root.left = new node(2);
        // root.right = new node(3);
        // root.left.left = new node(3);
        // root.left.right = new node(4);
        // root.left.left.left = new node(3);
        // root.left.left.right = new node(3);
        // preOrder(root);
        // System.out.println();
        // // System.out.println(isUnivalued(root, root.data));
        // root = deleteLeaf(root, 3);
        // preOrder(root);
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.right.left = new node(2);
        root.right.left.left = new node(4);
        root.right.right = new node(4);
        ArrayList<node> res = findDuplicateSubtree(root);
        for(int i=0; i<res.size(); i++) {
            preOrder(res.get(i));
        }
    }
}
