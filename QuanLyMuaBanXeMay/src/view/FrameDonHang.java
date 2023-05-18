package view;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import connection.ConnectDB;
import dao.BanHangDAO;
import dao.ChiTietHDDAO;
import dao.CustomersDAO;
import dao.DonHangDAO;
import dao.StaffDAO;
import entity.ChiTietHoaDon;
import entity.Customer;
import entity.DonHang;
import entity.Staff;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class FrameDonHang extends JPanel implements ActionListener {
	private ArrayList<DonHang> listDonHang;
	private DefaultTableModel model;
	private JTable table;
	private JComboBox<String> comboBox_locTheoTongTien_Start;
	private JComboBox<String> comboBox_locTheoTongTien_End;
	private JComboBox<String> comboBox_locTheoTen;
	private JComboBox<String> comboBox_locTheoTrangThai;
	private BanHangDAO daoBanHang;
	private DecimalFormat dfmGia;
	private DonHangDAO daoDonHang;
	private JButton btn_loc;
	private JButton btn_xemChiTiet;
	private JButton btn_inHoaDon;

	public FrameDonHang() {
		setLayout(null);

		JPanel panel_timKiem = new JPanel();
		panel_timKiem.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\u0110\u01A1n h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_timKiem.setBounds(10, 11, 791, 463);
		add(panel_timKiem);
		panel_timKiem.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 204, 771, 248);
		panel_timKiem.add(scrollPane, BorderLayout.CENTER);

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == -1;
			}
		};
		model.addColumn("Mã đơn hàng");
		model.addColumn("Ngày lập đơn hàng");
		model.addColumn("Tổng tiền");
		model.addColumn("Trạng thái");
		model.addColumn("Người lập");
		model.addColumn("Tên khách hàng");
		model.addColumn("Ghi chú");
		table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(table);

		JPanel panel_locTheoTen = new JPanel();
		panel_locTheoTen.setBorder(new TitledBorder(null, "L\u1ECDc theo t\u00EAn kh\u00E1ch h\u00E0ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_locTheoTen.setBounds(29, 37, 184, 67);
		panel_timKiem.add(panel_locTheoTen);
		panel_locTheoTen.setLayout(null);

		comboBox_locTheoTen = new JComboBox<String>();
		comboBox_locTheoTen.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_locTheoTen.setBounds(28, 21, 127, 22);
		panel_locTheoTen.add(comboBox_locTheoTen);

		JPanel panel_locTheoTrangThai = new JPanel();
		panel_locTheoTrangThai.setLayout(null);
		panel_locTheoTrangThai.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"L\u1ECDc theo tr\u1EA1ng th\u00E1i", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_locTheoTrangThai.setBounds(242, 37, 152, 67);
		panel_timKiem.add(panel_locTheoTrangThai);

		comboBox_locTheoTrangThai = new JComboBox<String>();
		comboBox_locTheoTrangThai.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_locTheoTrangThai.setBounds(10, 21, 127, 22);
		comboBox_locTheoTrangThai.addItem("");
		comboBox_locTheoTrangThai.addItem("Chờ xử lý");
		comboBox_locTheoTrangThai.addItem("Đã xác nhận");
		comboBox_locTheoTrangThai.addItem("Đã hoàn thành");
		comboBox_locTheoTrangThai.addItem("Đã hủy");
		panel_locTheoTrangThai.add(comboBox_locTheoTrangThai);

		JPanel panel_locTheoTongTien = new JPanel();
		panel_locTheoTongTien.setLayout(null);
		panel_locTheoTongTien.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"L\u1ECDc theo t\u1ED5ng ti\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_locTheoTongTien.setBounds(423, 37, 337, 67);
		panel_timKiem.add(panel_locTheoTongTien);

		JLabel lblNewLabel_1_1 = new JLabel("đến");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(161, 26, 28, 14);
		panel_locTheoTongTien.add(lblNewLabel_1_1);

		comboBox_locTheoTongTien_Start = new JComboBox<>();
		comboBox_locTheoTongTien_Start.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_locTheoTongTien_Start.setBounds(31, 22, 120, 22);
		panel_locTheoTongTien.add(comboBox_locTheoTongTien_Start);

		JLabel lblNewLabel_tu = new JLabel("Từ");
		lblNewLabel_tu.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_tu.setBounds(10, 26, 22, 14);
		panel_locTheoTongTien.add(lblNewLabel_tu);

		comboBox_locTheoTongTien_End = new JComboBox<>();
		comboBox_locTheoTongTien_End.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_locTheoTongTien_End.setBounds(186, 22, 130, 22);
		panel_locTheoTongTien.add(comboBox_locTheoTongTien_End);

		comboBox_locTheoTongTien_Start.addItem("");
		comboBox_locTheoTongTien_Start.addItem("0");
		comboBox_locTheoTongTien_Start.addItem("20.000.000 VNĐ");
		comboBox_locTheoTongTien_Start.addItem("50.000.000 VNĐ");
		comboBox_locTheoTongTien_Start.addItem("100.000.000 VNĐ");
		comboBox_locTheoTongTien_Start.addItem("200.000.000 VNĐ");
		comboBox_locTheoTongTien_Start.addItem("500.000.000 VNĐ");
		comboBox_locTheoTongTien_Start.addItem("1.000.000.000 VNĐ");

		comboBox_locTheoTongTien_End.addItem("");
		comboBox_locTheoTongTien_End.addItem("20.000.000 VNĐ");
		comboBox_locTheoTongTien_End.addItem("50.000.000 VNĐ");
		comboBox_locTheoTongTien_End.addItem("100.000.000 VNĐ");
		comboBox_locTheoTongTien_End.addItem("200.000.000 VNĐ");
		comboBox_locTheoTongTien_End.addItem("500.000.000 VNĐ");
		comboBox_locTheoTongTien_End.addItem("1.000.000.000 VNĐ");
		comboBox_locTheoTongTien_End.addItem("2.000.000.000 VNĐ");

		btn_loc = new JButton("Lọc");
		btn_loc.setForeground(Color.WHITE);
		btn_loc.setBackground(Color.BLUE);
		btn_loc.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_loc.setBounds(351, 146, 89, 23);
		panel_timKiem.add(btn_loc);

		btn_xemChiTiet = new JButton("Xem chi tiết");
		btn_xemChiTiet.setBackground(Color.ORANGE);
		btn_xemChiTiet.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_xemChiTiet.setBounds(211, 485, 93, 23);
		add(btn_xemChiTiet);

		btn_inHoaDon = new JButton("In hóa đơn");
		btn_inHoaDon.setBackground(Color.GREEN);
		btn_inHoaDon.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_inHoaDon.setBounds(511, 485, 89, 23);
		add(btn_inHoaDon);

		btn_loc.addActionListener(this);
		btn_xemChiTiet.addActionListener(this);
		btn_inHoaDon.addActionListener(this);

		dfmGia = new DecimalFormat("###,###");
		loadData();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_xemChiTiet) {
			thucHienXemChiTiet();
		} else if (e.getSource() == btn_loc && btn_loc.getText().equals("Lọc")) {
			thucHienLoc();
		} else if (e.getSource() == btn_loc && btn_loc.getText().equals("Hủy lọc")) {
			loadDanhSachDonHang();
			btn_loc.setText("Lọc");
		} else if (e.getSource() == btn_inHoaDon) {
			thucHienInHoaDon();
		}

	}

	public void thucHienXemChiTiet() {
		daoDonHang = new DonHangDAO();
		int row = table.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn đơn hàng cần xem chi tiết!");
			return;
		} else {
			DonHang donHang = new DonHang();
			donHang.setOrder_id(model.getValueAt(row, 0) + "");
			FrameChiTietDonHang frameChiTietDonHang = new FrameChiTietDonHang(daoDonHang.selectByID(donHang), this);
			frameChiTietDonHang.setVisible(true);
		}
	}

	public void loadData() {
		loadDanhSachDonHang();
		comboBox_locTheoTen.removeAllItems();
		comboBox_locTheoTen.addItem("");
		for (Customer customer : CustomersDAO.getInstance().selectAll()) {
			comboBox_locTheoTen.addItem(customer.getCustomer_ID());
		}

	}

	public void loadDanhSachDonHang() {
		model.setRowCount(0);
		listDonHang = daoDonHang.getInstance().selectAll();

		for (DonHang donHang : listDonHang) {
			String data[] = { donHang.getOrder_id(), donHang.getOrder_Date() + "",
					dfmGia.format(donHang.getOrderAmount()), donHang.getStatus(),
					StaffDAO.getInstance().selectByID(donHang.getStaff_id()).getStaffName(),
					CustomersDAO.getInstance().selectByID(donHang.getCustomer_id()).getCustomer_Name(),
					donHang.getNote() };
			model.addRow(data);
		}
	}

	private void thucHienLoc() {
		if (comboBox_locTheoTen.getSelectedItem().equals("") && comboBox_locTheoTrangThai.getSelectedItem().equals("")
				&& comboBox_locTheoTongTien_Start.getSelectedItem().equals("")
				&& comboBox_locTheoTongTien_End.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn loại lọc!");
			return;
		} else if (comboBox_locTheoTongTien_Start.getSelectedItem().equals("")
				&& !(comboBox_locTheoTongTien_End.getSelectedItem().equals(""))
				|| !(comboBox_locTheoTongTien_Start.getSelectedItem().equals(""))
						&& comboBox_locTheoTongTien_End.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ giá từ và giá đến!");
			return;
		} else {
			btn_loc.setText("Hủy lọc");
			ArrayList<DonHang> listOrderFilter = new ArrayList<DonHang>();
			String customer_id = comboBox_locTheoTen.getSelectedItem() + "";
			String status = comboBox_locTheoTrangThai.getSelectedItem() + "";
			double gia_startArray[] = { -1, 0, 20000000, 50000000, 100000000, 200000000, 500000000, 1000000000 };
			double gia_endAray[] = { -1, 20000000, 50000000, 100000000, 200000000, 500000000, 1000000000, 2000000000 };
			double gia_start = gia_startArray[comboBox_locTheoTongTien_Start.getSelectedIndex()];
			double gia_end = gia_endAray[comboBox_locTheoTongTien_End.getSelectedIndex()];

			for (DonHang donHang : daoDonHang.getInstance().selectAll()) {
				if (!(customer_id.equals("")) && !(status.equals(""))
						&& !(comboBox_locTheoTongTien_Start.getSelectedItem().equals(""))
						&& !(comboBox_locTheoTongTien_End.getSelectedItem().equals(""))) {
					if (donHang.getCustomer_id().equals(customer_id) && donHang.getStatus().equals(status)
							&& donHang.getOrderAmount() >= gia_start && donHang.getOrderAmount() <= gia_end) {
						listOrderFilter.add(donHang);
					}
				} else if (!(customer_id.equals("")) && !(status.equals(""))) {
					if (donHang.getCustomer_id().equals(customer_id) && donHang.getStatus().equals(status)) {
						listOrderFilter.add(donHang);
					}
				} else if (!(customer_id.equals("")) && !(comboBox_locTheoTongTien_Start.getSelectedItem().equals(""))
						&& !(comboBox_locTheoTongTien_End.getSelectedItem().equals(""))) {
					if (donHang.getCustomer_id().equals(customer_id) && donHang.getOrderAmount() >= gia_start
							&& donHang.getOrderAmount() <= gia_end) {
						listOrderFilter.add(donHang);
					}
				} else if (!(status.equals("")) && !(comboBox_locTheoTongTien_Start.getSelectedItem().equals(""))
						&& !(comboBox_locTheoTongTien_End.getSelectedItem().equals(""))) {
					if (donHang.getStatus().equals(status) && donHang.getOrderAmount() >= gia_start
							&& donHang.getOrderAmount() <= gia_end) {
						listOrderFilter.add(donHang);
					}
				} else if (!(customer_id.equals(""))) {
					if (donHang.getCustomer_id().equals(customer_id)) {
						listOrderFilter.add(donHang);
					}
				} else if (!(status.equals(""))) {
					if (donHang.getStatus().equals(status)) {
						listOrderFilter.add(donHang);
					}
				} else if (!(comboBox_locTheoTongTien_Start.getSelectedItem().equals(""))
						&& !(comboBox_locTheoTongTien_End.getSelectedItem().equals(""))) {
					if (donHang.getOrderAmount() >= gia_start && donHang.getOrderAmount() <= gia_end) {
						listOrderFilter.add(donHang);
					}
				}

			}
			if (listOrderFilter != null) {
				model.setRowCount(0);
				for (DonHang donHang : listOrderFilter) {
					String data[] = { donHang.getOrder_id(), donHang.getOrder_Date() + "",
							dfmGia.format(donHang.getOrderAmount()), donHang.getStatus(),
							StaffDAO.getInstance().selectByID(donHang.getStaff_id()).getStaffName(),
							CustomersDAO.getInstance().selectByID(donHang.getCustomer_id()).getCustomer_Name(),
							donHang.getNote() };
					model.addRow(data);
				}
			}

		}

	}

	private void thucHienInHoaDon() {

		int row = table.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn đơn hàng cần in hóa đơn!");
			return;
		} else {
			DonHang donHang = listDonHang.get(row);
			if (donHang.getStatus().equals("Đã xác nhận")) {
				FrameHoaDon frameHoaDon = new FrameHoaDon(donHang);
				frameHoaDon.setVisible(true);
				frameHoaDon.thucHienLuu(donHang);
				loadDanhSachDonHang();
			} else {
				JOptionPane.showMessageDialog(this, "Bạn chỉ có thể in hóa đơn ở những đơn hàng đã xác nhận!");
				return;
			}
		}
	}

}

