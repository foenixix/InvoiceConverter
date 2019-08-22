
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HelpFrame {

	private JFrame frame;
	int step = 0;
	private ImageIcon[] images = new ImageIcon[] {
			new ImageIcon(HelpFrame.class.getResource("/resources/step1.png")),
			new ImageIcon(HelpFrame.class.getResource("/resources/step2.png")),
			new ImageIcon(HelpFrame.class.getResource("/resources/step3.png")),
			new ImageIcon(HelpFrame.class.getResource("/resources/step4.png"))};
	private JLabel imageLabel;
	private JLabel stepLabel;
	

	/**
	 * Create the application.
	 */
	public HelpFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Image Converter Hulp");
		frame.setBounds(100, 100, 625, 800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(321, 738, 89, 23);
		btnNext.addActionListener(e -> updateStepLabel(step+1));
		frame.getContentPane().add(btnNext);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(177, 738, 89, 23);
		btnPrevious.addActionListener(e -> updateStepLabel(step-1));
		frame.getContentPane().add(btnPrevious);
		
		imageLabel = new JLabel("");
		imageLabel.setIcon(images[0]);
		imageLabel.setBounds(10, 11, 595, 716);
		frame.getContentPane().add(imageLabel);
		
		stepLabel = new JLabel("1");
		stepLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stepLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		stepLabel.setBounds(261, 738, 65, 23);
		frame.getContentPane().add(stepLabel);
		frame.setResizable(false);
		
		frame.setVisible(true);
	}
	
	private void updateStepLabel(int toStep) {
		if(toStep<0 || toStep>3) {
			return;
		}
		step = toStep;
		stepLabel.setText(toStep+1+"");
		imageLabel.setIcon(images[toStep]);
	}
}
