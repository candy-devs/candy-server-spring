package candy.server.utils;

public class ScalarUtils {

    public static boolean inside(int target, int starts, int ends) {
        return starts <= target && target <= ends;
    }

}
