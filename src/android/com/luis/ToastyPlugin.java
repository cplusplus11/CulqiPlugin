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
     callbackContext = newcallbackContext;
    
	
    if (action.equals("show")) {
      callbackContext.error("\"" + action + "\" is not a recognized action.");
      
	    this.cordova.getActivity().runOnUiThread(new Runnable(){
                public void run(){
                    try{
                        show(args.getJSONObject(0));
                    }catch(Exception e){
                        callbackContext.error(e.getMessage());
                    }
                    
                }
            });
	    
	    
	    return true;
    }
      
     /*PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
      callbackContext.sendPluginResult(pluginResult);
      return true; */
	  
	PluginResult pluginResult = new  PluginResult(PluginResult.Status.NO_RESULT);
        pluginResult.setKeepCallback(true);
        return false;  
    
}
	
private final void show(final JSONObject params) throws JSONException {
	String message;
      String duration;
	
      try {
        JSONObject options = args.getJSONObject(0);
        message = options.getString("message");
        //duration = options.getString("duration");
      } catch (JSONException e) {
        callbackContext.error("Error encountered: " + e.getMessage());
        return false;
      }
      
	//Persona per = new Persona("Luis", "Huasacca");
	//Toast toast1 = Toast.makeText(cordova.getActivity(), per.getName() + per.getLastname(),Toast.LENGTH_SHORT);
     	//toast1.show(); 
	    
        
        //intent.putExtra(Constants.PAYME_BUNDLE,bundle);        
        //this.cordova.startActivityForResult((CordovaPlugin) this,intent, "Hola");	
	
	String URL = "2";    
	Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_MERCHANT_ENVDOMAIN, URL);
        //bundle.putParcelable(Constants.EXTRA_MERCHANT_OPERATION, merchantOperation);
        bundle.putBoolean(Constants.EXTRA_ENABLED_MPOS, false);    
	   
	//context=cordova.getActivity().getApplicationContext();
	    
	// Intent intent = new Intent(context, PayActivity.class);
	// intent.putExtra(Constants.PAYME_BUNDLE,bundle);        
	    
	//this.cordova.startActivityForResult((CordovaPlugin) this,intent, Constants.REQUEST_CODE_PAYME);  
	//this.cordova.startActivityForResult((CordovaPlugin) this,intent, 0);   
     	Toast toast1 = Toast.makeText(cordova.getActivity(), "alberto thread",Toast.LENGTH_SHORT);
	toast1.show();
	}
	
}
