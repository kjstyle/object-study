package chapter01.step02;

/**
 * 관객
 */
public class Audience {
	private Bag bag;

	public Audience(Bag bag) {
		this.bag = bag;
	}

	/**
	 * bag이 나(관람객)만 접근하고 통제되도록 캡슐화되어버림
	 *
	 * @param ticket
	 * @return 실제 지불한 티켓값
	 */
	public long buy(Ticket ticket) {
		if (this.bag.hasInvitation()) { // 내 가방에 초대장이 들어있으면
			this.bag.setTicket(ticket); // 받은 티켓을 가방에 넣는다
			return 0L;

		} else { // 내 가방에 초대장이 없으면
			this.bag.minusAmount(ticket.getFee()); // 티켓값만큼 돈을 내어주고
			this.bag.setTicket(ticket); // 받은 티켓을 가방에 넣는다
			return ticket.getFee();
		}
	}
}
