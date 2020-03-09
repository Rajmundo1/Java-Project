package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * TimorousPandaView osztály, mely a PandaView-bõl származik.
 */
public class TimorousPandaView extends PandaView {
	/**
	 * Eltárolunk egy TimorousPanda-t.
	 */
	private TimorousPanda panda;
	
	/**
	 * TimorousPandaView osztály konstruktora.
	 * @param p - TimorousPanda típus.
	 * @param f - FloorView típus.
	 */
	public TimorousPandaView(TimorousPanda p, FloorView f) {
		super(f);
		panda = p;
	}

	/**
	 * TimorousPandaView osztály Draw metódusa, mely a paraméterként kapott objektumot kirajzolja.
	 * @param graphics - Graphics típus.
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
