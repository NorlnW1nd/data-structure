package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(majorityElement(nums));
    }

    /**
     * 使用map记录个数
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        //  map 记录元素出现个数
        Map<Integer,Integer> map = new HashMap<>();
        // 统计 多数元素 满足结果
        int halfLength = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //  元素次数初始化为1
            int count = 1;
            if (map.containsKey(num)){
                count = map.get(num);
                count++;
            }
            if (count > halfLength){
                return num;
            }
            map.put(num,count);
        }

        return -1;
    }

    /**
     * 对数组进行排序 n/2位置的元素一定是最多的元素
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums){
        Arrays.sort(nums);
        int address = nums.length / 2;
        return nums[address];
    }

    /**
     * 投票算法 将元素当场候选人 如果新元素和候选人相同，次数+1，不同次数-1
     * 如果次数=0，候选人更新
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums){
        //  本质上 多数元素出现的次数 一定大于其他所有元素出现次数的总和
        int candidate = 0;// n.候选人
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                candidate = nums[i];
            }
            if (candidate == nums[i]){
                count++;
            }else {
                count--;
            }
        }
        return candidate;
    }
}
