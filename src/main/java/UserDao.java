import java.util.List;


public interface UserDao {
    List<User> findAllUsers();
    void addUser(User user);
}
