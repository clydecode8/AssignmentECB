package adt;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Kok Ming Han, Liew Yee Jie, Lim Wei Sheng, Siew Yuan Feng, Tan Khai Dee
 * @param <T>
 * 
 */

public class ArrayList<T extends Comparable<T>> implements ListInterface<T> {

    
    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 5;
    private Node firstNode;
    
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayList(int initialCapacity){
        
        numberOfEntries = 0;
        array = (T[]) new Comparable[initialCapacity];
    }
 
//------------------------------------------------------
    //Official Implementation of Interfaces
//------------------------------------------------------
    
    //Adding new element
    @Override
    public boolean add(T newElement) {
        
        if(isArrayFull()){
            
            //Doubles size of array if its full
            doubleArray();
        }
        
        array[numberOfEntries] = newElement;
        numberOfEntries++;
        
        //Node Size
        Node newNode = new Node(newElement);
        newNode.next = firstNode;
        firstNode = newNode;
        
        return true;
        
    }

    //Adding new element to specific position
    @Override
    public boolean add(int newPosition, T newElement) {
       
        boolean status = true;
        
        //Checks if the position exceeds 1 & less than current entries+1
        //Current Entries+1 is because entries start from 0
        if((newPosition >= 0) && (newPosition < numberOfEntries+1)){


            if(isArrayFull()){

                doubleArray();
            }

            makeRoom(newPosition + 1);
            array[newPosition] = newElement;  
            numberOfEntries++;
            
            //Node Size
            Node newNode = new Node(newElement);
            newNode.next = firstNode;
            firstNode = newNode;
            
            
        }else{
            
            status = false;
        }
        
        return status;

    }
    
    //Removing element at specific position
    @Override
    public T remove(int indexPosition) {
        
        T result = null;

        //Checks if the position exceeds 1 & less than current entries
        if((indexPosition >= 0) && (indexPosition < numberOfEntries)){
            
            //Stores the array value onto result
            result = array[indexPosition];
            

            
            
            //Node Size
            //add removal of nodes


            if (indexPosition == 0) {      // case 1: remove first entry
                result = firstNode.data;     // save entry to be removed
                firstNode = firstNode.next;
            
            } else {                         // case 2: givenPosition > 1
                
                Node nodeBefore = firstNode;
                for (int i = 1; i < indexPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
                }   
                
                result = nodeBefore.next.data;  // save entry to be removed
                nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the
            
            }
            
            if(indexPosition < numberOfEntries){
                
                //Removes the gap when noEntries exceed index
                removeGap(indexPosition);
            }
            
            numberOfEntries--;
            
        }else{
            
            //Invalid result
            result = null;
            
        }
        
        return result;
    }
    
    //Removes the entry that has the containing word.
    @Override
    public boolean customRemove(String word){
        
        boolean status = false;
        int tempNumb = numberOfEntries;
        T result = null;
        Node currentNode = firstNode;
        Node prevNode = null;
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(word) + "\\b", Pattern.CASE_INSENSITIVE);
        
        for (int i = 0; i < numberOfEntries; i++) {
              
            
            if (pattern.matcher(array[i].toString()).find()) {
                

                // Shift elements to the left to fill the gap
                for (int j = i; j < numberOfEntries - 1; j++) {
                    array[j] = array[j + 1];
                }
                
                while (currentNode != null) {
                    if (currentNode.data.toString().contains(word)) {

                        status = true;

                        if (prevNode == null) { // Removing the first node
                            firstNode = currentNode.next;
                        } else {
                            prevNode.next = currentNode.next;
                        }

                        numberOfEntries--;
                    } else {
                        prevNode = currentNode;
                    }

                    currentNode = currentNode.next;
                }

                
                i--; // Adjust the loop index since you removed an element
            }
        }
        
        
        
        
        
        
        return status;
    }
    
    
    
    
    //Getting the value at specific position
    @Override
    public T getEntry(int indexPosition) {
        
        T result = null;
        
        //Validation whether indexPosition in range of 1 and numberofentries
        if((indexPosition >= 0) && (indexPosition < numberOfEntries)){
            
            result = array[indexPosition];
        }

        return result;
    }

    //Checks whether list contains specific Element
    @Override
    public boolean contains(T givenElement) {
        
        boolean status = false;
        
        //Validation Check
        //!status = If FALSE meaning that it has not been found
        //!status = If TRUE meaning that it has been found
        //Better efficiency instead of constant looping
        
        for (int index = 0; !status && (index < numberOfEntries); index++) {
        
            if (givenElement.equals(array[index])) {
                status = true;
            }
        }
        
        return status;       
        
    } 
    

    //Checks whether Empty
    @Override
    public boolean isEmpty() {
        
        //Returns false if not empty, true if empty
        return numberOfEntries == 0;
    }
    
    //Checks whether full
    @Override
    public boolean isFull() {
        
        //Dynamic Array where size is increased every time array is full is being used
        return false;
    }
    
    //Clears everything
    @Override
    public void clear() {
        
        //Enhance efficiency 
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        
        firstNode = null;
        
        numberOfEntries = 0;
    }
    
    //Replace element at specific position
    @Override
    public boolean replace(int indexPosition, T newElement) {

        boolean status = true;
        
        //Validation to check indexPosition whether in range of 1 and noEntries
        if ((indexPosition >= 0) && (indexPosition < numberOfEntries)){
            
            array[indexPosition] = newElement;
            
        }else{
            
            status = false;
        }
        
        return status;
        
        
    }

    @Override
    //Get number of entries
    public int getNumberOfEntries(){
        
        return numberOfEntries;
    }
    
    //Get the index of the element
    @Override
    public int getIndexOf(T givenElement){
        
        int index = -1;
        
        //Cannot be 0
        if (numberOfEntries == 0) {
            
            return -1; // Return -1 to indicate failure
        }
        
        //Loop through array to find the element
        for(int i = 0; i < numberOfEntries; i++){
            
            if(array[i] != null || array[i].equals(givenElement)){
                
                System.out.println(array[i]);
                index = i;
                break;
                
            }
        }
        
        return index;        
    }
    
    //Finds the size of the list
    @Override
    public int size(){
        
        //Returns the number of values inside of the list
        return size(firstNode);
    }
    
    public int size(Node passInFirstNode){
        
        if(passInFirstNode == null){
            
            return 0;
            
        }else{
            
            return 1 + size(passInFirstNode.next);
        }
    }
    
    //Checks whether list contains specific word (String)
    //Returns the entry that has that specific word
    //Duplicate words in an entry also are returned
    @Override
    public boolean condSearch(String targetWord) {
        
        boolean found = false;
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(targetWord) + "\\b", Pattern.CASE_INSENSITIVE);
        
        for (int i = 0; i < numberOfEntries; i++) {
              
            if (pattern.matcher(array[i].toString()).find()) {
                System.out.println(array[i].toString());
                found = true;
            }
        }
       
        return found;
    }
    
    //Search method with conditions
    //Same as condSearch(), returns entries but with validation of two values
    //twoCondSearch takes 2 Strings and 1 integer as parameters
    //The integers are for conditions (1-3)
    //Duplicatewords in an entry are also returned
    @Override
    public boolean twoCondSearch(String targetWord, String targetWord2, int cond) {

        boolean status = false;
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(targetWord) + "\\b", Pattern.CASE_INSENSITIVE);
        
        String regex = "\\b" + Pattern.quote(targetWord) + "\\b.*\\b" + Pattern.quote(targetWord2) + "\\b|\\b" + Pattern.quote(targetWord2) + "\\b.*\\b" + Pattern.quote(targetWord) + "\\b";
        Pattern pattern2 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        
        String integerPattern = "\\b\\d+\\b";
        Pattern intpattern = Pattern.compile(integerPattern);
        
        String doublePattern = "\\b\\d+(\\.\\d+)?\\b";
        Pattern doublepattern = Pattern.compile(doublePattern);
        
        switch(cond){
            
            //String and String
            case 1:
                
                for (int i = 0; i < numberOfEntries; i++) {
                    
                    
                    if (pattern2.matcher(array[i].toString()).find()) {

                        status = true;
                        System.out.println(array[i]);

                    }
                }
                
                break;
            
            //String and Integer
            case 2:
                
                int targetValue = Integer.parseInt(targetWord2);
                for (int i = 0; i < numberOfEntries; i++) {
                    
                    
                    if (pattern.matcher(array[i].toString()).find()) {
                        
                        if(containsInteger(array[i], targetValue, intpattern)){
                            
                            status = true;
                            System.out.println(array[i]);
                            
                        }

                    }
                }
                
                break;
                
            //String and Double
            case 3:
                
                double targetValue2 = Double.parseDouble(targetWord2);
                for (int i = 0; i < numberOfEntries; i++) {
                    
                    
                    
                    if (pattern.matcher(array[i].toString()).find()) {
                        
                        if(containsDouble(array[i], targetValue2, doublepattern)){
                            
                            status = true;
                            System.out.println(array[i]);
                            
                        }

                    }
                }
                
                break;
              
        }
       
        return status;
    }
    
    
    //Search method with conditions
    //Same as condSearch(), returns entries but with validation of three values
    //twoCondSearch takes 3 Strings and 1 integer as parameters
    //The integers are for conditions (1-3)
    //Duplicatewords in an entry are also returned
    @Override
    public boolean threeCondSearch(String targetWord, String targetWord2, String targetWord3, int cond) {

        String regex = "\\b" + Pattern.quote(targetWord) + "\\b.*\\b" + Pattern.quote(targetWord2) + "\\b.*\\b" + Pattern.quote(targetWord3) + "\\b|\\b" 
             + Pattern.quote(targetWord2) + "\\b.*\\b" + Pattern.quote(targetWord) + "\\b.*\\b" + Pattern.quote(targetWord3) + "\\b|\\b"
             + Pattern.quote(targetWord3) + "\\b.*\\b" + Pattern.quote(targetWord) + "\\b.*\\b" + Pattern.quote(targetWord2) + "\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        
        
        String integerPattern = "\\b\\d+\\b";
        Pattern intpattern = Pattern.compile(integerPattern);
        
        String doublePattern = "\\b\\d+(\\.\\d+)?\\b";
        Pattern doublepattern = Pattern.compile(doublePattern);
        
        
        boolean status = false;
        
        switch(cond){

            //String, String and String
            case 1:
                
                for (int i = 0; i < numberOfEntries; i++) {
                    
                    
                    if (pattern.matcher(array[i].toString()).find()) {

                        status = true;
                        System.out.println(array[i]);

                    }
                }
                
                break;                
                
            //String, String and Double
            case 2:
                
                double targetValue = Double.parseDouble(targetWord3);
                for (int i = 0; i < numberOfEntries; i++) {
                    
                    
                    
                    if (pattern.matcher(array[i].toString()).find()) {
                        
                        if(containsDouble(array[i], targetValue, doublepattern)){
                            
                            status = true;
                            System.out.println(array[i]);
                            
                        }

                    }
                }
                
                break;    
                
            //String, String and Integer
            case 3:
                
                int targetValue2 = Integer.parseInt(targetWord3);
                for (int i = 0; i < numberOfEntries; i++) {
                    
                    
                    if (pattern.matcher(array[i].toString()).find()) {
                        
                        if(containsInteger(array[i], targetValue2, intpattern)){
                            
                            status = true;
                            System.out.println(array[i]);
                            
                        }

                    }
                }
                
                break;              
                
                

        }
        

       
        return status;
    }
    
    //Checks whether the entry contains this integer value
    //Returns all entries
    //Returns duplicate values in an entry ("12", 12)
    @Override
    public boolean customIntegerContains(int targetValue) {
        
        boolean status = false;
        for (int i = 0; i < numberOfEntries; i++) {
           
            if (containsInteger(array[i], targetValue)) {
                System.out.println(array[i]);
                status = true;
            }
        }
        
        return status;
    }

    //Checks whether the entry contains this double value
    //Returns all entries
    //Returns duplicate values in an entry ("12.0", 12.0)    
    @Override
    public boolean customDoubleContains(double targetValue) {
        
        boolean status = false;
        for (int i = 0; i < numberOfEntries; i++) {
           
            if (containsDouble(array[i], targetValue)) {
                System.out.println(array[i]);
                status = true;
            }
        }
        
        return status;
    }
    
    //Replaces all oldValues with newValue in all entries
    //Duplicate oldValues in an entry will also be changed to newValue
    @Override
    public boolean replaceAll(String oldValue, String newValue) {
        
        boolean found = false;
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(oldValue) + "\\b", Pattern.CASE_INSENSITIVE);
        for (int i = 0; i < numberOfEntries; i++) {
            
            
            if (pattern.matcher(array[i].toString()).find()) {
                    
                    String newString = array[i].toString().replace(oldValue, newValue);
                    
                    //Cast comparator onto newString
                    array[i] = (T) newString;
                    found = true;
            }
               
        }
        
        return found;
    }
    
    //Bubble sort
    //Sort according to each entities' critieria
    //Each entities contains a compareTo()
    //Sort will work according to the compareTo() logic code
    @Override
    public void sort(int cond) {
        
        //Ascending
        if(cond == 0){
            
            for (int i = 0; i < numberOfEntries - 1; i++) {
                for (int j = 0; j < numberOfEntries - i - 1; j++) {

                    if (array[j].toString().compareTo(array[j+1].toString()) > 0) {
                        T temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;

                    }
                }


            }
            
        //Descending
        }else if(cond == 1){
            
            for (int i = 0; i < numberOfEntries - 1; i++) {
                for (int j = 0; j < numberOfEntries - i - 1; j++) {

                    if (array[j].toString().compareTo(array[j+1].toString()) < 0) {
                        T temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;

                    }
                }


            }            
            
        }
        
    }
    
    //Iterator method
    //Its a for loop substitude
    //hasNext() checks for size
    //Must be comparable when calling the method
    //Comparable tutorialGroup = iterator.next();
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }
    

    
    private class ArrayListIterator<T extends Comparable<T>> implements Iterator<T> {
        
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < numberOfEntries;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next element");
            }
            return (T) array[currentIndex++];
        }
    }
    

//------------------------------------------------------   
    //Extra methods for implementation
//------------------------------------------------------
    
    //Declaration for Nodes
    private class Node {
        
        private Node next;
        private T data;
        
        private Node(T data){
            
            this.data = data;
            this.next = null;
        }
        
        private Node(Node next){
            
            this.data = data;
            this.next = next;
        }
    }
    
    //Extra function for circular array
    @Override
    public T remove(T element) {
        
        T temp = null;
        for (int i = 0; i < numberOfEntries; i++) {
            
            temp = array[i];
            
            
            if(contains(element)){
                
                temp = element;
            }
            
        }
    
        return temp;
    }
    
    //Check whether the array is full
    private boolean isArrayFull(){
        
        //Returns True when No of entries same as array length
        return numberOfEntries == array.length;
        
    }
    
    //Pushes the positions to the back, add()
    private void makeRoom(int newPosition){
        
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;
        
        //Moves each entry to the next higher index
        //Starts at the end of array until it reaches newIndex
        //Better efficiency
        //{0, 1, 2} -> {_, 0, 1, 2}
        //0 and the following numbers will be moved to the back
        for (int i = lastIndex; i >= newIndex; i--){
            
            array[i+1] = array[i];
            
        }
        
    }
    
    //Removes the gap for remove()
    private void removeGap(int givenPosition) {
        
        /*
        * Task: Shifts entries that are beyond the entry to be removed to the next
        * lower position. Precondition: array is not empty; 1 <= givenPosition <
        * numberOfEntries; numberOfEntries is array's numberOfEntries before removal.
        */

        int removedIndex = givenPosition;
        int lastIndex = numberOfEntries - 1;

        for (int i = removedIndex; i < lastIndex; i++) {
            array[i] = array[i + 1];
        }
        
    }
    
    //Doubles the size of array
    private void doubleArray(){
        
        T[] oldArray = array;
        array = (T[]) new Comparable[oldArray.length * 2];
        for (int i = 0; i < oldArray.length; i++) {
            
            array[i] = oldArray[i];
            
        }
    }
    
    //Validation for customIntegerContains()
    //item is array[i], it will check whether it contains the specific value
    private boolean containsInteger(T item, int targetValue) {
        String itemString = item.toString();
        return itemString.contains(Integer.toString(targetValue));
    }
    
    //Method overloading for extra parameter PATTERN
    private boolean containsInteger(T item, int targetValue, Pattern pattern) {
        String itemString = item.toString();
        Matcher matcher = pattern.matcher(itemString);
        while (matcher.find()) {
            // Extract the matched substring
            String matchedSubstring = matcher.group();
            // Check if the matched substring contains the integer value
            try {
                int intValue = Integer.parseInt(matchedSubstring);
                if (intValue == targetValue) {
                    return true;
                }
            } catch (NumberFormatException e) {
                    // Ignore parsing errors and continue searching
            }
        }
        return false; // Return false if no match is found

   }
    
        
    //Validation for customDoubleContains()
    //item is array[i], it will check whether it contains the specific value
    private boolean containsDouble(T item, double targetValue) {
        String itemString = item.toString();
        return itemString.contains(Double.toString(targetValue));
    }
    
    //Method overloading for extra parameter PATTERN
    private boolean containsDouble(T item, double targetValue, Pattern pattern) {
        String itemString = item.toString();
        Matcher matcher = pattern.matcher(itemString);
        while (matcher.find()) {
            // Extract the matched substring
            String matchedSubstring = matcher.group();
            // Check if the matched substring represents a double value
            try {
                double doubleValue = Double.parseDouble(matchedSubstring);
                if (Double.compare(doubleValue, targetValue) == 0) {
                    return true;
                }
            } catch (NumberFormatException e) {
                // Ignore parsing errors and continue searching
            }
        }
        return false; // Return false if no match is found
    }
    

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfEntries; i++) {
            sb.append(array[i].toString());
            sb.append("\n");
        }
        return sb.toString();
        
    }
    
    public String toString2(){
         StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfEntries; i++) {
            if(i!= numberOfEntries-1){
                sb.append(array[i].toString());
                sb.append(", ");
            }
            else{
                sb.append(array[i].toString());

            }
            
        }
        return sb.toString();
    }
    
    
    
}

