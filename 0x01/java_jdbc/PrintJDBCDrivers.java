import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {

    public static void main(String[] args) {

        System.out.println("Lista de todos os drivers dos diferentes fabricantes: ");
        for (Enumeration<Driver> driverEnumeration = DriverManager.getDrivers();
             driverEnumeration.hasMoreElements();){
            Driver driver = driverEnumeration.nextElement();
            print(driver);
        }

    }

    private static void print(Driver driver) {
        String nome = driver.getClass().getName();
        int versaoMajor = driver.getMajorVersion();
        int versaoMinor = driver.getMinorVersion();
        System.out.println("Nome: " + nome);
        System.out.println("Versão recente: " + versaoMajor);
        System.out.println("Versão antiga: " + versaoMinor);
    }
}
