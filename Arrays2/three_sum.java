import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class three_sum {

    public static List<List<Integer>> threeSum(int[] nums) {
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
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = new ArrayList<>();
        list = threeSum(nums);
        System.out.println(list);
    }
}
