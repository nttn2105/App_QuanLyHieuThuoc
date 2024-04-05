
USE [QLBT]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 3/30/2024 7:27:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHD] [nvarchar](12) NOT NULL,
	[maThuoc] [nvarchar](7) NOT NULL,
	[soLuong] [int],
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[HoaDon]    Script Date: 3/30/2024 7:27:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [nvarchar](12) NOT NULL,
	[ngayLap] [datetime],
	[maNV] [nvarchar](8) NOT NULL,
	[maKH] [nvarchar](10) NOT NULL,
	[tongTien] [float],
	[loaiHD] [nvarchar](30),
	[maKMHD] [nvarchar](25),
	[thue] [float],
	[ghiChu] [nvarchar](50)
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 3/30/2024 7:27:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [nvarchar](10) NOT NULL,
	[hoTen] [nvarchar](50),
	[soDienThoai] [nvarchar](11),
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 3/30/2024 7:27:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[maKM] [nvarchar](25) NOT NULL,
	[ngayBatDau] [datetime],
	[ngayKetThuc] [datetime],
	[tyleKM] [float],
	[loaiKM] [nvarchar](30) NOT NULL,
 CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[maKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 3/30/2024 7:27:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [nvarchar](8) NOT NULL,
	[hoTen] [nvarchar](50),
	[gioiTinh][nvarchar](3),
	[soDienThoai] [nvarchar](11),
	[ngaySinh] [datetime],
	[ngayVaoLam] [datetime],
	[chucVu] [nvarchar](25),
	[soCCCD] [nvarchar](12),	
	[diaChi] [nvarchar](50),
	[anh] [varbinary](max),
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 3/30/2024 7:27:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenTaiKhoan] [nvarchar](50) NOT NULL,
	[matKhau] [nvarchar](50),
	[quyen] [nvarchar](50),
	[trangThai] [int],
	[maNV] [nvarchar](8) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[tenTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thuoc]    Script Date: 3/30/2024 7:27:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thuoc](
	[maThuoc] [nvarchar](7) NOT NULL,
	[tenThuoc] [nvarchar](50),
	[ngayNhapVe] [datetime],
	[ngayHetHan] [datetime],
	[ngaySanXuat] [datetime],
	[noiSanXuat] [nvarchar](50),
	[gia] [float],
	[donViTinh] [nvarchar](25),
	[thanhPhan] [nvarchar](100),
	[soLuong] [int],
	[maKMSP] [nvarchar](25)
PRIMARY KEY CLUSTERED 
(
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_DanhSachThuoc_Thuoc] FOREIGN KEY([maThuoc])
REFERENCES [dbo].[Thuoc] ([maThuoc])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_DanhSachThuoc_Thuoc]
GO
AlTER TABLE [dbo].[Thuoc] WITH CHECK ADD CONSTRAINT [FK_Thuoc_KhuyenMai] FOREIGN KEY ([maKMSP])
REFERENCES [dbo].[KhuyenMai] ([maKM])
GO
ALTER TABLE [dbo].[Thuoc] CHECK CONSTRAINT [FK_Thuoc_KhuyenMai]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhuyenMai] FOREIGN KEY([maKMHD])
REFERENCES [dbo].[KhuyenMai] ([maKM])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhuyenMai]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
