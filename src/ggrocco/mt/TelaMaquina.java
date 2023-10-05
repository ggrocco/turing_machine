package ggrocco.mt;

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
public class TelaMaquina extends JFrame{
	
	private JPanel jContentPane = null;

	private JLabel jLabelEntrada = null;

	private JTextField jTextFieldEntrada = null;

	private JTextArea jTextAreaLinguagem = null;

	private JTextArea jTextAreaSaida = null;

	private JLabel Saida = null;

	private JLabel jLabelLinguagem = null;

	private JButton jButtonIniciar = null;

	private JScrollPane jScrollPaneLinguagem = null;

	private JScrollPane jScrollPaneSaida = null;

	private JLabel jLabelPosicaoInicial = null;

	private JTextField jTextFieldPosica = null;

	private JButton jButtonParar = null;

	public TelaMaquina(){
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
		this.setTitle("Maquina de Turing");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelPosicaoInicial = new JLabel();
			jLabelPosicaoInicial.setBounds(new Rectangle(410, 18, 56, 16));
			jLabelPosicaoInicial.setText("Posicao:");
			jLabelLinguagem = new JLabel();
			jLabelLinguagem.setBounds(new Rectangle(10, 45, 68, 16));
			jLabelLinguagem.setText("Linguagem:");
			Saida = new JLabel();
			Saida.setBounds(new Rectangle(279, 44, 38, 16));
			Saida.setText("Saida:");
			jLabelEntrada = new JLabel();
			jLabelEntrada.setText("Entrada:");
			jLabelEntrada.setBounds(new Rectangle(6, 14, 55, 23));
			jLabelEntrada.setName("jLabelEntrada");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelEntrada, null);
			jContentPane.add(getJTextFieldEntrada(), null);
			jContentPane.add(getJTextAreaLinguagem(), null);
			jContentPane.add(getJTextAreaSaida(), null);
			jContentPane.add(Saida, null);
			jContentPane.add(jLabelLinguagem, null);
			jContentPane.add(getJButtonIniciar(), null);
			jContentPane.add(getJScrollPaneLinguagem(), null);
			jContentPane.add(getJScrollPaneSaida(), null);
			jContentPane.add(jLabelPosicaoInicial, null);
			jContentPane.add(getJTextFieldPosica(), null);
			jContentPane.add(getJButtonParar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldEntrada	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldEntrada() {
		if (jTextFieldEntrada == null) {
			jTextFieldEntrada = new JTextField();
			jTextFieldEntrada.setBounds(new Rectangle(56, 16, 208, 20));
		}
		return jTextFieldEntrada;
	}

	/**
	 * This method initializes jTextAreaLinguagem	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaLinguagem() {
		if (jTextAreaLinguagem == null) {
			jTextAreaLinguagem = new JTextArea();
			jTextAreaLinguagem.setBounds(new Rectangle(10, 60, 233, 194));
		}
		return jTextAreaLinguagem;
	}

	/**
	 * This method initializes jTextAreaSaida	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaSaida() {
		if (jTextAreaSaida == null) {
			jTextAreaSaida = new JTextArea();
			jTextAreaSaida.setBounds(new Rectangle(277, 60, 229, 195));
			jTextAreaSaida.setEditable(false);
		}
		return jTextAreaSaida;
	}

	/**
	 * This method initializes jButtonIniciar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonIniciar() {
		if (jButtonIniciar == null) {
			jButtonIniciar = new JButton();
			jButtonIniciar.setBounds(new Rectangle(264, 16, 73, 19));
			jButtonIniciar.setText("Iniciar");
		}
		return jButtonIniciar;
	}
		
	public void addEventBotaoIniciar(ActionListener action){
		getJButtonIniciar().addActionListener(action);
	}
	
	public void addEventBotaoParar(ActionListener action){
		getJButtonParar().addActionListener(action);
	}
	
	public JTextArea getAreaSaida(){
		return getJTextAreaSaida();
	}
		
	public JTextArea getAreaLinguagem(){
		return getJTextAreaLinguagem();
	}	
	
	public JTextField getEntrada(){
		return getJTextFieldEntrada();
	}
	
	public JTextField getPosicao(){
		return getJTextFieldPosica();
	}

	/**
	 * This method initializes jScrollPaneLinguagem	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneLinguagem() {
		if (jScrollPaneLinguagem == null) {
			jScrollPaneLinguagem = new JScrollPane(getAreaLinguagem());
			jScrollPaneLinguagem.setBounds(new Rectangle(10, 60, 223, 194));
		}
		return jScrollPaneLinguagem;
	}

	/**
	 * This method initializes jScrollPaneSaida	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneSaida() {
		if (jScrollPaneSaida == null) {
			jScrollPaneSaida = new JScrollPane(getJTextAreaSaida());
			jScrollPaneSaida.setBounds(new Rectangle(277, 60, 229, 195));
		}
		return jScrollPaneSaida;
	}

	/**
	 * This method initializes jTextFieldPosica	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldPosica() {
		if (jTextFieldPosica == null) {
			jTextFieldPosica = new JTextField();
			jTextFieldPosica.setBounds(new Rectangle(468, 16, 54, 20));
		}
		return jTextFieldPosica;
	}

	/**
	 * This method initializes jButtonParar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonParar() {
		if (jButtonParar == null) {
			jButtonParar = new JButton();
			jButtonParar.setBounds(new Rectangle(337, 16, 68, 19));
			jButtonParar.setText("Parar");
		}
		return jButtonParar;
	}
}  //  @jve:decl-index=0:visual-constraint="6,9"
