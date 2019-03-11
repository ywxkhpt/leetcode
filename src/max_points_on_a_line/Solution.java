package max_points_on_a_line;
//穷举法
//求最大公约数 辗转相除法
//对于每一个点 求和这一个点在同一直线上的最大的个数 需要考虑点重合的情况 别忘了加上点本身+1
//然后找出最多的个数
//不要用除法记录 可能出现精度问题 用字符串记录斜率

import java.util.*;

public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        int length = points.length;
        int res = 0;
        for(int i=0;i<length;i++){
            int dul = 0; //记录重复的点
            int max = 0;//记录和点在同一条直线上的点的最大的个数
            HashMap<String,Integer> map = new HashMap<String,Integer>();
            for(int j=i+1;j<length;j++){
                int deltaX = points[i].x - points[j].x;
                int deltaY = points[i].y - points[j].y;
                if(deltaX==0 && deltaY==0){//重合的点
                    dul++;
                    continue;
                }
                int gcd = gcd(deltaX, deltaY); //当水平或者竖直的时候 为1,0或0,1
                int dX = deltaX / gcd;
                int dY = deltaY / gcd;
                String key = String.valueOf(dX + "," + dY);
                map.put(key,map.getOrDefault(key,0) + 1);
                max = Math.max(map.get(key),max);
            }
            res = Math.max(res,max + dul + 1);
        }
        return res;
    }

    public int gcd(int a,int b){
        if (a == 0) return b;
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
