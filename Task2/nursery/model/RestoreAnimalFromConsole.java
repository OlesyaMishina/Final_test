package model;

import java.time.LocalDate;

import model.baggageAnimal.BaggageAnimal;
import model.domesticAnimal.DomesticAnimal;
import view.CollecterInfo;

//Собирает экземпляр животного используя информациюи от пользователя

public class RestoreAnimalFromConsole {

    public Animal restoreAnimalFromConsole(Nursery listAnimals, CollecterInfo collecterInfo) {
        DomesticAnimal animalD = new DomesticAnimal(0, "DomesticAnimal", collecterInfo.getType(),
                collecterInfo.getName(), null, null);
        BaggageAnimal animalB = new BaggageAnimal(0, "BaggageAnimal", collecterInfo.getType(),
                collecterInfo.getName(), null, null);
        if (collecterInfo.getType() == AnimalType.Cat | collecterInfo.getType() == AnimalType.Dog
                | collecterInfo.getType() == AnimalType.Hamster) {

            // System.out.println(animalD.getName());
            if (listAnimals.getAnimalList() == null) {
                animalD.setId(1);
                System.out.println(animalD.getId());
            } else {
                int maxId = 0;
                for (int i = 0; i < listAnimals.getAnimalList().size(); i++) {
                    if (listAnimals.getAnimalList().get(i).getId() > maxId)
                        maxId = listAnimals.getAnimalList().get(i).getId();
                }
                animalD.setId(maxId + 1);
            }
            String[] dataBirth = collecterInfo.getBirthday().split("-");
            animalD.setBirthday((LocalDate.of(Integer.parseInt(dataBirth[0]), Integer.parseInt(dataBirth[1]),
                    Integer.parseInt(dataBirth[2]))));
            System.out.println(animalD.toString());
            return animalD;
        }

        if (collecterInfo.getType() == AnimalType.Donkey | collecterInfo.getType() == AnimalType.Horse
                | collecterInfo.getType() == AnimalType.Camel) {

            if (listAnimals.getAnimalList() == null) {
                animalB.setId(1);
                System.out.println(animalB.getId());
            } else {
                int maxId = 0;
                for (int i = 0; i < listAnimals.getAnimalList().size(); i++) {
                    if (listAnimals.getAnimalList().get(i).getId() > maxId)
                        maxId = listAnimals.getAnimalList().get(i).getId();
                }
                animalB.setId(maxId + 1);
            }
            String[] dataBirth = collecterInfo.getBirthday().split("-");
            animalB.setBirthday((LocalDate.of(Integer.parseInt(dataBirth[0]), Integer.parseInt(dataBirth[1]),
                    Integer.parseInt(dataBirth[2]))));

            System.out.println(animalB.toString());
        }
        return animalB;
    }

}
