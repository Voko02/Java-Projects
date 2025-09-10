import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.util.Timer;
import java.util.TimerTask;

public class CurrencyExchangeApp extends JFrame implements ActionListener {
  private JLabel passportLabel, dollarLabel, toLabel;
  private JTextField passportNumber, dollarAmount;
  private JPanel nPanel, cPanel, sPanel;
  private JComboBox currency;
  private JButton exchange, clear, print;
  
  public CurrencyExchangeApp() {
    super("Currency Exchange Service");
    passportLabel = new JLabel("Passport Number:");
    passportNumber = new JTextField(10);
    nPanel = new JPanel();
    nPanel.add(passportLabel);
    nPanel.add(passportNumber);
    add(nPanel, BorderLayout.NORTH);
    
    dollarLabel = new JLabel("US Dollar Amount: $");
    dollarAmount = new JTextField(5);
    toLabel = new JLabel("To:");
    String option [] = {"", "British Pound", "Canadian Dollar"};
    currency = new JComboBox(option);
    cPanel = new JPanel();
    cPanel.add(dollarLabel);
    cPanel.add(dollarAmount);
    cPanel.add(toLabel);
    cPanel.add(currency);
    add(cPanel, BorderLayout.CENTER);
    
    exchange = new JButton("Exchange");
    exchange.addActionListener(this);
    clear = new JButton("Clear");
    clear.addActionListener(this);
    print = new JButton("Print Transaction");
    sPanel = new JPanel();
    sPanel.add(exchange);
    sPanel.add(clear);
    sPanel.add(print);
    add(sPanel, BorderLayout.SOUTH);
    
    setSize(400, 150);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void actionPerformed(ActionEvent event) {
    if(event.getSource() == exchange) { // if exchange button is clicked
      String passport = passportNumber.getText();
      String dollar = dollarAmount.getText();
      String toCurrency = currency.getSelectedItem().toString();
      double d = Double.parseDouble(dollar);
      double exchangeAmt = 0;
      if(toCurrency.equals("British Pound")) {
        exchangeAmt = d * 0.71;
      }
      else if(toCurrency.equals("Canadian Dollar")) {
        exchangeAmt = d * 1.35;
      }

      String output = "Currency Exchange Information" + 
                   "\nPassport Number: " + passport +  
                   "\nFrom US Dollars to " + toCurrency +
                   "\nUS Dollar Amount: " + dollar +
                    "\n" + toCurrency + ": " + exchangeAmt;
      
      //JOptionPane.showMessageDialog(null, output);
      JOptionPane pane = new JOptionPane(output);
      JDialog dialog = pane.createDialog("Confirm");
      
      Timer timer = new Timer();
      timer.schedule(new TimerTask() {
    	  public void run () {
    		  pane.setValue(JOptionPane.OK_OPTION);
    		  dialog.dispose();
    	  }
      }, 3000
      );
      
      dialog.setVisible(true);
    }
    else if(event.getSource() == clear) { // if clear button is clicked
      passportNumber.setText("");
      dollarAmount.setText("");
    }
  }
  
  public static void main(String [] args) {
    CurrencyExchangeApp ces = new CurrencyExchangeApp();
    String passportNumber [] = {"ABC1234", "DEF1234"};
    String dollarAmount [] = {"1000.00", "2000.00"};
    int currency [] = {1,2};
    for(int index = 0; index < passportNumber.length; index ++) {
    	
    ces.passportNumber.setText(passportNumber[index]);
    ces.dollarAmount.setText(dollarAmount[index]);
    ces.currency.setSelectedIndex(currency[index]);
    ces.exchange.doClick();
    
    }
  }
}
