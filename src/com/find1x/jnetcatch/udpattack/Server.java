package com.find1x.jnetcatch.udpattack;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;

public class Server {

	public static void main(String[] args) {
		try {
			// ȷ�����ܷ���IP�Ͷ˿ںţ�IP��ַΪ���ػ�����ַ
			InetAddress ip = InetAddress.getLocalHost();
			int port = 8888;
			if (args.length > 0) {
				port = Integer.parseInt(args[0]);
			}

			// �������շ����׽���,���ƶ��˿ںź�IP��ַ
			DatagramSocket getSocket = new DatagramSocket(port, ip);

			// ȷ�����ݱ����ܵ����ݵ������С
			byte[] buf = new byte[1024];

			// �����������͵����ݱ������ݽ��洢��buf��
			DatagramPacket getPacket = new DatagramPacket(buf, buf.length);

			while (true) {
				// ͨ���׽��ֽ�������
				getSocket.receive(getPacket);

				// �������ͷ����ݵ���Ϣ������ӡ
				String getMes = new String(buf, 0, getPacket.getLength());
				System.out.println("�Է����͵���Ϣ��" + getMes);

				// ͨ�����ݱ��õ����ͷ���IP�Ͷ˿ںţ�����ӡ
				InetAddress sendIP = getPacket.getAddress();
				int sendPort = getPacket.getPort();
				System.out.println("�Է���IP��ַ�ǣ�" + sendIP.getHostAddress());
				System.out.println("�Է��Ķ˿ں��ǣ�" + sendPort);
				byte[] data = getPacket.getData();
				String dataString = "";
				for (byte b : data) {
					if (b == 0) {
						dataString += "END";
						break;
					}
					dataString += Integer.toHexString((int) b & 0x0ff) + "-";
				}
				System.out.println("���ݱ������ǣ�" + dataString);
			}
			// // ͨ�����ݱ��õ����ͷ����׽��ֵ�ַ
			// SocketAddress sendAddress = getPacket.getSocketAddress();
			//
			// // ȷ��Ҫ�������ͷ�����Ϣ���ݣ���ת��Ϊ�ֽ�����
			// String feedback = "���շ�˵�����յ��ˣ�";
			// byte[] backBuf = feedback.getBytes();
			//
			// // �����������͵����ݱ�
			// DatagramPacket sendPacket = new DatagramPacket(backBuf,
			// backBuf.length, sendAddress);
			//
			// // ͨ���׽��ַ�������
			// getSocket.send(sendPacket);

			// �ر��׽���
			// getSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
