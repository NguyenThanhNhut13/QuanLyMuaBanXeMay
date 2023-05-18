package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.FrameXeMay;
import view.FrameChiTietDonHang;
import view.FrameDangNhap;
import view.FrameDonHang;
import view.FrameKhachHang;
import view.FrameMain;
import view.FrameNhanVien;

public class Controller implements ActionListener {
	private FrameMain frameMain;
	private FrameDangNhap frameDangNhap;
	private FrameDonHang frameDonHang;
	private FrameChiTietDonHang frameChiTietDonHang;
	private FrameNhanVien frameNhanVien;
	private FrameKhachHang frameKhachHang;

	public Controller(FrameMain frameMain) {
		this.frameMain = frameMain;
	}

	public Controller(FrameDangNhap frameDangNhap) {
		this.frameDangNhap = frameDangNhap;
	}

	public Controller(FrameDonHang frameDonHang) {
		this.frameDonHang = frameDonHang;
	}

	public Controller(FrameChiTietDonHang frameChiTietDonHang) {
		this.frameChiTietDonHang = frameChiTietDonHang;
	}

	public Controller(FrameNhanVien frameNhanVien) {
		this.frameNhanVien = frameNhanVien;
	}

	public Controller(FrameKhachHang frameKhachHang) {
		this.frameKhachHang = frameKhachHang;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Bán hàng")) {
			frameMain.chuyenTab(cm);
		} else if (cm.equals("Xe máy")) {
			frameMain.chuyenTab(cm);
		} else if (cm.equals("Đơn hàng")) {
			frameMain.chuyenTab(cm);
		} else if (cm.equals("Khách hàng")) {
			frameMain.chuyenTab(cm);
		} else if (cm.equals("Nhân viên")) {
			frameMain.chuyenTab(cm);
		} else if (cm.equals("Thống kê")) {
			frameMain.chuyenTab(cm);
		} else if (cm.equals("Thông tin")) {
			frameMain.chuyenTab(cm);
		} 
	}

	

}
