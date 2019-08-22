import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;

public class PdfLinkConverter {

	private JFrame frame;
	private JTextField inputField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PdfLinkConverter window = new PdfLinkConverter();
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
	public PdfLinkConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Invoice Converter");
		frame.setBounds(100, 100, 1001, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Volledige url (link) van de invoice pdf:");
		lblNewLabel.setBounds(10, 161, 218, 14);
		frame.getContentPane().add(lblNewLabel);
		
		inputField = new JTextField();
		inputField.setBounds(10, 186, 965, 20);
		frame.getContentPane().add(inputField);
		inputField.setColumns(10);
		
		JLabel lblUrlInDe = new JLabel("Url in de juiste taal:");
		lblUrlInDe.setBounds(10, 303, 218, 14);
		frame.getContentPane().add(lblUrlInDe);
		
		JTextArea outputLabel = new JTextArea();
		outputLabel.setBackground(Color.WHITE);
		outputLabel.setBounds(10, 328, 965, 20);
		frame.getContentPane().add(outputLabel);
		
		JButton btnConverteer = new JButton("Converteer");
		btnConverteer.setBounds(10, 218, 162, 61);
		frame.getContentPane().add(btnConverteer);
		
		JButton button = new JButton("?");
		button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button.setBounds(10, 366, 43, 34);
		button.addActionListener(e -> new HelpFrame());
		frame.getContentPane().add(button);
		
		JLabel lblHoeGebruikIk = new JLabel("Hoe gebruik ik dit programma?");
		lblHoeGebruikIk.setBounds(63, 376, 276, 14);
		frame.getContentPane().add(lblHoeGebruikIk);
		
		JTextPane txtpnInvoiceConverter = new JTextPane();
		txtpnInvoiceConverter.setBackground(Color.YELLOW);
		txtpnInvoiceConverter.setEditable(false);
		txtpnInvoiceConverter.setFont(new Font("Tahoma", Font.PLAIN, 90));
		txtpnInvoiceConverter.setText(" INVOICE CONVERTER");
		txtpnInvoiceConverter.setBounds(10, 11, 965, 124);
		frame.getContentPane().add(txtpnInvoiceConverter);

		btnConverteer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				outputLabel.setText(convertLink(inputField.getText()));
			}

			private String convertLink(String input) {
				//https://legenturia.checkfront.com/booking/XQDZ-030819/pdf?admin=1&export_id=1b27f25aefdd7743c8c74f222d39504a78ef1963496d2aea708fb2c2849cdefe
				//to
				
				try {
					int startIndex = input.indexOf("/booking")+9;
					String bookingNumber = input.substring(startIndex,startIndex+11);
					startIndex = input.indexOf("&export_id")+11;
					String export_id = input.substring(startIndex,input.length()).trim();
					System.out.println("bookingNumber: "+bookingNumber);
					System.out.println("converting link with: ");
					System.out.println("export_id: "+export_id);
					return "https://legenturia.checkfront.com/reserve/booking/"+bookingNumber+"?token="+export_id+"&view=pdf";
				}catch(Exception e) {
					return "can not convert that link, contact Valentin with your correct link";
				}
			}
		});
	}
}
