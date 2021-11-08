# CRM-demo
  
  
#### demo 简介
    一个简单的CRM案例, 分别采用 SSM单体, SSM+Dubbo分布式, SpringBoot单体, SpringBoot+Dubbo分布式, SpringCloud微服务 五种架构方式实现.  
    业务逻辑尽可能简单, 意在观察和练习java后端工程的多种组织架构.
    前端页面使用bootstrap+jsp渲染, 前后端不分离, 有少量ajax接口. 五个版本使用完全一样的前端代码.
    
#### 系统环境及外部服务
    - 开发工具IDEA
    - 管理工具maven
    - jdk1.8
    - tomcat
    - mysql
    - redis(可配置, 不启用则不需要)
    - zookeeper(两个dubbo的版本需要)

#### 涉及到的技术点
    1. 功能层面
        - mybatis逆向工程
        - mybatis的pagehelper分页插件
        - spring事务管理
        - springMVC拦截器(登录权限验证)
        - log4j日志的简单使用
        - redis的简单使用(缓存少量固定数据)
        - 多线程的简单使用(redis的存储动作采用多线程异步方式)
    2. 架构层面
        - 在SpringBoot中使用jsp. SpringBoot默认不支持也不推荐使用jsp, 这里为了保证前端代码一致性使用, 也并不复杂.
        - Dubbo远程过程调用, 将单体版本的service层拆分为三个dubbo服务, 用zookeeper作注册中心.
        - SpringCloud微服务版本, 同样将业务拆分为三个provider和一个consumer, 使用到的组件:
            * eureka
            * zuul
            * feign

#### 使用步骤
    1. crm.sql文件导入数据库
    2. 项目启动
        - SSM版本
            1. jdbc.properties为你的mysql服务配置url, user, passworld.
            2. myConfig.properties配置enableRedis是否启用redis, 不启用设为false即可.
            3. 2中如果启用redis, 在redis-context.xml中修改redis的host及port. myConfig.properties中redisDB字段可配置要使用的redis数据库号.
            4. 使用maven的tomcat插件运行tomcat7:run启动项目.
        - SpringBoot版本
            1. jdbc.properties只用作逆向工程, 可以忽略.
            2. application.properties配置mysql以及是否启用redis.
            3. 2中如果启用redis, 在application.yml修改redis信息.
            4. 运行入口类CRMSpringBootGo启动项目.
        - SSM-Dubbo版本
            1. 在三个service模块和web-app模块的dubbo-xxxxx.xml中配置zookeeper的ip和端口.
            2. 在三个service模块的jdbc.properties中配置mysql.
            3. 在service-dict模块的myConfig.properties,redis-context.xml中配置redis.
            4. 启动三个service模块的入口类, 使用IDEA集成本地tomcat部署web-app模块.
        - SpringBoot-Dubbo版本
            1. 在三个service模块和web-app模块的application.yml中配置zookeeper的ip和端口.
            2. 在三个service模块中的jdbc.properties配置mysql.
            3. 在service-dict模块的application.yml中配置redis.
            4. 启动三个service模块及Web-app模块的入口类(Web-app模块运行选项里需设置Working directory为$MODULE_DIR$).
        - SpringCloud版本
            1. mysql和redis的基本设置同上.
            2. Web-app模块运行选项里设置Working directory为$MODULE_DIR$.
            3. 启动3个service+webapp+eureka+zuul共6个服务.
            4. 可通过8004端口访问项目, 也可用postman通过7999端口测试zuul对三个service服务的反向代理情况.
         
        ps: 所有分布式服务都支持用java -jar方式启动.

#### 页面预览
![Alt text](https://github.com/tianxiaoyu111/imgs/blob/master/1.png)
![Alt text](https://github.com/tianxiaoyu111/imgs/blob/master/2.png)
![Alt text](https://github.com/tianxiaoyu111/imgs/blob/master/3.png)
