package Model;
import java.sql.SQLException;
import java.util.List;

import Model.Class.*;

public interface TaskDAO {
    public void insertTask(Task task) throws SQLException;
    void updateTask(Task task) throws SQLException;
    void deleteTask(String taskName)  throws SQLException;
    List<Task> getAllTasks() throws SQLException;
}
