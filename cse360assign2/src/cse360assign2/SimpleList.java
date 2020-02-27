package cse360assign2;

/**
 * 
 * @author Micah Secrest
 * Class ID: 391
 * Assignment 1
 * 
 * SimpleList is a list which contains up to 10 integers
 * and a count of the integers currently in the list.
 * This contains methods which add items, remove items,
 * return the count of items, search for an item, and
 * return the list as a <code>String</code>. 
 *
 */
public class SimpleList
{
	private int[] list;
	private int count;
	
	/**
	 * Constructs SimpleList
	 */
	public SimpleList()
	{
		list = new int[10];
		count = 0;
	}
	
	/**
	 * Adds an element to the front of the list, shifting
	 * all other elements over to make room. If the list is full,
	 * last element "falls off" the list.
	 * 
	 * @param newInt element to be added to list
	 */
	public void add(int newInt)
	{
		int temp;
		
		if (count == 10)
			temp = 9;
		else
			temp = count;
		// Shifts over elements to make room
		while (temp > 0)
		{
			list[temp] = list[temp - 1];
			temp--;
		}
		
		if(count != 10)
			count++;
		
		list[0] = newInt;
	}
	/**
	 * Removes target element from list. Following elements
	 * will be shifted down.
	 * 
	 * @param target element to be removed from list
	 */
	public void remove(int target)
	{
		int location = this.search(target);
		
		if(location != -1)
		{
			for(int i = location; i < count; i++)
			{
				list[i] = list[i + 1];
			}
			count--;
		}
	}
	
	/**
	 * Returns the number of elements stored in the list.
	 * 
	 * @return number of elements stored in the list.
	 */
	public int count()
	{
		return count;
	}
	
	/**
	 * Returns the list as a <code>String</code> with elements
	 * separated by spaces.
	 * 
	 * @return the list as a <code>String</code>
	 */
	public String toString()
	{
		String output = "";
		if(count != 0)
			output += list[0];
		for(int temp = 1; temp < count; temp++)
			output += " " + list[temp];
		return output;
	}
	
	/**
	 * Searches the list for target element and returns its location.
	 * The returned location will be an integer 0-9 where 0 is the front of the list
	 * 
	 * @param target element to be searched for
	 * @return -1 if the element is not in the list;
	 * 			the location of the element otherwise.
	 */
	public int search(int target)
	{
		for(int temp = 0; temp < count; temp++)
		{
			if(list[temp] == target)
			{
				return temp;
			}
		}
		return -1;
	}
	
}