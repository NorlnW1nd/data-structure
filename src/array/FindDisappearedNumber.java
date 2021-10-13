package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDisappearedNumber {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers1(nums));
    }

    /**
     * 使用额外的set
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // 使用set 存储已经出现的数字
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 从1-n开始遍历
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> findDisappearedNumbers1(int[] nums){
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);// 通过abs方法取绝对值
            int index = num - 1;

            // 将对应索引位置的值置为负数
            if (nums[index]>=0) nums[index] = - nums[index];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}
