package beleg6;

public class GraphMatrix implements IGraph {

	int[][] matrix;
	
	int letzteGefundeneKante;

	public GraphMatrix(int anzKnoten) {

		matrix = new int[anzKnoten][anzKnoten];

		for (int i = 0; i < anzKnoten; i++)
			for (int j = 0; j < anzKnoten; j++)
				matrix[i][j] = 0;
		
		letzteGefundeneKante = 0;

	}

	@Override
	public void addKante(int Start, int Ziel) {

		matrix[Start-1][Ziel-1] = 1;

	}

	@Override
	public boolean testKante(int Start, int Ziel) {

		if (matrix[Start][Ziel] == 0)
			return false;
		return true;
	}

	@Override
	public int[] initAlleKantenEinesKnotenAusgeben(int Knoten) {
		
		return matrix[Knoten];

		
	}

	@Override
	public boolean existiertEineWeitereKante() {
		
		return false;
	}

	@Override
	public int zielKnotenDerNächstenKante() {
		// TODO Auto-generated method stub
		return 0;
	}

}
