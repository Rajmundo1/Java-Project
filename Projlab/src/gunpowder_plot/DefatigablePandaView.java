package gunpowder_plot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * DefatigablePandaView oszt�ly mely a PandaView oszt�lyb�l sz�rmazik le.
 */
public class DefatigablePandaView extends PandaView {
	/**
	 * Elt�roljuk a DefatigablePanda-t.
	 */
	private DefatigablePanda panda;
	
	/**
	 * DefatigablePandaView oszt�ly konstruktora, mely a megadott param�tereknek megfelel�en l�trehoz egy DefatigablePandaView objektumot.
	 * @param p - DefatigablePanda t�pus.
	 * @param f - FloorView t�pus
	 */
	public DefatigablePandaView(DefatigablePanda p, FloorView f) {
		super(f);
		panda = p;
	}
	
	/**
	 * DefatigablePandaView oszt�ly Draw f�ggv�nye, mely kirajzol egy DefatigablePanda objektumot.
	 * @param graphics - Graphics t�pus.
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