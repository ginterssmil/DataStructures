package datastr;

import java.util.ArrayList;

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
			throw new IllegalArgumentException("Nav iespejams ievietot elementu, jo indekss ir negatīvs");
		} 
		if(given_index > howManyElements ) {
			throw new IllegalArgumentException("Nav iespejams ievietot elementu,  jo indekss ir lielāks par elementu skait");
		}


		if(given_index == howManyElements) {
			add(element);
			return;
		}

		if(isFull()) {
			resize();
		}

		for (int i = howManyElements ; i > given_index ; i--) {
			list[i] = list[i-1];
		}
		list[given_index] = element;
		howManyElements++;
	}

	public void remove(int given_index) throws Exception {
		if(isEmpty()) {
			throw new Exception("Nav iespējams dzēst elementu, jo saraksts ir tukšs.");
		}
		if(given_index < 0) {
			throw new IllegalArgumentException("Nav iespejams dzēst elementu, jo indekss ir negatīvs");
		} 
		if(given_index >= howManyElements ) {
			throw new IllegalArgumentException("Nav iespejams dzēst elementu,  jo indekss ir lielāks vai vienāds ar elementu skait");
		}

		


		for (int i = given_index ; i < howManyElements ; i++) {
			list[i] = list[i+1];
		}
		list[howManyElements--] = ' ';
	}

	public char get(int given_index) throws IllegalArgumentException {
		if(isEmpty()) {
			throw new IllegalArgumentException("Nav iespējams iegūt elementu, jo saraksts ir tukšs.");
		}
		if(given_index < 0) {
			throw new IllegalArgumentException("Nav iespejams iegūt elementu, jo indekss ir negatīvs");
		} 
		if(given_index >= howManyElements ) {
			throw new IllegalArgumentException("Nav iespejams iegūt elementu, jo indekss ir lielāks vai vienāds ar elementu skait");
		}

		return list[given_index];

	}

	public ArrayList<Integer> search(char element) throws Exception{
			if(isEmpty()) {
				throw new Exception("Nav iespējams veikt elementa meklēšanu, jo saraksts ir tukšs.");
		}

		ArrayList<Integer> indexArrayList = new  ArrayList<Integer>();
		for(int i=0;i<howManyElements;i++) {
			if (list[i] == element) {
				indexArrayList.add(i);
			}
		}

		if(indexArrayList.isEmpty()) {
			throw new Exception("Meklētais elements" + element + "neatrodas saraksta");
		}

		return indexArrayList;
	}
	
	public char[] getNextElements(char element) throws Exception{
		ArrayList<Integer> arrayListForIndexes = search(element);
		
		int howManyNextElements = arrayListForIndexes.size();
		if(arrayListForIndexes.get(arrayListForIndexes.size()-1) == howManyElements) {
			howManyNextElements--;
		}
		
		char[] nextElements = new char[howManyNextElements];
		int indexForNextElementArray = 0;
		
		for(int i = 0; i < arrayListForIndexes.size() ; i++) {
			int nextElementIndex = arrayListForIndexes.get(i)+1;
			nextElements[indexForNextElementArray] = list[nextElementIndex];
			indexForNextElementArray++;
		}

		return nextElements;
	}

	public void sort() throws Exception {
		if(isEmpty()) {
			throw new Exception("Nav iespējams kārtot sarakstu, jo tas ir tukšs.");
		}
		for(int i=0;i<howManyElements;i++) {
			for(int j = 0; j<howManyElements;j++) {
				if (list[i] > list[j]) {
					char temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}

	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("Nav iespējams izvadīt sarakstu, jo tas ir tukšs ");
		}
		for(int i = 0 ; i < howManyElements ; i++) {
			System.out.println(list[i] + " ");
		}
		System.out.println();
		
	}

	public void makeEmpty() {
		list = null;// atkabina refrenci no datiem, zaudē datus
		System.gc();// iztīra datus,   šīs 2 rindas var nerakstīt
		howManyElements=0;
		size = DEFAULT_SIZE;
		list = new char[size];
	}

}
