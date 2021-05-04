package model.enumType;

public enum StatusRoom {
    REPAIRABLE,
    SERVICED,
    PREPARED;

    public static StatusRoom getByIndex(int index){ //роверка на графницы
        return StatusRoom.values()[index];
    }

}
