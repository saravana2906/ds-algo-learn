package com.sars.ds.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;



public class ShortestPathUnWeightedGraph {
	
	public static class DistanceInfo {
		private int lastVertex;
		private int distance;
		
		public DistanceInfo() {
			 setLastVertex(-1);
			 distance = -1;
		}
		
		public int getLastVertex() {
			return lastVertex;
		}

		public void setLastVertex(int lastVertex) {
			this.lastVertex = lastVertex;
		}

		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}
		
	}

	public static void main(String[] args) {
	     Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
	        graph1.addEdge(2, 7);
	        graph1.addEdge(3, 0);
	        graph1.addEdge(0, 4);
	        graph1.addEdge(0, 1);
	        graph1.addEdge(2, 1);
	        graph1.addEdge(1, 3);
	        graph1.addEdge(3, 5);
	        graph1.addEdge(6, 3);
	        graph1.addEdge(4, 7);

	        shortestPath(graph1, 1, 7);
	}

	private static void shortestPath(Graph graph, int sourceVertex, int destinationVertex) {
		
		Map<Integer,DistanceInfo> distanceTable = buildDistanceTable(graph,sourceVertex);
		Stack<Integer> processingStack = new Stack<>();
		processingStack.add(destinationVertex);
		int lastVertex = distanceTable.get(destinationVertex).getLastVertex();
		while(lastVertex != -1 && lastVertex != sourceVertex) {
			processingStack.add(lastVertex);
			lastVertex = distanceTable.get(lastVertex).lastVertex;
		}
		
		
		if(lastVertex == -1) {
			System.out.println("Graph doesn't have path between mentioned vertices");
		} else {
			System.out.print("Shortest Path : "+ sourceVertex);
			while(!processingStack.isEmpty()) {
				System.out.print("->"+processingStack.pop().toString());
			}
		}
	
	}

	private static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int sourceVertex) {
		Map<Integer,DistanceInfo> distanceTable = new HashMap<Integer, ShortestPathUnWeightedGraph.DistanceInfo>();
		for(int eachVertex=0 ;eachVertex<graph.getNumberOfVertices();eachVertex++) {
			distanceTable.put(eachVertex, new DistanceInfo());
		}
		distanceTable.get(sourceVertex).setDistance(0);
		distanceTable.get(sourceVertex).setLastVertex(sourceVertex);
		LinkedList<Integer> processingQueue = new LinkedList<Integer>();
		processingQueue.add(sourceVertex);
		while(!processingQueue.isEmpty()) {
			int currentVertex = processingQueue.poll();
			DistanceInfo currentVertexDistanceInfo = distanceTable.get(currentVertex);
			List<Integer> adjacentVertices = graph.getAdjacentVertices(currentVertex);
			for(int eachAdjacentVertex: adjacentVertices) {
				if(distanceTable.get(eachAdjacentVertex).getDistance()==-1) {
					int currentDistance = currentVertexDistanceInfo.getDistance();
					int currentAdjacentVertexDistance = 1 + currentDistance;
					distanceTable.get(eachAdjacentVertex).setDistance(currentAdjacentVertexDistance);
					distanceTable.get(eachAdjacentVertex).setLastVertex(currentVertex);
					if(!graph.getAdjacentVertices(eachAdjacentVertex).isEmpty()) {
						processingQueue.add(eachAdjacentVertex);
					}
				}
				
			}
			
		}
		return distanceTable;
	}

}
