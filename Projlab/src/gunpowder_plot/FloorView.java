package gunpowder_plot;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * FloorView oszt�ly, mely a JPanel-b�l sz�rmazik.
 */
@SuppressWarnings("serial")
public class FloorView extends JPanel {
	/**
	 * OrangutanView-ket t�rol� lista.
	 */
	private List<OrangutanView> orangutans = new ArrayList<OrangutanView>();
	/**
	 * PandaView-ket t�rol� lista.
	 */
	private List<PandaView> pandas = new ArrayList<PandaView>();
	/**
	 * TileView-ket t�rol� lista.
	 */
	private List<TileView> tiles = new ArrayList<TileView>();
	/**
	 * T�roljuk az aktu�lis szintet.
	 */
	private LevelView level;
	
	/**
	 * FloorView oszt�ly konstruktra, be�ll�tja az alap�rtelmezett m�retet.
	 */
	public FloorView() {
		setPreferredSize(new Dimension(800, 450));
	}
	
	/**
	 * FloorView oszt�ly GetOrangutanAt f�ggv�nye, mely vissza adja az Or�nut�nView-t a param�terk�nt megkapott pontr�l, 
	 * ha val�ban tal�lhat� ott Or�ngut�n.
	 * @param point - Point t�pus
	 * @return OrangutanView t�pus.
	 */
	public OrangutanView GetOrangutanAt(Point point) {
		for(OrangutanView orangutan : orangutans)
			if(orangutan.IsUnder(point))
				return orangutan;
		
		return null;
	}
	
	/**
	 * FloorView oszt�ly GetTileAt f�ggv�nye, mely vissza adja az TileView-t a param�terk�nt megkapott pontr�l, 
	 * ha val�ban tal�lhat� ott TileView.
	 * @param point - Point t�pus
	 * @return TileView t�pus.
	 */
	public TileView GetTileAt(Point point ) {
		for(TileView tile : tiles)
			if(tile.IsUnder(point))
				return tile;
		
		return null;
	}
	
	/**
	 * FloorView oszt�ly GetTileByModelReference f�ggv�nye, mely vissza adja az TileView-t a param�terk�nt megkapott Tile referenci�b�l, 
	 * ha tal�lhat� ilyen TileView.
	 * @param tile - Tile t�pus
	 * @return TileView t�pus.
	 */
	public TileView GetTileByModelReference(Tile tile) {
		for(TileView tileView : tiles)
			if(tileView.GetTile() == tile)
				return tileView;
		
		return null;
	}
	
	/**
	 * FloorView oszt�ly Clear f�ggv�nye, mely t�rli a FloorView-ben t�rolt adatokat.
	 * @return - void.
	 */
	public void Clear() {
		orangutans.clear();
		pandas.clear();
		tiles.clear();
		level = null;
		repaint();
	}
	
	/**
	 * FloorView oszt�ly Add f�ggv�nye, mely hozz�ad a PandaView list�hoz egy �jabb PandaView-t.
	 * @param panda - Panda t�pus.
	 * @return - void.
	 */
	public void Add(PandaView panda) {
		pandas.add(panda);
	}
	
	/**
	 * FloorView oszt�ly Add f�ggv�nye, mely hozz�ad az OrangutanView list�hoz egy �jabb OrangutanView-t.
	 * @param orangutan - Orangutan t�pus.
	 * @return - void.
	 */
	public void Add(OrangutanView orangutan) {
		orangutans.add(orangutan);
	}
	
	/**
	 * FloorView oszt�ly Add f�ggv�nye, mely hozz�ad a TileView list�hoz egy �jabb TileView-t.
	 * @param tile - TileView t�pus.
	 * @return - void.
	 */
	public void Add(TileView tile) {
		tiles.add(tile);
	}
	
	/**
	 * FloorView oszt�ly Add f�ggv�nye, mely be�ll�tja a p�ly�hoz tartoz� LevelView-t.
	 * @param level - LevelView t�pus.
	 * @return - void.
	 */
	public void Add(LevelView level) {
		this.level = level;
	}
	
	/**
	 * FloorView oszt�ly paintComponent f�ggv�nye, mely kirajzolja az emeletet.
	 * @param g - Graphics t�pus.
	 * @return - void.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Glob�lis rajzol�si be�ll�t�sok:
		try {
			Graphics2D g2d = (Graphics2D)g;
		    RenderingHints rh = new RenderingHints(
		            RenderingHints.KEY_TEXT_ANTIALIASING,
		            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		    rh.add(new RenderingHints(
		    		RenderingHints.KEY_FRACTIONALMETRICS,
		    		RenderingHints.VALUE_FRACTIONALMETRICS_ON));
		    rh.add(new RenderingHints(
		    		RenderingHints.KEY_ANTIALIASING,
		    		RenderingHints.VALUE_ANTIALIAS_ON));
		    rh.add(new RenderingHints(
		    		RenderingHints.KEY_STROKE_CONTROL,
		    		RenderingHints.VALUE_STROKE_NORMALIZE));
		    rh.add(new RenderingHints(
		    		RenderingHints.KEY_RENDERING,
		    		RenderingHints.VALUE_RENDER_QUALITY));
		    rh.add(new RenderingHints(
		    		RenderingHints.KEY_COLOR_RENDERING,
		    		RenderingHints.VALUE_COLOR_RENDER_QUALITY));
	
		    g2d.setRenderingHints(rh);
		    
		    Stroke s = new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		    g2d.setStroke(s);
		}
		catch(ClassCastException e) { /* Windows eset�n nem fordulhat el� */ }
		
		// A modell elemeinek kirajzol�sa:
		for(TileView tile : tiles)
			tile.Draw(g);
		
		for(PandaView panda : pandas)
			panda.Draw(g);
		
		for(OrangutanView orangutan : orangutans)
			orangutan.Draw(g);
		
		if(level != null)
			level.Draw(g);
	}
}
