package dao;

import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Regex {
	
	public boolean regexTimXeTheoMaHoacTen(JTextField textField_timKiemXe) {
		String input1 = textField_timKiemXe.getText();
		String input = input1.trim().toUpperCase();
		String regexMaXe = "((MSX|msx)[0-9]+[0-9]*)|";
	    String regexTenXe = "([a-zA-Z\\s]*+)|";
	    String regexTim = "^(" + regexMaXe + regexTenXe +  ")$";
		if (!input.matches(regexTim)) {
			JOptionPane.showMessageDialog(null,
					"Nhap ma xe de tim hoac ten xe de tim "
							+ "\n (vd: MSX006 hoặc msx006)"
							+ "\n (vd: Airblade)",
					"THONG BAO", JOptionPane.ERROR_MESSAGE);
			textField_timKiemXe.requestFocus();
			textField_timKiemXe.selectAll();
			return false;
		}
		return true;
	}
	
	public boolean regexGiaXe(JTextField textField_gia) {
		String input = textField_gia.getText();
		String regex = "^[1-9]+[0-9]{7}+[0-9]*$";
		if (!input.matches(regex)) {
			JOptionPane.showMessageDialog(null,
					"Gia xe phai tu 10 triệu ", "THONG BAO",
					JOptionPane.ERROR_MESSAGE);
			textField_gia.requestFocus();
			textField_gia.selectAll();
			return false;
		}
		return true;
	}  
	
	public boolean regexMaSX(JTextField textField_maXe) {
		String input = textField_maXe.getText().trim();
		input = input.toUpperCase();
		String regexMaXe = "^MSX([0-9]){3}$";
		if (!input.matches(regexMaXe)) {
			JOptionPane.showMessageDialog(null, "Ma So Xe co dinh dang MSXxxx (xxx la day so bat ki)\n"
					+ "Vi du: MSX015\n");
			textField_maXe.requestFocus();
			textField_maXe.selectAll();
			return false;
		}
		return true;
	}
}

