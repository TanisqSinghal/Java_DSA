import java.util.ArrayList;

public class BST {

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

    public static boolean search(node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if(root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static node delete(node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        }
        else if(root.data > val) {
            root.left = delete(root.left, val);
        }
        else {
            //case 1 - leaf node
            if(root.left == null && root.right == null) {
                return null;
            }
            //case 2 = either node is null
            if(root.left == null) {
                return root.right;
            } else if(root.right == null){
                return root.right;
            }
            //case 3 - complete node - inorder successor case
            node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static node findInOrderSuccessor(node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(node root, int k1, int k2) {
        if(root == null) {
            return;
        }

        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    public static void printPathToLeaf(node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            print(path);
        }
        printPathToLeaf(root.left, path);
        printPathToLeaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static void print(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+"->");
        }
        System.out.println("null");
    }

    public static boolean validBST2(node root, node min, node max) {
        if(root == null) {
            return true;
        }
        if(min != null && root.data <= min.data) {
            return false;
        }
        if(max != null && root.data >= max.data ) {
            return false;
        }

        return validBST2(root.left, min, root) && validBST2(root.right, root, max);
    }

    public static boolean validBST(node root) {
        node min = null;
        node max = null;
        return validBST2(root, min, max);
    }

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

    public static void preOrder(node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int nodes[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        node root = null;
        for(int i=0; i<nodes.length; i++) {
            root = insert(nodes[i], root);
        }
        preOrder(root);
        System.out.println();
        // // System.out.println(search(root, 4));
        // delete(root, 4);
        // System.out.println();
        // inOrder(root);
        // printInRange(root, 3, 11);
        // printPathToLeaf(root, new ArrayList<>());
        // System.out.println(validBST(root));
        mirrorTree(root);
        preOrder(root);
    }
}