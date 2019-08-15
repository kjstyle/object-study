package chapter02.step01;

import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 영화테스트
 */
public class MoiveTest {

	public static final long ALADDIN_DEFAULT_FEE = 12000L;
	public static final long DISCOUNT_AMOUNT = 1000L;
	public static final int AUDIENCE_COUNT = 2;

	@Test
	public void 금액할인되는영화만들기() {
		Movie aladdin = new Movie(
				"알라딘",
				Duration.ofMinutes(130),
				Money.wons(ALADDIN_DEFAULT_FEE),
				new AmountDiscountPolicy(Money.wons(DISCOUNT_AMOUNT), // 무조건 1200원 할인해줌
						new SequenceCondition(1), // 할인조건 > 1회차에 해당하면
						new SequenceCondition(10), // 할인조건 > 10회차에 해당하면
						new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)), // 할인조건 > 월요일 상영시작시간이 10시부터 11시59분까지면
						new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)) // 할인조건 > 목요일 상영시작시간이 10시부터 20시 59분까지면
				)
		);

		Screening screening01 = new Screening(aladdin, 1, LocalDateTime.of(2019, 8, 19, 10, 0, 0)); // 월요일 10시 0분에 상영시작
		Screening screening02 = new Screening(aladdin, 2, LocalDateTime.of(2019, 8, 19, 13, 10, 0)); // 월요일 13시 10분에 상영시작

		Reservation r1 = screening01.reserve(new Customer("이길주", "kjstyle"), AUDIENCE_COUNT);
		Money expectedPaidAmount = Money.wons(ALADDIN_DEFAULT_FEE - DISCOUNT_AMOUNT).times(AUDIENCE_COUNT);
		Assert.assertTrue(expectedPaidAmount.equals(r1.getFee()));

		Reservation r2 = screening02.reserve(new Customer("이희진", "hjlove"), AUDIENCE_COUNT);
		Money expectedPaidAmount2 = Money.wons(ALADDIN_DEFAULT_FEE).times(AUDIENCE_COUNT);
		Assert.assertTrue(expectedPaidAmount2.equals(r2.getFee()));
	}
}
