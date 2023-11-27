package Hello.core.beanFind;

import Hello.core.AppConfig;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.*;

class ApplicationContextBasic {
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
  @Test
  @DisplayName("빈 이름으로 조회")
  void findBeanByName(){
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    System.out.println("memberService = " + memberService);
    System.out.println("memberService = " + memberService.getClass());
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }
  @Test
  @DisplayName("이름 없이 타입으로만 조회")
  void findBeanByTpe(){
    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }


  /**
   * 역할에 의존하지 않고 -> 구현에 의존하는 코드 좋은 코드가 아니다.
   */
  @Test
  @DisplayName("구체 타입으로 조회")
  void findBeanByName2(){
    MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }
}
