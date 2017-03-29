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
}
