package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * FileHandler
 */
public class FileHandler {

    public void saveToFile(Nursery listAnimals, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(listAnimals);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Nursery loadFromFile(String filename) {
        Nursery listAnimals = null;
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            listAnimals = ((Nursery) ois.readObject());
        } catch (Exception ex) {
            System.out.println("Файл " + filename + " не существует.");
        }
        return listAnimals;
    }
}
