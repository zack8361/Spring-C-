package Hello.core.beanfind;

import Hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanName = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String s : beanName) {
            Object bean = annotationConfigApplicationContext.getBean(s);
            System.out.println("bean = " + bean);

        }
    }
}
