package chapter02.step01;

/**
 * 할인조건
 */
public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}
