package service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*;

@WebService(serviceName = "postgre")
public class postgre {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "NombreEmpresa")
    public String NombreEmpresa(@WebParam(name = "nit") int nit) {
        String url = "jdbc:postgresql://localhost:5432/db328";
        String usu = "gio";
        String pass = "6059227";
        String a = "";
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url, usu, pass);
            java.sql.Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from empresa where nit=" + nit);
            while (rs.next()) {
                a = rs.getString(2);

            }
            rs.close();
            st.close();
            conexion.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return a;
    }
}
