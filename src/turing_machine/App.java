package turing_machine;

public class App {
	public static void main(String[] args) {
		UI ui = new UI();
		UIController controller = new UIController(ui);
		controller.setVisible();
	}
}
