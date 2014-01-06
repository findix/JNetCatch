package com.find1x.jnetcatch.netutil;

import net.sourceforge.jpcap.capture.CaptureDeviceLookupException;
import net.sourceforge.jpcap.capture.CaptureDeviceOpenException;
import net.sourceforge.jpcap.capture.CapturePacketException;
import net.sourceforge.jpcap.capture.InvalidFilterException;
import net.sourceforge.jpcap.capture.PacketCapture;
import net.sourceforge.jpcap.net.ARPPacket;
import net.sourceforge.jpcap.net.EthernetPacket;
import net.sourceforge.jpcap.net.ICMPPacket;
import net.sourceforge.jpcap.net.IPPacket;
import net.sourceforge.jpcap.net.Packet;
import net.sourceforge.jpcap.net.TCPPacket;
import net.sourceforge.jpcap.net.UDPPacket;

public class NetworkPackage {
	private PacketCapture pcap;
	private PacketHandler handler;
	public EthernetPacket ethernetpacket = null;
	public Packet packet;
	public IPPacket ippacket = null;
	public UDPPacket udppacket = null;
	public TCPPacket tcppacket = null;
	public ARPPacket arppacket = null;
	public ICMPPacket icmppacket = null;
	public NetworkPackage(String device) {
		pcap = new PacketCapture();
		handler = new PacketHandler();
		try {
			pcap.open(device, true);
			pcap.setFilter("(ip or arp) and (udp or tcp or icmp)", true);
			pcap.addPacketListener(handler);
		} catch (CaptureDeviceOpenException | InvalidFilterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String[] lookupDevices() {
		try {
			return PacketCapture.lookupDevices();
		} catch (CaptureDeviceLookupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void getNext() {
		try {
			pcap.capture(1);
			packet=handler.getPacket();
			ethernetpacket = handler.getEthernetPacket();
			ippacket = handler.getIPPacket();
			udppacket = handler.getUDPPacket();
			tcppacket=handler.getTCPPacket();
			arppacket=handler.getARPPacket();
			icmppacket=handler.getICMPPacket();
		} catch (CapturePacketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
