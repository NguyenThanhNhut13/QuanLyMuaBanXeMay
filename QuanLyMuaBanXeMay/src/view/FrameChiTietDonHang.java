package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.CustomersDAO;
import dao.DonHangDAO;
import dao.MotobikeDAO;
import dao.StaffDAO;
import entity.Customer;
import entity.DonHang;
import entity.Motobike;
import entity.Staff;

import javax.swing.JButton;
import java.awt.Color;

public class FrameChiTietDonHang extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JButton btn_thoat;
	private DefaultTableModel model;
	private DecimalFormat df;
	private JButton btn_xacNhanDonHang;
	private JLabel lbl_valueMaDonHang;
	private JLabel lbl_trangThai;

	public FrameChiTietDonHang(DonHang donHang, FrameDonHang frameDonHang) {
		this.setTitle("Chi tiết đơn hàng");
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_thongTin = new JPanel();
		panel_thongTin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_thongTin.setBounds(10, 11, 666, 179);
		contentPane.add(panel_thongTin);
		panel_thongTin.setLayout(null);

		JLabel lbl_maDonHang = new JLabel("Mã đơn hàng:");
		lbl_maDonHang.setBounds(10, 15, 108, 17);
		panel_thongTin.add(lbl_maDonHang);
		lbl_maDonHang.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lbl_maKhachHang = new JLabel("Mã khách hàng:");
		lbl_maKhachHang.setFont(new Font("Arial", Font.PLAIN, 14));
		lbl_maKhachHang.setBounds(10, 47, 108, 18);
		panel_thongTin.add(lbl_maKhachHang);

		JLabel lbl_maNhanVien = new JLabel("Mã nhân viên:");
		lbl_maNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		lbl_maNhanVien.setBounds(10, 80, 108, 18);
		panel_thongTin.add(lbl_maNhanVien);

		JLabel lbl_tongTien = new JLabel("Tổng tiền:");
		lbl_tongTien.setFont(new Font("Arial", Font.PLAIN, 14));
		lbl_tongTien.setBounds(10, 113, 108, 18);
		panel_thongTin.add(lbl_tongTien);

		lbl_trangThai = new JLabel("Trạng thái:");
		lbl_trangThai.setFont(new Font("Arial", Font.PLAIN, 14));
		lbl_trangThai.setBounds(10, 146, 108, 18);
		panel_thongTin.add(lbl_trangThai);

		JLabel lbl_ngayTaoDonHang = new JLabel("Ngày tạo đơn hàng:");
		lbl_ngayTaoDonHang.setFont(new Font("Arial", Font.PLAIN, 14));
		lbl_ngayTaoDonHang.setBounds(360, 14, 129, 18);
		panel_thongTin.add(lbl_ngayTaoDonHang);

		JLabel lbl_tenKhachHang = new JLabel("Tên khách hàng:");
		lbl_tenKhachHang.setFont(new Font("Arial", Font.PLAIN, 14));
		lbl_tenKhachHang.setBounds(360, 47, 129, 18);
		panel_thongTin.add(lbl_tenKhachHang);

		JLabel lbl_tenNhanVien = new JLabel("Tên nhân viên:");
		lbl_tenNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		lbl_tenNhanVien.setBounds(360, 80, 129, 18);
		panel_thongTin.add(lbl_tenNhanVien);

		JLabel lbl_ghiChu = new JLabel("Ghi chú:");
		lbl_ghiChu.setFont(new Font("Arial", Font.PLAIN, 14));
		lbl_ghiChu.setBounds(360, 113, 129, 18);
		panel_thongTin.add(lbl_ghiChu);

		JTextArea textArea_ghiChu = new JTextArea(donHang.getNote());
		textArea_ghiChu.setFont(new Font("Arial", Font.BOLD, 14));
		textArea_ghiChu.setEditable(false);
		textArea_ghiChu.setBounds(493, 111, 163, 55);
		panel_thongTin.add(textArea_ghiChu);

		lbl_valueMaDonHang = new JLabel(donHang.getOrder_id());
		lbl_valueMaDonHang.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_valueMaDonHang.setBounds(147, 15, 108, 17);
		panel_thongTin.add(lbl_valueMaDonHang);

		JLabel lbl_valueMaKhachHang = new JLabel(donHang.getCustomer_id());
		lbl_valueMaKhachHang.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_valueMaKhachHang.setBounds(147, 47, 108, 18);
		panel_thongTin.add(lbl_valueMaKhachHang);

		JLabel lbl_valueMaNhanVien = new JLabel(donHang.getStaff_id());
		lbl_valueMaNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_valueMaNhanVien.setBounds(147, 80, 108, 18);
		panel_thongTin.add(lbl_valueMaNhanVien);

		df = new DecimalFormat("###,###");
		JLabel lbl_valueTongTien = new JLabel(df.format(donHang.getOrderAmount()));
		lbl_valueTongTien.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_valueTongTien.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_valueTongTien.setBounds(147, 113, 98, 18);
		panel_thongTin.add(lbl_valueTongTien);

		JLabel lbl_valueTrangThai = new JLabel(donHang.getStatus());
		lbl_valueTrangThai.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_valueTrangThai.setBounds(147, 146, 108, 18);
		panel_thongTin.add(lbl_valueTrangThai);

		JLabel lbl_tongTienDonVi = new JLabel("VNĐ");
		lbl_tongTienDonVi.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_tongTienDonVi.setBounds(255, 115, 49, 14);
		panel_thongTin.add(lbl_tongTienDonVi);

		JLabel lbl_valueNgayTaoDonHang = new JLabel(donHang.getOrder_Date() + "");
		lbl_valueNgayTaoDonHang.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_valueNgayTaoDonHang.setBounds(498, 14, 158, 18);
		panel_thongTin.add(lbl_valueNgayTaoDonHang);

		JLabel lbl_valueTenKhachHang = new JLabel(
				CustomersDAO.getInstance().selectByID(donHang.getCustomer_id()).getCustomer_Name());
		lbl_valueTenKhachHang.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_valueTenKhachHang.setBounds(498, 47, 158, 18);
		panel_thongTin.add(lbl_valueTenKhachHang);

		JLabel lbl_valueTenNhanVien = new JLabel(
				StaffDAO.getInstance().selectByID(donHang.getStaff_id()).getStaffName());
		lbl_valueTenNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_valueTenNhanVien.setBounds(498, 80, 158, 18);
		panel_thongTin.add(lbl_valueTenNhanVien);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 211, 666, 179);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == -1;
			}
		};
		model.addColumn("STT");
		model.addColumn("Mã sản phẩm");
		model.addColumn("Tên sản phẩm");
		model.addColumn("Số lượng");
		model.addColumn("Đơn giá");
		table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);

		btn_thoat = new JButton("Thoát");
		btn_thoat.setBackground(Color.GREEN);
		btn_thoat.setFont(new Font("Arial", Font.BOLD, 14));
		btn_thoat.setBounds(550, 417, 89, 23);
		contentPane.add(btn_thoat);

		btn_xacNhanDonHang = new JButton("Xác nhận đơn hàng");
		btn_xacNhanDonHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienXacNhan(frameDonHang);
			}
		});
		btn_xacNhanDonHang.setForeground(Color.WHITE);
		btn_xacNhanDonHang.setFont(new Font("Arial", Font.BOLD, 14));
		btn_xacNhanDonHang.setBackground(Color.BLUE);
		btn_xacNhanDonHang.setBounds(42, 415, 179, 27);
		contentPane.add(btn_xacNhanDonHang);

		JButton btn_huyDonHang = new JButton("Hủy đơn hàng");
		btn_huyDonHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienHuy(frameDonHang);
			}
		});
		btn_huyDonHang.setForeground(Color.WHITE);
		btn_huyDonHang.setFont(new Font("Arial", Font.BOLD, 14));
		btn_huyDonHang.setBackground(Color.RED);
		btn_huyDonHang.setBounds(251, 415, 179, 27);
		contentPane.add(btn_huyDonHang);

		btn_thoat.addActionListener(this);

		loadDSSanPham(donHang);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_thoat) {
			thucHienThoat();
		}
	}

	public JButton getBtn_thoat() {
		return btn_thoat;
	}

	public void setBtn_thoat(JButton btn_thoat) {
		this.btn_thoat = btn_thoat;
	}

	public void thucHienThoat() {
		this.setVisible(false);
	}

	public void loadDSSanPham(DonHang donHang) {
		model.setRowCount(0);
		ArrayList<Motobike> listSP = donHang.getListSanPham();
		for (int i = 0; i < listSP.size(); i++) {
			String data[] = { i + 1 + "", listSP.get(i).getId(), listSP.get(i).getName(),
					listSP.get(i).getQuantity() + "", df.format(listSP.get(i).getPrice()) };
			model.addRow(data);
		}
	}

	private void thucHienXacNhan(FrameDonHang frameDonHang) {
		DonHang donHang_test = new DonHang();
		donHang_test.setOrder_id(lbl_valueMaDonHang.getText());
		DonHang donHang = DonHangDAO.getInstance().selectByID(donHang_test);
		if(donHang.getStatus().equals("Chờ xử lý")) {
			donHang.setStatus("Đã xác nhận");
			DonHangDAO.getInstance().update(donHang);
			frameDonHang.loadDanhSachDonHang();
			lbl_trangThai.setText("Đã xác nhận");
			lbl_trangThai.repaint();
			JOptionPane.showMessageDialog(this, "Đã xác nhận thành công");
		}else {
			JOptionPane.showMessageDialog(this, "Bạn chỉ xác nhận được đơn hàng đang chờ xử lý thôi");
			return;
		}
		
		
	}

	private void thucHienHuy(FrameDonHang frameDonHang) {
		MotobikeDAO daoMotobike = new MotobikeDAO();
		DonHang donHang_test = new DonHang();
		donHang_test.setOrder_id(lbl_valueMaDonHang.getText());
		DonHang donHang = DonHangDAO.getInstance().selectByID(donHang_test);
		if (donHang.getStatus().equals("Chờ xử lý") || donHang.getStatus().equals("Đã xác nhận")) {
			if(JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn hủy đơn hàng này chứ?", "CẢNH BÁO", JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				donHang.setStatus("Đã hủy");
				DonHangDAO.getInstance().update(donHang);
				for (Motobike motobike : donHang.getListSanPham()) {
					Motobike motobike_old = daoMotobike.get1XeTheoMa(motobike.getId());
					motobike_old.setQuantity(motobike_old.getQuantity()+motobike.getQuantity());
					daoMotobike.capNhatXe(motobike_old);
				}
				lbl_trangThai.setText("Đã hủy");
				lbl_trangThai.repaint();
				frameDonHang.loadDanhSachDonHang();
				JOptionPane.showMessageDialog(this, "Đã hủy thành công!");
			}
		}else {
			if(donHang.getStatus().equals("Đã hủy")) {
				JOptionPane.showMessageDialog(this, "Đơn hàng này đã bị hủy từ trước!");
				return;
			}else if(donHang.getStatus().equals("Đã hoàn thành")) {
				JOptionPane.showMessageDialog(this, "Đơn hàng này đã hoàn thành rồi không thể hủy!");
				return;
			}
		}
		
	}
}

