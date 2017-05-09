package ishan.khandelwal.vitsilentmode;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
//import android.widget.Toast;
import android.util.Log;

public class RingerMode extends BroadcastReceiver
{
	private AudioManager mAudioManager;
	private SharedPreferences preferences;
	private Boolean enable;
	
         @Override
            public void onReceive(Context context, Intent intent)
            {
                    // TODO Auto-generated method stub
        	/* if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
                 Intent serviceIntent = new Intent("com.myapp.NotifyService");
                 context.startService(serviceIntent);
        	 }*/
        	 //Toast.makeText(context, "inside ringer reciever", Toast.LENGTH_LONG).show();
                
        	 MainActivity2 mainActivity2 = new MainActivity2();
     		 preferences = mainActivity2.getpref();
        	 enable=preferences.getBoolean("enable", true);
        	 
        	 //Toast.makeText(context, "preferences set", Toast.LENGTH_LONG).show();
     		
     		if(enable)
     		{
     			mAudioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
     			mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
     			Log.d("RingerMode", "enable=true");
     			//Toast.makeText(context, "Ringer Mode", Toast.LENGTH_LONG).show();
     		}
     		else
     		{
     			Log.d("RingerMode", "enable=false");
     			
     		}
			
			// Show the toast
            //Toast.makeText(context, "Normal Mode", Toast.LENGTH_LONG).show();
                   
             }
}
