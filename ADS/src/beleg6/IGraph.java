package beleg6;

public interface IGraph {
	
	public void addKante(int Start, int Ziel);
	
	public boolean testKante(int Start, int Ziel);
	
	public int[] initAlleKantenEinesKnotenAusgeben(int Knoten);
	
	public boolean existiertEineWeitereKante();
	
	public int zielKnotenDerNächstenKante();

}
