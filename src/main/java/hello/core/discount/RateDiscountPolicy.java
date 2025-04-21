package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            //이 로직 과연 정상적으로 할인 금액을 리턴할까? cmd + shift + T로 테스트 해보지
            return price * discountPercent / 100;
        } else{
            return 0;
        }
    }
}
