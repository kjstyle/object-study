package chapter01.step02;

/**
 * 소극장
 */
public class Theater {

	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(Audience audience) {
		if (audience.getBag().hasInvitation()) { // 관객의 가방을 열어보니 초대장이 발견되면
			Ticket ticket = ticketSeller.getTicketOffice().getTicket(); // 판매원이 근무하는 매표소에서 티켓을 하나꺼낸다
			audience.getBag().setTicket(ticket); // 관객의 가방을 열어 티켓을 넣는다
		} else { // 관객의 가방을 열어보니 초대장이 없는 경우
			Ticket ticket = ticketSeller.getTicketOffice().getTicket(); // 판매원이 근무하는 매표소에서 티켓을 하나꺼낸다
			audience.getBag().minusAmount(ticket.getFee()); // 관객의 가방을 열어 티켓가격만큼 돈을 차감시킨다
			ticketSeller.getTicketOffice().plusAmount(ticket.getFee()); // 판매원이 근무하는 매표소의 잔고에 티켓가격만큼 플러스를 시킨다
			audience.getBag().setTicket(ticket); // 관객의 가방을 열어 티켓을 넣는다
		}
	}
}