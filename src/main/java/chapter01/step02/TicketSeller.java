package chapter01.step02;

/**
 * 판매원
 */
public class TicketSeller {
	private TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}

	/**
	 * Theater.enter의 메소드가 TicketSeller의 SellTo로 옮겨짐
	 * 이로인해, Theater와 TicketOffice간의 관계가 끊어지고, Ticketseller는 자신이 속한 TicketOffice에 this로 직접 접근
	 * 쉽게말해, ticketOffice를 캡슐화 한 것임
	 *
	 * @param audience
	 */
	public void sellTo(Audience audience) {
		Ticket ticket = this.ticketOffice.getTicket();
		long actualFee = audience.buy(ticket);
		this.ticketOffice.plusAmount(actualFee); // 관람객에게 받은 티켓값만큼 잔고가 늘어남
	}
}
