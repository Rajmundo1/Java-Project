package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * DefatigablePandaView osztály mely a PandaView osztályból származik le.
 */
public class DefatigablePandaView extends PandaView {
	/**
	 * Eltároljuk a DefatigablePanda-t.
	 */
	private DefatigablePanda panda;
	
	/**
	 * DefatigablePandaView osztály konstruktora, mely a megadott paramétereknek megfelelõen létrehoz egy DefatigablePandaView objektumot.
	 * @param p - DefatigablePanda típus.
	 * @param f - FloorView típus
	 */
	public DefatigablePandaView(DefatigablePanda p, FloorView f) {
		super(f);
		panda = p;
	}
	
	/**
	 * DefatigablePandaView osztály Draw függvénye, mely kirajzol egy DefatigablePanda objektumot.
	 * @param graphics - Graphics típus.
	 * @return void.
	 */
	public void Draw(Graphics graphics) {
		TileView tile = floor.GetTileByModelReference(panda.GetTile()); 
		if(tile != null) {
			Point tileCenter = tile.GetCenter();
			Draw(graphics, tileCenter, new Color(145, 0, 0), (panda.GetPreviousInChain() != null));
		} 
	}
}