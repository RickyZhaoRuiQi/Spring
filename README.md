# Spring

---

- 什么是框架
    - 定义
        - 通常指的是为了实现某个业界标准或完成特定基本任务的软件组件规范，也指为了实现某个软件组件规范时，提供规范所要求之基础功能的软件产品
        - 框架就是指定一套规范或者规则（思想）、大家（程序员）在该规范或者规则（思想）下工作。或者说就是使用别人搭好的舞台，你来做表演
    - 特点
        1. 半成品
        2. 封装了特定的处理流程和控制逻辑
        3. 成熟的、不断升级改进的软件
    - 框架与类库的区别
        1. 框架一般是封装了逻辑、高内聚的，类库则是松散的工具集合
        2. 框架专注于某一领域，类库则是更加通用的
- 为什么使用框架
    - 软件系统日趋复杂
    - 重用度高，开发效率和质量提高
    - 软件设计人员要专注于对领域的了解，使需求分许更充分
    - 易于上手、快速解决问题

---

- Spring简介
    - Spring是一个开源框架，为了解决企业应用开发的复杂性而创建的，但现在已经不止应用于企业应用
    - 是一个轻量级的控制反转（Ioc）和面向切面（AOP）的容器框架
        1. 从大小与开销两方面而言Spring都是轻量的
        2. 通过控制反转（Ioc）的技术达到松耦合的目的
        3. 提供了面向切面编程的丰富支持，允许通过分离应用的业务逻辑与系统级服务进行内聚性的开发
        4. 包含并管理应用对象的配置和生命周期，这个意义上是一种容器
        5. 将简单的组件配置、组合成为复杂的应用，这个意义上是框架
    - 为什么是Spring
        1. 在Spring上开发应用简单
        2. 在Spring上开发应用方便
        3. 在Spring上开发应用快捷
    - Spring作用
        1. 容器
        2. 提供了对多种技术的支持
            1. JMS
            2. MQ支持
            3. UnitTest等等
        3. AOP（事务管理，日志等）
        4. 提供了众多方便应用的辅助类（JDBC Template等）
        5. 对主流应用框架（Hibernate等）提供了良好的支持
    - 适用范围
        1. 构建企业应用（SpringMVC+Spring+Hibernate/Mybatis）
        2. 单独适用Bean容器（Bean管理）
        3. 单独适用AOP进行切面处理
        4. 其他的Spring功能，如：对消息的支持等
        5. 在互联网中的应用
---
        
- IOC（配置、注解）
    1. 接口及面向接口编程
        - **接口**
            1. 用于沟通的中介物的抽象化
            2. 实体把自己提供给外界的一种抽象化说明，用以由内部操作分离出外部沟通方法，使其能被修改内部而不影响外界其他实体于其交互的方式
            3. 对应Java接口即声明，声明了哪些方法是对外公开提供的
            4. 在Java8中，接口可以拥有方法体
        - 面向接口编程
            1. 结构设计中，分清层次及调用关系，每层只向外（上层）提供一组功能接口，各层间仅依赖接口而非实体类
            2. **接口实现的变动不影响各层间的调用**，这一点在公共服务中尤为重要
            3. “面向接口编程”中的“接口"是用于隐藏具体实现和实现多态性的组件
    2. 控制反转
        - 控制权的转移，应用程序本身不负责依赖对象的创建和维护，而是由外部容器负责创建和维护
        - DI（依赖注入）是其一种实现方式
        - 目的：创建对象并且组装对象之间的关系
    3. Spring注入
        - Spring注入是指在启动Spring容器加载bean配置的时候，完成对变量的赋值行为
        - 常用的两种注入方式
            - 设置注入
                - 通过调用set()方法 <property>
            - 构造注入
                - 通过调用构造器 <constructor-arg>
                
---

- Bean（配置、注解）
    1. Bean的配置项
        1. Id->Bean的唯一标识（变量名）
        2. Class->具体要实例化的类**理论上必须配置的项**
        3. Scope->范围，作用域
        4. Constructor arguments->构造器参数（构造器注入）
        5. Properties->属性（设置注入）
        6. Autowiring mode->自动装配
        7. lazy-initialization mode->懒加载
        8. Initialization/destruction method->初始化和销毁的方法
    2. Bean的作用域
        1. singleton：单例，指一个Bean容器中只存一份（默认方式）
        2. prototype：每次请求（每次使用）创建新的实例，destroy方式不生效
        3. request：每次http请求创建一个实例且在当前的request内有效
        4. session：同上，每次http请求创建，当前session有效
        5. global session：基于portlet的web中有效（portlet定义了global session），如果在web中，同session
    3. 声明周期
        1. 定义
        2. 初始化
            1. 实现org.springframework.beans.factory.InitializingBean接口，覆盖afterPropertiesSet方法
            2. 配置init-method
            3. 全局默认方式
        3. 使用
        4. 销毁
            1. 实现org.springframework.beans.factory.DisposableBean接口，覆盖destroy方法
            2. 配置destroy-method
            3. 全局默认方式
    4. Aware
        - Spring提供一些以Aware为后缀的接口，实现了Aware接口的bean在被初始化之后可以获取相应的资源
        - 通过Aware接口，可以对Spring相应的资源进行操作（一定要谨慎）
        - 为对Spring进行简单的扩展提供了方便的接口
        - 例如：ApplicationContextAware，BeanNameAware等
    5. Bean的自动装配（Autowiring）
        - NO：不做任何操作
        - byName：根据属性名自动装配。此选项将检查容器并根据名字查找与属性完全一致的bean，并将其与属性自动装配
        - byType：如果容器中存在一个与指定属性类型相同的bean，那么将与该属性自动装配；如果存在多个该类型的bean，那么抛出异常，并指出不能使用byType方式进行自动装配；如果没有找到相匹配的bean，则什么事都不发生
        - Constructor：与byType类似，不同之处在于它应用于构造器参数。如果容器中没有找到与构造器参数类型一致的bean，那么抛出异常
    6. Resource
        - 针对于资源文件的同意接口
        - Resources种类
            1. UrlResources：URL对应的资源，根据一个URL地址即可构建
            2. ClassPathResources：获取类路径下的资源文件
            3. FileSystemResources：获取文件系统里的资源
            4. ServletContextResources：ServletContext封装的资源，用于访问ServletContext环境下的资源
            5. InputStreamResources：针对输入流封装的资源
            6. ByteArrayResources：针对于字节数组封装的资源
        - ResourcesLoader
            - 所有resource实现该接口
            - 前缀
                1. classpath:->从classpath加载
                2. file:->从文件系统加载
                3. http:->作为RUL加载
                4. (none)
---
    
- AOP（配置、注解、AspectJ、API）