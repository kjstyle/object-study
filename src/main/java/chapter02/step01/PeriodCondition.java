package chapter02.step01;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 상영시작시간이 특정기간 안에 포함될 경우 할인조건
 */
public class PeriodCondition implements DiscountCondition {

	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;

	public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		return screening.getStartTime().getDayOfWeek().equals(this.dayOfWeek) &&
				startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 && // 기간시작 <= 상영시작시간
				endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0      // 기간종료 >= 상영시작시간
				;
	}
}
