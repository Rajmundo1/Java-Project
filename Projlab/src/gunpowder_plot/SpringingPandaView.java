package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * SpringingPandaView oszt�ly, mely a PandaView oszt�lyb�l sz�rmazik.
 */
public class SpringingPandaView extends PandaView {
	/**
	 * Elt�rolunk egy SpringingPanda-t.
	 */
	private SpringingPanda panda;
	
	/**
	 * SpringingPandaView oszt�ly konstruktora.
	 * @param p - SpringingPanda t�pus.
	 * @param f - FloorView t�pus.
	 */
	public SpringingPandaView(SpringingPanda p, FloorView f) {
		super(f);
		panda = p;
	}

	/**
	 * SpringingPandaView oszt�ly Draw met�dusa, mely a param�terk�nt kapott objektumot kirajzolja.
	 * @param graphics - Graphics.
	 * @return - void.
	 */
	public void Draw(Graphics graphics) {
		TileView tile = floor.GetTileByModelReference(panda.GetTile()); 
		if(tile != null) {
			Point tileCenter = tile.GetCenter();
			Draw(graphics, tileCenter, new Color(0, 125, 0), (panda.GetPreviousInChain() != null));
		} 
	}
}