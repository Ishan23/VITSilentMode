package ishan.khandelwal.vitsilentmode;




import java.util.ArrayList;
import java.util.Calendar;
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
import android.widget.Toast;


public class MorningSlots extends FragmentActivity implements OnClickListener {
	
	private ArrayList <Calendar> Cal= new ArrayList <Calendar>(25);
	
	private ArrayList <CheckBox> l= new ArrayList <CheckBox>(14);

	private ArrayList <Boolean> checkboxValue_m = new ArrayList <Boolean>(14);
	
	
	
	
	
	
			      
	
	private SharedPreferences mSharedPreferences_m;
    private SharedPreferences.Editor mPrefsEditor_m;
    private Button submitButton_m;
    
    
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slots);
		addenable();
		
		
		submitButton_m = (Button)findViewById(R.id.button1);
        submitButton_m.setOnClickListener(this);
        
        mSharedPreferences_m = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        mPrefsEditor_m = mSharedPreferences_m.edit();
		
 	  //OLD
        /*
		a1 = (CheckBox)findViewById(R.id.checkBox1);
		b1 = (CheckBox)findViewById(R.id.checkBox2);
		c1 = (CheckBox)findViewById(R.id.checkBox3);
		d1 = (CheckBox)findViewById(R.id.checkBox4);
		e1 = (CheckBox)findViewById(R.id.checkBox5);
		f1 = (CheckBox)findViewById(R.id.checkBox6);
		g1 = (CheckBox)findViewById(R.id.checkBox7);
		ta1 = (CheckBox)findViewById(R.id.checkBox8);
		tb1 = (CheckBox)findViewById(R.id.checkBox9);
		tc1 = (CheckBox)findViewById(R.id.checkBox10);
		td1 = (CheckBox)findViewById(R.id.checkBox11);
		te1 = (CheckBox)findViewById(R.id.checkBox12);
		tf1 = (CheckBox)findViewById(R.id.checkBox13);
		tg1 = (CheckBox)findViewById(R.id.checkBox14);
		*/
		
		
		//new
		//Initialise check boxes for every slot
		for (int i = 1; i <= 14; i++) {
			   String viewId = "checkBox" + i;
			   l.add(i-1, (CheckBox) findViewById(getResources().getIdentifier(viewId, "id", getPackageName())));
			   checkboxValue_m.add(i-1, mSharedPreferences_m.getBoolean("morning"+(i-1), false));
			   
			   if (checkboxValue_m.get(i-1) == true) 
			   {
		           l.get(i-1).setChecked(true);
		           }
		}
			   
			   ///////////////////////////old/////////////////
			   
		/*	   
		for (int i1=0; i1 <14; i1++) {
			   
			   checkboxValue_m.add(i1, mSharedPreferences_m.getBoolean("morning"+i1, false));			   
			   			}	
		
		if (checkboxValue_m.get(0) == true) {
	           a1.setChecked(true);
	       }
		if (checkboxValue_m.get(1) == true) {
	           b1.setChecked(true);
	       }
		if (checkboxValue_m.get(2) == true) {
	           c1.setChecked(true);
	       }
		if (checkboxValue_m.get(3) == true) {
	           d1.setChecked(true);
	       }
		if (checkboxValue_m.get(4) == true) {
	           e1.setChecked(true);
	       }
		if (checkboxValue_m.get(5) == true) {
	           f1.setChecked(true);
	       }
		if (checkboxValue_m.get(6) == true) {
	           g1.setChecked(true);
	       }
		if (checkboxValue_m.get(7) == true) {
	           ta1.setChecked(true);
	       }
		if (checkboxValue_m.get(8) == true) {
	           tb1.setChecked(true);
	       }
		if (checkboxValue_m.get(9) == true) {
	           tc1.setChecked(true);
	       }
		if (checkboxValue_m.get(10) == true) {
	           td1.setChecked(true);
	       }
		if (checkboxValue_m.get(11) == true) {
	           te1.setChecked(true);
	       }
		if (checkboxValue_m.get(12) == true) {
	           tf1.setChecked(true);
	       }
		if (checkboxValue_m.get(13) == true) {
	           tg1.setChecked(true);
	       }
		}*/
		
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
		
		//Code from labs. delete later
		//for refrence purpose only
		/*
		for( int i=0; i<60; i++)
		{
			Cal.add(i, Calendar.getInstance());
			Cal.get(i).set(Calendar.DAY_OF_WEEK, Day(i+1));
			Cal.get(i).set(Calendar.HOUR_OF_DAY, Hour(i+1));
			Cal.get(i).set(Calendar.MINUTE, Min(i+1));
			Cal.get(i).set(Calendar.SECOND, 0);
		}
		*/
		
		
		
		
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
				
				
				
				
		//OLD CODE. FOR REFRENCE. DELETE AFTER USE.
				/*
		//Set Calendar for A1 Slot
		aC1= Calendar.getInstance();
		aC1.set(Calendar.DAY_OF_WEEK, 2);
		aC1.set(Calendar.HOUR_OF_DAY, 8);
		aC1.set(Calendar.MINUTE, 0);
		aC1.set(Calendar.SECOND, 0);
		
		aC2= Calendar.getInstance();
		aC2.set(Calendar.DAY_OF_WEEK, 5);
		aC2.set(Calendar.HOUR_OF_DAY, 9);
		aC2.set(Calendar.MINUTE, 0);
		aC2.set(Calendar.SECOND, 0);
		
		aCt= Calendar.getInstance();
		aCt.set(Calendar.DAY_OF_WEEK, 3);
		aCt.set(Calendar.HOUR_OF_DAY, 11);
		aCt.set(Calendar.MINUTE, 0);
		aCt.set(Calendar.SECOND, 0);
		
		//Set Calendar for B1 Slot
		bC1= Calendar.getInstance();
		bC1.set(Calendar.DAY_OF_WEEK, 3);
		bC1.set(Calendar.HOUR_OF_DAY, 8);
		bC1.set(Calendar.MINUTE, 0);
		bC1.set(Calendar.SECOND, 0);
				
		bC2= Calendar.getInstance();
		bC2.set(Calendar.DAY_OF_WEEK, 6);
		bC2.set(Calendar.HOUR_OF_DAY, 9);
		bC2.set(Calendar.MINUTE, 0);
		bC2.set(Calendar.SECOND, 0);
		
		bCt= Calendar.getInstance();
		bCt.set(Calendar.DAY_OF_WEEK, 4);
		bCt.set(Calendar.HOUR_OF_DAY, 11);
		bCt.set(Calendar.MINUTE, 0);
		bCt.set(Calendar.SECOND, 0);
				
		//Set Calendar for C1 Slot
		cC1= Calendar.getInstance();
		cC1.set(Calendar.DAY_OF_WEEK, 4);
		cC1.set(Calendar.HOUR_OF_DAY, 8);
		cC1.set(Calendar.MINUTE, 0);
		cC1.set(Calendar.SECOND, 0);
				
		cC2= Calendar.getInstance();
		cC2.set(Calendar.DAY_OF_WEEK, 2);
		cC2.set(Calendar.HOUR_OF_DAY, 10);
		cC2.set(Calendar.MINUTE, 0);
		cC2.set(Calendar.SECOND, 0);
		
		cC3= Calendar.getInstance();
		cC3.set(Calendar.DAY_OF_WEEK, 5);
		cC3.set(Calendar.HOUR_OF_DAY, 11);
		cC3.set(Calendar.MINUTE, 0);
		cC3.set(Calendar.SECOND, 0);
		
		cCt= Calendar.getInstance();
		cCt.set(Calendar.DAY_OF_WEEK, 6);
		cCt.set(Calendar.HOUR_OF_DAY, 12);
		cCt.set(Calendar.MINUTE, 0);
		cCt.set(Calendar.SECOND, 0);
				
		//Set Calendar for D1 Slot
		dC1= Calendar.getInstance();
		dC1.set(Calendar.DAY_OF_WEEK, 5);
		dC1.set(Calendar.HOUR_OF_DAY, 8);
		dC1.set(Calendar.MINUTE, 0);
		dC1.set(Calendar.SECOND, 0);
				
		dC2= Calendar.getInstance();
		dC2.set(Calendar.DAY_OF_WEEK, 3);
		dC2.set(Calendar.HOUR_OF_DAY, 10);
		dC2.set(Calendar.MINUTE, 0);
		dC2.set(Calendar.SECOND, 0);
		
		dC3= Calendar.getInstance();
		dC3.set(Calendar.DAY_OF_WEEK, 6);
		dC3.set(Calendar.HOUR_OF_DAY, 11);
		dC3.set(Calendar.MINUTE, 18);
		dC3.set(Calendar.SECOND, 0);
		
		dCt= Calendar.getInstance();
		dCt.set(Calendar.DAY_OF_WEEK, 2);
		dCt.set(Calendar.HOUR_OF_DAY, 12);
		dCt.set(Calendar.MINUTE, 0);
		dCt.set(Calendar.SECOND, 0);
				
		//Set Calendar for E1 Slot
		eC1= Calendar.getInstance();
		eC1.set(Calendar.DAY_OF_WEEK, 6);
		eC1.set(Calendar.HOUR_OF_DAY, 8);
		eC1.set(Calendar.MINUTE, 0);
		eC1.set(Calendar.SECOND, 0);
				
		eC2= Calendar.getInstance();
		eC2.set(Calendar.DAY_OF_WEEK, 4);
		eC2.set(Calendar.HOUR_OF_DAY, 10);
		eC2.set(Calendar.MINUTE, 0);
		eC2.set(Calendar.SECOND, 0);
		
		eC3= Calendar.getInstance();
		eC3.set(Calendar.DAY_OF_WEEK, 2);
		eC3.set(Calendar.HOUR_OF_DAY, 11);
		eC3.set(Calendar.MINUTE, 0);
		eC3.set(Calendar.SECOND, 0);
		
		eCt= Calendar.getInstance();
		eCt.set(Calendar.DAY_OF_WEEK, 5);
		eCt.set(Calendar.HOUR_OF_DAY, 12);
		eCt.set(Calendar.MINUTE, 0);
		eCt.set(Calendar.SECOND, 0);
				
		//Set Calendar for F1 Slot
		fC1= Calendar.getInstance();
		fC1.set(Calendar.DAY_OF_WEEK, 2);
		fC1.set(Calendar.HOUR_OF_DAY, 9);
		fC1.set(Calendar.MINUTE, 0);
		fC1.set(Calendar.SECOND, 0);
				
		fC2= Calendar.getInstance();
		fC2.set(Calendar.DAY_OF_WEEK, 4);
		fC2.set(Calendar.HOUR_OF_DAY, 9);
		fC2.set(Calendar.MINUTE, 0);
		fC2.set(Calendar.SECOND, 0);
		
		fC3= Calendar.getInstance();
		fC3.set(Calendar.DAY_OF_WEEK, 5);
		fC3.set(Calendar.HOUR_OF_DAY, 10);
		fC3.set(Calendar.MINUTE, 0);
		fC3.set(Calendar.SECOND, 0);
		
		fCt= Calendar.getInstance();
		fCt.set(Calendar.DAY_OF_WEEK, 3);
		fCt.set(Calendar.HOUR_OF_DAY, 12);
		fCt.set(Calendar.MINUTE, 0);
		fCt.set(Calendar.SECOND, 0);
				
		//Set Calendar for G1 Slot
		gC1= Calendar.getInstance();
		gC1.set(Calendar.DAY_OF_WEEK, 3);
		gC1.set(Calendar.HOUR_OF_DAY, 9);
		gC1.set(Calendar.MINUTE, 0);
		gC1.set(Calendar.SECOND, 0);
				
		gC2= Calendar.getInstance();
		gC2.set(Calendar.DAY_OF_WEEK, 6);
		gC2.set(Calendar.HOUR_OF_DAY, 10);
		gC2.set(Calendar.MINUTE, 0);
		gC2.set(Calendar.SECOND, 0);
		
		gCt= Calendar.getInstance();
		gCt.set(Calendar.DAY_OF_WEEK, 4);
		gCt.set(Calendar.HOUR_OF_DAY, 12);
		gCt.set(Calendar.MINUTE, 0);
		gCt.set(Calendar.SECOND, 0);
		*/
		
		//Intents
        Intent setVibration = new Intent();
        setVibration.setClass(this, AlarmReciever.class);
        
        Intent setNormal = new Intent();
        setNormal.setClass(this, RingerMode.class);
       //NEW 
      //PENDING INTENTS
        ArrayList <PendingIntent> M_V= new ArrayList <PendingIntent>(25);
        ArrayList <PendingIntent> M_N= new ArrayList <PendingIntent>(25);
        
        for(int i=0; i<25; i++)
        {
        	M_V.add(PendingIntent.getBroadcast(this, i, setVibration,
        			PendingIntent.FLAG_UPDATE_CURRENT));
        	M_N.add(PendingIntent.getBroadcast(this, i, setNormal,
        			PendingIntent.FLAG_UPDATE_CURRENT));
        }
        
        //OLD
        //PENDING INTENTS
        /*p(V/N)q
        ID key:pqr
        p:slot no.
        q:class no.
        r:vibration/normal (0/1) */
        /*
        //Pending intents for A1 slot
       
        PendingIntent aV1 = PendingIntent.getBroadcast(this, 110, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent aV2 = PendingIntent.getBroadcast(this, 120, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent aVt = PendingIntent.getBroadcast(this, 140, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent aN1 = PendingIntent.getBroadcast(this, 111, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent aN2 = PendingIntent.getBroadcast(this, 121, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent aNt = PendingIntent.getBroadcast(this, 141, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        
        //Pending intents for B1 slot
        
        PendingIntent bV1 = PendingIntent.getBroadcast(this, 210, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent bV2 = PendingIntent.getBroadcast(this, 220, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent bVt = PendingIntent.getBroadcast(this, 240, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent bN1 = PendingIntent.getBroadcast(this, 211, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent bN2 = PendingIntent.getBroadcast(this, 221, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent bNt = PendingIntent.getBroadcast(this, 241, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        //Pending intents for C1 slot
        
        PendingIntent cV1 = PendingIntent.getBroadcast(this, 310, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent cV2 = PendingIntent.getBroadcast(this, 320, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent cV3 = PendingIntent.getBroadcast(this, 330, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent cVt = PendingIntent.getBroadcast(this, 340, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent cN1 = PendingIntent.getBroadcast(this, 311, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent cN2 = PendingIntent.getBroadcast(this, 321, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent cN3 = PendingIntent.getBroadcast(this, 331, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent cNt = PendingIntent.getBroadcast(this, 341, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        //Pending intents for D1 slot
        
        PendingIntent dV1 = PendingIntent.getBroadcast(this, 410, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent dV2 = PendingIntent.getBroadcast(this, 420, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent dV3 = PendingIntent.getBroadcast(this, 430, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent dVt = PendingIntent.getBroadcast(this, 440, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
       
        PendingIntent dN1 = PendingIntent.getBroadcast(this, 411, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent dN2 = PendingIntent.getBroadcast(this, 421, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent dN3 = PendingIntent.getBroadcast(this, 431, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent dNt = PendingIntent.getBroadcast(this, 441, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        //Pending intents for E1 slot
        
        PendingIntent eV1 = PendingIntent.getBroadcast(this, 510, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent eV2 = PendingIntent.getBroadcast(this, 520, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent eV3 = PendingIntent.getBroadcast(this, 530, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent eVt = PendingIntent.getBroadcast(this, 540, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent eN1 = PendingIntent.getBroadcast(this, 511, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent eN2 = PendingIntent.getBroadcast(this, 521, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent eN3 = PendingIntent.getBroadcast(this, 531, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent eNt = PendingIntent.getBroadcast(this, 541, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        //Pending intents for F1 slot
        
        PendingIntent fV1 = PendingIntent.getBroadcast(this, 610, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent fV2 = PendingIntent.getBroadcast(this, 620, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent fV3 = PendingIntent.getBroadcast(this, 630, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent fVt = PendingIntent.getBroadcast(this, 640, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent fN1 = PendingIntent.getBroadcast(this, 611, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent fN2 = PendingIntent.getBroadcast(this, 621, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent fN3 = PendingIntent.getBroadcast(this, 631, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent fNt = PendingIntent.getBroadcast(this, 641, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        
        //Pending intents for G1 slot
        
        PendingIntent gV1 = PendingIntent.getBroadcast(this, 710, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent gV2 = PendingIntent.getBroadcast(this, 720, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent gVt = PendingIntent.getBroadcast(this, 740, setVibration,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent gN1 = PendingIntent.getBroadcast(this, 711, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent gN2 = PendingIntent.getBroadcast(this, 721, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
        PendingIntent gNt = PendingIntent.getBroadcast(this, 741, setNormal,
        		PendingIntent.FLAG_UPDATE_CURRENT);
        
       */
         
        // create the object
        AlarmManager mAlarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        
        //a1
        if(l.get(0).isChecked()){
        	
        	//NEW
        	for(int i=0; i<=1; i++)
            {
           			
    				
    				 mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis(), 7*24*60*60*1000, M_V.get(i));
    		         mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(i));
    		        
    		         //Toast.makeText(this, "L"+(i+1), Toast.LENGTH_SHORT).show();
                	
            }
        /*
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, aC1.getTimeInMillis(), 7*24*60*60*1000, aV1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, aC1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, aN1);
        
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, aC2.getTimeInMillis(), 7*24*60*60*1000, aV2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, aC2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, aN2);
      
        */
            //Toast.makeText(this, "A1", Toast.LENGTH_SHORT).show();
            
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
            /*
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, bC1.getTimeInMillis(), 7*24*60*60*1000, bV1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, bC1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, bN1);
            
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, bC2.getTimeInMillis(), 7*24*60*60*1000, bV2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, bC2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, bN2);
          
            */
             //Toast.makeText(this, "B1", Toast.LENGTH_SHORT).show();
            
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
            
            /*
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cC1.getTimeInMillis(), 7*24*60*60*1000, cV1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cC1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, cN1);
            
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cC2.getTimeInMillis(), 7*24*60*60*1000, cV2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cC2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, cN2);
            
            //Class no. 3
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cC3.getTimeInMillis(), 7*24*60*60*1000, cV3);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cC3.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, cN3);
          */
          
            
             //Toast.makeText(this, "C1", Toast.LENGTH_SHORT).show();
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
            /*
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, dC1.getTimeInMillis(), 7*24*60*60*1000, dV1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, dC1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, dN1);
            
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, dC2.getTimeInMillis(), 7*24*60*60*1000, dV2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, dC2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, dN2);
          
            //Class no. 3
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, dC3.getTimeInMillis(), 7*24*60*60*1000, dV3);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, dC3.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, dN3);
           */
             //Toast.makeText(this, "D1", Toast.LENGTH_SHORT).show();
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
            /*
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, eC1.getTimeInMillis(), 7*24*60*60*1000, eV1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, eC1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, eN1);
            
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, eC2.getTimeInMillis(), 7*24*60*60*1000, eV2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, eC2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, eN2);
          
            //Class no. 3
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, eC3.getTimeInMillis(), 7*24*60*60*1000, eV3);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, eC3.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, eN3);
          */
             //Toast.makeText(this, "E1", Toast.LENGTH_SHORT).show();
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
            /*
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, fC1.getTimeInMillis(), 7*24*60*60*1000, fV1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, fC1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, fN1);
            
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, fC2.getTimeInMillis(), 7*24*60*60*1000, fV2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, fC2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, fN2);
          
            //Class no. 3
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, fC3.getTimeInMillis(), 7*24*60*60*1000, fV3);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, fC3.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, fN3);
          */
             //Toast.makeText(this, "F1", Toast.LENGTH_SHORT).show();
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
            /*
            //Class no. 1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, gC1.getTimeInMillis(), 7*24*60*60*1000, gV1);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, gC1.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, gN1);
            
            //Class no. 2
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, gC2.getTimeInMillis(), 7*24*60*60*1000, gV2);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, gC2.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, gN2);
          
            */
             //Toast.makeText(this, "G1", Toast.LENGTH_SHORT).show();
            }
        
        
      //ta1
    	   if(l.get(7).isChecked()){
    	   
    	  //NEW
    	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(2).getTimeInMillis(), 7*24*60*60*1000, M_V.get(2));
	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(2).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(2));
         /*   
            //Class TA1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, aCt.getTimeInMillis(), 7*24*60*60*1000, aVt);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, aCt.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, aNt);
        */
            //Toast.makeText(this, "TA1", Toast.LENGTH_SHORT).show();
          }
    	   
    	   //tb1
        
        	if(l.get(8).isChecked()){
            
        	//NEW
      	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(5).getTimeInMillis(), 7*24*60*60*1000, M_V.get(5));
  	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(5).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(5));
  	      /*
            //Class TB1
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, bCt.getTimeInMillis(), 7*24*60*60*1000, bVt);
            mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, bCt.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, bNt);
        */
            //Toast.makeText(this, "TB1", Toast.LENGTH_SHORT).show();
          }
        
        	//tc1
        	if(l.get(9).isChecked()){
        	//NEW
      	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(9).getTimeInMillis(), 7*24*60*60*1000, M_V.get(9));
  	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(9).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(9));
  	      /*
        	//Class TC1
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cCt.getTimeInMillis(), 7*24*60*60*1000, cVt);
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cCt.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, cNt);
        	*/
        	 //Toast.makeText(this, "TC1", Toast.LENGTH_SHORT).show();
        }
       
        	
        	//td1
        	if(l.get(10).isChecked()){
        	//NEW
      	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(13).getTimeInMillis(), 7*24*60*60*1000, M_V.get(13));
  	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(13).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(13));
  	      /*
        	//Class TD1
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, dCt.getTimeInMillis(), 7*24*60*60*1000, dVt);
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, dCt.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, dNt);
        	*/
        	 //Toast.makeText(this, "TD1", Toast.LENGTH_SHORT).show();
        }
        
        	//te1
        	if(l.get(11).isChecked()){
        	//NEW
      	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(17).getTimeInMillis(), 7*24*60*60*1000, M_V.get(17));
  	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(17).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(17));
  	      /*
        	//Class TE1
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, eCt.getTimeInMillis(), 7*24*60*60*1000, eVt);
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, eCt.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, eNt);
        	*/
        	 //Toast.makeText(this, "TE1", Toast.LENGTH_SHORT).show();
        }
        
        	//tf1
        	if(l.get(12).isChecked()){
        	//NEW
      	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(21).getTimeInMillis(), 7*24*60*60*1000, M_V.get(21));
  	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(21).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(21));
  	      /*
        	//Class TF1
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, fCt.getTimeInMillis(), 7*24*60*60*1000, fVt);
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, fCt.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, fNt);
        	*/
        	 //Toast.makeText(this, "TF1", Toast.LENGTH_SHORT).show();
        }
       
        	//tg1
        	if(l.get(13).isChecked()){
        	//NEW
      	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(24).getTimeInMillis(), 7*24*60*60*1000, M_V.get(24));
  	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(24).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(24));
  	      /*
        	//Class TG1
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, gCt.getTimeInMillis(), 7*24*60*60*1000, gVt);
        	mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, gCt.getTimeInMillis()+50*60*1000, 7*24*60*60*1000, gNt);
        	*/
        	 //Toast.makeText(this, "TG1", Toast.LENGTH_SHORT).show(); 
        }
 
     
        //!a1
        if(!l.get(0).isChecked()){
        	
        	for(int i=0; i<2; i++)
        	{
        		PendingIntent.getBroadcast(this, i, setVibration,
        	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	        	
        	        	
        	        	
        	        	PendingIntent.getBroadcast(this, i, setNormal,
        	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	                	
        	                	
        	}
        	/*
        	//Close vibration p.i
        	PendingIntent.getBroadcast(this, 110, setVibration,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 120, setVibration,
       		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
       	
        	//Close normal p.i
        	PendingIntent.getBroadcast(this, 111, setNormal,
    	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 121, setNormal,
    	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	*/
        	   }
        
        //!b1
          if(!l.get(1).isChecked()){
        	  
        	  for(int i=3; i<5; i++)
          	{
          		PendingIntent.getBroadcast(this, i, setVibration,
          	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	        	
          	        	
          	        	
          	        	PendingIntent.getBroadcast(this, i, setNormal,
          	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	                	
          	                	
          	}
        	/*
        	//Close vibration p.i
        	PendingIntent.getBroadcast(this, 210, setVibration,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 220, setVibration,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        
        	//Close normal p.i
        	PendingIntent.getBroadcast(this, 211, setNormal,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 221, setNormal,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	*/
        
          }

          //!c1
          if(!l.get(2).isChecked()){
        	  
        	  for(int i=6; i<9; i++)
          	{
          		PendingIntent.getBroadcast(this, i, setVibration,
          	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	        	
          	        	
          	        	
          	        	PendingIntent.getBroadcast(this, i, setNormal,
          	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	                	
          	                	
          	}
        	  /*
        	//Close vibration p.i
        	PendingIntent.getBroadcast(this, 310, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 320, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 330, setVibration,
           	PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        
	
        	//Close normal p.i
        	PendingIntent.getBroadcast(this, 311, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 321, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 331, setNormal,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	*/
         }

          //!d1
          if(!l.get(3).isChecked()){
        	  
        	  for(int i=10; i<13; i++)
          	{
          		PendingIntent.getBroadcast(this, i, setVibration,
          	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	        	
          	        	
          	        	PendingIntent.getBroadcast(this, i, setNormal,
          	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	                	
          	                	
          	}
        	  /*
            //Close vibration p.i
            PendingIntent.getBroadcast(this, 410, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
            PendingIntent.getBroadcast(this, 420, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            
            PendingIntent.getBroadcast(this, 430, setVibration,
           	PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        
	
            //Close normal p.i
            PendingIntent.getBroadcast(this, 411, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
            PendingIntent.getBroadcast(this, 421, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            
            PendingIntent.getBroadcast(this, 431, setNormal,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            */
          }

          //!e1
          if(!l.get(4).isChecked()){
        	  
        	  for(int i=14; i<17; i++)
          	{
          		PendingIntent.getBroadcast(this, i, setVibration,
          	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	        
          	        	
          	        	PendingIntent.getBroadcast(this, i, setNormal,
          	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	                	
          	                	
          	}
        	  /*
            //Close vibration p.i
        	PendingIntent.getBroadcast(this, 510, setVibration,
    	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 520, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 530, setVibration,
       		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
       
        	//Close normal p.i
        	PendingIntent.getBroadcast(this, 511, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 521, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 531, setNormal,
   	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	*/
          }

          
          //!f1
          if(!l.get(5).isChecked()){
        	  
        	  for(int i=18; i<21; i++)
          	{
          		PendingIntent.getBroadcast(this, i, setVibration,
          	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	        	
          	        	
          	        	
          	        	PendingIntent.getBroadcast(this, i, setNormal,
          	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	                	
          	                	
          	}
        	  /*
        	//Close vibration p.i
        	PendingIntent.getBroadcast(this, 610, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 620, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 630, setVibration,
       		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
      
	
        	//Close normal p.i
        	PendingIntent.getBroadcast(this, 611, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 621, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	PendingIntent.getBroadcast(this, 631, setNormal,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
        	*/
          }

          
          //!g1
          if(!l.get(6).isChecked()){
        	  
        	  for(int i=22; i<24; i++)
          	{
          		PendingIntent.getBroadcast(this, i, setVibration,
          	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	        	
          	        	
          	        	
          	        	PendingIntent.getBroadcast(this, i, setNormal,
          	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	                	
          	}
        	  /*
        	//Close vibration p.i
        	PendingIntent.getBroadcast(this, 710, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 720, setVibration,
    		PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	
       
	
        	//Close normal p.i
        	PendingIntent.getBroadcast(this, 711, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
	
        	PendingIntent.getBroadcast(this, 721, setNormal,
	        PendingIntent.FLAG_UPDATE_CURRENT).cancel();
        	*/
          }
          
          //!ta1
          if(!l.get(7).isChecked()){
        	  
        	
           	//Close vibration p.i	
          	PendingIntent.getBroadcast(this, 2, setVibration,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	
          	//Close normal p.i
          	PendingIntent.getBroadcast(this, 2, setNormal,
            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
          	
          	          }
          
          //!tb1
          if(!l.get(8).isChecked()){
        	  
        	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(this, 5, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(this, 5, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          
          //!tc1
          if(!l.get(9).isChecked()){
        	  
        	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(this, 9, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(this, 9, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          
          //!td1
          if(!l.get(10).isChecked()){
        	  
        	 
            	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(this, 13, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(this, 13, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          
          //!te1
          if(!l.get(11).isChecked()){
        	  
        	 
            	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(this, 17, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(this, 17, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          
          //!tf1
          if(!l.get(12).isChecked()){
        	  
        	 
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(this, 21, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(this, 21, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
          
          //!tg1
          if(!l.get(13).isChecked()){
        	  
        	  
            	
            	//Close vibration p.i	
            	PendingIntent.getBroadcast(this, 24, setVibration,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	//Close normal p.i
            	PendingIntent.getBroadcast(this, 24, setNormal,
              PendingIntent.FLAG_UPDATE_CURRENT).cancel();
            	
            	          }
        
      
        
        }
	
	public void onClick(View view) {
		
		/*
		if(a1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+0, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+0, false);
            mPrefsEditor_m.commit();
        }
		if(b1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+1, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+1, false);
            mPrefsEditor_m.commit();
        }
		if(c1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+2, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+2, false);
            mPrefsEditor_m.commit();
        }
		if(d1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+3, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+3, false);
            mPrefsEditor_m.commit();
        }
		if(e1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+4, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+4, false);
            mPrefsEditor_m.commit();
        }
		if(f1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+5, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+5, false);
            mPrefsEditor_m.commit();
        }
		if(g1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+6, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+6, false);
            mPrefsEditor_m.commit();
        }
		if(ta1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+7, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+7, false);
            mPrefsEditor_m.commit();
        }
		if(tb1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+8, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+8, false);
            mPrefsEditor_m.commit();
        }
		if(tc1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+9, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+9, false);
            mPrefsEditor_m.commit();
        }
		if(td1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+10, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+10, false);
            mPrefsEditor_m.commit();
        }
		if(te1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+11, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+11, false);
            mPrefsEditor_m.commit();
        }
		if(tf1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+12, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+12, false);
            mPrefsEditor_m.commit();
        }
		if(tg1.isChecked()){
            mPrefsEditor_m.putBoolean("morning"+13, true);
            mPrefsEditor_m.commit();
        }
        else {
            mPrefsEditor_m.putBoolean("morning"+13, false);
            mPrefsEditor_m.commit();
        }
		
	    getdata(view);
	   
	}*/
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
		 Toast.makeText(this, "SUBMITTED", Toast.LENGTH_LONG).show();
		    getdata(view);
		   
		}
}
	


