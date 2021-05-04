package runner;
import controllers.FacilityController;
import initializers.FacilityAnitializer;
import initializers.Initializer;
import initializers.RegistrationInitializer;
import initializers.RoomInitializer;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Initializer> initializers = Arrays.asList(
                new RoomInitializer(),
                new RegistrationInitializer(),
                new FacilityAnitializer()
        );

        initializers.forEach(Initializer::init);

        System.out.println(FacilityController.getInstance().getAll());
    }
}
