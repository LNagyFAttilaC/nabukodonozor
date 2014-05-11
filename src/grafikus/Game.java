package grafikus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import nabukodonozor.Field;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel pfield;
	
	public Game() {
		pfield = new JPanel();
		
		//az ablak alap beallitasai
		getContentPane().setLayout(null);
		setTitle("A két torony");
		setIconImage(new ImageIcon("pics/tower.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(964, 709));
		setResizable(false);
		
		//kozepre pozicionalas
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth()  - 964) / 2);
		setLocation(x, 10);
	}
	
	private void createLayout_Menu() {
		//uj jatek
		JButton menu_new_game = new JButton(new ImageIcon("pics/menu_new_game.png"));
		menu_new_game.setSize(292, 44);
		menu_new_game.setLocation(339, 353);
		menu_new_game.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				createLayout_NewGame();
				repaint();
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(menu_new_game);
		
		//kilepes
		JButton menu_exit = new JButton(new ImageIcon("pics/menu_exit.png"));
		menu_exit.setSize(292, 44);
		menu_exit.setLocation(339, 435);
		menu_exit.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(menu_exit);
		
		//hatter
		ImagePanel menus = new ImagePanel("pics/menu_bg.png");
		menus.setSize(960, 680);
		menus.setLocation(0, 0);
		add(menus);
	}
	
	private void createLayout_NewGame() {
		//Erkezes a Fekete Kapuhoz
		JButton field1 = new JButton(new ImageIcon("pics/menu_field1.png"));
		field1.setSize(292, 44);
		field1.setLocation(339, 353);
		field1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				try {
					Field field = new Field("field1");
				}
				catch (IOException ioe) {
					ioe.printStackTrace();
				}
				
				getContentPane().removeAll();
				createLayout_Game();
				repaint();
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(field1);
		
		//Minath Morgul
		JButton field2 = new JButton(new ImageIcon("pics/menu_field2.png"));
		field2.setSize(292, 44);
		field2.setLocation(339, 435);
		field2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				try {
					Field field = new Field("field2");
				}
				catch (IOException ioe) {
					ioe.printStackTrace();
				}
				
				getContentPane().removeAll();
				createLayout_Game();
				repaint();
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(field2);
		
		//A kiralyok varosa
		JButton field3 = new JButton(new ImageIcon("pics/menu_field3.png"));
		field3.setSize(292, 44);
		field3.setLocation(339, 519);
		field3.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				try {
					Field field = new Field("field3");
				}
				catch (IOException ioe)	{
					ioe.printStackTrace();
				}
				
				getContentPane().removeAll();
				createLayout_Game();
				repaint();
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(field3);
		
		//hatter
		ImagePanel menus = new ImagePanel("pics/menu_bg.png");
		menus.setSize(960, 680);
		menus.setLocation(0, 0);
		add(menus);
	}
	
	private void createLayout_Game() {
		//palya
		pfield.setSize(960, 560);
		pfield.setLocation(0, 0);
		add(pfield);
		
		//also sav
		JPanel toolbox = new JPanel();
		toolbox.setBackground(Color.GRAY);
		toolbox.setSize(960, 120);
		toolbox.setLocation(0, 560);
		add(toolbox);
		
		//ikonok
		//fomenu
		ImagePanel icons_quit = new ImagePanel("pics/exitbutton.png");
		icons_quit.setSize(40, 40);
		icons_quit.setLocation(920, 0);
		toolbox.add(icons_quit);
		
		//pause/play
		ImagePanel icons_pause = new ImagePanel("pics/pausebutton.png");
		icons_pause.setSize(40, 40);
		icons_pause.setLocation(920, 40);
		toolbox.add(icons_pause);
		
		//sugo
		ImagePanel icons_help = new ImagePanel("pics/helpbutton.png");
		icons_help.setSize(40, 40);
		icons_help.setLocation(920, 80);
		toolbox.add(icons_help);
		
		//shop
		//torony
		ImagePanel shop_tower = new ImagePanel("pics/tower_shop.png");
		shop_tower.setSize(50, 50);
		shop_tower.setLocation(5, 5);
		toolbox.add(shop_tower);
		
		//csapda
		ImagePanel shop_trap = new ImagePanel("pics/trap_shop.jpg");
		shop_trap.setSize(50, 50);
		shop_trap.setLocation(5, 65);
		toolbox.add(shop_trap);
		
		//DamageStone
		ImagePanel shop_damagestone = new ImagePanel("pics/damagestone.png");
		shop_damagestone.setSize(50, 50);
		shop_damagestone.setLocation(65, 5);
		toolbox.add(shop_damagestone);
		
		//FrequencyStone
		ImagePanel shop_frequencystone = new ImagePanel("pics/frequencystone.png");
		shop_frequencystone.setSize(50, 50);
		shop_frequencystone.setLocation(65, 65);
		toolbox.add(shop_frequencystone);
		
		//RadiusStone
		ImagePanel shop_radiusstone = new ImagePanel("pics/radiusstone.png");
		shop_radiusstone.setSize(50, 50);
		shop_radiusstone.setLocation(125, 5);
		toolbox.add(shop_radiusstone);
		
		//HobbitDamageStone
		ImagePanel shop_hobbitdamagestone = new ImagePanel("pics/hobbitdamagestone.png");
		shop_hobbitdamagestone.setSize(50, 50);
		shop_hobbitdamagestone.setLocation(125, 65);
		toolbox.add(shop_hobbitdamagestone);
		
		//ElfDamageStone
		ImagePanel shop_elfdamagestone = new ImagePanel("pics/elfdamagestone.png");
		shop_elfdamagestone.setSize(50, 50);
		shop_elfdamagestone.setLocation(185, 5);
		toolbox.add(shop_elfdamagestone);
		
		//DwarfDamageStone
		ImagePanel shop_dwarfdamagestone = new ImagePanel("pics/dwarfdamagestone.png");
		shop_dwarfdamagestone.setSize(50, 50);
		shop_dwarfdamagestone.setLocation(185, 65);
		toolbox.add(shop_dwarfdamagestone);
		
		//HumanDamageStone
		ImagePanel shop_humandamagestone = new ImagePanel("pics/humandamagestone.png");
		shop_humandamagestone.setSize(50, 50);
		shop_humandamagestone.setLocation(245, 5);
		toolbox.add(shop_humandamagestone);
		
		//RetentiveStone
		ImagePanel shop_retentivestone = new ImagePanel("pics/retentivestone.png");
		shop_retentivestone.setSize(50, 50);
		shop_retentivestone.setLocation(245, 65);
		toolbox.add(shop_retentivestone);
	}

	public void startGame() {
		//kezdo layout a menu
		createLayout_Menu();
		
		//megjelenites
		pack();
		setVisible(true);
	}
	
	public JPanel getPField() {
		return pfield;
	}
}