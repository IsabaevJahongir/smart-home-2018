package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class HallDoorEventProcessor {

    public static void processHallDoorEvent(SmartHome smartHome, SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (room.getName().equals("hall")) {
                    for (Room homeRoom : smartHome.getRooms()) {
                        for (Light light : homeRoom.getLights()) {
                            light.setOn(false);
                            SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                            SensorCommandExecutor.sendCommand(command);
                        }
                    }
                }
            }
        }
    }
}
