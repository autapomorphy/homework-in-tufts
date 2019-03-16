import java.util.*;

public class EdgeGraphAdapter implements EdgeGraph {

    private Graph g;
    
    EdgeGraphAdapter(Graph g) { this.g = g; }

    public boolean addEdge(Edge e) {
	//throw new UnsupportedOperationException();
		g.addNode(e.getSrc());
		g.addNode(e.getDst());
		
		return g.addEdge(e.getSrc(),e.getDst());
    }

    public boolean hasNode(String n) {
	//throw new UnsupportedOperationException();
		if(!g.hasNode(n))
		{
			return false;
		}
		if(!(g.succ(n).isEmpty()&&g.pred(n).isEmpty()))
		{
			return true;
		}
		else
		{
			return false;
		}
    }

    public boolean hasEdge(Edge e) {
	//throw new UnsupportedOperationException();
		return g.hasEdge(e.getSrc(),e.getDst());
    }

    public boolean hasPath(List<Edge> e) {
	//throw new UnsupportedOperationException();
		if(e.size() == 0)
		{
			return true;
		}
		
		for (int index_e = 0;index_e < e.size(); index_e = index_e + 1)
		{
			//check badpath
			if(index_e < (e.size()-1)){
				if(!e.get(index_e).getDst().equals(e.get(index_e+1).getSrc()))
				{
					throw new BadPath();
				}
			}
			//check if exist
			if(g.hasEdge(e.get(index_e).getSrc(),e.get(index_e).getDst()) == false)
			{
				return false;
			}
		}
		return true;
    }

}