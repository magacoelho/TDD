import java.util.ArrayList;


public class StartController {

	public int sizeWaste() {
	
		return 0;
	}

	public int sizeDeck() {
		return 24;
	}

	public int getNumberFoundations() {
		return 4;
	}

	

	public ArrayList<Integer> getSizeFoundations() {
		ArrayList<Integer> sizeFoundations= new ArrayList<Integer>();
		sizeFoundations.add(new Integer(0));
		sizeFoundations.add(new Integer(0));
		sizeFoundations.add(new Integer(0));
		sizeFoundations.add(new Integer(0));
		return sizeFoundations;
	}

}
