import java.util.*;

class Solution {

    public int minMutation(String start, String end, String[] bank) {

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {
                String curr = queue.poll();

                if (curr.equals(end)) return level;

                char[] currArr = curr.toCharArray();

                for (int i = 0; i < currArr.length; i++) {
                    char old = currArr[i];

                    for (char g : genes) {
                        if (g == old) continue;

                        currArr[i] = g;
                        String next = new String(currArr);

                        if (bankSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArr[i] = old; // restore character
                }
            }

            level++;
        }

        return -1;
    }
}
