import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File; // This File class allows developers to create an actual text file.
import java.io.FileWriter; // This FIle Writer class developers write content or data into a text file.
import java.io.IOException; // This IOException class is required for the processess of 
							// using the FileWriter to write content into a correct file

public class MyFirstApp {

	private JFrame frmGraphicalUserInterface;
	private JTextField textFieldFullName;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFirstApp window = new MyFirstApp();
					window.frmGraphicalUserInterface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyFirstApp() throws IOException{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frmGraphicalUserInterface = new JFrame();
		frmGraphicalUserInterface.setTitle("Graphical User Interface Example");
		frmGraphicalUserInterface.setBounds(100, 100, 450, 300);
		frmGraphicalUserInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGraphicalUserInterface.getContentPane().setLayout(null);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFullName.setBounds(121, 6, 103, 16);
		frmGraphicalUserInterface.getContentPane().add(lblFullName);
		
		textFieldFullName = new JTextField();
		textFieldFullName.setBounds(236, 1, 130, 26);
		frmGraphicalUserInterface.getContentPane().add(textFieldFullName);
		textFieldFullName.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(156, 34, 68, 16);
		frmGraphicalUserInterface.getContentPane().add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(225, 34, 68, 19);
		frmGraphicalUserInterface.getContentPane().add(rdbtnMale);
		
		JRadioButton Comment = new JRadioButton("Female");
		buttonGroup.add(Comment);
		Comment.setBounds(303, 30, 141, 23);
		frmGraphicalUserInterface.getContentPane().add(Comment);
		
		JLabel lblHobbies = new JLabel("Hobbies:");
		lblHobbies.setBounds(163, 62, 61, 16);
		frmGraphicalUserInterface.getContentPane().add(lblHobbies);
		
		JCheckBox chckbxMovie = new JCheckBox("Movie");
		chckbxMovie.setBounds(225, 58, 76, 23);
		frmGraphicalUserInterface.getContentPane().add(chckbxMovie);
		
		JCheckBox chckbxMusic = new JCheckBox("Music");
		chckbxMusic.setBounds(303, 58, 76, 23);
		frmGraphicalUserInterface.getContentPane().add(chckbxMusic);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(163, 90, 61, 16);
		frmGraphicalUserInterface.getContentPane().add(lblStatus);
		
		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"-- Select A Status --", "Freshman", "Sophomore", "Junior", "Senior"}));
		comboBoxStatus.setToolTipText("");
		comboBoxStatus.setBounds(225, 90, 196, 27);
		frmGraphicalUserInterface.getContentPane().add(comboBoxStatus);
		
		JLabel lblComment = new JLabel("Comment:");
		lblComment.setBounds(156, 118, 97, 16);
		frmGraphicalUserInterface.getContentPane().add(lblComment);
		
		JTextArea textAreaComment = new JTextArea();
		textAreaComment.setBounds(236, 118, 126, 58);
		frmGraphicalUserInterface.getContentPane().add(textAreaComment);
		
		JButton btnSubmitButton = new JButton("Submit");
		btnSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("/Users/voko02/eclipse-workspace/Example1/src/guidata.txt");
				try { 
					FileWriter writer = new FileWriter(file);
				String fullName = textFieldFullName.getText();
				System.out.println("Full Name: " + fullName);
				writer.write("Full Name: " + fullName);
				String comment = textAreaComment.getText();
				System.out.println("Comment: " + comment);
				writer.write("\nComment: " + comment);
				String status = comboBoxStatus.getSelectedItem().toString();
				System.out.println("Status:" + status);
				writer.write("\nStatus:" + status);
				boolean movie = chckbxMovie.isSelected();
				System.out.println("Movie " + movie);
				writer.write("\nMovie " + movie);
				boolean music = chckbxMusic.isSelected();
				System.out.println("Music " + music);
				writer.write("\nMusic " + music);
				boolean male = rdbtnMale.isSelected();
				System.out.println("Male " + male);
				writer.write("\nMale " + male);
				boolean female = rdbtnMale.isSelected();
				System.out.println("Female " + female);
				writer.write("\nFemale " + female);
				writer.close(); } catch (IOException ioe) {}
				
			}
		});
		btnSubmitButton.setBounds(236, 188, 117, 29);
		frmGraphicalUserInterface.getContentPane().add(btnSubmitButton);
	}
}
