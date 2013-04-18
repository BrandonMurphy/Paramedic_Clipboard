package com.home.customarrayadapter;
/*
 * This class is used to populate the ListView
 * in the XML files. The ListView will have a title and subtitle.
 * We populate these objects with data that we want to show.
 */

public class List_Item {
	private final String title;
	private final String subtitle;
	private final int id;
	
	//constructor - receives title, subtitle, and id of the listview item
	public List_Item(final String title, final String subtitle, final int id){
		this.title = title;
		this.subtitle = subtitle;
		this.id = id;
	}
	
	// Get the title of the listview item
	public String getTitle(){
		return title;
	}
	
	// Get the subtitle of the listview item
	public String getSubtitle(){
		return subtitle;
	}
	
	// Get the id of the item. This will be used to pass the actuall ID to the other view
	//so we know which item was clicked/
	public int getId(){
		return id;
	}
}
