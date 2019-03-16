import java.util.*;

public class ListGraph implements Graph {
    private HashMap<String, LinkedList<String>> nodes = new HashMap<String, LinkedList<String>>();;
    
    public boolean addNode(String n) {
	//throw new UnsupportedOperationException();
		if(nodes.containsKey(n))
		{
			return false;
		}
		nodes.put(n, new LinkedList<String>());
		return true;
    }

    public boolean addEdge(String n1, String n2) {
	//throw new UnsupportedOperationException();
		if(!(nodes.containsKey(n1)&&nodes.containsKey(n2)))//check node exist
		{
			throw new NoSuchElementException();
		}
		if(nodes.get(n1).contains(n2))
		{
			return false;
		}
		nodes.get(n1).add(n2);
		return true;
    }

    public boolean hasNode(String n) {
	//throw new UnsupportedOperationException();
	
		return nodes.containsKey(n);

    }

    public boolean hasEdge(String n1, String n2) {
	//throw new UnsupportedOperationException();
		if(nodes.containsKey(n1)&&nodes.containsKey(n2))//check if n1 n2 exist
		{
			if(nodes.get(n1).contains(n2))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
    
    }
    
    public List<String> succ(String n) {
	//throw new UnsupportedOperationException();
		if(!nodes.containsKey(n))//check node exist
		{
			throw new NoSuchElementException();
		}
		return nodes.get(n);
    }

    public List<String> pred(String n) {
	//throw new UnsupportedOperationException();
		if(!nodes.containsKey(n))//check node exist
		{
			throw new NoSuchElementException();
		}
		LinkedList<String>predlist = new LinkedList<String>();
		for (String n_in : nodes.keySet()) {
			if(nodes.get(n_in).contains(n))
			{
				predlist.add(n_in);
			}
		}
		return predlist;
    }

    public boolean connected(String n1, String n2) {
	//throw new UnsupportedOperationException();
		if(!(nodes.containsKey(n1)&&nodes.containsKey(n2)))//check node exist
		{
			throw new NoSuchElementException();
		}
		//BFS
		LinkedList<String>waitqueue = new LinkedList<String>();
		LinkedList<String>visitedmark = new LinkedList<String>();
		waitqueue.offer(n1);
		while(!waitqueue.isEmpty())
		{
			String n_now = waitqueue.poll();
			if(n_now.equals(n2))
			{
				return true;
			}
			visitedmark.add(n_now);
			for (String n : nodes.get(n_now))
			{
				if(!visitedmark.contains(n))
				{
					waitqueue.offer(n);
				}
			}
		}
		return false;
    }
}