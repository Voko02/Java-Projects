import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class RentalApp {

	private JFrame frmRentalCarReservation;
	private JTextField textFieldFIrstName;
	private JTextField textFieldMiddleName;
	private JLabel lblLastName;
	private JTextField textFieldLastName;
	private JLabel lblNewLabelDriverLicenseNumber;
	private JTextField textFieldDriverLicenseNumber;
	private JLabel lblRentalInformation;
	private JLabel lblPickUpDate;
	private JTextField textFieldPickUpDate;
	private JLabel lblPickUpTime;
	private JTextField textFieldDropOffTime;
	private JLabel lblPaymentOptions;
	private JTextField textFieldCard;
	private JTextField textFieldExpDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentalApp window = new RentalApp();
					window.frmRentalCarReservation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RentalApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRentalCarReservation = new JFrame();
		frmRentalCarReservation.setTitle("Rental Car Reservation System");
		frmRentalCarReservation.setBounds(100, 100, 700, 500);
		frmRentalCarReservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRentalCarReservation.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("FIrst Name: ");
		lblFirstName.setBounds(16, 6, 76, 16);
		frmRentalCarReservation.getContentPane().add(lblFirstName);
		
		textFieldFIrstName = new JTextField();
		textFieldFIrstName.setBounds(90, 1, 130, 26);
		frmRentalCarReservation.getContentPane().add(textFieldFIrstName);
		textFieldFIrstName.setColumns(10);
		
		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setBounds(232, 6, 99, 16);
		frmRentalCarReservation.getContentPane().add(lblMiddleName);
		
		textFieldMiddleName = new JTextField();
		textFieldMiddleName.setBounds(320, 1, 130, 26);
		frmRentalCarReservation.getContentPane().add(textFieldMiddleName);
		textFieldMiddleName.setColumns(10);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(462, 6, 99, 16);
		frmRentalCarReservation.getContentPane().add(lblLastName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(534, 1, 130, 26);
		frmRentalCarReservation.getContentPane().add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		lblNewLabelDriverLicenseNumber = new JLabel("Driver License Number:");
		lblNewLabelDriverLicenseNumber.setBounds(124, 39, 151, 16);
		frmRentalCarReservation.getContentPane().add(lblNewLabelDriverLicenseNumber);
		
		textFieldDriverLicenseNumber = new JTextField();
		textFieldDriverLicenseNumber.setBounds(287, 34, 130, 26);
		frmRentalCarReservation.getContentPane().add(textFieldDriverLicenseNumber);
		textFieldDriverLicenseNumber.setColumns(10);
		
		lblRentalInformation = new JLabel("Rental Information");
		lblRentalInformation.setBounds(134, 67, 123, 16);
		frmRentalCarReservation.getContentPane().add(lblRentalInformation);
		
		lblPickUpDate = new JLabel("Pick - Up Date (mm/dd/yy)");
		lblPickUpDate.setBounds(16, 93, 180, 16);
		frmRentalCarReservation.getContentPane().add(lblPickUpDate);
		
		textFieldPickUpDate = new JTextField();
		textFieldPickUpDate.setBounds(16, 118, 180, 26);
		frmRentalCarReservation.getContentPane().add(textFieldPickUpDate);
		textFieldPickUpDate.setColumns(10);
		
		lblPickUpTime = new JLabel("Pick-up Time");
		lblPickUpTime.setBounds(227, 93, 92, 16);
		frmRentalCarReservation.getContentPane().add(lblPickUpTime);
		
		JComboBox comboBoxPickUpTime = new JComboBox();
		comboBoxPickUpTime.setModel(new DefaultComboBoxModel(new String[] {"7:00 am", "8:00 am", "9:00 am", "10:00 am", "11:00 am", "12:00 pm", "1:00 pm", "2:00 pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm"}));
		comboBoxPickUpTime.setBounds(232, 119, 123, 27);
		frmRentalCarReservation.getContentPane().add(comboBoxPickUpTime);
		
		JLabel lblDropoffDate = new JLabel("Drop-off  Date (mm/dd/yy)");
		lblDropoffDate.setBounds(16, 156, 180, 16);
		frmRentalCarReservation.getContentPane().add(lblDropoffDate);
		
		JLabel lblDropoffTime = new JLabel("Drop-off Time");
		lblDropoffTime.setBounds(227, 156, 92, 16);
		frmRentalCarReservation.getContentPane().add(lblDropoffTime);
		
		textFieldDropOffTime = new JTextField();
		textFieldDropOffTime.setColumns(10);
		textFieldDropOffTime.setBounds(16, 183, 180, 26);
		frmRentalCarReservation.getContentPane().add(textFieldDropOffTime);
		
		JComboBox comboBoxPickUpTime_1 = new JComboBox();
		comboBoxPickUpTime_1.setModel(new DefaultComboBoxModel(new String[] {"7:00 am", "8:00 am", "9:00 am", "10:00 am", "11:00 am", "12:00 pm", "1:00 pm", "2:00 pm", "3:00 pm", "4:00 pm", "5:00 pm", "6:00 pm", "7:00 pm"}));
		comboBoxPickUpTime_1.setBounds(232, 184, 123, 27);
		frmRentalCarReservation.getContentPane().add(comboBoxPickUpTime_1);
		
		lblPaymentOptions = new JLabel("Payment Options");
		lblPaymentOptions.setBounds(525, 93, 114, 16);
		frmRentalCarReservation.getContentPane().add(lblPaymentOptions);
		
		JRadioButton rdbtnVisa = new JRadioButton("Visa");
		rdbtnVisa.setBounds(523, 119, 141, 23);
		frmRentalCarReservation.getContentPane().add(rdbtnVisa);
		
		JRadioButton rdbtnMastercard = new JRadioButton("MasterCard");
		rdbtnMastercard.setBounds(523, 149, 141, 23);
		frmRentalCarReservation.getContentPane().add(rdbtnMastercard);
		
		JRadioButton rdbtnAmex = new JRadioButton("Amex");
		rdbtnAmex.setBounds(523, 184, 141, 23);
		frmRentalCarReservation.getContentPane().add(rdbtnAmex);
		
		JRadioButton rdbtnDiscover = new JRadioButton("Discover");
		rdbtnDiscover.setBounds(523, 219, 141, 23);
		frmRentalCarReservation.getContentPane().add(rdbtnDiscover);
		
		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setBounds(534, 254, 92, 16);
		frmRentalCarReservation.getContentPane().add(lblCardNumber);
		
		textFieldCard = new JTextField();
		textFieldCard.setBounds(534, 270, 130, 26);
		frmRentalCarReservation.getContentPane().add(textFieldCard);
		textFieldCard.setColumns(10);
		
		JLabel lblExpirationDate = new JLabel("Expiration Date:");
		lblExpirationDate.setBounds(534, 303, 114, 16);
		frmRentalCarReservation.getContentPane().add(lblExpirationDate);
		
		textFieldExpDate = new JTextField();
		textFieldExpDate.setColumns(10);
		textFieldExpDate.setBounds(534, 321, 130, 26);
		frmRentalCarReservation.getContentPane().add(textFieldExpDate);
		
		JLabel lblCarType = new JLabel("Select Car Type:");
		lblCarType.setBounds(16, 226, 114, 16);
		frmRentalCarReservation.getContentPane().add(lblCarType);
		
		JComboBox comboBoxCarType = new JComboBox();
		comboBoxCarType.setModel(new DefaultComboBoxModel(new String[] {"Economy ", "Compact", "Mid-Size", "Standard", "Full-Size", "Premium", "Luxury", "Convertible", "Minivan", "SUV"}));
		comboBoxCarType.setBounds(232, 223, 123, 27);
		frmRentalCarReservation.getContentPane().add(comboBoxCarType);
		
		JLabel lblOptional = new JLabel("Optional:");
		lblOptional.setBounds(16, 275, 61, 16);
		frmRentalCarReservation.getContentPane().add(lblOptional);
		
		JCheckBox chckbxGPS = new JCheckBox("GPS");
		chckbxGPS.setBounds(161, 271, 61, 23);
		frmRentalCarReservation.getContentPane().add(chckbxGPS);
		
		JCheckBox chckbxInsurance = new JCheckBox("Insurance");
		chckbxInsurance.setBounds(242, 271, 99, 23);
		frmRentalCarReservation.getContentPane().add(chckbxInsurance);
		
		JLabel lblSpecialRequest = new JLabel("Special Request:");
		lblSpecialRequest.setBounds(16, 326, 102, 16);
		frmRentalCarReservation.getContentPane().add(lblSpecialRequest);
		
		JTextArea textAreaSpecialRequest = new JTextArea();
		textAreaSpecialRequest.setBounds(16, 342, 234, 74);
		frmRentalCarReservation.getContentPane().add(textAreaSpecialRequest);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(158, 437, 117, 29);
		frmRentalCarReservation.getContentPane().add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(300, 437, 117, 29);
		frmRentalCarReservation.getContentPane().add(btnReset);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(444, 437, 117, 29);
		frmRentalCarReservation.getContentPane().add(btnSearch);
	}
}
