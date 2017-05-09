package ishan.khandelwal.vitsilentmode;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
//import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	//private CheckBox enable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//FULLSCREEN!!!
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
		
		setContentView(R.layout.activity_main);
		
		//enable=(CheckBox)findViewById(R.id.checkBox);
	
		
		
	}
	
	public void Getmorningslots(View v){
		Intent intent = new Intent();
		intent.setClass(this, MorningSlots.class);
		startActivity(intent);
	}
	
	public void Geteveningslots(View v){
		Intent intent2 = new Intent();
		intent2.setClass(this, EveningSlots.class);
		startActivity(intent2);
	}
	
	public void Labslots(View v){
		Intent intent3 = new Intent();
		intent3.setClass(this, Labs.class);
		startActivity(intent3);
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
			Toast.makeText(getApplicationContext(),"Sorry, no settings available right now",Toast.LENGTH_SHORT).show();
			return true;
		} else if (itemId == R.id.about) {
			Intent intent = new Intent();
			intent.setClass(this, About.class);
			startActivity(intent);
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}  
	

	}
}
