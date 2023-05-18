package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.StaffDAO;
import entity.Staff;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class FrameDangNhap extends JFrame implements ActionListener {
	public JTextField textField_taiKhoan;
	public FrameMain frameMain;
	private JPasswordField passwordField_matKhau;
	private Staff user;

	public FrameDangNhap() {
		getContentPane().setFont(new Font("Arial", Font.BOLD, 11));
		this.init();
	}

	public JTextField getTextField_taiKhoan() {
		return textField_taiKhoan;
	}

	public void setTextField_taiKhoan(JTextField textField_taiKhoan) {
		this.textField_taiKhoan = textField_taiKhoan;
	}

	public JPasswordField getPasswordField_matKhau() {
		return passwordField_matKhau;
	}

	public void setPasswordField_matKhau(JPasswordField passwordField_matKhau) {
		this.passwordField_matKhau = passwordField_matKhau;
	}

	private void init() {
		this.setTitle("Đăng Nhập");
		this.setSize(400, 350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel jlabel_dangNhap = new JLabel("Đăng Nhập");
		jlabel_dangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		jlabel_dangNhap.setFont(new Font("Arial", Font.BOLD, 20));
		jlabel_dangNhap.setForeground(new Color(0, 0, 255));
		jlabel_dangNhap.setBounds(136, 23, 105, 24);
		getContentPane().add(jlabel_dangNhap);

		JLabel lbl_taiKhoan = new JLabel("Tài Khoản:");
		lbl_taiKhoan.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_taiKhoan.setBounds(29, 69, 73, 18);
		getContentPane().add(lbl_taiKhoan);

		textField_taiKhoan = new JTextField();
		textField_taiKhoan.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_taiKhoan.setBounds(107, 68, 219, 20);
		getContentPane().add(textField_taiKhoan);
		textField_taiKhoan.setColumns(10);

		JLabel lbl_matKhau = new JLabel("Mật Khẩu: ");
		lbl_matKhau.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_matKhau.setBounds(29, 111, 73, 18);
		getContentPane().add(lbl_matKhau);

		JButton btn_dangNhap = new JButton("Đăng Nhập");
		btn_dangNhap.setFont(new Font("Arial", Font.BOLD, 14));
		btn_dangNhap.setBounds(52, 195, 115, 27);
		getContentPane().add(btn_dangNhap);

		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.setFont(new Font("Arial", Font.BOLD, 14));
		btn_thoat.setBounds(219, 195, 115, 27);
		getContentPane().add(btn_thoat);

		passwordField_matKhau = new JPasswordField();
		passwordField_matKhau.setBounds(107, 110, 219, 20);
		getContentPane().add(passwordField_matKhau);
		btn_dangNhap.addActionListener(this);
		btn_thoat.addActionListener(this);
		this.setVisible(true);
	}

	public void thucHienThoat() {
		System.exit(0);
	}

	public void thucHienDangNhap() {
		char[] pass = passwordField_matKhau.getPassword();
		String password = new String(pass);
		if (textField_taiKhoan.getText().equals("") && password.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
			return;
		}else if (textField_taiKhoan.getText().equals("") ) {
			JOptionPane.showMessageDialog(this, "Tên tài khoản không được bỏ trống!");
			textField_taiKhoan.requestFocus();
			return;
		}else if (password.equals("") ) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không được bỏ trống!");
			passwordField_matKhau.requestFocus();
			return;
		} else {
			if (kiemTraDangNhap()) {
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
				this.setVisible(false);
				frameMain = new FrameMain(user, this);
				frameMain.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không chính xác!");
				return;
			}
		}
	}

	private boolean kiemTraDangNhap() {
		char[] pass = passwordField_matKhau.getPassword();
		String password = new String(pass);
		for (Staff staff : StaffDAO.getInstance().selectAll()) {
			if (textField_taiKhoan.getText().equals(staff.getStaffID()) && password.equals("123456789")) {
				user = staff;
				return true;
			}
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Đăng Nhập")) {
			thucHienDangNhap();
		} else if (cm.equals("Thoát")) {
			thucHienThoat();
		}

	}
}

