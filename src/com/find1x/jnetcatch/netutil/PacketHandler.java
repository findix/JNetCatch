package com.find1x.jnetcatch.netutil;

import net.sourceforge.jpcap.capture.PacketListener;
import net.sourceforge.jpcap.net.ARPPacket;
import net.sourceforge.jpcap.net.ICMPPacket;
import net.sourceforge.jpcap.net.Packet;
import net.sourceforge.jpcap.net.EthernetPacket;
import net.sourceforge.jpcap.net.IPPacket;
import net.sourceforge.jpcap.net.TCPPacket;
import net.sourceforge.jpcap.net.UDPPacket;

public class PacketHandler implements PacketListener {
	private Packet packet;
	private EthernetPacket ethernetpacket;
	private IPPacket ippacket;
	private UDPPacket udppacket;
	private TCPPacket tcppacket;
	private ARPPacket arppacket;
	private ICMPPacket icmppacket;
	@Override
	public void packetArrived(Packet packet) {
		// TODO Auto-generated method stub
		this.packet = packet;
		analyse();
	}

	public Packet getPacket() {
		return packet;
	}

	public void setPacket(Packet packet) {
		this.packet = packet;
	}

	public EthernetPacket getEthernetPacket() {
		return ethernetpacket;
	}

	public IPPacket getIPPacket() {
		return ippacket;
	}

	public UDPPacket getUDPPacket() {
		return udppacket;
	}

	public TCPPacket getTCPPacket() {
		return tcppacket;
	}
	
	public ARPPacket getARPPacket(){
		return arppacket;
	}
	
	public ICMPPacket getICMPPacket(){
		return icmppacket;
	}
	
	private void analyse() {
		ethernetpacket = (EthernetPacket) packet;
		if(ethernetpacket.getEthernetProtocol()==2048){//16进制0800为2048
			ippacket = (IPPacket) packet;
			if (ippacket.getProtocol() == 17)
				udppacket = (UDPPacket) packet;
			else if (ippacket.getProtocol() == 6)
				tcppacket = (TCPPacket) packet;
			else if(ippacket.getProtocol() == 1)
				icmppacket=(ICMPPacket)packet;
		}
		else if(ethernetpacket.getEthernetProtocol()==2054)//16进制0806为2054
			arppacket=(ARPPacket)packet;
	}

}
