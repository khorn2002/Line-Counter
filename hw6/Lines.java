package hw6;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Lines {
	private JFrame frame;
	private JFileChooser fileChooser;
	private JTextField lines;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lines window = new Lines();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Lines() {
		initialize();
		int countLines = 0;
		boolean noCount = false;
		int r = fileChooser.showOpenDialog(null);
		
		if (r == JFileChooser.APPROVE_OPTION) {
			try {
				Scanner java_doc_scan = new Scanner(fileChooser.getSelectedFile());
				
				while(java_doc_scan.hasNextLine()) {
					String current_line = java_doc_scan.nextLine().strip();
					
					if (!noCount) {
						if (current_line.contains("/*")) {
							noCount = true;
						}
						else if (!current_line.contains("//") && current_line != "") { 
							countLines++;
						}
					}
					else {
						if(current_line.contains("*/")){
							noCount = false;
						}
					}
				}
			}
			catch (FileNotFoundException e){
				e.printStackTrace();
			}
			
			String sum = Integer.toString(countLines);
			
			lines.setText(sum);
			
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 829, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		fileChooser = new JFileChooser();
		fileChooser.setApproveButtonText("Select");
		fileChooser.setBounds(6, 6, 174, 57);
		frame.getContentPane().add(fileChooser);
		
		lines = new JTextField();
		lines.setBounds(254, 183, 221, 26);
		frame.getContentPane().add(lines);
		lines.setColumns(10);
		
		JLabel lbl = new JLabel("Lines of Code:");
		lbl.setBounds(151, 188, 51, 16);
		lbl.setSize(150,15);
		frame.getContentPane().add(lbl);
	}
}