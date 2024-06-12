import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class SongTableModel extends AbstractTableModel {

	private final String[] COLUMN_NAMES = new String[] { "ARTIST", "TITLE", "MINUTE", "SECOND" };

	private final List<Song> songs;

	public SongTableModel(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public int getRowCount() {
		return songs.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0: {

			return songs.get(rowIndex).getArtist();
		}
		case 1: {

			return songs.get(rowIndex).getTitle();
		}
		case 2: {

			return songs.get(rowIndex).getMinute();
		}
		case 3: {

			return songs.get(rowIndex).getSeconds();
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}
	
	

}
