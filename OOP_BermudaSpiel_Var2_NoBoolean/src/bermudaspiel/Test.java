package bermudaspiel;

public class Test {

	public static void main(String[] args) {
		Highscore highscore = Highscore.getInstance();

		highscore.add(new Score("Emmy", 5));
		highscore.add(new Score("Phuong", 10));
		highscore.add(new Score("unknown", 40));

		for (int i = 0; i < highscore.size(); i++) {
			Score score = highscore.get(i);
			System.out.println(score.getName() + " : " + score.getSekunden());

		}

	}

}
