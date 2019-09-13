package com.luis.cordova.plugin;
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

// importo del aar
// import card.entel.testlibrary01.*;

public class ToastyPlugin extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args,final CallbackContext callbackContext) {
     
    if (!action.equals("show")) {
      callbackContext.error("\"" + action + "\" is not a recognized action.");
      return false;
    }else{
      
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
	
	    
        //Intent intent = new Intent(context, MainActivity.class);
        //intent.putExtra(Constants.PAYME_BUNDLE,bundle);        
        //this.cordova.startActivityForResult((CordovaPlugin) this,intent, "Hola");	    
	    
     Toast toast1 = Toast.makeText(cordova.getActivity(), message,Toast.LENGTH_SHORT);
	//Toast toast1 = Toast.makeText(cordova.getActivity(), per.getName() + per.getLastname(),Toast.LENGTH_SHORT);
     toast1.show(); 
      
      PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
      callbackContext.sendPluginResult(pluginResult);
      return true;
    }
}
	
  
     
}
