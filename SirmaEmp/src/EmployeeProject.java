import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class EmployeeProject {
	private final String empId;
    private final Map<Integer, Project> projects;

    public EmployeeProject(String empId) {
        this.empId = empId;
        this.projects = new HashMap<>();
    }

    public String getEmpId() {
        return empId;
    }

    public void addProject(int projectId, Date dateFrom, Date dateTo) {
        projects.put(projectId, new Project(dateFrom, dateTo));
    }

    public int getSharedTime(EmployeeProject otherProject) {
        int totalTime = 0;
        for (Project project1 : projects.values()) {
            for (Project project2 : otherProject.projects.values()) {
                int overlap = project1.getOverlap(project2);
                if (overlap > 0) {
                    totalTime += overlap;
                }
            }
        }
        return totalTime;
    }
}
