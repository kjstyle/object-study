package chapter01.step03;

/**
 * 가방
 */
public class Bag {
	private long amount;
	private Invitation invitation;
	private Ticket ticket;

	/**
	 * 이벤트에 당첨되어 초대장과 핸드
	 *
	 * @param invitation
	 * @param amount
	 */
	public Bag(Invitation invitation, long amount) {
		this.invitation = invitation;
		this.amount = amount;
	}

	/**
	 * 가방안에 현금만 가지고 오는 경우
	 *
	 * @param amount
	 */
	public Bag(long amount) {
		this(null, amount);
	}

	public long hold(Ticket ticket) {
		if (this.hasInvitation()) {
			setTicket(ticket);
			return 0L;
		} else {
			setTicket(ticket);
			minusAmount(ticket.getFee());
			return ticket.getFee();
		}
	}

	public boolean hasInvitation() {
		return this.invitation != null;
	}

	public boolean hasTicket() {
		return this.ticket != null;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void minusAmount(long amount) {
		this.amount -= amount;
	}

	public void plusAmount(long amount) {
		this.amount += amount;
	}
}
