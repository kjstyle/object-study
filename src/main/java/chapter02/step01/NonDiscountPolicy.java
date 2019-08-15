package chapter02.step01;

/**
 * 할인이 없는 정책
 */
public class NonDiscountPolicy extends DiscountPolicy {
	@Override
	protected Money getDiscountAmount(Screening screening) {
		return Money.ZERO;
	}
}
