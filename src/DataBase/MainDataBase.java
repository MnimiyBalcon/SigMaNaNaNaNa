package DataBase;

import java.sql.*;


/**
 * Класс, устанавливающий соединение с базой данных и позволяющий выполнять запросы
 */
public class MainDataBase {
    /**
     * Поле, хранящее ссылку на объект класса Connection
     */
    private static Connection connection;

    //Класс Connection в Java используется для установления соединения с базами данных.
    /**
     * Метод, позволяющий установить соединение
     */
    private static void getConnection() {
        try {
            connection = DriverManager.getConnection("", "", "");
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

