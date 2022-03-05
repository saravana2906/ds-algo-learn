package com.sars.ds.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

	public static void main(String[] args) {
		
		 Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
	        graph1.addEdge(2, 7);
	        graph1.addEdge(0, 3);
	        graph1.addEdge(0, 4);
	        graph1.addEdge(0, 1);
	        graph1.addEdge(2, 1);
	        graph1.addEdge(1, 3);
	        graph1.addEdge(3, 5);
	        graph1.addEdge(3, 6);
	        graph1.addEdge(4, 7);

	        printList(sort(graph1));
	    }

	private static void printList(List<Integer> sortedList) {
		for (int v : sortedList) {
            System.out.print(v + ", ");
        }
		System.out.println();
	}

	private static List<Integer> sort(Graph graph) {
		
		LinkedList<Integer> processingQueue = new LinkedList<Integer>();
		Map<Integer,Integer> inDegreeValueOfVertices = new HashMap<Integer, Integer>();
		
		for(int currentVertex=0;currentVertex<graph.getNumberOfVertices();currentVertex++) {
			int inDegree = graph.getIndegree(currentVertex);
			inDegreeValueOfVertices.put(currentVertex, inDegree);
			if(inDegree==0) {
				processingQueue.add(currentVertex);
			}
		}
		
		LinkedList<Integer> sortedList = new LinkedList<Integer>();
		while(!processingQueue.isEmpty()) {
			int currentVertex = processingQueue.pollLast();
			sortedList.add(currentVertex);
			List<Integer> adjacentVertices = graph.getAdjacentVertices(currentVertex);
			for(int eachAdjacentVertex : adjacentVertices) {
				int pastInDegreeValue = inDegreeValueOfVertices.get(eachAdjacentVertex);
				pastInDegreeValue--;
				inDegreeValueOfVertices.remove(eachAdjacentVertex);
				inDegreeValueOfVertices.put(eachAdjacentVertex, pastInDegreeValue);
				if(pastInDegreeValue==0) {
					processingQueue.add(eachAdjacentVertex);
				}
			}
		}
		
		if(graph.getNumberOfVertices() != sortedList.size()) {
			System.out.println("Graph has Cycle");
		}
		
		return sortedList;
	}
	
}
