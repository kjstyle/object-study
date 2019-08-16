package chapter02.step01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 할인정책
 */
public abstract class DiscountPolicy {

	private List<DiscountCondition> conditions = new ArrayList<>();

	public DiscountPolicy(DiscountCondition... conditions) {
		this.conditions = Arrays.asList(conditions);
	}

	public Money calculateDiscountAmount(Screening screening) {
		for (DiscountCondition each : conditions) {
			if (each.isSatisfiedBy(screening)) { // 상영정보를 넘겨주고 할인조건을 만족하는지 확인
				return getDiscountAmount(screening); // 할인조건을 만족하면 구현체에서 정의한 할인금액을 반환하도록함
			}
		}
		return Money.ZERO;
	}

	protected abstract Money getDiscountAmount(Screening screening);
}
