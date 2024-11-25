package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	final int originalTileSize = 16;
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHight = tileSize * maxScreenRow;
	
	KeyHandler keyH = new KeyHandler(); 
	Thread gameThread;
	
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel () {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHight));
		this.setBackground(Color.black );
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGaneThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	 @Override
	    public void run() {
	        long lastTime = System.nanoTime();
	        final double nsPerTick = 1000000000.0 / 60.0; // 60 FPS target
	        double delta = 0;

	        while (gameThread != null) {
	            long now = System.nanoTime();
	            delta += (now - lastTime) / nsPerTick;
	            lastTime = now;

	            // If it's time for the next tick, update and repaint the screen
	            if (delta >= 1) {
	                update();
	                repaint();
	                delta--;
	            }
	        }
	    }

	    // Updates the player's position based on key inputs
	    public void update() {
	        // Handle player movement
	        if (keyH.upPressed) {
	            playerY -= playerSpeed;
	        }
	        if (keyH.downPressed) {
	            playerY += playerSpeed;
	        }
	        if (keyH.leftPressed) {
	            playerX -= playerSpeed;
	        }
	        if (keyH.rightPressed) {
	            playerX += playerSpeed;
	        }

	        // Prevent player from going off-screen
	        if (playerX < 0) playerX = 0;
	        if (playerY < 0) playerY = 0;
	        if (playerX > screenWidth - tileSize) playerX = screenWidth - tileSize;
	        if (playerY > getHeight() - tileSize) playerY = getHeight() - tileSize;
	    }
    @Override 
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose();
	}
}



