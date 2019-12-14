package panelgunz;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




public class Conn {
	public static int UGradeID;
    Connection conexion;
    Statement sentencia = null;
    public static boolean connected=false,logged=false, login = false;
    public boolean try_c(){
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = (Connection) DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=teste;allowMultiQueries=true", "sa", "123456789");
            sentencia = (Statement) conexion.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
            if (conexion!=null){
                connected=true;
            }
        } catch (ClassNotFoundException | SQLException ex ) {
            System.out.println(ex.getMessage() + "1");
            connected=false;            
        } 
        return connected;
    }
    public void login(String USERID, String PASSWORD){
    	try_c();
        try{
            sentencia = (Statement) conexion.createStatement();
            ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account,Login where Login.UserID='" + USERID + "' and Login.Password='" + PASSWORD + "' and Account.UGradeID=255");
            if (rlst.next() & logged == false) {
            	 UGradeID = rlst.getInt("UGradeID");
                System.out.println("Logged Grade:" + UGradeID);
                logged = true;
            }else if(logged == true){
                System.out.println("You are connected");
                return;
            }else if(USERID.equals("")){
                System.out.println("Llena el campo de UserID");
                return;
            }else if(PASSWORD.equals("")){
                System.out.println("Llena el campo de Password");
                return;
            }
            else{
                System.out.println("UserID or Password incorrect");
                return;
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage() + "2");
        }
    }
    
    public int Users_conected(){
        try{
            sentencia = (Statement) conexion.createStatement();
            ResultSet rlst = sentencia.executeQuery("SELECT CurrPlayer FROM ServerStatus where Opened = 1");
            if (rlst.next()) {
                return rlst.getInt("CurrPlayer");
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage() + "3");
        }
        return 0;
    }
    void VTAccounts(DefaultTableModel dtm, int i, ResultSet rlst) {
    	try {
        Object[] OAccounts = new Object[] {i, //contador
                rlst.getInt("AID"),//aid
                rlst.getString("UserID"),//userid
                rlst.getInt("UGradeID"), //ugradeid
                rlst.getInt("DonatorCoins"), //coins
                rlst.getInt("EventCoins"), //event coins
                rlst.getInt("RedColor"), //red color
                rlst.getInt("GreenColor"), //green color
                rlst.getInt("BlueColor"), //blue color
                rlst.getString("Country"), //country
                rlst.getString("sq"), //question
                rlst.getString("sa"),//answer
                "","","","","","","","","","","",""};

        dtm.addRow(OAccounts);
    	}catch(SQLException e) {}
    }
    void VTCharacters(DefaultTableModel dtm, int i, ResultSet rlst) {
    	try {
    		 Object[] OCharacters = new Object[] {"","","","","","","","","","","","",
                     i, //contador
                     rlst.getInt("CID"),//character id
                     rlst.getInt("AID"),//account id
                     rlst.getString("Name"),//name
                     setSex(rlst.getInt("Sex")), //sex
                     rlst.getInt("Level"),//level
                     rlst.getInt("XP"), //experience
                     rlst.getInt("BP"), //bounty
                     rlst.getInt("PlayTime"), //PlayTime
                     rlst.getInt("KillCount"), //KillCount
                     rlst.getInt("DeathCount"), //DeathCount
                     rlst.getInt("Ranking")};//ranking
    	        dtm.addRow(OCharacters);
    	}catch(SQLException e) {}
    }
    void VTLogin(DefaultTableModel dtm, int i, ResultSet rlst) {
    	try {
    		 Object[] OLogin = new Object[] {i,rlst.getInt("AID"),rlst.getString("UserID"),rlst.getString("Password"),rlst.getString("LastIP"),rlst.getString("LastConnDate")};
    	        dtm.addRow(OLogin);
    	}catch(SQLException e) {}
    }
    void VTClan(DefaultTableModel dtm, int i, ResultSet rlst) {
    	try {
    		 Object[] OClan = new Object[] {i,rlst.getInt("CLID"),rlst.getString("Name"),rlst.getString("MasterCID"),rlst.getInt("Point") - 1000,rlst.getString("Wins"),rlst.getString("Losses")};
    	        dtm.addRow(OClan);
    	}catch(SQLException e) {}
    }
    
    public void Actualizar_Accounts(JTable Table_AllAccounts){
        if(try_c()){ //realizar primero conexion
            try{
                sentencia = (Statement) conexion.createStatement();
                ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account");
                DefaultTableModel dtm = (DefaultTableModel) Table_AllAccounts.getModel();
                if (Table_AllAccounts.getRowCount()==0) { //verificar si esta vacia la tabla
                    int i = 0;
                    while (rlst.next()) {
                        i++;
                        VTAccounts(dtm, i,rlst);
                    }
                    hideRows(Table_AllAccounts, 12, 23);
                    showRows(Table_AllAccounts, 0, 11);
                }
                else{//update table despues de mostrar primer tabla
                    int i;
                    for (i = dtm.getRowCount() - 1; i >= 0; i--) {
                        dtm.removeRow(i);
                    }
                    i=0;
                    while (rlst.next()) {
                        i++;
                        VTAccounts(dtm, i,rlst);
                    }
                    hideRows(Table_AllAccounts, 12, 23);
                    showRows(Table_AllAccounts, 0, 11);
                }
            } catch (SQLException e) {JOptionPane.showMessageDialog(Table_AllAccounts, "4 No se pudo cargar los datos de Accounts: "+e);} 
        }
    }
    public void Actualizar_Characters(JTable Table_AllCharacters){
        
        if (try_c()) {
            try{
            sentencia = (Statement) conexion.createStatement();
            ResultSet rlst = sentencia.executeQuery("SELECT * from Character where DeleteFlag = 0");
            DefaultTableModel dtm = (DefaultTableModel) Table_AllCharacters.getModel();
            if (Table_AllCharacters.getRowCount()==0) { //verificar si esta vacia la tabla
                    int i = 0;
                    while (rlst.next()) {
                        i++;
                        VTCharacters(dtm, i,rlst);
                    }
                    hideRows(Table_AllCharacters, 0, 11);
                    showRows(Table_AllCharacters, 12, 23);
                }
                else{//update table despues de mostrar primer tabla
                    int i;
                    for (i = dtm.getRowCount() - 1; i >= 0; i--) {
                        dtm.removeRow(i);
                    }
                    i=0;
                    while (rlst.next()) {
                        i++;
                        VTCharacters(dtm, i,rlst);
                    }  
                    hideRows(Table_AllCharacters, 0, 11);
                    showRows(Table_AllCharacters, 12, 23);
                }
            }catch(SQLException e){JOptionPane.showMessageDialog(Table_AllCharacters, "5 No se pudo cargar los datos de Characters: "+e);}
        }
    }
    public void Actualizar_Login(JTable Table_Login) {
    	if(try_c()) {
    		try {
    		sentencia = (Statement) conexion.createStatement();
    		ResultSet rlst = sentencia.executeQuery("SELECT * FROM Login");
    		DefaultTableModel dtm = (DefaultTableModel) Table_Login.getModel();
			int i = 0;
    		if(Table_Login.getRowCount() == 0) {
    			while(rlst.next()) {
    				i++;
                    VTLogin(dtm, i,rlst);    				
    			}
    		}
    		else {
    			for(i = dtm.getRowCount() - 1; i>=0; i--) {
    				dtm.removeRow(i);
    			}
    			i=0;
    			while(rlst.next()) {
    				i++;
                    VTLogin(dtm, i,rlst);    				
    			}
    		}
    		}catch(Exception e) {System.out.println("No se pudo cargar los datos de Login, " +e);}
    	}
    }
    public void Actualizar_Clan(JTable Table_Clan) {
    	if(try_c()) {
    		try {
    			sentencia = (Statement) conexion.createStatement();
    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Clan where DeleteFlag = 0");
    			DefaultTableModel dtm = (DefaultTableModel) Table_Clan.getModel();
    			int i = 0;
    			if(Table_Clan.getRowCount()==0) {
    				while(rlst.next()) {
    					i++;
    					VTClan(dtm, i, rlst);
    				}
    			}
    			else {
    				for(i=dtm.getRowCount()-1; i >= 0; i--) {
    					dtm.removeRow(i);
    				}
        			i=0;
    				while(rlst.next()) {
    					i++;
    					VTClan(dtm, i, rlst);
    				}
    			}
    		}catch(SQLException e) {System.out.println("No se pudo cargar los datos de Clan, " +e);}
    	}
    }
    public void SendDCoins(int Type, int dCoins, String txtUser) {
    	if(try_c()) {
    		int _dCoins = 0;
			String userid=null;
    		switch(Type) {
			case 0:
				try {
	    			sentencia = (Statement) conexion.createStatement();
	    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account where UserID='" + txtUser + "'");
	    			if(rlst.next()) 
	    				_dCoins = rlst.getInt("DonatorCoins");
	    			else
	    				JOptionPane.showMessageDialog(null, "No existe usuario");
	    			System.out.println(_dCoins);
    				_dCoins = _dCoins + dCoins;
	    			
	    		}catch(SQLException e) {System.out.println("1.1No se pudo enviar DonatorCoins, " +e);}
	    		try {
	    			sentencia = (Statement) conexion.createStatement();
	    			sentencia.executeUpdate("UPDATE Account SET DonatorCoins=" + _dCoins + "where UserID='" + txtUser + "'");
	    			System.out.println(_dCoins);
	    		}catch(SQLException e) {System.out.println("1.2No se pudo enviar DonatorCoins, " +e);}
				break;
			case 1:
				try {
	    			sentencia = (Statement) conexion.createStatement();
	    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account where AID='" + txtUser + "'");
	    			if(rlst.next()) 
	    				_dCoins = rlst.getInt("DonatorCoins");
	    			else
	    				JOptionPane.showMessageDialog(null, "No existe usuario");
	    			System.out.println(_dCoins);
    				_dCoins = _dCoins + dCoins;
	    			
	    		}catch(SQLException e) {System.out.println("2.1No se pudo enviar DonatorCoins, " +e);}
	    		try {
	    			sentencia = (Statement) conexion.createStatement();
	    			sentencia.executeUpdate("UPDATE Account SET DonatorCoins=" + _dCoins + "where AID='" + txtUser + "'");
	    			System.out.println(_dCoins);
	    		}catch(SQLException e) {System.out.println("2.2No se pudo enviar DonatorCoins, " +e);}
				break;
			case 2:
				try {
	    			sentencia = (Statement) conexion.createStatement();
	    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account,Character where (Character.Name='" + txtUser + "' and Character.AID = Account.AID)");
	    			if(rlst.next()) {
	    				_dCoins = rlst.getInt("DonatorCoins");
	    				userid = rlst.getString("UserID");}
	    			else
	    				JOptionPane.showMessageDialog(null, "No existe usuario");
	    			System.out.println(_dCoins);
    				_dCoins = _dCoins + dCoins;
	    			
	    		}catch(SQLException e) {System.out.println("3.1No se pudo enviar DonatorCoins, " +e);}
	    		try {
	    			sentencia = (Statement) conexion.createStatement();
	    			sentencia.executeUpdate("UPDATE Account SET DonatorCoins=" + _dCoins + "where UserID='" + userid + "'");
	    			System.out.println(_dCoins);
	    		}catch(SQLException e) {System.out.println("3.2No se pudo enviar DonatorCoins, " +e);}
				break;
			}
    		
    	}
    }
    public void SendECoins(int Type, int eCoins, String txtUser) {
    	if(try_c()) {
    		int _eCoins = 0;
			String userid="";
    		switch(Type) {
			case 0:
				try {
	    			sentencia = (Statement) conexion.createStatement();
	    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account where UserID='" + txtUser + "'");
	    			if(rlst.next()) 
	    				_eCoins = rlst.getInt("EventCoins");
	    			else
	    				JOptionPane.showMessageDialog(null, "No existe usuario");
	    			System.out.println(_eCoins);
    				_eCoins = _eCoins + eCoins;
	    			
	    		}catch(SQLException e) {System.out.println("1.1No se pudo enviar EventCoins, " +e);}
	    		try {
	    			sentencia = (Statement) conexion.createStatement();
	    			sentencia.executeUpdate("UPDATE Account SET EventCoins=" + _eCoins + "where UserID='" + txtUser + "'");
	    			System.out.println(_eCoins);
	    		}catch(SQLException e) {System.out.println("1.2No se pudo enviar EventCoins, " +e);}
				break;
			case 1:
				try {
	    			sentencia = (Statement) conexion.createStatement();
	    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account where AID='" + txtUser + "'");
	    			if(rlst.next()) 
	    				_eCoins = rlst.getInt("EventCoins");
	    			else
	    				JOptionPane.showMessageDialog(null, "No existe usuario");
	    			System.out.println(_eCoins);
    				_eCoins = _eCoins + eCoins;
	    			
	    		}catch(SQLException e) {System.out.println("2.1No se pudo enviar EventCoins, " +e);}
	    		try {
	    			sentencia = (Statement) conexion.createStatement();
	    			sentencia.executeUpdate("UPDATE Account SET EventCoins=" + _eCoins + "where AID='" + txtUser + "'");
	    			System.out.println(_eCoins);
	    		}catch(SQLException e) {System.out.println("2.2No se pudo enviar EventCoins, " +e);}
				break;
			case 2:
				try {
	    			sentencia = (Statement) conexion.createStatement();
	    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account,Character where (Character.Name='" + txtUser + "' and Character.AID = Account.AID)");
	    			if(rlst.next()) {
	    				_eCoins = rlst.getInt("EventCoins");
	    				userid = rlst.getString("UserID");}
	    			else
	    				JOptionPane.showMessageDialog(null, "No existe usuario");
	    			System.out.println(_eCoins);
    				_eCoins = _eCoins + eCoins;
	    			
	    		}catch(SQLException e) {System.out.println("3.1No se pudo enviar EventCoins, " +e);}
	    		try {
	    			sentencia = (Statement) conexion.createStatement();
	    			sentencia.executeUpdate("UPDATE Account SET EventCoins=" + _eCoins + "where UserID='" + userid + "'");
	    			System.out.println(_eCoins);
	    		}catch(SQLException e) {System.out.println("3.2No se pudo enviar EventCoins, " +e);}
				break;
			}
    		
    	}
    }
    public void GetEditDCoins (JComboBox<?> Type, JTextField txtUserDonatorCEdit, JTextField txtInfoDonatorCoins, KeyEvent arg0) {
    	if(try_c()) {
    		int _dCoins = 0;
    		switch(Type.getSelectedIndex()) {
			case 0:
				try {
					if(!txtUserDonatorCEdit.getText().equals("")) {
	    			sentencia = (Statement) conexion.createStatement();
	    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account where UserID='" + txtUserDonatorCEdit.getText() + "'");
	    			if(rlst.next()) {
	    				_dCoins = rlst.getInt("DonatorCoins");
		    			System.out.println(_dCoins);
		    				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
		    					txtInfoDonatorCoins.setText(Integer.toString(_dCoins));
		    			}
						else {
							txtInfoDonatorCoins.setText("noInfo");
						}}
					}
				}catch(SQLException e) {System.out.println("1.1No se pudo encontrar DonatorCoins, " +e);}
				break;
			case 1:
				try {
					if(!txtUserDonatorCEdit.getText().equals("")) {
	    			sentencia = (Statement) conexion.createStatement();
	    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account where AID=" + txtUserDonatorCEdit.getText());
	    			if(rlst.next()) {
	    				_dCoins = rlst.getInt("DonatorCoins");
		    			System.out.println(_dCoins);
	    				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
	    					txtInfoDonatorCoins.setText(Integer.toString(_dCoins));
			    		}
		    			else {
								txtInfoDonatorCoins.setText("noInfo");
						}}
					}
	    		}catch(SQLException e) {System.out.println("2.1No se pudo encontrar DonatorCoins, " +e);}
				break;
			case 2:
				try {
					if(!txtUserDonatorCEdit.getText().equals("")) {
	    			sentencia = (Statement) conexion.createStatement();
	    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account,Character where Character.Name='" + txtUserDonatorCEdit.getText() + "' and Character.AID=Account.AID");
	    			if(rlst.next()) {
	    				_dCoins = rlst.getInt("DonatorCoins");
		    			System.out.println(_dCoins);
	    				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
	    					txtInfoDonatorCoins.setText(Integer.toString(_dCoins));
						}
		    			else {
							txtInfoDonatorCoins.setText("noInfo");
						}}
					}
	    		}catch(SQLException e) {System.out.println("1.1No se pudo encontrar DonatorCoins, " +e);}
				break;
			}
    	}
    }
    public void GetEditECoins (JComboBox<?> Type, JTextField txtUserEventCEdit, JTextField txtInfoEventCoins, KeyEvent arg0) {
    	if(try_c()) {
    		int _dCoins = 0;
    		switch(Type.getSelectedIndex()) {
			case 0:
				try {
					if(!txtUserEventCEdit.getText().equals("")) {
	    			sentencia = (Statement) conexion.createStatement();
	    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account where UserID='" + txtUserEventCEdit.getText() + "'");
	    			if(rlst.next()) {
	    				_dCoins = rlst.getInt("EventCoins");
		    			System.out.println(_dCoins);
		    				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
		    					txtInfoEventCoins.setText(Integer.toString(_dCoins));
		    			}
						else {
							txtInfoEventCoins.setText("noInfo");
						}}
					}
				}catch(SQLException e) {System.out.println("1.1No se pudo encontrar EventCoins, " +e);}
				break;
			case 1:
				try {
					if(!txtUserEventCEdit.getText().equals("")) {
	    			sentencia = (Statement) conexion.createStatement();
	    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account where AID=" + txtUserEventCEdit.getText());
	    			if(rlst.next()) {
	    				_dCoins = rlst.getInt("EventCoins");
		    			System.out.println(_dCoins);
	    				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
	    					txtInfoEventCoins.setText(Integer.toString(_dCoins));
			    		}
		    			else {
		    				txtInfoEventCoins.setText("noInfo");
						}}
					}
	    		}catch(SQLException e) {System.out.println("2.1No se pudo encontrar EventCoins, " +e);}
				break;
			case 2:
				try {
					if(!txtUserEventCEdit.getText().equals("")) {
	    			sentencia = (Statement) conexion.createStatement();
	    			ResultSet rlst = sentencia.executeQuery("SELECT * FROM Account,Character where Character.Name='" + txtUserEventCEdit.getText() + "' and Character.AID=Account.AID");
	    			if(rlst.next()) {
	    				_dCoins = rlst.getInt("EventCoins");
		    			System.out.println(_dCoins);
	    				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
	    					txtInfoEventCoins.setText(Integer.toString(_dCoins));
						}
		    			else {
		    				txtInfoEventCoins.setText("noInfo");
						}}
					}
	    		}catch(SQLException e) {System.out.println("1.1No se pudo encontrar EventCoins, " +e);}
				break;
			}
    	}
    }
    public void EditDCoins(JComboBox<?> Type, JTextField txtUserDonatorCEdit, JTextField txtNewDCoins, JTextField txtInfoDonatorCoins) {
    	if(try_c()) {
    		try {
				if(txtNewDCoins.getText().equals("")){JOptionPane.showMessageDialog(null, "Escribe una cantidad de Coins");return;}
	    			switch(Type.getSelectedIndex()) {
	    				case 0:
	    	    			sentencia = conexion.createStatement();
	    	    			if(!txtInfoDonatorCoins.getText().equals("noInfo")) {
	    	    				sentencia.executeUpdate("UPDATE Account SET DonatorCoins=" + Integer.parseInt(txtNewDCoins.getText()) + "where UserID='" + txtUserDonatorCEdit.getText() + "'");
	    	    				System.out.println(txtNewDCoins.getText()); JOptionPane.showMessageDialog(null, "DonatorCoins Actualizados");
	    	    			}else {JOptionPane.showMessageDialog(null, "Actualiza información de DonatorCoins con UserID");return;}
	    				break;
	    				case 1:
	    	    			sentencia = conexion.createStatement();
	    	    			if(!txtInfoDonatorCoins.getText().equals("noInfo")) {
	    	    				sentencia.executeUpdate("UPDATE Account SET DonatorCoins=" + Integer.parseInt(txtNewDCoins.getText()) + "where AID=" + Integer.parseInt(txtUserDonatorCEdit.getText()));
	    	    				System.out.println(txtNewDCoins.getText()); JOptionPane.showMessageDialog(null, "DonatorCoins Actualizados");
	    	    			}else {JOptionPane.showMessageDialog(null, "Actualiza información de DonatorCoins con AID");return;}
	    				break;
	    				case 2:
	    					String _UserID=null;
	    	    			sentencia = conexion.createStatement();
	    	    			try {
	    	    				ResultSet rlst = sentencia.executeQuery("Select * From Account,Character where Character.Name='" + txtUserDonatorCEdit.getText() + "' and Character.AID=Account.AID");
	    	    				if(rlst.next()) {
	    	    					_UserID = rlst.getString("UserID");
	    	    				}
	    	    			}catch(SQLException e) {JOptionPane.showMessageDialog(null, "2.1No se pudo obtener UserID " + e);return;}
	    	    			if(!txtInfoDonatorCoins.getText().equals("noInfo")) {
	    	    				sentencia.executeUpdate("UPDATE Account SET DonatorCoins=" + Integer.parseInt(txtNewDCoins.getText()) + "where UserID='" + _UserID + "'");
	    	    				System.out.println(txtNewDCoins.getText()); JOptionPane.showMessageDialog(null, "DonatorCoins Actualizados");
	    	    			}else {JOptionPane.showMessageDialog(null, "Actualiza información de DonatorCoins con Character");return;}
	    				break;
	    			}
    		}catch(SQLException e) {System.out.println("1No se pudo actualizar DonatorCoins " + e);}
    	}
    }
    public void EditECoins(JComboBox<?> Type, JTextField txtUserEventCEdit, JTextField txtNewECoins, JTextField txtInfoEventCoins) {
    	if(try_c()) {
    		try {
				if(txtNewECoins.getText().equals("")){JOptionPane.showMessageDialog(null, "Escribe una cantidad de Coins");return;}
	    			switch(Type.getSelectedIndex()) {
	    				case 0:
	    	    			sentencia = conexion.createStatement();
	    	    			if(!txtInfoEventCoins.getText().equals("noInfo")) {
	    	    				sentencia.executeUpdate("UPDATE Account SET EventCoins=" + Integer.parseInt(txtNewECoins.getText()) + "where UserID='" + txtUserEventCEdit.getText() + "'");
	    	    				System.out.println(txtNewECoins.getText()); JOptionPane.showMessageDialog(null, "EventCoins Actualizados");
	    	    			}else {JOptionPane.showMessageDialog(null, "Actualiza información de EventCoins con UserID");return;}
	    				break;
	    				case 1:
	    	    			sentencia = conexion.createStatement();
	    	    			if(!txtInfoEventCoins.getText().equals("noInfo")) {
	    	    				sentencia.executeUpdate("UPDATE Account SET EventCoins=" + Integer.parseInt(txtNewECoins.getText()) + "where AID=" + Integer.parseInt(txtUserEventCEdit.getText()));
	    	    				System.out.println(txtNewECoins.getText()); JOptionPane.showMessageDialog(null, "EventCoins Actualizados");
	    	    			}else {JOptionPane.showMessageDialog(null, "Actualiza información de EventCoins con AID");return;}
	    				break;
	    				case 2:
	    					String _UserID=null;
	    	    			sentencia = conexion.createStatement();
	    	    			try {
	    	    				ResultSet rlst = sentencia.executeQuery("Select * From Account,Character where Character.Name='" + txtUserEventCEdit.getText() + "' and Character.AID=Account.AID");
	    	    				if(rlst.next()) {
	    	    					_UserID = rlst.getString("UserID");
	    	    				}
	    	    			}catch(SQLException e) {JOptionPane.showMessageDialog(null, "2.1No se pudo obtener UserID " + e);return;}
	    	    			if(!txtInfoEventCoins.getText().equals("noInfo")) {
	    	    				sentencia.executeUpdate("UPDATE Account SET EventCoins=" + Integer.parseInt(txtNewECoins.getText()) + "where UserID='" + _UserID + "'");
	    	    				System.out.println(txtNewECoins.getText()); JOptionPane.showMessageDialog(null, "EventCoins Actualizados");
	    	    			}else {JOptionPane.showMessageDialog(null, "Actualiza información de EventCoins con Character");return;}
	    				break;
	    			}
    		}catch(SQLException e) {System.out.println("1No se pudo actualizar EventCoins " + e);}
    	}
    }    
    
    public void EditUserID (JComboBox<?> Type, JTextField txtUserEdit, JTextField txtNewUserID) {
    	
    }

    public void EditPassword (JComboBox<?> Type, JTextField txtPasswordEdit, JTextField txtNewPassword) {
    	
    }
    
    public void EditRange (JComboBox<?> Type, JTextField txtUserID, JComboBox<?> Range) {
    	
    }
    
    public void SendItemAllAccounts (JTextField txtItemID, JTextField txtDays) {
    	
    }
    
    public void SendItemAccount (JComboBox Type, JTextField txtUserID, JTextField txtItemID, JTextField txtDays	) {
    	
    }
    
    public void EditCountry (JComboBox Type, JTextField txtUserID, JTextField txtNewCountry) {
    	
    }
    
    String setSex(int Sex) {
    	if(Sex == 0)
    		return "Male";
    	else
    		return "Female";
    }
    public static void hideRows(JTable Table_AllRowsName, int min, int max) {
    	for(int i = min; i <= max; i++) {
    		Table_AllRowsName.getColumnModel().getColumn(i).setPreferredWidth(0);
    		Table_AllRowsName.getColumnModel().getColumn(i).setMinWidth(0);
    		Table_AllRowsName.getColumnModel().getColumn(i).setMaxWidth(0);
    	}
    }
    void showRows(JTable Table_AllRowsName, int min, int max) {
    	for(int i = min; i <= max; i++) {
    		Table_AllRowsName.getColumnModel().getColumn(i).setPreferredWidth(100);
    		Table_AllRowsName.getColumnModel().getColumn(i).setMinWidth(0);
    		Table_AllRowsName.getColumnModel().getColumn(i).setMaxWidth(100);
    	}
    }
    

}
