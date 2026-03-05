package datastr;

public class MyArrayList {

	private char[] list;
	private int howManyElements = 0;
	private final int DEFAULT_SIZE = 8;
	private int size = DEFAULT_SIZE;
	
	//konstruktori
	public MyArrayList() {
		list = new char[size];
	}
	
	public MyArrayList(int inputSize) {
		if(inputSize > 0 && inputSize < 100000) {
			size = inputSize;
		}
		
		list = new char[size];
	}
	
	
	//funkcijas
	private boolean isEmpty() {
		/*if(howManyElements == 0) {
			return true;
		}
		else {
			return false;
		}
		*/
		// if-else isais pieraksts
		//return (howManyElements == 0) ? true : false;
		
		//vel isaks
		return (howManyElements == 0);
	}
	
	private boolean isFull() {
		return (howManyElements == size);
	}
	
	public int getHowManyElements() {
		return howManyElements;
	}  

	//resize
	private void resize() {
		int newSize = (howManyElements < 200) ? (size*2) : (int)(size *1.5);
		char[] newList = new char[newSize];
		
		for (int i=0;i < howManyElements; i++) {
			newList[i] = list[i];
		}
		
		list = newList;
		size = newSize;
		System.gc();
	}
	
	public void add(char element) {
		if(isFull()) {
			resize();
		}

		list[howManyElements++] = element;
		//howManyElements++   tiek izdarits ieprekseja rinda
	}
	// nav negativs, nav lieaks par howManyElements, masivs nav pilns (izsaukt resize()), 
	// vekit elementu parkopesanu no beigam par vienu indeksu uz prieksu, bet lids indeksam, kura gribas pievienot jauno ele
	//palielinat howManyElements
	public void add(char element, int given_index) throws IllegalArgumentException{
		if(given_index < 0) {
			throw new IllegalArgumentException("Nav iespejams ievietot elementu, jo indekss ir negatīvs")
		} 
		if(given_index > howManyElements ) {
			throw new IllegalArgumentException("Nav iespejams ievietot elementu, jo indeks ir pārāk liels")
		}


		if(given_index == howManyElements) {
			add(element);
			return
		}

		if(isFull()) {
			resize();
		}

		for (int i = howManyElements ; i > given_index ; i--) {
			list[i] = list[i-1]
		}
		list[given_index] = element
		howManyElements++;
	}

	
}
