import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private static final List<User> users = new ArrayList<>();

    public static void registerUser(String username, String password) {
        users.add(new User(username, password));
    }

    public static boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
