package com.sars.ds.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.IntStream;




public class PrimsAlgorithm {
	
	public static void main(String[] args) {
		  Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.UNDIRECTED);
	        graph1.addEdge(2, 7, 4);
	        graph1.addEdge(0, 3, 2);
	        graph1.addEdge(0, 4, 2);
	        graph1.addEdge(0, 1, 1);
	        graph1.addEdge(2, 1, 3);
	        graph1.addEdge(1, 3, 2);
	        graph1.addEdge(3, 5, 1);
	        graph1.addEdge(3, 6, 3);
	        graph1.addEdge(4, 7, 22);
	        graph1.addEdge(7, 5, 4);

	        spanningTree(graph1, 0);

	}
	

	private static void spanningTree(com.sars.ds.graph.Graph graph, int sourceVertex) {
		Map<Integer,DistanceInfo> distanceTable = buildDistanceTable(graph,sourceVertex);
		
		
		
	}

	private static Map<Integer, DistanceInfo> buildDistanceTable(com.sars.ds.graph.Graph graph, int sourceVertex) {
		Map<Integer,DistanceInfo> distanceTable = new HashMap<Integer, PrimsAlgorithm.DistanceInfo>();
		IntStream.range(0, graph.getNumberOfVertices()).forEach(vertex->{
			distanceTable.put(vertex, new DistanceInfo());
		});
		distanceTable.get(sourceVertex).setDistance(0);
		distanceTable.get(sourceVertex).setLastVertex(sourceVertex);
		PriorityQueue<VertexInfo> vertexQueue = new PriorityQueue<PrimsAlgorithm.VertexInfo>(
				new Comparator<VertexInfo>() {
					@Override
					public int compare(VertexInfo o1, VertexInfo o2) {
						return Integer.compare(o1.getDistance(), o2.getDistance());
					}
				});
		
		 Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
		VertexInfo sourceVertexInfo = new VertexInfo(sourceVertex,0);
		vertexInfoMap.put(sourceVertex, sourceVertexInfo);
		vertexQueue.add(sourceVertexInfo);
		Set<String> spanningTree = new HashSet<String>();
		Set<Integer> visitedVertices = new HashSet<Integer>();
		
		while(!vertexQueue.isEmpty()) {
			VertexInfo currentVertexInfo = vertexQueue.poll();
			
			int currentVertexId = currentVertexInfo.getVertexId();
			if(visitedVertices.contains(currentVertexId)) {
				continue;
			}
			visitedVertices.add(currentVertexId);
			if(currentVertexId!=sourceVertex) {
				String edge = String.valueOf(currentVertexId) +
						String.valueOf(distanceTable.get(currentVertexId).getLastVertex());
				 if (!spanningTree.contains(edge)) {
	                    spanningTree.add(edge);
	                }
			}
			for(int currentAdjacentVertex : graph.getAdjacentVertices(currentVertexId)) {
				int distance = graph.getWeightedEdge(currentVertexId, currentAdjacentVertex);
				if(distance < distanceTable.get(currentAdjacentVertex).getDistance()) {
					distanceTable.get(currentAdjacentVertex).setDistance(distance);
					distanceTable.get(currentAdjacentVertex).setLastVertex(currentVertexId);
					if(vertexInfoMap.get(currentAdjacentVertex)!=null) {
						vertexQueue.remove(vertexInfoMap.get(currentAdjacentVertex));
					}
					VertexInfo currentAdjacentVertexInfo = new VertexInfo(currentAdjacentVertex, distance);
					vertexInfoMap.put(currentAdjacentVertex, currentAdjacentVertexInfo);
					vertexQueue.add(currentAdjacentVertexInfo);
				}
			}
		}
		 for (String edge : spanningTree) {
	            System.out.println(edge);
	        }
		return distanceTable;
	}


	public static class DistanceInfo {
		private int distance;
		private int lastVertex;
		public DistanceInfo() {
			this.distance = Integer.MAX_VALUE;
			this.lastVertex = -1;
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
		public VertexInfo(int vertexId,int distance) {
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
