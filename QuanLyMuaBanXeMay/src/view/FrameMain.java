package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entity.Staff;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;

public class FrameMain extends JFrame implements ActionListener {
	public FrameDangNhap frameDangNhap;
	public JPanel panel_chucNang;
	public JTabbedPane tabbedPane_chucNang;
	private FrameNhanVien frameNhanVien;
	private FrameKhachHang frameKhachHang;
	private FrameBanHang frameBanHang;
	private FrameDonHang frameDonHang;
	private FrameXeMay frameXeMay;
	private FrameThongKe frameThongKe;
	private JLabel lbl_user;
	private Staff user;

	public FrameMain(Staff user, FrameDangNhap frameDangNhap) {
		this.frameDangNhap = frameDangNhap;
		this.user = user;
		getContentPane().setBackground(SystemColor.window);
		this.init();
		loadData();
	}

	private void init() {
		this.setTitle("Quản lý mua bán xe máy - Nhóm 1");
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().setLayout(null);

		lbl_user = new JLabel();
		lbl_user.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(FrameMain.class.getResource("/img/user.png"))));
		lbl_user.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_user.setFont(new Font("Arial", Font.BOLD, 12));
		lbl_user.setBounds(10, 13, 153, 32);
		getContentPane().add(lbl_user);

		JButton btn_dangXuat = new JButton("Đăng Xuất");
		btn_dangXuat.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(FrameMain.class.getResource("/img/log-out.png"))));
		btn_dangXuat.setFont(new Font("Arial", Font.BOLD, 12));
		btn_dangXuat.setBounds(10, 500, 155, 49);
		getContentPane().add(btn_dangXuat);

		JButton btn_xeMay = new JButton("Xe máy");
		btn_xeMay.setFont(new Font("Arial", Font.BOLD, 12));
		btn_xeMay.setIcon(new ImageIcon(FrameMain.class.getResource("/img/motorbike.png")));
		btn_xeMay.setBounds(10, 185, 155, 49);
		getContentPane().add(btn_xeMay);

		JButton btn_banHang = new JButton("Bán hàng");
		btn_banHang.setFont(new Font("Arial", Font.BOLD, 12));
		btn_banHang.setIcon(new ImageIcon(FrameMain.class.getResource("/img/banHang.png")));
		btn_banHang.setBounds(10, 59, 155, 49);
		getContentPane().add(btn_banHang);

		JButton btn_thongKe = new JButton("Thống kê");
		btn_thongKe.setFont(new Font("Arial", Font.BOLD, 12));
		btn_thongKe.setIcon(new ImageIcon(FrameMain.class.getResource("/img/thongKe.png")));
		btn_thongKe.setBounds(10, 374, 155, 49);
		getContentPane().add(btn_thongKe);

		JButton btn_nhanVien = new JButton("Nhân viên");
		btn_nhanVien.setFont(new Font("Arial", Font.BOLD, 12));
		btn_nhanVien.setIcon(new ImageIcon(FrameMain.class.getResource("/img/nhanVien.png")));
		btn_nhanVien.setBounds(10, 311, 155, 49);
		getContentPane().add(btn_nhanVien);

		JButton btn_khachHang = new JButton("Khách hàng");
		btn_khachHang.setFont(new Font("Arial", Font.BOLD, 12));
		btn_khachHang.setIcon(new ImageIcon(FrameMain.class.getResource("/img/khachHang.png")));
		btn_khachHang.setBounds(10, 248, 155, 49);
		getContentPane().add(btn_khachHang);

		JButton btn_thongTin = new JButton("Thông tin");
		btn_thongTin.setFont(new Font("Arial", Font.BOLD, 12));
		btn_thongTin.setIcon(new ImageIcon(FrameMain.class.getResource("/img/thongTin.png")));
		btn_thongTin.setBounds(10, 437, 155, 49);
		getContentPane().add(btn_thongTin);

		panel_chucNang = new JPanel();
		panel_chucNang.setBounds(165, 11, 811, 541);
		getContentPane().add(panel_chucNang);
		panel_chucNang.setLayout(new CardLayout(0, 0));

		tabbedPane_chucNang = new JTabbedPane();
		tabbedPane_chucNang.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		panel_chucNang.add(tabbedPane_chucNang);

		frameBanHang = new FrameBanHang();
		frameBanHang.setBackground(SystemColor.window);
		tabbedPane_chucNang.add("Bán hàng", frameBanHang);
		frameDonHang = new FrameDonHang();
		frameDonHang.setBackground(SystemColor.window);
		tabbedPane_chucNang.add("Đơn hàng", frameDonHang);
		frameXeMay = new FrameXeMay();
		frameXeMay.setBackground(SystemColor.window);
		tabbedPane_chucNang.add("Xe máy", frameXeMay);
		frameNhanVien = new FrameNhanVien();
		frameNhanVien.setBackground(SystemColor.window);
		if (!(user.getPosition().equals("Nhân viên"))) {
			tabbedPane_chucNang.add("Nhân viên", frameNhanVien);
		}
		frameKhachHang = new FrameKhachHang();
		frameKhachHang.setBackground(SystemColor.window);
		tabbedPane_chucNang.add("Khách hàng", frameKhachHang);
		frameThongKe = new FrameThongKe();
		frameThongKe.setBackground(SystemColor.window);
		tabbedPane_chucNang.add("Thống kê", frameThongKe);
		tabbedPane_chucNang.add("Thông tin", new FrameAbout());

		JButton btn_donHang = new JButton("Đơn hàng");
		btn_donHang.setBounds(10, 122, 155, 49);
		getContentPane().add(btn_donHang);
		btn_donHang.setIcon(new ImageIcon(FrameMain.class.getResource("/img/hoaDon.png")));
		btn_donHang.setFont(new Font("Arial", Font.BOLD, 12));
		btn_donHang.addActionListener(this);

		btn_banHang.addActionListener(this);
		btn_xeMay.addActionListener(this);
		btn_khachHang.addActionListener(this);
		btn_nhanVien.addActionListener(this);
		btn_thongKe.addActionListener(this);
		btn_thongTin.addActionListener(this);
		btn_dangXuat.addActionListener(this);

	}

	public void loadData() {
		frameNhanVien.loadData();
		frameKhachHang.loadData();
		lbl_user.setText(user.getStaffName());
	}

	public void chuyenTab(String cm) {
		if (cm.equals("Bán hàng")) {
			frameBanHang.loadData();
		} else if (cm.equals("Đơn hàng")) {
			frameDonHang.loadData();
		} else if (cm.equals("Xe máy")) {
			frameXeMay.loadDanhSachXe();
		} else if (cm.equals("Thống kê")) {
			frameThongKe.loadData();
		}
		tabbedPane_chucNang.setSelectedIndex(tabbedPane_chucNang.indexOfTab(cm));
	}

	public void thucHienDangXuat() {
		JOptionPane.showMessageDialog(this, "Đã đăng xuất");
		this.setVisible(false);
		frameDangNhap.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Bán hàng")) {
			chuyenTab(cm);
		} else if (cm.equals("Xe máy")) {
			chuyenTab(cm);
		} else if (cm.equals("Đơn hàng")) {
			chuyenTab(cm);
		} else if (cm.equals("Khách hàng")) {
			chuyenTab(cm);
		} else if (cm.equals("Nhân viên")) {
			chuyenTab(cm);
		} else if (cm.equals("Thống kê")) {
			chuyenTab(cm);
		} else if (cm.equals("Thông tin")) {
			chuyenTab(cm);
		} else if (cm.equals("Đăng Xuất")) {
			thucHienDangXuat();
		}

	}
}
