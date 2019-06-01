package com.example.springbootselfdefineBeanFactoryPostProcessor

import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.xml.XmlBeanFactory
import org.springframework.core.io.ClassPathResource

/**
 * @author zhixiao.mzx
 * @date 2019-06-01
 */

fun main(args: Array<String>) {
    var bf = XmlBeanFactory(ClassPathResource("/BeanFactory.xml"))
    var bean: BeanFactoryPostProcessor = bf.getBean("bfpp") as BeanFactoryPostProcessor
    bean.postProcessBeanFactory(bf)
    println(bf.getBean("simpleBean"))
}