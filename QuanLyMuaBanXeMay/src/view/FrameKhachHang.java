package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.CustomersDAO;
import dao.StaffDAO;
import entity.Customer;
import entity.Staff;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class FrameKhachHang extends JPanel {
	private ArrayList<Customer> listCustomer;
	private JTextField textField_maKhachHang;
	private JTextField textField_tenKhachHang;
	private JTextField textField_diaChi;
	private JTextField textField_soDienThoai;
	private JTextField textField_timKiemKhachHang;

	private DefaultTableModel modelKhachHang;
	private JTable tableKhachHang;
	private JButton btn_timKhachHang;
	private JButton btn_themKhachHang;
	private JButton btn_xoaKhachHang;
	private JButton btn_capNhat;
	private JButton btn_lamMoi;
	private JDateChooser dateChooser_ngaySinh;
	private JComboBox comboBox_gioiTinh;

	public FrameKhachHang() {
		setLayout(null);

		JPanel panel_khachHang = new JPanel();
		panel_khachHang.setBounds(10, 11, 795, 177);
		add(panel_khachHang);
		panel_khachHang.setLayout(null);
		panel_khachHang.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));

		JLabel lbl_maKhachHang = new JLabel("Mã khách hàng:");
		lbl_maKhachHang.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_maKhachHang.setBounds(10, 32, 81, 13);
		panel_khachHang.add(lbl_maKhachHang);

		textField_maKhachHang = new JTextField();
		textField_maKhachHang.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_maKhachHang.setColumns(10);
		textField_maKhachHang.setBounds(96, 28, 280, 20);
		panel_khachHang.add(textField_maKhachHang);

		JLabel lbl_tenKhachHang = new JLabel("Tên khách hàng:");
		lbl_tenKhachHang.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_tenKhachHang.setBounds(10, 62, 81, 13);
		panel_khachHang.add(lbl_tenKhachHang);

		textField_tenKhachHang = new JTextField();
		textField_tenKhachHang.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_tenKhachHang.setColumns(10);
		textField_tenKhachHang.setBounds(96, 58, 280, 20);
		panel_khachHang.add(textField_tenKhachHang);

		JLabel lbl_diaChi = new JLabel("Địa chỉ:");
		lbl_diaChi.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_diaChi.setBounds(10, 89, 81, 14);
		panel_khachHang.add(lbl_diaChi);

		textField_diaChi = new JTextField();
		textField_diaChi.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_diaChi.setColumns(10);
		textField_diaChi.setBounds(96, 86, 280, 20);
		panel_khachHang.add(textField_diaChi);

		JLabel lbl_soDienThoai = new JLabel("Số điện thoại:");
		lbl_soDienThoai.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_soDienThoai.setBounds(10, 119, 81, 14);
		panel_khachHang.add(lbl_soDienThoai);

		textField_soDienThoai = new JTextField();
		textField_soDienThoai.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_soDienThoai.setColumns(10);
		textField_soDienThoai.setBounds(96, 116, 280, 20);
		panel_khachHang.add(textField_soDienThoai);

		JLabel lbl_gioiTinh = new JLabel("Giới tính");
		lbl_gioiTinh.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_gioiTinh.setBounds(419, 31, 76, 14);
		panel_khachHang.add(lbl_gioiTinh);

		JLabel lbl_ngaySinh = new JLabel("Ng\u00E0y sinh:");
		lbl_ngaySinh.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_ngaySinh.setBounds(419, 61, 76, 14);
		panel_khachHang.add(lbl_ngaySinh);

		comboBox_gioiTinh = new JComboBox();
		comboBox_gioiTinh.setBounds(505, 27, 70, 22);
		panel_khachHang.add(comboBox_gioiTinh);
		comboBox_gioiTinh.addItem("");
		comboBox_gioiTinh.addItem("Nam");
		comboBox_gioiTinh.addItem("Nữ");

		dateChooser_ngaySinh = new JDateChooser();
		dateChooser_ngaySinh.setBounds(505, 58, 263, 20);
		panel_khachHang.add(dateChooser_ngaySinh);

		JPanel panel_table = new JPanel();
		panel_table.setBounds(10, 219, 795, 234);
		add(panel_table);
		panel_table.setLayout(new BorderLayout(0, 0));
		panel_table.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));

		modelKhachHang = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == -1;
			}
		};
		tableKhachHang = new JTable(modelKhachHang);
		tableKhachHang.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				thucHienMouseClick();
			}
		});
		modelKhachHang.addColumn("Mã khách hàng");
		modelKhachHang.addColumn("Tên khách hàng");
		modelKhachHang.addColumn("Giới tính");
		modelKhachHang.addColumn("Địa chỉ");
		modelKhachHang.addColumn("Ngày sinh");
		modelKhachHang.addColumn("Số điện thoại");
		JScrollPane scrollPane = new JScrollPane(tableKhachHang);
		panel_table.add(scrollPane, BorderLayout.CENTER);

		JLabel lbl_timKiemKhachHang = new JLabel("Tìm kiếm khách hàng:");
		lbl_timKiemKhachHang.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_timKiemKhachHang.setBounds(31, 477, 120, 14);
		add(lbl_timKiemKhachHang);

		textField_timKiemKhachHang = new JTextField();
		textField_timKiemKhachHang.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_timKiemKhachHang.setColumns(10);
		textField_timKiemKhachHang.setBounds(157, 474, 146, 20);
		textField_timKiemKhachHang.setText("Tìm theo mã hoặc theo tên");
		add(textField_timKiemKhachHang);

		btn_timKhachHang = new JButton("Tìm");
		btn_timKhachHang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thucHienTim();
			}
		});
		btn_timKhachHang.setForeground(Color.WHITE);
		btn_timKhachHang.setBackground(Color.BLUE);
		btn_timKhachHang.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_timKhachHang.setBounds(313, 473, 66, 23);
		add(btn_timKhachHang);

		btn_themKhachHang = new JButton("Thêm");
		btn_themKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienThem();
			}
		});
		btn_themKhachHang.setBackground(Color.GREEN);
		btn_themKhachHang.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_themKhachHang.setBounds(420, 473, 81, 23);
		add(btn_themKhachHang);

		btn_xoaKhachHang = new JButton("Xóa");
		btn_xoaKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienXoa();
			}
		});
		btn_xoaKhachHang.setBackground(Color.RED);
		btn_xoaKhachHang.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_xoaKhachHang.setBounds(511, 473, 81, 23);
		add(btn_xoaKhachHang);

		btn_capNhat = new JButton("Cập Nhật");
		btn_capNhat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thucHienCapNhat();
			}
		});
		btn_capNhat.setBackground(Color.YELLOW);
		btn_capNhat.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_capNhat.setBounds(602, 473, 81, 23);
		add(btn_capNhat);

		btn_lamMoi = new JButton("Làm mới");
		btn_lamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thucHienLamMoi();
			}
		});
		btn_lamMoi.setBackground(Color.BLUE);
		btn_lamMoi.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_lamMoi.setBounds(692, 473, 79, 23);
		add(btn_lamMoi);
	}

	public DefaultTableModel getModelKhachHang() {
		return modelKhachHang;
	}

	public void setModelKhachHang(DefaultTableModel modelKhachHang) {
		this.modelKhachHang = modelKhachHang;
	}

	public JTable getTableKhachHang() {
		return tableKhachHang;
	}

	public void setTableKhachHang(JTable tableKhachHang) {
		this.tableKhachHang = tableKhachHang;
	}

	public JButton getBtn_timKhachHang() {
		return btn_timKhachHang;
	}

	public void setBtn_timKhachHang(JButton btn_timKhachHang) {
		this.btn_timKhachHang = btn_timKhachHang;
	}

	public JButton getBtn_themKhachHang() {
		return btn_themKhachHang;
	}

	public void setBtn_themKhachHang(JButton btn_themKhachHang) {
		this.btn_themKhachHang = btn_themKhachHang;
	}

	public JButton getBtn_xoaKhachHang() {
		return btn_xoaKhachHang;
	}

	public void setBtn_xoaKhachHang(JButton btn_xoaKhachHang) {
		this.btn_xoaKhachHang = btn_xoaKhachHang;
	}

	public JButton getBtn_capNhat() {
		return btn_capNhat;
	}

	public void setBtn_capNhat(JButton btn_capNhat) {
		this.btn_capNhat = btn_capNhat;
	}

	public JButton getBtn_lamMoi() {
		return btn_lamMoi;
	}

	public void setBtn_lamMoi(JButton btn_lamMoi) {
		this.btn_lamMoi = btn_lamMoi;
	}

	public void loadData() {
		listCustomer = CustomersDAO.getInstance().selectAll();
		for (Customer customer : listCustomer) {
			addRowTable(customer);
		}

	}

	public void thucHienMouseClick() {
		int row = tableKhachHang.getSelectedRow();
		Customer customer = listCustomer.get(row);

		textField_maKhachHang.setText(customer.getCustomer_ID());
		textField_tenKhachHang.setText(customer.getCustomer_Name());
		textField_diaChi.setText(customer.getCustomer_Address());
		textField_soDienThoai.setText(customer.getCustomer_Phone());
		comboBox_gioiTinh.setSelectedItem((customer.isCustomer_Gender()) ? "Nam" : "Nữ");
		dateChooser_ngaySinh.setDate(customer.getCustomer_DateOfBirth());

	}

	private boolean kiemTraTrungMa() {
		for (Customer customer : listCustomer) {
			if (customer.getCustomer_ID().equals(textField_maKhachHang.getText())) {
				return false;
			}
		}
		return true;
	}

	private boolean checkRegularExpresstion() {
		if (!textField_maKhachHang.getText().matches("^KH[0-9]{3}$")) {
			JOptionPane.showMessageDialog(this, "Mã khách hàng phải có định dạng: KHXXX với XXX là các số nguyên! ");
			return false;
		} else if (!textField_tenKhachHang.getText().matches("^[A-Za-zÀ-ỹ\' ]+$")) {
			JOptionPane.showMessageDialog(this, "Tên khách hàng phải là chữ!");
			return false;
		} else if (!textField_diaChi.getText().matches("^[A-Za-zÀ-ỹ\' 0-9-]+$")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được chứa ký tự đặc biệt!");
			return false;
		} else if (!textField_soDienThoai.getText().matches("^0[0-9]{9}$")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải có 10 số và bắt đầu bằng số 0!");
			return false;
		} else if (Period
				.between(dateChooser_ngaySinh.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
						LocalDate.now())
				.getYears() < 18) {
			JOptionPane.showMessageDialog(this, "Tuổi phải lớn hơn hoặc bằng 18!");
			return false;
		}
		return true;
	}

	private void addDataToTable() {
		modelKhachHang.setRowCount(0);
		for (Customer customer : listCustomer) {
			addRowTable(customer);
		}
	}

	public void thucHienThem() {
		if (textField_maKhachHang.getText().equals("") || textField_tenKhachHang.getText().equals("")
				|| textField_diaChi.getText().equals("") || textField_soDienThoai.getText().equals("")
				|| comboBox_gioiTinh.getSelectedItem().equals("") || dateChooser_ngaySinh.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
			return;
		} else if (!kiemTraTrungMa()) {
			JOptionPane.showMessageDialog(this, "Mã nhân viên không được trùng!");
			return;
		} else {
			if (checkRegularExpresstion()) {
				String maKhachHang = textField_maKhachHang.getText();
				String tenKhachHang = textField_tenKhachHang.getText();
				boolean gioiTinh = (comboBox_gioiTinh.getSelectedItem().equals("Nam"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date ngaySinh = Date.valueOf(sdf.format(dateChooser_ngaySinh.getDate()));
				String sdt = textField_soDienThoai.getText();
				String diaChi = textField_diaChi.getText();

				Customer customer = new Customer(maKhachHang, tenKhachHang, gioiTinh, ngaySinh, sdt, diaChi);
				listCustomer.add(customer);
				CustomersDAO.getInstance().insert(customer);
				addDataToTable();
				JOptionPane.showMessageDialog(this, "Đã thêm thành công");
			}
		}
	}

	private void thucHienXoa() {
		int row = tableKhachHang.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
			return;
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa dòng này không") == JOptionPane.YES_OPTION) {
				Customer customer = null;
				for (Customer ct : listCustomer) {
					if (ct.getCustomer_ID().equals(modelKhachHang.getValueAt(row, 0))) {
						customer = ct;
					}
				}
				listCustomer.remove(customer);
				CustomersDAO.getInstance().delete(customer);
				addDataToTable();
				thucHienLamMoi();
				JOptionPane.showMessageDialog(this, "Đã xóa thành công");
			}
		}
	}

	public void thucHienCapNhat() {
		int row = tableKhachHang.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần cập nhật!");
			return;
		} else {
			if (JOptionPane.showConfirmDialog(this,
					"Bạn có chắc chắn muốn cập nhật dòng này không!") == JOptionPane.YES_OPTION) {
				String maKhachHang = textField_maKhachHang.getText();
				String tenKhachHang = textField_tenKhachHang.getText();
				boolean gioiTinh = (comboBox_gioiTinh.getSelectedItem().equals("Nam"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date ngaySinh = Date.valueOf(sdf.format(dateChooser_ngaySinh.getDate()));
				String sdt = textField_soDienThoai.getText();
				String diaChi = textField_diaChi.getText();

				Customer customer = new Customer(maKhachHang, tenKhachHang, gioiTinh, ngaySinh, sdt, diaChi);

				listCustomer.set(row, customer);
				addDataToTable();
				CustomersDAO.getInstance().update(customer);
				JOptionPane.showMessageDialog(this, "Bạn đã cập nhật thành công!");
			}
		}
	}

	public void thucHienLamMoi() {
		textField_maKhachHang.setText("");
		textField_tenKhachHang.setText("");
		comboBox_gioiTinh.setSelectedItem("");
		dateChooser_ngaySinh.setDate(null);
		textField_soDienThoai.setText("");
		textField_diaChi.setText("");

		addDataToTable();
	}

	private void thucHienTim() {
		if (textField_timKiemKhachHang.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hoặc tên cần tìm!");
			return;
		} else {
			int ketQua = 0;
			String timKiem = textField_timKiemKhachHang.getText();
			modelKhachHang.setRowCount(0);
			for (Customer customer : listCustomer) {
				if (customer.getCustomer_ID().equals(timKiem) || customer.getCustomer_Name().equals(timKiem)) {
					addRowTable(customer);
					ketQua++;
				}
			}
			if (ketQua == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
				addDataToTable();
			}
		}
	}

	private void addRowTable(Customer customer) {
		String data[] = { customer.getCustomer_ID(), customer.getCustomer_Name(),
				(customer.isCustomer_Gender()) ? "Nam" : "Nữ", customer.getCustomer_DateOfBirth() + "",
				customer.getCustomer_Phone(), customer.getCustomer_Address() };
		modelKhachHang.addRow(data);
	}
}
