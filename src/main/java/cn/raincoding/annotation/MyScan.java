package cn.raincoding.annotation;

import cn.raincoding.core.MyScanRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zengqm01
 * @date 2022/7/8 17:11
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({MyScanRegistrar.class})
public @interface MyScan {

    String[] basePackage() default {};

}
