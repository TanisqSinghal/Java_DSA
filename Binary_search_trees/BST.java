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
                return root.left;
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

    public static boolean validBSTutil(node root, node min, node max) {
        if(root == null) {
            return true;
        }
        if(min != null && root.data <= min.data) {
            return false;
        }
        if(max != null && root.data >= max.data ) {
            return false;
        }

        return validBSTutil(root.left, min, root) && validBSTutil(root.right, root, max);
    }

    public static boolean validBST(node root) {
        node min = null;
        node max = null;
        return validBSTutil(root, min, max);
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

    public static node createTreeWithSortedArrayutil(ArrayList<Integer> nodes,int start, int end) {

        if(start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        node root = new node(nodes.get(mid));

        root.left = createTreeWithSortedArrayutil(nodes, start, mid-1);
        root.right = createTreeWithSortedArrayutil(nodes, mid+1, end);

        return root;
    }

    public static node createTreeWithSortedArray(ArrayList<Integer> nodes) {
        int start = 0, end = nodes.size() - 1;
        return createTreeWithSortedArrayutil(nodes, start, end);
    }

    public static void getInOrder(node root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }

        getInOrder(root.left, arr);
        arr.add(root.data);
        getInOrder(root.right, arr);
    }

    public static node converBstToBalancesBst(node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        getInOrder(root, arr);
        return createTreeWithSortedArray(arr);
    }

    public static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }


    public static int maxSizeBST = 0;
    public static Info largestBSTfromBT(node root) {
        if(root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBSTfromBT(root.left);
        Info rightInfo = largestBSTfromBT(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST) {
            maxSizeBST = Math.max(maxSizeBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);

    }


    public static int sum(node root) {
        if(root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return leftSum + rightSum + root.data;

    }
    
    public static int maxSumBST = 0;

    public static Info largestBSTSumfromBT(node root) {
        if(root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBSTSumfromBT(root.left);
        Info rightInfo = largestBSTSumfromBT(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST) {
            maxSumBST = Math.max(maxSumBST, sum(root));
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);

    }


    public static void main(String[] args) {
        // int nodes[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        // node root = null;
        // for(int i=0; i<nodes.length; i++) {
        //     root = insert(nodes[i], root);
        // }
        // preOrder(root);
        // System.out.println();
        // // // System.out.println(search(root, 4));
        // // delete(root, 4);
        // // System.out.println();
        // // inOrder(root);
        // // printInRange(root, 3, 11);
        // // printPathToLeaf(root, new ArrayList<>());
        // // System.out.println(validBST(root));
        // mirrorTree(root);
        // preOrder(root);
        // ArrayList<Integer> nodes = new ArrayList<>();
        // nodes.add(3);
        // nodes.add(5);
        // nodes.add(6);
        // nodes.add(8);
        // nodes.add(10);
        // nodes.add(11);
        // nodes.add(12);
        // node root = createTreeWithSortedArray(nodes);
        // preOrder(root);
        // node root = new node(8);
        // root.left = new node(6);
        // root.left.left = new node(5);
        // root.left.left.left = new node(3);
        // root.right = new node(10);
        // root.right.right = new node(11);
        // root.right.right.right = new node(12);
        // preOrder(root);
        // System.out.println();
        // root = converBstToBalancesBst(root);
        // preOrder(root);
        node root = new node(50);
        root.left = new node(30);
        root.right = new node(60);
        root.left.left = new node(5);
        root.left.right = new node(20);
        root.right.left = new node(45);
        root.right.right = new node(70);
        root.right.right.left = new node(65);
        root.right.right.right = new node(80);
        // largestBSTfromBT(root);
        largestBSTSumfromBT(root);
        System.out.println(maxSumBST);
    }
}