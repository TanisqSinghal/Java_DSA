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
            if (nodes[i] == -1) {
                return null;
            }
            node newNode = new node(nodes[i]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(node root) {
            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(node root) {
            if (root == null) {
                return;
            }

            Queue<node> q = new LinkedList<>();

            q.add(root);
            // q.add(null);

            while (!q.isEmpty()) {
                node currNode = q.remove();
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

        public static int height(node root) {
            if (root == null) {
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh, rh) + 1;
        }

        public static int countNodes(node root) {
            if (root == null) {
                return 0;
            }

            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);

            return leftCount + rightCount + 1;
        }

        public static int sumOfNodes(node root) {
            if (root == null) {
                return 0;
            }

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);

            return leftSum + rightSum + root.data;
        }

        public static int diameter1(node root) {
            if (root == null) {
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
            if (root == null) {
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

    public static boolean isIdentical(node Node, node subroot) {
        if (Node == null && subroot == null) {
            return true;
        } else if (Node == null || subroot == null || Node.data != subroot.data) {
            return false;
        }

        if (!isIdentical(Node.left, subroot.left)) {
            return false;
        }
        if (!isIdentical(Node.right, subroot.right)) {
            return false;
        }
        return true;
    }

    public static boolean isSubTree(node root, node subroot) {
        if (root == null) {
            return false;
        }

        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }

        return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
    }

    public static class Info {
        node Node;
        int hd;

        public Info(node Node, int hd) {
            this.Node = Node;
            this.hd = hd;
        }
    }

    public static void topView(node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, node> hMap = new HashMap<>();

        q.add(new Info(root, 0));
        q.add(null);

        int min = 0, max = 0;

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!hMap.containsKey(curr.hd)) {
                    hMap.put(curr.hd, curr.Node);
                }

                if (curr.Node.left != null) {
                    q.add(new Info(curr.Node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.Node.right != null) {
                    q.add(new Info(curr.Node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(hMap.get(i).data + " ");
        }

        System.out.println();
    }

    public static void kthLevel(node root, int k, int level) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kthLevel(root.left, k, level + 1);
        kthLevel(root.right, k, level + 1);
    }

    public static boolean getPath(node root, int n, ArrayList<node> path) {

        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static node lca(node root, int n1, int n2) {
        ArrayList<node> path1 = new ArrayList<>();
        ArrayList<node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        return path1.get(i - 1);
    }

    public static node lca2(node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        node leftLca = lca2(root.left, n1, n2);
        node rightLca = lca2(root.right, n1, n2);

        if (leftLca == null) {
            return rightLca;
        }
        if (rightLca == null) {
            return leftLca;
        }

        return root;
    }

    public static int lcaDist(node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDistBetNodes(node root, int n1, int n2) {
        node lca = lca(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int kthAncestor(node root, int n, int k) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            return root.data;
        }

        return max + 1;
    }

    public static int transformIntoSumTree(node root) {
        if (root == null) {
            return 0;
        }

        int leftChild = transformIntoSumTree(root.left);
        int rightChild = transformIntoSumTree(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight + rightChild;

        return data;
    }

    public static void preOrder(node root) {
        if (root == null) {
            // System.out.print(-1 + " ");
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // BinaryTree tree = new BinaryTree();
        // node root = tree.buildTree(nodes);
        // tree.preOrder(root);
        // tree.inOrder(root);
        // tree.postOrder(root);
        // tree.levelOrder(root);
        // System.out.println(tree.height(root));
        // System.out.println(tree.countNodes(root));
        // System.out.println(tree.sumOfNodes(root));
        // System.out.println(tree.diameter1(root));
        // System.out.println(tree.diameter(root));
            //         1
            //       /  \
            //      2    3
            //    / \    / \
            //   4   5  6   7
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        // node subroot = new node(2);
        // subroot.left = new node(4);
        // subroot.right = new node(5);

        // System.out.println(isSubTree(root, subroot));
        // topView(root);
        // kthLevel(root, 3, 1);
        // System.out.println(lca2(root, 5, 7).data);
        // System.out.println(minDistBetNodes(root, 5, 7));
        // System.out.println(kthAncestor(root, 5, 2));
        transformIntoSumTree(root);
        preOrder(root);
    }
}
