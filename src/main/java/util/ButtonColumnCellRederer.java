package util;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonColumnCellRederer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;

	private String buttonType;

	public ButtonColumnCellRederer(String buttonType) {
		this.buttonType = buttonType;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int col) {
		// Cells are by default rendered as a JLabel.
		JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + buttonType + ".png")));

		// Return the JLabel which renders the cell.
		return label;
	}

}
