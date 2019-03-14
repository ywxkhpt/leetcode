package word_ladder;

import java.util.HashSet;
import java.util.Set;

//BFS 遍历 需要一个集合记录到达的点 并将到达的点从字典中删除
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordDict.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            reached = toAdd;
            if (reached.size() == 0) return 0;
            distance++;
        }
        return distance;
    }
//"hot","dog","dot"
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("hot");
        set.add("dog");
        set.add("dot");
        Solution solution = new Solution();
        solution.ladderLength("hot","dog",set);
    }
}
