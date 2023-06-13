package DataBase;

import java.sql.*;


/**
 * Класс, устанавливающий соединение с базой данных и позволяющий выполнять запросы
 */
public class MainDataBase {
    /**
     * Поле, хранящее ссылку на объект класса Connection
     */
    public static Connection connection;
    public static String username ="";

    //Класс Connection в Java используется для установления соединения с базами данных.

    /**
     * Метод, позволяющий установить соединение
     */
    public static void getConnection() {

        String user = "postgres";
        String password = "13131";
        String url = "jdbc:postgresql://localhost:5432/test_db";

        /*String user = "s368949";
        String password = "W4B3WDUkXkwHmyuu";
        String url = "jdbc:postgresql://db:5432/studs";*/

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод, работающий с запросами, которые ничего не возвращают
     *
     * @param request the request
     */
//метод, выполняет запрос без измененния данных
    public static void requestSQLWithout(String request) {
        getConnection();
        try {
            connection.createStatement().execute(request);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод, работающий с запросами, которые возвращающие информацию из базы данных
     *
     * @param request the request
     * @param values  the values
     * @return the result set
     */
//метод, выполняет запрос с измененния данных
    public static ResultSet requestSQLWith(String request, String... values) {
        getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            for (int i = 0; i < values.length; ++i) {
                preparedStatement.setString(i + 1, values[i]);
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    }

