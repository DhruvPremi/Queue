package com.datastructure.queue;

import java.util.Iterator;

public class QueueByLinkList<Item> implements Iterable<Item>
{
	LinkList front  = null , back = null;
	
	private class LinkList
	{
		Item item;
		LinkList next;
	}
	
	public boolean isEmpty()
	{
		return front == null;
	}
	
	public void enqueue(Item item)
	{
		if(isEmpty())
		{
			LinkList temp = new LinkList();
			temp.item = item;
			temp.next = front;
			
			front = temp;
			back = temp;
		}
		else
		{
			LinkList temp = new LinkList();
			
			temp.item = item;
			temp.next = null;
			
			back.next = temp;
			back = back.next;
			
		}
	}
	
	public Item dequeue()
	{
		if(isEmpty())
		{
			return null;
		}
		Item toRet = front.item;
		front = front.next;
		if(isEmpty())
		{
			back = null;
		}
		
		return toRet;
	}
	@Override
	public Iterator<Item> iterator() 
	{
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>
	{
		
		LinkList current = front;
		
		@Override
		public boolean hasNext() 
		{
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() 
		{
			// TODO Auto-generated method stub
			Item item = current.item;
			current = current.next;			
			return item;
		}
		
		
		
		
	}
	
}
