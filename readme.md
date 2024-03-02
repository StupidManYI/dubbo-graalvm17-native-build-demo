(node before run application ,you need to modify the application.yml)

**myquestion**: **I don't need hessian2, I just use fastjson2**, I have removed all hessian2 dependency,
but why dubbo still inject Hessian2FactoryManager

```
<dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo</artifactId>
            <version>${dubbo.verison}</version>
            <exclusions>
                <exclusion>
                    <artifactId>hessian-lite</artifactId>
                    <groupId>com.alibaba</groupId>
                </exclusion>
            </exclusions>
        </dependency>
```

error.log

```
org.apache.dubbo.common.beans.ScopeBeanException: create bean instance failed, type=org.apache.dubbo.common.serialize.hessian2.Hessian2FactoryManager
	at org.apache.dubbo.common.beans.factory.ScopeBeanFactory.createAndRegisterBean(ScopeBeanFactory.java:94) ~[dubbo-3.3.0-beta.1.jar:3.3.0-beta.1]
	at org.apache.dubbo.common.beans.factory.ScopeBeanFactory.getOrRegisterBean(ScopeBeanFactory.java:131) ~[dubbo-3.3.0-beta.1.jar:3.3.0-beta.1]
	at org.apache.dubbo.common.beans.factory.ScopeBeanFactory.registerBean(ScopeBeanFactory.java:78) ~[dubbo-3.3.0-beta.1.jar:3.3.0-beta.1]
	at org.apache.dubbo.common.serialize.hessian2.Hessian2ScopeModelInitializer.initializeFrameworkModel(Hessian2ScopeModelInitializer.java:29) ~[dubbo-3.3.0-beta.1.jar:3.3.0-beta.1]
	at org.apache.dubbo.rpc.model.FrameworkModel.<init>(FrameworkModel.java:97) ~[dubbo-3.3.0-beta.1.jar:3.3.0-beta.1]
	at org.apache.dubbo.rpc.model.FrameworkModel.defaultModel(FrameworkModel.java:181) ~[dubbo-3.3.0-beta.1.jar:3.3.0-beta.1]
	at org.apache.dubbo.config.spring.context.DubboSpringInitializer.customize(DubboSpringInitializer.java:198) ~[dubbo-3.3.0-beta.1.jar:3.3.0-beta.1]
	at org.apache.dubbo.config.spring.context.DubboSpringInitializer.initContext(DubboSpringInitializer.java:108) ~[dubbo-3.3.0-beta.1.jar:3.3.0-beta.1]
	at org.apache.dubbo.config.spring.context.DubboSpringInitializer.initialize(DubboSpringInitializer.java:65) ~[dubbo-3.3.0-beta.1.jar:3.3.0-beta.1]
	at org.apache.dubbo.config.spring.context.annotation.DubboConfigConfigurationRegistrar.registerBeanDefinitions(DubboConfigConfigurationRegistrar.java:40) ~[dubbo-3.3.0-beta.1.jar:3.3.0-beta.1]
	at org.springframework.context.annotation.ImportBeanDefinitionRegistrar.registerBeanDefinitions(ImportBeanDefinitionRegistrar.java:86) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.lambda$loadBeanDefinitionsFromRegistrars$1(ConfigurationClassBeanDefinitionReader.java:376) ~[spring-context-6.1.2.jar:6.1.2]
	at java.base/java.util.LinkedHashMap.forEach(LinkedHashMap.java:721) ~[na:na]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsFromRegistrars(ConfigurationClassBeanDefinitionReader.java:375) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsForConfigurationClass(ConfigurationClassBeanDefinitionReader.java:148) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitions(ConfigurationClassBeanDefinitionReader.java:120) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:428) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:289) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:349) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:118) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:789) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:606) ~[spring-context-6.1.2.jar:6.1.2]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:464) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) ~[spring-boot-3.2.1.jar:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[spring-boot-3.2.1.jar:3.2.1]
	at com.ingsha.nativeDemo.Application.main(Application.java:24) ~[classes/:na]
Caused by: java.lang.NoClassDefFoundError: com/alibaba/com/caucho/hessian/io/SerializerFactory
	at java.base/java.lang.Class.getDeclaredConstructors0(Native Method) ~[na:na]
	at java.base/java.lang.Class.privateGetDeclaredConstructors(Class.java:3373) ~[na:na]
	at java.base/java.lang.Class.getConstructor0(Class.java:3578) ~[na:na]
	at java.base/java.lang.Class.getConstructor(Class.java:2271) ~[na:na]
	at org.apache.dubbo.common.beans.support.InstantiationStrategy.instantiate(InstantiationStrategy.java:53) ~[dubbo-3.3.0-beta.1.jar:3.3.0-beta.1]
	at org.apache.dubbo.common.beans.factory.ScopeBeanFactory.createAndRegisterBean(ScopeBeanFactory.java:92) ~[dubbo-3.3.0-beta.1.jar:3.3.0-beta.1]
	... 28 common frames omitted
Caused by: java.lang.ClassNotFoundException: com.alibaba.com.caucho.hessian.io.SerializerFactory
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641) ~[na:na]
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188) ~[na:na]
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:525) ~[na:na]
	... 34 common frames omitted
```