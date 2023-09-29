package view;

public class ToChooseStart {
    public int toChoose() {
        ToReadAnswer answer=new ToReadAnswer();
        System.out.println("\n1 - Загрузить список животных питомника из файла\n" +
                "2 - Распечатать список животных питомника\n" +
                "3 - Добавить новое животное в список животных питомника\n" +
                "4 - Найти животное и распечатать список его команд\n" +
                "5 - Научить животное новой команде\n" +
                "6 - Сохранить список животных питомника в файл\n" +
                "7 - завершить работу.");
        return answer.readAnswer();
    }
}
