package ishan.khandelwal.vitsilentmode;

import java.util.ArrayList;
import java.util.Calendar;
//import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent; 
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
//import android.widget.Toast;
//import android.widget.Toast;

public class Labs extends FragmentActivity implements OnClickListener {
	
	private ArrayList <Calendar> Cal= new ArrayList <Calendar>(60);
	
	private ArrayList <CheckBox> l= new ArrayList <CheckBox>(60);
	
	private ArrayList <Boolean> checkboxValue_lab = new ArrayList <Boolean>(60);
	
	private SharedPreferences mSharedPreferences_l;
    private SharedPreferences.Editor mPrefsEditor_l;
    private Button submitButton;
    
    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_labs);
		addenable();
		
		
		submitButton = (Button)findViewById(R.id.button1);
        submitButton.setOnClickListener(this);
        
        mSharedPreferences_l = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        mPrefsEditor_l = mSharedPreferences_l.edit();
        
        
       
		
		//Initialise check boxes for every slot
		for (int i = 101; i <= 160; i++) {
			   String viewId = "checkBox" + i;
			   l.add(i-101, (CheckBox) findViewById(getResources().getIdentifier(viewId, "id", getPackageName())));
			   checkboxValue_lab.add(i-101, mSharedPreferences_l.getBoolean("lab"+(i-101), false));
			   
			   if (checkboxValue_lab.get(i-101) == true) {
		           l.get(i-101).setChecked(true);}
		       }
			}	
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}	
	
	public void addenable(){
		
	}
	
	public int Day(int a)
	{
		int d=0;
		int x = a;
		x--;
		
		if(x>=30)
			d = (x/6)-3;
		
		else
			d=(x/6)+2;
		
		return d;
	}
	
	public int Hour(int a)
	{
		int hr=0;
		int x=a;
		
		x--;
		
		hr=(x%6)+8;
		
		if((x%6)>=4)
			hr--;
		
		if(x>=30)
			hr = hr+6;
		
		return hr;
		
	}
	
	public int Min(int a)
	{
		int m=0;
		int x=a;
		
		if(x%6==5)
			m=50;
		
		if(x%6==0)
			m=40;
		
		return m;
	}
	
	public void getdata(View V){
		
		for( int i=0; i<60; i++)
		{
			Cal.add(i, Calendar.getInstance());
			Cal.get(i).set(Calendar.DAY_OF_WEEK, Day(i+1));
			Cal.get(i).set(Calendar.HOUR_OF_DAY, Hour(i+1));
			Cal.get(i).set(Calendar.MINUTE, Min(i+1));
			Cal.get(i).set(Calendar.SECOND, 0);
		}
		
				
		//Intents
        Intent setVibration = new Intent();
        setVibration.setClass(this, AlarmReciever.class);
        
        Intent setNormal = new Intent();
        setNormal.setClass(this, RingerMode.class);
     
        //PENDING INTENTS
        ArrayList <PendingIntent> Lab_V= new ArrayList <PendingIntent>(60);
        ArrayList <PendingIntent> Lab_N= new ArrayList <PendingIntent>(60);
        
        for(int i=0; i<60; i++)
        {
        	Lab_V.add(PendingIntent.getBroadcast(this, i, setVibration,
        			PendingIntent.FLAG_UPDATE_CURRENT));
        	Lab_N.add(PendingIntent.getBroadcast(this, i, setNormal,
        			PendingIntent.FLAG_UPDATE_CURRENT));
        }
 
        // create the object
        AlarmManager mAlarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        
        for(int i=0; i<60; i++)
        {
       			if(l.get(i).isChecked()){
				
				 mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis(), 7*24*60*60*1000, Lab_V.get(i));
		         mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis()+50*60*1000, 7*24*60*60*1000, Lab_N.get(i));
		        
		         //Toast.makeText(this, "L"+(i+1), Toast.LENGTH_SHORT).show();
            	}
        }
                                   
        }

	
	public void onClick(View view) {
	  
	    for(int i = 0; i < 60 ; i++){

	        if(l.get(i).isChecked()){
	            mPrefsEditor_l.putBoolean("lab"+i, true);
	            mPrefsEditor_l.commit();
	        }
	        else {
	            mPrefsEditor_l.putBoolean("lab"+i, false);
	            mPrefsEditor_l.commit();
	        }
	    }

	    getdata(view);
	   
	}
	}
	


