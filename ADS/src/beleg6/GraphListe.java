package beleg6;

import java.util.LinkedList;

public class GraphListe implements IGraph {
	
	LinkedList<Integer>[] graph;
	
	public GraphListe(int anzKnoten) {
		
		
		graph = new LinkedList[anzKnoten];
		
		for(int i = 0; i < anzKnoten; i++)
			graph[i] = new LinkedList<Integer>();
		
		
	}

	@Override
	public void addKante(int Start, int Ziel) {
		
		graph[Start-1].add(Ziel);
		
	}

	@Override
	public boolean testKante(int Start, int Ziel) {
		if(graph[Start-1].contains(Ziel))
			return true;
		return false;
	}

	@Override
	public int[] initAlleKantenEinesKnotenAusgeben(int Knoten) {
		
		int[] re = new int[graph.length];
		
		for(int i = 0; i < re.length; i++)
			re[i] = 0;
		
		for(Integer x : graph[Knoten])
			re[x-1] = 1;
		
		return re;
	}

	@Override
	public boolean existiertEineWeitereKante() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int zielKnotenDerNächstenKante() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
