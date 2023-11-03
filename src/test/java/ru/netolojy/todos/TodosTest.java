package ru.netolojy.todos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTwoTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Молоко");
        ;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Помыть посуду");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Нагрузочное тестирование",
                "Приложение Банка",
                "Во вторник после обеда"
        );
        Object query;

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Протестировать Приложение");

        String[] subtasks = {"Молоко", "Приложение", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Нагрузочное тестирование",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        Todos todos = new Todos();


        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindZeroTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Помыть посуду");

        String[] subtasks = {"Молоко", "Помидор", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Нагрузочное тестирование",
                "Приложение Банка",
                "Во вторник после обеда"
        );


        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {};
        Task[] actual = todos.search("Мыло");
        Assertions.assertArrayEquals(expected, actual);
    }

}
