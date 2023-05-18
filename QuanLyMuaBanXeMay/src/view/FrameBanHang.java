package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;

import connection.ConnectDB;
import dao.BanHangDAO;
import dao.ChiTietHDDAO;
import dao.CustomersDAO;
import dao.DonHangDAO;
import dao.MotoTypeDAO;
import dao.MotobikeDAO;
import dao.Regex;
import dao.StaffDAO;
import entity.ChiTietHoaDon;
import entity.Customer;
import entity.DonHang;
import entity.MotoType;
import entity.Motobike;
import entity.Staff;

import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class FrameBanHang extends JPanel implements ActionListener {
	private DefaultTableModel model;
	private JTable table;
	private DefaultTableModel model_gioHang;
	private JTable table_gioHang;
	private JTextField textField_timKiemSanPham;
	private JTextField textField_maDonHang;
	private JTextField textField_ghiChu;
	private MotobikeDAO daoMoto;
	private MotoTypeDAO daoMotoType;
	private DecimalFormat dfmGia;
	private JButton btn_timKiemSanPham;
	private JButton btn_themSanPham;
	private JButton btn_xoaTatCa;
	private JComboBox<String> comboBox_maKhachHang;
	private JComboBox<String> comboBox_maNhanVien;
	private JButton btn_luuDonHang;
	private JButton btn_xoaSanPham;
	private ArrayList<Motobike> lsXe;
	private BanHangDAO daoBanHang;
	private JTextField textField_tongTien;
	private JDateChooser dateChooser_ngayTaoDonHang;

	public FrameBanHang() {
		setLayout(null);

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == -1;
			}
		};
		model.addColumn("Mã sản phẩm");
		model.addColumn("Tên sản phẩm");
		model.addColumn("Hãng sản xuất");
		model.addColumn("Dung tích");
		model.addColumn("Năm sản xuất");
		model.addColumn("Số lượng tồn");
		model.addColumn("Giá");
		model.addColumn("Loại xe");

		btn_xoaSanPham = new JButton("Xóa sản phẩm");
		btn_xoaSanPham.setForeground(Color.WHITE);
		btn_xoaSanPham.setBackground(Color.RED);
		btn_xoaSanPham.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_xoaSanPham.setBounds(553, 183, 109, 23);
		add(btn_xoaSanPham);

		btn_luuDonHang = new JButton("Lưu đơn hàng");
		btn_luuDonHang.addActionListener(this);
		btn_luuDonHang.setBackground(Color.BLUE);
		btn_luuDonHang.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_luuDonHang.setBounds(623, 218, 109, 23);
		add(btn_luuDonHang);

		JPanel panel_thongTinDonHang = new JPanel();
		panel_thongTinDonHang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin \u0111\u01A1n h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_thongTinDonHang.setBounds(10, 11, 791, 116);
		add(panel_thongTinDonHang);
		panel_thongTinDonHang.setLayout(null);

		JLabel lbl_maDonHang = new JLabel("Mã đơn hàng:");
		lbl_maDonHang.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_maDonHang.setBounds(28, 22, 95, 14);
		panel_thongTinDonHang.add(lbl_maDonHang);

		textField_maDonHang = new JTextField();
		textField_maDonHang.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_maDonHang.setColumns(10);
		textField_maDonHang.setBounds(127, 19, 210, 19);
		panel_thongTinDonHang.add(textField_maDonHang);
		textField_maDonHang.setEditable(false);

		JLabel lbl_maKhachHang = new JLabel("Mã khách hàng:");
		lbl_maKhachHang.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_maKhachHang.setBounds(28, 86, 95, 14);
		panel_thongTinDonHang.add(lbl_maKhachHang);

		comboBox_maKhachHang = new JComboBox<String>();
		comboBox_maKhachHang.setBounds(127, 82, 105, 22);
		panel_thongTinDonHang.add(comboBox_maKhachHang);

		JLabel lbl_ngayTaoDonHang = new JLabel("Ngày tạo:");
		lbl_ngayTaoDonHang.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_ngayTaoDonHang.setBounds(433, 22, 87, 14);
		panel_thongTinDonHang.add(lbl_ngayTaoDonHang);

		JLabel lbl_tongTien = new JLabel("Tổng tiền:");
		lbl_tongTien.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_tongTien.setBounds(433, 54, 54, 14);
		panel_thongTinDonHang.add(lbl_tongTien);

		JLabel lbl_ghiChu = new JLabel("Ghi chú:");
		lbl_ghiChu.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_ghiChu.setBounds(433, 86, 45, 14);
		panel_thongTinDonHang.add(lbl_ghiChu);

		textField_tongTien = new JTextField();
		textField_tongTien.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_tongTien.setBounds(531, 51, 210, 20);
		panel_thongTinDonHang.add(textField_tongTien);
		textField_tongTien.setEditable(false);

		JLabel lbl_maNhanVien = new JLabel("Mã nhân viên:");
		lbl_maNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_maNhanVien.setBounds(28, 54, 95, 14);
		panel_thongTinDonHang.add(lbl_maNhanVien);

		comboBox_maNhanVien = new JComboBox<String>();
		comboBox_maNhanVien.setBounds(127, 50, 105, 22);
		panel_thongTinDonHang.add(comboBox_maNhanVien);

		dateChooser_ngayTaoDonHang = new JDateChooser();
		dateChooser_ngayTaoDonHang.getCalendarButton().setFont(new Font("Arial", Font.PLAIN, 11));
		dateChooser_ngayTaoDonHang.setBounds(530, 19, 211, 20);
		panel_thongTinDonHang.add(dateChooser_ngayTaoDonHang);
		dateChooser_ngayTaoDonHang.setDate(new java.util.Date());
		dateChooser_ngayTaoDonHang.setEnabled(false);

		JLabel lblTongTien = new JLabel("0");
		lblTongTien.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTongTien.setBounds(531, 51, 210, 20);
		panel_thongTinDonHang.add(lblTongTien);

		textField_ghiChu = new JTextField();
		textField_ghiChu.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_ghiChu.setColumns(10);
		textField_ghiChu.setBounds(531, 83, 210, 20);
		panel_thongTinDonHang.add(textField_ghiChu);

		JPanel panel_gioHang = new JPanel();
		panel_gioHang.setLayout(null);
		panel_gioHang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Giỏ hàng",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_gioHang.setBounds(10, 133, 533, 148);
		add(panel_gioHang);

		model_gioHang = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 3;
			}
		};
		table_gioHang = new JTable(model_gioHang);
		model_gioHang.addColumn("Mã sản phẩm");
		model_gioHang.addColumn("Tên sản phẩm");
		model_gioHang.addColumn("Đơn giá");
		model_gioHang.addColumn("Số lượng");

		JScrollPane scrollPane_gioHang = new JScrollPane(table_gioHang);
		scrollPane_gioHang.setBounds(10, 17, 513, 120);
		panel_gioHang.add(scrollPane_gioHang);

		btn_xoaTatCa = new JButton("Xóa tất cả");
		btn_xoaTatCa.setBackground(Color.RED);
		btn_xoaTatCa.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_xoaTatCa.setBounds(676, 183, 109, 23);
		add(btn_xoaTatCa);

		JPanel panel_danhSachSanPham = new JPanel();
		panel_danhSachSanPham.setBorder(
				new TitledBorder(null, "Danh sách sản phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_danhSachSanPham.setBounds(10, 282, 791, 231);
		add(panel_danhSachSanPham);
		panel_danhSachSanPham.setLayout(null);
		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 52, 771, 168);
		panel_danhSachSanPham.add(scrollPane);

		JLabel lbl_timKiemSanPham = new JLabel("Tìm kiếm sản phẩm:");
		lbl_timKiemSanPham.setBounds(66, 25, 107, 14);
		panel_danhSachSanPham.add(lbl_timKiemSanPham);
		lbl_timKiemSanPham.setFont(new Font("Arial", Font.PLAIN, 11));

		textField_timKiemSanPham = new JTextField();
		textField_timKiemSanPham.setBounds(183, 22, 146, 20);
		panel_danhSachSanPham.add(textField_timKiemSanPham);
		textField_timKiemSanPham.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_timKiemSanPham.setColumns(10);
		textField_timKiemSanPham.setText("Tìm theo mã hoặc theo tên xe");

		btn_timKiemSanPham = new JButton("Tìm");
		btn_timKiemSanPham.setForeground(Color.WHITE);
		btn_timKiemSanPham.setBackground(Color.BLUE);
		btn_timKiemSanPham.setBounds(339, 21, 73, 23);
		panel_danhSachSanPham.add(btn_timKiemSanPham);
		btn_timKiemSanPham.setFont(new Font("Arial", Font.PLAIN, 11));

		btn_themSanPham = new JButton("Thêm vào giỏ hàng");
		btn_themSanPham.setBackground(Color.GREEN);
		btn_themSanPham.setBounds(510, 21, 135, 23);
		panel_danhSachSanPham.add(btn_themSanPham);
		btn_themSanPham.setFont(new Font("Arial", Font.PLAIN, 11));

		////////////////////

		daoMoto = new MotobikeDAO();
		daoMotoType = new MotoTypeDAO();
		daoBanHang = new BanHangDAO();
		dfmGia = new DecimalFormat("###,###");
		loadData();

		btn_timKiemSanPham.addActionListener(this);
		btn_themSanPham.addActionListener(this);
		btn_xoaSanPham.addActionListener(this);
		btn_xoaTatCa.addActionListener(this);

	}

	public void loadData() {
		comboBox_maKhachHang.removeAllItems();
		comboBox_maNhanVien.removeAllItems();

		for (Staff staff : StaffDAO.getInstance().selectAll()) {
			comboBox_maNhanVien.addItem(staff.getStaffID());
		}
		for (Customer customer : CustomersDAO.getInstance().selectAll()) {
			comboBox_maKhachHang.addItem(customer.getCustomer_ID());
		}

		loaddsSP();

	}

	public void loaddsSP() {
		model.setRowCount(0);
		lsXe = daoMoto.getDSXe();
		for (Motobike xe : lsXe) {
			MotoType loaixe = daoMotoType.getLoaiXeTheoMa(xe.getType().getTypeId());
			model.addRow(new Object[] { xe.getId(), xe.getName(), xe.getManufacturer(), xe.getCapacity(), xe.getYear(),
					xe.getQuantity(), dfmGia.format(xe.getPrice()), loaixe.getTypeName() });
		}
	}

	// Tìm kiếm xe theo Mã hoặc tên
	private void timKiemXe() throws Exception {
		String input = textField_timKiemSanPham.getText();
		String regexMaXe = "^((MSX|msx)[0-9]+[0-9]*)$";
		if ((textField_timKiemSanPham.getText().length() <= 0)
				|| (textField_timKiemSanPham.getText().equals("Tìm theo mã hoặc theo tên xe"))) {
			model.setRowCount(0);
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiêm (Theo mã hoặc Tên xe)!", "THONG BAO",
					JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			btn_timKiemSanPham.setText("Hủy tìm");
			model.setRowCount(0);
			if (input.matches(regexMaXe)) {
				loadXeTimKiem(daoMoto.get1XeTheoMa(input));
			} else {
				for (Motobike motobike : daoMoto.getDSXe()) {
					if (motobike.getName().trim().equals(input.trim())) {
						loadXeTimKiem(motobike);
					}
				}
			}
			if (model.getRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy xe!", "THONG BAO", JOptionPane.ERROR_MESSAGE);
				textField_timKiemSanPham.requestFocus();
				textField_timKiemSanPham.selectAll();
			}

		}
	}

	public void loadXeTimKiem(Motobike xe) {
		MotoType loaixe = daoMotoType.getLoaiXeTheoMa(xe.getType().getTypeId());
		model.addRow(new Object[] { xe.getId(), xe.getName(), xe.getManufacturer(), xe.getCapacity(), xe.getYear(),
				xe.getQuantity(), dfmGia.format(xe.getPrice()), loaixe.getTypeName() });

	}

	public void xoaGioHang() {
		int row = table_gioHang.getSelectedRow();
		if (row >= 0) {
			int choose = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa sản phẩm này?", "THONG BAO",
					JOptionPane.YES_NO_OPTION);
			if (choose == JOptionPane.YES_OPTION) {
				String ma = model_gioHang.getValueAt(row, 0).toString();
				model_gioHang.removeRow(row);
				updateTongTien();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm trong giỏ hàng để xóa.");
		}
	}

	private void updateTongTien() {
		double tongTien = 0;
		for (int i = 0; i < model_gioHang.getRowCount(); i++) {
			String maSP = model_gioHang.getValueAt(i, 0).toString();
			Motobike xe = daoMoto.get1XeTheoMa(maSP);
			double giaSP = xe.getPrice();
			int soLuong = Integer.parseInt(model_gioHang.getValueAt(i, 3).toString());
			tongTien += giaSP * soLuong;
		}
		textField_tongTien.setText(dfmGia.format(tongTien));
	}

	public void loadVaoGioHang() throws Exception {
		String quantity = JOptionPane.showInputDialog("Nhập số lượng");
		// Lấy thông tin sản phẩm được chọn từ bảng sản phẩm
		int selectedRow = table.getSelectedRow();
		if (selectedRow >= 0) {
			if (quantity != null && !quantity.equals("")) {
				if (!quantity.matches("^[0-9]+$")) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên dương!");
					return;
				} 
				String maSP = table.getValueAt(selectedRow, 0).toString();
				String tenSP = table.getValueAt(selectedRow, 1).toString();
				Motobike xe = daoMoto.get1XeTheoMa(maSP);
				double giaSP = xe.getPrice();
				if (Integer.valueOf(quantity) > Integer.valueOf(table.getValueAt(selectedRow, 5) + "")) {
					JOptionPane.showMessageDialog(this, "Vượt quá số lượng của cửa hàng!");
					return;
				}
				int soLuong = Integer.valueOf(quantity);

				// Kiểm tra sản phẩm đã tồn tại trong giỏ hàng chưa
				int gioHangRow = -1;
				for (int i = 0; i < table_gioHang.getRowCount(); i++) {
					if (table_gioHang.getValueAt(i, 0).toString().equals(maSP)) {
						gioHangRow = i;
						break;
					}
				}

				if (gioHangRow == -1) { // Nếu sản phẩm chưa tồn tại trong giỏ hàng
					Object[] row = { maSP, tenSP, dfmGia.format(giaSP), soLuong };
					model_gioHang.addRow(row);
				} else { // Nếu sản phẩm đã tồn tại trong giỏ hàng
					int oldSoLuong = Integer.parseInt(table_gioHang.getValueAt(gioHangRow, 3).toString());
					int newSoLuong = oldSoLuong + soLuong;
					if (newSoLuong > Integer.valueOf(table.getValueAt(selectedRow, 5) + "")) {
						JOptionPane.showMessageDialog(this, "Vượt quá số lượng của cửa hàng!");
						return;
					}
					table_gioHang.setValueAt(newSoLuong, gioHangRow, 3);
				}
				updateTongTien();
			}

		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để thêm vào giỏ hàng.");
		}
	}

	private DonHang createDonHang() throws Exception {
		String maDonHang = daoBanHang.getMaHD();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayTao = Date.valueOf(sf.format(dateChooser_ngayTaoDonHang.getDate()));
		String customer_id = comboBox_maKhachHang.getSelectedItem() + "";
		String staff_id = comboBox_maNhanVien.getSelectedItem() + "";
		ArrayList<Motobike> dssp = new ArrayList<Motobike>();
		double tongTien = 0;
		String status = "Chờ xử lý";
		String note = "";

		// Lặp qua từng dòng sản phẩm và tính tổng tiền
		for (int i = 0; i < model_gioHang.getRowCount(); i++) {
			String maSP = model_gioHang.getValueAt(i, 0) + "";
			Motobike motobike = daoMoto.get1XeTheoMa(maSP);
			motobike.setQuantity(Integer.valueOf(table_gioHang.getValueAt(i, 3) + ""));
			tongTien += motobike.getPrice() * Integer.valueOf(model_gioHang.getValueAt(i, 3) + "");
			dssp.add(motobike);
		}
		DonHang donHang = new DonHang(maDonHang, ngayTao, customer_id, staff_id, dssp, tongTien, status, note);
		return donHang;
	}

	private void luuDonHang() throws Exception {
		if (model_gioHang.getRowCount() < 1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm");
			return;
		} else if (comboBox_maNhanVien.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên tạo đơn hàng!");
			return;
		} else if (comboBox_maKhachHang.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng!");
			return;
		}
		for (int i = 0; i < table_gioHang.getRowCount(); i++) {
			if (Integer.valueOf(table_gioHang.getValueAt(i, 3) + "") > daoMoto.get1XeTheoMa(table.getValueAt(i, 0) + "")
					.getQuantity()) {
				JOptionPane.showMessageDialog(this, "Sản phẩm mua vượt quá số lượng của cửa hàng!");
				table_gioHang.setRowSelectionInterval(i, i);
				return;
			}
		}

		DonHang donHang = createDonHang();
		DonHangDAO.getInstance().insert(donHang);
		for (int i = 0; i < table_gioHang.getRowCount(); i++) {
			Motobike motobike = daoMoto.get1XeTheoMa(table_gioHang.getValueAt(i, 0) + "");
			motobike.setQuantity(motobike.getQuantity() - Integer.valueOf(table_gioHang.getValueAt(i, 3) + ""));
			daoMoto.capNhatXe(motobike);
		}
		loaddsSP();
		JOptionPane.showMessageDialog(this, "Tạo đơn hàng thành công.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btn_timKiemSanPham) && btn_timKiemSanPham.getText().equals("Tìm")) {
			try {
				timKiemXe();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (o.equals(btn_timKiemSanPham) && btn_timKiemSanPham.getText().equals("Hủy tìm")) {
			btn_timKiemSanPham.setText("Tìm");
			try {
				loaddsSP();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (o.equals(btn_themSanPham)) {
			try {
				loadVaoGioHang();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (o.equals(btn_xoaSanPham)) {
			xoaGioHang();
		} else if (o.equals(btn_xoaTatCa)) {
			model_gioHang.setRowCount(0);
		} else if (o.equals(btn_luuDonHang)) {
			try {
				luuDonHang();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

}

