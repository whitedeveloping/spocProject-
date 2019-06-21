day01:
逆向工程生成后包名不统一导致扫描不到使得8080访问不到
day02:
之前没考虑随着不同的拨号上网本地ip不停变化的问题,每次链接新网络都需要设置新的ip(使用ifconfig -a查看)
dubbo-admin监控中心配置有问题,目前还处于404状态
将jsp  js  css放在webapp下,使用到资源映射问题,理解拦截形式
分页插件:将pagehelper安装到本地,进行分页测试时出现端口占用错误,需要service下对dubbo的配置端口作出修改

在启动SOA架构时启动zookepper才能启动项目


day06
安装Redis时遇到的问题:

1.redis安装成功后,无法访问外部服务器,只能默认访问127.0.0.1:6379,无法访问到自己ip 192.168.1.106

最开始是拒绝连接 ,百度出的结果是安装ss工具,效果不显著,最后通过注释端口和设置保护模式成功了

https://blog.csdn.net/a532672728/article/details/78035559

2.搭建redis集群:在每个redis中修改为不同的端口实现伪分布式,可以写一个脚本实现6台服务器的启动,搭建了六台服务器,三主三从,有16385个节点,存储在6台服务器中,可以实现数据的共享和端口的跳转

启动redis集群:
1.开始启动redis   ./redis-server redis-conf
2.开启六台redis   ./start-all.sh   全部启动脚本
3.在任意一个redis下以redis-cli -p 7002 -c启动即可
4.单机版集群在测试时没有夹getter和setter方法  ,导致在配置文件中少property的属性 报错

day10和day11:
单点登录遇到的问题:
首先借用SOA架构,
1.因为在spoc-manager-web模块需要得到spoc-sso-web的用户数据,传送过程中遇到跨域的问题,使用jsonp解决,
2.在修改了js文件后,页面刷新没效果:最后解决了  是因为浏览器默认缓存了js文件,清除缓存即可





