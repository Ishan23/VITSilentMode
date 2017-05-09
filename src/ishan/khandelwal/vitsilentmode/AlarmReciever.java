package ishan.khandelwal.vitsilentmode;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.util.Log;

public class AlarmReciever extends BroadcastReceiver
{
	private AudioManager mAudioManager;
	private SharedPreferences preferences;
	private Boolean enable;
	private Boolean vibration;
	
    @Override
            public void onReceive(Context context, Intent intent)
            {
                    // TODO Auto-generated method stub
    	
    		/*if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Intent serviceIntent = new Intent("ishan.khandelwal.vitsilentmode");
            context.startService(serviceIntent);
    		}   */
    		//Toast.makeText(context, "inside alarm reciever", Toast.LENGTH_LONG).show();
    	
    	    MainActivity2 mainActivity2 = new MainActivity2();
    		preferences = mainActivity2.getpref();
    		enable=preferences.getBoolean("enable", true);
    		vibration=preferences.getBoolean("vibration", true);
    		
    		//Toast.makeText(context, "preferences set", Toast.LENGTH_LONG).show();
    		
    		if(enable)
    		{
    			mAudioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
    			if(vibration)
    			{
    				mAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
    				//Toast.makeText(context, "Vibration Mode", Toast.LENGTH_LONG).show();
    			}
    			else
    			{
    				mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    				//Toast.makeText(context, "Silent Mode", Toast.LENGTH_LONG).show();
    			}
    			
    			Log.d("AlarmReciever", "enable=true");
    		}
    		else
    		{
    			Log.d("AlarmReciever", "enable=false");
    			//Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show();
    		}
               
            
                    
			// Show the toast
            //Toast.makeText(context, "Vibration Mode", Toast.LENGTH_SHORT).show();
                    
              }
}
