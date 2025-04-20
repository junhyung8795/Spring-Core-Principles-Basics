package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    //정말 RateDiscountPolicy가 10프로 할인을 하는지 봐보자
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    //junit5는 한글로 이름을 쓸 수가 있다. @DisplayName으로.
    @Test
    @DisplayName("VIp는 10프로 할인 적용돼야함")//이게 테스트 옆에 메시지로 보여짐
    void vip_o () {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    //성공 테스트 뿐만 아니라 실패나 예외 테스트도 꼭 만들어봐야한다!
    @Test
    @DisplayName("VIp가 아니면 할인 적용이 안돼야 한다.")
    void vip_x () {
        //given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        //Expected는 1000 Actual은 0이라고 하면서 1000을 기대했지만 실제로는 0이라면서 빨간색 테스트 오류를 보여준다.
//        Assertions.assertThat(discount).isEqualTo(1000);
        assertThat(discount).isEqualTo(0);
    }
//메서드말고 클래스 레벨에서도 테스트해봐라.


}