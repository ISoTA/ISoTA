import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;

import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import org.jdatepicker.util.JDatePickerUtil;
import org.jdatepicker.impl.JDatePanelImpl;

import java.util.Properties;

public class AddEditForm extends JDialog
{
	private ClientModel client;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfFIO;
	private JButton okButton;
	private JButton cancelButton;
	private JDialog thisForm;
	private JTextField tfRegDate;
	private JTextField tfOkpo;
	private JTextField tfAdress;
	private JTextField tfUID;
	private JTextField tfNumber;
	private JTextField tfJurAdress;
	private JTextField tfDirFIO;
	private JTextField tfDirUID;
	private JTextField tfDirNumber;
	private JTextField tfSum;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JDatePickerImpl datePicker;
	private JRadioButton rbtnFiz;
	private JRadioButton rbtnJur;
	private AddEditForm dialog;

	public static void main(String[] args)
	{
		try
		{
			AddEditForm dialog = new AddEditForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}	
}
