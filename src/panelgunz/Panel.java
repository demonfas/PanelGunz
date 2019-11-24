package panelgunz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Panel extends JFrame {

	private JPanel contentPane;
	private JTable T_AllAccounts;
	private JTable Table_Login;
	private JTable Table_Clan;
	Conn cnn = new Conn();
	private JTextField txtUserDC;
	private JTextField txtDonatorCSend;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtUserDonatorCEdit;
	private JTextField txtInfoDonatorCoins;
	private JTextField txtNewDCoins;
	private JTextField txtUserEventCEdit;
	private JTextField txtInfoEventCoins;
	private JTextField txtNewECoins;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel frame = new Panel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Panel() {
		
		setResizable(false);
		setTitle("Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel PEditAccounts = new JPanel();
		PEditAccounts.setBorder(new LineBorder(Color.LIGHT_GRAY));
		PEditAccounts.setVisible(false);
		PEditAccounts.setBackground(Color.WHITE);
		PEditAccounts.setBounds(265, 5, 719, 565);
		contentPane.add(PEditAccounts);
		PEditAccounts.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Cambiar UserID", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 699, 83);
		PEditAccounts.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel(":");
		lblNewLabel_3.setBounds(123, 38, 10, 14);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFocusTraversalPolicyProvider(true);
		textField.setFocusCycleRoot(true);
		textField.setBounds(133, 35, 136, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"UserID", "AID"}));
		comboBox.setBounds(24, 35, 89, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Nueva UserID:");
		lblNewLabel_4.setBounds(279, 38, 93, 14);
		panel.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(382, 35, 187, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Cambiar");
		btnNewButton.setBounds(579, 34, 89, 23);
		panel.add(btnNewButton);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Cambiar Country", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 471, 699, 83);
		PEditAccounts.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_8 = new JLabel(":");
		label_8.setBounds(147, 36, 13, 14);
		panel_5.add(label_8);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(170, 33, 136, 20);
		panel_5.add(textField_12);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"UserID", "AID", "CharacterID"}));
		comboBox_5.setBounds(27, 33, 110, 20);
		panel_5.add(comboBox_5);
		
		JLabel lblNuevaCountry = new JLabel("Nueva Country:");
		lblNuevaCountry.setBounds(316, 36, 93, 14);
		panel_5.add(lblNuevaCountry);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(430, 33, 142, 20);
		panel_5.add(textField_13);
		
		JButton button_7 = new JButton("Cambiar");
		button_7.setBounds(582, 32, 89, 23);
		panel_5.add(button_7);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Enviar Item a Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 379, 699, 83);
		PEditAccounts.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_6 = new JLabel(":");
		label_6.setBounds(100, 34, 10, 14);
		panel_6.add(label_6);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(109, 31, 99, 20);
		panel_6.add(textField_9);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"UserID", "AID"}));
		comboBox_4.setBounds(27, 31, 69, 20);
		panel_6.add(comboBox_4);
		
		JLabel lblItemid_1 = new JLabel("ItemID:");
		lblItemid_1.setBounds(218, 34, 45, 14);
		panel_6.add(lblItemid_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(273, 31, 113, 20);
		panel_6.add(textField_10);
		
		JButton button_6 = new JButton("Cambiar");
		button_6.setBounds(582, 30, 89, 23);
		panel_6.add(button_6);
		
		JLabel lblDuracindas_1 = new JLabel("Duraci\u00F3n(D\u00EDas):");
		lblDuracindas_1.setBounds(396, 34, 89, 14);
		panel_6.add(lblDuracindas_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(495, 31, 76, 20);
		panel_6.add(textField_11);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Cambiar Contrase\u00F1a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 100, 699, 83);
		PEditAccounts.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel label_5 = new JLabel(":");
		label_5.setBounds(120, 36, 10, 14);
		panel_7.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(130, 33, 136, 20);
		panel_7.add(textField_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"UserID", "AID"}));
		comboBox_1.setBounds(24, 33, 89, 20);
		panel_7.add(comboBox_1);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva Contrase\u00F1a:");
		lblNuevaContrasea.setBounds(276, 36, 109, 14);
		panel_7.add(lblNuevaContrasea);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(380, 33, 186, 20);
		panel_7.add(textField_5);
		
		JButton button = new JButton("Cambiar");
		button.setBounds(576, 32, 89, 23);
		panel_7.add(button);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Cambiar Rango", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(10, 195, 699, 83);
		PEditAccounts.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel label_7 = new JLabel(":");
		label_7.setBounds(135, 34, 10, 14);
		panel_8.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(144, 31, 136, 20);
		panel_8.add(textField_6);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"UserID", "AID", "CharacterID"}));
		comboBox_2.setBounds(23, 31, 102, 20);
		panel_8.add(comboBox_2);
		
		JLabel lblNuevoRango = new JLabel("Nuevo Rango:");
		lblNuevoRango.setBounds(290, 34, 81, 14);
		panel_8.add(lblNuevoRango);
		
		JButton button_3 = new JButton("Cambiar");
		button_3.setBounds(578, 30, 89, 23);
		panel_8.add(button_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Normal User - 0", "Event User - 2", "Banned User - 253", "Developer User - 252", "GameMaster User - 254", "Admin - 255"}));
		comboBox_3.setBounds(381, 31, 187, 20);
		panel_8.add(comboBox_3);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Enviar Item a todas las cuentas", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(10, 287, 699, 83);
		PEditAccounts.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblItemid = new JLabel("ItemID:");
		lblItemid.setBounds(26, 35, 93, 14);
		panel_9.add(lblItemid);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(78, 32, 191, 20);
		panel_9.add(textField_7);
		
		JLabel lblDuracindas = new JLabel("Duraci\u00F3n (D\u00EDas):");
		lblDuracindas.setBounds(279, 35, 93, 14);
		panel_9.add(lblDuracindas);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(382, 32, 187, 20);
		panel_9.add(textField_8);
		
		JButton button_5 = new JButton("Cambiar");
		button_5.setBounds(579, 31, 89, 23);
		panel_9.add(button_5);
		
		JPanel PCoins = new JPanel();
		PCoins.setBorder(new LineBorder(Color.LIGHT_GRAY));
		PCoins.setVisible(false);
		PCoins.setBackground(Color.WHITE);
		PCoins.setBounds(265, 5, 719, 565);
		contentPane.add(PCoins);
		PCoins.setLayout(null);
		
		JPanel PDonatorCoins = new JPanel();
		PDonatorCoins.setBackground(Color.WHITE);
		PDonatorCoins.setBounds(10, 11, 699, 264);
		PCoins.add(PDonatorCoins);
		PDonatorCoins.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Donator Coins");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 28));
		lblNewLabel_2.setBounds(260, 5, 198, 33);
		PDonatorCoins.add(lblNewLabel_2);
		
		txtUserDC = new JTextField();
		txtUserDC.setBorder(new MatteBorder(0, 5, 1, 0, (Color) SystemColor.controlShadow));
		txtUserDC.setBounds(237, 55, 277, 20);
		PDonatorCoins.add(txtUserDC);
		txtUserDC.setColumns(10);
		
		JComboBox CBDCoinsTypeSend = new JComboBox();
		CBDCoinsTypeSend.setBorder(null);
		CBDCoinsTypeSend.setModel(new DefaultComboBoxModel(new String[] {"UserID", "AID", "Character"}));
		CBDCoinsTypeSend.setBounds(146, 55, 87, 20);
		PDonatorCoins.add(CBDCoinsTypeSend);
		
		JLabel label_1 = new JLabel("Donator Coins");
		label_1.setBounds(146, 84, 87, 14);
		PDonatorCoins.add(label_1);
		label_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		
		txtDonatorCSend = new JTextField();
		txtDonatorCSend.setColumns(10);
		txtDonatorCSend.setBorder(new MatteBorder(0, 5, 1, 0, (Color) SystemColor.controlShadow));
		txtDonatorCSend.setBounds(237, 80, 277, 20);
		PDonatorCoins.add(txtDonatorCSend);
		
		JButton BEnviarDC = new JButton("Enviar");
		BEnviarDC.setBounds(299, 111, 89, 23);
		PDonatorCoins.add(BEnviarDC);
		
		txtUserDonatorCEdit = new JTextField();
		txtUserDonatorCEdit.setToolTipText("Presiona enter para detectar usuario");
		txtUserDonatorCEdit.setColumns(10);
		txtUserDonatorCEdit.setBorder(new MatteBorder(0, 5, 1, 0, (Color) SystemColor.controlShadow));
		txtUserDonatorCEdit.setBounds(129, 188, 186, 20);
		PDonatorCoins.add(txtUserDonatorCEdit);
		
		JComboBox CBDCoinsTypeEdit = new JComboBox();
		CBDCoinsTypeEdit.setModel(new DefaultComboBoxModel(new String[] {"UserID", "AID", "Character"}));
		CBDCoinsTypeEdit.setBorder(null);
		CBDCoinsTypeEdit.setBounds(38, 188, 87, 20);
		PDonatorCoins.add(CBDCoinsTypeEdit);
		
		txtInfoDonatorCoins = new JTextField();
		txtInfoDonatorCoins.setEnabled(false);
		txtInfoDonatorCoins.setText("noInfo");
		txtInfoDonatorCoins.setColumns(10);
		txtInfoDonatorCoins.setBorder(new MatteBorder(0, 5, 1, 0, (Color) SystemColor.controlShadow));
		txtInfoDonatorCoins.setBounds(328, 187, 56, 20);
		PDonatorCoins.add(txtInfoDonatorCoins);
		
		JButton BEditDC = new JButton("Cambiar");
		BEditDC.setBounds(521, 186, 89, 23);
		PDonatorCoins.add(BEditDC);
		
		txtNewDCoins = new JTextField();
		txtNewDCoins.setToolTipText("newCoins");
		txtNewDCoins.setColumns(10);
		txtNewDCoins.setBorder(new MatteBorder(0, 5, 1, 0, (Color) SystemColor.controlShadow));
		txtNewDCoins.setBounds(426, 187, 66, 20);
		PDonatorCoins.add(txtNewDCoins);
		
		JLabel label = new JLabel("--");
		label.setBounds(397, 190, 19, 14);
		PDonatorCoins.add(label);
		
		JLabel label_2 = new JLabel(">");
		label_2.setBounds(408, 192, 19, 14);
		PDonatorCoins.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBounds(26, 155, 645, 79);
		PDonatorCoins.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_2.setBounds(26, 45, 645, 95);
		PDonatorCoins.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel PEventCoins = new JPanel();
		PEventCoins.setBackground(Color.WHITE);
		PEventCoins.setBounds(10, 286, 699, 268);
		PCoins.add(PEventCoins);
		PEventCoins.setLayout(null);
		
		JLabel lblEventCoins = new JLabel("Event Coins");
		lblEventCoins.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 28));
		lblEventCoins.setBounds(273, 11, 198, 33);
		PEventCoins.add(lblEventCoins);
		
		txtUserEventCEdit = new JTextField();
		txtUserEventCEdit.setToolTipText("Presiona enter para detectar usuario");
		txtUserEventCEdit.setColumns(10);
		txtUserEventCEdit.setBorder(new MatteBorder(0, 5, 1, 0, (Color) SystemColor.controlShadow));
		txtUserEventCEdit.setBounds(135, 212, 186, 20);
		PEventCoins.add(txtUserEventCEdit);
		
		JComboBox CBECoinsTypeEdit = new JComboBox();
		CBECoinsTypeEdit.setModel(new DefaultComboBoxModel(new String[] {"UserID", "AID", "Character"}));
		CBECoinsTypeEdit.setBorder(null);
		CBECoinsTypeEdit.setBounds(44, 212, 87, 20);
		PEventCoins.add(CBECoinsTypeEdit);
		
		txtInfoEventCoins = new JTextField();
		txtInfoEventCoins.setText("noInfo");
		txtInfoEventCoins.setEnabled(false);
		txtInfoEventCoins.setColumns(10);
		txtInfoEventCoins.setBorder(new MatteBorder(0, 5, 1, 0, (Color) SystemColor.controlShadow));
		txtInfoEventCoins.setBounds(334, 211, 56, 20);
		PEventCoins.add(txtInfoEventCoins);
		
		JButton BEditEC = new JButton("Cambiar");
		BEditEC.setBounds(527, 210, 89, 23);
		PEventCoins.add(BEditEC);
		
		txtNewECoins = new JTextField();
		txtNewECoins.setToolTipText("newCoins");
		txtNewECoins.setColumns(10);
		txtNewECoins.setBorder(new MatteBorder(0, 5, 1, 0, (Color) SystemColor.controlShadow));
		txtNewECoins.setBounds(432, 211, 66, 20);
		PEventCoins.add(txtNewECoins);
		
		JLabel label_3 = new JLabel("--");
		label_3.setBounds(403, 214, 19, 14);
		PEventCoins.add(label_3);
		
		JLabel label_4 = new JLabel(">");
		label_4.setBounds(414, 216, 19, 14);
		PEventCoins.add(label_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(27, 62, 645, 109);
		PEventCoins.add(panel_3);
		panel_3.setLayout(null);
		
		JButton BEnviarEC = new JButton("Enviar");
		BEnviarEC.setBounds(276, 75, 89, 23);
		panel_3.add(BEnviarEC);
		
		JComboBox CBECoinsSend = new JComboBox();
		CBECoinsSend.setBounds(122, 19, 87, 20);
		panel_3.add(CBECoinsSend);
		CBECoinsSend.setModel(new DefaultComboBoxModel(new String[] {"UserID", "AID", "Character"}));
		CBECoinsSend.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		
		JLabel lblEventCoins_1 = new JLabel("Event Coins");
		lblEventCoins_1.setBounds(123, 50, 87, 14);
		panel_3.add(lblEventCoins_1);
		lblEventCoins_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		
		textField_2 = new JTextField();
		textField_2.setBounds(213, 18, 277, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(0, 5, 1, 0, (Color) SystemColor.controlShadow));
		
		textField_3 = new JTextField();
		textField_3.setBounds(213, 44, 277, 20);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(0, 5, 1, 0, (Color) SystemColor.controlShadow));
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(27, 178, 645, 79);
		PEventCoins.add(panel_4);
		BEnviarDC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnn.SendDCoins(CBDCoinsTypeSend.getSelectedIndex(),Integer.parseInt(txtDonatorCSend.getText()),  txtUserDC.getText());
			}
		});
		BEnviarEC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnn.SendECoins(CBECoinsSend.getSelectedIndex(),Integer.parseInt(txtDonatorCSend.getText()), txtUserDC.getText());
			}
		});
		txtUserDonatorCEdit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				cnn.GetEditDCoins(CBDCoinsTypeEdit, txtUserDonatorCEdit, txtInfoDonatorCoins, arg0);
			}
		});
		txtUserEventCEdit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				cnn.GetEditECoins(CBECoinsTypeEdit, txtUserEventCEdit, txtInfoEventCoins, arg0);
			}
		});
		BEditDC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cnn.EditDCoins(CBDCoinsTypeEdit, txtUserDonatorCEdit, txtNewDCoins, txtInfoDonatorCoins);
			}
		});
		BEditEC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnn.EditECoins(CBECoinsTypeEdit, txtUserEventCEdit, txtNewECoins, txtInfoEventCoins);
			}
		});
		
		JPanel PAccounts = new JPanel();
		PAccounts.setBorder(new LineBorder(Color.LIGHT_GRAY));
		PAccounts.setName("panel_3");
		PAccounts.setBackground(Color.WHITE);
		PAccounts.setBounds(265, 5, 719, 565);
		contentPane.add(PAccounts);
		PAccounts.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 699, 524);
		PAccounts.add(scrollPane);
		
		T_AllAccounts = new JTable();
		T_AllAccounts.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(T_AllAccounts);
		T_AllAccounts.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00B0", "AID", "UserID", "UGrade", "Coins", "ECoins", "RedColor", "GreenColor", "BlueColor", "Country", "Question", "Answer", "N\u00B0", "CID", "AID", "Name", "Sex", "Level", "XP", "BP", "PlayTime", "Kill", "Death", "Ranking"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		Conn.hideRows(T_AllAccounts, 0, 23);
		
		JLabel lblAccounts = new JLabel("$lblAccounts");
		lblAccounts.setBounds(10, 7, 110, 14);
		PAccounts.add(lblAccounts);
		
		JPanel PUser = new JPanel();
		PUser.setBackground(Color.LIGHT_GRAY);
		PUser.setBounds(5, 5, 250, 100);
		contentPane.add(PUser);
		PUser.setLayout(null);
		
		Label LBienvenido = new Label("Bienvenido '$user' Grade: '$grade'");
		LBienvenido.setBounds(10, 10, 230, 22);
		PUser.add(LBienvenido);
		
		Label LConectados = new Label("Usuarios conectados '$usersonline'");
		LConectados.setBounds(10, 68, 230, 22);
		PUser.add(LConectados);
		
		JPanel PClan = new JPanel();
		PClan.setBorder(new LineBorder(Color.LIGHT_GRAY));
		PClan.setVisible(false);
		
		JPanel PLogin = new JPanel();
		PLogin.setBorder(new LineBorder(Color.LIGHT_GRAY));
		PLogin.setVisible(false);
		PLogin.setBounds(265, 5, 719, 565);
		contentPane.add(PLogin);
		PLogin.setBackground(Color.WHITE);
		PLogin.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 30, 699, 524);
		PLogin.add(scrollPane_1);
		
		Table_Login = new JTable();
		scrollPane_1.setViewportView(Table_Login);
		Table_Login.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00B0", "AID", "UserID", "Password", "LasIP", "LastConnect"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		PLogin.add(lblNewLabel_1);
		Table_Login.getTableHeader().setReorderingAllowed(false);
		PClan.setBackground(Color.WHITE);
		PClan.setBounds(265, 5, 719, 565);
		contentPane.add(PClan);
		PClan.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 30, 699, 524);
		PClan.add(scrollPane_2);
		
		Table_Clan = new JTable();
		Table_Clan.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00B0", "CLID", "Name", "Master", "Points", "Win", "Lose"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, String.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(Table_Clan);
		
		JLabel lblNewLabel = new JLabel("Clans");
		lblNewLabel.setBounds(10, 11, 46, 14);
		PClan.add(lblNewLabel);
		
		JPanel PButtons = new JPanel();
		PButtons.setBackground(Color.LIGHT_GRAY);
		PButtons.setBounds(5, 116, 250, 454);
		contentPane.add(PButtons);
		PButtons.setLayout(null);
		

		JButton BAccounts = new JButton("Cuentas");
		BAccounts.setBounds(10, 11, 230, 23);
		PButtons.add(BAccounts);
		
		JButton BCharacters = new JButton("Personajes");
		BCharacters.setBounds(10, 45, 230, 23);
		PButtons.add(BCharacters);
		
		JButton BEditAccounts = new JButton("Editar Cuentas");
		BEditAccounts.setBounds(10, 147, 230, 23);
		PButtons.add(BEditAccounts);
		
		JButton button_2 = new JButton("Editar Personajes");
		button_2.setBounds(10, 181, 230, 23);
		PButtons.add(button_2);
		
		JButton BCoins = new JButton("Coins");
		BCoins.setBounds(10, 215, 230, 23);
		PButtons.add(BCoins);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(10, 249, 230, 23);
		PButtons.add(button_4);
		
		JButton BClan = new JButton("Clan");
		BClan.setBounds(10, 113, 230, 23);
		PButtons.add(BClan);
		
		JButton BLogout = new JButton("Logout");
		BLogout.setBounds(10, 419, 230, 23);
		PButtons.add(BLogout);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(10, 385, 230, 23);
		PButtons.add(button_8);
		
		JButton button_9 = new JButton("New button");
		button_9.setBounds(10, 351, 230, 23);
		PButtons.add(button_9);
		
		JButton button_10 = new JButton("New button");
		button_10.setBounds(10, 317, 230, 23);
		PButtons.add(button_10);
		
		JButton button_11 = new JButton("New button");
		button_11.setBounds(10, 283, 230, 23);
		PButtons.add(button_11);
		
		JButton BLogin = new JButton("Login");
		BLogin.setBounds(10, 79, 230, 23);
		PButtons.add(BLogin);
		BLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Login lgn = new Login();
				 	lgn.setLocationRelativeTo(null);
			        lgn.setVisible(true);
			        Conn.logged = false;
			        dispose();
			}
		});
		BAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblAccounts.setText("Accounts");
				PLogin.setVisible(false);
				PClan.setVisible(false);
				PCoins.setVisible(false);
				PEditAccounts.setVisible(false);
				PAccounts.setVisible(true);
				cnn.Actualizar_Accounts(T_AllAccounts);
			}
		});
		BCharacters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAccounts.setText("Characters");
				PLogin.setVisible(false);
				PClan.setVisible(false);
				PCoins.setVisible(false);
				PEditAccounts.setVisible(false);
				PAccounts.setVisible(true);
				cnn.Actualizar_Characters(T_AllAccounts);
			}
		});
		
				BLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PAccounts.setVisible(false);
						PClan.setVisible(false);
						PCoins.setVisible(false);
						PEditAccounts.setVisible(false);
						PLogin.setVisible(true);
						cnn.Actualizar_Login(Table_Login);
					}
				});
				BClan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PAccounts.setVisible(false);
						PLogin.setVisible(false);
						PCoins.setVisible(false);
						PEditAccounts.setVisible(false);
						PClan.setVisible(true);
						cnn.Actualizar_Clan(Table_Clan);
					}
				});
				BCoins.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PAccounts.setVisible(false);
						PLogin.setVisible(false);
						PClan.setVisible(false);
						PEditAccounts.setVisible(false);
						PCoins.setVisible(true);
					}
				});
				BEditAccounts.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PAccounts.setVisible(false);
						PLogin.setVisible(false);
						PClan.setVisible(false);
						PCoins.setVisible(false);
						PEditAccounts.setVisible(true);
					}
				});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				PAccounts.setVisible(false);
				LBienvenido.setText("Bienvenido '" + Login.T_USERID.getText() +"' Grade: " + Conn.UGradeID);
				LConectados.setText("Usuarios conectados: " + Login.U_C);
		        Conn.login = true;
			}
		});
	}
}
