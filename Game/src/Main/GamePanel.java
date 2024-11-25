package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	private static final long serailVersionUID = 1L;
	
	public static final int WIDTH = 500, HEIGHT = 600;
	
	private Thread thread;
	private boolean running;
	private boolean gameover = false;
	private boolean win = false;
	int level = 1;
	
	private unitArea hero;
	
	private ArrayList<Obstacle> obstacles; 
	
	private int x = WIDTH/20 -3, y = HEIGHT/10 - 5;
	
	private int ticks = 0, tickObstacles = 0;
	private boolean right = false, left = false, up = false, down = false;
	
	//engel vektorune yeni obje ekleniyor
	private void addObstacle(int x, int y,int lenght, int size, Color color, int direction) {
		for(int i = 0; i < size; i++) {
			obstacles.add(new Obstacle(x, y, lenght, color, direction));
			x += direction;
		}
	}
	
	public GamePanel() {
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);

		start();
	}
	
	public void start() {
		initGame();
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private  void initGame() {
		win = false; 
		gameover = false;
		obstacles= new ArrayList<Obstacle>();
		hero = new unitArea(x, y, 10, Color.GREEN);
		//her engel tek tek ekleniyor	
		//first line
		addObstacle(WIDTH/10 - 8,HEIGHT/10 - 10,10,5,Color.YELLOW, -1);
		addObstacle(WIDTH/10 - 24,HEIGHT/10 - 10,10,5,Color.YELLOW, -1);
		addObstacle(WIDTH/10 - 40,HEIGHT/10 - 10,10,5,Color.YELLOW, -1);
		//second line
		addObstacle(WIDTH/10 - 20,HEIGHT/10 - 25,10,8,Color.BLUE, 1);
		addObstacle(WIDTH/10 - 40,HEIGHT/10 - 25,10,8,Color.BLUE, 1);
		//third line
		addObstacle(WIDTH/10 - 3,HEIGHT/10 - 40,10,3,Color.RED, -1);
		addObstacle(WIDTH/10 - 13,HEIGHT/10 - 40,10,3,Color.RED, -1);
		addObstacle(WIDTH/10 - 23,HEIGHT/10 - 40,10,3,Color.RED, -1);
		addObstacle(WIDTH/10 - 33,HEIGHT/10 - 40,10,3,Color.RED, -1);
		addObstacle(WIDTH/10 - 43,HEIGHT/10 - 40,10,3,Color.RED, -1);
		//fourth line
		addObstacle(WIDTH/10 - 20,HEIGHT/10 - 55,10,8,Color.WHITE, -1);
		addObstacle(WIDTH/10 - 40,HEIGHT/10 - 55,10,8,Color.WHITE, -1);
	}
	
	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
		//her milisaniyede bu fonksiyon calisiyor
		if(win || gameover) {
			return;
		}
		ticks++;
		//playerin hareketi var mi diye bakiliyor
		if(ticks > 250000) {
			int x = hero.getX();
			int y = hero.getY();
			if(right) {
				x++;
				right = false;
			}
			if(left){
				x--;
				left = false;
			}
			if(up) {
				y--;
				up = false;
			}
			if(down) {
				y++;
				down = false;
			}
			
			ticks = 0;
			
			hero.setX(x);
			hero.setY(y);
			for(int i = 0; i < obstacles.size(); i++) {
				if(obstacles.get(i).didCollide(hero)) {
					gameover = true;
					System.out.println("game over");
					return;
				}
			}
			if(y < 0) {
				win = true;
				return;
			}
		}
		tickObstacles++;
		//engeller hareket ettiriliyor
		if(tickObstacles > 1000000 - level * 10000) {
			tickObstacles = 0;
			
			for(int i = 0; i < obstacles.size(); i++) {
				obstacles.get(i).move(0,WIDTH/10);
			}
		}
		
 	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		//ekranlar ciziliyor
		if(win) {
			g.drawString("You Win to pass next level press 'R'", 20, 25);
		} else if(gameover) {
			g.drawString("Game Over to Restart press 'R'", 20, 25);
		} else if(level%2 == 1){
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			for(int i = 0; i<WIDTH; i++) {
				g.drawLine(i * 10, 0, i * 10, HEIGHT);
			}
			for(int i = 0; i<HEIGHT; i++) {
				g.drawLine(0,i * 10, HEIGHT, i * 10);
			}
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 20, WIDTH, 80);
			g.fillRect(0, 180, WIDTH, 60);
			g.fillRect(0, 310, WIDTH, 90);
			g.fillRect(0, 465, WIDTH, 80);
			
			g.setColor(Color.ORANGE);
			g.fillRect(0, 0, WIDTH, 20);
			g.fillRect(0, 100, WIDTH, 80);
			g.fillRect(0, 240, WIDTH, 70);
			g.fillRect(0, 400, WIDTH, 65);
			g.fillRect(0, 545, WIDTH, 55);
			for(int i = 0; i < obstacles.size(); i++) {
				obstacles.get(i).draw(g);
			}
			hero.draw(g);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			for(int i = 0; i<WIDTH; i++) {
				g.drawLine(i * 10, 0, i * 10, HEIGHT);
			}
			for(int i = 0; i<HEIGHT; i++) {
				g.drawLine(0,i * 10, HEIGHT, i * 10);
			}
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 20, WIDTH, 80);
			g.fillRect(0, 180, WIDTH, 60);
			g.fillRect(0, 310, WIDTH, 90);
			g.fillRect(0, 465, WIDTH, 80);
			
			g.setColor(Color.CYAN);
			g.fillRect(0, 0, WIDTH, 20);
			g.fillRect(0, 100, WIDTH, 80);
			g.fillRect(0, 240, WIDTH, 70);
			g.fillRect(0, 400, WIDTH, 65);
			g.fillRect(0, 545, WIDTH, 55);
			for(int i = 0; i < obstacles.size(); i++) {
				obstacles.get(i).draw(g);
			}
			hero.draw(g);
		}

	}
	
	public void run() {
		while(running) {
			tick();
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//tuslara basilinca ne olacagi soyleniyor
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT) {
			right = true;
			left = false;
		} else if(key == KeyEvent.VK_LEFT) {
			right = false;
			left = true;
		} else if(key == KeyEvent.VK_UP) {
			up = true;
			down = false;
		} else if(key == KeyEvent.VK_DOWN) {
			up = false;
			down = true;
		} 
		
		
		//for debug
		if(key == KeyEvent.VK_P) {
			System.out.println("x: " + hero.getX());
			System.out.println("y: " + hero.getY());
		}
		if(gameover || win) {
			if(key == KeyEvent.VK_R) {
				if(win) {
					level++;
				}
				stop();
				start();
				
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
