
 package ishan.khandelwal.vitsilentmode;

import java.util.ArrayList;
import java.util.Calendar;





import android.app.AlarmManager;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
//import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MorningFragment extends Fragment implements OnClickListener {

private ArrayList <Calendar> Cal= new ArrayList <Calendar>(25);
	
	
	private ArrayList <CheckBox> l= new ArrayList <CheckBox>(14);
	private ArrayList <Boolean> checkboxValue_m = new ArrayList <Boolean>(14);
	

	private SharedPreferences mSharedPreferences_m;
    private SharedPreferences.Editor mPrefsEditor_m;
    //private Button submitButton_m;
    
   

	
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	 View rootView = inflater.inflate(R.layout.activity_slots, container, false);
		addenable();
		
		Log.d("inside fragment", "Layout set");
		
		
		// Demonstration of a collection-browsing activity.
        rootView.findViewById(R.id.button1)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    	
                    	Log.d("onClick", "inside onclick");
                		Toast.makeText(getActivity(), "on click", Toast.LENGTH_SHORT).show();
                    	
                    	 for(int i = 0; i < 14 ; i++){

             		        if(l.get(i).isChecked()){
             		            mPrefsEditor_m.putBoolean("morning"+i, true);
             		            mPrefsEditor_m.apply();
             		        }
             		        else {
             		            mPrefsEditor_m.putBoolean("morning"+i, false);
             		            mPrefsEditor_m.apply();
             		        }
             		    }
             		
             		   getdata(view);
             		
                        
                    }
                });
		
		
		//submitButton_m = (Button)findViewById(R.id.button1);
        //submitButton_m.setOnClickListener(this);
        
        mSharedPreferences_m = getActivity().getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
        mPrefsEditor_m = mSharedPreferences_m.edit();

		
		
		//new
		//Initialise check boxes for every slot
		for (int i = 1; i <= 14; i++) {
			   String viewId = "checkBox" + i;
			   l.add(i-1, (CheckBox) rootView.findViewById(getResources().getIdentifier(viewId, "id", "ishan.khandelwal.vitsilentmode")));
			   checkboxValue_m.add(i-1, mSharedPreferences_m.getBoolean("morning"+(i-1), false));
			   
			   if (checkboxValue_m.get(i-1) == true) 
			   {
		           l.get(i-1).setChecked(true);
		           }
		}
		
		return rootView;

		
	}



	
	public void addenable(){
		
	}
	public void getdata(View V){
		
		Log.d("Inside getdata", "inside getdata");
		Toast.makeText(getActivity(), "GetData", Toast.LENGTH_SHORT).show();
		//Set Calendar for A1 Slot
		Cal.add(0, Calendar.getInstance());
		Cal.get(0).set(Calendar.DAY_OF_WEEK, 2);
		Cal.get(0).set(Calendar.HOUR_OF_DAY, 8);
		Cal.get(0).set(Calendar.MINUTE, 0);
		Cal.get(0).set(Calendar.SECOND, 0);

		Cal.add(1, Calendar.getInstance());
		Cal.get(1).set(Calendar.DAY_OF_WEEK, 5);
		Cal.get(1).set(Calendar.HOUR_OF_DAY, 9);
		Cal.get(1).set(Calendar.MINUTE, 0);
		Cal.get(1).set(Calendar.SECOND, 0);
		
		Cal.add(2, Calendar.getInstance());
		Cal.get(2).set(Calendar.DAY_OF_WEEK, 3);
		Cal.get(2).set(Calendar.HOUR_OF_DAY, 11);
		Cal.get(2).set(Calendar.MINUTE, 0);
		Cal.get(2).set(Calendar.SECOND, 0);
		
		
				
				//Set Calendar for B1 Slot
				Cal.add(3, Calendar.getInstance());
				Cal.get(3).set(Calendar.DAY_OF_WEEK, 3);
				Cal.get(3).set(Calendar.HOUR_OF_DAY, 8);
				Cal.get(3).set(Calendar.MINUTE, 0);
				Cal.get(3).set(Calendar.SECOND, 0);

				Cal.add(4, Calendar.getInstance());
				Cal.get(4).set(Calendar.DAY_OF_WEEK, 6);
				Cal.get(4).set(Calendar.HOUR_OF_DAY, 9);
				Cal.get(4).set(Calendar.MINUTE, 0);
				Cal.get(4).set(Calendar.SECOND, 0);
				
				Cal.add(5, Calendar.getInstance());
				Cal.get(5).set(Calendar.DAY_OF_WEEK, 4);
				Cal.get(5).set(Calendar.HOUR_OF_DAY, 11);
				Cal.get(5).set(Calendar.MINUTE, 0);
				Cal.get(5).set(Calendar.SECOND, 0);
				
				
				
				//Set Calendar for C1 Slot
				Cal.add(6, Calendar.getInstance());
				Cal.get(6).set(Calendar.DAY_OF_WEEK, 4);
				Cal.get(6).set(Calendar.HOUR_OF_DAY, 8);
				Cal.get(6).set(Calendar.MINUTE, 0);
				Cal.get(6).set(Calendar.SECOND, 0);

				Cal.add(7, Calendar.getInstance());
				Cal.get(7).set(Calendar.DAY_OF_WEEK, 2);
				Cal.get(7).set(Calendar.HOUR_OF_DAY, 10);
				Cal.get(7).set(Calendar.MINUTE, 0);
				Cal.get(7).set(Calendar.SECOND, 0);
				
				Cal.add(8, Calendar.getInstance());
				Cal.get(8).set(Calendar.DAY_OF_WEEK, 5);
				Cal.get(8).set(Calendar.HOUR_OF_DAY, 11);
				Cal.get(8).set(Calendar.MINUTE, 0);
				Cal.get(8).set(Calendar.SECOND, 0);
				
				//TC1
				Cal.add(9, Calendar.getInstance());
				Cal.get(9).set(Calendar.DAY_OF_WEEK, 6);
				Cal.get(9).set(Calendar.HOUR_OF_DAY, 12);
				Cal.get(9).set(Calendar.MINUTE, 0);
				Cal.get(9).set(Calendar.SECOND, 0);
				
				//Set Calendar for D1 Slot
				

				Cal.add(10, Calendar.getInstance());
				Cal.get(10).set(Calendar.DAY_OF_WEEK, 5);
				Cal.get(10).set(Calendar.HOUR_OF_DAY, 8);
				Cal.get(10).set(Calendar.MINUTE, 0);
				Cal.get(10).set(Calendar.SECOND, 0);
				
				Cal.add(11, Calendar.getInstance());
				Cal.get(11).set(Calendar.DAY_OF_WEEK, 3);
				Cal.get(11).set(Calendar.HOUR_OF_DAY, 10);
				Cal.get(11).set(Calendar.MINUTE, 0);
				Cal.get(11).set(Calendar.SECOND, 0);
				
				
				Cal.add(12, Calendar.getInstance());
				Cal.get(12).set(Calendar.DAY_OF_WEEK, 6);
				Cal.get(12).set(Calendar.HOUR_OF_DAY, 11);
				Cal.get(12).set(Calendar.MINUTE, 0);
				Cal.get(12).set(Calendar.SECOND, 0);
				
				
				//TD1
				Cal.add(13, Calendar.getInstance());
				Cal.get(13).set(Calendar.DAY_OF_WEEK, 2);
				Cal.get(13).set(Calendar.HOUR_OF_DAY, 12);
				Cal.get(13).set(Calendar.MINUTE, 0);
				Cal.get(13).set(Calendar.SECOND, 0);
				
				//Set Calendar for E1 Slot
				
				Cal.add(14, Calendar.getInstance());
				Cal.get(14).set(Calendar.DAY_OF_WEEK, 6);
				Cal.get(14).set(Calendar.HOUR_OF_DAY, 8);
				Cal.get(14).set(Calendar.MINUTE, 0);
				Cal.get(14).set(Calendar.SECOND, 0);
				
				
				Cal.add(15, Calendar.getInstance());
				Cal.get(15).set(Calendar.DAY_OF_WEEK, 4);
				Cal.get(15).set(Calendar.HOUR_OF_DAY, 10);
				Cal.get(15).set(Calendar.MINUTE, 0);
				Cal.get(15).set(Calendar.SECOND, 0);

				Cal.add(16, Calendar.getInstance());
				Cal.get(16).set(Calendar.DAY_OF_WEEK, 2);
				Cal.get(16).set(Calendar.HOUR_OF_DAY, 11);
				Cal.get(16).set(Calendar.MINUTE, 0);
				Cal.get(16).set(Calendar.SECOND, 0);
				
				
				//TE1
				Cal.add(17, Calendar.getInstance());
				Cal.get(17).set(Calendar.DAY_OF_WEEK, 5);
				Cal.get(17).set(Calendar.HOUR_OF_DAY, 12);
				Cal.get(17).set(Calendar.MINUTE, 0);
				Cal.get(17).set(Calendar.SECOND, 0);
				
				//Set Calendar for F1 Slot
				
				
				Cal.add(18, Calendar.getInstance());
				Cal.get(18).set(Calendar.DAY_OF_WEEK, 2);
				Cal.get(18).set(Calendar.HOUR_OF_DAY, 9);
				Cal.get(18).set(Calendar.MINUTE, 0);
				Cal.get(18).set(Calendar.SECOND, 0);

				Cal.add(19, Calendar.getInstance());
				Cal.get(19).set(Calendar.DAY_OF_WEEK, 4);
				Cal.get(19).set(Calendar.HOUR_OF_DAY, 9);
				Cal.get(19).set(Calendar.MINUTE, 0);
				Cal.get(19).set(Calendar.SECOND, 0);
				
				Cal.add(20, Calendar.getInstance());
				Cal.get(20).set(Calendar.DAY_OF_WEEK, 5);
				Cal.get(20).set(Calendar.HOUR_OF_DAY, 10);
				Cal.get(20).set(Calendar.MINUTE, 0);
				Cal.get(20).set(Calendar.SECOND, 0);
				
				//TF1
				Cal.add(21, Calendar.getInstance());
				Cal.get(21).set(Calendar.DAY_OF_WEEK, 3);
				Cal.get(21).set(Calendar.HOUR_OF_DAY, 12);
				Cal.get(21).set(Calendar.MINUTE, 0);
				Cal.get(21).set(Calendar.SECOND, 0);
				
				//Set Calendar for G1 Slot
				
				Cal.add(22, Calendar.getInstance());
				Cal.get(22).set(Calendar.DAY_OF_WEEK, 3);
				Cal.get(22).set(Calendar.HOUR_OF_DAY, 9);
				Cal.get(22).set(Calendar.MINUTE, 0);
				Cal.get(22).set(Calendar.SECOND, 0);
				
				Cal.add(23, Calendar.getInstance());
				Cal.get(23).set(Calendar.DAY_OF_WEEK, 6);
				Cal.get(23).set(Calendar.HOUR_OF_DAY, 10);
				Cal.get(23).set(Calendar.MINUTE, 0);
				Cal.get(23).set(Calendar.SECOND, 0);
				
				Cal.add(24, Calendar.getInstance());
				Cal.get(24).set(Calendar.DAY_OF_WEEK, 4);
				Cal.get(24).set(Calendar.HOUR_OF_DAY, 12);
				Cal.get(24).set(Calendar.MINUTE, 0);
				Cal.get(24).set(Calendar.SECOND, 0);
				

		
		//Intents
        Intent setVibration = new Intent();
        setVibration.setClass(getActivity(), AlarmReciever.class);
        
        Intent setNormal = new Intent();
        setNormal.setClass(getActivity(), RingerMode.class);
       //NEW 
      //PENDING INTENTS
        ArrayList <PendingIntent> M_V= new ArrayList <PendingIntent>(25);
        ArrayList <PendingIntent> M_N= new ArrayList <PendingIntent>(25);
        
        for(int i=0; i<25; i++)
        {
        	M_V.add(PendingIntent.getBroadcast(getActivity(), i, setVibration,
        			PendingIntent.FLAG_UPDATE_CURRENT));
        	M_N.add(PendingIntent.getBroadcast(getActivity(), i, setNormal,
        			PendingIntent.FLAG_UPDATE_CURRENT));
        }

         
        // create the object
        AlarmManager mAlarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        
        //a1
        if(l.get(0).isChecked()){
        	
        	//NEW
        	for(int i=0; i<=1; i++)
            {
           			
    				
    				 mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis(), 7*24*60*60*1000, M_V.get(i));
    		         mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(i));
    		        
    		         Toast.makeText(getActivity(), "A1", Toast.LENGTH_SHORT).show();
                	
            }
    
            
          }
        
        //b1
        if(l.get(1).isChecked()){
        	
        	//NEW
        	for(int i=3; i<=4; i++)
            {
           			
    				
    				 mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis(), 7*24*60*60*1000, M_V.get(i));
    		         mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(i));
    		        
    		         //Toast.makeText(this, "L"+(i+1), Toast.LENGTH_SHORT).show();
                
            }

            
            }
        //c1
        if(l.get(2).isChecked()){
        	
        	//NEW
        	for(int i=6; i<=8; i++)
            {
           			
    				
    				 mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis(), 7*24*60*60*1000, M_V.get(i));
    		         mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(i));
    		        
    		         //Toast.makeText(this, "L"+(i+1), Toast.LENGTH_SHORT).show();
                	
            }
         
            }
        //d1
        if(l.get(3).isChecked()){
        	
        	//NEW
        	for(int i=10; i<=12; i++)
            {
           			
    				
    				 mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis(), 7*24*60*60*1000, M_V.get(i));
    		         mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(i));
    		        
    		         //Toast.makeText(this, "L"+(i+1), Toast.LENGTH_SHORT).show();
                	
            }

            }
        //e1
        if(l.get(4).isChecked()){
        	
        	///NEW
        	for(int i=14; i<=16; i++)
            {
           		
    				
    				 mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis(), 7*24*60*60*1000, M_V.get(i));
    		         mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(i));
    		        
    		         //Toast.makeText(this, "L"+(i+1), Toast.LENGTH_SHORT).show();
              
            }
       
            }
        //f1
        if(l.get(5).isChecked()){
        	
        	///NEW
        	for(int i=18; i<=20; i++)
            {
           			
    				
    				 mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis(), 7*24*60*60*1000, M_V.get(i));
    		         mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(i));
    		        
    		         //Toast.makeText(this, "L"+(i+1), Toast.LENGTH_SHORT).show();
                	
            }
     
            }
        //g1
        if(l.get(6).isChecked()){
        	
        	//NEW
        	for(int i=22; i<=23; i++)
            {
           			
    				
    				 mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis(), 7*24*60*60*1000, M_V.get(i));
    		         mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(i));
    		        
    		         //Toast.makeText(this, "L"+(i+1), Toast.LENGTH_SHORT).show();
                	
            }
      
            }
        
        
      //ta1
    	   if(l.get(7).isChecked()){
    	   
    	  //NEW
    	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(2).getTimeInMillis(), 7*24*60*60*1000, M_V.get(2));
	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(2).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(2));
  
          }
    	   
    	   //tb1
        
        	if(l.get(8).isChecked()){
            
        	//NEW
      	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(5).getTimeInMillis(), 7*24*60*60*1000, M_V.get(5));
  	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(5).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(5));
  	    
          }
        
        	//tc1
        	if(l.get(9).isChecked()){
        	//NEW
      	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(9).getTimeInMillis(), 7*24*60*60*1000, M_V.get(9));
  	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(9).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(9));
  	   
        }
       
        	
        	//td1
        	if(l.get(10).isChecked()){
        	//NEW
      	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(13).getTimeInMillis(), 7*24*60*60*1000, M_V.get(13));
  	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(13).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(13));
  	   
        }
        
        	//te1
        	if(l.get(11).isChecked()){
        	//NEW
      	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(17).getTimeInMillis(), 7*24*60*60*1000, M_V.get(17));
  	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(17).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(17));
  	    
        }
        
        	//tf1
        	if(l.get(12).isChecked()){
        	//NEW
      	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(21).getTimeInMillis(), 7*24*60*60*1000, M_V.get(21));
  	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(21).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(21));
  	
        }
       
        	//tg1
        	if(l.get(13).isChecked()){
        	//NEW
      	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(24).getTimeInMillis(), 7*24*60*60*1000, M_V.get(24));
  	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(24).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(24));
  	     
        }
 
     
        //!a1
        if(!l.get(0).isChecked()){
        	
        	for(int i=0; i<2; i++)
        	{
        		PendingIntent.getBroadcast(getActivity(), i, setVibration,
        	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	        	
        	        	
        	        	
        	        	PendingIntent.getBroadcast(getActivity(), i, setNormal,
        	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	                	
        	                	
        	}
        	
        	   }
        
        //!b1
          if(!l.get(1).isChecked()){
        	  
        	  for(int i=3; i<5; i++)
          	{
          		PendingIntent.getBroadcast(getActivity(), i, setVibration,
          	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	        	
          	        	
          	        	
          	        	PendingIntent.getBroadcast(getActivity(), i, setNormal,
          	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	                	
          	                	
          	}
        	
        
          }

          //!c1
          if(!l.get(2).isChecked()){
        	  
        	  for(int i=6; i<9; i++)
          	{
          		PendingIntent.getBroadcast(getActivity(), i, setVibration,
          	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	        	
          	        	
          	        	
          	        	PendingIntent.getBroadcast(getActivity(), i, setNormal,
          	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	                	
          	                	
          	}
        	 
         }

          //!d1
          if(!l.get(3).isChecked()){
        	  
        	  for(int i=10; i<13; i++)
          	{
          		PendingIntent.getBroadcast(getActivity(), i, setVibration,
          	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	        	
          	        	
          	        	PendingIntent.getBroadcast(getActivity(), i, setNormal,
          	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	                	
          	                	
          	}
        	 
          }

          //!e1
          if(!l.get(4).isChecked()){
        	  
        	  for(int i=14; i<17; i++)
          	{
          		PendingIntent.getBroadcast(getActivity(), i, setVibration,
          	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	        
          	        	
          	        	PendingIntent.getBroadcast(getActivity(), i, setNormal,
          	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	                	
          	                	
          	}
        	 
          }

          
          //!f1
          if(!l.get(5).isChecked()){
        	  
        	  for(int i=18; i<21; i++)
          	{
          		PendingIntent.getBroadcast(getActivity(), i, setVibration,
          	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	        	
          	        	
          	        	
          	        	PendingIntent.getBroadcast(getActivity(), i, setNormal,
          	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	                	
          	                	
          	}
        	 
          }

          
          //!g1
          if(!l.get(6).isChecked()){
        	  
        	  for(int i=22; i<24; i++)
          	{
          		PendingIntent.getBroadcast(getActivity(), i, setVibration,
          	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	        	
          	        	
          	        	
          	        	PendingIntent.getBroadcast(getActivity(), i, setNormal,
          	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	                	
          	}
        	 
          }
          
          //!ta1
          if(!l.get(7).isChecked()){
        	  
        	
           	//Close vibration p.i	
          	PendingIntent.getBroadcast(getActivity(), 2, setVibration,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	
          	//Close normal p.i
          	PendingIntent.getBroadcast(getActivity(), 2, setNormal,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	
          	          }
          
          //!tb1
          if(!l.get(8).isChecked()){
        	  
        	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(getActivity(), 5, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(getActivity(), 5, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          
          //!tc1
          if(!l.get(9).isChecked()){
        	  
        	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(getActivity(), 9, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(getActivity(), 9, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          
          //!td1
          if(!l.get(10).isChecked()){
        	  
        	 
            	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(getActivity(), 13, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(getActivity(), 13, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          
          //!te1
          if(!l.get(11).isChecked()){
        	  
        	 
            	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(getActivity(), 17, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(getActivity(), 17, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          
          //!tf1
          if(!l.get(12).isChecked()){
        	  
        	 
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(getActivity(), 21, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(getActivity(), 21, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          
          //!tg1
          if(!l.get(13).isChecked()){
        	  
        	  
            	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(getActivity(), 24, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(getActivity(), 24, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          
          Toast.makeText(getActivity(), "SUBMITTED", Toast.LENGTH_LONG).show();
		   
        
      
        
        }




	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		Log.d("onClick 2", "inside onclick 2");
		Toast.makeText(getActivity(), "on click 2", Toast.LENGTH_SHORT).show();
		 for(int i = 0; i < 14 ; i++){

		        if(l.get(i).isChecked()){
		            mPrefsEditor_m.putBoolean("morning"+i, true);
		            mPrefsEditor_m.apply();
		        }
		        else {
		            mPrefsEditor_m.putBoolean("morning"+i, false);
		            mPrefsEditor_m.apply();
		        }
		
	}
		 getdata(arg0);
	
	}
}


 
 