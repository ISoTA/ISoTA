import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.ComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

public class AddEditFormReport extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JDialog thisForm;
	private JCustomTextField tfOperDate;
	private JTextField tfOperCode;
	private JTextField tfOverpayment;
	private JTextField tfPaid;
	private JTextField tfReturned;
	private JTextField tfSum;
	private ReportModel report;
	private JTextField tfClient;
	private ClientModel curClient;

	/** Launch the application. */
	public static void main(String[] args)
	{
		try
		{
			AddEditFormReport dialog = new AddEditFormReport();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean validateReports()
	{
		boolean res = true;
		if (tfOperCode.getText().isEmpty()) return false;
		return res;
	}
}