package ishan.khandelwal.vitsilentmode;


import java.util.ArrayList;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

@SuppressLint("NewApi") public class MainActivity2 extends FragmentActivity implements ActionBar.TabListener {

    
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;

     ViewPager mViewPager;
     private static SharedPreferences preferences;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main2);
        
        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();

        // Specify that the Home/Up button should not be enabled, since there is no hierarchical
        // parent.
        actionBar.setHomeButtonEnabled(false);

        // Specify that we will be displaying tabs in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When swiping between different app sections, select the corresponding tab.
                // We can also use ActionBar.Tab#select() to do this if we have a reference to the
                // Tab.
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by the adapter.
            // Also specify this Activity object, which implements the TabListener interface, as the
            // listener for when this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mAppSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    
	@Override  
    public boolean onOptionsItemSelected(MenuItem item) {  
        int itemId = item.getItemId();
		if (itemId == R.id.action_settings) {
			Intent intent = new Intent();
			intent.setClass(this, Settings.class);
			startActivity(intent);
			return true;
			//Toast.makeText(getApplicationContext(),"Sorry, no settings available right now",Toast.LENGTH_SHORT).show();
			
		} else if (itemId == R.id.about) {
			Intent intent = new Intent();
			intent.setClass(this, About.class);
			startActivity(intent);
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}  
	

	}

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        //////////////////////////////////////////////////////////
        /*
         * Main Part. Make the cases for each layout
         */
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    // Morning
                    return new Morning();
                    
                case 1:
                	// Evening
                	return new Evening();
                	
                case 2:
                	// Labs
                	return new LabSlots();

                default:
                    // The other sections of the app are dummy placeholders.
                    Fragment fragment = new DummySectionFragment();
                    Bundle args = new Bundle();
                   // args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
                    fragment.setArguments(args);
                    return fragment;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
        	
        	switch (position)
        	{
        	case 0: return "MORNING";
        	case 1: return "EVENING";
        	case 2: return "LABS";
        	default: return "ERROR";
        	}

        }
    }
    
    public SharedPreferences getpref() {
		
		// TODO Auto-generated method stub
		return preferences;
	}

    /**
     * A fragment that launches other parts of the application.
     */
    public static class DummySectionFragment extends Fragment{
    	
    }
    
   
    
    /////////////////////////// MORNING ////////////////////////////////
    
    public static class Morning extends Fragment implements OnClickListener{

    	private ArrayList <Calendar> Cal= new ArrayList <Calendar>(25);
    	
    	
    	private ArrayList <CheckBox> l= new ArrayList <CheckBox>(14);
    	private ArrayList <Boolean> checkboxValue_m = new ArrayList <Boolean>(14);
    	
    	Boolean enable;
    
        private SharedPreferences.Editor mPrefsEditor_m;
        

      //PENDING INTENTS
        ArrayList <PendingIntent> M_V= new ArrayList <PendingIntent>(25);
        ArrayList <PendingIntent> M_N= new ArrayList <PendingIntent>(25);
        
       

    	
        @Override
    	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        	 View rootView = inflater.inflate(R.layout.activity_slots, container, false);
    		addenable();

    		

    		
    		// Demonstration of a collection-browsing activity.
            rootView.findViewById(R.id.button1)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        	
                        	Log.d("onClick", "Morning");
                    	
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
                        	 
                        	 for(int i=0; i<25; i++)
                         	{
                         		mPrefsEditor_m.putBoolean("P.I morning"+i, false);
                         		mPrefsEditor_m.apply();
                         	}
                        	 
     		
                 		   getdata(view);
                 		
                            
                        }
                    });
    		
    		
            preferences = getActivity().getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
            mPrefsEditor_m = preferences.edit();

    		
    		
    		//new
    		//Initialise check boxes for every slot
    		for (int i = 1; i <= 14; i++) {
    			   String viewId = "checkBox" + i;
    			   l.add(i-1, (CheckBox) rootView.findViewById(getResources().getIdentifier(viewId, "id", "ishan.khandelwal.vitsilentmode")));
    			   checkboxValue_m.add(i-1, preferences.getBoolean("morning"+(i-1), false));
    			   //check[i]=mSharedPreferences_m.getBoolean("morning"+(i-1), false);
    			   
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
    				
    				//Toast.makeText(getActivity(), "testing2", Toast.LENGTH_LONG).show();
    		
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
    				
    				Log.d("Inside getdata", "Calendar data set");

    				
    				
    				//Intents
    				Intent setVibration = new Intent();
    				setVibration.setClass(getActivity(), AlarmReciever.class);
            
    				Intent setNormal = new Intent();
    				setNormal.setClass(getActivity(), RingerMode.class);
    				
    				
            
    				Log.d("Inside getdata", "Intent set");
   
    				//NEW 
  
    				for(int i=0; i<25; i++)
    				{
    					M_V.add(PendingIntent.getBroadcast(getActivity(), i, setVibration,
            			PendingIntent.FLAG_UPDATE_CURRENT));
    					M_N.add(PendingIntent.getBroadcast(getActivity(), i, setNormal,
            			PendingIntent.FLAG_UPDATE_CURRENT));
    				}
    				Log.d("Inside getdata", " Pending Intent set");
             
    				// create the object
    				AlarmManager mAlarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
    				
    				Log.d("Inside getdata", "AlarmManager set");
            
    				//a1
    				if(l.get(0).isChecked()){
            	
    					//NEW
    					for(int i=0; i<=1; i++)
    					{
               			
    					 mPrefsEditor_m.putBoolean("P.I morning"+i, true);
    					 mPrefsEditor_m.apply();
        				 mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis(), 7*24*60*60*1000, M_V.get(i));
        		         mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis()+60*60*1000, 7*24*60*60*1000, M_N.get(i));
        		
        		         //Toast.makeText(getActivity(), "A1", Toast.LENGTH_SHORT).show();
                    	
    					}
        
                
    				}
            
            //b1
            if(l.get(1).isChecked()){
            	
            	//NEW
            	for(int i=3; i<=4; i++)
                {
               			
            		mPrefsEditor_m.putBoolean("P.I morning"+i, true);
					 mPrefsEditor_m.apply();
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
               			
            		mPrefsEditor_m.putBoolean("P.I morning"+i, true);
					 mPrefsEditor_m.apply();
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
               			
            		mPrefsEditor_m.putBoolean("P.I morning"+i, true);
					 mPrefsEditor_m.apply();
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
               		
            		mPrefsEditor_m.putBoolean("P.I morning"+i, true);
					 mPrefsEditor_m.apply();
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
               			
            		mPrefsEditor_m.putBoolean("P.I morning"+i, true);
					 mPrefsEditor_m.apply();
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
               			
            		mPrefsEditor_m.putBoolean("P.I morning"+i, true);
					 mPrefsEditor_m.apply();
        				 mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis(), 7*24*60*60*1000, M_V.get(i));
        		         mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(i));
        		        
        		         //Toast.makeText(this, "L"+(i+1), Toast.LENGTH_SHORT).show();
                    	
                }
          
                }
            
            
          //ta1
        	   if(l.get(7).isChecked()){
        		   
        		   mPrefsEditor_m.putBoolean("P.I morning"+2, true);
        		   mPrefsEditor_m.apply();
        	  //NEW
        	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(2).getTimeInMillis(), 7*24*60*60*1000, M_V.get(2));
    	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(2).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(2));
      
              }
        	   
        	   //tb1
            
            	if(l.get(8).isChecked()){
            		
            		mPrefsEditor_m.putBoolean("P.I morning"+5, true);
            		mPrefsEditor_m.apply();
            	//NEW
          	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(5).getTimeInMillis(), 7*24*60*60*1000, M_V.get(5));
      	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(5).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(5));
      	    
              }
            
            	//tc1
            	if(l.get(9).isChecked()){
            		
            		mPrefsEditor_m.putBoolean("P.I morning"+9, true);
            		mPrefsEditor_m.apply();
            	//NEW
          	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(9).getTimeInMillis(), 7*24*60*60*1000, M_V.get(9));
      	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(9).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(9));
      	   
            }
           
            	
            	//td1
            	if(l.get(10).isChecked()){
            		
            		mPrefsEditor_m.putBoolean("P.I morning"+13, true);
            		mPrefsEditor_m.apply();
            	//NEW
          	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(13).getTimeInMillis(), 7*24*60*60*1000, M_V.get(13));
      	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(13).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(13));
      	   
            }
            
            	//te1
            	if(l.get(11).isChecked()){
            		
            		mPrefsEditor_m.putBoolean("P.I morning"+17, true);
            		mPrefsEditor_m.apply();
            	//NEW
          	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(17).getTimeInMillis(), 7*24*60*60*1000, M_V.get(17));
      	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(17).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(17));
      	    
            }
            
            	//tf1
            	if(l.get(12).isChecked()){
            		
            		mPrefsEditor_m.putBoolean("P.I morning"+21, true);
            		mPrefsEditor_m.apply();
            	//NEW
          	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(21).getTimeInMillis(), 7*24*60*60*1000, M_V.get(21));
      	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(21).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(21));
      	
            }
           
            	//tg1
            	if(l.get(13).isChecked()){
            		
            		mPrefsEditor_m.putBoolean("P.I morning"+24, true);
            		mPrefsEditor_m.apply();
            	//NEW
          	  mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(24).getTimeInMillis(), 7*24*60*60*1000, M_V.get(24));
      	      mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(24).getTimeInMillis()+55*60*1000, 7*24*60*60*1000, M_N.get(24));
      	     
            }
     
         
            //!a1
            if(!l.get(0).isChecked()){
            	
            	for(int i=0; i<2; i++)
            	{
            		mPrefsEditor_m.putBoolean("P.I morning"+i, false);
					 mPrefsEditor_m.apply();
					 
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
            		  mPrefsEditor_m.putBoolean("P.I morning"+i, false);
 					 mPrefsEditor_m.apply();
 					 
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
            		  mPrefsEditor_m.putBoolean("P.I morning"+i, false);
 					 mPrefsEditor_m.apply();
 					 
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
            		  mPrefsEditor_m.putBoolean("P.I morning"+i, false);
 					 mPrefsEditor_m.apply();
            		  
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
            		  mPrefsEditor_m.putBoolean("P.I morning"+i, false);
 					 mPrefsEditor_m.apply();
            		  
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
            		  mPrefsEditor_m.putBoolean("P.I morning"+i, false);
 					 mPrefsEditor_m.apply();
            		  
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
            		  mPrefsEditor_m.putBoolean("P.I morning"+i, false);
 					 mPrefsEditor_m.apply();
            		  
              		PendingIntent.getBroadcast(getActivity(), i, setVibration,
              	            PendingIntent.FLAG_UPDATE_CURRENT).cancel();
              	        	
              	        	
              	        	
              	        	PendingIntent.getBroadcast(getActivity(), i, setNormal,
              	            	    PendingIntent.FLAG_UPDATE_CURRENT).cancel();
              	                	
              	}
            	 
              }
              
              //!ta1
              if(!l.get(7).isChecked()){
            	  
            	  mPrefsEditor_m.putBoolean("P.I morning"+2, false);
       		   mPrefsEditor_m.apply();
            	  
               	//Close vibration p.i	
              	PendingIntent.getBroadcast(getActivity(), 2, setVibration,
                PendingIntent.FLAG_UPDATE_CURRENT).cancel();
              	
              	//Close normal p.i
              	PendingIntent.getBroadcast(getActivity(), 2, setNormal,
                PendingIntent.FLAG_UPDATE_CURRENT).cancel();
              	
              	          }
              
              //!tb1
              if(!l.get(8).isChecked()){
            	  
            	  mPrefsEditor_m.putBoolean("P.I morning"+5, false);
          		   mPrefsEditor_m.apply();
            	
                	//Close vibration p.i	
                	PendingIntent.getBroadcast(getActivity(), 5, setVibration,
                  PendingIntent.FLAG_UPDATE_CURRENT).cancel();
                	
                	//Close normal p.i
                	PendingIntent.getBroadcast(getActivity(), 5, setNormal,
                  PendingIntent.FLAG_UPDATE_CURRENT).cancel();
                	
                	          }
              
              //!tc1
              if(!l.get(9).isChecked()){
            	  
            	  mPrefsEditor_m.putBoolean("P.I morning"+9, false);
          		   mPrefsEditor_m.apply();
            	
                	//Close vibration p.i	
                	PendingIntent.getBroadcast(getActivity(), 9, setVibration,
                  PendingIntent.FLAG_UPDATE_CURRENT).cancel();
                	
                	//Close normal p.i
                	PendingIntent.getBroadcast(getActivity(), 9, setNormal,
                  PendingIntent.FLAG_UPDATE_CURRENT).cancel();
                	
                	          }
              
              //!td1
              if(!l.get(10).isChecked()){
            	  
            	  mPrefsEditor_m.putBoolean("P.I morning"+13, false);
          		   mPrefsEditor_m.apply();
                	
                	//Close vibration p.i	
                	PendingIntent.getBroadcast(getActivity(), 13, setVibration,
                  PendingIntent.FLAG_UPDATE_CURRENT).cancel();
                	
                	//Close normal p.i
                	PendingIntent.getBroadcast(getActivity(), 13, setNormal,
                  PendingIntent.FLAG_UPDATE_CURRENT).cancel();
                	
                	          }
              
              //!te1
              if(!l.get(11).isChecked()){
            	  
            	  mPrefsEditor_m.putBoolean("P.I morning"+17, false);
          		   mPrefsEditor_m.apply();
                	
                	//Close vibration p.i	
                	PendingIntent.getBroadcast(getActivity(), 17, setVibration,
                  PendingIntent.FLAG_UPDATE_CURRENT).cancel();
                	
                	//Close normal p.i
                	PendingIntent.getBroadcast(getActivity(), 17, setNormal,
                  PendingIntent.FLAG_UPDATE_CURRENT).cancel();
                	
                	          }
              
              //!tf1
              if(!l.get(12).isChecked()){
            	  
            	  mPrefsEditor_m.putBoolean("P.I morning"+21, false);
          		   mPrefsEditor_m.apply();
            	  
                	//Close vibration p.i	
                	PendingIntent.getBroadcast(getActivity(), 21, setVibration,
                  PendingIntent.FLAG_UPDATE_CURRENT).cancel();
                	
                	//Close normal p.i
                	PendingIntent.getBroadcast(getActivity(), 21, setNormal,
                  PendingIntent.FLAG_UPDATE_CURRENT).cancel();
                	
                	          }
              
              //!tg1
              if(!l.get(13).isChecked()){
            	  
            	  mPrefsEditor_m.putBoolean("P.I morning"+24, false);
          		   mPrefsEditor_m.apply();
                	
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
		
    	
    	

		public ArrayList<PendingIntent> getPendingIntents() {
			// TODO Auto-generated method stub
			return M_V;
		}

		public ArrayList<PendingIntent> getPendingIntents2() {
			
			return M_N;
		}
		public void cancelAllPendingIntent()
		{
			
				for(int i=0; i<=24; i++)
				{
					M_V.get(i).cancel();
					M_N.get(i).cancel();
					Log.d("Pending intent "+i, "cancelled");
				}
			
			
		}
		
		public ArrayList <Calendar> getData()
		{
			Log.d("Morning", "Calendar data being sent");
			
			return Cal;
			
		}
    }
    

    /////////////////////////// EVENING ////////////////////////////////
    
    	public static class Evening extends Fragment implements OnClickListener{

    	private ArrayList <Calendar> Cal= new ArrayList <Calendar>(25);


    	private ArrayList <CheckBox> l= new ArrayList <CheckBox>(14);
    	private ArrayList <Boolean> checkboxValue_m = new ArrayList <Boolean>(14);



    	private SharedPreferences.Editor mPrefsEditor_m;





    	@Override
    	public View onCreateView(LayoutInflater inflater, ViewGroup container,
    			Bundle savedInstanceState) {
    		View rootView = inflater.inflate(R.layout.activity_eslots, container, false);
    		addenable();

    		Log.d("inside fragment", "Layout set");

    		
    		// Demonstration of a collection-browsing activity.
    		rootView.findViewById(R.id.button1)
    		.setOnClickListener(new View.OnClickListener() {
    			@Override
    			public void onClick(View view) {
  	
    				Log.d("onClick", "Evening");
		
  	
    				for(int i = 0; i < 14 ; i++){

    					if(l.get(i).isChecked()){
    						mPrefsEditor_m.putBoolean("evening"+i, true);
    						mPrefsEditor_m.apply();
    					}
    					else {
    						mPrefsEditor_m.putBoolean("evening"+i, false);
    						mPrefsEditor_m.apply();
    					}
    				}
	
	   getdata(view);
	

    			}
    		});


    		//submitButton_m = (Button)findViewById(R.id.button1);
    		//submitButton_m.setOnClickListener(this);

    		preferences = getActivity().getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
    		mPrefsEditor_m = preferences.edit();
    		
    		//new
    		//Initialise check boxes for every slot
    		for (int i = 15; i <= 28; i++) {
    			String viewId = "checkBox" + i;
    			l.add(i-15, (CheckBox) rootView.findViewById(getResources().getIdentifier(viewId, "id", "ishan.khandelwal.vitsilentmode")));
    			checkboxValue_m.add(i-15, preferences.getBoolean("evening"+(i-15), false));

    			if (checkboxValue_m.get(i-15) == true) 
    			{
    					l.get(i-15).setChecked(true);
    			}
    		}


    		return rootView;


    	}




    	public void addenable(){
    	}
    	
    	public void getdata(View V){

    		Log.d("Inside getdata", "inside getdata");

    		//Set Calendar for A2 Slot
    		Cal.add(0, Calendar.getInstance());
    		Cal.get(0).set(Calendar.DAY_OF_WEEK, 2); 
    		Cal.get(0).set(Calendar.HOUR_OF_DAY, 14);
    		Cal.get(0).set(Calendar.MINUTE, 0);
    		Cal.get(0).set(Calendar.SECOND, 0);

    		Cal.add(1, Calendar.getInstance());
    		Cal.get(1).set(Calendar.DAY_OF_WEEK, 5);
    		Cal.get(1).set(Calendar.HOUR_OF_DAY, 15);
    		Cal.get(1).set(Calendar.MINUTE, 0);
    		Cal.get(1).set(Calendar.SECOND, 0);

    		Cal.add(2, Calendar.getInstance());
    		Cal.get(2).set(Calendar.DAY_OF_WEEK, 3);
    		Cal.get(2).set(Calendar.HOUR_OF_DAY, 17);
    		Cal.get(2).set(Calendar.MINUTE, 0);
    		Cal.get(2).set(Calendar.SECOND, 0);



    		//Set Calendar for B2 Slot
    		Cal.add(3, Calendar.getInstance());
    		Cal.get(3).set(Calendar.DAY_OF_WEEK, 3);
    		Cal.get(3).set(Calendar.HOUR_OF_DAY, 14);
    		Cal.get(3).set(Calendar.MINUTE, 0);
    		Cal.get(3).set(Calendar.SECOND, 0);

    		Cal.add(4, Calendar.getInstance());
    		Cal.get(4).set(Calendar.DAY_OF_WEEK, 6);
    		Cal.get(4).set(Calendar.HOUR_OF_DAY, 15);
    		Cal.get(4).set(Calendar.MINUTE, 0);
    		Cal.get(4).set(Calendar.SECOND, 0);

    		Cal.add(5, Calendar.getInstance());
    		Cal.get(5).set(Calendar.DAY_OF_WEEK, 4);
    		Cal.get(5).set(Calendar.HOUR_OF_DAY, 17);
    		Cal.get(5).set(Calendar.MINUTE, 0);
    		Cal.get(5).set(Calendar.SECOND, 0);



    		//Set Calendar for C2 Slot
    		Cal.add(6, Calendar.getInstance());
    		Cal.get(6).set(Calendar.DAY_OF_WEEK, 4);
    		Cal.get(6).set(Calendar.HOUR_OF_DAY, 14);
    		Cal.get(6).set(Calendar.MINUTE, 0);
    		Cal.get(6).set(Calendar.SECOND, 0);

    		Cal.add(7, Calendar.getInstance());
    		Cal.get(7).set(Calendar.DAY_OF_WEEK, 2);
    		Cal.get(7).set(Calendar.HOUR_OF_DAY, 16);
    		Cal.get(7).set(Calendar.MINUTE, 0);
    		Cal.get(7).set(Calendar.SECOND, 0);

    		Cal.add(8, Calendar.getInstance());
    		Cal.get(8).set(Calendar.DAY_OF_WEEK, 5);
    		Cal.get(8).set(Calendar.HOUR_OF_DAY, 17);
    		Cal.get(8).set(Calendar.MINUTE, 0);
    		Cal.get(8).set(Calendar.SECOND, 0);

    		//TC2
    		Cal.add(9, Calendar.getInstance());
    		Cal.get(9).set(Calendar.DAY_OF_WEEK, 6);
    		Cal.get(9).set(Calendar.HOUR_OF_DAY, 18);
    		Cal.get(9).set(Calendar.MINUTE, 0);
    		Cal.get(9).set(Calendar.SECOND, 0);

    		//Set Calendar for D2 Slot
    		Cal.add(10, Calendar.getInstance());
    		Cal.get(10).set(Calendar.DAY_OF_WEEK, 5);
    		Cal.get(10).set(Calendar.HOUR_OF_DAY, 14);
    		Cal.get(10).set(Calendar.MINUTE, 0);
    		Cal.get(10).set(Calendar.SECOND, 0);

    		Cal.add(11, Calendar.getInstance());
    		Cal.get(11).set(Calendar.DAY_OF_WEEK, 3);
    		Cal.get(11).set(Calendar.HOUR_OF_DAY, 16);
    		Cal.get(11).set(Calendar.MINUTE, 0);
    		Cal.get(11).set(Calendar.SECOND, 0);


    		Cal.add(12, Calendar.getInstance());
    		Cal.get(12).set(Calendar.DAY_OF_WEEK, 6);
    		Cal.get(12).set(Calendar.HOUR_OF_DAY, 17);
    		Cal.get(12).set(Calendar.MINUTE, 0);
    		Cal.get(12).set(Calendar.SECOND, 0);


    		//TD2
    		Cal.add(13, Calendar.getInstance());
    		Cal.get(13).set(Calendar.DAY_OF_WEEK, 2);
    		Cal.get(13).set(Calendar.HOUR_OF_DAY, 18);
    		Cal.get(13).set(Calendar.MINUTE, 0);
    		Cal.get(13).set(Calendar.SECOND, 0);

    		//Set Calendar for E2 Slot

    		Cal.add(14, Calendar.getInstance());
    		Cal.get(14).set(Calendar.DAY_OF_WEEK, 6);
    		Cal.get(14).set(Calendar.HOUR_OF_DAY, 14);
    		Cal.get(14).set(Calendar.MINUTE, 0);
    		Cal.get(14).set(Calendar.SECOND, 0);


    		Cal.add(15, Calendar.getInstance());
    		Cal.get(15).set(Calendar.DAY_OF_WEEK, 4);
    		Cal.get(15).set(Calendar.HOUR_OF_DAY, 16);
    		Cal.get(15).set(Calendar.MINUTE, 0);
    		Cal.get(15).set(Calendar.SECOND, 0);

    		Cal.add(16, Calendar.getInstance());
    		Cal.get(16).set(Calendar.DAY_OF_WEEK, 2);
    		Cal.get(16).set(Calendar.HOUR_OF_DAY, 17);
    		Cal.get(16).set(Calendar.MINUTE, 0);
    		Cal.get(16).set(Calendar.SECOND, 0);


    		//TE2
    		Cal.add(17, Calendar.getInstance());
    		Cal.get(17).set(Calendar.DAY_OF_WEEK, 5);
    		Cal.get(17).set(Calendar.HOUR_OF_DAY, 18);
    		Cal.get(17).set(Calendar.MINUTE, 0);
    		Cal.get(17).set(Calendar.SECOND, 0);

    		//Set Calendar for F2 Slot
    		Cal.add(18, Calendar.getInstance());
    		Cal.get(18).set(Calendar.DAY_OF_WEEK, 2);
    		Cal.get(18).set(Calendar.HOUR_OF_DAY, 15);
    		Cal.get(18).set(Calendar.MINUTE, 0);
    		Cal.get(18).set(Calendar.SECOND, 0);

    		Cal.add(19, Calendar.getInstance());
    		Cal.get(19).set(Calendar.DAY_OF_WEEK, 4);
    		Cal.get(19).set(Calendar.HOUR_OF_DAY, 15);
    		Cal.get(19).set(Calendar.MINUTE, 0);
    		Cal.get(19).set(Calendar.SECOND, 0);

    		Cal.add(20, Calendar.getInstance());
    		Cal.get(20).set(Calendar.DAY_OF_WEEK, 5);
    		Cal.get(20).set(Calendar.HOUR_OF_DAY, 16);
    		Cal.get(20).set(Calendar.MINUTE, 0);
    		Cal.get(20).set(Calendar.SECOND, 0);

    		//TF2
    		Cal.add(21, Calendar.getInstance());
    		Cal.get(21).set(Calendar.DAY_OF_WEEK, 3);
    		Cal.get(21).set(Calendar.HOUR_OF_DAY, 18);
    		Cal.get(21).set(Calendar.MINUTE, 0);
    		Cal.get(21).set(Calendar.SECOND, 0);

    		//Set Calendar for G2 Slot
    		Cal.add(22, Calendar.getInstance());
    		Cal.get(22).set(Calendar.DAY_OF_WEEK, 3);
    		Cal.get(22).set(Calendar.HOUR_OF_DAY, 15);
    		Cal.get(22).set(Calendar.MINUTE, 0);
    		Cal.get(22).set(Calendar.SECOND, 0);

    		Cal.add(23, Calendar.getInstance());
    		Cal.get(23).set(Calendar.DAY_OF_WEEK, 6);
    		Cal.get(23).set(Calendar.HOUR_OF_DAY, 16);
    		Cal.get(23).set(Calendar.MINUTE, 0);
    		Cal.get(23).set(Calendar.SECOND, 0);

    		Cal.add(24, Calendar.getInstance());
    		Cal.get(24).set(Calendar.DAY_OF_WEEK, 4);
    		Cal.get(24).set(Calendar.HOUR_OF_DAY, 18);
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
  
    				//Toast.makeText(getActivity(), "A2", Toast.LENGTH_SHORT).show();
	
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

    		for(int i = 0; i < 14 ; i++){

    			if(l.get(i).isChecked()){
    				mPrefsEditor_m.putBoolean("evening"+i, true);
    				mPrefsEditor_m.apply();
    			}
    			else {
    				mPrefsEditor_m.putBoolean("evening"+i, false);
    				mPrefsEditor_m.apply();
    			}

    		}
    		getdata(arg0);

    	}
    }

     /////////////////////////// LABS ////////////////////////////////
    
    public static class LabSlots extends Fragment implements OnClickListener{

    	private ArrayList <Calendar> Cal= new ArrayList <Calendar>(60);
    	
    	private ArrayList <CheckBox> l= new ArrayList <CheckBox>(60);
    	
    	private ArrayList <Boolean> checkboxValue_lab = new ArrayList <Boolean>(60);
    	

        private SharedPreferences.Editor mPrefsEditor_l;
      




    	@Override
    	public View onCreateView(LayoutInflater inflater, ViewGroup container,
    			Bundle savedInstanceState) {
    		View rootView = inflater.inflate(R.layout.activity_labs, container, false);
    		addenable();

    		Log.d("inside fragment", "Layout set");

    		preferences = getActivity().getSharedPreferences("loginPrefs", MODE_PRIVATE);
            mPrefsEditor_l = preferences.edit();
    		// Demonstration of a collection-browsing activity.
    		rootView.findViewById(R.id.button1)
    		.setOnClickListener(new View.OnClickListener() {
    			@Override
    			public void onClick(View view) {
  	
    				Log.d("onClick", "Labs");
		
  	
    				
	
    				getdata(view);
	
      
    			}
    		});


    		



    		//new
    		//Initialise check boxes for every slot
    		for (int i = 101; i <= 160; i++) {
 			   String viewId = "checkBox" + i;
 			   l.add(i-101, (CheckBox) rootView.findViewById(getResources().getIdentifier(viewId, "id", getActivity().getPackageName())));
 			   checkboxValue_lab.add(i-101, preferences.getBoolean("lab"+(i-101), false));
 			   
 			   if (checkboxValue_lab.get(i-101) == true) {
 		           l.get(i-101).setChecked(true);}
 		       }

    		return rootView;


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


    	public void addenable(){

    	}
    	public void getdata(View V){

    		Log.d("Inside getdata", "inside getdata");

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
            setVibration.setClass(getActivity(), AlarmReciever.class);
            
            Intent setNormal = new Intent();
            setNormal.setClass(getActivity(), RingerMode.class);
         
            //PENDING INTENTS
            ArrayList <PendingIntent> Lab_V= new ArrayList <PendingIntent>(60);
            ArrayList <PendingIntent> Lab_N= new ArrayList <PendingIntent>(60);
            
            for(int i=0; i<60; i++)
            {
            	Lab_V.add(PendingIntent.getBroadcast(getActivity(), i, setVibration,
            			PendingIntent.FLAG_UPDATE_CURRENT));
            	Lab_N.add(PendingIntent.getBroadcast(getActivity(), i, setNormal,
            			PendingIntent.FLAG_UPDATE_CURRENT));
            }
     
            // create the object
            AlarmManager mAlarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
            
            for(int i=0; i<60; i++)
            {
           			if(l.get(i).isChecked()){
    				
    				 mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis(), 7*24*60*60*1000, Lab_V.get(i));
    		         mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Cal.get(i).getTimeInMillis()+59*60*1000+55*1000, 7*24*60*60*1000, Lab_N.get(i));
    		        
    		         //Toast.makeText(this, "L"+(i+1), Toast.LENGTH_SHORT).show();
                	}
            }


    			Toast.makeText(getActivity(), "SUBMITTED", Toast.LENGTH_LONG).show();

    	}

    	@Override
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


}




