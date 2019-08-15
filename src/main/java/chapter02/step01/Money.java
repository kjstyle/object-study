package chapter02.step01;

import java.math.BigDecimal;

/**
 * 금액
 */
public class Money {
	public static final Money ZERO = Money.wons(0);

	private final BigDecimal amount;

	public Money(BigDecimal amount) {
		this.amount = amount;
	}

	public static Money wons(long amount) {
		return new Money(BigDecimal.valueOf(amount));
	}

	public static Money wons(double amount) {
		return new Money(BigDecimal.valueOf(amount));
	}

	public Money plus(Money _amount) {
		return new Money(this.amount.add(_amount.amount));
	}

	public Money minus(Money _amount) {
		return new Money(this.amount.subtract(_amount.amount));
	}

	public Money times(double percent) {
		return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
	}

	public boolean isLessThan(Money other) {
		return amount.compareTo(other.amount) < 0;
	}

	public boolean isGreaterThanOrEqual(Money other) {
		return amount.compareTo(other.amount) >= 0;
	}

	public boolean equals(Money other) {
		return amount.compareTo(other.amount) == 0;
	}
}
