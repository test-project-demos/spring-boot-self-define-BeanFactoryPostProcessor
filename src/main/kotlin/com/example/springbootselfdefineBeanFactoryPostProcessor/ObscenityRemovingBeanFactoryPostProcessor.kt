package com.example.springbootselfdefineBeanFactoryPostProcessor

import org.springframework.beans.factory.config.BeanDefinitionVisitor
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.context.annotation.Configuration
import org.springframework.util.StringValueResolver

/**
 * @author zhixiao.mzx
 * @date 2019-06-01
 */
@Configuration
class ObscenityRemovingBeanFactoryPostProcessor : BeanFactoryPostProcessor {
    var obscenties: Set<String> = setOf()
        set(value) {
            field = value.map { it.toUpperCase() }.toSet()
        }

    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {
        val beanNames = beanFactory.beanDefinitionNames
        beanNames.forEach { beanName ->
            val bd = beanFactory.getBeanDefinition(beanName)
            val valueResolver = StringValueResolver {
                println("check value: $it, obscenties: $obscenties")
                if (obscenties.contains(it.toUpperCase())) {
                        return@StringValueResolver "*****"
                } else {
                    return@StringValueResolver it
                }
            }

            val visitor = BeanDefinitionVisitor(valueResolver)
            visitor.visitBeanDefinition(bd)
        }
    }
}