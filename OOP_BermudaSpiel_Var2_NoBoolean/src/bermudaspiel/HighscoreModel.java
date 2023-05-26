package bermudaspiel;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class HighscoreModel implements TableModel {
	private Highscore highscore;

	public HighscoreModel(Highscore highscore) {
		this.highscore = highscore;
	}

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
		if (columnIndex == 0) {
			return "Name";
		} else if (columnIndex == 1) {
			return "Sekunden";
		}
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
//		return highscore.toString();
		if (columnIndex == 0) {
			return highscore.get(rowIndex).getName();
		} else if (columnIndex == 1) {
			return highscore.get(rowIndex).getSekunden();
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0) {
			return String.class;
		} else if (columnIndex == 1) {
			return Integer.class;
		}
		return null;
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
