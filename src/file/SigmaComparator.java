package file;

import base.Vehicle;
import java.util.Comparator;

/**
 * Comparator сравнивающий драконов по возрасту и весу
 */
public class SigmaComparator implements Comparator<Vehicle> {
    /**Метод, который проводит сравнение по возрасту и весу*/
    @Override
    public int compare(Vehicle vehicle1, Vehicle vehicle2) {
        return vehicle1.getId() - vehicle2.getId();

    }
}