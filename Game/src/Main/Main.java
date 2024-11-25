package Main;

import javax.swing.JFrame;

public class Main {
// ekrani init ediyoruz
	public Main() {
		JFrame frame = new JFrame();
		//oyunu init ediyoruz
		GamePanel gamepanel = new GamePanel();
		
		frame.add(gamepanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Crossy Road");
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
}
