package lotto;

import java.util.Set;

public class LottoInformation {
	private final int year;
	private final int week;
	private final long largestWin;
	private final Set<Integer> winningNumbers;

	public LottoInformation(int year, int week, long largestWin, Set<Integer> winningNumbers) {
		super();
		this.year = year;
		this.week = week;
		this.largestWin = largestWin;
		this.winningNumbers = winningNumbers;
	}
	public int getYear() {
		return year;
	}
	public int getWeek() {
		return week;
	}
	public long getLargestWin() {
		return largestWin;
	}
	public Set<Integer> getWinningNumbers() {
		return winningNumbers;
	}
	
	
}
