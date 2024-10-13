
public class ResultPrinter {
	
	public void printResult(String empId1, String empId2, int longestTime) {
        System.out.println(empId1 + ", " + empId2 + ", " + longestTime);
    }

    public void printNoResult() {
        System.out.println("No employees found working together on projects.");
    }
}
