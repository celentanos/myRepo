package pruefung_2006;
public class Main {

	public static void main(String[] args) {
		final int n = 500;
		final int abstand = 10;
		boolean gefunden = false;

		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i % 5;
			System.out.println(a[i]);
		}

		for (int i = 0; i < n - abstand; i++) {
			// if (a[i] == a[i+1] || a[i] == a[i+2] || a[i] == a[i+3] || a[i] ==
			// a[i+4] || a[i] == a[i+5] || a[i] == a[i+6] || a[i] == a[i+7]
			// ||a[i] == a[i+8] || a[i] == a[i+9] || a[i] == a[i+10]) {
			for (int j = 1; j < abstand; j++) {
				if (a[i] == a[i + j]) {

					gefunden = true;
					break;
				}
			}
		}

		System.out.println(gefunden);
	}

}
