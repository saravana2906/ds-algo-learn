package com.sars.ds.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;


public class DijkstraAlgorithm {

	public static void main(String[] args) {
		 Graph graph = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
	        graph.addEdge(2, 7, 4);
	        graph.addEdge(0, 3, 2);
	        graph.addEdge(0, 4, 2);
	        graph.addEdge(0, 1, 1);
	        graph.addEdge(2, 1, 3);
	        graph.addEdge(1, 3, 2);
	        graph.addEdge(3, 5, 1);
	        graph.addEdge(3, 6, 3);
	        graph.addEdge(4, 7, 2);
	        graph.addEdge(7, 5, 4);

	        shortestPath(graph, 0, 2);
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
		
		Map<Integer, DistanceInfo> distanceTable = new HashMap<Integer, DijkstraAlgorithm.DistanceInfo>();
		PriorityQueue<VertexInfo> processingQueue =
				new PriorityQueue<DijkstraAlgorithm.VertexInfo>(
						new Comparator<VertexInfo>() {
				            @Override
				            public int compare(VertexInfo v1, VertexInfo v2) {
				                return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
				            }
				        }
				);
		
		for(int eachVertex=0;eachVertex<graph.getNumberOfVertices();eachVertex++) {
			distanceTable.put(eachVertex, new DistanceInfo());
		}
		distanceTable.get(sourceVertex).setDistance(0);
		distanceTable.get(sourceVertex).setLastVertex(sourceVertex);
		VertexInfo sourceVertexInfo = new VertexInfo(sourceVertex, 0);
		Map<Integer,VertexInfo> vertexInfoMap = new HashMap<Integer, DijkstraAlgorithm.VertexInfo>();
		vertexInfoMap.put(sourceVertex, sourceVertexInfo);
		processingQueue.add(sourceVertexInfo);
		
		while(!processingQueue.isEmpty()) {
			VertexInfo currentVertexInfo = processingQueue.poll();
			
			for(int eachAdjacentVertex : graph.getAdjacentVertices(currentVertexInfo.getVertexId())) {
				
				int distance = distanceTable.get(currentVertexInfo.getVertexId()).getDistance()
						+ graph.getWeightedEdge(currentVertexInfo.getVertexId(), eachAdjacentVertex);
				
				if(distance < distanceTable.get(eachAdjacentVertex).getDistance()) {
					distanceTable.get(eachAdjacentVertex).setDistance(distance);
					distanceTable.get(eachAdjacentVertex).setLastVertex(currentVertexInfo.getVertexId());
					VertexInfo adjacentVertexInfo = vertexInfoMap.get(eachAdjacentVertex);
					if(adjacentVertexInfo != null) {
						processingQueue.remove(adjacentVertexInfo);
					}
					adjacentVertexInfo = new VertexInfo(eachAdjacentVertex, distance);
					processingQueue.add(adjacentVertexInfo);
					vertexInfoMap.put(eachAdjacentVertex, adjacentVertexInfo);
					
				}
			}
		}
		return distanceTable;
	}


	public static class DistanceInfo {
		
		private int distance;
		private int lastVertex;
		  public DistanceInfo() {
	            distance = Integer.MAX_VALUE;
	            lastVertex = -1;
	        }
		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}
		public int getLastVertex() {
			return lastVertex;
		}
		public void setLastVertex(int lastVertex) {
			this.lastVertex = lastVertex;
		}
	}
	
	public static class VertexInfo {
		private int vertexId;
		private int distance;
		
		 public VertexInfo(int vertexId, int distance) {
	            this.vertexId = vertexId;
	            this.distance = distance;
	        }
		 
		public int getVertexId() {
			return vertexId;
		}
		public void setVertexId(int vertexId) {
			this.vertexId = vertexId;
		}
		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}
		
		
	}
}
