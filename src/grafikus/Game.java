package grafikus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import nabukodonozor.BasicTower;
import nabukodonozor.BasicTrap;
import nabukodonozor.DamageStone;
import nabukodonozor.DwarfDamageStone;
import nabukodonozor.ElfDamageStone;
import nabukodonozor.Field;
import nabukodonozor.FrequencyStone;
import nabukodonozor.HobbitDamageStone;
import nabukodonozor.HumanDamageStone;
import nabukodonozor.RadiusStone;
import nabukodonozor.RetentiveStone;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLayeredPane pfield;
	private JTextArea pinfos;
	private JTextField mana_value;
	private Field field;

	public Game() {
		pfield = new JLayeredPane();
		pinfos = new JTextArea();
		field  = new Field();
		
		//az ablak alap beallitasai
		getContentPane().setLayout(null);
		setTitle("A két torony");
		setIconImage(new ImageIcon("pics/simpletower.png").getImage());
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
		JButton menu_new_game = new JButton(new ImageIcon("pics/menu_new_game.jpg"));
		menu_new_game.setSize(292, 44);
		menu_new_game.setLocation(339, 353);
		menu_new_game.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				createLayout_NewGame();
				repaint();
			}
		});
		add(menu_new_game);
		
		//kilepes
		JButton menu_exit = new JButton(new ImageIcon("pics/menu_exit.jpg"));
		menu_exit.setSize(292, 44);
		menu_exit.setLocation(339, 435);
		menu_exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		add(menu_exit);
		
		//hatter
		ImagePanel menus = new ImagePanel("pics/menu_bg.jpg");
		menus.setSize(960, 680);
		menus.setLocation(0, 0);
		add(menus);
	}
	
	private void createLayout_NewGame() {
		//Erkezes a Fekete Kapuhoz
		JButton field1 = new JButton(new ImageIcon("pics/menu_field1.jpg"));
		field1.setSize(292, 44);
		field1.setLocation(339, 353);
		field1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Controller.initTimer();
					
					field.initialize("field1");
				}
				catch (IOException ioe) {
					ioe.printStackTrace();
				}
				
				getContentPane().removeAll();
				createLayout_Game();
				repaint();
			}
		});
		add(field1);
		
		//Minath Morgul
		JButton field2 = new JButton(new ImageIcon("pics/menu_field2.jpg"));
		field2.setSize(292, 44);
		field2.setLocation(339, 435);
		field2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Controller.initTimer();
					
					field.initialize("field2");
				}
				catch (IOException ioe) {
					ioe.printStackTrace();
				}
				
				getContentPane().removeAll();
				createLayout_Game();
				repaint();
			}
		});
		add(field2);
		
		//A kiralyok varosa
		JButton field3 = new JButton(new ImageIcon("pics/menu_field3.jpg"));
		field3.setSize(292, 44);
		field3.setLocation(339, 519);
		field3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Controller.initTimer();
					
					field.initialize("field3");
				}
				catch (IOException ioe)	{
					ioe.printStackTrace();
				}
				
				getContentPane().removeAll();
				createLayout_Game();
				repaint();
			}
		});
		add(field3);
		
		//hatter
		ImagePanel menus = new ImagePanel("pics/menu_bg.jpg");
		menus.setSize(960, 680);
		menus.setLocation(0, 0);
		add(menus);
	}
	
	private void createLayout_Game() {
		//palya
		pfield.setSize(960, 560);
		pfield.setLocation(0, 0);
		pfield.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Controller.click(e.getX(), e.getY());
			}
		});
		add(pfield);
		
		//also sav
		ImagePanel toolbox = new ImagePanel("pics/toolbox_bg.jpg");
		toolbox.setSize(960, 120);
		toolbox.setLocation(0, 560);
		add(toolbox);
		
		//informaciok
		pinfos.setEditable(false);
		pinfos.setOpaque(false);
		pinfos.setBorder(null);
		pinfos.setFont(pinfos.getFont().deriveFont(Font.BOLD));
		JScrollPane jinfos = new JScrollPane(pinfos);
		jinfos.setOpaque(false);
		jinfos.getViewport().setOpaque(false);
		jinfos.setBorder(null);
		jinfos.setSize(480, 115);
		jinfos.setLocation(430, 5);
		toolbox.add(jinfos);
		
		//shop
		//torony
		JButton shop_tower = new JButton(new ImageIcon("pics/tower_shop.jpg"));
		shop_tower.setSize(50, 50);
		shop_tower.setLocation(5, 5);
		shop_tower.setToolTipText("Torony");
		shop_tower.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Controller.setState(Controller.ControllerState.TOWER_CLICKED);
				
				colorMana(BasicTower.default_price);
				
				pinfos.setText("TORONY\n"
						+ "Ár: 80\n\n"
						+ "Csak mezőre tehető!\n"
						+ "A pályán elhelyezve a hatósugarába került ellenséget lövi.");
			}
		});
		toolbox.add(shop_tower);
		
		//csapda
		JButton shop_trap = new JButton(new ImageIcon("pics/trap_shop.jpg"));
		shop_trap.setSize(50, 50);
		shop_trap.setLocation(5, 65);
		shop_trap.setToolTipText("Akadály");
		shop_trap.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Controller.setState(Controller.ControllerState.TRAP_CLICKED);
				
				colorMana(BasicTrap.default_price);
				
				pinfos.setText("CSAPDA\n"
						+ "Ár: 50\n\n"
						+ "Csak útra tehető!\n"
						+ "A pályán elhelyezve a rálépő ellenséget lassítja.");
			}
		});
		toolbox.add(shop_trap);
		
		//DamageStone
		JButton shop_damagestone = new JButton(new ImageIcon("pics/damagestone.jpg"));
		shop_damagestone.setSize(50, 50);
		shop_damagestone.setLocation(65, 5);
		shop_damagestone.setToolTipText("Sebzést növelő kő");
		shop_damagestone.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Controller.setState(Controller.ControllerState.DAMAGESTONE_CLICKED);
				
				colorMana(DamageStone.default_price);
				
				pinfos.setText("SEBZÉST NÖVELŐ KŐ\n"
						+ "Ár: 650\n\n"
						+ "Csak toronyra tehető.\n"
						+ "Toronyra helyezve megnöveli annak sebzési tulajdonságát.");
			}
		});
		toolbox.add(shop_damagestone);
		
		//FrequencyStone
		JButton shop_frequencystone = new JButton(new ImageIcon("pics/frequencystone.jpg"));
		shop_frequencystone.setSize(50, 50);
		shop_frequencystone.setLocation(65, 65);
		shop_frequencystone.setToolTipText("Lövési gyakoriságot növelő kő");
		shop_frequencystone.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Controller.setState(Controller.ControllerState.FREQUENCYSTONE_CLICKED);
				
				colorMana(FrequencyStone.default_price);
				
				pinfos.setText("LÖVÉSI GYAKORISÁGOT NÖVELŐ KŐ\n"
						+ "Ár: 700\n\n"
						+ "Csak toronyra tehető.\n"
						+ "Toronyra helyezve megnöveli annak tüzelési sebességét.");
			}
		});
		toolbox.add(shop_frequencystone);
		
		//RadiusStone
		JButton shop_radiusstone = new JButton(new ImageIcon("pics/radiusstone.jpg"));
		shop_radiusstone.setSize(50, 50);
		shop_radiusstone.setLocation(125, 5);
		shop_radiusstone.setToolTipText("Hatótávolságot növelő kő");
		shop_radiusstone.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Controller.setState(Controller.ControllerState.RADIUSSTONE_CLICKED);
				
				colorMana(RadiusStone.default_price);
				
				pinfos.setText("HATÓTÁVOLSÁGOT NÖVELŐ KŐ\n"
						+ "Ár: 410\n\n"
						+ "Csak toronyra tehető.\n"
						+ "Toronyra helyezve megnöveli annak hatótávolságát.");
			}
		});
		toolbox.add(shop_radiusstone);
		
		//HobbitDamageStone
		JButton shop_hobbitdamagestone = new JButton(new ImageIcon("pics/hobbitdamagestone.jpg"));
		shop_hobbitdamagestone.setSize(50, 50);
		shop_hobbitdamagestone.setLocation(125, 65);
		shop_hobbitdamagestone.setToolTipText("Hobbit-sebzést növelő kő");
		shop_hobbitdamagestone.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Controller.setState(Controller.ControllerState.HOBBITDAMAGESTONE_CLICKED);
				
				colorMana(HobbitDamageStone.default_price);
				
				pinfos.setText("HOBBIT-SEBZÉST NÖVELŐ KŐ\n"
						+ "Ár: 275\n\n"
						+ "Csak toronyra tehető.\n"
						+ "Ezzel a kővel ellátott torony nagyobb sebzést okoz a hobbitoknak.");
			}
		});
		toolbox.add(shop_hobbitdamagestone);
		
		//ElfDamageStone
		JButton shop_elfdamagestone = new JButton(new ImageIcon("pics/elfdamagestone.jpg"));
		shop_elfdamagestone.setSize(50, 50);
		shop_elfdamagestone.setLocation(185, 5);
		shop_elfdamagestone.setToolTipText("Tünde-sebzést növelő kő");
		shop_elfdamagestone.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Controller.setState(Controller.ControllerState.ELFDAMAGESTONE_CLICKED);
				
				colorMana(ElfDamageStone.default_price);
				
				pinfos.setText("TÜNDE-SEBZÉST NÖVELŐ KŐ\n"
						+ "Ár: 300\n\n"
						+ "Csak toronyra tehető.\n"
						+ "Ezzel a kővel ellátott torony nagyobb sebzést okoz a tündéknek.");
			}
		});
		toolbox.add(shop_elfdamagestone);
		
		//DwarfDamageStone
		JButton shop_dwarfdamagestone = new JButton(new ImageIcon("pics/dwarfdamagestone.jpg"));
		shop_dwarfdamagestone.setSize(50, 50);
		shop_dwarfdamagestone.setLocation(185, 65);
		shop_dwarfdamagestone.setToolTipText("Törp-sebzést növelő kő");
		shop_dwarfdamagestone.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Controller.setState(Controller.ControllerState.DWARFDAMAGESTONE_CLICKED);
				
				colorMana(DwarfDamageStone.default_price);
				
				pinfos.setText("TÖRP-SEBZÉST NÖVELŐ KŐ\n"
						+ "Ár: 325\n\n"
						+ "Csak toronyra tehető.\n"
						+ "Ezzel a kővel ellátott torony nagyobb sebzést okoz a törpöknek.");
			}
		});
		toolbox.add(shop_dwarfdamagestone);
		
		//HumanDamageStone
		JButton shop_humandamagestone = new JButton(new ImageIcon("pics/humandamagestone.jpg"));
		shop_humandamagestone.setSize(50, 50);
		shop_humandamagestone.setLocation(245, 5);
		shop_humandamagestone.setToolTipText("Ember-sebzést növelő kő");
		shop_humandamagestone.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Controller.setState(Controller.ControllerState.HUMANDAMAGESTONE_CLICKED);
				
				colorMana(HumanDamageStone.default_price);
				
				pinfos.setText("EMBER-SEBZÉST NÖVELŐ KŐ\n"
						+ "Ár: 350\n\n"
						+ "Csak toronyra tehető.\n"
						+ "Ezzel a kővel ellátott torony nagyobb sebzést okoz az embereknek.");
			}
		});
		toolbox.add(shop_humandamagestone);
		
		//RetentiveStone
		JButton shop_retentivestone = new JButton(new ImageIcon("pics/retentivestone.jpg"));
		shop_retentivestone.setSize(50, 50);
		shop_retentivestone.setLocation(245, 65);
		shop_retentivestone.setToolTipText("Lassítást fokozó kő");
		shop_retentivestone.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Controller.setState(Controller.ControllerState.RETENTIVESTONE_CLICKED);
				
				colorMana(RetentiveStone.default_price);
				
				pinfos.setText("LASSÍTÁST FOKOZÓ KŐ\n"
						+ "Ár: 180\n\n"
						+ "Csak csapdára tehető.\n"
						+ "Ezzel a kővel ellátott csapda tovább tartja fogva az ellenséget.");
			}
		});
		toolbox.add(shop_retentivestone);
		
		//mana
		//felirat
		JLabel mana_label = new JLabel("MANA", SwingConstants.CENTER);
		mana_label.setFont(mana_label.getFont().deriveFont(16.0f));
		mana_label.setSize(115, 16);
		mana_label.setLocation(305, 35);
		toolbox.add(mana_label);
		
		//tenyleges ertek
		mana_value = new JTextField(((Integer)field.getMana()).toString());
		mana_value.setOpaque(false);
		mana_value.setEditable(false);
		mana_value.setBorder(null);
		mana_value.setHorizontalAlignment(JTextField.CENTER);
		mana_value.setFont(mana_value.getFont().deriveFont(24.0f));
		mana_value.setSize(115, 25);
		mana_value.setLocation(305, 66);
		toolbox.add(mana_value);

		//ikonok
		//fomenu
		JButton icons_quit = new JButton(new ImageIcon("pics/exitbutton.jpg"));
		icons_quit.setSize(40, 40);
		icons_quit.setLocation(918, 0);
		icons_quit.setToolTipText("Vissza a főmenübe");
		icons_quit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				pfield.removeAll();
				createLayout_NewGame();
				repaint();
			}
		});
		
		toolbox.add(icons_quit);
		
		//pause/play
		JButton icons_pause = new JButton(new ImageIcon("pics/pausebutton.jpg"));
		icons_pause.setSize(40, 40);
		icons_pause.setLocation(918, 40);
		icons_pause.setToolTipText("Szünet");
		toolbox.add(icons_pause);
		
		//sugo
		JButton icons_help = new JButton(new ImageIcon("pics/helpbutton.jpg"));
		icons_help.setSize(40, 40);
		icons_help.setLocation(918, 80);
		icons_help.setToolTipText("Súgó");
		icons_help.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JFrame help_frame = new JFrame("Súgó");
				help_frame.setPreferredSize(new Dimension(300, 600));
				
				Help help = new Help();

				JTextArea help_text = new JTextArea();
				help_text.setSize(300, 600);
				help_text.setText(help.getHelp());

				JScrollPane help_jp = new JScrollPane(help_text);
				help_jp.setSize(300, 600);
				help_jp.setBorder(null);
				help_frame.add(help_jp);
				
				help_frame.pack();
				help_frame.setVisible(true);
			}
		});
		
		toolbox.add(icons_help);
	}

	public void startGame() {
		//kezdo layout a menu
		createLayout_Menu();
		
		//megjelenites
		pack();
		setVisible(true);
	}
	
	public Field getField() {
		return field;
	}
	
	public JLayeredPane getPField() {
		return pfield;
	}
	
	public void updateMana() {
		mana_value.setText(((Integer)field.getMana()).toString());
		mana_value.setForeground(null);
	}
	
	public void colorMana(int mana) {
		if (field.getMana() >= mana) {
			mana_value.setForeground(Color.GREEN);
		}
		else {
			mana_value.setForeground(Color.RED);
		}
	}
}