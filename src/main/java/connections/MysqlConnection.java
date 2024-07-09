package connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    private static MysqlConnection instance;
    private Connection connection;
    private String jdbcURL ="jdbc:mysql://localhost:3306/user_providers";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Sansa181188";

    //constructor de la clase conexion que es un singleton
    private MysqlConnection () throws SQLException{
        try{
            //busca el driver en la biblioteca y lo carga en memoria
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Setting de la clase connection con el driver manager
            // (le pasa las ruta de conexion del servidor BD y las credenciales para acceder a ella)
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }catch (ClassNotFoundException | SQLException e){
            throw new SQLException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    //Metodo para generar la instancia de singleton y acceder a esa intancia
    public static MysqlConnection getInstance() throws SQLException{
        // si la instancia no existe o la conexion a la bd fue cerrada se genera la instancia de la clase
        if(instance == null){
            instance = new MysqlConnection();
        }else if(instance.getConnection().isClosed()){
            instance = new MysqlConnection();
        }
     return instance;
    }
}
