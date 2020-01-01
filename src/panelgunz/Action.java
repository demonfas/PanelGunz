package panelgunz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Action {
	public void MsgBox(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
	public void MsgCon(String text) {
		System.out.println(text); 
	}
	public void MsgBoxCon(String[] text) {
		JOptionPane.showMessageDialog(null, text[0]);
		System.out.println(text[1]); 
	}
	public void Update(Statement sentencia, String[] SQLQuery) {
		//sentencia.executeUpdate("UPDATE Account SET UserID='" + txtNewUserID.getText() + "' where UserID='" + txtUserEdit.getText() + "'");
	}
	public void Execute(Statement sentencia, String[] SQLQuery) throws SQLException {
		sentencia.executeQuery("SELECT * FROM Account,Login where Login.UserID='" +  "' and Login.Password='" +  "' and Account.UGradeID=255");
		
	}
}
