import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


public class CSVFileReader {

	public Map<String, EmployeeProject> readData(String fileName) throws Exception {
        Map<String, EmployeeProject> projectMap = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }
                String[] data = line.split(",");

                String empId = data[0];
                int projectId = Integer.parseInt(data[1]);
                String dateFromStr = data[2];
                String dateToStr = data[3];

                EmployeeProject project = projectMap.get(empId);
                if (project == null) {
                    project = new EmployeeProject(empId);
                    projectMap.put(empId, project);
                }

                project.addProject(projectId, dateFormat.parse(dateFromStr), dateToStr.isEmpty() ? null : dateFormat.parse(dateToStr));
            }
        }

        return projectMap;
    }
}
