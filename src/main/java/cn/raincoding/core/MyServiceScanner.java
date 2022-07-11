package cn.raincoding.core;

import cn.raincoding.annotation.MyService;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * @author zengqm01
 * @date 2022/7/8 17:21
 */
public class MyServiceScanner extends ClassPathBeanDefinitionScanner {

    public MyServiceScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        addIncludeFilter(new AnnotationTypeFilter(MyService.class));
        return super.doScan(basePackages);
    }
}
