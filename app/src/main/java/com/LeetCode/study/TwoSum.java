package com.LeetCode.study;

import java.util.HashMap;

public class TwoSum implements ResultInterface<int[]>{
    int[] nums;
    int target;

    public TwoSum(int[] nums, int target) {
        this.nums=nums;
        this.target=target;
    }


    @Override
    public int[] result() {
            //2数之和至少2个数
            if (nums==null&&nums.length>2){
                throw new IllegalArgumentException("No two sum solution");
            }
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for(int i = 0; i< nums.length; i++) {

                //是否包含
                if(hashMap.containsKey(target - nums[i])) {
                    return new int[] {hashMap.get(target-nums[i]),i};
                }
                hashMap.put(nums[i], i);
            }

            throw new IllegalArgumentException("No two sum solution");
    }

    @Override
    public void test() {

    }
}
