package p56_merge_intervals;

import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
//        return res;
    }

    public static void main(String[] args) {
        int[][] res = new Solution().merge(new int[][]{{1,3},{2,6},{8,0},{15,18}});
        for (int[] re:res){
            System.out.println(Arrays.toString(re));
        }
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] res= new int[intervals.length][2];
        int index = 0;
        for(int[] interval : intervals){
            if(index == 0 || interval[0] > res[index - 1][1]){
                res[index] = interval;
                index++;
            } else {
                res[index - 1][1] = Math.max(res[index - 1][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, index);

    }
}

