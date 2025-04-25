package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        //위 코드는 AnnotationConfig..는 같지만 AutoAppConfig를 한게 다르다.
        //이 클래스를 들어가면 다 텅텅 비어있고 @ComponenetScan이 붙어서 저는 그냥 @Component 붙은 애들 스프링 빈으로 등록할거에요라고 적혀 있다.
        //이렇게 하면 따로 설정 파일을 안 만들어도 된다.
        //그리고 긴 설정 파일에 개발자가 특정 빈을 누락하는 일도 없어진다.
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = orderService.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);
    }
}
