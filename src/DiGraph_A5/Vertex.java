package DiGraph_A5;

public class Vertex {

	private String name;
	public boolean visited;
	private long id;
	private int in;

	public Vertex(long i, String s) {
		name = s;
		id = i;
		visited = false;
		in = 0;
	}
	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}
	public int getIn() {
		return in;
	}
	public void addIn() {
		in++;
	}
	public void delIn(){
		in--;
	}
}
