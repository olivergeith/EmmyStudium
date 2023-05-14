
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class Sortieralgorithmen_Vergleich_mPlot extends JPanel {

	public static void main(final String args[]) {

		// laengeEingabeliste --> kann verändert werden
		final int laengeEingabeliste = 60;

		// Arrays zum speichern der Anazhl an Operationen initiieren
		final int[] selection = new int[laengeEingabeliste];
		final int[] bubble = new int[laengeEingabeliste];
		final int[] insertion = new int[laengeEingabeliste];

		// für jeden Sortieralgorithmus zufällige Listen erstellen und sortieren lassen
		for (int i = 1; i <= laengeEingabeliste; i++) {
			ArrayList<Integer> liste = new ArrayList<Integer>();

			/********************************************************************
			 * Selection Sort *
			 ********************************************************************/
			liste = randomUnsortedList(i);
			// für obere Grenze: die Liste mithilfe von sort absteigend sortieren
			Collections.sort(liste, Collections.reverseOrder());

			// Aufruf von Selection Sort mit gesetztem Zähler
			selection[i - 1] = SelectionSortClass.sortAndCount(liste); // Grüne Punkte

			/********************************************************************
			 * Insertion Sort *
			 ********************************************************************/
			liste = randomUnsortedList(i);
			// für obere Grenze: die Liste mithilfe von sort absteigend sortieren
			Collections.sort(liste, Collections.reverseOrder());

			// Aufruf von Insertion Sort mit gesetztem Zähler
			insertion[i - 1] = InsertionSortClass.sortAndCount(liste); // Blaue Punkte

			/********************************************************************
			 * Bubble Sort *
			 ********************************************************************/
			liste = randomUnsortedList(i);
			// für obere Grenze: die Liste mithilfe von sort absteigend sortieren
			Collections.sort(liste, Collections.reverseOrder());

			// Aufruf von Bubble Sort mit gesetztem Zähler
			bubble[i - 1] = BubbleSortClass.sortAndCount(liste); // Rote Punkte

		}

		/************************************************************************
		 * Ab hier ist der Code nicht mehr für die * Lösung der Laboraufgabe relevant *
		 * * *
		 ************************************************************************/
		// Plot Details - kann ignoriert werden aber nichts verändern!!
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Sortieralgorithmen_Vergleich_mPlot(selection, insertion, bubble));
		frame.setSize(500, 500);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		/****************************************************************/
	}

	// Initialisierung
	int[] selectCord;
	int[] insertCord;
	int[] bubbleCord;
	int marg = 10;

	public Sortieralgorithmen_Vergleich_mPlot(final int[] selection, final int[] insertion, final int[] bubble) {
		this.selectCord = selection;
		this.insertCord = insertion;
		this.bubbleCord = bubble;
	}

	// Hilfsfunktion zur Generierung von zufälligen Listen einer bestimmten Länge
	private static ArrayList<Integer> randomUnsortedList(final int length) {

		final ArrayList<Integer> liste = new ArrayList<Integer>();
		final Random rand = new Random();

		for (int i = 0; i < length; i++) {
			liste.add(rand.nextInt(1000));
		}

		return liste;
	}

	/***************************************************************************/
	// Plot Funktionen - können komplett ignoriert werden aber nicht verändern!!
	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		final Graphics2D graph = (Graphics2D) g;

		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		final int width = getWidth();
		final int height = getHeight();

		graph.draw(new Line2D.Double(marg, marg, marg, height - marg));
		graph.draw(new Line2D.Double(marg, height - marg, width - marg, height - marg));

		final double x = (double) (width - 2 * marg) / (selectCord.length - 1);
		final double scale = (double) (height - 2 * marg) / getMax();

		// graph.setPaint(Color.RED);
		graph.setColor(new Color(55, 165, 0)); // Grün
		for (int i = 0; i < selectCord.length; i++) {
			final double x1 = marg + i * x;
			final double y1 = height - marg - scale * selectCord[i];
			graph.fill(new Ellipse2D.Double(x1 - 2, y1 - 2, 4, 4));
		}

		graph.setColor(new Color(55, 0, 0)); // Blau
		for (int i = 0; i < insertCord.length; i++) {
			final double x1 = marg + i * x;
			final double y1 = height - marg - scale * insertCord[i];
			graph.fill(new Ellipse2D.Double(x1 - 2, y1 - 2, 4, 4));
		}

		graph.setColor(new Color(238, 75, 43)); // Rot
		for (int i = 0; i < bubbleCord.length; i++) {
			final double x1 = marg + i * x;
			final double y1 = height - marg - scale * bubbleCord[i];
			graph.fill(new Ellipse2D.Double(x1 - 2, y1 - 2, 4, 4));
		}
	}

	private int getMax() {
		int max = 1;
		for (int i = 0; i < selectCord.length; i++) {
			if (selectCord[i] > max) {
				max = selectCord[i];
			}
		}
		for (int i = 0; i < insertCord.length; i++) {
			if (insertCord[i] > max) {
				max = insertCord[i];
			}
		}
		for (int i = 0; i < bubbleCord.length; i++) {
			if (bubbleCord[i] > max) {
				max = bubbleCord[i];
			}
		}
		return max;
	}
}