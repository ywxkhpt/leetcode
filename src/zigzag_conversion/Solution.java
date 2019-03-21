package zigzag_conversion;

//寻找数学规律
//找到循环的周期
import java.util.*;
public class Solution {
    public String convert(String s, int nRows){
        if(nRows <= 1) return s;
        StringBuilder[] builders = new StringBuilder[nRows];
        for(int i=0;i<nRows;i++){
            builders[i] = new StringBuilder("");
        }
        for(int i=0;i<s.length();i++){
            int index = i%(2*nRows-2);
            index = index < nRows ? index:(2*nRows-2 -index);
            builders[index].append(s.charAt(i));
        }
        for(int i=1;i<builders.length;i++){
            builders[0].append(builders[i]);
        }
        return builders[0].toString();
    }
}
