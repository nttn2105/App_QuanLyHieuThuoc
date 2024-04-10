
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class Gui_KhuyenMai extends JPanel implements ActionListener{
	private int widthComp;
	private int heightComp;
	private JPanel pNorth;
	private JPanel pCenter;
	private JPanel pTable;
	private JPanel pBut;
	private DefaultTableModel dataModel;
	private JTable tableModel;
	private JButton btnThem;
	//private JButton btnXoa;
	private JButton btnTim;
	private JButton btnSua;
	private JTextField txtMa;
	private JTextField txtTyLe;
	private JRadioButton radTatCa;
	private JRadioButton radHD;
	private JRadioButton radKHD;
	private ButtonGroup radGroup;
	private JDateChooser ngayBatDauDate;
	private JDateChooser ngayKetThucDate;
	private JComboBox cbbLoaiKM;
	private JLayeredPane layeredPane;
	private JPanel pContent;
	private Gui_ThemKhuyenMai guiTKM;
	
	private boolean isGuiCTHDDisplayed = false;

	public Gui_KhuyenMai(int width, int height) {
		
		this.widthComp = width;
		this.heightComp = height;
		this.setLayout(new BorderLayout());
		initCompoent();
		
		
	}
	public void initCompoent() {
		pNorth = new JPanel();
		pCenter = new JPanel();
		pTable = new JPanel();
		layeredPane = new JLayeredPane();
		pContent = new JPanel();
		
		layeredPane.setOpaque(true);
        layeredPane.setPreferredSize(new Dimension(widthComp, heightComp));
        layeredPane.setBackground(Color.WHITE);
        
		pContent.setOpaque(true);
        pContent.setBounds(0,0, widthComp, heightComp);
		pContent.setBackground(Color.WHITE);
		
		
		pCenter.setLayout(new BorderLayout());
	    pNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
//	    pTable.setLayout(new FlowLayout(FlowLayout.LEFT));
	    
	    JLabel lblTitle  = new JLabel("Thông tin tìm kiếm");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblTitle.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        
        
        JPanel pInfor = new JPanel();
        pInfor.setLayout(new GridBagLayout());
		GridBagConstraints constraintsCustomer = new GridBagConstraints();
        constraintsCustomer.insets = new Insets(5, 5, 5, 5);
        
        JLabel lblMa = new JLabel("Mã khuyến mãi:");
        constraintsCustomer.gridx = 1;
        constraintsCustomer.gridy = 0;
        constraintsCustomer.anchor = GridBagConstraints.WEST;
        pInfor.add(lblMa, constraintsCustomer);
        txtMa= new JTextField(10);
        constraintsCustomer.gridx = 2;
        constraintsCustomer.gridy = 0;
        constraintsCustomer.anchor = GridBagConstraints.WEST;
        pInfor.add(txtMa,constraintsCustomer);
        
        JLabel lblTyLe = new JLabel("Tỷ lệ khuyến mãi:");
        //lblTyLe.setPreferredSize(lblMa.getPreferredSize());
        constraintsCustomer.gridx = 1;
        constraintsCustomer.gridy = 1;
        constraintsCustomer.anchor = GridBagConstraints.WEST;
        pInfor.add(lblTyLe, constraintsCustomer);
        txtTyLe= new JTextField(10);
        constraintsCustomer.gridx = 2;
        constraintsCustomer.gridy = 1;
        constraintsCustomer.anchor = GridBagConstraints.WEST;
        pInfor.add(txtTyLe,constraintsCustomer);
        
        JLabel lblTT = new JLabel("Trạng Thái:");
        radTatCa = new JRadioButton("Tất cả");
        radHD = new JRadioButton("Hoạt Động");
        radKHD = new JRadioButton("Không Hoạt Động");
        constraintsCustomer.gridx = 1;
        constraintsCustomer.gridy = 2; 
        constraintsCustomer.anchor = GridBagConstraints.WEST;
        pInfor.add(lblTT, constraintsCustomer);
        
        radGroup = new ButtonGroup();
        radGroup.add(radTatCa);
        radGroup.add(radHD);
        radGroup.add(radKHD);
        JPanel pGroup = new JPanel();
        pGroup.add(radTatCa);
        pGroup.add(radHD);
        pGroup.add(radKHD);
        constraintsCustomer.gridx = 2;
        constraintsCustomer.gridy = 2;
        constraintsCustomer.anchor = GridBagConstraints.WEST;
        pInfor.add(pGroup, constraintsCustomer);
        
        JLabel lblNBD = new JLabel("Ngày bắt đầu:");
        constraintsCustomer.gridx = 3;
        constraintsCustomer.gridy = 0; // 
        constraintsCustomer.anchor = GridBagConstraints.WEST;
        pInfor.add(lblNBD,constraintsCustomer);
        ngayBatDauDate = new JDateChooser();
        ngayBatDauDate.setPreferredSize(new Dimension(170,25));
        constraintsCustomer.gridx = 4;
        constraintsCustomer.gridy = 0;
        constraintsCustomer.anchor = GridBagConstraints.WEST;
        pInfor.add(ngayBatDauDate,constraintsCustomer);
        
        JLabel lblNKT = new JLabel("Ngày kết thúc:");
        constraintsCustomer.gridx = 3;
        constraintsCustomer.gridy = 1; 
        constraintsCustomer.anchor = GridBagConstraints.WEST;
        pInfor.add(lblNKT,constraintsCustomer);
        ngayKetThucDate  = new JDateChooser();
        ngayKetThucDate.setPreferredSize(new Dimension(170,25));
        constraintsCustomer.gridx = 4;
        constraintsCustomer.gridy = 1;
        constraintsCustomer.anchor = GridBagConstraints.WEST;
        pInfor.add(ngayKetThucDate,constraintsCustomer);
        
        JLabel lblLoaiKM = new JLabel("Loại khuyến mãi");
        constraintsCustomer.gridx = 3;
        constraintsCustomer.gridy = 2;
        constraintsCustomer.anchor = GridBagConstraints.WEST;
        pInfor.add(lblLoaiKM,constraintsCustomer);
        cbbLoaiKM = new JComboBox(new String[]{"Khuyến mãi trên hóa đơn", "Khuyến mãi trên sản phẩm"});
        cbbLoaiKM.setPreferredSize(new Dimension(200,25));
        constraintsCustomer.gridx = 4;
        constraintsCustomer.gridy = 2; 
        constraintsCustomer.anchor = GridBagConstraints.WEST;
        pInfor.add(cbbLoaiKM, constraintsCustomer);
        
        
        
        
        pBut = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
		pBut.setBackground(Color.WHITE); 
		btnThem = new JButton("Thêm khuyến mãi");
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Arial", Font.BOLD, 16));
		btnThem.setBackground(new Color (40,156,164));
//	    btnXoa = new JButton("Xóa khuyến mãi");
//	    btnXoa.setForeground(Color.WHITE);
//		btnXoa.setFont(new Font("Arial", Font.BOLD, 16));
//		btnXoa.setBackground(new Color (40,156,164));
	    btnSua = new JButton("Sửa khuyến mãi");
	    btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Arial", Font.BOLD, 16));
		btnSua.setBackground(new Color (40,156,164));
	    btnTim = new JButton("Tìm khuyến mãi");
	    btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("Arial", Font.BOLD, 16));
		btnTim.setBackground(new Color (40,156,164));
		
		
        
        
        
       
       
        JLabel lblDSKM = new JLabel("Danh sách khuyến mãi");
		lblDSKM.setFont(new Font("Times New Roman", Font.BOLD, 30));
		String headers[] = {"Mã khuyến mãi", "Tỷ lệ khuyến mãi", "Ngày bắt đầu", "Ngày kết thúc", "Loại khuyến mãi","Trạng Thái"};
		Object[][] data = {
				{"KMSP24","20%","20/10/2024","15/12/2024","khuyến mãi trên sản phẩm","Hoạt động"}

        };
		dataModel = new DefaultTableModel(data,headers);
		tableModel = new JTable(dataModel);
		tableModel.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
		tableModel.setFont(new Font("Arial", Font.PLAIN, 16));
		tableModel.setRowHeight(30);
		tableModel.setModel(dataModel);
		
		JScrollPane scroll = new JScrollPane(tableModel);
		
		pNorth.setPreferredSize(new Dimension((int)(widthComp*0.93),(int) (heightComp*0.05)));
		pCenter.setPreferredSize(new Dimension((int)(widthComp*0.93),(int) (heightComp*0.40)));
		
        pTable.setPreferredSize(new Dimension((int)(widthComp*0.93),(int) (heightComp*0.45)));
        scroll.setPreferredSize(new Dimension((int)(widthComp*0.9),(int) (heightComp*0.35)));
		
        
        pNorth.add(lblTitle,FlowLayout.LEFT);
        pBut.add(btnThem);
		//pBut.add(btnXoa);
		pBut.add(btnSua);
		pBut.add(btnTim);
		pCenter.add(pInfor,BorderLayout.CENTER);
		pCenter.add(pBut,BorderLayout.SOUTH);
		pTable.add(lblDSKM); 
		pTable.add(scroll);
		
		
		pContent.add(pNorth,BorderLayout.NORTH);
		pContent.add(pCenter,BorderLayout.CENTER);
		pContent.add(pTable,BorderLayout.SOUTH);
		layeredPane.add(pContent, JLayeredPane.DEFAULT_LAYER);
        this.add(layeredPane);
		
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnSua.addActionListener(this);
		
		this.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
//				System.out.println(widthComp );
//				System.out.println(heightComp);
				
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
// TODO Auto-generated method stub
				
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem))
		{

			if(layeredPane.getComponentsInLayer(JLayeredPane.PALETTE_LAYER).length == 0){
	    		isGuiCTHDDisplayed = false;
	    	}


	    	if (!isGuiCTHDDisplayed) {
	        
	    		
		        guiTKM = new Gui_ThemKhuyenMai();
		        guiTKM.setOpaque(true);
		        Dimension sizeGuiCTHD= guiTKM.getPreferredSize(); // Lấy kích thước ưu tiên của guiCTHD
		        Dimension sizeGuiLayeredPane = layeredPane.getPreferredSize(); // Lấy container cha (ví dụ, JLayeredPane hoặc JPanel)

		        if (sizeGuiLayeredPane != null && sizeGuiLayeredPane.getWidth() > 0 && sizeGuiLayeredPane.getHeight() > 0) {
		            int x = (int) ((sizeGuiLayeredPane.getWidth() - sizeGuiCTHD.width) / 2);
		            int y = (int) ((sizeGuiLayeredPane.getHeight() - sizeGuiCTHD.height) / 2);

		            guiTKM.setBounds(x, y, sizeGuiCTHD.width, sizeGuiCTHD.height);
		        } else {
		            guiTKM.setBounds(0, 0, sizeGuiCTHD.width, sizeGuiCTHD.height);
		        }
		        guiTKM.addMouseListener(new MouseAdapter() {});
		        guiTKM.addMouseMotionListener(new MouseAdapter() {});

		        layeredPane.add(guiTKM, JLayeredPane.PALETTE_LAYER);
		     
		        isGuiCTHDDisplayed  = true;
	    	}
		}
		
		
	}
	
}