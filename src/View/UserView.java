package View;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Controller.UserController;
import Model.ProjectDAOImpl;
import Model.ReportDAOImpl;
import Model.StudentRemarksDAOImpl;
import Model.StudentTaskDAO;
import Model.TaskDAOImpl;
import Model.Class.Project;
import Model.Class.Report;
import Model.Class.StudentRemarks;
import Model.Class.StudentTask;
import Model.Class.Task;
public class UserView {
    public static Scanner scanner = new Scanner(System.in);

    public static void start(Connection connection) throws SQLException {
        showMainMenu(connection);
    }

    private static void showMainMenu(Connection connection) throws SQLException {
        while (true) {
        	System.out.println("+-------------------------+");
            System.out.println("|         Main Menu       |");
            System.out.println("+--+----------------------+");
            System.out.println("| 1| Register new user    |");
            System.out.println("| 2| Login                |");
            System.out.println("| 3| Exit                 |");
            System.out.println("+--+----------------------+");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:{
                    UserController.registerUser(connection, scanner);
                    break;
                }
                case 2:{
                    UserController.loginUser(connection, scanner);
                    break;
                }
                case 3:{
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                }
                default:{
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    public static void studentMenu(Connection connection) throws SQLException {
        while (true) {
        	System.out.println("+----------------------------+");
        	System.out.println("|            Menu            |");
        	System.out.println("+----------------------------+");
        	System.out.println("| 1. Upload Project Details  |");
        	System.out.println("| 2. Upload Report Details   |");
        	System.out.println("| 3. View Task Scheduled     |");
        	System.out.println("| 4. View Remarks Uploaded   |");
        	System.out.println("| 5. Update Project Details  |");
        	System.out.println("| 6. Update Report Details   |");
        	System.out.println("| 7. Upload Task Details     |");
        	System.out.println("| 8. Logout                  |");
        	System.out.println("+----------------------------+");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:{
                    uploadProjectDetails(connection);
                    break;
                }
                case 2:{
                    uploadReportDetails(connection);
                    break;
                }
                case 3:{
                    viewTaskScheduled(connection);
                    break;
                }
                case 4:{
                    viewRemarksUploaded(connection);
                    break;
                }
                case 5:{
                	updateProject(connection);
                	break;
                }
                case 6:{
                	updateReport(connection);
                    break;
                }
                case 7:{
                	uploadStudentTask(connection);
                	break;
                }
                case 8:{
                    System.out.println("Logging out...");
                    return;
                }
                default:{
                    System.out.println("Invalid choice. Please try again.");
                    break;
                }
            }
        }
    }
    
    public static void teacherMenu(Connection connection) throws SQLException {
        while (true) {
        	System.out.println("+----------------------------+");
        	System.out.println("|           Menu             |");
        	System.out.println("+----------------------------+");
        	System.out.println("| 1. Upload Student Remark   |");
        	System.out.println("| 2. Upload Tasks            |");
        	System.out.println("| 3. View Projects           |");
        	System.out.println("| 4. View Reports            |");
        	System.out.println("| 5. Update Task Details     |");
        	System.out.println("| 6. Update Remarks Uploaded |");
        	System.out.println("| 7. View Task Status        |");
        	System.out.println("| 8. Logout                  |");
        	System.out.println("+----------------------------+");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:{
                    uploadStudentRemark(connection);
                    break;
                }
                case 2:{
                    uploadTasks(connection);
                    break;
                }
                case 3:{
                    viewProjects(connection);
                    break;
                }
                case 4:{
                    viewReports(connection);
                    break;
                }
                case 5:{
                	updateTasks(connection);
                	break;
                }
                case 6:{
                	updateStudentRemarks(connection);
                	break;
                }
                case 7:{
                	viewStudentTasks(connection);
                	break;
                }
                case 8:{
                    System.out.println("Logging out...");
                    return;
                }
                default:{
                    System.out.println("Invalid choice. Please try again.");
                    break;
                }
            }
        }
    }
	private static void uploadProjectDetails(Connection connection) throws SQLException {
        System.out.println("Uploading project details...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter project ID: ");
        int projectId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter project name: ");
        String projectName = scanner.nextLine();
        System.out.print("Enter project domain: ");
        String projectDomain = scanner.nextLine();
        System.out.print("Enter project objective: ");
        String projectObjective = scanner.nextLine();
        System.out.print("Enter mentor name: ");
        String mentorName = scanner.nextLine();
        Project project = new Project(userId,projectId, projectName, projectDomain, projectObjective, mentorName);
        ProjectDAOImpl.insertProject(connection, project);
        System.out.println("Project Uploaded Successfully");
    }

	 private static void uploadReportDetails(Connection connection) throws SQLException {
	        System.out.println("Uploading report details...");

	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter report ID: ");
	        int reportId = scanner.nextInt();
	        scanner.nextLine();
	        
	        System.out.print("Enter user ID: ");
	        int userId = scanner.nextInt();
	        scanner.nextLine(); 
	        
	        System.out.print("Enter project ID: ");
	        int projectId = scanner.nextInt();
	        scanner.nextLine(); 
	        
	        System.out.print("Enter report progress: ");
	        String reportProgress = scanner.nextLine();
	        
	        System.out.print("Enter reporting date (YYYY-MM-DD): ");
	        String reportingDateString = scanner.nextLine();
	        Date reportingDate = Date.valueOf(reportingDateString); 
	        Report report = new Report(reportId, userId, projectId, reportProgress, reportingDate);
	        ReportDAOImpl reportDAO = new ReportDAOImpl(connection);
	        reportDAO.insertReport(report);
	    }
	    private static void viewTaskScheduled(Connection connection) throws SQLException {
	        System.out.println("Viewing task scheduled...");
	        TaskDAOImpl taskDAO = new TaskDAOImpl(connection);
	        List<Task> tasks = taskDAO.getAllTasks();
	        System.out.println(Task.getColumnHeaders());
	        //printTableBorderTask();
	        for (Task task : tasks) {
	            System.out.print(task);
	        }
	        printTableBorderTask();
	    }
	  

	  private static void viewRemarksUploaded(Connection connection) throws SQLException {
	        System.out.println("Viewing remarks uploaded...");
	        StudentRemarksDAOImpl remarksDAO = new StudentRemarksDAOImpl(connection);
	        List<StudentRemarks> remarks = remarksDAO.getAllRemarks();
	        System.out.println(StudentRemarks.getColumnHeaders());
	       
	        for (StudentRemarks remark : remarks) {
	            System.out.print(remark);
	        }
	        printTableBorderremarks();
	    }

	  private static void viewReports(Connection connection) throws SQLException {
	        System.out.println("Viewing reports...");
	        ReportDAOImpl reportDAO = new ReportDAOImpl(connection);
	        List<Report> reports = reportDAO.getAllReports();
	        System.out.println(Report.getColumnHeaders());
	        printTableBorderreport();
	        for (Report report : reports) {
	            System.out.print(report);
	        }
	            printTableBorderreport();
	    }
	  private static void viewProjects(Connection connection) throws SQLException {
	        System.out.println("Viewing projects...");
	        ProjectDAOImpl projectDAO = new ProjectDAOImpl(connection);
	        List<Project> projects = projectDAO.getAllProjects();
	        System.out.println(Project.getColumnHeaders());
	        printTableBorderproject();
	        for (Project project : projects) {
	            System.out.println(project);
	        }
	        printTableBorderproject();
	    }
	  private static void viewStudentTasks(Connection connection) throws SQLException {
		    System.out.println("Viewing tasks...");
		    StudentTaskDAO taskDAO = new StudentTaskDAO(connection);
		    List<StudentTask> tasks = taskDAO.getAllTasks();
		    System.out.println(StudentTask.getColumnHeaders());
		    for (StudentTask task : tasks) {
		        System.out.print(task);
		    }
		    printTableBorderTask2();
		}
	    public static void uploadStudentTask(Connection connection) throws SQLException {
	        System.out.println("Uploading student task...");
	        System.out.print("Enter User ID: ");
	        int userId = scanner.nextInt();
	        scanner.nextLine(); 
	        System.out.print("Enter User Name: ");
	        String userName = scanner.nextLine();
	        System.out.print("Enter Task Name: ");
	        String taskName = scanner.nextLine();
	        System.out.print("Enter Task Status: ");
	        String taskStatus = scanner.nextLine();
	        System.out.print("Enter Date of Completion (YYYY-MM-DD): ");
	        String dateOfCompletion = scanner.nextLine();
	        StudentTask studentTask = new StudentTask(userId, userName, taskName, taskStatus, dateOfCompletion);
	        StudentTaskDAO taskDAO = new StudentTaskDAO(connection);
	        taskDAO.insertTask(studentTask);
	        System.out.println("Student task uploaded successfully!");
	    }


	  private static void uploadTasks(Connection connection) throws SQLException {
	        System.out.println("Uploading tasks...");
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter task name: ");
	        String taskName = scanner.nextLine();
	        System.out.print("Enter task type: ");
	        String taskType = scanner.nextLine();
	        System.out.print("Enter due date (YYYY-MM-DD): ");
	        String dueDateString = scanner.nextLine();
	        Date dueDate = Date.valueOf(dueDateString);
	        System.out.print("Enter subject name: ");
	        String subjectName = scanner.nextLine();
	        Task task = new Task(taskName, taskType, dueDate, subjectName);
	        TaskDAOImpl taskDAO = new TaskDAOImpl(connection);
	        taskDAO.insertTask(task);
	    }
	    private static void uploadStudentRemark(Connection connection) throws SQLException {
	        System.out.println("Uploading student remark...");
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter user ID: ");
	        int userId = scanner.nextInt();
	        scanner.nextLine();
	        System.out.print("Enter feedback on project: ");
	        String feedbackOnProject = scanner.nextLine();
	        System.out.print("Enter remark: ");
	        String remark = scanner.nextLine();
	        StudentRemarks remarkObj = new StudentRemarks(userId, feedbackOnProject, remark);
	        StudentRemarksDAOImpl remarksDAO = new StudentRemarksDAOImpl(connection);
	        remarksDAO.insertStudentRemark(remarkObj);
	        
	    }
	    private static void updateTasks(Connection connection) throws SQLException {
	        System.out.println("Update Task Details");
	        System.out.print("Enter task name: ");
	        String taskName = scanner.nextLine();
	        System.out.print("Enter updated task type: ");
	        String taskType = scanner.nextLine();
	        System.out.print("Enter updated due date (YYYY-MM-DD): ");
	        String dueDateString = scanner.nextLine();
	        Date dueDate = Date.valueOf(dueDateString);
	        System.out.print("Enter Subject Name:");
	        String subjectName=scanner.nextLine();
	        Task taskToUpdate = new Task(taskName, taskType, dueDate,subjectName);
	        TaskDAOImpl taskDAO = new TaskDAOImpl(connection);
	        taskDAO.updateTask(taskToUpdate);
	        System.out.println("Task updated successfully!");
	    }
	    private static void updateStudentRemarks(Connection connection) throws SQLException {
	        System.out.println("Update Student Remarks");
	        System.out.print("Enter userId: ");
	        int userId = scanner.nextInt();
	        scanner.nextLine(); 
	        System.out.print("Enter updated feedback on project: ");
	        String feedbackOnProject = scanner.nextLine();
	        System.out.print("Enter updated remark: ");
	        String remark = scanner.nextLine();
	        StudentRemarks remarksToUpdate = new StudentRemarks(userId, feedbackOnProject, remark);
	        StudentRemarksDAOImpl remarksDAO = new StudentRemarksDAOImpl(connection);
	        remarksDAO.updateStudentRemark(remarksToUpdate);
	        System.out.println("Student remarks updated successfully!");
	    }
	    private static void updateProject(Connection connection) throws SQLException {
	        System.out.println("Update Project Details");
	        System.out.print("Enter User ID:");
	        int userId=scanner.nextInt();
	        System.out.print("Enter project ID: ");
	        int projectId = scanner.nextInt();
	        scanner.nextLine(); 
	        System.out.print("Enter updated project name: ");
	        String projectName = scanner.nextLine();
	        System.out.print("Enter updated project domain: ");
	        String projectDomain = scanner.nextLine();
	        System.out.print("Enter updated project objective: ");
	        String projectObjective = scanner.nextLine();
	        System.out.print("Enter updated mentor name: ");
	        String mentorName = scanner.nextLine();
	        Project projectToUpdate = new Project(userId,projectId, projectName, projectDomain, projectObjective, mentorName);
	        ProjectDAOImpl projectDAO = new ProjectDAOImpl(connection);
	        projectDAO.updateProject(projectToUpdate);
	        System.out.println("Project updated successfully!");
	    }
	    private static void updateReport(Connection connection) throws SQLException {
	        System.out.println("Update Report Details");
	        System.out.print("Enter report ID: ");
	        int reportId = scanner.nextInt();
	        System.out.print("Enter User ID:");
	        int userId=scanner.nextInt();
	        System.out.print("Enter Project ID:");
	        int projectId=scanner.nextInt();
	        scanner.nextLine(); 
	        System.out.print("Enter updated report progress: ");
	        String reportProgress = scanner.nextLine();
	        System.out.print("Enter updated reporting date (YYYY-MM-DD): ");
	        String reportingDateStr = scanner.nextLine();
	        Date reportingDate = Date.valueOf(reportingDateStr);
	        Report reportToUpdate = new Report(reportId,userId,projectId, reportProgress, reportingDate);
	        ReportDAOImpl reportDAO = new ReportDAOImpl(connection);
	        reportDAO.updateReport(reportToUpdate);
	        System.out.println("Report updated successfully!");
	    }
	    private static void printTableBorderproject() {
	        System.out.format("|----------------------|----------------------|----------------------|----------------------|----------------------|----------------------|%n");
	    }
	    private static void printTableBorderTask() {
	        System.out.format("|----------------------|----------------------|-----------------|----------------------|%n");
	    }
	    private static void printTableBorderreport() {
	        System.out.format("|----------------------|----------------------|----------------------|----------------------|%n");
	    }
	    private static void printTableBorderremarks() {
	        System.out.format("|----------------------|----------------------|----------------------|%n");
	    }
	    private static void printTableBorderTask2() {
	        System.out.format("+----------------------|----------------------|----------------------|----------------------|-------------------------|%n");
	    }




}