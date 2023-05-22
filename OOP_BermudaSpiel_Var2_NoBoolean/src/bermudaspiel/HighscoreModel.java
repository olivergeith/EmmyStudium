package bermudaspiel;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class HighscoreModel implements TableModel {
	Highscore highscore = Highscore.getInstance();
	private String[] columnNames = { "Name", "Sekunden" };
	private Object[][] data = { { highscore.get(getRowCount()), highscore.get(getColumnCount()) } };

	@Override
	public int getRowCount() {
		return highscore.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return highscore.toString();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	//
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
