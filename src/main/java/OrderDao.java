import java.util.List;

public interface OrderDao {
    List<Order> getUsersOrders(int user_id);
    void addUsersOrder(Order order);
    int getUsersOrdersCount(int user_id);
}
