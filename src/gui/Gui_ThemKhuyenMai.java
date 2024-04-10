package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class Gui_ThemKhuyenMai extends JPanel implements ActionListener {
	private JTextField txtMaKM;
	private JDateChooser txtNgayBD;
	private JButton btnThem;
	private JButton btnHuy;
	private JTextField txtTyLeKM;
	private JDateChooser txtNgayKT;
	
	private JComboBox<String> cbbLoai ;
	private JTextField txtAddTien;
	//private JTextField txtGiamGia;
	private JScrollPane scrollPane2;
	private JScrollPane scrollPane;
	private JPanel panel3;
	private JButton btnLeft;
	private JButton btnRight;
	private int widthComp;
	private int heightComp;
	public Gui_ThemKhuyenMai()
	{
		this.widthComp = 1000;
		this.heightComp =500;
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        

        // Tạo JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel btnGroup = new JPanel();
        //panel.setBackground(new Color (40,156,164));

        // Tạo JLabel
        JLabel label1 = new JLabel("Thêm khuyến mãi");
        label1.setFont(new Font("Arial",Font.BOLD,26));
        JLabel lblMa = new JLabel("Mã khuyến mãi");
        JLabel lblBD = new JLabel("Ngày bắt đầu");
        JLabel lblTLKM = new JLabel("Tỷ lệ khuyến mãi");
        JLabel lblKT = new JLabel("Ngày kết thúc");
        JLabel lblLoai = new JLabel("Loại khuyến mãi");
        JLabel lblAddTien = new JLabel("Giá trị hóa đơn");
        //JLabel lblGiamGia = new JLabel("Giảm giá");
        cbbLoai= new JComboBox<>();

        // Tạo JTextField
        txtMaKM = new JTextField(10);
        txtNgayBD = new JDateChooser();
        txtTyLeKM = new JTextField(10);
        txtNgayKT = new JDateChooser();
        txtAddTien = new JTextField(10);
        //txtGiamGia = new JTextField(10);
        cbbLoai.addItem("Khuyến mãi trên hóa đơn");
        cbbLoai.addItem("Khuyến mãi trên sản phẩm");
        

        // Tạo JButton
        btnThem = new JButton("Thêm");
        btnHuy = new JButton("Hủy");
        btnLeft = new JButton("<-");
        btnRight = new JButton("->");
        btnGroup.add(btnLeft);
        btnGroup.add(btnRight);
        
//        btnLeft.setPreferredSize(new Dimension(40,1));
//        btnRight.setPreferredSize(new Dimension(40,1));
        


       

        JPanel panel2 = new JPanel();
        panel2 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 5, 0);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel2.add(lblMa, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel2.add(txtMaKM, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel2.add(lblTLKM, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel2.add(txtTyLeKM, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel2.add(lblAddTien, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel2.add(txtAddTien, gbc);
        
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        panel2.add(lblGiamGia, gbc);
//        
//        gbc.gridx = 1;
//        gbc.gridy = 3;
//        panel2.add(txtGiamGia, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 0;
        panel2.add(lblBD, gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        panel2.add(txtNgayBD, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        panel2.add(lblKT, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        panel2.add(txtNgayKT, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        panel2.add(lblLoai, gbc);

        gbc.gridx = 4;
        gbc.gridy = 2;
        panel2.add(cbbLoai, gbc);
        
        
        
        
       
        JPanel pnelTable = new JPanel();
        String[] columnNames = {"Mã thuốc", "Tên thuốc", "Đơn giá"};
        DefaultTableModel modelright = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(modelright);
        scrollPane = new JScrollPane(table);
        panel2.add(scrollPane,gbc);
        pnelTable.add(scrollPane);
        
        
        
        
      
      
        
      JPanel pnelTable2 = new JPanel();
      String[] columnNames2 = {"Mã thuốc", "Tên thuốc", "Đơn giá", "Giảm giá"};
      DefaultTableModel modelleft = new DefaultTableModel(columnNames2, 0);
      JTable table2 = new JTable(modelleft);
      scrollPane2 = new JScrollPane(table2);
      pnelTable2.add(scrollPane2);
      
      
        
        
        
//        panel2.add(label2);
//        panel2.add(txtMaKM);
//        panel2.add(label4);
//        panel2.add(txtTyLeKM);
//        panel2.add(label3);
//        panel2.add(txtNgayBD);
//        panel2.add(label5);
//        panel2.add(txtNgayKT);
//        panel2.add(label6);
//        panel2.add(cbbLoai);
       
        

        

        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        panel3.add(btnThem);
        panel3.add(btnHuy);
//        panel.add(label1, BorderLayout.NORTH);
        panel.add(panel2, BorderLayout.NORTH);
        panel.add(btnGroup,BorderLayout.CENTER);
//        panel.add(btnLeft,BorderLayout.CENTER);
//        panel.add(btnRight,BorderLayout.CENTER);
       
        panel.add(pnelTable,BorderLayout.WEST);
        panel.add(pnelTable2,BorderLayout.EAST);
        panel.add(panel3, BorderLayout.SOUTH);

        this.setPreferredSize(new Dimension(this.widthComp, (int)(this.heightComp+panel2.getPreferredSize().getHeight()+panel3.getPreferredSize().getHeight())));
        add(panel);
        
        
        scrollPane.setVisible(false);
		scrollPane2.setVisible(false);
		btnLeft.setVisible(false);
		btnRight.setVisible(false);
        btnThem.addActionListener(this);
        btnHuy.addActionListener(this);
        cbbLoai.addActionListener(this);
        
        
	}
	public static void main(String[] args) {
		new Gui_ThemKhuyenMai().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(cbbLoai)) {
			int select =cbbLoai.getSelectedIndex();
			if (select==0) {
				txtAddTien.setEnabled(true);
				//txtGiamGia.setEnabled(true);
				scrollPane.setVisible(false);
				scrollPane2.setVisible(false);
				btnLeft.setVisible(false);
				btnRight.setVisible(false);
				//pack();
				
			} else {
				txtAddTien.setEnabled(false); 
				txtAddTien.setText(""); 
				//txtGiamGia.setEnabled(false); 
				//txtGiamGia.setText("");
				scrollPane.setVisible(true);
				scrollPane2.setVisible(true);
				btnLeft.setVisible(true);
				btnRight.setVisible(true);
				//pack();
        }
		}
		if(o.equals(btnHuy))
			{
			JLayeredPane layeredPane = (JLayeredPane) getParent();
            layeredPane.remove(Gui_ThemKhuyenMai.this);
            // Cập nhật lại giao diện
            layeredPane.validate();
            layeredPane.repaint();
			}
	}
	
	
}
