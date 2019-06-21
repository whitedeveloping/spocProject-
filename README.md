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

最后检查:
1.视频部分使用ffmpeg音视频工具进行转码  播放  缩略图的实现,本来的目的是使用ffmpeg工具把mp4 avi 等等之类的视频格式转为通常使用的fiv格式,因为fiv相对来说文件较小,易于存储和操作,但是由于原始是使用ffmpeg.exe进行实现,在linux不太容易转化,所以这块其他格式的音视频资源未进行正确转码
2.由于视频网站相对而言带宽需求极大,所以更好的选择是搭建视频服务器,将视频存储在视频服务器上,但是由于服务器搭建困难,仍未完成,只能把视频资源存储在toncat服务器上,这样性能较差 

自己尝试实现Nginx+Tomcat集群
1.开始使用tomcat8.5.38,在bin下使用start.sh启动后一直访问不了8080端口,最后尝试使用tomcat9.0.21成功访问
2.Nginx安装后可以使用nginx命令直接启动或者使用service nginx start启动  但是莫名其妙不能使用service nginx stop进行关闭,当使用pkill -9 nginx关闭后就无法启动,无论是通过nginx还是service nginx start命令,最终尝试可以使用service nginx restart重新启动
3.tomcat集群最开始修改其他tomcat节点的port,最后在nginx.conf配置文件中添加节点的域名即可







