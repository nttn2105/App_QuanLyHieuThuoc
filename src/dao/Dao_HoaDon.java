package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.NhanVien;
import entity.Thuoc;

public class Dao_HoaDon {
	public void Dao_HoaDon() {
		
	}
	
	public boolean addHoaDon(HoaDon hd) {
		Connection connect = null;
	    PreparedStatement stmt = null;
		int n = 0;
		try {
			
	        connect = ConnectDB.getConnection();
			stmt = connect.prepareStatement("INSERT INTO HoaDon VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, hd.getMaHD());
			stmt.setTimestamp(2, Timestamp.valueOf(hd.getNgayLap().atStartOfDay()));
			stmt.setString(3, hd.getNhanVien().getMaNV());
			stmt.setString(4, hd.getKhachHang().getMaKH());
			stmt.setFloat(5, hd.getTongTien());
			stmt.setString(6, hd.getLoaiHD());
			stmt.setString(7, hd.getKhuyenMai().getMaKM());
			stmt.setFloat(8, hd.getThue());
			stmt.setString(9, hd.getGhiChu());
			n = stmt.executeUpdate();
			if (addChiTietHoaDon(hd)) {
				return n>0;
			}else {
				removeHoaDon(hd.getMaHD());
			}
		}  catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng kết nối và statement để tránh lãng phí tài nguyên
	        try {
	            if (stmt != null) stmt.close();
	            if (connect != null) {
	            	ConnectDB.close(connect);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return n>0;
	}
	
	public boolean removeHoaDon(String maHD) {
		Connection connect = null;
	    PreparedStatement stmt = null;
		int n = 0;
		try {
			connect = ConnectDB.getConnection();
			stmt = connect.prepareStatement("DELETE FROM HoaDon WHERE maHD = ?");
			stmt.setString(1, maHD);
			n = stmt.executeUpdate();
		}  catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng kết nối và statement để tránh lãng phí tài nguyên
	        try {
	            if (stmt != null) stmt.close();
	            if (connect != null) {
	            	ConnectDB.close(connect);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return n>0;
	}
	
	public boolean addChiTietHoaDon(HoaDon hd) {
		Connection connect = null;
	    PreparedStatement stmt = null;
		int n = 0;
		try {
	        connect = ConnectDB.getConnection();
	        List<ChiTietHoaDon> listCTHD = hd.getChiTietHoaDon();
	        for (ChiTietHoaDon cthd : listCTHD) {
	        	stmt = connect.prepareStatement("INSERT INTO ChiTietHoaDon VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
				stmt.setString(1, hd.getMaHD());
				stmt.setString(2, cthd.getMaThuoc());
				stmt.setString(3, cthd.getTenThuoc());
				stmt.setInt(4, cthd.getSoLuong());
				stmt.setString(5, cthd.getDonViTinh());
				stmt.setFloat(6, cthd.getGia());
				stmt.setFloat(7, cthd.getKhuyenMai());
				stmt.setFloat(8, cthd.getTongTienSanPham());

				n = stmt.executeUpdate();
	        }
			
		}  catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng kết nối và statement để tránh lãng phí tài nguyên
	        try {
	            if (stmt != null) stmt.close();
	            if (connect != null) {
	            	ConnectDB.close(connect);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return n>0;
	}
	
	public List<ChiTietHoaDon> readChiTietHoaDonFromSQLByMaHD(String maHD){
		Connection connect = null;
	    PreparedStatement stmt = null;
	    List<ChiTietHoaDon> listCTHD = new ArrayList();
		try {
	        connect = ConnectDB.getConnection();
			Statement stt = connect.createStatement();
	        stmt = connect.prepareStatement("SELECT * FROM ChiTietHoaDon WHERE maHD = ?");
			stmt.setString(1, maHD);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChiTietHoaDon cthd = new ChiTietHoaDon(rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getFloat(6),
						rs.getFloat(7),
						rs.getFloat(8)
						);
				listCTHD.add(cthd);
			}
		}  catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng kết nối và statement để tránh lãng phí tài nguyên
	        try {
	            if (stmt != null) stmt.close();
	            if (connect != null) {
	            	ConnectDB.close(connect);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		return listCTHD;
	}
	
	public List<HoaDon> readHoaDonFromSQL(){
		Connection connect = null;
	    PreparedStatement stmt = null;
	    List<HoaDon> listHD = new ArrayList();
		try {
	        connect = ConnectDB.getConnection();
			Statement stt = connect.createStatement();
			ResultSet rs = stt.executeQuery("SELECT * FROM HoaDon");
			while (rs.next()) {
				NhanVien nv = (new Dao_NhanVien()).findNhanVienByMaNV(rs.getString(3));
				KhachHang kh = (new Dao_KhachHang()).findKhachHangByMaKH(rs.getString(4));
				KhuyenMai km = new KhuyenMai();
				HoaDon hd = new HoaDon(rs.getString(1),
						rs.getDate(2).toLocalDate(),
						rs.getFloat(5),
						rs.getString(6),
						rs.getFloat(8),
						rs.getString(9)
					);
				hd.setNhanVien(nv);
				hd.setKhachHang(kh);
				hd.setKhuyenMai(km);
				listHD.add(hd);
			}
		}  catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng kết nối và statement để tránh lãng phí tài nguyên
	        try {
	            if (stmt != null) stmt.close();
	            if (connect != null) {
	            	ConnectDB.close(connect);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		return listHD;
	}
	
	public HoaDon findHoaDonByMaHD(String maHD) {
	    Connection connect = null;
	    PreparedStatement stmt = null;
	    HoaDon hd = null;
	    try {
	        connect = ConnectDB.getConnection();
	        stmt = connect.prepareStatement("SELECT * FROM HoaDon WHERE maHD = ?");
	        stmt.setString(1, maHD); // Thiết lập giá trị cho tham số maThuoc

	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	NhanVien nv = (new Dao_NhanVien()).findNhanVienByMaNV(rs.getString(3));
	        	KhachHang kh = (new Dao_KhachHang()).findKhachHangByMaKH(rs.getString(4));
	            KhuyenMai km = new KhuyenMai();
	            List<ChiTietHoaDon> listCTHD = readChiTietHoaDonFromSQLByMaHD(maHD);
	        	hd = new HoaDon(rs.getString(1),
	                    rs.getDate(2).toLocalDate(),
	                    rs.getFloat(5),
	                    rs.getString(6),
	                    rs.getFloat(8),
	                    rs.getString(9)
	            );
	        	hd.setNhanVien(nv);
	        	hd.setKhachHang(kh);
	        	hd.setKhuyenMai(km);
	        	hd.setChiTietHoaDon(listCTHD);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng kết nối và statement để tránh lãng phí tài nguyên
	        try {
	            if (stmt != null) stmt.close();
	            if (connect != null) {
	                ConnectDB.close(connect);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return hd;
	}
	
	public String autoCreateMaHD() {
		Connection connect = null;
	    PreparedStatement stmt = null;
	    String maHD = null;
	    try {
	        connect = ConnectDB.getConnection();
            Statement stm = connect.createStatement();
            ResultSet rs = stm.executeQuery("DECLARE @TodayDate AS DATE = GETDATE(),\r\n"
            		+ "        @Prefix AS VARCHAR(8),\r\n"
            		+ "        @NextNumber AS INT;\r\n"
            		+ "SET @Prefix = 'HD' + \r\n"
            		+ "              FORMAT(@TodayDate, 'dd') + \r\n"
            		+ "              FORMAT(@TodayDate, 'MM') + \r\n"
            		+ "              RIGHT(YEAR(@TodayDate), 2);\r\n"
            		+ "SELECT @NextNumber = ISNULL(MAX(CAST(SUBSTRING(maHD, 9, 4) AS INT)), 0) + 1\r\n"
            		+ "FROM [dbo].[HoaDon]\r\n"
            		+ "WHERE maHD LIKE @Prefix + '%';\r\n"
            		+ "SELECT @Prefix + FORMAT(@NextNumber, '0000');");
            while(rs.next()) {
                maHD = rs.getString(1);
            }
	    }  catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng kết nối và statement để tránh lãng phí tài nguyên
	        try {
	            if (stmt != null) stmt.close();
	            if (connect != null) {
	            	ConnectDB.close(connect);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
        return maHD;
    }
	
	public List<Integer> getListYearOfOrder(){
		Connection connect = null;
	    PreparedStatement stmt = null;
	    List<Integer> listNam = new ArrayList<>();
	    try {
	        connect = ConnectDB.getConnection();
            Statement stm = connect.createStatement();
            ResultSet rs = stm.executeQuery("SELECT DISTINCT YEAR(ngayLap) AS nam\r\n"
            		+ "FROM HoaDon\r\n"
            		+ "ORDER BY nam DESC;");
            while(rs.next()) {
                listNam.add(rs.getInt(1));
            }
	    }  catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Đóng kết nối và statement để tránh lãng phí tài nguyên
	        try {
	            if (stmt != null) stmt.close();
	            if (connect != null) {
	            	ConnectDB.close(connect);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
        return listNam;
	}
}
