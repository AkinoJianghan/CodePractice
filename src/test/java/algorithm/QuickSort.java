package algorithm;

import org.junit.Test;

// 先去第一位当做
public class QuickSort {
    public int[] quickSort(int[] nums){
        int[] resultNums = new int[nums.length];
        // 先复制一遍数据,不在原来的数据上操作.
        for(int i = 0; i < resultNums.length; i++) {
            resultNums[i] = nums[i];
        }
        quickSortFaciton(resultNums,0,resultNums.length-1);
        return resultNums;
    }

    public void quickSortFaciton(int[] nums,int start,int end){
        if(start >= end){
            return ;
        }
        int temp = nums[start];
        int index1 = start;
        int index2 = end;
        // 标志位 1代表当前轮次index1移动,2代表index2移动
        byte mark = 2;
        // 前后指针相遇,循环结束
        while (index1 < index2){
            // 轮到后指针移动时
            if(mark == 2){
                // 没有触发换位,下一轮继续后指针向前移动
                if(nums[index2] >= temp){
                    index2 -= 1;
                }
                // 触发换位,下一轮移动前指针
                else {
                    nums[index1] = nums[index2];
                    index1 += 1;
                    mark = 1;
                }
            }
            // 轮到前指针移动时
            else{
                //  没有触发换位,下一轮继续前指针向后移动
                if(nums[index1] <= temp) {
                    index1 += 1;
                }
                // 触发换位,下一轮移动后指针
                else {
                    nums[index2] = nums[index1];
                    index2 -=1;
                    mark = 2;
                }
            }
        }
        nums[index1] = temp;
        quickSortFaciton(nums,0,index1 - 1 );
        quickSortFaciton(nums,index1+1,end);
        return ;
    }


    @Test
    public void testQuickSort(){
        int[] nums = new int[]{1,3,2,1,5,1,7,1,1,-2,8,-10,11,15,1};
        int[] resultNums = quickSort(nums);
        for(int i = 0; i < resultNums.length; i++){
            System.out.print(resultNums[i]+" ");
        }
    }
}
