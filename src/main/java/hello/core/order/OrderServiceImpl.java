package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("componentTest")
public class OrderServiceImpl implements OrderService {
    //두 개가 필요함
    @Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;
    //위 코드는 필드 주입으로 스프링 빈을 의존관계를 주입한 것.

//    @Autowired(required = false)
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//        System.out.println("세터 주입 memberRepository = " + memberRepository);
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("세터 주입 discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }
//    @Autowired//의존관계 주입을 설정파일에선 다 명시해줬지만 여기선 클래스 파일안에서 직접 해줘야 한다.
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        System.out.println("orderservice에 생성자 주입");
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //id로 멤버를 먼저 찾는다.
        Member member = memberRepository.findById(memberId);
        //멤버를 DiscountPolicy에 넘기면 DiscountPolicy에가 알아서 등급 빼와서 계산함.
        //이부분이 설계가 잘된게 OrderService에는 할인에 관한 코드가 아예 없다. OrderService에서 등급을 빼서 전달하지 않.
        //역할을 OrderService와 DiscountPolicy가 잘 분리됏음. --> 단일 책임 원칙.
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //필드 주입으로 잘 들어갔는 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
