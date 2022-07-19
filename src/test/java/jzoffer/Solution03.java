package jzoffer;

import org.junit.Test;

/*
    题目 ： 面试题3 数组中重复的数字
    在一个长度为n的数组，所有数字都在0～n-1的范围内，有些数字重复了，但不知道那些重复了。请你找出任意一个重复的数字。

    1 一定可以的方法再生成一个数组，将这些数字一个个放进去，如果那个数字放的时候，下标已经有数字了，代表重复。return。
        时间复杂度 O(n） 空间复杂度O(n)
    2 考虑直接在原数组做交换操作，这样空间复杂度可以降到O(1)。
        每次交换和遍历，原下标的数字必然会被放在正确的位置上，直到当前下标就是当前的值，就切到下一个下标元素。
        由于每个元素最多被换两次（一次被换，一次换到正确位置）
        时间复杂度 O(n） 空间复杂度O(1)。 缺点是原数组被动过了。
    3 使用二分法。
        定义两个计数器。如果没有重复的数字，那么0~n-1，大于和小于中位数的数字个数都是固定的。
        比如0~7 大于4的应该有三个。小于4的应该有4个。如果多了证明有重复，继续使用二分即可，直到最后分完只剩一位数，但count大于1。
        时间复杂度O(nlogn) 空间复杂度O(1).

2022-07-19 21:47
 */
public class Solution03 {
    public int findNumber(int[] input){
        int result;
        // 空值处理
        if(input == null){
            result = -1;
            return result;
        }
        // 长度为0或1的数组必然没有重复
        if(input.length == 0 || input.length == 1){
            result = -1;
            return result;
        }
        int numbers[] = new int[input.length];
        // 每个元素如果进来一次，就将这个元素的位置变为-1
        for(int i = 0; i < input.length; i++){
            // 元素不符合规范
            if(input[i] < 0 ){
                return -1;
            }
            if(numbers[input[i]] != -1){
                numbers[input[i]] = -1;
            }else{
                return input[i];
            }
        }
        // 如果正常走完了循环，证明没有重复
        return -1;
    }

    @Test
    public void testCode01(){
        int input[] = new int[]{2,3,1,0,4,5,3};
        int result = findNumber(input);
        System.out.println(input);
        System.out.println(result);
    }
}
