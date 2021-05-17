package runner;
import CSV.Writer;
import Config.SpringConfig;
import actions.ActionExecute;
import actions.hotel.create.CreateNewRoom;
import controllers.FacilityController;
import controllers.RoomController;
import initializers.FacilityAnitializer;
import initializers.Initializer;
import initializers.RegistrationInitializer;
import initializers.RoomInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationAttributes;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Initializer> initializers = Arrays.asList(
                new RoomInitializer(),
                new RegistrationInitializer(),
                new FacilityAnitializer()
        );

        initializers.forEach(Initializer::init);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
          SpringConfig.class
        );

        ActionExecute.execute(new CreateNewRoom());

    }
}
