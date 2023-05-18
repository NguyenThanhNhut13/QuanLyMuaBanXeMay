USE [master]

go
CREATE DATABASE MotobikesManagement
go
use MotobikesManagement
go 
CREATE TABLE Motobike(
	motobike_ID nvarchar(50) NOT NULL,
	motobike_Name nvarchar(50) NOT NULL,
	motobike_Manufacturer nvarchar(100) NULL,
	motobike_Capacity float NULL,
	motobike_Color nvarchar(50) NULL,
	mType_ID nvarchar(50) NOT NULL,
	motobike_Price float NULL,
	motobike_Quantity int NULL,
	motobike_ManufacturingYear int NULL,
	
	CONSTRAINT PK_Product 
	PRIMARY KEY CLUSTERED(motobike_ID ASC)
)

go 
CREATE TABLE MotobikeType (
	mType_ID nvarchar(50) NOT NULL,
	mType_Name nvarchar(50) NOT NULL,

	CONSTRAINT PK_ProductType 
	PRIMARY KEY CLUSTERED(mType_ID ASC)
)



go
CREATE TABLE Orders(
	order_ID nvarchar(50) NOT NULL,
	order_Date date NULL,
	staff_ID nvarchar(50) NOT NULL,
	customer_ID nvarchar(50) NOT NULL,
	order_Amount float NOT NULL,
	order_Status nvarchar(50) NOT NULL,
	order_Note nvarchar(100) NULL,
	CONSTRAINT PK_Orders PRIMARY KEY CLUSTERED(
	order_ID ASC 
	)
)

go
CREATE TABLE OrderDetail(
	order_ID nvarchar(50) NOT NULL,
	motobike_ID nvarchar(50) NOT NULL,
	quantity int,
	price float NULL
	
CONSTRAINT PK_OrderDetail PRIMARY KEY CLUSTERED(
	order_ID ASC,
	motobike_ID ASC
	)
)

go
CREATE TABLE Staff(
	staff_ID nvarchar(50) NOT NULL,
	account_ID nvarchar(50) NOT NULL,
	account_Password nvarchar(255) NOT NULL,
	staff_Name nvarchar(50) NULL,
	staff_Gender nvarchar(5) NULL,
	staff_DateOfBirth Date,
	staff_Address nvarchar(50) NULL,
	staff_Email nvarchar(50) NULL,
	staff_Salary float,
	staff_Phone nvarchar(13) NULL,
	staff_Position nvarchar(50) NULL,
	staff_Note nvarchar(50) NULL,
	
CONSTRAINT PK_Staff PRIMARY KEY CLUSTERED(
	staff_ID ASC 
)
)


go
CREATE TABLE Customers(
	customer_ID nvarchar(50) NOT NULL,
	customer_Name nvarchar(50) NULL,
	customer_Gender nvarchar(5) NULL,
	customer_DateOfBirth date NULL,
	customer_Phone nvarchar(13) NULL,
	customer_Address nvarchar(50) NULL,
CONSTRAINT PK_Customer PRIMARY KEY CLUSTERED(
	customer_ID ASC 
)
)

--Set độ dài tối đa cho các chuỗi có chứa khoảng trắng 
GO
SET ANSI_PADDING ON
GO

--Thêm ràng buộc khóa ngoại cho các bảng 
	-- Motobike - MotobikeType
GO
ALTER TABLE [dbo].[Motobike]  WITH CHECK ADD  CONSTRAINT [FK_Motobike_mType] FOREIGN KEY([mType_ID])
REFERENCES [dbo].[MotobikeType] ([mType_ID])
ON UPDATE CASCADE
ON DELETE CASCADE

	-- Orders - OrderDetail
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_Orders_OrderDetail] FOREIGN KEY([order_ID])
REFERENCES [dbo].[Orders] ([order_ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_Orders_OrderDetail]

	-- OrderDetail - Motobike
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_Motobike_OrderDetail] FOREIGN KEY([motobike_ID])
REFERENCES [dbo].[Motobike] ([motobike_ID])
ON UPDATE CASCADE
ON DELETE CASCADE

GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_Motobike_OrderDetail]
GO

	-- Orders - Customer
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Customer] FOREIGN KEY([customer_ID])
REFERENCES [dbo].[Customers] ([customer_ID])
ON UPDATE CASCADE
ON DELETE CASCADE


GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Customer]

	--Orders - Staff
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Staff] FOREIGN KEY([staff_ID])
REFERENCES [dbo].[Staff] ([staff_ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Staff]



--Set trạng thái có thể đọc và ghi dữ liệu vào db
GO
ALTER DATABASE [MotobikesManagement] SET  READ_WRITE 
GO



-- INSERT VALUES
select * from MotobikeType
select * from Motobike 

---------------------------
go
insert into dbo.MotobikeType(mType_ID, mType_Name) values ('loaixe1',N'xe mới');
insert into dbo.MotobikeType(mType_ID, mType_Name) values ('LX01',N'Xe số');
insert into dbo.MotobikeType(mType_ID, mType_Name) values ('LX02',N'Xe tay ga');
insert into dbo.MotobikeType(mType_ID, mType_Name) values ('LX03',N'Xe côn tay');
insert into dbo.MotobikeType(mType_ID, mType_Name) values ('LX04',N'Xe mô tô');
------------------------
go
insert into dbo.Motobike(motobike_ID, motobike_Name, motobike_Manufacturer, motobike_Capacity, motobike_Color, mType_ID, motobike_Price, motobike_Quantity, motobike_ManufacturingYear)
	 values ('MSX001','Honda Wave RSX', 'Honda', 109, N'Đỏ', 'LX01', 22000000,200,2002),
			('MSX002','Wave Alpha 110cc', 'Honda', 109.1, N'Xanh', 'LX01', 18190000, 300, 2002),
			('MSX003','Super Cub C125', 'Honda', 123.94, N'Đỏ', 'LX01', 87890000,200,2000),
			('MSX004','Blade 2023', 'Honda', 109.1, N'Đen', 'LX01', 19250000,500,2004),
			('MSX005','Sh Mode 125cc', 'Honda', 124.8,  N'Đỏ', 'LX02', 58190000, 200,2004),
			('MSX006','Vision', 'Honda', 109.5, N'Đen', 'LX02', 31690000,500,2012),
			('MSX007','Yamaha Mio M3 125', 'Yamaha', 125, N'Đen', 'LX02', 31950000,100,2017),
			('MSX008','Piaggio Libery #25 ', 'Piaggio', 125, N'Trắng', 'LX02', 61900000, 400,2015),
			('MSX009','Bluera Bike 110cc MSX', ' Bluera Bike', 110, N'Xanh', 'LX03', 26050000,200,2015),
			('MSX010','Winner X', 'Honda', 149.1, N'Đen', 'LX03', 50050000,100,2023),
			('MSX011','CB150R The Streetster', 'Honda', 149.2, N'Đen', 'LX03', 105250000, 90, 2023),
			('MSX012','CBR150R', 'Honda', 149.2, N'Đen', 'LX03', 73250000, 300,2022),
			('MSX013','Africa Twin 2023', 'Honda', 1084, N'Đen', 'LX04', 590250000,50,2023),
			('MSX014','Yamaha R14', 'Yamaha', 998 , N'Đen', 'LX04', 1200250000,20,2023),
			('MSX015','Yamaha R15', 'Yamaha', 155, N'Xanh', 'LX04', 72250000,100,2023)

select * from Motobike

 ----------------------
 UPDATE Motobike set motobike_Quantity = 20 where motobike_ID = N'MSX014'
	
	
 -- INSERT VALUES Staff
 INSERT INTO Staff VALUES ('NV001', 'NV001', '123456789', N'Nguyễn Thanh Nhứt', N'Nam', '2003-10-13', N'Long An', 'thanhnhutcu@gmail.com', 50000000, '0901407421', N'Chủ tịch', N'Đang làm'),
						  ('NV002', 'NV002', '123456789',N'Nguyễn Thanh Phới', N'Nam', '2003-03-10', N'Đồng Tháp', 'nguyenthanhphoi2003@gmail.com', 45000000, '0878085650', N'Giám đốc', N'Đang làm'),
						  ('NV003', 'NV003', '123456789',N'Lê Thị Ngọc Mai', N'Nữ', '2002-02-15', N'TPHCM', 'lethingocmai15022002@gmail.com', 40000000, '0352594707', N'Phó Giám đốc', N'Đang làm'),
						  ('NV004', 'NV004', '123456789', N'Trương Nhật Đông', N'Nam', '2003-05-17', N'Long An', 'truongnhatdong4@gmail.com', 35000000, '0909090909', N'Quản lý', N'Đang làm')
						 
select * from Staff					


-- INSERT VALUES Customer
INSERT INTO Customers VALUES ('KH001', N'Nguyễn Văn A', N'Nam', '1990-01-01', '0987654321', N'Hà Nội'),
							 ('KH002', N'Trần Thị B',   N'Nữ',  '1995-06-30', '0912345678', N'Hồ Chí Minh'),
							 ('KH003', N'Lê Văn C',     N'Nam', '1985-12-15', '0911111111', N'Đà Nẵng'),
							 ('KH004', N'Hoàng Thị D',  N'Nữ',  '1998-03-22', '0977777777', N'Hải Phòng'),
							 ('KH005', N'Phạm Văn E',   N'Nam', '1992-09-10', '0966666666', N'Nha Trang')

Select* from Customers


-- INSERT VALUES Orders  
INSERT INTO Orders VALUES ('HD001', '2022-02-12', 'NV001', 'KH001', 62190000, N'Đã hoàn thành', N''),
						  ('HD002', '2022-02-21', 'NV002', 'KH002', 1790500000, N'Đã hoàn thành', N''),
						  ('HD003', '2022-04-01', 'NV003', 'KH004', 73250000, N'Đã hủy', N'Cá tháng tư'),
						  ('HD004', '2022-06-18', 'NV004', 'KH003', 44000000, N'Đã hoàn thành', N''),
						  ('HD005', '2022-08-03', 'NV001', 'KH005', 63380000, N'Đã hoàn thành', N''),
						  ('HD006', '2022-09-01', 'NV002', 'KH002', 22000000, N'Đã hoàn thành', N''),
						  ('HD007', '2022-10-12', 'NV003', 'KH003', 44000000, N'Đã hoàn thành', N''),
						  ('HD008', '2022-12-02', 'NV004', 'KH001', 77000000, N'Đã hủy', N''),
						  ('HD009', '2023-01-04', 'NV001', 'KH005', 63380000, N'Đã hoàn thành', N''),
						  ('HD010', '2023-01-21', 'NV002', 'KH001', 22000000, N'Đã hoàn thành', N''),
						  ('HD011', '2023-02-16', 'NV003', 'KH004', 44000000, N'Đã hoàn thành', N''),
						  ('HD012', '2023-03-09', 'NV004', 'KH003', 77000000, N'Đã hủy', N'')


-- INSERT VALUES OrderDetail
INSERT INTO OrderDetail VALUES ('HD001', 'MSX001', 2, 22000000),
							   ('HD001', 'MSX002', 1, 18190000),
							   ('HD002', 'MSX013', 1, 590250000),
							   ('HD002', 'MSX014', 1, 1200250000),
							   ('HD003', 'MSX012', 1, 73250000),
							   ('HD004', 'MSX001', 2, 22000000),
							   ('HD005', 'MSX006', 2, 31690000),
							   ('HD006', 'MSX001', 1, 22000000),
							   ('HD007', 'MSX001', 2, 22000000),
							   ('HD008', 'MSX004', 4, 19250000),
							   ('HD009', 'MSX012', 1, 73250000),
							   ('HD010', 'MSX012', 2, 73250000),
							   ('HD011', 'MSX012', 1, 73250000),
							   ('HD012', 'MSX013', 1, 590250000)

select * from OrderDetail
select * from Orders


/*
SELECT * FROM OrderDetail WHERE staff_ID = 'NV001'
SELECT * FROM Orders
SELECT * FROM OrderDetail
select * from OrderDetail Where order_Status = '' AND
order_ID IN (Select order_ID from Orders where order_Amount between 10000000 and 30000000)

insert into Orders Values('HD0001','2023-01-01', 'MSX000001', 10, 22000000 )

insert into OrderDetail Values ('HD0001','NV001','KH001','mẫu custom','Đã xác nhận')
*/

