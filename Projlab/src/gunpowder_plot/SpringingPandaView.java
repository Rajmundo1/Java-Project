package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * SpringingPandaView osztály, mely a PandaView osztályból származik.
 */
public class SpringingPandaView extends PandaView {
	/**
	 * Eltárolunk egy SpringingPanda-t.
	 */
	private SpringingPanda panda;
	
	/**
	 * SpringingPandaView osztály konstruktora.
	 * @param p - SpringingPanda típus.
	 * @param f - FloorView típus.
	 */
	public SpringingPandaView(SpringingPanda p, FloorView f) {
		super(f);
		panda = p;
	}

	/**
	 * SpringingPandaView osztály Draw metódusa, mely a paraméterként kapott objektumot kirajzolja.
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