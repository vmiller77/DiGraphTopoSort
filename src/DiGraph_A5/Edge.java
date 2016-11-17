package DiGraph_A5;

public class Edge {

	private Vertex start,end;
	private long weight;
	private long id;
	private String label;
	
	public Edge(long i, Vertex s, Vertex e,long w, String l){
		id = i;
		start = s;
		end = e;
		weight = w;
		label = l;
	}
	
	public String getPair(){
		return "Start: "+start.getName()+" End: "+end.getName();
	}
	
	public long getId(){
		return id;
	}
	public long getWeight(){
		return weight;
	}
	public Vertex getStart(){
		return start;
	}
	public Vertex getEnd(){
		return end;
	}
	public String getLabel(){
		return label;
	}
}

