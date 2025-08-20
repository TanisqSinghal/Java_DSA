import java.util.ArrayList;

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

    //Q1 , TC - O(H) , SC - O(H)
    public static int rangeSumOfBST(node root,int k1, int k2, int sum) {
        if(root == null) {
            return 0;
        }
        if(root.data >= k1 && root.data <= k2) {
            sum = rangeSumOfBST(root.left, k1, k2, sum);
            sum += root.data;
            sum += rangeSumOfBST(root.right, k1, k2, sum);
        }
        else if(root.data < k1) {
            sum = rangeSumOfBST(root.right, k1, k2, sum);
        }
        else {
            sum = rangeSumOfBST(root.left, k1, k2, sum);
        }

        return sum;
    }

    //Q2 , TC - O(H), SC - O(H)
    public static int closestElementInBST(node root, int key, int closest) {
        if(root == null) {
            return closest;
        }
        
        if(Math.abs(root.data - key) < Math.abs(closest - key)) {
            closest = root.data;
        }
        if(key < root.data) {
            closest = closestElementInBST(root.left, key, closest);
        }
        else if(key > root.data) {
            closest = closestElementInBST(root.right, key, closest);
        }
        else {
            return root.data; // if key is not > root.data and not < root.data, then obv it is equal to key
        }

        return closest;
    }

    //Q3 , TC - O(H + K) , SC - O(H)
    static int count = 0;
    static int result = -1;
    public static int kthSmallestElementInBST(node root, int k) {
        count = 0;
        result = -1;
        inOrderTraveral(root, k);
        return result;
    }

    public static void inOrderTraveral(node root, int k) {
        if(root == null) {
            return;
        }

        inOrderTraveral(root.left, k);
        
        count++;
        if(count == k) {
            result = root.data;
            return;
        }

        inOrderTraveral(root.right, k);
    }

    //Q4, TC - O(N), SC - O(N)
    public static void twoSumInorder(ArrayList<Integer> list1, node root1) {
        if(root1 == null) {
            return;
        }

        twoSumInorder(list1, root1.left);
        list1.add(root1.data);
        twoSumInorder(list1, root1.right);
    }
    public static void twoSumInorderReverse(ArrayList<Integer> list2, node root2) {
        if(root2 == null) {
            return;
        }

        twoSumInorderReverse(list2, root2.right);
        list2.add(root2.data);
        twoSumInorderReverse(list2, root2.left);
    }

    public static void twoSumBSTs(node root1, node root2, int tar) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        twoSumInorder(list1, root1);
        twoSumInorderReverse(list2, root2);

        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()) {
            int sum = list1.get(i) + list2.get(j);
            if(sum == tar) {
                System.out.println("("+list1.get(i)+","+list2.get(j)+")");
                i++; j++;
            }
            else if(sum < tar) {
                i++;
            }
            else {
                j++;
            }
        }
    }

    //Q5 , TC - O(N), SC - O(N)
    public static class Info {
        boolean isBST;
        int min, max;

        public Info(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public static int sum(node root) {
        if(root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return leftSum + rightSum + root.data;

    }

    static int maxSumOfLargestBST = 0;
    public static Info maxSumOfBSTinBT(node root) {
        if(root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = maxSumOfBSTinBT(root.left);
        Info rightInfo = maxSumOfBSTinBT(root.right);

        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max && root.data >= rightInfo.min) {
            return new Info(false, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST) {
            maxSumOfLargestBST = Math.max(maxSumOfLargestBST, sum(root));
            return new Info(true, min, max);
        }

        return new Info(false, min, max);
    }

    public static void main(String[] args) {
        // int nodes[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        // node root = null;
        // for(int i=0; i<nodes.length; i++) {
        //     root = insert(nodes[i], root);
        // }
        // // System.out.println(rangeSumOfBST(root, 4, 10, 0));
        // // System.out.println(closestElementInBST(root, 2, root.data));
        // System.out.println(kthSmallestElementInBST(root, 3));
        int nodes1[] = {5, 3, 7, 2, 4, 6, 8};
        node root1 = null;
        for(int i=0; i<nodes1.length; i++) {
            root1 = insert(nodes1[i], root1);
        }
        int nodes2[] = {10, 6, 15, 3, 8, 11, 18};
        node root2 = null;
        for(int i=0; i<nodes2.length; i++) {
            root2 = insert(nodes2[i], root2);
        }
        // twoSumBSTs(root1, root2, 16);
        maxSumOfBSTinBT(root1);
        System.out.println(maxSumOfLargestBST);
    }
}
