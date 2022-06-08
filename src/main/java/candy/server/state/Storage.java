package candy.server.state;

public class Storage {

    private static final ThreadLocal<String> userId = new ThreadLocal<>();

    public static void setUserId(String id) {
        userId.set(id);
    }

    public static String getUserId() {
        return userId.get();
    }
}
