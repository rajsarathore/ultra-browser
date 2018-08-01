package com.example.ultrabrowser;

public class ListModel {
	private  String title="";
    private  String url="";
    private  String time="";
     
    /*********** Set Methods ******************/
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title=title;
	}

	public void setURL(String url) {
		// TODO Auto-generated method stub
	this.url=url;	
	}

	public void setTime(String time) {
		// TODO Auto-generated method stub
		this.time=time;
	}

	/*********** Get Methods ****************/
    
    public String getTitle()
    {
        return this.title;
    }
     
    public String getUrl()
    {
        return this.url;
    }
 
    public String getTime()
    {
        return this.time;
    } 

}
