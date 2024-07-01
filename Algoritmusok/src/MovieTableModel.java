import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MovieTableModel extends AbstractTableModel {


    private final List<Movie> movies;
    private final static String[] COLUMN_NAMES = new String[]{"rank", "releaseYear", "duration", "ageLimit", "imdbRating", "metaScore", "description", "name"};

    public MovieTableModel(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getRowCount() {
        return movies.size();
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movie movie = movies.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return movie.getRank();
            case 1:
                return movie.getReleaseYear();
            case 2:
                return movie.getDuration();
            case 3:
                return movie.getAgeLimit();
            case 4:
                return movie.getImdbRating();
            case 5:
                return movie.getMetaScore();
            case 6:
                return movie.getDescription();
            case 7:
                return movie.getName();
            default:
                throw new IndexOutOfBoundsException();
        }
    }
}
