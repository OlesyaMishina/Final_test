import Task2.project.model.Nursery;
import Task2.project.view.CollecterInfo;

public class RestoreAnimalFromConsole {
    public class RestoreToyFromConsole {
        public Animal restoreToyFromConsole(Nursery listAnimals, CollecterInfo collecterInfo) {
    
        Animal animal = new Animal(0, collecterInfo.getName(), collecterInfo.getBirthday());
        if (listAnimals.getNurseryList() == null)
            animal.setId(1);
        else {
            int maxId = 0;
            for (int i = 0; i < listAnimals.getNurseryList().size(); i++) {
                if (listAnimals.getNurseryList().get(i).getId() > maxId)
                    maxId = listAnimals.getNurseryList().get(i).getId();
            }
            animal.setId(maxId + 1);
        }
        return toy;
    }
}
}
