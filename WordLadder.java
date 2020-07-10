import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
  private HashMap<String, List<String>> map = new HashMap<>();

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (beginWord.equals(endWord))
      return 0;
    buildMap(wordList, beginWord);
    HashSet<String> doneSet = new HashSet<>();
    Queue<String> queue = new LinkedList<>();

    queue.offer(beginWord);
    doneSet.add(beginWord);
    int steps = 1;
    while (queue.size() != 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String curr = queue.poll();
        if (curr.equals(endWord))
          return steps;
        List<String> nxtStrList = map.get(curr);
        for (String nxtStr : nxtStrList) {
          if (!doneSet.contains(nxtStr)) {
            queue.offer(nxtStr);
            doneSet.add(nxtStr);
          }
        }
      }
      steps++;
    }

    return 0;
  }

  private void buildMap(List<String> wordList, String beginWord) {
    for (String str : wordList) {
      List<String> nList = new ArrayList<>();
      map.put(str, nList);
      for (String nxt : wordList) {
        if (diff(str, nxt) == 1) {
          map.get(str).add(nxt);
        }
      }
    }
    if (!map.containsKey(beginWord)) {
      List<String> nList = new ArrayList<>();
      map.put(beginWord, nList);
      for (String str : wordList) {
        if (diff(beginWord, str) == 1) {
          map.get(beginWord).add(str);
        }
      }
    }
  }

  private int diff(String s, String t) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != t.charAt(i))
        count++;
    }
    return count;
  }
}