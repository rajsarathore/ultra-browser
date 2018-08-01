package com.example.ultrabrowser;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter   implements OnClickListener {
	/*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    public Resources res;
    ListModel tempValues=null;
    int i=0;
     
    /*************  CustomAdapter Constructor *****************/
    public CustomAdapter(Activity a, ArrayList d,Resources resLocal) {
        
        /********** Take passed values **********/
         activity = a;
         data=d;
         res = resLocal;
      
         /***********  Layout inflator to call external xml layout () ***********/
          inflater = ( LayoutInflater )activity.
                                      getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      
 }

 /******** What is the size of Passed Arraylist Size ************/
 public int getCount() {
      
     if(data.size()<=0)
         return 1;
     return data.size();
 }

 public Object getItem(int position) {
     return position;
 }

 public long getItemId(int position) {
     return position;
 }
  
 /********* Create a holder Class to contain inflated xml file elements *********/
 public static class ViewHolder{
      
     public Button btn_title, btn_menu;
     public TextView text_url;
     public TextView text_time;
     

 }

 /****** Depends upon data size called for each row , Create each ListView row *****/
 public View getView(int position, View convertView, ViewGroup parent) {
      
     View vi = convertView;
     ViewHolder holder;
      
     if(convertView==null){
          
         /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
         vi = inflater.inflate(R.layout.bookmark_style, null);
          
         /****** View Holder Object to contain tabitem.xml file elements ******/

         holder = new ViewHolder();
         holder.btn_title=(Button)vi.findViewById(R.id.bookmark_title_button);
		 holder.btn_menu=(Button)vi.findViewById(R.id.bookmark_menu_button);
		 holder.text_url=(TextView)vi.findViewById(R.id.bookmark_url_textview);
		 holder.text_time=(TextView)vi.findViewById(R.id.bookmark_time);
		 
        /************  Set holder with LayoutInflater ************/
         vi.setTag( holder );
     }
     else 
         holder=(ViewHolder)vi.getTag();
      
     if(data.size()<=0)
     {
         holder.btn_title.setText("No Data");
          
     }
     else
     {
         /***** Get each Model object from Arraylist ********/
         tempValues=null;
         tempValues = ( ListModel ) data.get( position );
          
         /************  Set Model values in Holder elements ***********/
        
          holder.text_time.setText( tempValues.getTime() );
          holder.text_url.setText( tempValues.getUrl() );
          holder.btn_title.setText(tempValues.getTitle());
          
          holder.btn_menu.setOnClickListener( new onMenuAction(position));
            //Toast.makeText(activity,"manu Clicked", Toast.LENGTH_LONG).show();
			
           
          /******** Set Item Click Listner for LayoutInflater for each row *******/

          vi.setOnClickListener(new OnItemClickListener( position ));
     }
     return vi;
 }
  
 @Override
 public void onClick(View v) {
         Log.v("CustomAdapter", "=====Row button clicked=====");
 }
  
 /********* Called when Item click in ListView ************/
 private class OnItemClickListener  implements OnClickListener{           
     private int mPosition;
      
     OnItemClickListener(int position){
          mPosition = position;
     }
      
     @Override
     public void onClick(View arg0) {


       Bookmark sct = (Bookmark)activity;

      /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/

         sct.onItemClick(mPosition);
     }               
 }
private class onMenuAction implements OnClickListener{
    int pos;
	public onMenuAction(int position) {
		// TODO Auto-generated constructor stub
		pos=position;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		PopupMenu popup = new PopupMenu(activity, v);
		MenuInflater inflater = popup.getMenuInflater();
		inflater.inflate(R.menu.bookmark, popup.getMenu());
		
		popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				Bookmark bookmrk=(Bookmark)activity;
				switch (item.getItemId()) {
		        case R.id.bookmark_edit:
		           bookmrk.onManuClickAction(pos,0);
		            return true;
		        case R.id.bookmark_delete:
		        	bookmrk.onManuClickAction(pos,1);
		            return true;
		        default:
		            return false;
		         }
			}
		});
		popup.show();
		
	}

	
}
  
}
