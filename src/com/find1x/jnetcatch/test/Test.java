package com.find1x.jnetcatch.test;

import com.find1x.jnetcatch.netutil.NetworkPackage;

public class Test {

	@org.junit.Test
	public void test() {
		NetworkPackage np = new NetworkPackage(
				NetworkPackage.lookupDevices()[1]);
		np.getNext();
		System.out.println(np.ethernetpacket.getDestinationHwAddress());
		System.out.println(np.ethernetpacket.getSourceHwAddress());
		System.out.println(Integer.toHexString(np.ethernetpacket
				.getEthernetProtocol()));
		if (np.ethernetpacket.getEthernetProtocol() == 2048) {
			System.out.println(np.ippacket.getVersion());
			System.out.println(np.ippacket.getHeaderLength());
			System.out.println(np.ippacket.getTypeOfService());
			System.out.println(np.ippacket.getLength());
			System.out.println(np.ippacket.getId());
			System.out.println(np.ippacket.getFragmentFlags());
			System.out.println(np.ippacket.getFragmentOffset());
			System.out.println(np.ippacket.getTimeToLive());
			System.out.println(np.ippacket.getProtocol());
			System.out.println(np.ippacket.getChecksum());
			System.out.println(np.ippacket.getSourceAddress());
			System.out.println(np.ippacket.getDestinationAddress());
			if (np.ippacket.getProtocol() == 17) {// UDP
				System.out.println(np.udppacket.getSourcePort());
				System.out.println(np.udppacket.getDestinationPort());
				System.out.println(np.udppacket.getLength());
				System.out.println(np.udppacket.getChecksum());
			} else if (np.ippacket.getProtocol() == 6) {// TCP
				System.out.println(np.tcppacket.getSourcePort());
				System.out.println(np.tcppacket.getDestinationPort());
				System.out.println(np.tcppacket.getSequenceNumber());// 序列号
				System.out.println(np.tcppacket.getAcknowledgementNumber());// 确认序列号
				System.out.println(np.tcppacket.getFragmentOffset());
				System.out.println(np.tcppacket.getFragmentFlags());
				// Flags拆成6位
				System.out.println(np.tcppacket.isUrg());
				System.out.println(np.tcppacket.isAck());
				System.out.println(np.tcppacket.isPsh());
				System.out.println(np.tcppacket.isRst());
				System.out.println(np.tcppacket.isSyn());
				System.out.println(np.tcppacket.isFin());

				System.out.println(np.tcppacket.getWindowSize());
				System.out.println(np.tcppacket.getChecksum());
				System.out.println(np.tcppacket.getUrgentPointer());
			} else if (np.ippacket.getProtocol() == 1) {// ICMP
				System.out.println(np.icmppacket.getMessageType());
				System.out.println(np.icmppacket.getMessageCode());
				System.out.println(np.icmppacket.getChecksum());
				System.out.println(np.icmppacket.getId());
				// ICMP实在搞不清了，应该还有个序列号死活找不到
			}
		} else if (np.ethernetpacket.getEthernetProtocol() == 2054) {
			System.out.println("0x0001");// 0x0001表示以太网
			System.out.println(np.arppacket.getEthernetProtocol());// 16进制表示，2054为0x0806
			System.out.println(6);// MAC地址长度
			System.out.println(4);// 协议地址长度
			System.out.println(np.arppacket.getOperation());// 表示为16进制，即0x0001等
			System.out.println(np.arppacket.getSourceHwAddress());
			System.out.println(np.arppacket.getSourceProtoAddress());
			System.out.println(np.arppacket.getDestinationHwAddress());
			System.out.println(np.arppacket.getDestinationProtoAddress());
		}
	}

}
