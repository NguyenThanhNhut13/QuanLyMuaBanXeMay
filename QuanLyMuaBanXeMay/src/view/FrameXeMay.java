package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import connection.ConnectDB;
import dao.MotoTypeDAO;
import dao.MotobikeDAO;
import dao.Regex;
import entity.MotoType;
import entity.Motobike;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrameXeMay extends JPanel implements ActionListener, MouseListener {
	private static final Motobike Motobike = null;
	private JTextField textField_maXe;
	private JTextField textField;
	private JTextField textField_namSx;
	private JTextField textField_dungTich;
	private JTextField textField_gia;
	private DefaultTableModel model;
	private JTable table;
	private JTextField textField_timKiemXe;
	private JTextField textField_hangXe;
	private JTextField textField_mauXe;
	private MotobikeDAO daoMoto;
	private JComboBox<String> comboBox_loaiXe;
	private MotoTypeDAO daoMotoType;
	private Regex regex;
	private DecimalFormat dfmGia;
	private JButton btn_timKiemXe;
	private JButton btn_lamMoi;
	private JButton btn_xoaXe;
	private JButton btn_capNhatXe;
	private JButton btn_themXe;
	private int sl = 200;
	private JLabel lbl_soLuong;
	private JTextField textField_soLuong;
	private ArrayList<Motobike> lsXe;

	public FrameXeMay() {
		setBounds(100, 100, 811, 520);
		this.setLayout(null);

		JPanel panel_thongTin = new JPanel();
		panel_thongTin.setBorder(BorderFactory.createTitledBorder("Thông tin xe"));
		panel_thongTin.setBounds(10, 11, 795, 211);
		add(panel_thongTin);
		panel_thongTin.setLayout(null);

		textField_maXe = new JTextField();
		textField_maXe.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_maXe.setBounds(96, 18, 280, 20);
		panel_thongTin.add(textField_maXe);
		textField_maXe.setColumns(10);

		JLabel lbl_maXe = new JLabel("Mã xe:");
		lbl_maXe.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_maXe.setBounds(20, 21, 59, 14);
		panel_thongTin.add(lbl_maXe);

		JLabel lbl_tenXe = new JLabel("Tên xe:");
		lbl_tenXe.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_tenXe.setBounds(20, 53, 37, 14);
		panel_thongTin.add(lbl_tenXe);

		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 11));
		textField.setColumns(10);
		textField.setBounds(96, 50, 280, 20);
		panel_thongTin.add(textField);

		JLabel lbl_hangXe = new JLabel("Hãng xe:");
		lbl_hangXe.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_hangXe.setBounds(20, 85, 44, 14);
		panel_thongTin.add(lbl_hangXe);

		JLabel lbl_mauXe = new JLabel("Màu xe:");
		lbl_mauXe.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_mauXe.setBounds(20, 180, 44, 14);
		panel_thongTin.add(lbl_mauXe);

		JLabel lbl_namSx = new JLabel("Năm sản xuất:");
		lbl_namSx.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_namSx.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_namSx.setBounds(20, 148, 76, 14);
		panel_thongTin.add(lbl_namSx);

		textField_namSx = new JTextField();
		textField_namSx.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_namSx.setColumns(10);
		textField_namSx.setBounds(96, 145, 280, 20);
		panel_thongTin.add(textField_namSx);

		JLabel lbl_gia = new JLabel("Giá:");
		lbl_gia.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_gia.setBounds(431, 21, 33, 14);
		panel_thongTin.add(lbl_gia);

		JLabel lbl_loaiXe = new JLabel("Loại xe:");
		lbl_loaiXe.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_loaiXe.setBounds(431, 53, 44, 14);
		panel_thongTin.add(lbl_loaiXe);

		JLabel lbl_anhXe = new JLabel(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(FrameXeMay.class.getResource("/img/Exciter_150_2019.png"))));
		lbl_anhXe.setBounds(503, 76, 280, 114);
		panel_thongTin.add(lbl_anhXe);

		JLabel lbl_dungTich = new JLabel("Dung tích:");
		lbl_dungTich.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_dungTich.setBounds(20, 117, 51, 13);
		panel_thongTin.add(lbl_dungTich);

		textField_dungTich = new JTextField();
		textField_dungTich.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_dungTich.setColumns(10);
		textField_dungTich.setBounds(96, 113, 280, 20);
		panel_thongTin.add(textField_dungTich);

		textField_gia = new JTextField();
		textField_gia.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_gia.setColumns(10);
		textField_gia.setBounds(503, 18, 280, 20);
		panel_thongTin.add(textField_gia);

		JLabel lbl_loaiXe_1 = new JLabel("Ảnh xe:");
		lbl_loaiXe_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_loaiXe_1.setBounds(431, 116, 44, 14);
		panel_thongTin.add(lbl_loaiXe_1);

		textField_hangXe = new JTextField();
		textField_hangXe.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_hangXe.setColumns(10);
		textField_hangXe.setBounds(96, 82, 280, 20);
		panel_thongTin.add(textField_hangXe);

		textField_mauXe = new JTextField();
		textField_mauXe.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_mauXe.setColumns(10);
		textField_mauXe.setBounds(96, 177, 100, 20);
		panel_thongTin.add(textField_mauXe);

		lbl_soLuong = new JLabel("Số lượng:");
		lbl_soLuong.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_soLuong.setBounds(226, 180, 60, 14);
		panel_thongTin.add(lbl_soLuong);

		textField_soLuong = new JTextField();
		textField_soLuong.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_soLuong.setColumns(10);
		textField_soLuong.setBounds(296, 177, 80, 20);
		panel_thongTin.add(textField_soLuong);

		comboBox_loaiXe = new JComboBox();
		comboBox_loaiXe.setBounds(503, 50, 280, 20);

		panel_thongTin.add(comboBox_loaiXe);
		comboBox_loaiXe.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "", "Xe số", "Xe tay ga", "Xe côn tay", "Xe mô tô", "xe mới" }));

		comboBox_loaiXe.setSelectedIndex(0);
		/////////////

		JPanel panel_table = new JPanel();
		panel_table.setBorder(BorderFactory.createTitledBorder("Danh sách xe"));
		panel_table.setBounds(10, 225, 795, 246);
		add(panel_table);
		panel_table.setLayout(new BorderLayout());

		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã xe");
		model.addColumn("Tên xe");
		model.addColumn("Hãng xe");
		model.addColumn("Dung tích");
		model.addColumn("Năm sản xuất");
		model.addColumn("Màu xe");
		model.addColumn("Số lượng");
		model.addColumn("Giá");
		model.addColumn("Loại");

		JScrollPane scrollPane = new JScrollPane(table);
		panel_table.add(scrollPane, BorderLayout.CENTER);
		canLePhaiChoCot();
		//////////////

		btn_themXe = new JButton("Thêm");
		btn_themXe.setBackground(Color.GREEN);
		btn_themXe.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_themXe.setBounds(428, 482, 63, 23);
		add(btn_themXe);

		btn_capNhatXe = new JButton("Cập Nhật");
		btn_capNhatXe.setBackground(Color.YELLOW);
		btn_capNhatXe.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_capNhatXe.setBounds(608, 482, 83, 23);
		add(btn_capNhatXe);

		btn_xoaXe = new JButton("Xóa");
		btn_xoaXe.setBackground(Color.RED);
		btn_xoaXe.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_xoaXe.setBounds(523, 482, 53, 23);
		add(btn_xoaXe);

		btn_lamMoi = new JButton("Làm mới");
		btn_lamMoi.setBackground(Color.BLUE);
		btn_lamMoi.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_lamMoi.setBounds(711, 482, 79, 23);
		add(btn_lamMoi);

		JLabel lbl_timKiemXe = new JLabel("Tìm kiếm xe:");
		lbl_timKiemXe.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl_timKiemXe.setBounds(32, 486, 72, 14);
		add(lbl_timKiemXe);

		textField_timKiemXe = new JTextField();
		textField_timKiemXe.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_timKiemXe.setColumns(10);
		textField_timKiemXe.setBounds(114, 483, 146, 20);
		add(textField_timKiemXe);
		textField_timKiemXe.setText("Tim theo Ma hoac Ten xe");

		btn_timKiemXe = new JButton("Tìm");
		btn_timKiemXe.setForeground(Color.WHITE);
		btn_timKiemXe.setBackground(Color.BLUE);
		btn_timKiemXe.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_timKiemXe.setBounds(282, 482, 53, 23);
		add(btn_timKiemXe);

		this.setVisible(true);

		//////////////////////////////////////////
		daoMoto = new MotobikeDAO();
		daoMotoType = new MotoTypeDAO();
		regex = new Regex();
		dfmGia = new DecimalFormat("###,###");

		loadDanhSachXe();

		btn_timKiemXe.addActionListener(this);
		btn_themXe.addActionListener(this);
		btn_lamMoi.addActionListener(this);
		btn_capNhatXe.addActionListener(this);
		btn_xoaXe.addActionListener(this);
		table.addMouseListener(this);
	}

	private void themXe() throws Exception {
		if (regexTT()) {
			if (regex.regexMaSX(textField_maXe) && regex.regexGiaXe(textField_gia)) {
				try {
					Motobike xe = new Motobike();
					xe.setId(textField_maXe.getText());
					xe.setName(textField.getText());
					xe.setManufacturer(textField_hangXe.getText());
					xe.setCapacity(Float.parseFloat(textField_dungTich.getText()));
					xe.setColor(textField_mauXe.getText());
					String maloai = daoMotoType.getMaLoaiXeTheoTen(comboBox_loaiXe.getSelectedItem().toString());
					xe.setType(daoMotoType.getLoaiXeTheoMa(maloai));
					xe.setPrice(Double.parseDouble(textField_gia.getText()));
					xe.setQuantity(Integer.parseInt(textField_soLuong.getText()));
					xe.setYear(Integer.parseInt(textField_namSx.getText()));
					if(kiemTraTrungMa(xe)) {
						Motobike xe_new = daoMoto.get1XeTheoMa(xe.getId());
						xe_new.setQuantity(xe_new.getQuantity()+xe.getQuantity());
						daoMoto.capNhatXe(xe_new);
						clearTable();
						loadXeDuocChon(xe_new);
						JOptionPane.showMessageDialog(this, "Thêm xe thành công");
					}else {
						daoMoto.themXe(xe);
						clearTable();
						loadXeDuocChon(xe);
						JOptionPane.showMessageDialog(this, "Thêm xe thành công");
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Thêm xe không thành công!");
					e.printStackTrace();
					return;
				}

			}
		}
	}

	private boolean kiemTraTrungMa(Motobike xe) {
		for (Motobike motobike : lsXe) {
			if(motobike.getId().equals(xe.getId())) {
				return true;
			}
		}
		return false;
	}

	private void loadXeDuocChon(Motobike xe) throws Exception {
		MotoType loaixe = daoMotoType.getLoaiXeTheoMa(xe.getType().getTypeId());
		model.addRow(new Object[] { xe.getId(), xe.getName(), xe.getManufacturer(), xe.getCapacity(), xe.getYear(),
				xe.getColor(), xe.getQuantity(), dfmGia.format(xe.getPrice()), loaixe.getTypeName() });
	}

	// Tìm kiếm xe theo Mã hoặc tên
	private void timKiemXe() throws Exception {
		String input = textField_timKiemXe.getText().trim();
		input = input.toUpperCase();
		lsXe = null;
		String regexMaXe = "^((MSX|msx)[0-9]+[0-9]*)$";
		String regexTenXe = "^[a-zA-Z\\s]+$";
		if (!(textField_timKiemXe.getText().length() <= 0)
				&& !(textField_timKiemXe.getText().equalsIgnoreCase("Tim theo Ma hoac Ten xe"))) {
			if (regex.regexTimXeTheoMaHoacTen(textField_timKiemXe)) {
				if (input.matches(regexMaXe)) {
					lsXe = daoMoto.getXeTheoMa(input);
				} else if (input.matches(regexTenXe)) {
					lsXe = daoMoto.getXeTheoTen(textField_timKiemXe.getText());
				}

				if (lsXe.size() == 0) {
					JOptionPane.showMessageDialog(this, "Khong  tim thay xe!", "THONG BAO", JOptionPane.ERROR_MESSAGE);
					textField_timKiemXe.requestFocus();
					textField_timKiemXe.selectAll();
				} else {
					loadDSXeTimKiem(lsXe);
				}
			}
		} else {
			clearTable();
			JOptionPane.showMessageDialog(this, "Vui long nhap thong tin tim kiem (Theo ma hoac Ten xe)!", "THONG BAO",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void loadDSXeTimKiem(ArrayList<Motobike> lsXe) throws Exception {
		clearTable();
		for (Motobike xe : lsXe) {
			MotoType loaixe = daoMotoType.getLoaiXeTheoMa(xe.getType().getTypeId());
			model.addRow(new Object[] { xe.getId(), xe.getName(), xe.getManufacturer(), xe.getCapacity(), xe.getYear(),
					xe.getColor(), xe.getQuantity(), dfmGia.format(xe.getPrice()), loaixe.getTypeName() });
		}
	}

	private void canLePhaiChoCot() {
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
	}

	private boolean regexTT() {
		if (textField_maXe.getText().length() <= 0 || textField.getText().length() <= 0
				|| textField_hangXe.getText().length() <= 0 || textField_dungTich.getText().length() <= 0
				|| textField_namSx.getText().length() <= 0 || textField_mauXe.getText().length() <= 0
				|| textField_gia.getText().length() <= 0 || textField_soLuong.getText().length() <= 0
				|| comboBox_loaiXe.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập và chọn đầy đủ thông tin", "THÔNG BÁO",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (Integer.parseInt(textField_soLuong.getText()) <= 0) {
			JOptionPane.showMessageDialog(null, "Số lượng phải > 0", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	// làm trống bảng
	private void clearTable() {
		while (table.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	private void reset() throws Exception {
		textField_maXe.setText("");
		textField.setText("");
		textField_hangXe.setText("");
		textField_dungTich.setText("");
		textField_namSx.setText("");
		textField_mauXe.setText("");
		textField_gia.setText("");
		textField_soLuong.setText("");
		comboBox_loaiXe.setSelectedIndex(1);
		clearTable();
		loadDanhSachXe();
	}

	public void loadDanhSachXe() {
		clearTable();
		lsXe = daoMoto.getDSXe();
		for (Motobike xe : lsXe) {
			MotoType loaixe = daoMotoType.getLoaiXeTheoMa(xe.getType().getTypeId());
			model.addRow(new Object[] { xe.getId(), xe.getName(), xe.getManufacturer(), xe.getCapacity(), xe.getYear(),
					xe.getColor(), xe.getQuantity(), dfmGia.format(xe.getPrice()), loaixe.getTypeName() });
		}
	}

	// xoa xe
	private void xoaXe() {
		int row = table.getSelectedRow();
		if (row >= 0) {
			int choose = JOptionPane.showConfirmDialog(null, "Ban muon xoa xe nay?", "THONG BAO",
					JOptionPane.YES_NO_OPTION);
			if (choose == JOptionPane.YES_OPTION) {
				String ma = model.getValueAt(row, 0).toString();
				model.removeRow(row);
				try {
					if (daoMoto.xoaXe(ma)) {
						reset();
						clearTable();
						loadDanhSachXe();
						JOptionPane.showMessageDialog(null, "Xoa thanh cong", "THONG BAO", JOptionPane.OK_OPTION);
					} else {
						JOptionPane.showMessageDialog(null, "Xoa khong thanh cong", "THONG BAO",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Xoa khong thanh cong ex", "THONG BAO",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		} else {
			JOptionPane.showMessageDialog(null, "Vui long chon xe muon xoa", "THONG BAO", JOptionPane.WARNING_MESSAGE);
		}
	}

	// Sua thong tin xe
	public void capNhatXe() throws Exception {
		int row = table.getSelectedRow();
		if (row > -1) {
			int update = JOptionPane.showConfirmDialog(this, "Ban muon sua thong tin cua xe nay phai khong?",
					"THONG BAO", JOptionPane.YES_NO_OPTION);
			if (update == JOptionPane.YES_OPTION) {
				String ma = model.getValueAt(row, 0).toString();
				Motobike xe = daoMoto.get1XeTheoMa(ma);
				try {
					if (regex.regexGiaXe(textField_gia) && regexTT()) {
						xe.setName(textField.getText());
						xe.setManufacturer(textField_hangXe.getText());
						xe.setCapacity(Float.parseFloat(textField_dungTich.getText()));
						xe.setColor(textField_mauXe.getText());
						String maloai = daoMotoType.getMaLoaiXeTheoTen(comboBox_loaiXe.getSelectedItem().toString());
						xe.setType(daoMotoType.getLoaiXeTheoMa(maloai));
						xe.setQuantity(Integer.parseInt(textField_soLuong.getText()));
						xe.setPrice(Double.parseDouble(textField_gia.getText()));
						xe.setYear(Integer.parseInt(textField_namSx.getText()));

						new MotobikeDAO().capNhatXe(xe);
						clearTable();
						loadXeDuocChon(xe);
						JOptionPane.showMessageDialog(this, "Cập nhật thành công!", "THONG BAO", JOptionPane.OK_OPTION);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Vui kiem tra lai thong tin cap nhat!!", "THONG BAO",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui long chon dong can sua! ", "THONG BAO",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btn_lamMoi)) {
			try {
				reset();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (o.equals(btn_themXe)) {
			try {
				themXe();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (o.equals(btn_timKiemXe)) {
			try {
				timKiemXe();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(btn_xoaXe)) {
			try {
				xoaXe();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		if (o.equals(btn_capNhatXe)) {
			if(table.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn xe cần cập nhật!");
				return;
			}
			if ((table.getSelectedRow() > -1) && btn_capNhatXe.getText().equalsIgnoreCase("Cập nhật")) {
				textField_maXe.setEditable(false);
				btn_themXe.setEnabled(false);
				btn_xoaXe.setEnabled(false);
				btn_lamMoi.setEnabled(false);
				btn_capNhatXe.setText("Lưu");
			} else if (o.equals(btn_capNhatXe)) {
				try {
					capNhatXe();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_maXe.setEditable(true);
				btn_themXe.setEnabled(true);
				btn_xoaXe.setEnabled(true);
				btn_lamMoi.setEnabled(true);
				btn_capNhatXe.setText("Cập nhật");
			}

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		DecimalFormat df = new DecimalFormat("#");
		Object o = e.getSource();
		if (o.equals(table)) {
			int row = table.getSelectedRow();
			Motobike mtb = lsXe.get(row);
			textField_maXe.setText(model.getValueAt(row, 0).toString());
			textField.setText(model.getValueAt(row, 1).toString());
			textField_hangXe.setText(model.getValueAt(row, 2).toString());
			textField_dungTich.setText(model.getValueAt(row, 3).toString());
			textField_namSx.setText(model.getValueAt(row, 4).toString());
			textField_mauXe.setText(model.getValueAt(row, 5).toString());
			textField_soLuong.setText(model.getValueAt(row, 6).toString());
			textField_gia.setText(df.format(mtb.getPrice()));
			comboBox_loaiXe.setSelectedItem(model.getValueAt(row, 8));

//	    	textField_maXe.setEditable(false);
//	    	textField.setEditable(false);
//	    	textField_dungTich.setEditable(false);
//	    	textField_gia.setEditable(false);
//	    	textField_hangXe.setEditable(false);
//	    	textField_mauXe.setEditable(false);
//	    	textField_namSx.setEditable(false);
//	    	textField_soLuong.setEditable(false);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

