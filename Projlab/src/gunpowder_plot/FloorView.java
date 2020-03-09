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
 * FloorView osztály, mely a JPanel-bõl származik.
 */
@SuppressWarnings("serial")
public class FloorView extends JPanel {
	/**
	 * OrangutanView-ket tároló lista.
	 */
	private List<OrangutanView> orangutans = new ArrayList<OrangutanView>();
	/**
	 * PandaView-ket tároló lista.
	 */
	private List<PandaView> pandas = new ArrayList<PandaView>();
	/**
	 * TileView-ket tároló lista.
	 */
	private List<TileView> tiles = new ArrayList<TileView>();
	/**
	 * Tároljuk az aktuális szintet.
	 */
	private LevelView level;
	
	/**
	 * FloorView osztály konstruktra, beállítja az alapértelmezett méretet.
	 */
	public FloorView() {
		setPreferredSize(new Dimension(800, 450));
	}
	
	/**
	 * FloorView osztály GetOrangutanAt függvénye, mely vissza adja az OránutánView-t a paraméterként megkapott pontról, 
	 * ha valóban található ott Orángután.
	 * @param point - Point típus
	 * @return OrangutanView típus.
	 */
	public OrangutanView GetOrangutanAt(Point point) {
		for(OrangutanView orangutan : orangutans)
			if(orangutan.IsUnder(point))
				return orangutan;
		
		return null;
	}
	
	/**
	 * FloorView osztály GetTileAt függvénye, mely vissza adja az TileView-t a paraméterként megkapott pontról, 
	 * ha valóban található ott TileView.
	 * @param point - Point típus
	 * @return TileView típus.
	 */
	public TileView GetTileAt(Point point ) {
		for(TileView tile : tiles)
			if(tile.IsUnder(point))
				return tile;
		
		return null;
	}
	
	/**
	 * FloorView osztály GetTileByModelReference függvénye, mely vissza adja az TileView-t a paraméterként megkapott Tile referenciából, 
	 * ha található ilyen TileView.
	 * @param tile - Tile típus
	 * @return TileView típus.
	 */
	public TileView GetTileByModelReference(Tile tile) {
		for(TileView tileView : tiles)
			if(tileView.GetTile() == tile)
				return tileView;
		
		return null;
	}
	
	/**
	 * FloorView osztály Clear függvénye, mely törli a FloorView-ben tárolt adatokat.
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
	 * FloorView osztály Add függvénye, mely hozzáad a PandaView listához egy újabb PandaView-t.
	 * @param panda - Panda típus.
	 * @return - void.
	 */
	public void Add(PandaView panda) {
		pandas.add(panda);
	}
	
	/**
	 * FloorView osztály Add függvénye, mely hozzáad az OrangutanView listához egy újabb OrangutanView-t.
	 * @param orangutan - Orangutan típus.
	 * @return - void.
	 */
	public void Add(OrangutanView orangutan) {
		orangutans.add(orangutan);
	}
	
	/**
	 * FloorView osztály Add függvénye, mely hozzáad a TileView listához egy újabb TileView-t.
	 * @param tile - TileView típus.
	 * @return - void.
	 */
	public void Add(TileView tile) {
		tiles.add(tile);
	}
	
	/**
	 * FloorView osztály Add függvénye, mely beállítja a pályához tartozó LevelView-t.
	 * @param level - LevelView típus.
	 * @return - void.
	 */
	public void Add(LevelView level) {
		this.level = level;
	}
	
	/**
	 * FloorView osztály paintComponent függvénye, mely kirajzolja az emeletet.
	 * @param g - Graphics típus.
	 * @return - void.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Globális rajzolási beállítások:
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
		catch(ClassCastException e) { /* Windows esetén nem fordulhat elõ */ }
		
		// A modell elemeinek kirajzolása:
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
