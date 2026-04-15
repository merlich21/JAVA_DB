import java.sql.*;
import java.util.List;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/exam";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345678";

    public static void main(String[] args) {

        List<User> users;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            UserDaoJdbc udj = new UserDaoJdbc(connection);
            OrderDaoJdbc odj = new OrderDaoJdbc(connection);

            //Добавляем пользователей в БД
            udj.addUser(new User("alexa", "alexa@mail.ru"));
            udj.addUser(new User("steve", "steve@ya.ru"));

            //Получаем список всех пользователей из БД
            users = udj.findAllUsers();

            //Выводим список пользователей
            users.forEach(System.out::println);

            //Добавляем новый заказ пользователю
            odj.addUsersOrder(new Order(1, 4, Timestamp.valueOf("2026-04-06 16:45:03.123456789")));
            odj.addUsersOrder(new Order(1, 6, Timestamp.valueOf("2026-04-06 16:45:03.123456789")));
            odj.addUsersOrder(new Order(2, 1, Timestamp.valueOf("2026-04-06 16:45:03.123456789")));
            odj.addUsersOrder(new Order(1, 3, Timestamp.valueOf("2026-04-06 16:45:03.123456789")));

            //Получаем список заказов пользователя
            System.out.println("Заказы пользователя 1: " + odj.getUsersOrders(1));

            System.out.println("Заказы пользователя 2:" + odj.getUsersOrders(2));

            //Получаем общую сумму заказов пользователя
            System.out.println("Общая сумма заказов пользователя 1:"
                    + odj.getUsersOrdersCount(1));


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
