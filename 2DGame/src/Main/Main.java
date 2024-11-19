package Main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Roadrunner");
		
		GamePanel gamePanel = new GamePanel();
		frame.add(gamePanel);
		
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
