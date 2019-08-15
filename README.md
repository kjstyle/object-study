# the object book study
## CHAPTER01
* 모든 소프트웨어에는 3가지 목적
    * 제대로 실행되는 것
    * 변경을 위해 존재하는 것
    * 코드를 읽는 사람과 의사소통하는 것
* 문제점
    * 관람객과 판매원이 소극장의 통제를 받는 수동적인 존재
    * 세부적인 내용들을 한꺼번에 기억하고 있어야한다는 점
        * Audience가 Bag을 가지고있고, Bag안에는 현금(amount)과 티켓(ticket)이 들어있으며, TicketSeller가 TicketOffice에서 TIcket을 판매하고, TicketOffice안에 돈과 ticket이 보관돼 있다는 모든 사실을 동시에 기억해야만 함 -> 복잡하고 어려움
    * 변경에 취약한 코드
        * 만약 TicketOffice밖의 TicketSeller가 Ticket을 판매해야한다면?
        * 만약 Audience가 Bag이 없다면?
        * 만약 Audience가 현금이나 Invitation이 아닌 신용카드로 결제한다고하면?
        * 하나의 수정이 연결되어있는 상당수의 클래스의 변경이 발생해버림
            * 높은 결합도(coupling)
* (step2) 첫번째 개선
    * (기존문제)Theater가 Audience와 TicketSeller뿐 이나라 Audience소유의 Bag과 TicketSeller가 근무하는 TIcketOffice까지 맘대로 접근할 수 있었기때문 -> 자유도가 높음
    * 자율성을 높이자
        * Theater는 TicketSeller의 sellTo()라는 인터페이스에만 의존하도록해서, Theater가 TicketOffice를 몰라도 되도록 캡슐화
        * TicketSeller가 Audience의 Bag을 몰라도 되도록 Audience의 buy()메소드를 추가, buy()내에서 Audience가 초대장 소유 여부를 ‘직접’판단해서 지불할 금액을 리턴하도록 함
        * Bag이 캡슐화되고, Audience스스로 문제를 해결할 수 있도록 자율성을 높임
    * 응집도
        * 밀접하게 연관된 작업만을 수행하고, 연관성이 없는 작업은 다른 객체에게 위임 -> 응집도가 높다
    * 절차지향 vs 객체지향
        * 절차지향
            * enter메소드
                * 메소드 자체가 프로세스임
                * Audience, TicketSeller, Bag, TicketOffice는 데이터일 뿐
                * Theater가 전체적인 프로세스를 도맡아 처리 -> 독재자
                * 프로세스와 데이터를 서로 다른 모듈에 위치 시킴 -> 절차지향적
            * 가장 큰 문제
                * 데이터변경으로 인한 영향을 지역적으로 고립시키기 어렵다
                * Audience와 TicketSeller의 내부구현 변경-> Theater의 enter메서드를 함께 변경해야만
                * 여러군대 변경은 버그를 부르고, 버그가 두려워 변경을 어렵게 만듬
                * 결론 > 절차적 프로그래밍은 변경하기 어려운 코드를 양산하는 경향이 있다
        * 객체지향
            * 변경하기 쉬운 설계 = 한 번에 하나의 클래스만 변경할 수 있는 설계
            * 방법? 자신의 데이터를 스스로 처리하도록
            * 데이터와 프로세스가 동일모듈(class)내에 위치하도록
            * 캡슐화를 이용해 의존성을 적절히 관리 -> 객체 사이의 결합도를 낮추는 것 -> 유연하다는 것
* (step3) 두번째 개선
    * 가방속의 Invitation과 Ticket은 Bag의 데이터이고, Invitation이 존재하는지 체크해서 TIcket을 넣고 빼는 일련의 비지니스는 Bag이 책임져야
    * 매표소의 티켓들과 Amount는 매표소의 것, 티켓을 하나 빼는 것과 지불받은 티켓값을 더하는 행위의 책임은 판매원이 아닌 매표소의 책임범위임
* 객체지향 설계
    * 설계란 코드를 배치하는 것이다
    * 오늘까지 완성해야할 기능을 구현하는 코드를 짜야하는 동시에 + 내일 쉽게 변경할 수 있는 코드를 짜야한다
    * 요구사항은 ‘항상’ 변경된다.
        * 개발 시작 시점에 ‘모든’ 요구사항을 수집하는 건 불가능
    * 우리가 진정으로 원하는 것은 변경에 유연하게 대응할 수 있는 코드다
    * 변경가능한 코드 = 이해하기 쉬운 코드


