package gunpowder_plot;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * GameController oszt�ly, j�t�k vez�rl�s��rt felel�s.
 */
public class GameController {
	/**
	 * A kiv�lasztott Orangutant t�rolja.
	 */
	Orangutan selectedOrangutan;
	/**
	 * A j�t�kban az id� m�l�s��rt felel�s id�z�t�t t�rolja.
	 */
	Timer timer;
	/**
	 * A j�t�k aktu�lis szintj�nek modellbeli objektum�t t�rolja.
	 */
	Level level;
	/**
	 * A j�t�k ablak�t t�rolja.
	 */
	GameFrame frame;
	
	/**
	 * GameController oszt�ly konstruktora, mely a megadott param�ter alapj�n l�trehozza a "j�t�kkeretet".
	 * @param frame - GameFrame t�pus.
	 */
	public GameController(GameFrame frame) {
		this.frame = frame;
		timer = new Timer(150, new TimerActionListener());
		frame.AddMouseListener(new MouseClickEventListener());
		frame.AddLoadMenuItemActionListener(new LoadMenuItemActionListener());
		timer.start();
	}
	
	/**
	 * GameController oszt�ly bels� oszt�lya, mely az eg�rrel t�rt�n� kattint�sok�rt felel�s.
	 * MouseAdapter oszt�lyb�l sz�rmazik.
	 */
	public class MouseClickEventListener extends MouseAdapter {
		/**
		 * MouseClickEventListener oszt�ly mousePressed f�ggv�nye.
		 * @param e - MouseEvent t�pus.
		 * @return - void.
		 */
		public void mousePressed(MouseEvent e) {
			boolean endOfGame = (level != null) ? level.GetEndOfGame() : true;
			if(!endOfGame) {
				FloorView floor = frame.GetFloor();
				Point point = new Point(e.getPoint().x-3, e.getPoint().y-frame.GetFloor().getY()-26);
				OrangutanView oView = floor.GetOrangutanAt(point);
				TileView tileView = floor.GetTileAt(point);
				
				Orangutan orangutan = (oView != null) ? oView.GetOrangutan() : null;
				Tile tile = (tileView != null) ? tileView.GetTile() : null;
				
				if(e.getButton() == MouseEvent.BUTTON1) {
					if(orangutan == null && selectedOrangutan != null && tile != null)
						selectedOrangutan.StepTo(tile);
					
					else if(orangutan != null && orangutan != selectedOrangutan)
						selectedOrangutan = orangutan;
				}
				else if(e.getButton() == MouseEvent.BUTTON3) {
					if(selectedOrangutan != null && orangutan == selectedOrangutan)
						selectedOrangutan.BreakChain(selectedOrangutan);
					
					else if(selectedOrangutan != null && orangutan != null && tile != null)
						selectedOrangutan.StepTo(tile);
				}
				
				floor.repaint();
			}
		}
	}
	
	/**
	 * GameController oszt�ly bels� oszt�lya, mely az id� m�l�sa �ltal bek�vetkez� v�ltoz�sokat kezeli.
	 * ActionListener interf�szt val�s�tja meg.
	 */
	public class TimerActionListener implements ActionListener {
		/**
		 * TimerActionListener oszt�ly actionPerformed f�ggv�nye.
		 * @param e - ActionEvent.
		 * @return - void.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean endOfGame = (level != null) ? level.GetEndOfGame() : true;
			if(!endOfGame) {
				level.SendTick();
				frame.GetFloor().repaint();
			}
		}
	}
	
	/**
	 * GameController oszt�ly bels� oszt�lya, mely a men�vel t�rt�n� interakci�kat kezeli.
	 * ActionListener interf�szt val�s�tja meg.
	 */
	public class LoadMenuItemActionListener implements ActionListener {
		/**
		 * A LoadMenuItemActionListener oszt�ly actionPerformed f�ggv�nye.
		 * @param e - ActionEvent.
		 * @return - void.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
			fileChooser.setDialogTitle("Load a level");
			fileChooser.setApproveButtonText("Load");
			fileChooser.setApproveButtonToolTipText("Load selected file");
			fileChooser.setFileFilter(new FileNameExtensionFilter("Gunpowder Plot script files","gpscript"));
			
			int returnVal = fileChooser.showOpenDialog(frame);
			String path = (returnVal == JFileChooser.APPROVE_OPTION) ? fileChooser.getSelectedFile().getPath() : null;
			
			if(path == null)
				return;
			
			FloorView floor = frame.GetFloor();
			floor.Clear();
			
			Map<String, Object> userObjects = new LinkedHashMap<>();
			Registry preg = new Registry();
			Registry oreg = new Registry();
			level = new Level(preg, oreg);
			preg.SetLevel(level);
			oreg.SetLevel(level);
			floor.Add(new LevelView(level));
			selectedOrangutan = null;
			
			try(Scanner scanner = new Scanner(new File(path))) {
				while(scanner.hasNextLine()) {
					String line = scanner.nextLine();
					List<String> cmd = new ArrayList<String>(Arrays.asList(line.split(" ")));
					
					switch (cmd.get(0)) {					
					case "createwithview":
						ITimed userObj = null;
						switch (cmd.get(1)) {
						case "armchairtile": 		
							ArmchairTile a = new ArmchairTile();
							floor.Add(new ArmchairTileView(a, DecodePoints(cmd.get(3))));
							userObj = a;
							break;
						case "brittletile":  		
							BrittleTile b = new BrittleTile();  			
							floor.Add(new BrittleTileView(b, DecodePoints(cmd.get(3))));
							userObj = b;
							break;
						case "defatigablepanda":	
							DefatigablePanda d = new DefatigablePanda(preg);
							floor.Add(new DefatigablePandaView(d, floor));
							userObj = d;
							break;
						case "entrytile":			
							EntryTile en = new EntryTile();	
							floor.Add(new EntryTileView(en, DecodePoints(cmd.get(3))));
							userObj = en;
							break;
						case "exittile":			
							ExitTile ex = new ExitTile();	
							floor.Add(new ExitTileView(ex, DecodePoints(cmd.get(3))));
							userObj = ex;
							break;
						case "normaltile":			
							NormalTile n = new NormalTile();
							floor.Add(new NormalTileView(n, DecodePoints(cmd.get(3))));
							userObj = n;
							break;
						case "wardrobetile":		
							NormalTile w = new NormalTile();	
							floor.Add(new WardrobeTileView(w, DecodePoints(cmd.get(3))));
							userObj = w;
							break;
						case "orangutan":			
							Orangutan o = new Orangutan(oreg);	
							floor.Add(new OrangutanView(o, floor));
							userObj = o;
							break;
						case "slotmachinetile":		
							SlotMachineTile s = new SlotMachineTile();	
							floor.Add(new SlotMachineTileView(s, DecodePoints(cmd.get(3))));
							userObj = s;
							break;
						case "springingpanda":		
							SpringingPanda sp = new SpringingPanda(preg);	
							floor.Add(new SpringingPandaView(sp, floor));
							userObj = sp;
							break;
						case "timorouspanda":		
							TimorousPanda tp = new TimorousPanda(preg);	
							floor.Add(new TimorousPandaView(tp, floor));
							userObj = tp;
							break;
						case "vendingmachinetile":	
							VendingMachineTile v = new VendingMachineTile();	
							floor.Add(new VendingMachineTileView(v, DecodePoints(cmd.get(3))));
							userObj = v;
							break;
						case "zootile":				
							ZooTile z = new ZooTile();		
							userObj = z;
							break;
						default:
							throw new IllegalArgumentException();
						}
						
						if(userObj != null) {
							userObjects.put(cmd.get(2), userObj);
							level.addSubscriber(userObj);
						}
						
						break;
						
					case "step":
						((Animal)userObjects.get(cmd.get(1))).StepTo((Tile)userObjects.get(cmd.get(2)));
						break;
						
					case "setneighbors":
						List<String> names = new ArrayList<String>(Arrays.asList(cmd.get(2).split(",")));
						ArrayList<Tile> neighbors = new ArrayList<Tile>();
						
						for(String neighbor : names) 
							neighbors.add((Tile)userObjects.get(neighbor));
						
						((Tile)(userObjects.get(cmd.get(1)))).SetNeighbors(neighbors);
						break;
						
					case "setwayin":
						((ZooTile)(userObjects.get(cmd.get(1)))).SetWayIn((Tile)(userObjects.get(cmd.get(2))));
						break;
						
					case "setwayout":
						((ExitTile)(userObjects.get(cmd.get(1)))).SetWayOut((Tile)(userObjects.get(cmd.get(2))));
						break;
					}
				}
			}
			catch (Exception ex) {
				level = null;
				selectedOrangutan = null;
				frame.GetFloor().Clear();
				JOptionPane.showMessageDialog(null, "Could not load level.", 
	                      "Something went wrong", JOptionPane.WARNING_MESSAGE);
			}	
		}
		
		/**
		 * A LoadMenuItemActionListener oszt�ly DecodePoints f�gg�nye, mely a param�terk�nt kapott String objektumb�l, 
		 * kiolvassa �s elt�rolja a pontokat egy list�ban. Ezt a list�t adja vissza a f�ggv�ny.
		 * @param raw - String.
		 * @return points - Pontokat t�rol� lista.
		 */
		private List<Point> DecodePoints(String raw){
			List<Point> points = new ArrayList<Point>();
			for(String pair : raw.split(";"))
				points.add(new Point(Integer.parseInt(pair.split(",")[0]),
						             Integer.parseInt(pair.split(",")[1])));
			return points;
		}
	}
}
