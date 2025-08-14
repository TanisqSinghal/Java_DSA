public class BST_assignment {
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

    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(3);
        root.left.right = new node(4);
        root.left.left.left = new node(3);
        root.left.left.right = new node(3);
        preOrder(root);
        System.out.println();
        // System.out.println(isUnivalued(root, root.data));
        root = deleteLeaf(root, 3);
        preOrder(root);
    }
}
