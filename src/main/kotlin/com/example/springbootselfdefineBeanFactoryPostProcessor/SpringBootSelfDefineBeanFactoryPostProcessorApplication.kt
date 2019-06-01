package com.example.springbootselfdefineBeanFactoryPostProcessor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringBootSelfDefineBeanFactoryPostProcessorApplication : CommandLineRunner {

	override fun run(vararg p0: String?) {
//		obscenityRemovingBeanFactoryPostProcessor.postProcessBeanFactory(configurableListableBeanFactory)
//		var bean = configurableListableBeanFactory.getBean(Config::class.java)
//		println(bean)
	}
}

fun main(args: Array<String>) {
	SpringApplication.run(SpringBootSelfDefineBeanFactoryPostProcessorApplication::class.java, *args)
}
