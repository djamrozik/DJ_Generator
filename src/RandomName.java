
public class RandomName {

	int size = 0;
	String names[] = new String[size];
	String refreshList[] = new String[size];
	
	public RandomName(String[] inputNames){
		size = inputNames.length;
		this.names = inputNames;
		refreshList = this.names;
	}
	
	public String getName(int legit){
		//ensure that the name I get is going to be completely random
		if(legit == 1){
			int randomIndex  = (int) Math.floor(Math.random() * names.length);
			String name = names[randomIndex];
			removeName(randomIndex);
			return name;
		} else {
			return "...";
		}
	}
	
	public void removeName(int index){
		//remove the name if there will still be another after removing it (the size is at least 2
		if (size > 1) {
			// decrement the size
			size--;
			// create the usual copes
			String[] oldNames = names;
			names = new String[size];
			// make names the same as oldNames, except for that one shitty index
			int x = 0;
			for (int i = 0; i < oldNames.length; i++) {
				if (i != index) {
					names[x] = oldNames[i];
					x++;
				}
			}// end of for loop
		} else {
			refresh();
		}
		
	}
	
	//if we use up all the names, lets go ahead and refresh the list
	public void refresh(){
		names = refreshList;
	}
	
}
