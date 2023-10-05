package turing_machine;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class UI extends JFrame{
	
	private JPanel jContentPane = null;

	private JLabel jLabelInput = null;

	private JTextField jTextFieldInput = null;

	private JTextArea jTextAreaLanguage = null;

	private JTextArea jTextAreaOutput = null;

	private JLabel Output = null;

	private JLabel jLabelLanguage = null;

	private JButton jButtonStart = null;

	private JScrollPane jScrollPaneLanguage = null;

	private JScrollPane jScrollPaneOutput = null;

	private JLabel jLabelInitialPosition = null;

	private JTextField jTextFieldPosition = null;

	private JButton jButtonStop = null;

	public UI(){
		super();
		initialize();	
	}
	
	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(542, 292);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("Turing Machine");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelInitialPosition = new JLabel();
			jLabelInitialPosition.setBounds(new Rectangle(410, 18, 56, 16));
			jLabelInitialPosition.setText("Position:");
			jLabelLanguage = new JLabel();
			jLabelLanguage.setBounds(new Rectangle(10, 45, 68, 16));
			jLabelLanguage.setText("Language:");
			Output = new JLabel();
			Output.setBounds(new Rectangle(279, 44, 38, 16));
			Output.setText("Output:");
			jLabelInput = new JLabel();
			jLabelInput.setText("Input:");
			jLabelInput.setBounds(new Rectangle(6, 14, 55, 23));
			jLabelInput.setName("jLabelInput");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelInput, null);
			jContentPane.add(getJTextFieldInput(), null);
			jContentPane.add(getJTextAreaLanguage(), null);
			jContentPane.add(getJTextAreaOutput(), null);
			jContentPane.add(Output, null);
			jContentPane.add(jLabelLanguage, null);
			jContentPane.add(getJButtonStart(), null);
			jContentPane.add(getJScrollPaneLanguage(), null);
			jContentPane.add(getJScrollPaneOutput(), null);
			jContentPane.add(jLabelInitialPosition, null);
			jContentPane.add(getJTextFieldPosition(), null);
			jContentPane.add(getJButtonStop(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldInput
	 *
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldInput() {
		if (jTextFieldInput == null) {
			jTextFieldInput = new JTextField();
			jTextFieldInput.setBounds(new Rectangle(56, 16, 208, 20));
		}
		return jTextFieldInput;
	}

	/**
	 * This method initializes jTextAreaLanguage	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaLanguage() {
		if (jTextAreaLanguage == null) {
			jTextAreaLanguage = new JTextArea();
			jTextAreaLanguage.setBounds(new Rectangle(10, 60, 233, 194));
		}
		return jTextAreaLanguage;
	}

	/**
	 * This method initializes jTextAreaOutput	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaOutput() {
		if (jTextAreaOutput == null) {
			jTextAreaOutput = new JTextArea();
			jTextAreaOutput.setBounds(new Rectangle(277, 60, 229, 195));
			jTextAreaOutput.setEditable(false);
		}
		return jTextAreaOutput;
	}

	/**
	 * This method initializes jButtonStart	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonStart() {
		if (jButtonStart == null) {
			jButtonStart = new JButton();
			jButtonStart.setBounds(new Rectangle(264, 16, 73, 19));
			jButtonStart.setText("Start");
		}
		return jButtonStart;
	}
		
	public void addEventButtonStart(ActionListener action){
		getJButtonStart().addActionListener(action);
	}
	
	public void addEventButtonStop(ActionListener action){
		getJButtonStop().addActionListener(action);
	}
	
	public JTextArea getAreaOutput(){
		return getJTextAreaOutput();
	}
		
	public JTextArea getAreaLanguage(){
		return getJTextAreaLanguage();
	}	
	
	public JTextField getInput(){
		return getJTextFieldInput();
	}
	
	public JTextField getPosition(){
		return getJTextFieldPosition();
	}

	/**
	 * This method initializes jScrollPaneLanguage	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneLanguage() {
		if (jScrollPaneLanguage == null) {
			jScrollPaneLanguage = new JScrollPane(getAreaLanguage());
			jScrollPaneLanguage.setBounds(new Rectangle(10, 60, 223, 194));
		}
		return jScrollPaneLanguage;
	}

	/**
	 * This method initializes jScrollPaneOutput	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneOutput() {
		if (jScrollPaneOutput == null) {
			jScrollPaneOutput = new JScrollPane(getJTextAreaOutput());
			jScrollPaneOutput.setBounds(new Rectangle(277, 60, 229, 195));
		}
		return jScrollPaneOutput;
	}

	/**
	 * This method initializes jTextFieldPosition	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldPosition() {
		if (jTextFieldPosition == null) {
			jTextFieldPosition = new JTextField();
			jTextFieldPosition.setBounds(new Rectangle(468, 16, 54, 20));
		}
		return jTextFieldPosition;
	}

	/**
	 * This method initializes jButtonStop	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonStop() {
		if (jButtonStop == null) {
			jButtonStop = new JButton();
			jButtonStop.setBounds(new Rectangle(337, 16, 68, 19));
			jButtonStop.setText("Stop");
		}
		return jButtonStop;
	}
}  //  @jve:decl-index=0:visual-constraint="6,9"
