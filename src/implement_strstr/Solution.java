package implement_strstr;

//找到needle出现的第一次的位置
public class Solution {
    public String strStr(String haystack, String needle) {
        int index = haystack.indexOf(needle);
        if(index>-1)
            return haystack.substring(index);
        return null;
    }
}
