package actions;

import controllers.RoomController;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ControllerField {
    @Autowired
    private RoomController roomController;
}
