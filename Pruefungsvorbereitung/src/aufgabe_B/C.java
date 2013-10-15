package aufgabe_B;

public class C {
	public static void main(String[] args) {
		int i = 0;
		while (i < args.length) {
			if ((i % 3) == 0)
				args[i] = null;
			System.out.println(i + " " + args.length + " " + args[i]);
			i = i + 1;
		}

		if (args.length > 1)
			try {
				System.out.println(new String(args[args.length / 2]));
			} catch (Exception e) {
				System.out.println("Skazal zhe - MYLO!!!");
			}
	}
}