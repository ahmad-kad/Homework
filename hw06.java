import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class hw06 {

    // Approach 1: Using nested loops
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> fullList = new ArrayList<>();
        Set<List<Integer>> setList = new HashSet<>();
        Arrays.sort(nums);

        for (int x = 0; x < nums.length - 2; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                for (int z = y + 1; z < nums.length; z++) {
                    List<Integer> combo = new ArrayList<>();
                    combo.add(nums[x]);
                    combo.add(nums[y]);
                    combo.add(nums[z]);
                    if (nums[x] + nums[y] + nums[z] == 0 && !setList.contains(combo)) {
                        setList.add(combo);
                        fullList.add(combo);
                    }
                }
            }
        }
        return fullList;
    }

    // Approach 2: Using two-pointer technique
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> fullList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total < 0) {
                    left++;
                } else if (total > 0) {
                    right--;
                } else {
                    fullList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return fullList;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1};
        System.out.println("Approach 1:");
        System.out.println(threeSum1(nums));  // Output: []

        System.out.println("Approach 2:");
        System.out.println(threeSum2(nums));  // Output: []

        int[] nums2 = {-5, 0, 5, 10, -10, 0};
        System.out.println("Approach 1:");
        System.out.println(threeSum1(nums2));  // Output: [[-10, 0, 10], [-5, 0, 5]]

        System.out.println("Approach 2:");
        System.out.println(threeSum2(nums2));  // Output: [[-10, 0, 10], [-5, 0, 5]]
    }
}
