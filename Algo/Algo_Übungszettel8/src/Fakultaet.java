public class Fakultaet {

	public static void main(String[] args) {

		int someNumber = 5;

		System.out.println(fakultaet(someNumber));
	}

	private static int fakultaet(int number) {
		if (number == 0) {
			return 1;
		}
		return fakultaet(number - 1) * number;
	}

}
