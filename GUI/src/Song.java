import java.util.Objects;

public class Song {
	
	private final int minute;
	private final int seconds;
	private final String artist;
	private final String title;
	
	public Song(int minute, int seconds, String artist, String title) {
		super();
		this.minute = minute;
		this.seconds = seconds;
		this.artist = artist;
		this.title = title;
	}

	public int getMinute() {
		return minute;
	}

	public int getSeconds() {
		return seconds;
	}

	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(artist, minute, seconds, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		return Objects.equals(artist, other.artist) && minute == other.minute && seconds == other.seconds
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Song [minute=" + minute + ", seconds=" + seconds + ", artist=" + artist + ", title=" + title + "]";
	}

	
	
	
	
}
