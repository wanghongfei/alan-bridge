# Alan Bridge

## 使用方法
引入依赖:
```
<dependency>
	<groupId>cn.com.sina</groupId>
	<artifactId>alan-bridge</artifactId>
	<version>1.0-SNAPSHOT</version>
</dependency>
```

添加`ribbon.properties`配置文件:
```
# 固定写法
myclient.ribbon.NIWSServerListClassName=com.netflix.niws.loadbalancer.DiscoveryEnabledNIWSServerList

# 服务地址更新间隔, 单位毫秒
myclient.ribbon.ServerListRefreshInterval=60000

# 指定myclient对应的服务名
myclient.ribbon.DeploymentContextBasedVipAddresses=S3



# 不向eureka注册自身
eureka.registration.enabled=false

eureka.preferSameZone=true
eureka.shouldUseDns=false
# eureka地址
eureka.serviceUrl.default=http://127.0.0.1:8761/eureka

eureka.decoderName=JacksonJson
```

调用:
```
// 选择出myclient对应服务全部可用地址
List<AlanServiceAddress> list = AlanServiceAddressSelector.selectAvailableServers("myclient");
System.out.println(list);
        
// 选择出myclient对应服务的一个可用地址(轮询), 返回null表示服务当前没有可用地址
AlanServiceAddress addr = AlanServiceAddressSelector.selectOne("myclient");
System.out.println(addr);
// addr.toString() 返回 http://主机名:端口/
// addr.getPort() 返回端口(int)
// addr.getHost() 返回主机名(String)
```