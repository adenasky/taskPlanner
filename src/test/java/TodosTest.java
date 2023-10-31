import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
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

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchQueryWithOneMatch(){
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("родителям");
        Task[] expected = {simpleTask};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchQueryWithTwoMatches(){
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(5, "Созвон с родителями");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(555, "Созвон по Zoom", "Приложение НетоБанка", "Во вторник после обеда");

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Созвон");
        Task[] expected = {simpleTask, meeting};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchQueryWithPartialMatches(){
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(5, "Созвониться с родителями");
        String[] subtasks = {"Созвон", "Уборка", "Прогулка"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(555, "Созвон по Zoom", "Приложение НетоБанка", "Во вторник после обеда");

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Созвон");
        Task[] expected = {simpleTask, epic, meeting};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchQueryWithNoMatch(){
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(5, "Созвон с родителями");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(555, "Созвон по Zoom", "Приложение НетоБанка", "Во вторник после обеда");

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] actual = todos.search("Собака");
        Task[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}