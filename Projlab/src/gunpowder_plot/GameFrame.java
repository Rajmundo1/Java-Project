package gunpowder_plot;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * GameFrame oszt�ly mely a JFrame oszt�lyb�l sz�rmazik.
 */
@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	/**
	 * Elt�rol egy FloorView-t.
	 */
	private FloorView floor = new FloorView();
	/**
	 * Elt�rol egy JMenuItem-t.
	 */
	private JMenuItem loadMenuItem = new JMenuItem("Load");
	
	/**
	 * GameFrame oszt�ly konstruktora.
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
	 * GameFrame oszt�ly AddMouseListener f�ggv�nye, mely a param�terk�nt kapott MouseListener-t hozz�adja az oszt�lyhoz.
	 * @param l - MouseListener t�pus.
	 * @return - void.
	 */
	public void AddMouseListener(MouseListener l) {
		addMouseListener(l);
	}
	
	/**
	 * GameFrame oszt�ly AddLoadMenuItemActionListener f�ggv�nye, mely a param�terk�nt kapott ActionListener-t hozz�adja az oszt�lyhoz.
	 * @param l - ActionListener t�pus.
	 * @return - void.
	 */
	public void AddLoadMenuItemActionListener(ActionListener l) {
		loadMenuItem.addActionListener(l);
	}
	
	/**
	 * GameFrame oszt�ly GetFloor f�ggv�nye, mely visszaadja az elt�rolt FloorView-t.
	 * @return floor - FloorView t�pus.
	 */
	public FloorView GetFloor()
	{
		return floor;
	}
}
