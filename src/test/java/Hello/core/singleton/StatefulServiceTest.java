package Hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StatefulServiceTest {

    @Test
    @DisplayName("여기")
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService s = ac.getBean(StatefulService.class);
        StatefulService s2 = ac.getBean(StatefulService.class);
        s.order("kong",10000);
        s2.order("ho",20000);

        int price = s.getPrice();
        System.out.println("price = " + price);
        Assertions.assertThat(s.getPrice()).isEqualTo(20000);

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}