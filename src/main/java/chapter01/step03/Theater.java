package chapter01.step03;

/**
 * 소극장
 */
public class Theater {

	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(Audience audience) {
		// Theater가 ticketSeller의 sellTo라는 인터페이스에만 의존하도록 됨.
		this.ticketSeller.sellTo(audience);
	}
}