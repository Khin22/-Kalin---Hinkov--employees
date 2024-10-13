import java.util.Map;


public class ProjectAnalyzer {

	public void analyze(String fileName) throws Exception {
        CSVFileReader reader = new CSVFileReader();
        Map<String, EmployeeProject> projectMap = reader.readData(fileName);

        // Find the employee pair with the longest shared project time
        int longestTime = 0;
        String empId1 = null;
        String empId2 = null;

        for (EmployeeProject project1 : projectMap.values()) {
            for (EmployeeProject project2 : projectMap.values()) {
                if (project1 == project2) {
                    continue; // Skip comparing the same employee
                }

                int sharedTime = project1.getSharedTime(project2);
                if (sharedTime > longestTime) {
                    longestTime = sharedTime;
                    empId1 = project1.getEmpId();
                    empId2 = project2.getEmpId();
                }
            }
        }

        // Print the result
        ResultPrinter printer = new ResultPrinter();
        if (longestTime > 0) {
            printer.printResult(empId1, empId2, longestTime);
        } else {
            printer.printNoResult();
        }
    }
}
