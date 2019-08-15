package chapter01.step03;

/**
 * 관객
 */
public class Audience {
	private Bag bag;

	public Audience(Bag bag) {
		this.bag = bag;
	}

	/**
	 * bag이 할일을 bag에게 위임시키고 관여치않음 = bag의 캡슐화
	 *
	 * @param ticket
	 * @return 실제 지불한 티켓값
	 */
	public long buy(Ticket ticket) {
		return this.bag.hold(ticket);
	}
}
