package chapter02.step01;

/**
 * 예매
 */
public class Reservation {

	private Customer customer;
	private Screening screening;
	private Money fee;
	private int audienceCount;

	public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
		this.screening = screening;
		this.customer = customer;
		this.fee = fee;
		this.audienceCount = audienceCount;
	}

	public Money getFee() {
		return fee;
	}
}
