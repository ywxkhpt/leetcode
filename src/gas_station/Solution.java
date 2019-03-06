package gas_station;

public class Solution {
    //如果总的油量大于总的消耗量则一定能够走一圈
    //如果以A为起点 再走的过程中到达B剩余油量为负 则以A和B之间的任意一个为起点都不能走到B点
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, sum = 0,start = 0;
        for(int i = 0;i < gas.length; i++){
            total = total + (gas[i] - cost[i]);
            sum = sum + (gas[i] - cost[i]);
            if(sum < 0){
                start = i + 1;
                sum = 0;
            }
        }
        return total >= 0 ? start: -1;
    }
}
