 package hello.core.scan.filter;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
//컴포넌트 스캔에 제외할 애노테이션
public @interface MyExcludeComponent {
}
