package grafikus;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import nabukodonozor.Field;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel pfield;
	private JLabel pinfos;
	private JLabel mana_value;
	private Field  field;
	
	public Game() {
		pfield = new JPanel();
		pinfos = new JLabel();
		
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
					field = new Field("field1");
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
					field = new Field("field2");
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
					field = new Field("field3");
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
		ImagePanel toolbox = new ImagePanel("pics/toolbox_bg.jpg");
		toolbox.setSize(960, 120);
		toolbox.setLocation(0, 560);
		add(toolbox);
		
		//informaciok
		pinfos.setSize(480, 120);
		pinfos.setLocation(430, 0);
		toolbox.add(pinfos);
		
		//shop
		//torony
		JButton shop_tower = new JButton(new ImageIcon("pics/tower_shop.png"));
		shop_tower.setSize(50, 50);
		shop_tower.setLocation(5, 5);
		shop_tower.setToolTipText("Torony");
		shop_tower.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				//pinfos.setText("Ez egy torony.");
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		toolbox.add(shop_tower);
		
		//csapda
		JButton shop_trap = new JButton(new ImageIcon("pics/trap_shop.jpg"));
		shop_trap.setSize(50, 50);
		shop_trap.setLocation(5, 65);
		shop_trap.setToolTipText("Akadály");
		shop_trap.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				//pinfos.setText("Ez egy akadály.");
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		toolbox.add(shop_trap);
		
		//DamageStone
		JButton shop_damagestone = new JButton(new ImageIcon("pics/damagestone.png"));
		shop_damagestone.setSize(50, 50);
		shop_damagestone.setLocation(65, 5);
		shop_damagestone.setToolTipText("Sebzést növelő kő");
		toolbox.add(shop_damagestone);
		
		//FrequencyStone
		JButton shop_frequencystone = new JButton(new ImageIcon("pics/frequencystone.png"));
		shop_frequencystone.setSize(50, 50);
		shop_frequencystone.setLocation(65, 65);
		shop_frequencystone.setToolTipText("Lövési gyakoriságot növelő kő");
		toolbox.add(shop_frequencystone);
		
		//RadiusStone
		JButton shop_radiusstone = new JButton(new ImageIcon("pics/radiusstone.png"));
		shop_radiusstone.setSize(50, 50);
		shop_radiusstone.setLocation(125, 5);
		shop_radiusstone.setToolTipText("Hatótávolságot növelő kő");
		toolbox.add(shop_radiusstone);
		
		//HobbitDamageStone
		JButton shop_hobbitdamagestone = new JButton(new ImageIcon("pics/hobbitdamagestone.png"));
		shop_hobbitdamagestone.setSize(50, 50);
		shop_hobbitdamagestone.setLocation(125, 65);
		shop_hobbitdamagestone.setToolTipText("Hobbit-sebzést növelő kő");
		toolbox.add(shop_hobbitdamagestone);
		
		//ElfDamageStone
		JButton shop_elfdamagestone = new JButton(new ImageIcon("pics/elfdamagestone.png"));
		shop_elfdamagestone.setSize(50, 50);
		shop_elfdamagestone.setLocation(185, 5);
		shop_elfdamagestone.setToolTipText("Tünde-sebzést növelő kő");
		toolbox.add(shop_elfdamagestone);
		
		//DwarfDamageStone
		JButton shop_dwarfdamagestone = new JButton(new ImageIcon("pics/dwarfdamagestone.png"));
		shop_dwarfdamagestone.setSize(50, 50);
		shop_dwarfdamagestone.setLocation(185, 65);
		shop_dwarfdamagestone.setToolTipText("Törp-sebzést növelő kő");
		toolbox.add(shop_dwarfdamagestone);
		
		//HumanDamageStone
		JButton shop_humandamagestone = new JButton(new ImageIcon("pics/humandamagestone.png"));
		shop_humandamagestone.setSize(50, 50);
		shop_humandamagestone.setLocation(245, 5);
		shop_humandamagestone.setToolTipText("Ember-sebzést növelő kő");
		toolbox.add(shop_humandamagestone);
		
		//RetentiveStone
		JButton shop_retentivestone = new JButton(new ImageIcon("pics/retentivestone.png"));
		shop_retentivestone.setSize(50, 50);
		shop_retentivestone.setLocation(245, 65);
		shop_retentivestone.setToolTipText("Lassítást fokozó kő");
		toolbox.add(shop_retentivestone);
		
		//mana
		//felirat
		JLabel mana_label = new JLabel("MANA", SwingConstants.CENTER);
		mana_label.setFont(mana_label.getFont().deriveFont(16.0f));
		mana_label.setSize(115, 16);
		mana_label.setLocation(305, 35);
		toolbox.add(mana_label);
		
		//tenyleges ertek
		mana_value = new JLabel(((Integer)field.getMana()).toString(), SwingConstants.CENTER);
		mana_value.setFont(mana_value.getFont().deriveFont(24.0f));
		mana_value.setSize(115, 25);
		mana_value.setLocation(305, 66);
		toolbox.add(mana_value);

		//ikonok
		//fomenu
		JButton icons_quit = new JButton(new ImageIcon("pics/exitbutton.png"));
		icons_quit.setSize(40, 40);
		icons_quit.setLocation(918, 0);

		icons_quit.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				setVisible(false);
				createLayout_NewGame();
				pack();
				setVisible(true);
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		
		toolbox.add(icons_quit);
		
		//pause/play
		JButton icons_pause = new JButton(new ImageIcon("pics/pausebutton.png"));
		icons_pause.setSize(40, 40);
		icons_pause.setLocation(918, 40);
		toolbox.add(icons_pause);
		
		//sugo
		JButton icons_help = new JButton(new ImageIcon("pics/helpbutton.png"));
		icons_help.setSize(40, 40);
		icons_help.setLocation(918, 80);
		toolbox.add(icons_help);
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