package Hello.core.beanextends;

import Hello.core.discount.DiscountPolicy;
import Hello.core.discount.FixDiscountPolicy;
import Hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);


    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘이상 있으면 , 중복 오류가 발생한다..")
    void findBeanByParentTypeDuplicate(){
         assertThrows(NoUniqueBeanDefinitionException.class,
                 () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType(){
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for (String s : beansOfType.keySet()) {
            System.out.println("s = " + s);
        }
    }

    @Test
    @DisplayName("Object Type으로 전부 꺼내기")
    void findAllBeanByObjectType(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("s = " + s);
        }
    }


    @Configuration
    static class TestConfig{

        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
        @Bean DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }

    }
}
