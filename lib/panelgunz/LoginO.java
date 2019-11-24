package panelgunz;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

class RoundedBorder implements Border {

    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius, this.radius, this.radius, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
public class LoginO {
    public static String U_C = null;
    public Panel_Antiguo panel = new Panel_Antiguo();
    public Panel panel1 = new Panel();
    public Conn conn = new Conn();
    public static JFrame MainP;
    public static JTextField T_USERID;
    public static JPasswordField T_PASSWORD;
    public static JLabel L_USERID, L_PASSWORD;
    public static JButton B_LOGIN;
    public void PLoginFrame(){
        //Connection
        conn.try_c();
        conn.logged = false;
        
        //Frame
        MainP = new JFrame("Login");
        MainP.setLayout(null);
        MainP.setLocationRelativeTo(null);
        MainP.setBounds(500, 100, 270, 160);
        MainP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainP.setResizable(false);
        
        //Label
        /*L_USERID = new JLabel("UserID");
        L_USERID.setLayout(null);
        L_USERID.setBounds(10, 10, 100, 25);
        L_USERID.setVisible(true);
        
        L_PASSWORD = new JLabel("Password");
        L_PASSWORD.setLayout(null);
        L_PASSWORD.setBounds(10, 60, 100, 25);
        L_PASSWORD.setVisible(true);*/
        
        //TextField
        T_USERID = new JTextField("demon");
        T_USERID.setLayout(null);
        T_USERID.setBounds(10, 10, 150, 50);
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "UserID");
        T_USERID.setBorder(bordejpanel);
        T_USERID.setVisible(true);
        
        T_PASSWORD = new JPasswordField("trustedpwpw");
        T_PASSWORD.setLayout(null);
        T_PASSWORD.setBounds(10, 70, 150, 50);
        Border bordejpanel1 = new TitledBorder(new EtchedBorder(), "Password");
        T_PASSWORD.setBorder(bordejpanel1);
        T_PASSWORD.setVisible(true);
        
        //Button
        B_LOGIN = new JButton("Login");
        B_LOGIN.setLayout(null);
        B_LOGIN.setBounds(165, 10, 90, 111);
        B_LOGIN.setBackground(new java.awt.Color(240, 240, 240));
        B_LOGIN.setBorder(new RoundedBorder(20));
        B_LOGIN.setVisible(true);
        B_LOGIN.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e){
                conn.login = false;
                conn.login(T_USERID.getText(), T_PASSWORD.getText());
                /*if (conn.logged == false & conn.login == true) {
                    
                }else */if (conn.logged == true & conn.login == false){
                    U_C = Integer.toString(conn.Users_conected());
                    panel1.setVisible(true);
                    MainP.setVisible(false);
                }
            }
        });
        
        
        MainP.add(B_LOGIN);
        MainP.add(T_USERID);
        MainP.add(T_PASSWORD);
        /*MainP.add(L_USERID);
        MainP.add(L_PASSWORD);*/
        MainP.setVisible(true);
    }
    public static void main(String[] args) {
        LoginO lgn = new LoginO();
        lgn.PLoginFrame();
        
    }
    
    
}
