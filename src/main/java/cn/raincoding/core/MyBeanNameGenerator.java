package cn.raincoding.core;

import cn.raincoding.annotation.MyService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author zengqm01
 * @date 2022/7/11 09:16
 */
public class MyBeanNameGenerator extends AnnotationBeanNameGenerator {

    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        String beanName = getBeanNameByServiceAnnotation(definition);
        if (!StringUtils.isEmpty(beanName)) {
            return beanName;
        }

        return super.generateBeanName(definition, registry);
    }

    private String getBeanNameByServiceAnnotation(BeanDefinition definition) {
        String beanClassName = definition.getBeanClassName();
        try {
            Class<?> clazz = Class.forName(beanClassName);
            MyService annotation = clazz.getAnnotation(MyService.class);
            if (Objects.isNull(annotation)) {
                return "";
            }
            return annotation.name();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

}
