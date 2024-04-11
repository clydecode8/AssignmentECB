private ListInterface<TutorialGroup> **tutorialList** = new ArrayList<>(); //Declare sin

# Basic Function
-------------------------

`add(T newElement)`
> - tutorialList.add(new TutorialGroup(...));<br /><br />

`add(int newPosition, T newElement)`<br />
> - number must start from 0, array[0], array[1], array[2]<br />
> - tutorialList.add(number, new TutorialGroup(...));

`remove(int indexPosition) ` 
> - tutorialList.remove(1)<br />
> - number must start from 0 <br /><br />

`getEntry(int indexPosition)` 
> - tutorialList.getEntry(1)<br />
> - number must start from 0 <br /><br />

`contains(T element)` tutorialList.contains(new TutorialGroup(...)) <br /><br />
`isEmpty()` `isFull()` `clear()` `getNumberOfEntries()`<br /><br />

`replace(int indexPosition, T newElement)` <br />
tutorialList.replace(0, new TutorialGroup(...))<br /><br />

# New Functions
---------------------------
`getIndexOf(T givenElement)` <br />
> - Returns index value of that element. <br />
> - TutorialGroup tg = new TutorialGroup("FCP1203") <br />
> - tutorialList.add(tg); <br />
> - tutorialList.getIndexOf(tg) <br />

`size()` <br /><br />

`condSearch(String i)` <br />
> - Return output of the search <br />
> - condSearch("Han") <br /><br />

`twoCondSearch(String i, String j, int case)` <br />
> - twoCondSearch("Han", "FOCS", 1), twoCondSearch("Han", "23", 2), twoCondSearch("Han, "23.2", 3) <br />
> - twoCondSearch() got case 1-3 condition. 1 - (String, String), 2 - (String, Integer), 3 - (String, Double). <br /><br />
> - the function will auto convert the string to number (int / double)<br /><br />

`threeCondSearch(String i, String j, String k, int case)`<br />
> - threeCondSearch("Han", "FOCS", "FCP1307", 1), threeCondSearch("Han", "FOCS", "23"), threeCondSearch("Han, "FOCS", "23.2") <br />
> - threeCondSearch() got case 1-3 condition. 1 - (String, String, String), 2 - (String, String, Integer), 3 - (String, String, Double). <br />
> - the function will auto convert string to number (int / double)<br /><br />

`customIntegerContains(int value)`<br />
> - customIntegerContains(1)<br />
> - find if the entry value got 1, then output <br />
> - tutorialList.customIntegerContains(1); <br /><br />

`customDoubleContains(double value)`
> - customDoubleContains(1.2)<br />
> - find if the entry value got 1.2, then output <br />
> - tutorialList.customIntegerContains(1.2); <br /><br />

`replaceAll(String old, String new)`
> - tutorialList.replaceAll("FCP1307", "RSW2S2G4") <br />
> - find if entry value got FCP1307, then change to RSW2S2G4 <br />
> - if value is integer/double also can change <br /><br />

`customRemove(String word)`
> - tutorialList.customRemove("FCP1307") <br />
> - remove all entry that have FCP1307 <br /><br />

`sort(int cond)`
> - tutorialList.sort(0) //0 for ascending, 1 for descending <br />
> - the array[i] value will change if u call .sort() <br />

`iterator()`
> - Iterator<TutorialGroup> iterator = tutorialList.iterator();
> - while (iterator.hasNext()) {
>  		Comparable tutorialGroup = iterator.next();
>  		// Do something with tutorialGroup...
>  		System.out.println(tutorialGroup.toString());
> - }
> - must be comparable
> - substitute for loop with .next
> - for(int i = 0; i < tutorialList.size(); i++){} sama meaning with iterator


# ECB Design
---------------
> - `ADT`
>   - ArrayList + ListInterface
> - `Boundary`
>   - UI classes, GroupManagementUI, AssignmentTeamUI
> - `Control`
>   - Main class + ur module
> - `Entity`
>   - Student, Programme, TutorialGroup, Registration
> - `Utility`
>   - MessageUI

# Entity
---------
> - `Every entity must include:`
> - implements Comparable<class name><br />
> - equals(): cnp from other entity and change
> - hashCode()
> - compareTo(): ur sort() method, getName() = sort by getName() <br />

