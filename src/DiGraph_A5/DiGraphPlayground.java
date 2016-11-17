package DiGraph_A5;

import java.util.Iterator;

public class DiGraphPlayground {

	public static void main(String[] args) {

		// thorough testing is your responsibility
		//
		// you may wish to create methods like
		// -- print
		// -- sort
		// -- random fill
		// -- etc.
		// in order to convince yourself your code is producing
		// the correct behavior
		 //exTest();
		//addNodeTest();
		//delNodetest();
		//addEdgeTest();
		//delEdgeTest();
		//acyclicTest();
		newtopo();
	}

	public static void newtopo(){
		DiGraph d = new DiGraph();
		d.addNode(1, "f");
		d.addNode(3, "s");
		d.addNode(7, "t");
		d.addNode(0, "fo");
		d.addNode(4, "fi");
		d.addNode(6, "si");
		d.addEdge(0, "f", "s", 0, null);
		d.addEdge(1, "f", "si", 0, null);
		d.addEdge(2, "s", "t", 0, null);
		d.addEdge(3, "fo", "fi", 0, null);
		d.addEdge(4, "fi", "si", 0, null);
		printTOPO(d.topoSort());
		//printTOPO(d.newTopoSort());
		d = new DiGraph();
		d.addNode(1, "1");
		d.addNode(3, "2");
		d.addNode(7, "3");
		d.addNode(0, "4");
		d.addNode(4, "5");
		d.addNode(6, "6");
		d.addNode(8, "7");
		d.addEdge(0, "1", "2", 0, null);
		d.addEdge(1, "1", "4", 0, null);
		d.addEdge(2, "1", "3", 0, null);
		d.addEdge(3, "3", "6", 0, null);
		d.addEdge(4, "4", "6", 0, null);
		d.addEdge(5, "4", "7", 0, null);
		d.addEdge(6, "2", "4", 0, null);
		d.addEdge(7, "2", "5", 0, null);
		d.addEdge(8, "5", "4", 0, null);
		d.addEdge(9, "5", "7", 0, null);
		d.addEdge(10,"7", "6", 0, null);
		d.addEdge(11,"4", "3", 0, null);
		printTOPO(d.topoSort());
		//printTOPO(d.newTopoSort());
		d = new DiGraph();
		d.addNode(1, "4");
		d.addNode(3, "1");
		d.addNode(7, "8");
		d.addNode(0, "2");
		d.addNode(4, "7");
		d.addNode(6, "5");
		d.addEdge(0, "2", "5", 0, null);
		d.addEdge(1, "4", "7", 0, null);
		d.addEdge(2, "1", "8", 0, null);
		d.addEdge(3, "2", "8", 0, null);
		d.addEdge(4, "4", "5", 0, null);
		d.addEdge(5, "1", "2", 0, null);
		d.addEdge(6, "1", "5", 0, null);
		d.addEdge(7, "1", "7", 0, null);
		d.addEdge(8, "8", "5", 0, null);
		d.addEdge(9, "1", "4", 0, null);
		d.addEdge(10,"5", "7", 0, null);
		d.addEdge(11,"4", "2", 0, null);
		d.addEdge(12,"8", "7", 0, null);
		d.addEdge(13,"4", "8", 0, null);
		d.addEdge(14,"2", "7", 0, null);
		printTOPO(d.topoSort());
		//printTOPO(d.newTopoSort());
		
	}
	
	public static void exTest() {
		DiGraph d = new DiGraph();
		d.addNode(1, "f");
		d.addNode(3, "s");
		d.addNode(7, "t");
		d.addNode(0, "fo");
		d.addNode(4, "fi");
		d.addNode(6, "si");
		d.addEdge(0, "f", "s", 0, null);
		d.addEdge(1, "f", "si", 0, null);
		d.addEdge(2, "s", "t", 0, null);
		d.addEdge(3, "fo", "fi", 0, null);
		d.addEdge(4, "fi", "si", 0, null);
		System.out.println("numEdges: " + d.numEdges());
		System.out.println("numNodes: " + d.numNodes());
		printTOPO(d.topoSort());

	}

	public static void addNodeTest() {
		System.out.println("=====TESTING FOR ADDING NODES=====");
		DiGraph d = new DiGraph();
		d.addNode(100, "a");
		d.addNode(101, "a");
		d.addNode(-1, "b");
		d.addNode(101, null);
		d.addNode(101, "b");
		d.addNode(102, "c");
		d.addNode(103, "d");
		System.out.println("numEdges: " + d.numEdges());
		System.out.println("numNodes: " + d.numNodes());
		print(d);
	}

	public static void delNodetest() {
		System.out.println("=====TESTING FOR DELETING NODES=====");
		DiGraph d = new DiGraph();
		d.addNode(100, "a");
		d.addNode(101, "b");
		d.addNode(102, "c");
		d.addNode(103, "d");
		d.delNode("a");
		d.delNode("a");
		d.delNode("b");
		d.delNode("c");
		d.delNode("d");
		System.out.println("numEdges: " + d.numEdges());
		System.out.println("numNodes: " + d.numNodes());
		print(d);
	}
	
	public static void addEdgeTest() {
		System.out.println("=====TESTING FOR ADDING EDGES=====");
		DiGraph d = new DiGraph();
		d.addNode(100, "a");
		d.addNode(101, "b");
		d.addNode(102, "c");
		d.addNode(103, "d");
		d.addEdge(1, "a", "b", 0, "uno");
		d.addEdge(2, "a", "c", 0, "dos");
		System.out.println("numEdges: " + d.numEdges());
		System.out.println("numNodes: " + d.numNodes());
		print(d);
	}
	public static void delEdgeTest() {
		System.out.println("=====TESTING FOR DELETING EDGES=====");
		DiGraph d = new DiGraph();
		d.addNode(100, "a");
		d.addNode(101, "b");
		d.addNode(102, "c");
		d.addNode(103, "d");
		d.addEdge(1, "a", "b", 0, "uno");
		d.addEdge(2, "a", "c", 0, "dos");
		d.addEdge(3, "a", "d", 0, "tres");
		d.addEdge(4, "d", "a", 0, "quatro");
//		d.delEdge("a", "b");
//		d.delEdge("a", "c");
//		d.delEdge("a", "d");
		d.aCyclic(d.nodes.get(0));
		System.out.println("numEdges: " + d.numEdges());
		System.out.println("numNodes: " + d.numNodes());
		print(d);
	}

	public static void acyclicTest() {
		System.out.println("=====TESTING FOR acyclic=====");
//		DiGraph d = new DiGraph();
//		d.addNode(100, "a");
//		d.addNode(101, "b");
//		d.addNode(102, "c");
//		d.addNode(103, "d");
//		d.addEdge(1, "a", "b", 0, "uno");
//		d.addEdge(2, "a", "c", 0, "dos");
//		d.addEdge(3, "a", "d", 0, "tres");
//		d.addEdge(4, "d", "a", 0, "quatro");
//		System.out.println("D - Acyclic "+d.aCyclic(d.nodes.get(0)));
//		DiGraph a = new DiGraph();
//		a.addNode(1, "a");
//		a.addEdge(1, "a", "a", 0, "self edge");
//		System.out.println("A - Acyclic "+ a.aCyclic(a.nodes.get(0)));
		DiGraph b = new DiGraph();
		b.addNode(1, "a");
		b.addNode(2, "b");
		b.addNode(3, "c");
		b.addNode(4, "d");
		b.addEdge(1, "a", "b", 0, "uno");
		b.addEdge(2, "c", "a", 0, "dos");
		b.addEdge(3, "b", "c", 0, "tres");
		b.addEdge(3, "c", "d", 0, "quatro");

		System.out.println("B - Acyclic "+ b.aCyclic(b.nodes.get(3)));

	}
	public static void printTOPO(String[] toPrint) {
		System.out.print("TOPO Sort: ");
		for (String string : toPrint) {
			System.out.print(string + " ");
		}
		System.out.println();
	}

	public static void print(DiGraph d) {
		System.out.println("-----Nodes List-----");
		for (Vertex v : d.nodes) {
			System.out.print(v.getName() + " ");
		}
		System.out.println("");
		System.out.println("-----Nodes HashMap-----");
		Iterator<String> nodesHM = d.nodeNames.keySet().iterator();
		while (nodesHM.hasNext()) {
			System.out.print(nodesHM.next()+" ");
		}
		System.out.println("");
		System.out.println("-----Edges List-----");
		for (Edge e : d.edges) {
			System.out.println(e.getLabel() + " " + e.getPair());
		}
	}
}
