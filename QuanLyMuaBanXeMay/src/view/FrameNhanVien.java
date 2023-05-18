package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import dao.StaffDAO;
import entity.Staff;

import java.awt.Color;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameNhanVien extends JPanel {
	private ArrayList<Staff> listStaff;
	private JTextField textField_maNhanVien;
	private JTextField textField_tenNhanVien;
	private JTextField textField_diaChiNhanVien;
	private JTextField textField_soDienThoaiNhanVien;
	private JTextField textField_emailNhanVien;
	private JTextField textField_luong;
	private JTextField textField_ghiChu;
	private DefaultTableModel model_nhanVien;
	private JTable table_nhanVien;
	private JTextField textField_timKiemNhanVien;
	private JComboBox comboBox_gioiTinhNhanVien;
	private JDateChooser dateChooser_ngaySinh;
	private JComboBox comboBox_chucVu;
	private JButton btn_timKiemNhanVien;
	private JButton btn_xoaNhanVien;
	private JButton btn_capNhatNhanVien;
	private JButton btn_lamMoi;
	private JButton btn_themNhanVien;

	/**
	 * Create the panel.
	 */
	public FrameNhanVien() {
		setLayout(null);

		JPanel panel_ThongTinNhanVien = new JPanel();
		panel_ThongTinNhanVien.setBounds(10, 11, 791, 171);
		add(panel_ThongTinNhanVien);
		panel_ThongTinNhanVien.setLayout(null);
		panel_ThongTinNhanVien.setBorder(BorderFactory.createTitledBorder("Thông tin nhân viên"));

		JLabel lbl_maNhanVien = new JLabel("Mã nhân viên:");
		lbl_maNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_maNhanVien.setBounds(10, 22, 81, 13);
		panel_ThongTinNhanVien.add(lbl_maNhanVien);

		textField_maNhanVien = new JTextField();
		textField_maNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_maNhanVien.setColumns(10);
		textField_maNhanVien.setBounds(96, 18, 280, 20);
		panel_ThongTinNhanVien.add(textField_maNhanVien);

		JLabel lbl_tenNhanVien = new JLabel("Tên nhân viên:");
		lbl_tenNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_tenNhanVien.setBounds(10, 52, 81, 13);
		panel_ThongTinNhanVien.add(lbl_tenNhanVien);

		textField_tenNhanVien = new JTextField();
		textField_tenNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_tenNhanVien.setColumns(10);
		textField_tenNhanVien.setBounds(96, 48, 280, 20);
		panel_ThongTinNhanVien.add(textField_tenNhanVien);

		JLabel lbl_diaChiNhanVien = new JLabel("Địa chỉ:");
		lbl_diaChiNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_diaChiNhanVien.setBounds(10, 82, 81, 14);
		panel_ThongTinNhanVien.add(lbl_diaChiNhanVien);

		textField_diaChiNhanVien = new JTextField();
		textField_diaChiNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_diaChiNhanVien.setColumns(10);
		textField_diaChiNhanVien.setBounds(96, 79, 280, 20);
		panel_ThongTinNhanVien.add(textField_diaChiNhanVien);

		JLabel lbl_soDienThoaiNhanVien = new JLabel("Số điện thoại:");
		lbl_soDienThoaiNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_soDienThoaiNhanVien.setBounds(10, 113, 81, 14);
		panel_ThongTinNhanVien.add(lbl_soDienThoaiNhanVien);

		textField_soDienThoaiNhanVien = new JTextField();
		textField_soDienThoaiNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_soDienThoaiNhanVien.setColumns(10);
		textField_soDienThoaiNhanVien.setBounds(96, 110, 280, 20);
		panel_ThongTinNhanVien.add(textField_soDienThoaiNhanVien);

		JLabel lbl_gioiTinhNhanVien = new JLabel("Giới tính");
		lbl_gioiTinhNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_gioiTinhNhanVien.setBounds(419, 21, 76, 14);
		panel_ThongTinNhanVien.add(lbl_gioiTinhNhanVien);

		comboBox_gioiTinhNhanVien = new JComboBox();
		comboBox_gioiTinhNhanVien.setFont(new Font("Dialog", Font.BOLD, 12));
		comboBox_gioiTinhNhanVien.setBounds(495, 17, 111, 22);
		comboBox_gioiTinhNhanVien.addItem("");
		comboBox_gioiTinhNhanVien.addItem("Nam");
		comboBox_gioiTinhNhanVien.addItem("Nữ");
		panel_ThongTinNhanVien.add(comboBox_gioiTinhNhanVien);

		JLabel lbl_ngaySinhNhanVien = new JLabel("Ngày sinh:");
		lbl_ngaySinhNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_ngaySinhNhanVien.setBounds(419, 51, 76, 14);
		panel_ThongTinNhanVien.add(lbl_ngaySinhNhanVien);

		JLabel lbl_emailNhanVien = new JLabel("Email:");
		lbl_emailNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_emailNhanVien.setBounds(419, 82, 76, 14);
		panel_ThongTinNhanVien.add(lbl_emailNhanVien);

		textField_emailNhanVien = new JTextField();
		textField_emailNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_emailNhanVien.setColumns(10);
		textField_emailNhanVien.setBounds(495, 79, 280, 20);
		panel_ThongTinNhanVien.add(textField_emailNhanVien);

		JLabel lbl_chucVu = new JLabel("Chức vụ:");
		lbl_chucVu.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_chucVu.setBounds(419, 113, 76, 14);
		panel_ThongTinNhanVien.add(lbl_chucVu);

		JLabel lbl_luong = new JLabel("Lương:");
		lbl_luong.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_luong.setBounds(10, 144, 81, 14);
		panel_ThongTinNhanVien.add(lbl_luong);

		textField_luong = new JTextField();
		textField_luong.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_luong.setColumns(10);
		textField_luong.setBounds(96, 141, 280, 20);
		panel_ThongTinNhanVien.add(textField_luong);

		JLabel lbl_ghiChu = new JLabel("Ghi chú");
		lbl_ghiChu.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_ghiChu.setBounds(419, 144, 76, 14);
		panel_ThongTinNhanVien.add(lbl_ghiChu);

		textField_ghiChu = new JTextField();
		textField_ghiChu.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_ghiChu.setColumns(10);
		textField_ghiChu.setBounds(495, 141, 280, 20);
		panel_ThongTinNhanVien.add(textField_ghiChu);

		dateChooser_ngaySinh = new JDateChooser();
		dateChooser_ngaySinh.setBounds(495, 48, 280, 20);
		panel_ThongTinNhanVien.add(dateChooser_ngaySinh);

		comboBox_chucVu = new JComboBox();
		comboBox_chucVu.setFont(new Font("Dialog", Font.BOLD, 12));
		comboBox_chucVu.addItem("");
		comboBox_chucVu.addItem("Chủ tịch");
		comboBox_chucVu.addItem("Giám đốc");
		comboBox_chucVu.addItem("Phó Giám đốc");
		comboBox_chucVu.addItem("Quản lý");
		comboBox_chucVu.addItem("Nhân viên");
		comboBox_chucVu.setBounds(495, 109, 111, 22);
		panel_ThongTinNhanVien.add(comboBox_chucVu);

		JPanel panel_tableNhanVien = new JPanel();
		panel_tableNhanVien.setBounds(10, 201, 791, 251);
		add(panel_tableNhanVien);
		panel_tableNhanVien.setLayout(new BorderLayout());
		panel_tableNhanVien.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));

		model_nhanVien = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == -1;
			}
		};
		table_nhanVien = new JTable(model_nhanVien);
		table_nhanVien.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				thucHienMouseClick();
			}
		});
		model_nhanVien.addColumn("Mã nhân viên");
		model_nhanVien.addColumn("Họ tên");
		model_nhanVien.addColumn("Giới tính");
		model_nhanVien.addColumn("Ngày sinh");
		model_nhanVien.addColumn("Địa chỉ ");
		model_nhanVien.addColumn("Email");
		model_nhanVien.addColumn("SĐT");
		model_nhanVien.addColumn("Chức vụ");
		model_nhanVien.addColumn("Lương");
		model_nhanVien.addColumn("Ghi chú");

		JScrollPane scrollPane = new JScrollPane(table_nhanVien);
		panel_tableNhanVien.add(scrollPane, BorderLayout.CENTER);

		JLabel lbl_timKiemNhanVien = new JLabel("Tìm kiếm nhân viên:");
		lbl_timKiemNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_timKiemNhanVien.setBounds(39, 477, 101, 14);
		add(lbl_timKiemNhanVien);

		textField_timKiemNhanVien = new JTextField();
		textField_timKiemNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_timKiemNhanVien.setColumns(10);
		textField_timKiemNhanVien.setBounds(147, 474, 146, 20);
		textField_timKiemNhanVien.setText("Tìm theo mã hoặc theo tên");
		add(textField_timKiemNhanVien);

		btn_timKiemNhanVien = new JButton("Tìm");
		btn_timKiemNhanVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thucHienTim();
			}
		});
		btn_timKiemNhanVien.setForeground(Color.WHITE);
		btn_timKiemNhanVien.setBackground(Color.BLUE);
		btn_timKiemNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_timKiemNhanVien.setBounds(313, 473, 66, 23);
		add(btn_timKiemNhanVien);

		btn_themNhanVien = new JButton("Thêm");
		btn_themNhanVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thucHienThem();
			}
		});

		btn_themNhanVien.setBackground(Color.GREEN);
		btn_themNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_themNhanVien.setBounds(425, 473, 81, 23);
		add(btn_themNhanVien);

		btn_xoaNhanVien = new JButton("Xóa");
		btn_xoaNhanVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thucHienXoa();
			}
		});
		btn_xoaNhanVien.setBackground(Color.RED);
		btn_xoaNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_xoaNhanVien.setBounds(516, 473, 81, 23);
		add(btn_xoaNhanVien);

		btn_capNhatNhanVien = new JButton("Cập Nhật");
		btn_capNhatNhanVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thucHienCapNhat();
			}
		});
		btn_capNhatNhanVien.setBackground(Color.YELLOW);
		btn_capNhatNhanVien.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_capNhatNhanVien.setBounds(607, 473, 81, 23);
		add(btn_capNhatNhanVien);

		btn_lamMoi = new JButton("Làm mới");
		btn_lamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thucHienLamMoi();
			}
		});
		btn_lamMoi.setBackground(Color.BLUE);
		btn_lamMoi.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_lamMoi.setBounds(697, 473, 83, 23);
		add(btn_lamMoi);

	}

	NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

	public DefaultTableModel getModel_nhanVien() {
		return model_nhanVien;
	}

	public void setModel_nhanVien(DefaultTableModel model_nhanVien) {
		this.model_nhanVien = model_nhanVien;
	}

	public JTable getTable_nhanVien() {
		return table_nhanVien;
	}

	public void setTable_nhanVien(JTable table_nhanVien) {
		this.table_nhanVien = table_nhanVien;
	}

	public JButton getBtn_timKiemNhanVien() {
		return btn_timKiemNhanVien;
	}

	public void setBtn_timKiemNhanVien(JButton btn_timKiemNhanVien) {
		this.btn_timKiemNhanVien = btn_timKiemNhanVien;
	}

	public JButton getBtn_xoaNhanVien() {
		return btn_xoaNhanVien;
	}

	public void setBtn_xoaNhanVien(JButton btn_xoaNhanVien) {
		this.btn_xoaNhanVien = btn_xoaNhanVien;
	}

	public JButton getBtn_capNhatNhanVien() {
		return btn_capNhatNhanVien;
	}

	public void setBtn_capNhatNhanVien(JButton btn_capNhatNhanVien) {
		this.btn_capNhatNhanVien = btn_capNhatNhanVien;
	}

	public JButton getBtn_lamMoi() {
		return btn_lamMoi;
	}

	public void setBtn_lamMoi(JButton btn_lamMoi) {
		this.btn_lamMoi = btn_lamMoi;
	}

	public JButton getBtn_themNhanVien() {
		return btn_themNhanVien;
	}

	public void setBtn_themNhanVien(JButton btn_themNhanVien) {
		this.btn_themNhanVien = btn_themNhanVien;
	}

	public void loadData() {
		listStaff = StaffDAO.getInstance().selectAll();
		for (Staff staff : listStaff) {
			addRowTable(staff);
		}
	}

	public void thucHienMouseClick() {
		DecimalFormat df = new DecimalFormat("#");
		int row = table_nhanVien.getSelectedRow();
		Staff staff = listStaff.get(row);

		textField_maNhanVien.setText(staff.getStaffID());
		textField_tenNhanVien.setText(staff.getStaffName());
		comboBox_gioiTinhNhanVien.setSelectedItem((staff.isGender() ? "Nam" : "Nữ"));
		dateChooser_ngaySinh.setDate(staff.getDateOfBirth());
		textField_diaChiNhanVien.setText(staff.getAddress());
		textField_emailNhanVien.setText(staff.getEmail());
		textField_soDienThoaiNhanVien.setText(staff.getPhone());
		comboBox_chucVu.setSelectedItem(staff.getPosition());
		textField_luong.setText(df.format(staff.getSalary()));
		textField_ghiChu.setText(staff.getNote());
	}

	private boolean checkRegularExpresstion() {
		if (!textField_maNhanVien.getText().matches("^NV[0-9]{3}$")) {
			JOptionPane.showMessageDialog(this, "Mã nhân viên phải có định dạng: NVXXX với XXX là các số nguyên! ");
			return false;
		} else if (!textField_tenNhanVien.getText().matches("^[A-Za-zÀ-ỹ\' ]+$")) {
			JOptionPane.showMessageDialog(this, "Tên nhân viên phải là chữ!");
			return false;
		} else if (!textField_diaChiNhanVien.getText().matches("^[A-Za-zÀ-ỹ\' 0-9-]+$")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được chứa ký tự đặc biệt!");
			return false;
		} else if (!textField_soDienThoaiNhanVien.getText().matches("^0[0-9]{9}$")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải có 10 số và bắt đầu bằng số 0!");
			return false;
		} else if (!textField_luong.getText().matches("^[0-9]+$")
				|| Double.valueOf(textField_luong.getText() + "") < 0) {
			JOptionPane.showMessageDialog(this, "Lương phải là số và là số nguyên không âm!");
			return false;
		} else if (Period
				.between(dateChooser_ngaySinh.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
						LocalDate.now())
				.getYears() < 18) {
			JOptionPane.showMessageDialog(this, "Tuổi phải lớn hơn hoặc bằng 18!");
			return false;
		} else if (!textField_emailNhanVien.getText()
				.matches("^[a-z][a-z0-9.]+@(gmail||yahoo||iuh||google)(.[a-z]+){0,3}$")
				|| Double.valueOf(textField_luong.getText() + "") < 0) {
			JOptionPane.showMessageDialog(this,
					"Email phải theo định dạng tenemail@tenmien và phải bắt đầu bằng ký tự chữ!");
			return false;
		}
		return true;
	}

	public void addDataToTable() {
		model_nhanVien.setRowCount(0);
		for (Staff staff : listStaff) {
			addRowTable(staff);
		}
	}

	private boolean kiemTraTrungMa() {
		for (Staff staff : listStaff) {
			if (staff.getStaffID().equals(textField_maNhanVien.getText())) {
				return false;
			}
		}
		return true;
	}

	public void thucHienThem() {
		if (textField_maNhanVien.getText().equals("") || textField_tenNhanVien.getText().equals("")
				|| (comboBox_gioiTinhNhanVien.getSelectedItem() + "").equals("")
				|| dateChooser_ngaySinh.getDate() == null || textField_diaChiNhanVien.getText().equals("")
				|| textField_emailNhanVien.getText().equals("") || textField_soDienThoaiNhanVien.getText().equals("")
				|| comboBox_chucVu.getSelectedItem().equals("") || textField_luong.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
			return;
		} else if (!kiemTraTrungMa()) {
			JOptionPane.showMessageDialog(this, "Mã nhân viên không được trùng!");
			return;
		} else {
			if (checkRegularExpresstion()) {
				String maNhanVien = textField_maNhanVien.getText();
				String tenNhanVien = textField_tenNhanVien.getText();
				boolean gioiTinh = (comboBox_gioiTinhNhanVien.getSelectedItem().equals("Nam"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date ngaySinh = Date.valueOf(sdf.format(dateChooser_ngaySinh.getDate()));
				String diaChi = textField_diaChiNhanVien.getText();
				String email = textField_emailNhanVien.getText();
				String sdt = textField_soDienThoaiNhanVien.getText();
				String chucVu = comboBox_chucVu.getSelectedItem() + "";
				double tienLuong = Double.valueOf(textField_luong.getText());
				String ghiChu = textField_ghiChu.getText();

				Staff staff = new Staff(maNhanVien, tenNhanVien, gioiTinh, ngaySinh, diaChi, email, tienLuong, sdt,
						chucVu, ghiChu);
				listStaff.add(staff);
				StaffDAO.getInstance().insert(staff);
				addDataToTable();
				JOptionPane.showMessageDialog(this, "Đã thêm thành công");
			}
		}

	}

	public void thucHienXoa() {
		int row = table_nhanVien.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
			return;
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa dòng này không") == JOptionPane.YES_OPTION) {
				Staff staff = null;
				for (Staff st : listStaff) {
					if (st.getStaffID().equals(model_nhanVien.getValueAt(row, 0))) {
						staff = st;
					}
				}
				listStaff.remove(staff);
				StaffDAO.getInstance().delete(staff);
				addDataToTable();
				thucHienLamMoi();
				JOptionPane.showMessageDialog(this, "Đã xóa thành công");
			}
		}
	}

	public void thucHienCapNhat() {
		int row = table_nhanVien.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần cập nhật!");
			return;
		} else {
			if (JOptionPane.showConfirmDialog(this,
					"Bạn có chắc chắn muốn cập nhật dòng này không!") == JOptionPane.YES_OPTION) {
				String maNhanVien = textField_maNhanVien.getText();
				String tenNhanVien = textField_tenNhanVien.getText();
				boolean gioiTinh = (comboBox_gioiTinhNhanVien.getSelectedItem().equals("Nam"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date ngaySinh = Date.valueOf(sdf.format(dateChooser_ngaySinh.getDate()));
				String diaChi = textField_diaChiNhanVien.getText();
				String email = textField_emailNhanVien.getText();
				String sdt = textField_soDienThoaiNhanVien.getText();
				String chucVu = comboBox_chucVu.getSelectedItem() + "";
				double tienLuong = Double.valueOf(textField_luong.getText());
				String ghiChu = textField_ghiChu.getText();

				Staff staff = new Staff(maNhanVien, tenNhanVien, gioiTinh, ngaySinh, diaChi, email, tienLuong, sdt,
						chucVu, ghiChu);

				listStaff.set(row, staff);
				addDataToTable();
				StaffDAO.getInstance().update(staff);
				JOptionPane.showMessageDialog(this, "Bạn đã cập nhật thành công!");
			}
		}
	}

	public void thucHienLamMoi() {
		textField_maNhanVien.setText("");
		textField_tenNhanVien.setText("");
		comboBox_gioiTinhNhanVien.setSelectedItem("");
		dateChooser_ngaySinh.setDate(null);
		textField_diaChiNhanVien.setText("");
		textField_emailNhanVien.setText("");
		textField_soDienThoaiNhanVien.setText("");
		comboBox_chucVu.setSelectedItem("");
		textField_luong.setText("");
		textField_ghiChu.setText("");
		addDataToTable();
	}

	public void thucHienTim() {
		if (textField_timKiemNhanVien.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hoặc tên cần tìm!");
			return;
		} else {
			int ketQua = 0;
			String timKiem = textField_timKiemNhanVien.getText();
			model_nhanVien.setRowCount(0);
			for (Staff staff : listStaff) {
				if (staff.getStaffID().equals(timKiem) || staff.getStaffName().equals(timKiem)) {
					addRowTable(staff);
					ketQua++;
				}
			}
			if (ketQua == 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
				addDataToTable();
			}
		}
	}

	public void addRowTable(Staff staff) {
		String data[] = { staff.getStaffID(), staff.getStaffName(), (staff.isGender()) ? "Nam" : "Nữ",
				staff.getDateOfBirth() + "", staff.getAddress(), staff.getEmail(), staff.getPhone(),
				staff.getPosition(), nf.format(staff.getSalary()) + "", staff.getNote() };
		model_nhanVien.addRow(data);
	}

}

