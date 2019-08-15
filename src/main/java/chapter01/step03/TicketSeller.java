package chapter01.step03;

/**
 * 판매원
 */
public class TicketSeller {
	private TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}

	/**
	 * 매표소의 자율권을 찾아줌, Ticket과 매표소의 Amount의 주인은 TicketOffice이다. TicketOffice가 스스로할 수 있도록 setTicketTo로 위임
	 *
	 * @param audience
	 */
	public void sellTo(Audience audience) {
		this.ticketOffice.sellTicketTo(audience);
	}
}
