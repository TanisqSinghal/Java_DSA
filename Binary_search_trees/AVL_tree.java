public class AVL_tree {
    static class node {
        int data, height;
        node left;
        node right;

        public node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static node root;

    public static int height(node root) {
        if (root == null) {
            return 0;
        }

        return root.height;
    }

    public static int getBalance(node root) {
        if (root == null) {
            return 0;
        }

        return height(root.left) - height(root.right);
    }
    //left rotate subtree rooted with x
    public static node leftRotate(node x) {
        node y = x.right;
        node T2 = y.left;

        //perform rotation
        y.left = x;
        x.right = T2;

        //Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        //return new root
        return y;
    }
    //right rotation
    public static node rightRotate(node y) {
        node x = y.left;
        node T2 = x.right;

        //perform rotation
        x.right = y;
        y.left = T2;

        //update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        //return new root
        return x;
    }

    public static node insert(node root, int key) {
        if (root == null) {
            return new node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // duplicates are not allowed
        }

        // update the height
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // calculate balance factor
        int bf = getBalance(root);

        // Left Left case
        if (bf > 1 && key < root.left.data) {
            return rightRotate(root);
        }
        // right right case
        if (bf < -1 && key > root.right.data) {
            return leftRotate(root);
        }
        // left right case
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // right left case
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root; // return the root of AVL balanced tree
    }

    public static void preOrder(node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrder(root);
    }
}