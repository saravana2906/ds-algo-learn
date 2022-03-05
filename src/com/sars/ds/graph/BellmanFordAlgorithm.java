package com.sars.ds.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

public class BellmanFordAlgorithm {
	
public static void main(String[] args) {
	 Graph graph1 = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);
     graph1.addEdge(2, 7, 4);
     graph1.addEdge(0, 3, 23);
     graph1.addEdge(0, 4, 23);
     graph1.addEdge(0, 1, 1);
     graph1.addEdge(2, 1, 3);
     graph1.addEdge(1, 3, 2);
     graph1.addEdge(3, 5, 1);
     graph1.addEdge(3, 6, 3);
     graph1.addEdge(4, 7, 2);
     graph1.addEdge(7, 5, 4);

    shortestPath(graph1, 0, 5);


     Graph graph2 = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
     graph2.addEdge(0, 1, 2);
     graph2.addEdge(0, 2, 1);
     graph2.addEdge(1, 3, 3);
     graph2.addEdge(1, 4, -2);
     graph2.addEdge(2, 4, 2);
     graph2.addEdge(4, 3, 1);
     graph2.addEdge(2, 1, -5);

     shortestPath(graph2, 0, 3);

     Graph graph3 = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
     graph3.addEdge(0, 1, 2);
     graph3.addEdge(0, 2, 3);
     graph3.addEdge(3, 1, 2);
     graph3.addEdge(1, 4, -5);
     graph3.addEdge(2, 4, 6);
     graph3.addEdge(4, 3, -4);

     shortestPath(graph3, 0, 3);

     Graph graph4 = new AdjacencyMatrixGraph(6, Graph.GraphType.DIRECTED);
     graph4.addEdge(0, 1, 2);
     graph4.addEdge(1, 2, 3);
     graph4.addEdge(2, 3, 2);
     graph4.addEdge(3, 4, -5);
     graph4.addEdge(3, 5, 1);
     graph4.addEdge(4, 5, -3);
     graph4.addEdge(5, 4, -3);

     shortestPath(graph4, 0, 5);
}

private static void shortestPath(Graph graph, int sourceVertex, int destinationVertex) {
	
	Map<Integer,DistanceInfo> distanceTable = buildDistanceTable(graph,sourceVertex);
	
	 Stack<Integer> stack = new Stack<>();
     stack.push(destinationVertex);

     int previousVertex = distanceTable.get(destinationVertex).getLastVertex();
     while (previousVertex != -1 && previousVertex != sourceVertex) {
         stack.push(previousVertex);
         previousVertex = distanceTable.get(previousVertex).getLastVertex();

     }

     if (previousVertex == -1) {
         System.out.println("There is no path from node: " + sourceVertex
                 + " to node: " + destinationVertex);
     }
     else {
         System.out.print("Smallest Path is " + sourceVertex);
         while (!stack.isEmpty()) {
             System.out.print(" -> " +stack.pop());
         }
         System.out.println(" BellmanFord DONE!");
     }
}

private static Map<Integer, DistanceInfo> buildDistanceTable(com.sars.ds.graph.Graph graph, int sourceVertex) {
	
	Map<Integer,DistanceInfo> distanceTable = new HashMap<Integer, BellmanFordAlgorithm.DistanceInfo>();
	
	IntStream.range(0, graph.getNumberOfVertices()).forEach(vertex->{
		distanceTable.put(vertex, new DistanceInfo());
	});
	
	distanceTable.get(sourceVertex).setDistance(0);
	distanceTable.get(sourceVertex).setLastVertex(sourceVertex);
	
	LinkedList<Integer> vertexQueue = new LinkedList<Integer>();
	
	for(int iterations=0;iterations<graph.getNumberOfVertices()-1;iterations++) {
		
		IntStream.range(0,graph.getNumberOfVertices()).forEach(vertexQueue::add);
		Set<String> visitedEdges = new HashSet<>();
		while(!vertexQueue.isEmpty()) {
			int currentVertex = vertexQueue.poll();
			for(int currentAdjacentVertex: graph.getAdjacentVertices(currentVertex)) {
				String edge = String.valueOf(currentVertex) + String.valueOf(currentAdjacentVertex);
				 // Do not visit edges more than once in each iteration.
                if (visitedEdges.contains(edge)) {
                    continue;
                }
                visitedEdges.add(edge);
				int distance = distanceTable.get(currentVertex).getDistance() +
						      graph.getWeightedEdge(currentVertex, currentAdjacentVertex);
				if(distance < distanceTable.get(currentAdjacentVertex).getDistance()) {
					distanceTable.get(currentAdjacentVertex).setDistance(distance);
					distanceTable.get(currentAdjacentVertex).setLastVertex(currentVertex);
				}
			}
		}	
	}
	IntStream.range(0,graph.getNumberOfVertices()).forEach(vertexQueue::add);
	Set<String> visitedEdges = new HashSet<>();
	while(!vertexQueue.isEmpty()) {
		int currentVertex = vertexQueue.poll();
		for(int currentAdjacentVertex: graph.getAdjacentVertices(currentVertex)) {
			String edge = String.valueOf(currentVertex) + String.valueOf(currentAdjacentVertex);
			 // Do not visit edges more than once in each iteration.
           if (visitedEdges.contains(edge)) {
               continue;
           }
			int distance = distanceTable.get(currentVertex).getDistance() +
					      graph.getWeightedEdge(currentVertex, currentAdjacentVertex);
			if(distance < distanceTable.get(currentAdjacentVertex).getDistance()) {
//				distanceTable.get(currentAdjacentVertex).setDistance(distance);
//				distanceTable.get(currentAdjacentVertex).setLastVertex(currentVertex);
				throw new IllegalArgumentException(" Graph contains cycle - can't have shortest path");
			}
		}
	}	
	
	return distanceTable;
}

public static class DistanceInfo {

    private int distance;
    private int lastVertex;

    public DistanceInfo() {
        // The initial distance to all nodes is assumed infinite. Set it to
        // a very large value rather than the maximum integer value. Bellman Ford
        // supports negative weights and adding anything to this distance can
        // make it a negative value which interferes with the algorithm.
        distance = 100000;
        lastVertex = -1 ;
    }

    public int getDistance() {
        return distance;
    }

    public int getLastVertex() {
        return lastVertex;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setLastVertex(int lastVertex) {
        this.lastVertex = lastVertex;
    }
}
}
