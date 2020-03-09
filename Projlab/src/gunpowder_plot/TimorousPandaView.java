package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * TimorousPandaView oszt�ly, mely a PandaView-b�l sz�rmazik.
 */
public class TimorousPandaView extends PandaView {
	/**
	 * Elt�rolunk egy TimorousPanda-t.
	 */
	private TimorousPanda panda;
	
	/**
	 * TimorousPandaView oszt�ly konstruktora.
	 * @param p - TimorousPanda t�pus.
	 * @param f - FloorView t�pus.
	 */
	public TimorousPandaView(TimorousPanda p, FloorView f) {
		super(f);
		panda = p;
	}

	/**
	 * TimorousPandaView oszt�ly Draw met�dusa, mely a param�terk�nt kapott objektumot kirajzolja.
	 * @param graphics - Graphics t�pus.
	 * @return - void.
	 */
	public void Draw(Graphics graphics) {
		TileView tile = floor.GetTileByModelReference(panda.GetTile()); 
		if(tile != null) {
			Point tileCenter = tile.GetCenter();
			Draw(graphics, tileCenter, new Color(0, 0, 125), (panda.GetPreviousInChain() != null));
		} 
	}
}
