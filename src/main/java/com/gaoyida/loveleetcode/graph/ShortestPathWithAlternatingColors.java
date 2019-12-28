package com.gaoyida.loveleetcode.graph;

/**
 * @author gaoyida
 * @date 2019/12/28 下午9:46
 * <link>https://leetcode.com/problems/shortest-path-with-alternating-colors/</link>
 */
public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[][] fromarr = new int[n][n];
        int[][] toarr = new int[n][n];
        for (int i = 0; i < red_edges.length; i++) {
            if (red_edges[i][0] < red_edges[i][1]) {
                fromarr[red_edges[i][0]][red_edges[i][1]] = 1;
            } else {
                toarr[red_edges[i][1]][red_edges[i][0]] = 1;
            }
        }
        for (int i = 0; i < blue_edges.length; i++) {
            if (blue_edges[i][0] < blue_edges[i][1]) {
                fromarr[blue_edges[i][0]][blue_edges[i][1]] = 1;
            } else {
                toarr[blue_edges[i][1]][blue_edges[i][0]] = 1;
            }
        }
        return null;
    }
}
