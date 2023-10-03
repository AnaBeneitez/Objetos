package ejemplojdbc;

//En Netbeans 17+ conviene importar java.sql.* porque sino no autocompleta las clases bien
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Les puede dar error por la librería de mariadb en su máquina.
Quiten las que figuran en Libraries y agreguen las propias.
*/
public class Programa {

    public static void main(String[] args) {
        //Creamos variables para cada elementos que usamos para trabajar con la DB
        Connection cn = null; //La conexión con la DB
        Statement stmt = null; //La "consola" en la que se ejecutan las consultas
        PreparedStatement pst = null; // Permite ejecutar consultas más eficientemente y con parámetros
        ResultSet rs = null; //Resultados traidos por una consulta
        String query; //String para la consulta SQL
        
        Producto p = new Producto();
        p.setNombre("Papas fritas");
        p.setPrecio(1000);
        p.setDisponible(true);
        
        try {
            //La conexión se hace por un DriverManager, que gestiona todo lo relacionado a ella.
            cn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/ejemplo?user=usuario_ejemplo&password=password_ejemplo");
            
            /*
            //Ejemplo de consulta con los valores embebidos en el string de SQL, es complicado de leer
            query = "insert into productos(nombre, precio, disponible)"
                    + "values('"+p.getNombre()+"',"+p.getPrecio()+","+p.isDisponible()+");";
            //Pedimos el Statement a la conexión. Según el tipo de DB y driver son los Statements que crea
            stmt = cn.createStatement();
            //Para ejecutar INSERT, UPDATE o DELETE usamos executeUpdate
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS); //RETURN_GENERATED_KEYS es para los ID que se generan
            //Los ID se recuperan a un ResultSet (conjunto de resultados), como si fueran filas de un SELECT
            rs = stmt.getGeneratedKeys();
            
            //Como es un único resultado, usamos un if. El ResultSet siempre arranca en el índice "antes del primero"
            if (rs.next()) { //.next retorna true si pudo ir al siguiente (primer) elemento del ResultSet
                p.setId(rs.getInt(1)); //El ResultSet nos permite recuperar todos los tipos de datos
            }
            
            System.out.println(p);
            */
            
            //Consulta para usar un PreparedStatement. Los ? son parámetros
            query = "insert into productos(nombre, precio, disponible)"
                    + "values(?, ?, ?);";
            
            //Pedimos un PreparedStatement a la conexión y le decimos que retornará IDs
            pst = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            //Seteamos lso parámetros según su tipo. Los índices son de 1 en adelante
            pst.setString(1, p.getNombre());
            pst.setInt(2, p.getPrecio());
            pst.setBoolean(3, p.isDisponible());
            pst.executeUpdate(); //Ejecutamos la consulta para modificar
            rs = pst.getGeneratedKeys(); //Recuperamos el conjunto de IDs
            
            //Hacemos lo mismo que en el ejemplo anterior
            if (rs.next()) {
                p.setId(rs.getInt(1));
            }
            
            /*
            //Lo interesante del PreparedSatement es que usamos una única consulta
            //para varios INSERT (por ejemplo)
            //Supongo una lista, que viene de ALGÚN LADO
            List<Producto> prods = new ArrayList();
            //..
            for (Producto q : prods) {
                pst.setString(1, q.getNombre());
                pst.setInt(2, q.getPrecio());
                pst.setBoolean(3, q.isDisponible());
                pst.executeUpdate();
                rs = pst.getGeneratedKeys();

                if (rs.next()) {
                    q.setId(rs.getInt(1));
                }
            }
            */
            
            
            //Los SELECT son también Statemnts/PreparedStatements
            query = "select id, nombre, precio, disponible from productos;";
            stmt = cn.createStatement();
            //Se ejecutan como Query porque retornan ResultSet y no actualizan datos
            rs = stmt.executeQuery(query);
            
            //Puede retornar 0, 1 o más resultados. Recorremos con un while
            while (rs.next()) { //MIENTRAS (haya-siguiente-elemento)
                p = new Producto();
                p.setId(rs.getInt("id")); //La recuperación de información se puede hacer por nombre de campo
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getInt(3)); //precio //También se puede recuperar por orden en el SELECT
                p.setDisponible(rs.getBoolean(4)); //disponible
                System.out.println(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /*
            El bloque finally se usa para liberar recurso.
            Para cada objeto de JDBC usado, comprobamos si existe y luego lo cerramos
            */
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException ex) {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (SQLException ex) {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (pst != null) {
                try {
                    pst.close();
                    pst = null;
                } catch (SQLException ex) {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
