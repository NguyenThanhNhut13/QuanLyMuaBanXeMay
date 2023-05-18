package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
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

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;

public class FrameThongKe extends JPanel implements ItemListener, ActionListener {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ArrayList<Motobike> dsSP;
	private JTable table;
	private JLabel lbl_valueDoanhThu;
	private JLabel lbl_valueSoDonHang;
	private JLabel lbl_valueDonHangDaHuy;
	private JLabel lbl_valueKhachHang;
	private DefaultTableModel model;
	private JComboBox comboBox_theoQuy;
	private JComboBox comboBox_theoNam;
	private JRadioButton rdbtn_theoNam;
	private JRadioButton rdbtn_theoQuy;
	private JRadioButton rdbtn_tatCa;
	private MotobikeDAO daoMoto;
	private JComboBox comboBox_theoQuyCuaNam;

	public FrameThongKe() {
		setLayout(null);

		JPanel panel_doanhThu = new JPanel();
		panel_doanhThu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_doanhThu.setBounds(6, 11, 195, 115);
		add(panel_doanhThu);
		panel_doanhThu.setLayout(null);

		JLabel lbl_doanhThu = new JLabel("Doanh Thu");
		lbl_doanhThu.setIcon(new ImageIcon(FrameThongKe.class.getResource("/img/doanhThu.png")));
		lbl_doanhThu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_doanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doanhThu.setBounds(23, 11, 149, 32);
		panel_doanhThu.add(lbl_doanhThu);

		lbl_valueDoanhThu = new JLabel("12.500.000");
		lbl_valueDoanhThu.setForeground(Color.GREEN);
		lbl_valueDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_valueDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_valueDoanhThu.setBounds(10, 54, 175, 25);
		panel_doanhThu.add(lbl_valueDoanhThu);

		JLabel lbl_donViDoanhThu = new JLabel("VNĐ");
		lbl_donViDoanhThu.setForeground(Color.GREEN);
		lbl_donViDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_donViDoanhThu.setBounds(146, 78, 49, 14);
		panel_doanhThu.add(lbl_donViDoanhThu);

		JPanel panel_soDonHang = new JPanel();
		panel_soDonHang.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_soDonHang.setLayout(null);
		panel_soDonHang.setBounds(207, 11, 195, 115);
		add(panel_soDonHang);

		JLabel lbl_soDonHang = new JLabel("Số đơn hàng");
		lbl_soDonHang.setIcon(new ImageIcon(FrameThongKe.class.getResource("/img/tongDonHang.png")));
		lbl_soDonHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_soDonHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_soDonHang.setBounds(14, 11, 166, 32);
		panel_soDonHang.add(lbl_soDonHang);

		lbl_valueSoDonHang = new JLabel("96");
		lbl_valueSoDonHang.setForeground(Color.GREEN);
		lbl_valueSoDonHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_valueSoDonHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_valueSoDonHang.setBounds(18, 54, 159, 25);
		panel_soDonHang.add(lbl_valueSoDonHang);

		JPanel panel_donHangDaHuy = new JPanel();
		panel_donHangDaHuy.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_donHangDaHuy.setLayout(null);
		panel_donHangDaHuy.setBounds(408, 11, 195, 115);
		add(panel_donHangDaHuy);

		JLabel lbl_donHangDaHuy = new JLabel("Đã hủy");
		lbl_donHangDaHuy.setIcon(new ImageIcon(FrameThongKe.class.getResource("/img/donHangDaHuy.png")));
		lbl_donHangDaHuy.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_donHangDaHuy.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_donHangDaHuy.setBounds(23, 11, 149, 32);
		panel_donHangDaHuy.add(lbl_donHangDaHuy);

		lbl_valueDonHangDaHuy = new JLabel("69");
		lbl_valueDonHangDaHuy.setForeground(Color.RED);
		lbl_valueDonHangDaHuy.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_valueDonHangDaHuy.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_valueDonHangDaHuy.setBounds(18, 54, 159, 25);
		panel_donHangDaHuy.add(lbl_valueDonHangDaHuy);

		JPanel panel_khachHang = new JPanel();
		panel_khachHang.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_khachHang.setLayout(null);
		panel_khachHang.setBounds(609, 11, 192, 115);
		add(panel_khachHang);

		JLabel lbl_khachHang = new JLabel("Khách hàng");
		lbl_khachHang.setIcon(new ImageIcon(FrameThongKe.class.getResource("/img/khachHangDaMua.png")));
		lbl_khachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_khachHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_khachHang.setBounds(21, 11, 149, 32);
		panel_khachHang.add(lbl_khachHang);

		lbl_valueKhachHang = new JLabel("21");
		lbl_valueKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_valueKhachHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_valueKhachHang.setBounds(16, 54, 159, 25);
		panel_khachHang.add(lbl_valueKhachHang);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(6, 291, 795, 212);
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.CENTER);

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == -1;
			}
		};
		model.addColumn("Mã sản phẩm");
		model.addColumn("Tên sản phẩm");
		model.addColumn("Số lượng tồn");
		model.addColumn("Số lượng bán ra");
		model.addColumn("Thành tiền");
		model.addColumn("Đã hủy");
		table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(table);

		JPanel panel_locTheoDieuKien = new JPanel();
		panel_locTheoDieuKien.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_locTheoDieuKien.setBounds(6, 137, 321, 140);
		add(panel_locTheoDieuKien);
		panel_locTheoDieuKien.setLayout(null);

		rdbtn_tatCa = new JRadioButton("Tất cả");
		rdbtn_tatCa.setBounds(22, 17, 111, 23);
		panel_locTheoDieuKien.add(rdbtn_tatCa);
		rdbtn_tatCa.setFont(new Font("Arial", Font.PLAIN, 11));
		buttonGroup.add(rdbtn_tatCa);

		rdbtn_theoQuy = new JRadioButton("Theo quý");
		rdbtn_theoQuy.setBounds(22, 55, 111, 23);
		panel_locTheoDieuKien.add(rdbtn_theoQuy);
		rdbtn_theoQuy.setFont(new Font("Arial", Font.PLAIN, 11));
		buttonGroup.add(rdbtn_theoQuy);

		rdbtn_theoNam = new JRadioButton("Theo năm");
		rdbtn_theoNam.setBounds(22, 91, 111, 23);
		panel_locTheoDieuKien.add(rdbtn_theoNam);
		rdbtn_theoNam.setFont(new Font("Arial", Font.PLAIN, 11));
		buttonGroup.add(rdbtn_theoNam);

		comboBox_theoQuy = new JComboBox();
		comboBox_theoQuy.addItem("");
		comboBox_theoQuy.addItem("Quý 1");
		comboBox_theoQuy.addItem("Quý 2");
		comboBox_theoQuy.addItem("Quý 3");
		comboBox_theoQuy.addItem("Quý 4");
		comboBox_theoQuy.setVisible(false);
		comboBox_theoQuy.setBounds(139, 55, 63, 22);
		panel_locTheoDieuKien.add(comboBox_theoQuy);
		comboBox_theoQuy.setFont(new Font("Arial", Font.PLAIN, 11));

		comboBox_theoNam = new JComboBox();
		comboBox_theoNam.addItem("");
		comboBox_theoNam.setVisible(false);
		comboBox_theoNam.setBounds(139, 91, 63, 22);
		panel_locTheoDieuKien.add(comboBox_theoNam);
		comboBox_theoNam.setFont(new Font("Arial", Font.PLAIN, 11));

		comboBox_theoQuyCuaNam = new JComboBox();
		comboBox_theoQuyCuaNam.setVisible(false);
		comboBox_theoQuyCuaNam.addItem("");
		comboBox_theoQuyCuaNam.setBounds(223, 55, 63, 22);
		panel_locTheoDieuKien.add(comboBox_theoQuyCuaNam);

		rdbtn_tatCa.addItemListener(this);
		rdbtn_theoQuy.addItemListener(this);
		rdbtn_theoNam.addItemListener(this);
		comboBox_theoQuy.addActionListener(this);
		comboBox_theoQuyCuaNam.addActionListener(this);
		comboBox_theoNam.addActionListener(this);

		daoMoto = new MotobikeDAO();
		dsSP = daoMoto.getDSXe();
		loadData();
	}

	public void loadData() {
		comboBox_theoNam.removeAllItems();
		comboBox_theoQuyCuaNam.removeAllItems();
		Set<Integer> year = new HashSet<>();
		for (DonHang donHang : DonHangDAO.getInstance().selectAll()) {
			year.add(donHang.getOrder_Date().getYear() + 1900);
		}
		for (Integer integer : year) {
			comboBox_theoNam.addItem(integer);
			comboBox_theoQuyCuaNam.addItem(integer);
		}
		buttonGroup.clearSelection();
		model.setRowCount(0);
		comboBox_theoNam.setVisible(false);
		comboBox_theoQuy.setVisible(false);
		comboBox_theoQuyCuaNam.setVisible(false);
	}

	DecimalFormat df = new DecimalFormat("###,###");

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rdbtn_tatCa) {
			thucHienThongKeTatCa();
			comboBox_theoNam.setVisible(false);
			comboBox_theoQuy.setVisible(false);
			comboBox_theoQuyCuaNam.setVisible(false);
		} else if (e.getSource() == rdbtn_theoQuy) {
			comboBox_theoQuyCuaNam.setVisible(true);
			comboBox_theoNam.setVisible(false);
			comboBox_theoQuy.setVisible(true);
		} else if (e.getSource() == rdbtn_theoNam) {
			comboBox_theoNam.setVisible(true);
			comboBox_theoQuy.setVisible(false);
			comboBox_theoQuyCuaNam.setVisible(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (rdbtn_theoNam.isSelected() && e.getSource() == comboBox_theoNam) {
			thucHienThongKeTheoNam();
		} else if (rdbtn_theoQuy.isSelected() && e.getSource() == comboBox_theoQuy) {
			thucHienThongKeTheoQuy();
		}
	}

	private void thucHienThongKeTheoNam() {
		Set<String> listCustomers = new HashSet<>();
		ArrayList<DonHang> listDonHangTheoNam = new ArrayList<>();
		double doanhThu = 0;
		int soDonHangDaHuy = 0;
		int soLuongKhachHang = 0;
		for (DonHang donHang : DonHangDAO.getInstance().selectAll()) {
			if (Integer.valueOf(comboBox_theoNam.getSelectedItem() + "") == donHang.getOrder_Date().getYear() + 1900) {
				if (donHang.getStatus().equals("Đã hoàn thành")) {
					doanhThu += donHang.getOrderAmount();
				}
				if (donHang.getStatus().equals("Đã hủy")) {
					soDonHangDaHuy += 1;
				}
				listCustomers.add(donHang.getCustomer_id());
				listDonHangTheoNam.add(donHang);
			}

		}
		soLuongKhachHang = listCustomers.size();
		String data[] = { df.format(doanhThu), listDonHangTheoNam.size() + "", soDonHangDaHuy + "",
				listCustomers.size() + "" };
		addDataToView(data, listDonHangTheoNam);
	}

	private void thucHienThongKeTheoQuy() {
		Set<String> listCustomers = new HashSet<>();
		ArrayList<DonHang> listDonHangTheoQuy = new ArrayList<>();
		double doanhThu = 0;
		int soDonHangDaHuy = 0;
		int soLuongKhachHang = 0;
		for (DonHang donHang : DonHangDAO.getInstance().selectAll()) {
			if (comboBox_theoQuy.getSelectedIndex() == 1 && (donHang.getOrder_Date().getMonth() + 1) >= 1
					&& (donHang.getOrder_Date().getMonth() + 1) < 4 && Integer
							.valueOf(comboBox_theoQuyCuaNam.getSelectedItem() + "") == donHang.getOrder_Date().getYear()
									+ 1900) {
				if (donHang.getStatus().equals("Đã hoàn thành")) {
					doanhThu += donHang.getOrderAmount();
				}
				if (donHang.getStatus().equals("Đã hủy")) {
					soDonHangDaHuy += 1;
				}
				listCustomers.add(donHang.getCustomer_id());
				listDonHangTheoQuy.add(donHang);
			} else if (comboBox_theoQuy.getSelectedIndex() == 2 && (donHang.getOrder_Date().getMonth() + 1) >= 4
					&& (donHang.getOrder_Date().getMonth() + 1) < 7 && Integer
							.valueOf(comboBox_theoQuyCuaNam.getSelectedItem() + "") == donHang.getOrder_Date().getYear()
									+ 1900) {
				if (donHang.getStatus().equals("Đã hoàn thành")) {
					doanhThu += donHang.getOrderAmount();
				}
				if (donHang.getStatus().equals("Đã hủy")) {
					soDonHangDaHuy += 1;
				}
				listCustomers.add(donHang.getCustomer_id());
				listDonHangTheoQuy.add(donHang);
			} else if (comboBox_theoQuy.getSelectedIndex() == 3 && (donHang.getOrder_Date().getMonth() + 1) >= 7
					&& (donHang.getOrder_Date().getMonth() + 1) < 10 && Integer
							.valueOf(comboBox_theoQuyCuaNam.getSelectedItem() + "") == donHang.getOrder_Date().getYear()
									+ 1900) {
				if (donHang.getStatus().equals("Đã hoàn thành")) {
					doanhThu += donHang.getOrderAmount();
				}
				if (donHang.getStatus().equals("Đã hủy")) {
					soDonHangDaHuy += 1;
				}
				listCustomers.add(donHang.getCustomer_id());
				listDonHangTheoQuy.add(donHang);
			} else if (comboBox_theoQuy.getSelectedIndex() == 4 && (donHang.getOrder_Date().getMonth() + 1) >= 10
					&& (donHang.getOrder_Date().getMonth() + 1) <= 12 && Integer
							.valueOf(comboBox_theoQuyCuaNam.getSelectedItem() + "") == donHang.getOrder_Date().getYear()
									+ 1900) {
				if (donHang.getStatus().equals("Đã hoàn thành")) {
					doanhThu += donHang.getOrderAmount();
				}
				if (donHang.getStatus().equals("Đã hủy")) {
					soDonHangDaHuy += 1;
				}
				listCustomers.add(donHang.getCustomer_id());
				listDonHangTheoQuy.add(donHang);
			}
		}
		soLuongKhachHang = listCustomers.size();
		String data[] = { df.format(doanhThu), listDonHangTheoQuy.size() + "", soDonHangDaHuy + "",
				listCustomers.size() + "" };
		addDataToView(data, listDonHangTheoQuy);

	}

	private void thucHienThongKeTatCa() {
		Set<String> listCustomers = new HashSet<>();
		double doanhThu = 0;
		int soDonHangDaHuy = 0;
		int soLuongKhachHang = 0;
		for (DonHang donHang : DonHangDAO.getInstance().selectAll()) {
			if (donHang.getStatus().equals("Đã hoàn thành")) {
				doanhThu += donHang.getOrderAmount();
			}
			if (donHang.getStatus().equals("Đã hủy")) {
				soDonHangDaHuy += 1;
			}
			listCustomers.add(donHang.getCustomer_id());
		}
		soLuongKhachHang = listCustomers.size();
		String data[] = { df.format(doanhThu), DonHangDAO.getInstance().selectAll().size() + "", soDonHangDaHuy + "",
				listCustomers.size() + "" };
		addDataToView(data, DonHangDAO.getInstance().selectAll());
	}

	private void addDataToView(String[] data, ArrayList<DonHang> listDH) {
		model.setRowCount(0);
		ArrayList<Motobike> listSP = new ArrayList<Motobike>();
		int soLuongDaHuy = 0;
		Map<String, Integer> donHangBiHuy = new HashMap<>();
		lbl_valueDoanhThu.setText(data[0]);
		lbl_valueSoDonHang.setText(data[1]);
		lbl_valueDonHangDaHuy.setText(data[2]);
		lbl_valueKhachHang.setText(data[3]);
		for (DonHang donHang : listDH) {
			for (Motobike motobike : donHang.getListSanPham()) {
				if (donHang.getStatus().equals("Đã hoàn thành")) {
					int check = kiemTraTrungMa(listSP, motobike);
					if (check < 0) {
						listSP.add(motobike);
					} else {
						listSP.get(check).setQuantity(listSP.get(check).getQuantity() + motobike.getQuantity());
					}
				} else if (donHang.getStatus().equals("Đã hủy")) {
					int check = kiemTraTrungMa(listSP, motobike);
					soLuongDaHuy = donHangBiHuy.getOrDefault(motobike.getId(), 0);
					donHangBiHuy.put(motobike.getId(), soLuongDaHuy + motobike.getQuantity());
				}
			}
		}
		for (Motobike motobike : listSP) {
			String dataTable[] = { motobike.getId(), motobike.getName(),
					daoMoto.get1XeTheoMa(motobike.getId()).getQuantity() + "", motobike.getQuantity() + "",
					df.format(motobike.getQuantity() * motobike.getPrice()), "0" };
			model.addRow(dataTable);
		}

		for (int i = 0; i < model.getRowCount(); i++) {
			for (Map.Entry<String, Integer> donHang : donHangBiHuy.entrySet()) {
				if (model.getValueAt(i, 0).equals(donHang.getKey())) {
					model.setValueAt(donHang.getValue(), i, 5);
				}
			}
		}
	}

	private int kiemTraTrungMa(ArrayList<Motobike> motobikes, Motobike motobike) {
		for (int i = 0; i < motobikes.size(); i++) {
			if (motobikes.get(i).getId().equals(motobike.getId())) {
				return i;
			}
		}
		return -1;
	}

}

