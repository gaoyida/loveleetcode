package com.gaoyida.loveleetcode.graph;

/**
 * @author gaoyida
 * @date 2019/12/10 下午10:26
 */
public class UndirectedGraph {

    //vertice
    private int vertices;
    private int edges;
    private int[][] adj;

    public UndirectedGraph() {
    }

    public UndirectedGraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adj=new int[vertices][vertices];
    }

    public void addEdge(int v, int w) {

    }

//    public Iterable<Integer> adj(int v) {
//
//    }


}
