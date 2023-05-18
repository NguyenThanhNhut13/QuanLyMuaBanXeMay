package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import dao.CustomersDAO;
import dao.DonHangDAO;
import entity.DonHang;
import entity.Motobike;

import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfTemplate;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;

public class FrameHoaDon extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;

	public FrameHoaDon(DonHang donHang) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 637);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_title = new JPanel();
		panel_title.setBounds(10, 11, 566, 76);
		contentPane.add(panel_title);
		panel_title.setLayout(null);

		JLabel lbl_tenCongTy = new JLabel("CÔNG TY TNHH MUA BÁN XE MÁY ABC");
		lbl_tenCongTy.setBounds(82, 0, 401, 25);
		panel_title.add(lbl_tenCongTy);
		lbl_tenCongTy.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tenCongTy.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lbl_diaChi = new JLabel("Địa chỉ: Số 12 Nguyễn Văn Bảo, Phường 4, Quận Gò Vấp, Thành phố Hồ Chí Minh");
		lbl_diaChi.setBounds(77, 25, 412, 16);
		panel_title.add(lbl_diaChi);
		lbl_diaChi.setFont(new Font("Arial", Font.PLAIN, 11));

		JLabel lbl_dienThoai = new JLabel("Số điện thoại: 0283.8940 390 / Fax: 0283.9940 954");
		lbl_dienThoai.setBounds(155, 41, 256, 16);
		panel_title.add(lbl_dienThoai);
		lbl_dienThoai.setFont(new Font("Arial", Font.PLAIN, 11));

		JLabel lbl_email = new JLabel("Email: dhcn@iuh.edu.vn");
		lbl_email.setBounds(220, 57, 126, 16);
		panel_title.add(lbl_email);
		lbl_email.setFont(new Font("Arial", Font.PLAIN, 11));

		JLabel lbl_orderName = new JLabel("HÓA ĐƠN BÁN LẺ");
		lbl_orderName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_orderName.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_orderName.setBounds(209, 87, 175, 24);
		contentPane.add(lbl_orderName);

		JLabel lbl_ngayLapHoaDon = new JLabel("Ngày");
		lbl_ngayLapHoaDon.setFont(new Font("Arial", Font.ITALIC, 11));
		lbl_ngayLapHoaDon.setBounds(396, 122, 25, 13);
		contentPane.add(lbl_ngayLapHoaDon);

		JLabel lbl_thangLapHoaDon = new JLabel("tháng");
		lbl_thangLapHoaDon.setFont(new Font("Arial", Font.ITALIC, 11));
		lbl_thangLapHoaDon.setBounds(456, 122, 27, 13);
		contentPane.add(lbl_thangLapHoaDon);

		JLabel lbl_namLapHoaDon = new JLabel("năm");
		lbl_namLapHoaDon.setFont(new Font("Arial", Font.ITALIC, 11));
		lbl_namLapHoaDon.setBounds(520, 122, 27, 13);
		contentPane.add(lbl_namLapHoaDon);

		JLabel lbl_ngayLapHoaDon_value = new JLabel(donHang.getOrder_Date().getDate() + "");
		lbl_ngayLapHoaDon_value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ngayLapHoaDon_value.setFont(new Font("Arial", Font.ITALIC, 11));
		lbl_ngayLapHoaDon_value.setBounds(428, 122, 18, 13);
		contentPane.add(lbl_ngayLapHoaDon_value);

		JLabel lbl_thangLapHoaDon_value = new JLabel(donHang.getOrder_Date().getMonth() + 1 + "");
		lbl_thangLapHoaDon_value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_thangLapHoaDon_value.setFont(new Font("Arial", Font.ITALIC, 11));
		lbl_thangLapHoaDon_value.setBounds(493, 122, 17, 13);
		contentPane.add(lbl_thangLapHoaDon_value);

		JLabel lbl_namLapHoaDon_value = new JLabel(donHang.getOrder_Date().getYear() + 1900 + "");
		lbl_namLapHoaDon_value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_namLapHoaDon_value.setFont(new Font("Arial", Font.ITALIC, 11));
		lbl_namLapHoaDon_value.setBounds(549, 122, 27, 13);
		contentPane.add(lbl_namLapHoaDon_value);

		JLabel lbl_tenKhachHang = new JLabel("Họ tên khách hàng:");
		lbl_tenKhachHang.setFont(new Font("Arial", Font.PLAIN, 13));
		lbl_tenKhachHang.setBounds(23, 138, 118, 18);
		contentPane.add(lbl_tenKhachHang);

		JLabel lbl_tenKhachHang_1 = new JLabel(
				CustomersDAO.getInstance().selectByID(donHang.getCustomer_id()).getCustomer_Name());
		lbl_tenKhachHang_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tenKhachHang_1.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_tenKhachHang_1.setBounds(144, 138, 267, 18);
		contentPane.add(lbl_tenKhachHang_1);

		JLabel lbl_diaChiKhachHang = new JLabel("Địa chỉ:");
		lbl_diaChiKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_diaChiKhachHang.setFont(new Font("Arial", Font.PLAIN, 13));
		lbl_diaChiKhachHang.setBounds(23, 168, 118, 18);
		contentPane.add(lbl_diaChiKhachHang);

		JLabel lbl_diaChiKhachHang_value = new JLabel(
				CustomersDAO.getInstance().selectByID(donHang.getCustomer_id()).getCustomer_Address());
		lbl_diaChiKhachHang_value.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_diaChiKhachHang_value.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_diaChiKhachHang_value.setBounds(144, 168, 414, 18);
		contentPane.add(lbl_diaChiKhachHang_value);

		JPanel panel_table = new JPanel();
		panel_table.setBounds(10, 197, 566, 260);
		contentPane.add(panel_table);
		panel_table.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_table.add(scrollPane, BorderLayout.CENTER);

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == -1;
			}
		};
		model.addColumn("STT");
		model.addColumn("Tên sản phẩm");
		model.addColumn("Số lượng");
		model.addColumn("Đơn giá");
		model.addColumn("Thành tiền");
		table = new JTable(model);
		scrollPane.setViewportView(table);

		JLabel lbl_tongTien = new JLabel("Tổng tiền:");
		lbl_tongTien.setFont(new Font("Arial", Font.PLAIN, 13));
		lbl_tongTien.setBounds(23, 469, 76, 18);
		contentPane.add(lbl_tongTien);

		DecimalFormat df = new DecimalFormat("###,###");
		JLabel lbl_tongTienValue = new JLabel(df.format(donHang.getOrderAmount()));
		lbl_tongTienValue.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tongTienValue.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_tongTienValue.setBounds(104, 468, 108, 21);
		contentPane.add(lbl_tongTienValue);

		JLabel lbl_tongTien_Value_locale = new JLabel("VNĐ");
		lbl_tongTien_Value_locale.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl_tongTien_Value_locale.setBounds(215, 469, 33, 18);
		contentPane.add(lbl_tongTien_Value_locale);

		JLabel lbl_nguoiMua = new JLabel("Người mua");
		lbl_nguoiMua.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_nguoiMua.setBounds(140, 500, 83, 18);
		contentPane.add(lbl_nguoiMua);

		JLabel lbl_nguoiBan = new JLabel("Người bán");
		lbl_nguoiBan.setIcon(null);
		lbl_nguoiBan.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_nguoiBan.setBounds(363, 500, 83, 18);
		contentPane.add(lbl_nguoiBan);

		JLabel lbl_signature = new JLabel("");
		lbl_signature.setIcon(new ImageIcon(FrameHoaDon.class.getResource("/img/signature_NV1.png")));
		lbl_signature.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_signature.setBounds(335, 529, 139, 65);
		contentPane.add(lbl_signature);
		loadData(donHang);
	}

	public void loadData(DonHang donHang) {
		model.setRowCount(0);
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		ArrayList<Motobike> listSp = donHang.getListSanPham();
		for (int i = 0; i < listSp.size(); i++) {
			String data[] = { i + 1 + "", listSp.get(i).getName(), listSp.get(i).getQuantity() + "",
					nf.format(listSp.get(i).getPrice()),
					nf.format(listSp.get(i).getPrice() * listSp.get(i).getQuantity()) };
			model.addRow(data);
		}
	}

	public void JFrameToPDF(FrameHoaDon frameHoaDon, File file) {
		com.itextpdf.text.Document document = new com.itextpdf.text.Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			PdfContentByte cb = writer.getDirectContent();
			Graphics2D g2d = cb.createGraphics(frameHoaDon.getWidth(), frameHoaDon.getHeight(),
					new DefaultFontMapper());
			Rectangle rectangle = new Rectangle(0, 0, frameHoaDon.getWidth(), frameHoaDon.getHeight());
			frameHoaDon.setBounds(rectangle);
			frameHoaDon.getContentPane().paint(g2d);
			g2d.dispose();
//			BaseFont bf = BaseFont.createFont("D:/HK4/LapTrinhHuongSuKien/QuanLyMuaBanXeMay/arial-unicode-ms.ttf",
//					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//			com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf, 12);
//			Paragraph paragraph = new Paragraph("", font);
//			document.add(paragraph);
			document.close();
			this.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void thucHienLuu(DonHang donHang) {
		if(JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu hóa đơn không?", "Messaage", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new FileNameExtensionFilter("PDF files", "pdf"));
			int userSelection = fileChooser.showSaveDialog(this);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				JFrameToPDF(this, fileChooser.getSelectedFile());
				donHang.setStatus("Đã hoàn thành");
				DonHangDAO.getInstance().update(donHang);
				JOptionPane.showMessageDialog(this, "Đã lưu thành công");
			}
		}else {
			donHang.setStatus("Đã hoàn thành");
			DonHangDAO.getInstance().update(donHang);
		}
		
	}

}
