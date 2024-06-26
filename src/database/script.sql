
USE [QLBT]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 4/20/2024 12:28:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHD] [nvarchar](12) NOT NULL,
	[maThuoc] [nvarchar](7) NOT NULL,
	[tenThuoc] [nvarchar](50) NULL,
	[soLuong] [int] NULL,
	[donViTinh] [nvarchar](25) NULL,
	[gia] [float] NULL,
	[khuyenMai] [float] NULL,
	[tongTien] [float] NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 4/20/2024 12:28:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [nvarchar](12) NOT NULL,
	[ngayLap] [datetime] NULL,
	[maNV] [nvarchar](8) NOT NULL,
	[maKH] [nvarchar](12) NOT NULL,
	[tongTien] [float] NULL,
	[loaiHD] [nvarchar](30) NULL,
	[maKMHD] [nvarchar](25) NULL,
	[thue] [float] NULL,
	[ghiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/20/2024 12:28:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [nvarchar](12) NOT NULL,
	[hoTen] [nvarchar](50) NULL,
	[soDienThoai] [nvarchar](11) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 4/20/2024 12:28:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[maKM] [nvarchar](25) NOT NULL,
	[ngayBatDau] [datetime] NULL,
	[ngayKetThuc] [datetime] NULL,
	[tyleKM] [float] NULL,
	[loaiKM] [nvarchar](30) NOT NULL,
	[giaTriKhuyenMai] [float] NULL,
 CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[maKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/20/2024 12:28:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [nvarchar](8) NOT NULL,
	[hoTen] [nvarchar](50) NULL,
	[gioiTinh] [nvarchar](3) NULL,
	[soDienThoai] [nvarchar](11) NULL,
	[ngaySinh] [datetime] NULL,
	[ngayVaoLam] [datetime] NULL,
	[chucVu] [nvarchar](25) NULL,
	[soCCCD] [nvarchar](12) NULL,
	[diaChi] [nvarchar](50) NULL,
	[trangThai] [nvarchar](50) NULL,
	[anh] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 4/20/2024 12:28:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenTaiKhoan] [nvarchar](8) NOT NULL,
	[matKhau] [nvarchar](50) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[tenTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thuoc]    Script Date: 4/20/2024 12:28:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thuoc](
	[maThuoc] [nvarchar](7) NOT NULL,
	[tenThuoc] [nvarchar](50) NULL,
	[ngayNhapVe] [datetime] NULL,
	[ngayHetHan] [datetime] NULL,
	[ngaySanXuat] [datetime] NULL,
	[noiSanXuat] [nvarchar](50) NULL,
	[gia] [float] NULL,
	[donViTinh] [nvarchar](25) NULL,
	[thanhPhan] [nvarchar](100) NULL,
	[soLuong] [int] NULL,
	[maKMSP] [nvarchar](25) NULL,
PRIMARY KEY CLUSTERED 
(
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[KhachHang] ([maKH], [hoTen], [soDienThoai]) VALUES (N'KH1504240001', N'Thắng', N'0354830957')
GO
INSERT [dbo].[KhuyenMai] ([maKM], [ngayBatDau], [ngayKetThuc], [tyleKM], [loaiKM], [giaTriKhuyenMai]) VALUES (N'KM01', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), 0.5, N'Khuyến mãi trên sản phẩm', 0)
INSERT [dbo].[KhuyenMai] ([maKM], [ngayBatDau], [ngayKetThuc], [tyleKM], [loaiKM], [giaTriKhuyenMai]) VALUES (N'KM02', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), 1, N'Khuyến mãi trên sản phẩm', 0)
INSERT [dbo].[KhuyenMai] ([maKM], [ngayBatDau], [ngayKetThuc], [tyleKM], [loaiKM], [giaTriKhuyenMai]) VALUES (N'KM03', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), 2, N'Khuyến mãi trên sản phẩm', 0)
INSERT [dbo].[KhuyenMai] ([maKM], [ngayBatDau], [ngayKetThuc], [tyleKM], [loaiKM], [giaTriKhuyenMai]) VALUES (N'KM04', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), 3, N'Khuyến mãi trên sản phẩm', 0)
INSERT [dbo].[KhuyenMai] ([maKM], [ngayBatDau], [ngayKetThuc], [tyleKM], [loaiKM], [giaTriKhuyenMai]) VALUES (N'KM05', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), 1, N'Khuyến mãi trên sản phẩm', 0)
INSERT [dbo].[KhuyenMai] ([maKM], [ngayBatDau], [ngayKetThuc], [tyleKM], [loaiKM], [giaTriKhuyenMai]) VALUES (N'KM06', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), 1, N'Khuyến mãi trên sản phẩm', 0)
INSERT [dbo].[KhuyenMai] ([maKM], [ngayBatDau], [ngayKetThuc], [tyleKM], [loaiKM], [giaTriKhuyenMai]) VALUES (N'KM07', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), 1, N'Khuyến mãi trên sản phẩm', 0)
INSERT [dbo].[KhuyenMai] ([maKM], [ngayBatDau], [ngayKetThuc], [tyleKM], [loaiKM], [giaTriKhuyenMai]) VALUES (N'KM08', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), 1, N'Khuyến mãi trên sản phẩm', 0)
INSERT [dbo].[KhuyenMai] ([maKM], [ngayBatDau], [ngayKetThuc], [tyleKM], [loaiKM], [giaTriKhuyenMai]) VALUES (N'KM09', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), 1, N'Khuyến mãi trên sản phẩm', 0)
INSERT [dbo].[KhuyenMai] ([maKM], [ngayBatDau], [ngayKetThuc], [tyleKM], [loaiKM], [giaTriKhuyenMai]) VALUES (N'KM10', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), 1, N'Khuyến mãi trên hóa đơn', 0)
INSERT [dbo].[KhuyenMai] ([maKM], [ngayBatDau], [ngayKetThuc], [tyleKM], [loaiKM], [giaTriKhuyenMai]) VALUES (N'KM11', CAST(N'2024-02-13T00:00:00.000' AS DateTime), CAST(N'2024-07-13T00:00:00.000' AS DateTime), 0.30000001192092896, N'Khuyến mãi trên hóa đơn', 0)
INSERT [dbo].[KhuyenMai] ([maKM], [ngayBatDau], [ngayKetThuc], [tyleKM], [loaiKM], [giaTriKhuyenMai]) VALUES (N'KM12', CAST(N'2021-08-13T00:00:00.000' AS DateTime), CAST(N'2023-12-08T00:00:00.000' AS DateTime), 1, N'Khuyến mãi trên hóa đơn', 0)
GO
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [soDienThoai], [ngaySinh], [ngayVaoLam], [chucVu], [soCCCD], [diaChi], [trangThai], [anh]) VALUES (N'NV000000', N'ADMIN', N'', N'', CAST(N'2024-04-19T00:00:00.000' AS DateTime), CAST(N'2024-04-19T00:00:00.000' AS DateTime), N'ADMIN', N'', N'', N'', N'images/avatar-default.png')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [soDienThoai], [ngaySinh], [ngayVaoLam], [chucVu], [soCCCD], [diaChi], [trangThai], [anh]) VALUES (N'NV241001', N'123', N'Nam', N'123', CAST(N'2024-04-19T00:00:00.000' AS DateTime), CAST(N'2024-04-19T00:00:00.000' AS DateTime), N'Quản Lý', N'123', N'123', N'Làm Việc', N'images\imagesAvatarNV\NV241001.jpg')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [gioiTinh], [soDienThoai], [ngaySinh], [ngayVaoLam], [chucVu], [soCCCD], [diaChi], [trangThai], [anh]) VALUES (N'NV241002', N'123', N'Nam', N'123', CAST(N'2024-04-19T00:00:00.000' AS DateTime), CAST(N'2024-04-19T00:00:00.000' AS DateTime), N'Quản Lý', N'123', N'123', N'Làm Việc', N'images\imagesAvatarNV\NV241003.jpg')
GO
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau]) VALUES (N'NV000000', N'+jEAhpy4W5LulqmnmT1xXQ==')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau]) VALUES (N'NV241001', N'pnRmmeKGpDsGDFPJsudQ1g==')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau]) VALUES (N'NV241002', N'RYPyCiLdTCGDDwrRh4GWMg==')
GO
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [ngayNhapVe], [ngayHetHan], [ngaySanXuat], [noiSanXuat], [gia], [donViTinh], [thanhPhan], [soLuong], [maKMSP]) VALUES (N'PRD001', N'Paradon', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), N'Việt Nam', 10000, N'Hộp', N'.', 2, NULL)
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [ngayNhapVe], [ngayHetHan], [ngaySanXuat], [noiSanXuat], [gia], [donViTinh], [thanhPhan], [soLuong], [maKMSP]) VALUES (N'PRDH001', N'Paradon', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), N'Việt Nam', 10000, N'Hộp', N'.', 4, NULL)
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [ngayNhapVe], [ngayHetHan], [ngaySanXuat], [noiSanXuat], [gia], [donViTinh], [thanhPhan], [soLuong], [maKMSP]) VALUES (N'PRDV001', N'Paradon', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), N'Việt Nam', 10000, N'Vỉ', N'.', 5, NULL)
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [ngayNhapVe], [ngayHetHan], [ngaySanXuat], [noiSanXuat], [gia], [donViTinh], [thanhPhan], [soLuong], [maKMSP]) VALUES (N'PRDV002', N'Paradon', CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), CAST(N'2024-04-13T00:00:00.000' AS DateTime), N'Việt Nam', 10000, N'Vỉ', N'.', 10, NULL)
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [ngayNhapVe], [ngayHetHan], [ngaySanXuat], [noiSanXuat], [gia], [donViTinh], [thanhPhan], [soLuong], [maKMSP]) VALUES (N'PRDV003', N'Paradon', CAST(N'2024-04-14T00:00:00.000' AS DateTime), CAST(N'2024-04-14T00:00:00.000' AS DateTime), CAST(N'2024-04-14T00:00:00.000' AS DateTime), N'Việt Nam', 10000, N'Vỉ', N'.', 10, NULL)
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [ngayNhapVe], [ngayHetHan], [ngaySanXuat], [noiSanXuat], [gia], [donViTinh], [thanhPhan], [soLuong], [maKMSP]) VALUES (N'PRDV004', N'Paradon', CAST(N'2024-04-14T00:00:00.000' AS DateTime), CAST(N'2024-04-14T00:00:00.000' AS DateTime), CAST(N'2024-04-14T00:00:00.000' AS DateTime), N'Việt Nam', 10000, N'Hộp', N'.', 10, NULL)
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [ngayNhapVe], [ngayHetHan], [ngaySanXuat], [noiSanXuat], [gia], [donViTinh], [thanhPhan], [soLuong], [maKMSP]) VALUES (N'PRDV005', N'Paradon', CAST(N'2024-04-14T00:00:00.000' AS DateTime), CAST(N'2024-04-14T00:00:00.000' AS DateTime), CAST(N'2024-04-15T00:00:00.000' AS DateTime), N'Việt Nam', 10000, N'Hộp', N'.', 7, NULL)
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [ngayNhapVe], [ngayHetHan], [ngaySanXuat], [noiSanXuat], [gia], [donViTinh], [thanhPhan], [soLuong], [maKMSP]) VALUES (N'PRDV006', N'Paradon', CAST(N'2024-04-14T00:00:00.000' AS DateTime), CAST(N'2024-04-15T00:00:00.000' AS DateTime), CAST(N'2024-04-14T00:00:00.000' AS DateTime), N'Việt Nam', 10000, N'Vỉ', N'.', 8, NULL)
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhuyenMai] FOREIGN KEY([maKMHD])
REFERENCES [dbo].[KhuyenMai] ([maKM])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhuyenMai]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([tenTaiKhoan])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
ALTER TABLE [dbo].[Thuoc]  WITH CHECK ADD  CONSTRAINT [FK_Thuoc_KhuyenMai] FOREIGN KEY([maKMSP])
REFERENCES [dbo].[KhuyenMai] ([maKM])
GO
ALTER TABLE [dbo].[Thuoc] CHECK CONSTRAINT [FK_Thuoc_KhuyenMai]
GO
USE [master]
GO
ALTER DATABASE [QLBT] SET  READ_WRITE 
GO
