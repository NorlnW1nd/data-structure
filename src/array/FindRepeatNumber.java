package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 查找数组中重复的数字
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber3(numbers));
    }

    /**
     * 使用set集合存储对比的解法
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // 遍历数组的for循环 iter快捷键
        for (Integer num : nums) {
            if (set.contains(num)){
                // 若包含,则返回这个num
                System.out.println("发现重复元素" + num);
                return num;
            }
            System.out.println("添加元素"+num);
            set.add(num);
        }
        return -1;// 占位用，代表没有重复
    }

    /**
     * 先排序，后查找
     * @param nums
     * @return
     */
    public static int findRepeatNumber1(int[] nums){
        // 通过操作数组的工具类 进行排序
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        // itar快捷键 通过判断相邻元素是否相等判断是否重复
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) return nums[i];
        }
        return -1;
    }

    /**
     * 使用临时数组
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums){
        // 临时数组  所有元素默认是0
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 遍历时将对应位置上的数置为1
            int num = nums[i];
            // 如果已经赋值 表示重复出现 返回这个值
            if (tmp[num] != 0) return num;
            tmp[num] = 1;
        }
        return -1;
    }

    /**
     * 交换位置查找
     * @param nums
     * @return
     */
    public static int findRepeatNumber3(int[] nums){

        for (int i = 0; i < nums.length; i++) {

            // 如果索引正好等于元素本身 是期望的结果 直接跳过
            if (nums[i] == i)continue;
            // 交换
            int num = nums[i];// 2
            // 如果要交换的位置已经有期望值了 说明重复
            if (nums[num] == num){
                return num;
            }
            int tmp = nums[num];// 2对应位置出现的值
            nums[num] = num;
            nums[i] = tmp;
            System.out.println(Arrays.toString(nums));
            // 交换仍需遍历当前位置的值 通过i--来抵消
            i--;
        }
        return -1;
    }
}
