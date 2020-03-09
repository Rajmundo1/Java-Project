package gunpowder_plot;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * GameFrame osztály mely a JFrame osztályból származik.
 */
@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	/**
	 * Eltárol egy FloorView-t.
	 */
	private FloorView floor = new FloorView();
	/**
	 * Eltárol egy JMenuItem-t.
	 */
	private JMenuItem loadMenuItem = new JMenuItem("Load");
	
	/**
	 * GameFrame osztály konstruktora.
	 */
	public GameFrame()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu); 
		
		add(menuBar, BorderLayout.NORTH);
		add(floor, BorderLayout.CENTER);
		
		setTitle("Panda mall");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setResizable(false); 
		setLocationRelativeTo(null);
	}
	
	/**
	 * GameFrame osztály AddMouseListener függvénye, mely a paraméterként kapott MouseListener-t hozzáadja az osztályhoz.
	 * @param l - MouseListener típus.
	 * @return - void.
	 */
	public void AddMouseListener(MouseListener l) {
		addMouseListener(l);
	}
	
	/**
	 * GameFrame osztály AddLoadMenuItemActionListener függvénye, mely a paraméterként kapott ActionListener-t hozzáadja az osztályhoz.
	 * @param l - ActionListener típus.
	 * @return - void.
	 */
	public void AddLoadMenuItemActionListener(ActionListener l) {
		loadMenuItem.addActionListener(l);
	}
	
	/**
	 * GameFrame osztály GetFloor függvénye, mely visszaadja az eltárolt FloorView-t.
	 * @return floor - FloorView típus.
	 */
	public FloorView GetFloor()
	{
		return floor;
	}
}
