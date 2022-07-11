package cn.raincoding.core;

import cn.raincoding.annotation.MyScan;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;

import java.util.Objects;
import java.util.Set;

/**
 * @author zengqm01
 * @date 2022/7/8 17:13
 */
public class MyScanRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    private final static String BASE_PACKAGE_ATTR_NAME = "basePackage";

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(MyScan.class.getName()));
        String[] basePackages = new String[0];
        if (Objects.nonNull(annotationAttributes)) {
            basePackages = annotationAttributes.getStringArray(BASE_PACKAGE_ATTR_NAME);
        }
        if (basePackages.length == 0) {
            basePackages = new String[] {((StandardAnnotationMetadata) annotationMetadata).getIntrospectedClass().getPackage().getName()};
        }

        MyServiceScanner scanner = new MyServiceScanner(registry, false);
        if (Objects.nonNull(resourceLoader)) {
            scanner.setResourceLoader(resourceLoader);
        }
        scanner.setBeanNameGenerator(new MyBeanNameGenerator());
        Set<BeanDefinitionHolder> beanDefinitionHolders = scanner.doScan(basePackages);

        System.out.println(beanDefinitionHolders);
    }
}
