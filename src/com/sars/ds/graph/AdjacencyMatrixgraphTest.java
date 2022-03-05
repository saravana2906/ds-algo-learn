package com.sars.ds.graph;



public class AdjacencyMatrixgraphTest {

	public static void main(String[] args) {
		Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
	      graph1.addEdge(2, 7, 4);
	        graph1.addEdge(0, 3, 2);
	        graph1.addEdge(0, 4, 2);
	        graph1.addEdge(0, 1, 1);
	        graph1.addEdge(2, 1, 3);
	        graph1.addEdge(1, 3, 2);
	        graph1.addEdge(3, 5, 1);
	        graph1.addEdge(3, 6, 3);
	        graph1.addEdge(4, 7, 2);
	        graph1.addEdge(7, 5, 4);
	        
	        for(int i=0;i<graph1.getNumberOfVertices();i++) {
	        	System.out.println(graph1.getAdjacentVertices(i));
	        }
	}
}
