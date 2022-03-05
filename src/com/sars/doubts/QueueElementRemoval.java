package com.sars.doubts;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class QueueElementRemoval {

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

	        public int getDistance() {
	            return distance;
	        }

			@Override
			public String toString() {
				return "VertexInfo [vertexId=" + vertexId + ", distance=" + distance + "]";
			}
	    }
	 
	 public static void main(String[] args) {
		 PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
	            @Override
	            public int compare(VertexInfo v1, VertexInfo v2) {
	                return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
	            }
	        });
		 
		 VertexInfo vertexInfo0 = new VertexInfo(0, 2);
		 VertexInfo vertexInfo00 = new VertexInfo(0,2);
		 VertexInfo vertexInfo1 = new VertexInfo(1, 3);
		 
		 queue.add(vertexInfo00);
		 queue.add(vertexInfo0);
		 queue.add(vertexInfo1);
		 
		 System.out.println("Queue "+ queue.toString());
		 Map<Integer,VertexInfo> vertexInfoMap = new HashMap();
		 vertexInfoMap.put(0,vertexInfo0);
		 vertexInfoMap.put(1,vertexInfo1);
		 
		 queue.remove(vertexInfoMap.get(1));
		 queue.remove(vertexInfoMap.get(0));
		 System.out.println("Queue "+ queue.toString());
		 
		 
	 }
}
