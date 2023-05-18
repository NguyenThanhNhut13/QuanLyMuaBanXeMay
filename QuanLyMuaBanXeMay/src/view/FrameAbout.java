package view;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;

public class FrameAbout extends JPanel {


	public FrameAbout() {
		setLayout(null);
		
		JTextArea txtrChoMngn = new JTextArea();
		txtrChoMngn.setEditable(false);
		txtrChoMngn.setColumns(10);
		txtrChoMngn.setFont(new Font("Arial", Font.PLAIN, 15));
		txtrChoMngn.setLineWrap(true);
		txtrChoMngn.setText("Chào mừng đến với sản phẩm quản lý mua bán xe máy. Đây là một sản phẩm phần mềm được\r\nphát triển nhằm giúp người dùng quản lý và tổ chức thông tin về việc mua bán xe máy. Với giao diện thân thiện và tính năng đa dạng, sản phẩm này sẽ giúp bạn dễ dàng quản lý thông tin về xe máy, bao gồm cả thông tin về khách hàng, sản phẩm và hóa đơn. "
				+ "\n\nChúng tôi cam kết mang đến cho người dùng một sản phẩm chất lượng, đáp ứng đầy đủ các\r\nnhu cầu quản lý mua bán xe máy của khách hàng.\r\n"
				+ "\r\n"
				+ "Thành viên phát triển:\r\n"
				+ "\r\n"
				+ "Nguyễn Thanh Nhứt - 21140001: Thiên tài giao diện.\r\n"
				+ "Nguyễn Thanh Phới - 21077161: Nhà vua quản trị dữ liệu.\r\n"
				+ "Lê Thị Ngọc Mai   - 20005501: Chuyên gia vận hành cơ sở dữ liệu");
		txtrChoMngn.setBounds(95, 96, 636, 269);
		add(txtrChoMngn);
	}
}
