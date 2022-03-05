package com.sars.ds.graph;

import java.util.ArrayList;
import java.util.List;



public class AdjacencyMatrixGraph implements Graph{
	
	
	int numberOfVertices;
	int[][] adjacencyMatrix;
	private  GraphType graphType = GraphType.DIRECTED;
	
	public AdjacencyMatrixGraph(int numberOfVertices, GraphType graphType) {
		this.numberOfVertices = numberOfVertices;
		this.graphType =  graphType;
		this.adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
		for(int sourceVertexIndex=0;sourceVertexIndex<numberOfVertices;sourceVertexIndex++) {
			for(int destinationVertexIndex=0;destinationVertexIndex<numberOfVertices;destinationVertexIndex++) {
				adjacencyMatrix[sourceVertexIndex][destinationVertexIndex]=0;
			}
		}
	}
	

	@Override
	public void addEdge(int sourceVertexIndex, int destinationVertexIndex) {
		if(sourceVertexIndex>=getNumberOfVertices() && sourceVertexIndex<0 &&
				destinationVertexIndex>=getNumberOfVertices() 
				&& destinationVertexIndex<0) {
			new IllegalStateException("Vertices are not valid");
		}
		
		adjacencyMatrix[sourceVertexIndex][destinationVertexIndex] = 1;
		
		if(TypeofGraph() == GraphType.UNDIRECTED) {
			adjacencyMatrix[destinationVertexIndex][sourceVertexIndex] = 1;
		}
	}
	
	
	public void addEdge(int sourceVertexIndex, int destinationVertexIndex, int weight) {
		if(sourceVertexIndex>=getNumberOfVertices() && sourceVertexIndex<0 &&
				destinationVertexIndex>=getNumberOfVertices() 
				&& destinationVertexIndex<0) {
			throw new IllegalStateException("Vertices are not valid");
		}
		
		adjacencyMatrix[sourceVertexIndex][destinationVertexIndex] = weight;
		
		if(TypeofGraph()== GraphType.UNDIRECTED) {
			adjacencyMatrix[destinationVertexIndex][sourceVertexIndex] = weight;
		}
	}

	@Override
	public List<Integer> getAdjacentVertices(int vertex) {
		if(vertex<0 && vertex >= getNumberOfVertices()) {
			throw new IllegalStateException("Vertices are not valid");
		}
		List<Integer> adjacentVertices = new ArrayList<Integer>();
		
		for(int destinationVertexIndex=0;destinationVertexIndex<getNumberOfVertices();destinationVertexIndex++) {
			if(adjacencyMatrix[vertex][destinationVertexIndex]!=0) {
				adjacentVertices.add(destinationVertexIndex);
			}
		}
		
		
		return adjacentVertices;
	}
	
	public int getNumberOfVertices() {
		return this.numberOfVertices;
	}
	
	public int getWeightForVertices(int sourceVertexIndex,int destinationVertexIndex) {
		return this.adjacencyMatrix[sourceVertexIndex][destinationVertexIndex];
	}


	@Override
	public GraphType TypeofGraph() {
		return this.graphType;
	}


	@Override
	public int getWeightedEdge(int sourceVertexIndex, int destinationVertexIndex) {
		if(sourceVertexIndex>=getNumberOfVertices() && sourceVertexIndex<0 &&
				destinationVertexIndex>=getNumberOfVertices() 
				&& destinationVertexIndex<0) {
			throw new IllegalStateException("Vertices are not valid");
		}
		return adjacencyMatrix[sourceVertexIndex][destinationVertexIndex];
	}


	@Override
	public int getIndegree(int vertex) {
		if(vertex<0 && vertex >= getNumberOfVertices()) {
			throw new IllegalStateException("Vertices are not valid");
		}
		int inDegreeCount = 0;
		for(int sourceVertexIndex=0;sourceVertexIndex<getNumberOfVertices();sourceVertexIndex++) {
			if(adjacencyMatrix[sourceVertexIndex][vertex]!=0) {
				inDegreeCount++;
			}
		}
		return inDegreeCount;
	}

}
