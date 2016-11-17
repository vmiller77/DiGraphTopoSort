package DiGraph_A5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DiGraph implements DiGraph_Interface {

	List<Vertex> nodes;
	Map<String, Vertex> nodeNames;
	List<Edge> edges;

	public DiGraph() {
		nodes = new ArrayList<Vertex>();
		nodeNames = new HashMap<String, Vertex>();
		edges = new ArrayList<Edge>();
	}

	public boolean addNode(long idNum, String label) {
		for (Vertex v : nodes) {
			if (v.getId() == idNum || label == null || v.getName().compareTo(label) == 0) {
				return false;
			}
		}
		if (idNum < 0 || label == null) {
			return false;
		} else {
			Vertex noob = new Vertex(idNum, label);
			nodes.add(noob);
			nodeNames.put(label, noob);
			return true;
		}
	}

	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		for (Edge e : edges) {
			if (e.getId() == idNum || ((e.getEnd().getName().compareTo(dLabel) == 0)
					&& e.getStart().getName().compareTo(sLabel) == 0)) {
				return false;
			}
		}
		if (!nodeNames.containsKey(sLabel) || !nodeNames.containsKey(dLabel) || idNum < 0) {
			return false;
		} else {
			Edge noob = new Edge(idNum, nodeNames.get(sLabel), nodeNames.get(dLabel), weight, eLabel);
			edges.add(noob);
			nodeNames.get(dLabel).addIn();
			return true;
		}
	}

	public boolean delNode(String label) {
		if (!nodeNames.containsKey(label)) {
			return false;
		} else {
			nodes.remove(nodes.indexOf(nodeNames.get(label)));
			nodeNames.remove(label);
			List<Edge> delEdges = new ArrayList<Edge>();
			for (Edge e : edges) {
				if (e.getStart().getName().compareTo(label) == 0 || e.getEnd().getName().compareTo(label) == 0) {
					delEdges.add(e);
				}
			}
			for (Edge e : delEdges) {
				delEdge(e.getStart().getName(), e.getEnd().getName());
			}
			return true;
		}
	}

	public boolean delEdge(String sLabel, String dLabel) {
		for (Edge e : edges) {
			if (e.getStart().getName().compareTo(sLabel) == 0 && e.getEnd().getName().compareTo(dLabel) == 0) {
				edges.remove(edges.indexOf(e));
				nodeNames.get(dLabel).delIn();
				return true;
			}
		}
		return false;
	}

	public void print() {
		for (Vertex v : nodes) {
			System.out.println("Node Name: " + v.getName());
			for (Edge e : edges) {
				if (e.getStart().equals(v)) {
					System.out.println(
							"(" + "Node id: " + v.getId() + ")---" + e.getWeight() + "---> " + e.getEnd().getId());
				}
			}
		}
	}

	public long numNodes() {
		return nodes.size();
	}

	public long numEdges() {
		return edges.size();
	}

	public boolean hasParents(Vertex v) {
		for (Edge e : edges) {
			if (e.getEnd() == v) {
				return true;
			}
		}
		return false;
	}

	public boolean aCyclic(Vertex n) {
		Stack<Vertex> stack = new Stack<Vertex>();
		stack.add(n);
		n.visited = true;
		while (!stack.isEmpty()) {
			Vertex element = stack.pop();
			List<Vertex> dir = new ArrayList<Vertex>();
			for (Edge e : edges) {
				if (e.getStart() == element) {
					dir.add(e.getEnd());
				}
			}
			for (int i = 0; i < dir.size(); i++) {
				Vertex end = dir.get(i);
				if (end != null && !end.visited) {
					stack.add(end);
					end.visited = true;
				} else if (end.getName().compareTo(n.getName()) == 0) {
					return false;
				}
			}
		}
		clearVisited();
		stack.clear();
		return true;
	}

	public void clearVisited() {
		for (Vertex v : nodes) {
			v.visited = false;
		}
	}

//	@Override
//	public String[] topoSort() {
//		List<Edge> subEdges = new ArrayList<Edge>();
//		for (Edge e : edges) {
//			subEdges.add(e);
//		}
//		for (Vertex v : nodes) {
//			if (aCyclic(v) == false) {
//				return null;
//			}
//		}
//		if (numNodes() == 0 || numEdges() == 0) {
//			return null;
//		} else {
//			String[] sorted = new String[(int) numNodes()];
//			List<Vertex> sortedList = new ArrayList<Vertex>();
//			Stack<Vertex> beginner = new Stack<Vertex>();
//			for (Vertex v : nodes) {
//				if (!hasParents(v)) {
//					beginner.add(v);
//				}
//			}
//			while (!beginner.isEmpty()) {
//				Vertex b = beginner.pop();
//				sortedList.add(b);
//				for (Edge e : subEdges) {
//					if (e.getStart() == b) {
//						delEdge(b.getName(), e.getEnd().getName());
//						if (!hasParents(e.getEnd())) {
//							beginner.add(e.getEnd());
//						}
//					}
//				}
//			}
//			for (int i = 0; i < sortedList.size(); i++) {
//				sorted[i] = sortedList.get(i).getName();
//			}
//			return sorted;
//		}
//	}

	public List<Vertex> getAdj(Vertex v) {
		List<Vertex> adj = new ArrayList<Vertex>();
		for (Edge e : edges) {
			if (e.getStart().equals(v)) {
				adj.add(e.getEnd());
			}
		}
		return adj;
	}

	public String[] topoSort() {
		String[] sorted = new String[nodes.size()];
		List<String> sortedList = new ArrayList<String>();
		List<Vertex> q = new ArrayList<Vertex>();
		for (Vertex v : nodes) {
			if (v.getIn() == 0) {
				q.add(v);
			}
		}
		while (!q.isEmpty()) {
			Vertex n = q.remove(0);
			if (sortedList.contains(n)) {
				return null;
			}
			sortedList.add(n.getName());
			for (Vertex v : getAdj(n)) {
				v.delIn();
				if (v.getIn() == 0) {
					q.add(v);
				}
			}
		}
		for(int i = 0; i < sorted.length;i++){
			sorted[i] = sortedList.get(i);
		}
		return sorted;
	}
}
