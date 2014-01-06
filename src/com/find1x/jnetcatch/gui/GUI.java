package com.find1x.jnetcatch.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Window.Type;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.BorderLayout;

import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import com.find1x.jnetcatch.netutil.NetworkPackage;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.JTextArea;

import java.awt.ComponentOrientation;
import java.awt.Cursor;

import javax.swing.BoxLayout;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class GUI {

	private JFrame frmJnetcatch;
	private final Action action = new SwingAction();
	private int netcard = 3;
	static String[] nps= NetworkPackage.lookupDevices();
	NetworkPackage np = new NetworkPackage(nps[netcard]);
	JComboBox<Integer> comboBox;
	JTextPane textPaneMac;
	JTextPane textPaneIP;
	JTextPane textPaneUDP;
	JTextPane textPaneTCP;
	JTextPane textPaneARP;
	JTextPane textPaneICMP;
	JTextArea textPane;
	JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				for (String string : nps) {
					System.out.println(string);
				}
				try {
					GUI window = new GUI();
					window.frmJnetcatch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJnetcatch = new JFrame();
		frmJnetcatch.getContentPane().setCursor(
				Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmJnetcatch.getContentPane().setComponentOrientation(
				ComponentOrientation.LEFT_TO_RIGHT);
		frmJnetcatch.setType(Type.POPUP);
		frmJnetcatch.setTitle("JNetCatch 1.0 ");
		frmJnetcatch.setBounds(100, 100, 800, 600);
		frmJnetcatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJnetcatch.getRootPane().setDefaultButton(button);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 196, 196, 196, 196, 0 };
		gridBagLayout.rowHeights = new int[] { 140, 140, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		frmJnetcatch.getContentPane().setLayout(gridBagLayout);

		JPanel panel = new JPanel();

		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		gbc_panel.gridheight = 1;
		gbc_panel.weightx = 1;
		gbc_panel.weighty = 1;
		frmJnetcatch.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblChooseNetcard = new JLabel("\u9009\u62E9\u7F51\u5361");
		panel_1.add(lblChooseNetcard);

		comboBox = new JComboBox<Integer>();
		comboBox.setModel(new DefaultComboBoxModel<Integer>(
				getIntegerArray(NetworkPackage.lookupDevices().length)));
		comboBox.setSelectedItem(netcard);
		panel_1.add(comboBox);

		JButton button = new JButton("\u6293\u5305");
		panel_1.add(button);
		button.setAction(action);

		JTextArea txtrPowered = new JTextArea();
		txtrPowered.setLineWrap(true);
		panel.add(txtrPowered, BorderLayout.CENTER);
		txtrPowered
				.setText("\u8BF4\u660E\uFF1A\r\n\u672C\u5DE5\u5177\u53EF\u4EE5\u6293\u53D6\u5E76\u5206\u6790\u7F51\u7EDC\u5C01\u5305\r\nPowered by Winpacp&JPcap\r\n\r\n\u9009\u62E9\u7F51\u5361\uFF1A\r\n\u9ED8\u8BA4\u662F\u90091\uFF0C\u5982\u679C\u5E0C\u671B\u83B7\u53D6\u5176\u4ED6\u7F51\u5361\u5C01\u5305\u53EF\u5207\u6362\r\n\r\n\u5173\u4E8E\uFF1A\r\nCopyright \u00A9 FindiX Studio\r\n\u6797\u5CF0 \u51E4\u7FD4");

		JPanel panel_mac = new JPanel();
		panel_mac.setLayout(new BorderLayout(2, 2));
		GridBagConstraints gbc_panel_mac = new GridBagConstraints();
		gbc_panel_mac.fill = GridBagConstraints.BOTH;
		gbc_panel_mac.insets = new Insets(0, 0, 5, 5);
		gbc_panel_mac.gridx = 1;
		gbc_panel_mac.gridy = 0;
		gbc_panel_mac.weightx = 1;
		gbc_panel_mac.weighty = 1;
		frmJnetcatch.getContentPane().add(panel_mac, gbc_panel_mac);

		JLabel lblMac = new JLabel("MAC");
		panel_mac.add(lblMac, BorderLayout.NORTH);

		textPaneMac = new JTextPane();
		textPaneMac.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textPaneMac.setEditable(false);
		panel_mac.add(textPaneMac, BorderLayout.CENTER);

		JPanel panel_arp = new JPanel();
		GridBagConstraints gbc_panel_arp = new GridBagConstraints();
		gbc_panel_arp.fill = GridBagConstraints.BOTH;
		gbc_panel_arp.insets = new Insets(0, 0, 5, 5);
		gbc_panel_arp.gridx = 2;
		gbc_panel_arp.gridy = 0;
		frmJnetcatch.getContentPane().add(panel_arp, gbc_panel_arp);
		panel_arp.setLayout(new BorderLayout(0, 0));

		JLabel lblARP = new JLabel("ARP");
		panel_arp.add(lblARP, BorderLayout.NORTH);

		textPaneARP = new JTextPane();
		textPaneARP.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textPaneARP.setEditable(false);
		panel_arp.add(textPaneARP, BorderLayout.CENTER);

		JPanel panel_ip = new JPanel();
		GridBagConstraints gbc_panel_ip = new GridBagConstraints();
		gbc_panel_ip.fill = GridBagConstraints.BOTH;
		gbc_panel_ip.insets = new Insets(0, 0, 5, 0);
		gbc_panel_ip.gridx = 3;
		gbc_panel_ip.gridy = 0;
		frmJnetcatch.getContentPane().add(panel_ip, gbc_panel_ip);
		panel_ip.setLayout(new BorderLayout(0, 0));

		JLabel lblIP = new JLabel("IP");
		panel_ip.add(lblIP, BorderLayout.NORTH);

		textPaneIP = new JTextPane();
		textPaneIP.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textPaneIP.setEditable(false);
		panel_ip.add(textPaneIP);

		JPanel panel_origin = new JPanel();
		GridBagConstraints gbc_panel_origin = new GridBagConstraints();
		gbc_panel_origin.insets = new Insets(0, 0, 5, 5);
		gbc_panel_origin.fill = GridBagConstraints.BOTH;
		gbc_panel_origin.gridx = 0;
		gbc_panel_origin.gridy = 1;
		frmJnetcatch.getContentPane().add(panel_origin, gbc_panel_origin);
		panel_origin.setLayout(new BoxLayout(panel_origin, BoxLayout.X_AXIS));

		textPane = new JTextArea();
		textPane.setLineWrap(true);
		panel_origin.add(textPane);

		JPanel panel_icmp = new JPanel();
		GridBagConstraints gbc_panel_icmp = new GridBagConstraints();
		gbc_panel_icmp.fill = GridBagConstraints.BOTH;
		gbc_panel_icmp.insets = new Insets(0, 0, 5, 5);
		gbc_panel_icmp.gridx = 1;
		gbc_panel_icmp.gridy = 1;
		gbc_panel_icmp.weightx = 1;
		gbc_panel_icmp.weighty = 1;
		frmJnetcatch.getContentPane().add(panel_icmp, gbc_panel_icmp);
		panel_icmp.setLayout(new BorderLayout(0, 0));

		JLabel lblICMP = new JLabel("ICMP");
		panel_icmp.add(lblICMP, BorderLayout.NORTH);

		textPaneICMP = new JTextPane();
		textPaneICMP.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textPaneICMP.setEditable(false);
		panel_icmp.add(textPaneICMP, BorderLayout.CENTER);

		JPanel panel_tcp = new JPanel();
		GridBagConstraints gbc_panel_tcp = new GridBagConstraints();
		gbc_panel_tcp.fill = GridBagConstraints.BOTH;
		gbc_panel_tcp.insets = new Insets(0, 0, 5, 5);
		gbc_panel_tcp.gridx = 2;
		gbc_panel_tcp.gridy = 1;

		frmJnetcatch.getContentPane().add(panel_tcp, gbc_panel_tcp);
		panel_tcp.setLayout(new BorderLayout(0, 0));

		JLabel lblTCP = new JLabel("TCP");
		panel_tcp.add(lblTCP, BorderLayout.NORTH);

		textPaneTCP = new JTextPane();
		textPaneTCP.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textPaneTCP.setEditable(false);
		panel_tcp.add(textPaneTCP, BorderLayout.CENTER);

		JPanel panel_udp = new JPanel();
		GridBagConstraints gbc_panel_udp = new GridBagConstraints();
		gbc_panel_udp.insets = new Insets(0, 0, 5, 0);
		gbc_panel_udp.fill = GridBagConstraints.BOTH;
		gbc_panel_udp.gridx = 3;
		gbc_panel_udp.gridy = 1;
		frmJnetcatch.getContentPane().add(panel_udp, gbc_panel_udp);
		panel_udp.setLayout(new BorderLayout(0, 0));

		JLabel lblUDP = new JLabel("UDP");
		panel_udp.add(lblUDP, BorderLayout.NORTH);

		textPaneUDP = new JTextPane();
		textPaneUDP.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textPaneUDP.setEditable(false);
		panel_udp.add(textPaneUDP);
	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			putValue(NAME, "抓包");
		}

		public void actionPerformed(ActionEvent e) {
			if (netcard != (int) comboBox.getModel().getSelectedItem()) {
				netcard = (int) comboBox.getModel().getSelectedItem();
				np = new NetworkPackage(NetworkPackage.lookupDevices()[netcard]);
			}
			np.getNext();
			emptyTextPane();
			showResult();
		}
	}

	private void showResult() {
		// 原始数据
		textPane.setText("头\n" + byte2String(np.packet.getHeader()) + "\n\n");
		textPane.setText(textPane.getText() + "数据\n"
				+ byte2String(np.packet.getData()));
		// textPane.setText(byte2String(np.ethernetpacket.getData()));
		// MAC
		textPaneMac.setText("目的地址："
				+ np.ethernetpacket.getDestinationHwAddress() + "\n");
		textPaneMac.setText(textPaneMac.getText() + "源地址："
				+ np.ethernetpacket.getSourceHwAddress() + "\n");
		textPaneMac.setText(textPaneMac.getText() + "协议："
				+ Integer.toHexString(np.ethernetpacket.getProtocol()) + "\n");
		textPaneMac.setText(textPaneMac.getText() + "头长度："
				+ np.ethernetpacket.getHeaderLength() + "\n");
		textPaneMac.setText(textPaneMac.getText() + "以太网协议：0x"
				+ Integer.toHexString(np.ethernetpacket.getEthernetProtocol())
				+ "\n");
		textPaneMac.setText(textPaneMac.getText() + "以太网头部长度："
				+ np.ethernetpacket.getEthernetHeaderLength() + "\n");

		// ARP
		if (np.ethernetpacket.getEthernetProtocol() == 2054) {
			textPaneARP.setText("以太网协议："
					+ Integer.toHexString(np.arppacket.getEthernetProtocol()));// 16进制表示，2054为0x0806
			textPaneARP.setText(textPaneARP.getText() + "操作："
					+ Integer.toHexString(np.arppacket.getOperation()) + "\n");// 表示为16进制，即0x0001等
			textPaneARP.setText(textPaneARP.getText() + "源地址："
					+ np.arppacket.getSourceHwAddress() + "\n");
			textPaneARP.setText(textPaneARP.getText() + "源原型地址："
					+ np.arppacket.getSourceProtoAddress() + "\n");
			textPaneARP.setText(textPaneARP.getText() + "目的地址："
					+ np.arppacket.getDestinationHwAddress() + "\n");
			textPaneARP.setText(textPaneARP.getText() + "目的原型地址"
					+ np.arppacket.getDestinationProtoAddress() + "\n");
		}
		// IP
		if (np.ethernetpacket.getEthernetProtocol() == 2048) {
			textPaneIP.setText("IP版本：IPv" + np.ippacket.getVersion() + "\n");
			textPaneIP.setText(textPaneIP.getText() + "源地址："
					+ np.ippacket.getSourceAddress() + "\n");
			textPaneIP.setText(textPaneIP.getText() + "目的地址："
					+ np.ippacket.getDestinationAddress() + "\n");
			textPaneIP.setText(textPaneIP.getText() + "ID："
					+ np.ippacket.getId() + "\n");
			textPaneIP.setText(textPaneIP.getText() + "协议："
					+ np.ippacket.getProtocol() + "\n");
			textPaneIP.setText(textPaneIP.getText() + "头长度："
					+ np.ippacket.getHeaderLength() + "\n");
			textPaneIP.setText(textPaneIP.getText() + "服务类型："
					+ np.ippacket.getTypeOfService() + "\n");
			textPaneIP.setText(textPaneIP.getText() + "长度："
					+ np.ippacket.getLength() + "\n");
			textPaneIP.setText(textPaneIP.getText() + "标志片段："
					+ np.ippacket.getFragmentFlags() + "\n");
			textPaneIP.setText(textPaneIP.getText() + "分段偏移："
					+ np.ippacket.getFragmentOffset() + "\n");
			textPaneIP.setText(textPaneIP.getText() + "存活时间："
					+ np.ippacket.getTimeToLive() + "\n");
			textPaneIP.setText(textPaneIP.getText() + "校验和："
					+ np.ippacket.getChecksum() + "\n");
		}
		// ICMP
		if (np.ippacket.getProtocol() == 1) {
			textPaneICMP.setText("消息类型：" + np.icmppacket.getMessageType()
					+ "\n");
			textPaneICMP.setText(textPaneICMP.getText() + "消息代码："
					+ np.icmppacket.getMessageCode() + "\n");
			textPaneICMP.setText(textPaneICMP.getText() + "校验和："
					+ np.icmppacket.getChecksum() + "\n");
			textPaneICMP.setText(textPaneICMP.getText() + "ID："
					+ np.icmppacket.getId() + "\n");
		}
		// TCP
		if (np.ippacket.getProtocol() == 6) {// TCP
			textPaneTCP.setText(textPaneTCP.getText() + "源端口："
					+ np.tcppacket.getSourcePort() + "\n");
			textPaneTCP.setText(textPaneTCP.getText() + "目的端口："
					+ np.tcppacket.getDestinationPort() + "\n");
			textPaneTCP.setText(textPaneTCP.getText() + "序列号："
					+ np.tcppacket.getSequenceNumber() + "\n");// 序列号
			textPaneTCP.setText(textPaneTCP.getText() + "确认序列号："
					+ np.tcppacket.getAcknowledgementNumber() + "\n");// 确认序列号
			textPaneTCP.setText(textPaneTCP.getText() + "分段偏移："
					+ np.tcppacket.getFragmentOffset() + "\n");
			textPaneTCP.setText(textPaneTCP.getText() + "分段标志："
					+ np.tcppacket.getFragmentFlags() + "\n");
			textPaneTCP.setText(textPaneTCP.getText() + "Urg："
					+ np.tcppacket.isUrg() + "\n");
			textPaneTCP.setText(textPaneTCP.getText() + "Ack："
					+ np.tcppacket.isAck() + "\n");
			textPaneTCP.setText(textPaneTCP.getText() + "Psh："
					+ np.tcppacket.isPsh() + "\n");
			textPaneTCP.setText(textPaneTCP.getText() + "Rst："
					+ np.tcppacket.isRst() + "\n");
			textPaneTCP.setText(textPaneTCP.getText() + "Syn："
					+ np.tcppacket.isSyn() + "\n");
			textPaneTCP.setText(textPaneTCP.getText() + "Fin："
					+ np.tcppacket.isFin() + "\n");
			textPaneTCP.setText(textPaneTCP.getText() + "窗口大小："
					+ np.tcppacket.getWindowSize() + "\n");
			textPaneTCP.setText(textPaneTCP.getText() + "校验和："
					+ np.tcppacket.getChecksum() + "\n");
			textPaneTCP.setText(textPaneTCP.getText() + "紧急指针："
					+ np.tcppacket.getUrgentPointer() + "\n");
		}

		// UDP
		if (np.ippacket.getProtocol() == 17) {
			textPaneUDP.setText("源端口：" + np.udppacket.getSourcePort() + "\n");
			textPaneUDP.setText(textPaneUDP.getText() + "目的端口："
					+ np.udppacket.getDestinationPort() + "\n");
			textPaneUDP.setText(textPaneUDP.getText() + "头长度："
					+ np.udppacket.getHeaderLength() + "\n");
			textPaneUDP.setText(textPaneUDP.getText() + "长度："
					+ np.udppacket.getLength() + "\n");
			textPaneUDP.setText(textPaneUDP.getText() + "校验和："
					+ np.udppacket.getChecksum() + "\n");
		}
	}

	private void emptyTextPane() {
		textPaneARP.setText("");
		textPaneICMP.setText("");
		textPaneIP.setText("");
		textPaneMac.setText("");
		textPaneTCP.setText("");
		textPaneTCP.setText("");
		textPaneUDP.setText("");
	}

	private Integer[] getIntegerArray(int length) {
		Integer[] integers = new Integer[(length)];
		for (int i = 0; i < length; i++) {
			integers[i] = i;
		}
		return integers;
	}

	private String byte2String(byte[] bytes) {
		String str = "";
		String temp = "";
		for (byte b : bytes) {
			temp = Integer.toHexString((int) b & 0x0ff);
			str += (temp.length() == 1 ? "0" + temp : temp) + " ";
			// str += (b & 0x0ff) + " ";
		}
		return str;
	}
}
