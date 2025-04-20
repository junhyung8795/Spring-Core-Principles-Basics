package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; //고정된 1000원을 할인
    @Override
    public int discount(Member member, int price) {
        //Enum은 .equals()가 아니라 ==으로 동일성 비교를 해주는게 맞다!
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else{
            //vip등급이 아니면 할인이 없다.
            return  0;
        }
    }
}
