package panelgunz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	public static JTextField T_USERID;
	public Panel panel1 = new Panel();
    public static String U_C = null;
    public static JPasswordField T_PASSWORD;
	public Conn conn = new Conn();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
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
	public Login() {
        conn.try_c();
        Conn.logged = false;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 250, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblLogin.setFocusable(false);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(74, 23, 113, 50);
		panel.add(lblLogin);
		
		JLabel lblMin = new JLabel("_");
		lblMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = (int) lblMin.getLocation().getX() + 2;
				int y = (int) lblMin.getLocation().getY() - 2;
				lblMin.setLocation(x,y);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				int x = (int) lblMin.getLocation().getX() - 2;
				int y = (int) lblMin.getLocation().getY() + 2;
				lblMin.setLocation(x,y);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Login.ICONIFIED);
			}
		});
		lblMin.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMin.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMin.setForeground(Color.WHITE);
		lblMin.setBounds(210, -7, 16, 29);
		panel.add(lblMin);
		
		JLabel lblClose = new JLabel("x");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = (int) lblClose.getLocation().getX() + 1;
				int y = (int) lblClose.getLocation().getY() - 1;
				lblClose.setLocation(x,y);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				int x = (int) lblClose.getLocation().getX() - 1;
				int y = (int) lblClose.getLocation().getY() + 1;
				lblClose.setLocation(x,y);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblClose.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblClose.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblClose.setForeground(Color.WHITE);
		lblClose.setBounds(233, 0, 16, 20);
		panel.add(lblClose);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(0, 100, 250, 200);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		T_USERID = new JTextField();
		T_USERID.setText("demon");
		T_USERID.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		T_USERID.setAutoscrolls(false);
		T_USERID.setBounds(62, 11, 178, 32);
		panel_1.add(T_USERID);
		T_USERID.setColumns(10);
		
		JButton BLogin = new JButton("Login");
		BLogin.setBackground(Color.WHITE);
		BLogin.setForeground(Color.BLACK);
		BLogin.setFocusPainted(false);
		BLogin.setFocusable(false);
		BLogin.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(64, 64, 64)));
		BLogin.setBounds(30, 123, 190, 66);
		panel_1.add(BLogin);
		
		T_PASSWORD = new JPasswordField();
		T_PASSWORD.setText("123456");
		T_PASSWORD.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		T_PASSWORD.setBounds(62, 67, 178, 32);
		panel_1.add(T_PASSWORD);
		
		JLabel label = new JLabel("");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setIcon(new ImageIcon(((new ImageIcon("X:\\\\Disco D\\\\Jason\\\\Lenguajes\\\\Java\\\\test\\\\PanelGunz\\\\src\\\\Resource\\\\Imgs\\\\login.png")).getImage()).getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
		label.setBounds(21, 11, 32, 32);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setAlignmentX(0.5f);
		label_1.setIcon(new ImageIcon(((new ImageIcon("X:\\\\Disco D\\\\Jason\\\\Lenguajes\\\\Java\\\\test\\\\PanelGunz\\\\src\\\\Resource\\\\Imgs\\\\password.png")).getImage()).getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
		label_1.setBounds(21, 67, 32, 32);
		panel_1.add(label_1);
		BLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                conn.login(T_USERID.getText(), new String(T_PASSWORD.getPassword()));
				Conn.login = false;
                if (Conn.logged == false & Conn.login == true) {
                    
                }else if (Conn.logged == true & Conn.login == false){
                    U_C = Integer.toString(conn.Users_conected());
                    panel1.setVisible(true);
                    panel1.setLocationRelativeTo(null);
                    setVisible(false);
                }
			}
		});
	}
}
