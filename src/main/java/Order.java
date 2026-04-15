import java.sql.Timestamp;
import java.time.*;

public class Order {
    private int id;
    private int user_id;
    private int amount;
    private Timestamp created_at;

    public Order(int id, int user_id, int amount, Timestamp created_at) {
        this.id = id;
        this.user_id = user_id;
        this.amount = amount;
        this.created_at = created_at;
    }

    public Order(int user_id, int amount, Timestamp created_at) {
        this.user_id = user_id;
        this.amount = amount;
        this.created_at = created_at;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", amount=" + amount +
                ", created_at=" + created_at +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getAmount() {
        return amount;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }
}
