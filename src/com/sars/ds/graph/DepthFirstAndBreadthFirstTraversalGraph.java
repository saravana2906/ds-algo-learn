package com.sars.ds.graph;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstAndBreadthFirstTraversalGraph {
	
	
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
	        System.out.println("Depth First Traversal ---------");
	        startDepthFirstTraversal(graph1);
	        System.out.println();
	        System.out.println("Breadth First Traversal ---------");
	        startBreadthFirstTraversal(graph1);
	}

	private static void startBreadthFirstTraversal(Graph graph1) {
		
		int numberOfVertices = graph1.getNumberOfVertices();
		boolean[] visitedVertices = new boolean[graph1.getNumberOfVertices()];
		
		for(int i=0;i<numberOfVertices;i++)
			breadthFirstTraversal(graph1, visitedVertices, i);
		
		
	}
	
	private static void breadthFirstTraversal(Graph graph,boolean[] visitedVertices,int currentVertex) {
		
		LinkedList<Integer> processingQueue = new LinkedList<Integer>();
		processingQueue.add(currentVertex);
		while(!processingQueue.isEmpty()) {
			Integer vertex = processingQueue.poll();
			if(visitedVertices[vertex]) {
				continue;
			}
			System.out.print(vertex +"->");
			visitedVertices[vertex]=true;
			List<Integer> adjacentVertex = graph.getAdjacentVertices(vertex);
			adjacentVertex.forEach(processingQueue::add);
		}
		System.out.println();
	}

	private static void startDepthFirstTraversal(Graph graph) {
		
		int numberOfVertices = graph.getNumberOfVertices();
		boolean[] visitedVertices = new boolean[numberOfVertices];
		for(int i=0;i<numberOfVertices;i++)
		depthFirstTraversal(graph,visitedVertices,i);
		
	}

	private static void depthFirstTraversal(Graph graph, boolean[] visitedVertices, int currentVertex) {
		if(visitedVertices[currentVertex]) {
			return;
		}
		visitedVertices[currentVertex]=true;
		
		List<Integer> adjacentVertices = graph.getAdjacentVertices(currentVertex);
		for(Integer eachVertex: adjacentVertices) {
			depthFirstTraversal(graph, visitedVertices, eachVertex);
		}
		
		System.out.print(currentVertex +"->");
	}

}
