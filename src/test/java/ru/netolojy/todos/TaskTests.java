package ru.netolojy.todos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTests {

    @Test
    public void shouldRecognizeSimpleTask() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Object query;

        Task task = new Task(5);

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRecognizeSimpleTask() {

        SimpleTask simpleTask = new SimpleTask(5, "Помыть посуду");

        Object query;

        Task task = new Task(5);

        boolean expected = false;
        boolean actual = simpleTask.matches("Позвонить родителям");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldRecognizeMeetingByTopic() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Object query;

        Task task = new Task(555);

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldRecognizeMeetingByProject() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Object query;

        Task task = new Task(555);

        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");

        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void shouldNotRecognizeMeeting() {

        Meeting meeting = new Meeting(
                555,
                "нагрузочное тестирование",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Object query;

        Task task = new Task(555);

        boolean expected = false;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldRecognizeEpic() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Object query;

        Task task = new Task(55);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotRecognizeEpic() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Object query;

        Task task = new Task(55);

        boolean expected = false;
        boolean actual = epic.matches("Мыло");

        Assertions.assertEquals(expected, actual);

    }


}
