package ishan.khandelwal.vitsilentmode;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AutoStart1 extends BroadcastReceiver 
{

	
	 @Override
	    public void onReceive(Context context, Intent intent) {
	        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
	            //Intent serviceIntent = new Intent("com.myapp.NotifyService");
	            //context.startService(serviceIntent);
	       
	        	Log.i("Autostart", "test");
	        	
	        	Intent intent2 = new Intent();
	        	intent2.setClass(context, AlarmReciever.class);
	        
	        }
	    }
}