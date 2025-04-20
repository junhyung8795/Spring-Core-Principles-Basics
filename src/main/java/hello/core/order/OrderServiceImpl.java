package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    //두 개가 필요함
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

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

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
