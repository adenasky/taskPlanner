import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    public void simpleTaskMatchesQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicMatchesQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        boolean actual = epic.matches("Молоко");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingMatchesQuery() {
        Meeting meeting = new Meeting(3, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean actual = meeting.matches("Выкатка");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

}