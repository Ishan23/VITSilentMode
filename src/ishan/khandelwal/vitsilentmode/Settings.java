package ishan.khandelwal.vitsilentmode;




import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;



public class Settings extends Activity implements OnCheckedChangeListener {
	
	Switch mSwitch;
	CheckBox select;
	CheckBox silent;
	private SharedPreferences mSharedPreferences;
	private SharedPreferences.Editor mPrefsEditor;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		final MainActivity2 mainActivity2 = new MainActivity2();
		mSharedPreferences=mainActivity2.getpref();
		mPrefsEditor = mSharedPreferences.edit();
        mSharedPreferences.getBoolean("enable", true);
         
        
		mSwitch=(Switch) findViewById(R.id.switch1);
		mSwitch.setChecked(mSharedPreferences.getBoolean("enable", true));
		
		select=(CheckBox) findViewById(R.id.checkBox1);
		select.setChecked(mSharedPreferences.getBoolean("vibration", true));
		
		silent=(CheckBox) findViewById(R.id.checkBox2);
		silent.setChecked(mSharedPreferences.getBoolean("silent", false));
		
		 if(mSharedPreferences.getBoolean("enable", true))
	        {
	        	select.setClickable(true);
				silent.setClickable(true);
				select.setEnabled(true);
				silent.setEnabled(true);
	        }
	        else
	        {
	        	select.setClickable(false);
				silent.setClickable(false);
				select.setEnabled(false);
				silent.setEnabled(false);
	        }
			
		
		mSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				
				if (isChecked)
				{
					select.setClickable(true);
					silent.setClickable(true);
					select.setEnabled(true);
					silent.setEnabled(true);
					
					mPrefsEditor.putBoolean("enable", true);
					mPrefsEditor.apply();
					Toast.makeText(getApplicationContext(), "App Enabled", Toast.LENGTH_SHORT).show();
				}
				else
				{
					select.setClickable(false);
					silent.setClickable(false);
					select.setEnabled(false);
					silent.setEnabled(false);
					
				
					mPrefsEditor.putBoolean("enable", false);
					mPrefsEditor.apply();					
					Toast.makeText(getApplicationContext(), "App Disabled", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		select.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
				{
					silent.setChecked(false);
					mPrefsEditor.putBoolean("silent", false);
					mPrefsEditor.apply();
					mPrefsEditor.putBoolean("vibration", true);
					mPrefsEditor.apply();
					Toast.makeText(getApplicationContext(), "Vibration Mode", Toast.LENGTH_SHORT).show();
				}
				else
				{
					silent.setChecked(true);
					mPrefsEditor.putBoolean("silent", true);
					mPrefsEditor.apply();
					mPrefsEditor.putBoolean("vibration", false);
					mPrefsEditor.apply();					
					Toast.makeText(getApplicationContext(), "Silent Mode", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
		silent.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
				{
					select.setChecked(false);
					mPrefsEditor.putBoolean("silent", true);
					mPrefsEditor.apply();
					mPrefsEditor.putBoolean("vibration", false);
					mPrefsEditor.apply();
					Toast.makeText(getApplicationContext(), "Silent Mode", Toast.LENGTH_SHORT).show();
				}
				else
				{
					select.setChecked(true);
					mPrefsEditor.putBoolean("silent", false);
					mPrefsEditor.apply();
					mPrefsEditor.putBoolean("vibration", true);
					mPrefsEditor.apply();					
					Toast.makeText(getApplicationContext(), "Vibration Mode", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

		// TODO Auto-generated method stub
		
	}
	

	
}
