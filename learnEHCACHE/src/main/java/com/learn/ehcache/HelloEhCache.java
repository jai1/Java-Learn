package com.learn.ehcache;

import java.util.Scanner;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class HelloEhCache {
	public static void main(String []args)
	{
		System.out.println("\nHello World !!!!");
		Scanner reader = new Scanner(System.in);
		CacheManager cm = CacheManager.getInstance();
		
		cm.addCache("cache1");
		
		Cache cache = cm.getCache("cache1");
		
		cache.put(new Element(1, "Jan")); cache.put(new Element(2, "Feb")); cache.put(new Element(3, "Mar"));
		cache.put(new Element(4, "Apr")); cache.put(new Element(5, "May")); cache.put(new Element(6, "Jun"));
		cache.put(new Element(7, "Jul")); cache.put(new Element(8, "Aug")); cache.put(new Element(9, "Sep"));
		cache.put(new Element(10, "Oct")); cache.put(new Element(11, "Nov")); cache.put(new Element(12, "Dec"));
		String ch=null;
		do {
			System.out.println("\nEnter the month number");
			int month = reader.nextInt();
			if(cache.isKeyInCache(month))
			{
				System.out.println("\nThe Month selected was: "+cache.get(month));			
			} else {
				System.out.println("\nInvalid Month Number entered");	
			}
			System.out.println("\nDo You want to continue [Y/N]: ");
			ch = reader.next();
			ch = ch.trim();
			System.out.println(ch);
		} while(ch.equalsIgnoreCase("Y"));
	}

}
