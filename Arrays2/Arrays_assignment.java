import java.util.*;

public class Arrays_assignment {
    //Q1 , TC - O(nlogn) , SC - O(1) , without using hashing , solved using sorting
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
    //Q2 , TC - O(logn) , SC - O(1) , it is covered in later chapters also
    public int search(int[] arr, int tar) {
        int si = 0, ei = arr.length-1;
        while(si <= ei) {
            int mid = si + (ei-si)/2;
            if(arr[mid] == tar) return mid;

            //mid on L1 
            if(arr[si] <= arr[mid]) {
                //case a:
                if(arr[si] <= tar && tar <= arr[mid]) ei = mid-1;
                //case b:
                else si = mid+1;
            }
            //mid on L2
            else {
                //case a:
                if(arr[mid] <= tar && tar <= arr[ei]) si = mid+1;
                //case b:
                else ei = mid-1;
            }

        }
        return -1;
    }
    //Q5 , TC - O(N), SC - O(1) , 3sum question in leetcode
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            int target = nums[k];

            if (k > 0 && nums[k] == nums[k - 1])
                continue;

            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == -target) {
                    arr.add(Arrays.asList(target, nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i + 1])
                        i++;
                    while (i < j && nums[j] == nums[j - 1])
                        j--;
                    i++;
                    j--;

                } else if (nums[i] + nums[j] > -target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {

    }
}
