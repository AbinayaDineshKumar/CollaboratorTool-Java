package Model;

import java.sql.SQLException;
import java.util.List;
import Model.Class.StudentRemarks;
public interface StudentRemarksDAO {
	 	public void insertStudentRemark(StudentRemarks studentRemark) throws SQLException;
	 	void updateStudentRemark(StudentRemarks studentRemark) throws SQLException;
	 	public void deleteStudentRemark(int userId) throws SQLException;
	    List<StudentRemarks> getStudentRemarksByUserId(int userId) throws SQLException;
	    List<StudentRemarks> getAllRemarks() throws SQLException;
	    
}
