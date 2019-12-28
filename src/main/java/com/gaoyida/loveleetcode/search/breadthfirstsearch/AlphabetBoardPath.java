package com.gaoyida.loveleetcode.search.breadthfirstsearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author gaoyida
 * @date 2019/12/28 下午8:25
 * <link>https://leetcode.com/problems/alphabet-board-path/</link>
 */
public class AlphabetBoardPath {
    private static class Node {
        int x;
        int y;
        String saveStr;
        char pos;

        Node(int x, int y, String saveStr, char pos) {
            this.x = x;
            this.y = y;
            this.saveStr = saveStr;
            this.pos = pos;
        }
    }


    public String alphabetBoardPath(String target) {

        char board[][] = {
                {'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'j'},
                {'k', 'l', 'm', 'n', 'o'},
                {'p', 'q', 'r', 's', 't'},
                {'u', 'v', 'w', 'x', 'y'},
                {'z'},
        };
        int left = 0, right = 4;
        int top = 0, buttom = 4;
        int directArr[][] = new int[][]{{-1, 0, 'U'}, {0, -1, 'L'}, {1, 0, 'D'}, {0, 1, 'R'}};
        char[] charArray = target.toCharArray();
        int targetLen = charArray.length - 1;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, "", board[0][0]));
        int cur = 0;
        Set<Character> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            String oldStr = node.saveStr;
            visited.add(node.pos);
            if (node.pos == charArray[cur]) {
                while (cur <= targetLen && node.pos == charArray[cur]) {
                    oldStr += '!';
                    cur++;
                }
                queue.clear();
                visited.clear();
            }
            if (cur > targetLen) {
                return oldStr;
            }
            for (int[] xy : directArr) {
                int newx = node.x + xy[0];
                int newy = node.y + xy[1];
                if ((newx >= left && newx <= right && newy >= top && newy <= buttom)
                        || (newx == 5 && newy == 0)) {
                    if (visited.contains(board[newx][newy])) {
                        continue;
                    }
                    queue.add(new Node(newx, newy, oldStr + (char) xy[2], board[newx][newy]));
                }
            }
        }
        return null;
    }
}
