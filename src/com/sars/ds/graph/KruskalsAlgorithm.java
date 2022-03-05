package com.sars.ds.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.IntStream;






public class KruskalsAlgorithm {
	
	
	  public static void main(String[] args) {
	        Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.UNDIRECTED);
	        graph1.addEdge(2, 7, 4);
	        graph1.addEdge(0, 3, 2);
	        graph1.addEdge(0, 4, 2);
	        graph1.addEdge(0, 1, 1);
	        graph1.addEdge(2, 1, 3);
	        graph1.addEdge(1, 3, 2);
	        graph1.addEdge(3, 5, 3);
	        graph1.addEdge(3, 6, 2);
	        graph1.addEdge(4, 7, 22);
	       graph1.addEdge(7, 5, 4);
	        graph1.addEdge(6, 5, 1);

	        spanningTree(graph1);
	    }
	
	 private static void spanningTree(com.sars.ds.graph.Graph graph) {
		
		 PriorityQueue<EdgeInfo> edgeQueue = new PriorityQueue<KruskalsAlgorithm.EdgeInfo>(new Comparator<EdgeInfo>() {

			@Override
			public int compare(EdgeInfo o1, EdgeInfo o2) {
				return Integer.compare(o1.getWeight(), o2.getWeight());
			}
		});
		 
		 for(int eachVertex =0; eachVertex< graph.getNumberOfVertices();eachVertex++) {
			 for( int eachAdjacentVertex : graph.getAdjacentVertices(eachVertex)) {
				 edgeQueue.add(new EdgeInfo(eachVertex, eachAdjacentVertex, graph.getWeightedEdge(eachVertex, eachAdjacentVertex)));
			 }
		 }
		 
		 Set<Integer> visitedVertices = new HashSet<>();
		 Set<EdgeInfo> spanningTree = new HashSet<>();
	     Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
	     
	     IntStream.range(0, graph.getNumberOfVertices()).forEach(eachVertex -> {
	    	 edgeMap.put(eachVertex, new HashSet<>());
	     });
		 
		 while(!edgeQueue.isEmpty()  && spanningTree.size() < graph.getNumberOfVertices()-1) {
			 
			 EdgeInfo currentEdge = edgeQueue.poll();
			 
			 edgeMap.get(currentEdge.getVertex1()).add(currentEdge.getVertex2());
			 if(hasCycle(edgeMap)) {
				 edgeMap.get(currentEdge.getVertex1()).remove(currentEdge.getVertex2());
				 continue;
			 }
			 spanningTree.add(currentEdge);
			 visitedVertices.add(currentEdge.getVertex1());
			 visitedVertices.add(currentEdge.getVertex2());
			 
			 
		 }
		 
		    // Check whether all vertices have been covered with the spanning tree.
	        if (visitedVertices.size() != graph.getNumberOfVertices()) {
	            System.out.println("Minimum Spanning Tree is not possible");
	            for(EdgeInfo edgeInfo : spanningTree ) {
	                System.out.println(edgeInfo);
	            }
	        } else {
	            System.out.println("Minimum Spanning Tree using Kruskal's Algorithm");
	            for(EdgeInfo edgeInfo : spanningTree ) {
	                System.out.println(edgeInfo);
	            }
	        }
		
	}

	private static boolean hasCycle(Map<Integer, Set<Integer>> edgeMap) {
		
		
		for( int eachVertex : edgeMap.keySet()) {
			LinkedList<Integer> queue = new LinkedList<>();
			Set<Integer> visitedVertices = new HashSet<>();
			
			queue.add(eachVertex);
			
			while(!queue.isEmpty()) {
				int currentVertex = queue.poll();
				if(visitedVertices.contains(currentVertex)) {
					return true;
				}
				visitedVertices.add(currentVertex);
				queue.addAll(edgeMap.get(currentVertex));
			}
			
		}
		return false;
	}

	public static class EdgeInfo {

	        private Integer vertex1;
	        private Integer vertex2;
	        private Integer weight;

	        public EdgeInfo(Integer vertex1,Integer vertex2, Integer weight) {
	            this.vertex1 = vertex1;
	            this.vertex2 = vertex2;
	            this.weight = weight;
	        }

	        public Integer getVertex1() {
	            return vertex1;
	        }

	        public Integer getVertex2() {
	            return vertex2;
	        }

	        public Integer getWeight() {
	            return weight;
	        }

	        @Override
	        public String toString() {
	            return String.valueOf(vertex1) + String.valueOf(vertex2);
	        }
	    }
}
