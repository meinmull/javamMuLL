package Aconexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

 
public class conexao {
	public Connection conn  = null ;
	public conexao(){
		try {
		String userName="root";
		String password ="";
		String url = "jdbc:mysql://localhost:3306/mydb";
				conn = DriverManager.getConnection(url,userName,password);
		}
		catch (Exception ex){
			System.err.println("-----------------------------");
			System.err.println("Não pode se conectar");
			System.err.println("-----------------------------");
			ex.printStackTrace();
		}
	}
 
}
