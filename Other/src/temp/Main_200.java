package temp;

public class Main_200 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int sum;
		int[] feld = {1,2,3,1,3,5,1,5,1,5};
		
		for(int a = 0; a < 10; a++){
			sum = 0;
			for(int b = a; b < 9; b++){
				for(int c = a; c < 8; c++){
					for(int d = a; d < 7; d++){
						sum = sum + feld[a];
						sum = sum - feld[b+1];
						sum = sum * feld[c+2];
						//sum = sum / feld[d+3];
						System.out.println("" + sum);
						if(sum == 200){
							System.out.println("Erfolg: " + sum);
							break;
						}
					}
				}
			}
		}
	}
}
