import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

public class OrderDaoJdbc implements OrderDao {

    private final Connection connection;

    public OrderDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    public List<Order> getUsersOrders(int user_id) {

        List<Order> orders = new ArrayList<>();
        String sql = "select * from orders where user_id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, user_id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    orders.add(
                            new Order(
                                    resultSet.getInt("id"),
                                    resultSet.getInt("user_id"),
                                    resultSet.getInt("amount"),
                                    resultSet.getTimestamp("created_at")
                            )
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public int getUsersOrdersCount(int user_id) {
        return getUsersOrders(user_id).size();
    }


    public void addUsersOrder(Order order) {

        String sql = "insert into orders (user_id, amount, created_at) values (?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, order.getUser_id());
            preparedStatement.setInt(2, order.getAmount());
            preparedStatement.setTimestamp(3, order.getCreated_at());
            preparedStatement.executeUpdate();

            System.out.println("Заказ добавлен пользователю " + order.getUser_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
