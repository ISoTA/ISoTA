import java.awt.Dialog;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPanel;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.ListModel;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class MainWindow
{
	private Integer searchPos = 0;
	private JFrame frmIsota;
	private MainWindow MainWin;
	private JPanel panelReports;
	private JTable tableReports;
	private JList<ClientModel> listFIO;
	private JPanel panelClients;
	private JLabel statusText;
	private JTable tableClientInfo;
	private ClientModel[] clients;
	private JTextField tfFIO;
	

	/** Launch the application. */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					MainWindow window = new MainWindow();
					window.frmIsota.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	private void updateReportList()
	{
		try
		{
			DefaultTableModel dtm = ReportModel.findReportsAllTM();
			tableReports.setModel(dtm);
			((DefaultTableModel) tableReports.getModel())
					.fireTableDataChanged();
			JTableHeader th = tableReports.getTableHeader();
			th.setEnabled(true);
			tableReports.getColumnModel().getColumn(0).setMinWidth(0);
			tableReports.getColumnModel().getColumn(0).setMaxWidth(0);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** Create the application. */
	public MainWindow()
	{
		initialize();
	}

	/** Initialize the contents of the frame. */
	private void initialize()
	{
		MainWin = this;
		frmIsota = new JFrame();
		frmIsota.setTitle("ISoTA");
		frmIsota.addFocusListener(new FrameFocusListener());
		frmIsota.setResizable(false);
		frmIsota.addWindowListener(new FrameWindowListener());
		frmIsota.setBounds(100, 100, 686, 437);
		frmIsota.setLocationRelativeTo(null);
		frmIsota.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmIsota.setJMenuBar(menuBar);

		JMenu menuReports = new JMenu("\u041E\u0442\u0447\u0435\u0442\u044B");
		menuBar.add(menuReports);

		reportsOpen = new JMenuItem(
				"\u041E\u0442\u043A\u0440\u044B\u0442\u044C \u0441\u043F\u0438\u0441\u043E\u043A");
		reportsOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				panelClients.setVisible(false);
				panelReports.setVisible(true);
				updateReportList();

			}
		});
		menuReports.add(reportsOpen);

		reportsCreate = new JMenuItem(
				"\u0421\u043E\u0437\u0434\u0430\u0442\u044C");
		reportsCreate.addActionListener(new ReportsCreateActionListener());
		menuReports.add(reportsCreate);

		reportsEdit = new JMenuItem(
				"\u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C");
		reportsEdit.addActionListener(new ReportsEditActionListener());
		menuReports.add(reportsEdit);

		reportsDelete = new JMenuItem(
				"\u0423\u0434\u0430\u043B\u0438\u0442\u044C (\u0432\u044B\u0431\u0440.)");
		reportsDelete.addActionListener(new ReportsDeleteActionListener());
		menuReports.add(reportsDelete);

		reportsDeleteAll = new JMenuItem(
				"\u0423\u0434\u0430\u043B\u0438\u0442\u044C (\u0432\u0441\u0435)");
		reportsDeleteAll
				.addActionListener(new ReportsDeleteAllActionListener());
		menuReports.add(reportsDeleteAll);

		JMenu menuClients = new JMenu(
				"\u041A\u043B\u0438\u0435\u043D\u0442\u044B");
		menuBar.add(menuClients);

		clientsOpen = new JMenuItem(
				"\u041E\u0442\u043A\u0440\u044B\u0442\u044C \u0441\u043F\u0438\u0441\u043E\u043A");
		clientsOpen.addActionListener(new ClientsOpenActionListener());
		menuClients.add(clientsOpen);

		clientsAdd = new JMenuItem(
				"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		clientsAdd.addActionListener(new ClientsAddActionListener());
		menuClients.add(clientsAdd);

		clientsEdit = new JMenuItem(
				"\u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C");
		clientsEdit.addActionListener(new ClientsEditActionListener());
		menuClients.add(clientsEdit);

		clientsDelete = new JMenuItem(
				"\u0423\u0434\u0430\u043B\u0438\u0442\u044C (\u0432\u044B\u0431\u0440.)");
		clientsDelete.addActionListener(new ClientsDeleteActionListener());
		menuClients.add(clientsDelete);

		clientsDeleteAll = new JMenuItem(
				"\u0423\u0434\u0430\u043B\u0438\u0442\u044C(\u0432\u0441\u0435)");
		clientsDeleteAll
				.addActionListener(new ClientsDeleteAllActionListener());
		menuClients.add(clientsDeleteAll);

		JMenu menuExit = new JMenu("\u0412\u044B\u0445\u043E\u0434");
		menuBar.add(menuExit);

		JMenuItem exitChangeUser = new JMenuItem(
				"\u0421\u043C\u0435\u043D\u0438\u0442\u044C \u043F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u0435\u043B\u044F");
		exitChangeUser.addActionListener(new ExitChangeUserActionListener());
		menuExit.add(exitChangeUser);

		JMenuItem exitExit = new JMenuItem("\u0412\u044B\u0445\u043E\u0434");
		menuExit.add(exitExit);

		menu = new JMenu(
				"\u0410\u0434\u043C\u0438\u043D. \u043F\u0430\u043D\u0435\u043B\u044C");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem(
				"\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				RegForm rf = new RegForm();
				rf.setModal(true);
				rf.setVisible(true);
			}
		});
		menu.add(menuItem);
		frmIsota.getContentPane().setLayout(null);

		panelReports = new JPanel();
		panelReports.setBounds(0, 0, 680, 366);
		frmIsota.getContentPane().add(panelReports);

		panelReports.setLayout(null);

		JLabel labelReports = new JLabel(
				"\u0421\u043F\u0438\u0441\u043E\u043A \u043E\u0442\u0447\u0435\u0442\u043E\u0432");
		labelReports.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelReports.setBounds(278, 26, 110, 14);
		panelReports.add(labelReports);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 51, 571, 237);
		panelReports.add(scrollPane);
		
		tableReports = new JTable();
		tableReports.setCellSelectionEnabled(true);
		tableReports.setEnabled(true);
		tableReports.setAutoCreateRowSorter(true);
		tableReports.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableReports.setRowSelectionAllowed(false);
		tableReports.setColumnSelectionAllowed(false);
		tableReports.setBounds(0, 0, 571, 237);
		updateReportList();
		scrollPane.setViewportView(tableReports);		

		tfSearch = new JTextField();
		tfSearch.setBounds(52, 299, 86, 20);
		panelReports.add(tfSearch);
		tfSearch.setColumns(10);

		JButton btnSearch = new JButton("Искать...");
		btnSearch.addActionListener(new BtnSearchActionListener());
		btnSearch.setBounds(320, 298, 89, 23);
		panelReports.add(btnSearch);

		label_2 = new JLabel("\u0432 \u043F\u043E\u043B\u0435:");
		label_2.setBounds(149, 302, 46, 14);
		panelReports.add(label_2);

		cbColumn = new JComboBox<String>();
		cbColumn.setBounds(200, 299, 110, 20);
		cbColumn.addItem("ФИО клиента");
		cbColumn.addItem("Дата операции");
		cbColumn.addItem("Код");
		cbColumn.addItem("Сумма");
		cbColumn.addItem("Оплачено");
		cbColumn.addItem("Возвращено");
		cbColumn.addItem("Переплата");
		
		
		panelReports.add(cbColumn);

		panelClients = new JPanel();
		panelClients.setBounds(0, 0, 680, 366);
		frmIsota.getContentPane().add(panelClients);

		listFIO = new JList<ClientModel>();
		listFIO.setBounds(57, 68, 186, 256);
		listFIO.addListSelectionListener(new ListFIOListSelectionListener());
		panelClients.setLayout(null);
		panelClients.add(listFIO);

		JLabel labelClients = new JLabel(
				"\u0421\u043F\u0438\u0441\u043E\u043A \u043A\u043B\u0438\u0435\u043D\u0442\u043E\u0432");
		labelClients.setBounds(273, 21, 123, 14);
		labelClients.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelClients.add(labelClients);

		JLabel labelFIO = new JLabel("\u0424\u0418\u041E");
		labelFIO.setBounds(130, 51, 46, 14);
		panelClients.add(labelFIO);

		JLabel label = new JLabel(
				"\u0418\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u044F \u043E \u043A\u043B\u0438\u0435\u043D\u0442\u0435");
		label.setBounds(378, 51, 123, 14);
		panelClients.add(label);

		tableClientInfo = new JTable();
		tableClientInfo.setBounds(253, 67, 369, 257);
		panelClients.add(tableClientInfo);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 329, 680, 35);
		panelClients.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);

		JLabel label_1 = new JLabel("\u041F\u043E\u0438\u0441\u043A:");
		label_1.setBounds(10, 11, 46, 14);
		panel_1.add(label_1);

		tfFIO = new JTextField();
		tfFIO.setBounds(57, 8, 186, 20);
		panel_1.add(tfFIO);
		tfFIO.setColumns(10);

		JButton button = new JButton(
				"\u0418\u0441\u043A\u0430\u0442\u044C \u0434\u0430\u043B\u0435\u0435...");
		button.addActionListener(new ButtonActionListener());
		button.setBounds(253, 7, 115, 23);
		panel_1.add(button);

		JPanel panel = new JPanel();
		panel.setBounds(0, 368, 680, 20);
		frmIsota.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		statusText = new JLabel(
				"\u0424\u0418\u041E \u043F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u0435\u043B\u044F: ");
		statusText.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(statusText);

		JSeparator separator = new JSeparator();
		separator.setForeground(UIManager.getColor("Button.background"));
		panel.add(separator);

		JLabel statusDate = new JLabel(LocalDate.now().toString());
		statusDate.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(statusDate);

	}

	