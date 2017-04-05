package com.company;

/**
 * Created by yzc on 17/3/29.
 */
public class BinarySearchSolution {
    int BinarySearch(int array[], int n, int value)
    {
        int left = 0;
        int right = n - 1;
        //如果这里是int right = n 的话，那么下面有两处地方需要修改，以保证一一对应：
        //1、下面循环的条件则是while(left < right)
        //2、循环内当 array[middle] > value 的时候，right = mid

        while (left <= right)  //循环条件，适时而变
        {
            int middle = left + ((right - left) >> 1);  //防止溢出，移位也更高效。同时，每次循环都需要更新。

            if (array[middle] > value)
            {
                right = middle - 1;  //right赋值，适时而变
            }
            else if(array[middle] < value)
            {
                left = middle + 1;
            }
            else
                return middle;
            //可能会有读者认为刚开始时就要判断相等，但毕竟数组中不相等的情况更多
            //如果每次循环都判断一下是否相等，将耗费时间
        }
        return -1;
    }

    // 约瑟夫环
    // https://yq.aliyun.com/articles/14455
    public int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int[] a = new int[n];
        //当前遇到的对象
        int cur = -1;
        //计步器
        int count = 0;
        int num = n;
        while (num > 0) {
            //移动到上次被删除元素的下一个元素
            cur++;
            //当遇到最后一个数的时候，从开头重新计算
            if(cur == n) cur = 0;
            //如果遇到了上次被删除的对象，则跳过该对象
            if(a[cur] == -1)
                continue;
            //计步器加1
            count++;
            if(count == m){
                //把当前元素标记为已删除
                a[cur] = -1;
                //计步器重新复位
                count = 0;
                num--;
            }
        }
        return cur;
    }

    int LastRemaining_Solution(int n, int m)
    {
        if(n < 1 || m < 1)
        {
            return -1;
        }
        else if(n == 1)
        {
            return 0;
        }
        else
        {
            // F[n] = (F[n - 1] + m) % n
            return (LastRemaining_Solution(n-1,m)+m)%n;
        }
    }


    /*
    题目描述:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     */
    int minNumberInRotatedArray(int array[]) {
        if (array == null || array.length <= 0) return -1;
        int left = 0;
        int right = array.length - 1;
        int mid = left;
        while (left < right) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right)/2;
            if (array[left] == array[mid] && array[right] == array[mid]) {
                return minNumberInArray(array);
            }
            if (array[mid] >= array[left]) {
                left = mid;
            }
            else if (array[mid] <= array[right]){
                right = mid;
            }
        }
        return array[mid];
    }

    int minNumberInArray(int array[]) {
        if (array == null || array.length <= 0) return -1;
        int min = array[0];
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
