import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OfficeSpaceCommission extends JFrame implements ActionListener {
  
  private JLabel nameLabel, widthLabel, lengthLabel;
  private JComboBox nameList;
  private JPanel nPanel, cPanel, cPanel2, sPanel;
  private JTextField widthText, lengthText;
  private JRadioButton gardenChoice, streetChoice;
  private JButton submit, reset;
  private ButtonGroup choice;
  private String realtor, width, length, view;
  
  public OfficeSpaceCommission() {
    super("Office Space Commission");
    
    nameLabel = new JLabel("Select a realtor name:");
    String names [] = {"", "John Doe", "Jane Smith", "David Johnson"};
    nameList = new JComboBox(names);
    nPanel = new JPanel();
    nPanel.add(nameLabel);
    nPanel.add(nameList);
    add(nPanel, BorderLayout.NORTH);
    
    widthLabel = new JLabel("Enter width in feet:");
    widthText = new JTextField(10);
    lengthLabel = new JLabel("Enter length in feet:");
    lengthText = new JTextField(10);
    gardenChoice = new JRadioButton("Garden view");
    streetChoice = new JRadioButton("Street view");
    choice = new ButtonGroup();
    choice.add(gardenChoice);
    choice.add(streetChoice);
    cPanel = new JPanel();
    cPanel.setLayout(new GridLayout(3, 2));
    cPanel.add(widthLabel);
    cPanel.add(widthText);
    cPanel.add(lengthLabel);
    cPanel.add(lengthText);
    cPanel.add(gardenChoice);
    cPanel.add(streetChoice);
    cPanel2 = new JPanel();
    cPanel2.add(cPanel);
    add(cPanel2, BorderLayout.CENTER);
   
    submit = new JButton("Submit");
    submit.addActionListener(this);
    reset = new JButton("Reset");
    reset.addActionListener(this);
    sPanel = new JPanel();
    sPanel.add(submit);
    sPanel.add(reset);
    add(sPanel, BorderLayout.SOUTH);
    
    setSize(400, 190);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void actionPerformed(ActionEvent event) {
    if(event.getSource() == submit) {
       realtor = nameList.getSelectedItem().toString();
       width = widthText.getText();
       length = lengthText.getText();
       view = "";
       if(gardenChoice.isSelected()) {
         view = "Garden View";
       }
       else if(streetChoice.isSelected()) {
         view = "Street View";
       }
       
       int W = Integer.parseInt(width);
       int L = Integer.parseInt(length);
       int size = W * L;
       double monthly = size * 25.00;
       if(view.equals("Garden View"))
         monthly += 100.00;
       double yearly = monthly * 12;
       double commission = yearly * 0.05;
       
       String output = "Office Space Lease Summary" +
                       "\nRealtor Name: " + realtor +
                       "\nOffice Width: " + width + " ft" +
                       "\nOffice Length: " + length + " ft" +
                       "\n" + view +
                       "\nOffice Space: " + size + " square feet" +
                       "\nLeasing Fee Per Month: $" + monthly +
                       "\nLeasing Agreement For 1 Year: $" + yearly +
                       "\nLeasing Commission: $" + commission;
       JOptionPane.showMessageDialog(null, output);
       
       try {
         File file = new File("summary.txt"); 
         FileWriter writer = new FileWriter(file, true);
         writer.write(output + "\n\n");
         writer.close();
       }
       catch(IOException ioe) {
         System.out.println(ioe.toString());
       }
    }
    else if(event.getSource() == reset) {
       nameList.setSelectedIndex(0);
       widthText.setText("");
       lengthText.setText("");
       choice.clearSelection();
    }
  }
  
  public static void main(String [] args) {
     OfficeSpaceCommission osp = new OfficeSpaceCommission();
  }
}