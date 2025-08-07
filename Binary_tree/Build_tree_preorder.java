import java.util.*;

public class Build_tree_preorder {

    public static class node {
        int data;
        node left;
        node right;

        public node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        static int i = -1;
        public static node buildTree(int nodes[]) {
            i++;
            if(nodes[i] == -1) {
                return null;
            }
            node newNode = new node(nodes[i]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(node root) {
            if(root == null) {
                System.out.print(-1+" ");
                return;
            }

            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(node root) {
            if(root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void postOrder(node root) {
            if(root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrder(node root) {
            if(root == null) {
                return;
            }

            Queue<node> q = new LinkedList<>();

            q.add(root);
            // q.add(null);

            while(!q.isEmpty()) {
                node currNode = q.remove();
                System.out.print(currNode.data+" ");
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

        public static int height(node root) {
            if(root == null) {
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh, rh) + 1;
        }

        public static int countNodes(node root) {
            if(root == null) {
                return 0;
            }

            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);

            return leftCount + rightCount + 1;
        }

        public static int sumOfNodes(node root) {
            if(root == null) {
                return 0;
            }

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);

            return leftSum + rightSum + root.data;
        }

        public static int diameter1(node root) {
            if(root == null) {
                return 0;
            }

            int leftDiam = diameter1(root.left);
            int lh = height(root.left);
            int rightDiam = diameter1(root.right);
            int rh = height(root.right);

            int selfDiam = lh + rh + 1;

            return Math.max(Math.max(rightDiam, leftDiam), selfDiam);
        }

        public static class Info {
            int diam;
            int height;

            public Info(int diam, int height) {
                this.diam = diam;
                this.height = height;
            }
        }

        public static Info diameter2(node root) {
            if(root == null) {
                return new Info(0, 0);
            }

            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.height + rightInfo.height + 1);
            int height = Math.max(leftInfo.height, rightInfo.height) + 1;

            return new Info(diam, height);
        }

        public static int diameter(node root) {
            return diameter2(root).diam;
        }
    }

    

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        node root = tree.buildTree(nodes);
        // tree.preOrder(root);
        // tree.inOrder(root);
        // tree.postOrder(root);
        // tree.levelOrder(root);
        // System.out.println(tree.height(root));
        // System.out.println(tree.countNodes(root));
        // System.out.println(tree.sumOfNodes(root));
        // System.out.println(tree.diameter1(root));
        System.out.println(tree.diameter(root));
    }
}
