package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    //return이 할인 대상 금액.
    //1000원이 할인되면 1000원을 리턴
    int discount(Member member, int price );
}
