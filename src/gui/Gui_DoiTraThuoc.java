package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import javax.swing.border.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.Dao_HoaDon;
import dao.Dao_NhanVien;
import dao.Dao_Thuoc;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.NhanVien;
import entity.Thuoc;
import utils.ButtonDeleteEditor;
import utils.ButtonDeleteRenderer;
import utils.RadioButtonEditor;
import utils.RadioButtonRenderer;

public class Gui_DoiTraThuoc extends JPanel{
	private int widthComp, heightComp;
	private JPanel pLeft;
	private JPanel pSearch;
	private JTextField txtTim;
	private JPanel pInforOrderDetail;
	private JLabel lbl1;
	private JLabel lbl2;
	private JButton btnTim;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JPanel pRight;
	private DefaultTableModel dataModel;
	private JTable tableModel;
	private JPanel pMain;
	private JPanel pWest;
	private JLabel lbl7;
	private JRadioButton radTraThuoc;
	private JLabel lbl8;
	private JRadioButton radDoiThuoc;
	private JLabel lbl9;
	private JLabel lbl10;
	private JTextField txtLyDo;
	private JLabel lbl11;
	private JButton btnTaoLaiHoaDon;
	private JPanel pAction;
	private JPanel pTable;
	private ButtonGroup radGroup;
	private HoaDon hd;
	private NhanVien nv;

	public Gui_DoiTraThuoc(NhanVien nv, int widthComp, int heightComp) {
		this.widthComp = widthComp;
		this.heightComp = heightComp;
		this.nv = nv;
		this.setLayout(new BorderLayout());
		initCompoent();
	}
	
	public void initCompoent() {
		pSearch = new JPanel();
		pMain = new JPanel();
		pLeft = new JPanel();
		txtTim = new JTextField(15);
		btnTim = new JButton();
		pInforOrderDetail = new JPanel();
		lbl1 = new JLabel();
		lbl2 = new JLabel();
		lbl3 = new JLabel();
		lbl4 = new JLabel();
		lbl5 = new JLabel();
		lbl6 = new JLabel();
		pRight = new JPanel();
		pTable = new JPanel();
		lbl7 = new JLabel();
		String headers[] = {"Chọn", "Mã thuốc", "Tên thuốc", "Số lượng", "Đơn vị tính", "Giá", "Khuyến mãi", "Tổng tiền"};
		dataModel = new DefaultTableModel(headers, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Đặt tất cả các ô không thể chỉnh sửa
                return column==0;
            }
        };
		tableModel = new JTable(dataModel);
		tableModel.getColumn("Chọn").setPreferredWidth(10);
		tableModel.getColumn("Chọn").setCellRenderer(new RadioButtonRenderer());
		tableModel.getColumn("Chọn").setCellEditor(new RadioButtonEditor(new JCheckBox()));
		tableModel.getTableHeader().setFont(new Font("Arial", Font.BOLD, 17));
		tableModel.setFont(new Font("Arial", Font.PLAIN, 13));
		tableModel.setRowHeight(30);
		JScrollPane pane = new JScrollPane(tableModel);
		pAction = new JPanel();
		radTraThuoc = new JRadioButton();
		lbl8 = new JLabel();
		radDoiThuoc = new JRadioButton();
		lbl9 = new JLabel();
		radGroup = new ButtonGroup();
		lbl10 = new JLabel();
		txtLyDo = new JTextField(15);
		lbl11 = new JLabel();
		btnTaoLaiHoaDon = new JButton();
		
		this.setBackground(Color.WHITE);
		pSearch.setBackground(Color.WHITE);
		pSearch.setPreferredSize(new Dimension((int)(widthComp*0.98), (int)(heightComp*0.1)));
		pSearch.setLayout(new FlowLayout(FlowLayout.LEFT));
		pMain.setBackground(Color.WHITE);
		pMain.setPreferredSize(new Dimension((int)(widthComp*0.98), (int)(heightComp*0.85)));
		pLeft.setBackground(Color.WHITE);
		pLeft.setPreferredSize(new Dimension((int)(widthComp*0.3), (int)(heightComp*0.8)));

		txtTim.setFont(new Font ("Arial", Font.PLAIN, 20));
		btnTim.setText("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("Arial", Font.BOLD, 16));
		btnTim.setBackground(new Color(40,156,164));
		btnTim.setOpaque(true);
		btnTim.setContentAreaFilled(true);
        btnTim.setBorderPainted(false);
        btnTim.setFocusPainted(false);
		Border titledBorder = BorderFactory.createTitledBorder("Thông tin hóa đơn");
		if (titledBorder instanceof TitledBorder) {
		    Font titleFont = ((TitledBorder) titledBorder).getTitleFont();
		    Font newTitleFont = titleFont.deriveFont(titleFont.getSize() + 15f);
		    ((TitledBorder) titledBorder).setTitleFont(newTitleFont);
		}
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border compoundBorder = BorderFactory.createCompoundBorder(titledBorder, emptyBorder);
		pRight.setPreferredSize(new Dimension((int)(widthComp*0.62), (int)(heightComp*0.8)));
        pInforOrderDetail.setPreferredSize(new Dimension((int)(widthComp*0.3), (int)(heightComp*0.5)));
		pInforOrderDetail.setLayout(new BoxLayout(pInforOrderDetail, BoxLayout.Y_AXIS));
		pInforOrderDetail.setBorder(compoundBorder);
		pTable.setPreferredSize(new Dimension((int)(widthComp*0.6), (int)(heightComp*0.6)));
		pTable.setLayout(new BoxLayout(pTable, BoxLayout.Y_AXIS));
		pTable.setBorder(new EmptyBorder(10, 10, 10, 10)); // Đặt độ lề cho panel
		lbl1.setText("Mã hóa đơn:");
		lbl1.setFont(new Font("Arial:", Font.PLAIN, 23));
		lbl2.setText("Mã khách hàng:");
		lbl2.setFont(new Font("Arial:", Font.PLAIN, 23));
		lbl3.setText("Tên khách hàng:");
		lbl3.setFont(new Font("Arial", Font.PLAIN, 23));
		lbl4.setText("Tên nhân viên:");
		lbl4.setFont(new Font("Arial", Font.PLAIN, 23));
		lbl5.setText("Ngày:");
		lbl5.setFont(new Font("Arial", Font.PLAIN, 23));
		lbl6.setText("Giờ:");		
		lbl6.setFont(new Font("Arial", Font.PLAIN, 23));
		lbl7.setText("Danh sách thuốc mà khách hàng đã mua");
		lbl7.setFont(new Font("Arial", Font.BOLD, 25));
		pAction.setLayout(new FlowLayout(FlowLayout.LEFT));
		pAction.setPreferredSize(new Dimension(new Dimension((int)(widthComp*0.58), (int)(heightComp*0.2))));
		radTraThuoc.setSelected(true);
		radTraThuoc.setText("Trả thuốc");
		radTraThuoc.setFont(new Font ("Arial", Font.PLAIN, 20));
		radDoiThuoc.setText("Đổi thuốc");
		radDoiThuoc.setFont(new Font ("Arial", Font.PLAIN, 20));
		lbl10.setText("Lý do:");
		lbl10.setFont(new Font ("Arial", Font.PLAIN, 20));
		txtLyDo.setFont(new Font ("Arial", Font.PLAIN, 20));
		lbl11.setText("Số tiền được hoàn trả: " + getTotalRefund());
		lbl11.setFont(new Font ("Arial", Font.PLAIN, 20));
		btnTaoLaiHoaDon.setText("Tạo lại hóa đơn");
		btnTaoLaiHoaDon.setForeground(Color.WHITE);
		btnTaoLaiHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		btnTaoLaiHoaDon.setBackground(new Color(40,156,164));
		btnTaoLaiHoaDon.setOpaque(true);
		btnTaoLaiHoaDon.setContentAreaFilled(true);
        btnTaoLaiHoaDon.setBorderPainted(false);
        btnTaoLaiHoaDon.setFocusPainted(false);
		
		pSearch.add(Box.createHorizontalStrut(30));
		pSearch.add(txtTim);
		pSearch.add(Box.createHorizontalStrut(10));
		pSearch.add(btnTim);
		
		pInforOrderDetail.add(lbl1);
		pInforOrderDetail.add(Box.createVerticalStrut(15));
		pInforOrderDetail.add(lbl2);
		pInforOrderDetail.add(Box.createVerticalStrut(15));
		pInforOrderDetail.add(lbl3);
		pInforOrderDetail.add(Box.createVerticalStrut(15));
		pInforOrderDetail.add(lbl4);
		pInforOrderDetail.add(Box.createVerticalStrut(15));
		pInforOrderDetail.add(lbl5);
//		pInforOrderDetail.add(Box.createVerticalStrut(15));
//		pInforOrderDetail.add(lbl6);
		
		pTable.add(lbl7);
		pTable.add(Box.createVerticalStrut(20));
		pTable.add(pane);
		radGroup.add(radTraThuoc);
		radGroup.add(radDoiThuoc);
		pAction.add(radTraThuoc);
		pAction.add(lbl8);
		pAction.add(radDoiThuoc);
		pAction.add(lbl9);
		pAction.add(Box.createHorizontalStrut(100));
		pAction.add(lbl10);
		pAction.add(txtLyDo);
		pAction.add(lbl11);
		pAction.add(Box.createHorizontalStrut(1000));
		pAction.add(btnTaoLaiHoaDon);
		
		
		pLeft.add(pInforOrderDetail);
		pRight.add(pTable);
		pRight.add(pAction);
		pMain.add(pLeft);
		pMain.add(pRight);
		this.add(pSearch, BorderLayout.NORTH);
		this.add(pMain, BorderLayout.CENTER);
		
		dataModel.addTableModelListener(new TableModelListener() {
			private boolean isShowingDialog = false;

			@Override
			public void tableChanged(TableModelEvent e) {
		        if (e.getType() == TableModelEvent.UPDATE) {
		            int column = e.getColumn();
		            int row = e.getFirstRow();
		            if (column == 0 && row <= dataModel.getRowCount() - 1 ) {
		            	if (getItemSelectedRadGroup().equals("Đổi thuốc")) {
		            		if (!isShowingDialog) { // Kiểm tra xem hộp thoại đã được hiển thị hay chưa
			                    Thuoc thuoc = (new Dao_Thuoc()).getThuocByTenSoLuongDonViTinh(dataModel.getValueAt(row, 2).toString(), 
			                                Integer.parseInt(dataModel.getValueAt(row, 3).toString()), 
			                                dataModel.getValueAt(row, 4).toString());
			                    if (thuoc == null  && getItemSelectedRadGroup().equals("Đổi thuốc")) {
			                        isShowingDialog = true; // Đặt biến thành true để chỉ ra rằng hộp thoại đang được hiển thị
			                        JOptionPane.showMessageDialog(null, "Số lượng của thuốc này không còn đủ để đổi!");
			                        isShowingDialog = false; // Đặt lại biến thành false sau khi hộp thoại được đóng
			                    }
		            		}
		            	} else {
		                        lbl11.setText("Số tiền được hoàn trả: " + getTotalRefund());
		                        repaint();
		                }
		               
		            }
		        }
			}
		});
		
		radTraThuoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lbl11.getText().equals("")) {
					lbl11.setText("Số tiền được hoàn trả: " + getTotalRefund());
					repaint();
				}
			}
		});
		
		radDoiThuoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!lbl11.getText().equals("")) {
					lbl11.setText("");
				}
			}
		});
		
		btnTim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maHD = txtTim.getText();
				HoaDon hd = (new Dao_HoaDon()).findHoaDonByMaHD(maHD); 
				Gui_DoiTraThuoc.this.hd = hd;
				if(hd != null) {
					lbl1.setText("Mã hóa đơn: " + hd.getMaHD());
					lbl2.setText("Mã khách hàng: " + hd.getKhachHang().getMaKH());
					lbl3.setText("Tên khách hàng: " + hd.getKhachHang().getHoTen());
					lbl4.setText("Tên nhân viên: " + hd.getNhanVien().getHoTen());
					lbl5.setText("Ngày: " + hd.getNgayLap());
					removeDataTable();
					for (ChiTietHoaDon cthd : hd.getChiTietHoaDon()) {
						dataModel.addRow(new Object[] {false,
								cthd.getMaThuoc(),
								cthd.getTenThuoc(),
								cthd.getSoLuong()+"",
								cthd.getDonViTinh(),
								cthd.getGia()+"",
								cthd.getKhuyenMai()+"",
								cthd.getTongTienSanPham()+""});
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn này!");
				}
			}
		});
		btnTaoLaiHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HoaDon hdNew = new HoaDon();
				hdNew.setMaHD((new Dao_HoaDon()).autoCreateMaHD());
				hdNew.setKhachHang(hd.getKhachHang());
				hdNew.setNhanVien(nv);
				if (radDoiThuoc.isSelected()) {
					hdNew.setLoaiHD("Đổi thuốc");
					hdNew.setGhiChu("Đổi từ " + hd.getMaHD() + ", Lý do: " + txtLyDo.getText());
					List<Object> listThuocTrade = getListThuocTrade();
					hdNew.setChiTietHoaDon(getListCTHDDoiThuoc());
					boolean n = (new Dao_Thuoc()).setCountByMaThuoc((List<String>)listThuocTrade.get(0), (List<Integer>)listThuocTrade.get(1));
					if ( n == false) {
						JOptionPane.showMessageDialog(null, "Có lỗi xảy ra");
					}
				}else if (radTraThuoc.isSelected()) {
					hdNew.setLoaiHD("Trả thuốc");
					hdNew.setGhiChu("Trả từ " + hd.getMaHD() + ", Lý do: " + txtLyDo.getText());
					hdNew.setTongTien(getTotalRefund());
					hdNew.setChiTietHoaDon(getListCTHDTraThuoc());
				}
				hdNew.setNgayLap(LocalDate.now());
				hdNew.setKhuyenMai(hd.getKhuyenMai());
				
				if ((new Dao_HoaDon()).addHoaDon(hdNew)) {
					JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công!");
				}else {
					JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!");
				}
			}
		});
	}
	
	public List<ChiTietHoaDon> getListCTHDDoiThuoc(){
		List<Object> listThuocTrade = getListThuocTrade();
		List<String> listMaThuoc = (List<String>) listThuocTrade.get(0);
		List<Integer> listSoLuong = (List<Integer>) listThuocTrade.get(1);
		List<ChiTietHoaDon> listCTHD = new ArrayList();
		for (int i = 0 ; i < listMaThuoc.size() ; i ++) {
				ChiTietHoaDon cthd = new ChiTietHoaDon();
				cthd.setMaThuoc(listMaThuoc.get(i));
				Thuoc thuoc = (new Dao_Thuoc()).findThuocByMaThuoc(listMaThuoc.get(i));
				cthd.setGia(thuoc.getGia());
				cthd.setTenThuoc(thuoc.getTenThuoc());
				cthd.setSoLuong(listSoLuong.get(i));
				cthd.setDonViTinh(thuoc.getDonViTinh());
				listCTHD.add(cthd);
		}
		return listCTHD;
	}
	
	public List<ChiTietHoaDon> getListCTHDTraThuoc(){
		List<ChiTietHoaDon> listCTHD = new ArrayList();
		for (int i = 0 ; i < tableModel.getRowCount() ; i ++) {
			if (dataModel.getValueAt(i, 0).equals(true)) {
				ChiTietHoaDon cthd = new ChiTietHoaDon(dataModel.getValueAt(i, 1).toString(),
						dataModel.getValueAt(i, 2).toString(),
						Integer.parseInt(dataModel.getValueAt(i, 3).toString()),
						dataModel.getValueAt(i, 4).toString(),
						Float.valueOf(dataModel.getValueAt(i, 5).toString()),
						Float.valueOf(dataModel.getValueAt(i, 6).toString()),
						Float.valueOf(dataModel.getValueAt(i, 7).toString())
						);
				listCTHD.add(cthd);
			}
		}
		return listCTHD;
	}
	
	public List<Object> getListThuocTrade(){
		List<Object> list = new ArrayList<Object>();
		List<String> listMaThuoc = new ArrayList();
		List<Integer> listSoLuong = new ArrayList<Integer>();
		for (int i = 0 ; i < tableModel.getRowCount() ; i ++) {
			if (dataModel.getValueAt(i, 0).equals(true)) {
				Thuoc thuoc = (new Dao_Thuoc()).getThuocByTenSoLuongDonViTinh(dataModel.getValueAt(i, 2).toString(), 
						Integer.parseInt(dataModel.getValueAt(i, 3).toString()), 
						dataModel.getValueAt(i, 4).toString());
				listMaThuoc.add(thuoc.getMaThuoc());
				listSoLuong.add(Integer.parseInt(dataModel.getValueAt(i, 3).toString()));
			}
		}
		list.add(listMaThuoc);
		list.add(listSoLuong);
		return list;
	}
	
	public float getTotalRefund() {
		float total = 0;
		for (int i = 0 ; i < tableModel.getRowCount() ; i ++) {
			if (dataModel.getValueAt(i, 0).equals(true)) {
				total += Float.valueOf(dataModel.getValueAt(i, 7).toString());
			}
		}
		return total;
	}
	
	public String getItemSelectedRadGroup() {
		if (radDoiThuoc.isSelected()) {
			return "Đổi thuốc";
		}else if (radTraThuoc.isSelected()) {
			return "Trả thuốc";
		}
		return "";
	}
	
	public void removeDataTable() {
		while (dataModel.getRowCount() > 0) {
			dataModel.removeRow(0);
		}
	}
}
