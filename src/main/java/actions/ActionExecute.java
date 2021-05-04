package actions;

public class ActionExecute {

    public static void execute(Action action) {
        try {
            action.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
