package com.luis;
// The native Toast API
import android.widget.Toast;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Handler;

// importo aar de emilio
import com.alignet.api.payme.bean.*;
import com.alignet.api.payme.util.Constants;
import com.alignet.api.payme.wallet.models.EnvDomain;
import com.alignet.api.payme.wallet.pay.activities.PayActivity;
import android.content.Context;
import android.os.Bundle;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import android.content.Intent;

// importo del aar de prueba clase Persona
// import card.entel.testlibrary01.bean.Persona;


public class ToastyPlugin extends CordovaPlugin {

 private Context context=null;   //importa normal
 private CallbackContext callbackContext = null;
	
  @Override
  public boolean execute(String action, JSONArray args,final CallbackContext newcallbackContext) {
    
    if (!action.equals("show")) {
      callbackContext.error("\"" + action + "\" is not a recognized action.");
      return false;
    }else{
      
      String message;
      
      try {
        JSONObject options = args.getJSONObject(0);
        message = options.getString("message");
        
		this.cordova.getActivity().runOnUiThread(new Runnable(){
                public void run(){
                    try{
                        show(message);
                    }catch(Exception e){
                        callbackContext.error(e.getMessage());
                    }
                    
                }
         });
	
      } catch (JSONException e) {
        callbackContext.error("Error encountered: " + e.getMessage());
        return false;
      }
     
      PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
      callbackContext.sendPluginResult(pluginResult);
      return true;
    }
	
    
}
	
private final void show(String mensajito) throws JSONException {

	Toast toast1 = Toast.makeText(cordova.getActivity(), mensajito ,Toast.LENGTH_SHORT);
	toast1.show();
	
	}
}
