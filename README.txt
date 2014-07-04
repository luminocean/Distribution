ReadMe v0.1
-	本项目包含两个子项目：GroupPurchase 和 IndependentSystems
-	GroupPurchase中包含团购系统以及团购客户端
-	IndependentSystems中包含所有其他项目，即银行系统，短信系统以及零售商客户端

#############################################
v1.0
- 关于启动步骤（所有有关启动的类都在每个项目的launcher包中）：
	1. 启动Bank系统
	2. 启动团购服务器以及团购客户端（可以直接使用StartAll)
	3. 如果要测试ws发布新团购，再运行RetailTestDriver即可

##############################################
V1.2
- 启动步骤更新
	1. 开启JBoss (用于支持JMS), 目前开发环境为JBoss 5.1（没有JBoss服务器将在本地建立消息服务）
	2. 启动所有独立系统，可使用 StartAllSystems 类启动
	3. 启动团购网站和客户端
