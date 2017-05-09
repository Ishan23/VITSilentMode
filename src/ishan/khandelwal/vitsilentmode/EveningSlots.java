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

public class EveningSlots extends FragmentActivity implements OnClickListener {

	//Initialise Calendars
	/*Format:mCn
	  m:slot alphabet
	  n:class no. of the slot*/
	
	//Calendars for A2
	private Calendar a2C1;
	private Calendar a2C2;
	private Calendar a2Ct;
	
	//Calendars for B2
	private Calendar b2C1;
	private Calendar b2C2;
	private Calendar b2Ct;
		
	//Calendars for C2
	private Calendar c2C1;
	private Calendar c2C2;
	private Calendar c2C3;
	private Calendar c2Ct;
		
	//Calendars for D2
	private Calendar d2C1;
	private Calendar d2C2;
	private Calendar d2C3;
	private Calendar d2Ct;
		
	//Calendars for E2
	private Calendar e2C1;
	private Calendar e2C2;
	private Calendar e2C3;
	private Calendar e2Ct;
		
	//Calendars for F2
	private Calendar f2C1;
	private Calendar f2C2;
	private Calendar f2C3;
	private Calendar f2Ct;
		
	//Calendars for G2
	private Calendar g2C1;
	private Calendar g2C2;
	private Calendar g2Ct;
	
	//Initialise check boxes for every slot
	private CheckBox a2;
	private CheckBox b2;
	private CheckBox c2;
	private CheckBox d2;
	private CheckBox e2;
	private CheckBox f2;
	private CheckBox g2;
	private CheckBox ta2;
	private CheckBox tb2;
	private CheckBox tc2;
	private CheckBox td2;
	private CheckBox te2;
	private CheckBox tf2;
	private CheckBox tg2;
	
	
	private ArrayList <Boolean> checkBoxVale_e = new ArrayList <Boolean>(60);
	private SharedPreferences mSharedPreferences_e;
    private SharedPreferences.Editor mPrefsEditor_e;
    private Button submitButton_e;    
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eslots);
		addenable();
		
	  
		a2 = (CheckBox)findViewById(R.id.checkBox15);
		b2 = (CheckBox)findViewById(R.id.checkBox16);
		c2 = (CheckBox)findViewById(R.id.checkBox17);
		d2 = (CheckBox)findViewById(R.id.checkBox18);
		e2 = (CheckBox)findViewById(R.id.checkBox19);
		f2 = (CheckBox)findViewById(R.id.checkBox20);
		g2 = (CheckBox)findViewById(R.id.checkBox21);
		ta2 = (CheckBox)findViewById(R.id.checkBox22);
		tb2 = (CheckBox)findViewById(R.id.checkBox23);
		tc2 = (CheckBox)findViewById(R.id.checkBox24);
		td2 = (CheckBox)findViewById(R.id.checkBox25);
		te2 = (CheckBox)findViewById(R.id.checkBox26);
		tf2 = (CheckBox)findViewById(R.id.checkBox27);
		tg2 = (CheckBox)findViewById(R.id.checkBox28);
		
		
		submitButton_e = (Button)findViewById(R.id.button1);
        submitButton_e.setOnClickListener(this);
        
        mSharedPreferences_e = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        mPrefsEditor_e = mSharedPreferences_e.edit();
        
        
        for (int i=0; i <14; i++) {
			   
			   checkBoxVale_e.add(i, mSharedPreferences_e.getBoolean("evening"+i, false));			   
			   			}	
		
		if (checkBoxVale_e.get(0) == true) {
	           a2.setChecked(true);
	       }
		if (checkBoxVale_e.get(1) == true) {
	           b2.setChecked(true);
	       }
		if (checkBoxVale_e.get(2) == true) {
	           c2.setChecked(true);
	       }
		if (checkBoxVale_e.get(3) == true) {
	           d2.setChecked(true);
	       }
		if (checkBoxVale_e.get(4) == true) {
	           e2.setChecked(true);
	       }
		if (checkBoxVale_e.get(5) == true) {
	           f2.setChecked(true);
	       }
		if (checkBoxVale_e.get(6) == true) {
	           g2.setChecked(true);
	       }
		if (checkBoxVale_e.get(7) == true) {
	           ta2.setChecked(true);
	       }
		if (checkBoxVale_e.get(8) == true) {
	           tb2.setChecked(true);
	       }
		if (checkBoxVale_e.get(9) == true) {
	           tc2.setChecked(true);
	       }
		if (checkBoxVale_e.get(10) == true) {
	           td2.setChecked(true);
	       }
		if (checkBoxVale_e.get(11) == true) {
	           te2.setChecked(true);
	       }
		if (checkBoxVale_e.get(12) == true) {
	           tf2.setChecked(true);
	       }
		if (checkBoxVale_e.get(13) == true) {
	           tg2.setChecked(true);
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
	public void getdata(View V){
		
		//Set Calendar for A2 Slot
		a2C1= Calendar.getInstance();
		a2C1.set(Calendar.DAY_OF_WEEK, 2);
		a2C1.set(Calendar.HOUR_OF_DAY, 14);
		a2C1.set(Calendar.MINUTE, 0);
		a2C1.set(Calendar.SECOND, 0);
		
		a2C2= Calendar.getInstance();
		a2C2.set(Calendar.DAY_OF_WEEK, 5);
		a2C2.set(Calendar.HOUR_OF_DAY, 15);
		a2C2.set(Calendar.MINUTE, 0);
		a2C2.set(Calendar.SECOND, 0);
		
		a2Ct= Calendar.getInstance();
		a2Ct.set(Calendar.DAY_OF_WEEK, 3);
		a2Ct.set(Calendar.HOUR_OF_DAY, 17);
		a2Ct.set(Calendar.MINUTE, 0);
		a2Ct.set(Calendar.SECOND, 0);
		
		//Set Calendar for B2 Slot
		b2C1= Calendar.getInstance();
		b2C1.set(Calendar.DAY_OF_WEEK, 3);
		b2C1.set(Calendar.HOUR_OF_DAY, 14);
		b2C1.set(Calendar.MINUTE, 0);
		b2C1.set(Calendar.SECOND, 0);
				
		b2C2= Calendar.getInstance();
		b2C2.set(Calendar.DAY_OF_WEEK, 6);
		b2C2.set(Calendar.HOUR_OF_DAY, 15);
		b2C2.set(Calendar.MINUTE, 0);
		b2C2.set(Calendar.SECOND, 0);
		
		b2Ct= Calendar.getInstance();
		b2Ct.set(Calendar.DAY_OF_WEEK, 4);
		b2Ct.set(Calendar.HOUR_OF_DAY, 17);
		b2Ct.set(Calendar.MINUTE, 0);
		b2Ct.set(Calendar.SECOND, 0);
				
		//Set Calendar for C2 Slot
		c2C1= Calendar.getInstance();
		c2C1.set(Calendar.DAY_OF_WEEK, 4);
		c2C1.set(Calendar.HOUR_OF_DAY, 14);
		c2C1.set(Calendar.MINUTE, 0);
		c2C1.set(Calendar.SECOND, 0);
				
		c2C2= Calendar.getInstance();
		c2C2.set(Calendar.DAY_OF_WEEK, 2);
		c2C2.set(Calendar.HOUR_OF_DAY, 16);
		c2C2.set(Calendar.MINUTE, 0);
		c2C2.set(Calendar.SECOND, 0);
		
		c2C3= Calendar.getInstance();
		c2C3.set(Calendar.DAY_OF_WEEK, 5);
		c2C3.set(Calendar.HOUR_OF_DAY, 17);
		c2C3.set(Calendar.MINUTE, 0);
		c2C3.set(Calendar.SECOND, 0);
		
		c2Ct= Calendar.getInstance();
		c2Ct.set(Calendar.DAY_OF_WEEK, 6);
		c2Ct.set(Calendar.HOUR_OF_DAY, 18);
		c2Ct.set(Calendar.MINUTE, 0);
		c2Ct.set(Calendar.SECOND, 0);
				
		//Set Calendar for D2 Slot
		d2C1= Calendar.getInstance();
		d2C1.set(Calendar.DAY_OF_WEEK, 5);
		d2C1.set(Calendar.HOUR_OF_DAY, 14);
		d2C1.set(Calendar.MINUTE, 0);
		d2C1.set(Calendar.SECOND, 0);
				
		d2C2= Calendar.getInstance();
		d2C2.set(Calendar.DAY_OF_WEEK, 3);
		d2C2.set(Calendar.HOUR_OF_DAY, 16);
		d2C2.set(Calendar.MINUTE, 0);
		d2C2.set(Calendar.SECOND, 0);
		
		d2C3= Calendar.getInstance();
		d2C3.set(Calendar.DAY_OF_WEEK, 6);
		d2C3.set(Calendar.HOUR_OF_DAY, 17);
		d2C3.set(Calendar.MINUTE, 18);
		d2C3.set(Calendar.SECOND, 0);
		
		d2Ct= Calendar.getInstance();
		d2Ct.set(Calendar.DAY_OF_WEEK, 2);
		d2Ct.set(Calendar.HOUR_OF_DAY, 18);
		d2Ct.set(Calendar.MINUTE, 0);
		d2Ct.set(Calendar.SECOND, 0);
				
		//Set Calendar for E2 Slot
		e2C1= Calendar.getInstance();
		e2C1.set(Calendar.DAY_OF_WEEK, 6);
		e2C1.set(Calendar.HOUR_OF_DAY, 14);
		e2C1.set(Calendar.MINUTE, 0);
		e2C1.set(Calendar.SECOND, 0);
				
		e2C2= Calendar.getInstance();
		e2C2.set(Calendar.DAY_OF_WEEK, 4);
		e2C2.set(Calendar.HOUR_OF_DAY, 16);
		e2C2.set(Calendar.MINUTE, 0);
		e2C2.set(Calendar.SECOND, 0);
		
		e2C3= Calendar.getInstance();
		e2C3.set(Calendar.DAY_OF_WEEK, 2);
		e2C3.set(Calendar.HOUR_OF_DAY, 17);
		e2C3.set(Calendar.MINUTE, 0);
		e2C3.set(Calendar.SECOND, 0);
		
		e2Ct= Calendar.getInstance();
		e2Ct.set(Calendar.DAY_OF_WEEK, 5);
		e2Ct.set(Calendar.HOUR_OF_DAY, 18);
		e2Ct.set(Calendar.MINUTE, 0);
		e2Ct.set(Calendar.SECOND, 0);
				
		//Set Calendar for F2 Slot
		f2C1= Calendar.getInstance();
		f2C1.set(Calendar.DAY_OF_WEEK, 2);
		f2C1.set(Calendar.HOUR_OF_DAY, 15);
		f2C1.set(Calendar.MINUTE, 0);
		f2C1.set(Calendar.SECOND, 0);
				
		f2C2= Calendar.getInstance();
		f2C2.set(Calendar.DAY_OF_WEEK, 4);
		f2C2.set(Calendar.HOUR_OF_DAY, 15);
		f2C2.set(Calendar.MINUTE, 0);
		f2C2.set(Calendar.SECOND, 0);
		
		f2C3= Calendar.getInstance();
		f2C3.set(Calendar.DAY_OF_WEEK, 5);
		f2C3.set(Calendar.HOUR_OF_DAY, 16);
		f2C3.set(Calendar.MINUTE, 0);
		f2C3.set(Calendar.SECOND, 0);
		
		f2Ct= Calendar.getInstance();
		f2Ct.set(Calendar.DAY_OF_WEEK, 3);
		f2Ct.set(Calendar.HOUR_OF_DAY, 18);
		f2Ct.set(Calendar.MINUTE, 0);
		f2Ct.set(Calendar.SECOND, 0);
				
		//Set Calendar for G2 Slot
		g2C1= Calendar.getInstance();
		g2C1.set(Calendar.DAY_OF_WEEK, 3);
		g2C1.set(Calendar.HOUR_OF_DAY, 15);
		g2C1.set(Calendar.MINUTE, 0);
		g2C1.set(Calendar.SECOND, 0);
				
		g2C2= Calendar.getInstance();
		g2C2.set(Calendar.DAY_OF_WEEK, 6);
		g2C2.set(Calendar.HOUR_OF_DAY, 16);
		g2C2.set(Calendar.MINUTE, 0);
		g2C2.set(Calendar.SECOND, 0);
		
		g2Ct= Calendar.getInstance();
		g2Ct.set(Calendar.DAY_OF_WEEK, 4);
		g2Ct.set(Calendar.HOUR_OF_DAY, 18);
		g2Ct.set(Calendar.MINUTE, 0);
		g2Ct.set(Calendar.SECOND, 0);
		
		
		//Intents
        Intent setVibration = new Intent();
        setVibration.setClass(this, AlarmReciever.class);
        
        Intent setNormal = new Intent();
        setNormal.setClass(this, RingerMode.class);
        
        
        //PENDING INTENTS
        /*p2(V/N)q
        ID key:2pqr
        p:slot no.
        q:class no.
        r:vibration/normal (0/1) */
        
        //Pending intents for A2 slot
       
        PendingIntent a2V1 = PendingIntent.getBroadcast(this, 2110, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent a2V2 = PendingIntent.getBroadcast(this, 2120, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent a2Vt = PendingIntent.getBroadcast(this, 2140, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent a2N1 = PendingIntent.getBroadcast(this, 2111, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent a2N2 = PendingIntent.getBroadcast(this, 2121, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent a2Nt = PendingIntent.getBroadcast(this, 2141, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        
        //Pending intents for B2 slot
        
        PendingIntent b2V1 = PendingIntent.getBroadcast(this, 2210, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent b2V2 = PendingIntent.getBroadcast(this, 2220, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent b2Vt = PendingIntent.getBroadcast(this, 2240, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent b2N1 = PendingIntent.getBroadcast(this, 2211, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent b2N2 = PendingIntent.getBroadcast(this, 2221, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent b2Nt = PendingIntent.getBroadcast(this, 2241, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        //Pending intents for C2 slot
        
        PendingIntent c2V1 = PendingIntent.getBroadcast(this, 2310, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent c2V2 = PendingIntent.getBroadcast(this, 2320, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent c2V3 = PendingIntent.getBroadcast(this, 2330, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent c2Vt = PendingIntent.getBroadcast(this, 2340, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent c2N1 = PendingIntent.getBroadcast(this, 2311, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent c2N2 = PendingIntent.getBroadcast(this, 2321, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent c2N3 = PendingIntent.getBroadcast(this, 2331, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent c2Nt = PendingIntent.getBroadcast(this, 2341, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        //Pending intents for D2 slot
        
        PendingIntent d2V1 = PendingIntent.getBroadcast(this, 2410, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent d2V2 = PendingIntent.getBroadcast(this, 2420, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent d2V3 = PendingIntent.getBroadcast(this, 2430, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent d2Vt = PendingIntent.getBroadcast(this, 2440, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
       
        PendingIntent d2N1 = PendingIntent.getBroadcast(this, 2411, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent d2N2 = PendingIntent.getBroadcast(this, 2421, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent d2N3 = PendingIntent.getBroadcast(this, 2431, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent d2Nt = PendingIntent.getBroadcast(this, 2441, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        //Pending intents for E2 slot
        
        PendingIntent e2V1 = PendingIntent.getBroadcast(this, 2510, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent e2V2 = PendingIntent.getBroadcast(this, 2520, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent e2V3 = PendingIntent.getBroadcast(this, 2530, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent e2Vt = PendingIntent.getBroadcast(this, 2540, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent e2N1 = PendingIntent.getBroadcast(this, 2511, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent e2N2 = PendingIntent.getBroadcast(this, 2521, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent e2N3 = PendingIntent.getBroadcast(this, 2531, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent e2Nt = PendingIntent.getBroadcast(this, 2541, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        //Pending intents for F2 slot
        
        PendingIntent f2V1 = PendingIntent.getBroadcast(this, 2610, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent f2V2 = PendingIntent.getBroadcast(this, 2620, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent f2V3 = PendingIntent.getBroadcast(this, 2630, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent f2Vt = PendingIntent.getBroadcast(this, 2640, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent f2N1 = PendingIntent.getBroadcast(this, 2611, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent f2N2 = PendingIntent.getBroadcast(this, 2621, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent f2N3 = PendingIntent.getBroadcast(this, 2631, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent f2Nt = PendingIntent.getBroadcast(this, 2641, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        
        //Pending intents for G2 slot
        
        PendingIntent g2V1 = PendingIntent.getBroadcast(this, 2710, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent g2V2 = PendingIntent.getBroadcast(this, 2720, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent g2Vt = PendingIntent.getBroadcast(this, 2740, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent g2N1 = PendingIntent.getBroadcast(this, 2711, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent g2N2 = PendingIntent.getBroadcast(this, 2721, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent g2Nt = PendingIntent.getBroadcast(this, 2741, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
       
         
        // create the object
        AlarmManager mAlarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        
        if(a2.isChecked()){
        
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, a2C1.getTimeInMillis(), 7*24*60*60*1000, a2V1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, a2C1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, a2N1);
        
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, a2C2.getTimeInMillis(), 7*24*60*60*1000, a2V2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, a2C2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, a2N2);
      
        
            //Toast.makeText(this, "A2", Toast.LENGTH_SHORT).show();
          }
        
        if(b2.isChecked()){
            
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, b2C1.getTimeInMillis(), 7*24*60*60*1000, b2V1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, b2C1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, b2N1);
            
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, b2C2.getTimeInMillis(), 7*24*60*60*1000, b2V2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, b2C2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, b2N2);
          
            
             //Toast.makeText(this, "B2", Toast.LENGTH_SHORT).show();
            }
        
        if(c2.isChecked()){
            
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c2C1.getTimeInMillis(), 7*24*60*60*1000, c2V1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c2C1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, c2N1);
            
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c2C2.getTimeInMillis(), 7*24*60*60*1000, c2V2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c2C2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, c2N2);
            
            //Class no. 3
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c2C3.getTimeInMillis(), 7*24*60*60*1000, c2V3);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c2C3.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, c2N3);
          
          
            
             //Toast.makeText(this, "C2", Toast.LENGTH_SHORT).show();
            }
        
        if(d2.isChecked()){
            
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, d2C1.getTimeInMillis(), 7*24*60*60*1000, d2V1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, d2C1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, d2N1);
            
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, d2C2.getTimeInMillis(), 7*24*60*60*1000, d2V2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, d2C2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, d2N2);
          
            //Class no. 3
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, d2C3.getTimeInMillis(), 7*24*60*60*1000, d2V3);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, d2C3.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, d2N3);
           
             //Toast.makeText(this, "D2", Toast.LENGTH_SHORT).show();
            }
        
        if(e2.isChecked()){
            
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, e2C1.getTimeInMillis(), 7*24*60*60*1000, e2V1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, e2C1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, e2N1);
            
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, e2C2.getTimeInMillis(), 7*24*60*60*1000, e2V2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, e2C2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, e2N2);
          
            //Class no. 3
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, e2C3.getTimeInMillis(), 7*24*60*60*1000, e2V3);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, e2C3.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, e2N3);
          
             //Toast.makeText(this, "E2", Toast.LENGTH_SHORT).show();
            }
        
        if(f2.isChecked()){
            
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, f2C1.getTimeInMillis(), 7*24*60*60*1000, f2V1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, f2C1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, f2N1);
            
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, f2C2.getTimeInMillis(), 7*24*60*60*1000, f2V2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, f2C2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, f2N2);
          
            //Class no. 3
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, f2C3.getTimeInMillis(), 7*24*60*60*1000, f2V3);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, f2C3.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, f2N3);
          
             //Toast.makeText(this, "F2", Toast.LENGTH_SHORT).show();
            }
        
        if(g2.isChecked()){
            
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, g2C1.getTimeInMillis(), 7*24*60*60*1000, g2V1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, g2C1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, g2N1);
            
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, g2C2.getTimeInMillis(), 7*24*60*60*1000, g2V2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, g2C2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, g2N2);
          
            
             //Toast.makeText(this, "G2", Toast.LENGTH_SHORT).show();
            }
        
        
       if(ta2.isChecked()){
            
            //Class TA2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, a2Ct.getTimeInMillis(), 7*24*60*60*1000, a2Vt);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, a2Ct.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, a2Nt);
        
            //Toast.makeText(this, "TA2", Toast.LENGTH_SHORT).show();
          }
        if(tb2.isChecked()){
            
            //Class TB2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, b2Ct.getTimeInMillis(), 7*24*60*60*1000, b2Vt);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, b2Ct.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, b2Nt);
        
            //Toast.makeText(this, "TB2", Toast.LENGTH_SHORT).show();
          }
        if(tc2.isChecked()){
     
        	//Class TC2
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c2Ct.getTimeInMillis(), 7*24*60*60*1000, c2Vt);
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c2Ct.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, c2Nt);
 
        	 //Toast.makeText(this, "TC2", Toast.LENGTH_SHORT).show();
        }
        if(td2.isChecked()){
     
        	//Class TD2
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, d2Ct.getTimeInMillis(), 7*24*60*60*1000, d2Vt);
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, d2Ct.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, d2Nt);
 
        	 //Toast.makeText(this, "TD2", Toast.LENGTH_SHORT).show();
        }
        if(te2.isChecked()){
     
        	//Class TE2
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, e2Ct.getTimeInMillis(), 7*24*60*60*1000, e2Vt);
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, e2Ct.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, e2Nt);
 
        	 //Toast.makeText(this, "TE2", Toast.LENGTH_SHORT).show();
        }
        if(tf2.isChecked()){
     
        	//Class TF2
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, f2Ct.getTimeInMillis(), 7*24*60*60*1000, f2Vt);
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, f2Ct.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, f2Nt);
 
        	 //Toast.makeText(this, "TF2", Toast.LENGTH_SHORT).show();
        }
        if(tg2.isChecked()){
     
        	//Class TG2
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, g2Ct.getTimeInMillis(), 7*24*60*60*1000, g2Vt);
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, g2Ct.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, g2Nt);
 
        	 //Toast.makeText(this, "TG2", Toast.LENGTH_SHORT).show(); 
        }
 
     
        
        if(!a2.isChecked()){
        	
        	//Close vibration p.i
        	PendingIntent.getBroadcast(this, 2110, setVibration,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 2120, setVibration,
       		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
       	
        	//Close normal p.i
        	PendingIntent.getBroadcast(this, 2111, setNormal,
    	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 2121, setNormal,
    	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	   }
        
          if(!b2.isChecked()){
        	
        	//Close vibration p.i
        	PendingIntent.getBroadcast(this, 2210, setVibration,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 2220, setVibration,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        
        	//Close normal p.i
        	PendingIntent.getBroadcast(this, 2211, setNormal,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 2221, setNormal,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        
          }

          if(!c2.isChecked()){
	
        	//Close vibration p.i
        	PendingIntent.getBroadcast(this, 2310, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 2320, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 2330, setVibration,
           	PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        
	
        	//Close normal p.i
        	PendingIntent.getBroadcast(this, 2311, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 2321, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 2331, setNormal,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
         }

          if(!d2.isChecked()){
	
            //Close vibration p.i
            PendingIntent.getBroadcast(this, 2410, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
            PendingIntent.getBroadcast(this, 2420, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            
            PendingIntent.getBroadcast(this, 2430, setVibration,
           	PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        
	
            //Close normal p.i
            PendingIntent.getBroadcast(this, 2411, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
            PendingIntent.getBroadcast(this, 2421, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            
            PendingIntent.getBroadcast(this, 2431, setNormal,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
   
          }

          if(!e2.isChecked()){
	
            //Close vibration p.i
        	PendingIntent.getBroadcast(this, 2510, setVibration,
    	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 2520, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 2530, setVibration,
       		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
       
        	//Close normal p.i
        	PendingIntent.getBroadcast(this, 2511, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 2521, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 2531, setNormal,
   	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
      
          }

          if(!f2.isChecked()){
	
        	//Close vibration p.i
        	PendingIntent.getBroadcast(this, 2610, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 2620, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 2630, setVibration,
       		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
      
	
        	//Close normal p.i
        	PendingIntent.getBroadcast(this, 2611, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 2621, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 2631, setNormal,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	

          }

          if(!g2.isChecked()){
	
        	//Close vibration p.i
        	PendingIntent.getBroadcast(this, 2710, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 2720, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
       
	
        	//Close normal p.i
        	PendingIntent.getBroadcast(this, 2711, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 2721, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
       
          }
          
          if(!ta2.isChecked()){
          	
          	//Close vibration p.i	
          	PendingIntent.getBroadcast(this, 2140, setVibration,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	
          	//Close normal p.i
          	PendingIntent.getBroadcast(this, 2141, setNormal,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	
          	          }
          if(!tb2.isChecked()){
            	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(this, 2240, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(this, 2241, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          if(!tc2.isChecked()){
            	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(this, 2340, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(this, 2341, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          if(!td2.isChecked()){
            	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(this, 2440, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(this, 2441, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          if(!te2.isChecked()){
            	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(this, 2540, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(this, 2541, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          if(!tf2.isChecked()){
            	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(this, 2640, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(this, 2641, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          if(!tg2.isChecked()){
            	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(this, 2740, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(this, 2741, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
        
      
        
        }

public void onClick(View view) {
		
		if(a2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+0, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+0, false);
            mPrefsEditor_e.commit();
        }
		if(b2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+1, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+1, false);
            mPrefsEditor_e.commit();
        }
		if(c2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+2, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+2, false);
            mPrefsEditor_e.commit();
        }
		if(d2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+3, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+3, false);
            mPrefsEditor_e.commit();
        }
		if(e2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+4, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+4, false);
            mPrefsEditor_e.commit();
        }
		if(f2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+5, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+5, false);
            mPrefsEditor_e.commit();
        }
		if(g2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+6, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+6, false);
            mPrefsEditor_e.commit();
        }
		if(ta2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+7, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+7, false);
            mPrefsEditor_e.commit();
        }
		if(tb2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+8, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+8, false);
            mPrefsEditor_e.commit();
        }
		if(tc2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+9, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+9, false);
            mPrefsEditor_e.commit();
        }
		if(td2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+10, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+10, false);
            mPrefsEditor_e.commit();
        }
		if(te2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+11, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+11, false);
            mPrefsEditor_e.commit();
        }
		if(tf2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+12, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+12, false);
            mPrefsEditor_e.commit();
        }
		if(tg2.isChecked()){
            mPrefsEditor_e.putBoolean("evening"+13, true);
            mPrefsEditor_e.commit();
        }
        else {
            mPrefsEditor_e.putBoolean("evening"+13, false);
            mPrefsEditor_e.commit();
        }
		
	    getdata(view);
	   
	}
}
	


