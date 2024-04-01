package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
public class ButtonEditor extends DefaultCellEditor {
 
	protected JButton button;
	protected JTable table;
	private DeleteButtonListener bListener = new DeleteButtonListener();
 
	/**
	 * Constructeur avec une checkBox
	 * @param checkBox
	 * @param count
	 */
	@SuppressWarnings("deprecation")
	public ButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
	    button.setOpaque(true);
	    button.addActionListener(bListener);
 
	}
 
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	    bListener.setRow(row);
	    bListener.setTable(table);
	    button.setBackground(Color.WHITE);
	    button.setOpaque(true);
	    button.setContentAreaFilled(true);
	    button.setBorderPainted(false);
	    button.setFocusPainted(false);
	    ImageIcon image = new ImageIcon("images/delete.png");
	    Image img = image.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	    button.setIcon(new ImageIcon(img));
	    return button;
	}
}