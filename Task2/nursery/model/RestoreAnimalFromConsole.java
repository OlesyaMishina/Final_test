package model;

import java.time.LocalDate;

import view.CollecterInfo;

public class RestoreAnimalFromConsole {

    public DomesticAnimal restoreAnimalFromConsole(Nursery listAnimals, CollecterInfo collecterInfo) {
        DomesticAnimal animal = new DomesticAnimal(0, "DomesticAnimal", collecterInfo.getType(),
                collecterInfo.getName(), null, null);
        System.out.println(animal.getName());
        // System.out.println(collecterInfo.getAnimalType());
        // System.out.println(collecterInfo.getName());
        if (listAnimals.getAnimalList() == null) {
            animal.setId(1);
            System.out.println(animal.getId());
        } else {
            int maxId = 0;
            for (int i = 0; i < listAnimals.getAnimalList().size(); i++) {
                if (listAnimals.getAnimalList().get(i).getId() > maxId)
                    maxId = listAnimals.getAnimalList().get(i).getId();
            }
            animal.setId(maxId + 1);
        }
        String[] dataBirth = collecterInfo.getBirthday().split("-");
        animal.setBirthday((LocalDate.of(Integer.parseInt(dataBirth[0]), Integer.parseInt(dataBirth[1]),
                Integer.parseInt(dataBirth[2]))));

        System.out.println(animal.toString());
        return animal;
    }
}
