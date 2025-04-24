package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        //basePackages = "hello.core.member",//이렇게하면 member패키지 하위에서만 컴포넌트 스캔을 한다.
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean//(name= "memoryMemberRepository")
    //MemoryMemberRepository라는 클래스 명에서 맨앞 글자를 소문자로 하고 컴포넌트스캔하는데
    //설정파일에서도 중복되는 이름을 만들면 예외는 안터지지만 설정파일에 있는 빈을 우선으로 만든다.
    //같은 이름의 빈이 존재하면 설정 파일로 수동으로 빈을 저장한게 우선권을 가진다. 수동빈이 자동빈을 오버라이딩 한다.
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean(name = "memberServiceImpl")
    MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }


}
