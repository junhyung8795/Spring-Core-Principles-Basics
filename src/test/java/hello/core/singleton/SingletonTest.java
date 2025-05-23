package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회. 호출할 때마다 객체를 생성하는지
        MemberService memberService = appConfig.memberService();

        //2. 조회. 호출할 때마다 객체를 생성하는지
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인!
        System.out.println("memberService = " + memberService);
        System.out.println("memberService2 = " + memberService2);
        //memberService != memberService2테스트
        Assertions.assertThat(memberService).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체의 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        Assertions.assertThat(singletonService1).isEqualTo(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회. 호출할 때마다 객체를 생성하는지
        MemberService memberService = ac.getBean(MemberService.class);

        //2. 조회. 호출할 때마다 객체를 생성하는지
        MemberService memberService2 = ac.getBean(MemberService.class);

        //참조값이 다른 것을 확인!
        System.out.println("memberService = " + memberService);
        System.out.println("memberService2 = " + memberService2);
        //memberService != memberService2테스트
        Assertions.assertThat(memberService).isSameAs(memberService2);
    }
}
