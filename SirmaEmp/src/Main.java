import java.io.File;

import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);


        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            String fileName = selectedFile.getAbsolutePath();

            ProjectAnalyzer 
 analyzer = new ProjectAnalyzer();
            try {
				analyzer.analyze(fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
        } else {
            System.out.println("No file selected.");
        }

	}

}
