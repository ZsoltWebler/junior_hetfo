package lotto;

import java.util.Objects;
import java.util.Set;

public class LottoInformation {
	
	private final int year;
	private final int week;
	private final long amount;
	private final Set<Integer> winningNumbers;
	
	public LottoInformation(int year, int week, long amount, Set<Integer> winningNumbers) {
		super();
		this.year = year;
		this.week = week;
		this.amount = amount;
		this.winningNumbers = winningNumbers;
	}

	public int getYear() {
		return year;
	}

	public int getWeek() {
		return week;
	}

	public long getAmount() {
		return amount;
	}

	public Set<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	@Override
	public String toString() {
		return "LottoInformation [year=" + year + ", week=" + week + ", amount=" + amount + ", winningNumbers="
				+ winningNumbers + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, week, winningNumbers, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LottoInformation other = (LottoInformation) obj;
		return amount == other.amount && week == other.week && Objects.equals(winningNumbers, other.winningNumbers)
				&& year == other.year;
	}
	
	
	
	

}
