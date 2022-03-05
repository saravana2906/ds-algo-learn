package com.sars.ds.graph;

import java.util.List;

public interface Graph {

	enum GraphType {
		DIRECTED,
		UNDIRECTED
	}
    GraphType TypeofGraph();
    
    void addEdge(int v1, int v2);

    void addEdge(int v1, int v2, int weight);

    int getWeightedEdge(int v1, int v2);

    List<Integer> getAdjacentVertices(int v);

    int getNumberOfVertices();

    int getIndegree(int v);
}
