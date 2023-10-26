package com.simile.plan.java.other;

import org.junit.Test;

/**
 * @Author yitao
 * @Created 2023/10/24
 */
public class Code1Test {

    @Test
    public void sort() {
        int[] nums = {5, 1, 0, 0, 0, 4, 0};
        moveZeroes(nums);
    }

    public void println(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void moveZeroes(int[] nums) {
        //方案一，从数组头部开始遍历，一旦发现有0，则将0移动到数组末尾，0之后的数据往前顺移1位
        //方案二，在方案一的基础上，增加一个数组尾部已经是0的数目，往前顺移的时候，则无需移动此部分数据
        //方案三，从数组头部开始遍历，把0存到数组前面
        //方案四，对于大量连续0的情况，可以批量移动0
        //方案五，从数组尾部遍历，类似于方案一
        //方案六，从数组两端遍历，头部开始的则把0放头部，最后将前半部分的0移到末尾+方案四
        //方案七，从数组中间位置切分，对前半部分和后半部分使用方案六+方案四

    }


}
