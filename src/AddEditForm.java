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
	
	public boolean Validate()
	{
		boolean res = true;
		if (tfRegDate.getText().isEmpty()) return false;
		// if (textField_1.getText().isEmpty()) return false;
		// if (textField_2.getText().isEmpty()) return false;
		// if (textField_3.getText().isEmpty()) return false;
		// if (textField_4.getText().isEmpty()) return false;
		// if (rbtnJur.isSelected())
		// {
		// if (textField_5.getText().isEmpty()) return false;
		// if (textField_6.getText().isEmpty()) return false;
		// if (textField_7.getText().isEmpty()) return false;
		// if (textField_8.getText().isEmpty()) return false;
		// if (textField_9.getText().isEmpty()) return false;
		// }

		return res;
	}

	public void setModel(ClientModel cm)
	{
		this.client = cm;
		tfFIO.setText(cm.getFIO());
		if (cm.getDirectorAdress().equals(""))
		{
			rbtnFiz.setSelected(true);
			FizAct();
		}
		else
		{
			rbtnJur.setSelected(true);
			JurAct();
		}
		Date d = cm.getRegistrationDate();
		String sd = d.toString();
		String[] vals = sd.split("-");
		tfRegDate.setText(vals[2]+"/"+vals[1]+"/"+vals[0]);
		tfOkpo.setText(cm.getRevisionNum().toString());
		tfAdress.setText(cm.getAdress());
		tfUID.setText(cm.getUID().toString());
		tfNumber.setText(cm.getPhoneNumber().toString());
		tfAdress.setText(cm.getAdress());
		// TODO jur
	}
	
	private void FizAct()
	{
		okButton.setVisible(true);
		// thisForm.setBounds(100, 100, 450, 355);
		tfRegDate.setEnabled(true);
		tfOkpo.setEnabled(true);
		tfAdress.setEnabled(true);
		tfUID.setEnabled(true);
		tfNumber.setEnabled(true);
		tfJurAdress.setEnabled(false);
		tfDirFIO.setEnabled(false);
		tfDirUID.setEnabled(false);
		tfDirNumber.setEnabled(false);
		tfSum.setEnabled(false);
	}

	private void JurAct()
	{
		okButton.setVisible(true);
		tfRegDate.setEnabled(true);
		tfOkpo.setEnabled(true);
		tfAdress.setEnabled(true);
		tfUID.setEnabled(true);
		tfNumber.setEnabled(true);
		tfJurAdress.setEnabled(true);
		tfDirFIO.setEnabled(true);
		tfDirUID.setEnabled(true);
		tfDirNumber.setEnabled(true);
		tfSum.setEnabled(true);
	}
	
	public AddEditForm()
	{
		dialog = this;
		setTitle("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043A\u043B\u0438\u0435\u043D\u0442\u0430");
		setModal(true);
		setBounds(100, 100, 450, 537);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		thisForm = this;

		JLabel label_1 = new JLabel("\u0424\u0418\u041E:");
		label_1.setBounds(62, 30, 46, 14);
		contentPanel.add(label_1);

		tfFIO = new JTextField();
		tfFIO.setBounds(112, 27, 271, 20);
		contentPanel.add(tfFIO);
		tfFIO.setColumns(10);

		ButtonGroup btnGroup = new ButtonGroup();

		rbtnFiz = new JRadioButton(
				"\u0424\u0438\u0437\u0438\u0447\u0435\u0441\u043A\u043E\u0435");

		rbtnFiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				FizAct();
			}

		});
		
		rbtnFiz.setBounds(167, 69, 107, 23);
		contentPanel.add(rbtnFiz);
		btnGroup.add(rbtnFiz);

		rbtnJur = new JRadioButton(
				"\u042E\u0440\u0438\u0434\u0438\u0447\u0435\u0441\u043A\u043E\u0435");
		rbtnJur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				JurAct();
			}
		});

		rbtnJur.setBounds(276, 69, 107, 23);
		contentPanel.add(rbtnJur);
		btnGroup.add(rbtnJur);

		JLabel label = new JLabel(
				"\u0414\u0430\u0442\u0430 \u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u0438:");
		label.setBounds(62, 128, 144, 14);
		contentPanel.add(label);

		tfRegDate = new JTextField();
		tfRegDate.setEnabled(false);
		tfRegDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0)
			{

			}
		});
	}
	
}
