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
        - 针对于资源文件的统一接口
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
    7. Bean管理的注解实现
        - 从Spring3.0开始，Spring JavaConfig项目提供了很多特性，包括使用java而不是XML定义bean。比如@Configuration,@Bean,@Import,@DependsOn
        - @Component是一个通用注解，可用于任何bean
        - @Repository,@Service,@Controller是更有针对性的注解
            1. @Repository通常用于注解DAO类，即持久层
            2. @Service通用用于注解Service类，即服务层
            3. @Controller通常用于Controller层，即控制层（MVC）
        - **元注解**
            - 许多Spring提供的注解可以作为自己的代码，即“元数据注解”，元注解是一个简单的注解，可以应用到另一个注解
            - 除了value()，元注解还可以有其他的属性，允许定制
        - @Required
            - 适用于bean属性的setter方法
            - 这个注解仅仅表示，受影响的bean属性必须在配置时被填充，通过在bean定义或通过自动装配一个明确的属性值
        - @Autowired
            - 可以将@Autowired注解为“传统”的setter方法
            - 可用于构造器或成员变量
            - 默认形况下，如果找不到合适的bean将会导致autowiring失败排除异常，可以避免（bean得到null）
            - 每个类只能有一个构造器被标记为required=true
            - @Autowired的必要属性，建议使用@Required注解
            - 可以通过添加注解给需要该类型的数组的字段或方法，以提供ApplicationContext中的所有特定类型的bean
            - 可以用于装配key为String的Map
            - 如果希望数组有序，可以让bean实现org.springframework.core.Ordered接口或使用@Order注解
        - @Qualifier
            - 按类型自动装配可能有多个bean实例的情况，可以使用Spring的@Qualifier注解缩小范围（或指定唯一），也可以用于指定单独的构造器参数或方法参数
            - 可用于注解集合类型变量
            - 如果通过名字进行注解注入，主要使用的不是@Autowired（即使在技术上能够通过@Qualifier指定bean的名字），替代方案是使用JSR-250@Resource注解，它是通过其独特的名称来定义识别特定的目标（这是一个与其声明的类型无关的匹配过程）
            - 因语义差异，集合或Map类型的bean无法通过@Autowired来注入，因为没有类型匹配到这样的bean，为这些bean使用@Resource注解，通过唯一名称引用集合或Map的bean
            - @Autowired适用于fields,constructors,multi-argument-method这些允许在参数级别使用@Qualifier注解缩小范围的情况
            - @Resource适用于成员变量、只有一个参数的setter方法，所以在目标是构造器或一个多参数方法时，最好的方式是使用qualifiers
        - @Bean
            1. @Bean标识一个用于配置和初始化一个由SpringIoc容器管理的新对象的方法，类似于XML配置文件的<bean/>
            2. 可以在Spring的@Component注解的类中使用@bean注解任何方法（仅仅是可以）
            3. 上一点中，通常使用的是@Configuration
        - @ImportResource和@Value进行资源文件读取
            - @ImportResource注解类
            - @Value对成员赋值（从properties文件中读取）
        - @Bean和@Scope
            - 默认@Bean是单例的
            - @Scope-> value指定范围，proxyMode采用代理方式
                
---
    
- AOP（配置、注解、AspectJ、API）
    1. 什么是AOP
        - AOP：Aspect Oriented Program的缩写，意为：面向切面的编程，**通过预编译方式和运行期动态代理**实现程序功能的**统一维护**的一种技术
        - 主要功能：日志记录，性能统计，安全控制，事务处理，异常处理等等
        - 实现方式
            1. 预编译：AspectJ
            2. 运行期动态代理（JDK动态代理，CGLib动态代理）：SpringAOP，JbossAOP
        - Spring中AOP的作用
            - 提供了声明式的企业服务，特别是RJB的替代服务的声明
            - 允许用户定制自己的方面，以完成OOP与AOP的互补使用
    2. AOP基本概念
        - 相关概念
            1. 切面（Aspect）：一个关注点的模块化，这个关注点可能会横切多个对象
            2. 连接点（Joinpoint）：程序执行过程中的某个特定的点
            3. 通知（Advice）：在切面的某个特定的连接点上执行的动作
                - 前置通知（Before advice）:在连接点之前执行的通知，但不能阻止连接点前的执行
                - 返回后通知（After returning advice）：在某连接点正常后执行的通知
                - 抛出异常后通知（After throwing advice）：在方法抛出异常退出时执行的通知
                - 后通知（After（finally）advice）：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）
                - 环绕通知（Around Advice）：包围一个连接点的通知
            4. 切入点（Pointcut）：匹配连接点的断言，在AOP中通知和一个切入点表达式关联
            5. 引入（Introduction）：在不修改类代码的前提下，为类添加新的方法和属性
            6. 目标对象（Target Object）：被一个或者多个切面通知的对象
            7. AOP代理（AOP Proxy）：AOP框架创建的对象，用来实现切面契约（aspect contract）（包括通知方法执行等功能）
            8. 织入（Weaving）：把切面连接到其他的应用程序类型或者对象上，并创建一个被通知的对象，分为：编译时织入，类加载时织入，执行时织入
    3. Spring中的AOP
        - Spring的AOP实现
             - 纯java实现，无需特殊的编译过程，不需要控制类加载器层次
             - 目前只支持方法执行连接点（通知Spring Bean的方法执行）
             - 不是为了提供最完整的AOP实现（尽管它非常的强大）；而是侧重于提供一种AOP实现的Spring IoC容器之间的整合，用于帮助解决企业应用的常见问题
             - Spring AOP不会与AspectJ竞争，从而提供综合全面的AOP解决方法
        - 有接口和无接口Spring AOP实现的区别
              - Spring AOP默认使用标准的JavaSE动态代理作为AOP代理，这使得任何接口（或者接口集）都可以被代理
              - Spring AOP中也可以使用CGLIB代理（如果一个业务对象并没有实现一个接口）
    4. Schema-based AOP
        - Spring所有的切面和通知器都必须放在一个<aop:config>内（可以配置包含多个<aop:config>元素），每一个<aop:config>可以包含pointcut，advisor和aspect元素（它们必须按照这个顺序j进行声明）
        - pointcut
            1. execution(public**(..)) 切入点为执行所有public方法时
            2. execution(* set*(..)) 切入点为执行所有set开始的方法时
            3. execution(* com.xyz.service.AccountService.*(..)) 切入点为执行AccountService类中的所有方法时
            4. execution(* com.xyz.service..(..)) 切入点为执行com.xyz.service包下的所有方法时
            5. execution(* com.xyz.service...(..)) 切入点为执行com.xyz.service包及其子包下的所有方法时
            6. within(com.xyz.service.*)(only in Spring AOP)
            7. within(com.xyz.service..*)(only in Spring AOP) within用于匹配指定类型内的方法执行
            8. this(com.xyz.service.AccountService)(only in Spring AOP) this用于匹配当前AOP代理对象类型的执行方法
            9. target(com.xyz.service.AccountService)(only in Spring AOP) target用于匹配d当前目标对象类型的执行方法
            10. args(java.io.Serializable)(Only in Spring AOP)
            11. ...等等，查询文档
        - Introductions
            - 简介允许一个切面声明一个实现指定接口的通知对象，并且提供一个接口实现类来代表这些对象
            - 由<aop:aspect>中的<aop:declare-parents>元素声明该元素用于声明所匹配的类型拥有一个新的parent（因此得名）
            - schema-defined aspects（所有基于配置文件的aspect）只支持singleton model
        - Advisors
            - advisor就像一个小的自包含的方面，只有一个advice
            - 切面自身通过一个baen表示，并且必须实现某个advice接口，同时，advisor也可以很好的利用AspectJ的切入点表达式
            - Spring通过配置文件中<aop:advisor>元素支持advisor实际使用中，大多数情况下它会和transaction advice配合使用
            - 为了定义一个advisor的优先级以便让advice可以有序，可以使用order属性来定义advisor的顺序
    5. Spring AOP API
    6. AspectJ