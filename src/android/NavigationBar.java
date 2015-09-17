import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaArgs;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.provider.Settings;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NavigationBar extends CordovaPlugin {
public static final String TAG = "Navigation Bar Plugin";
/**
 * Constructor.
 */
public NavigationBar() {
}
/**
 * Sets the context of the Command. This can then be used to do things like
 * get file paths associated with the Activity.
 *
 * @param cordova The context of the main Activity.
 * @param webView The CordovaWebView Cordova is running in.
 */
public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.v(TAG,"Init NavigationBarPlugin");
}

public boolean execute(final String action, final CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        Log.v(TAG,"NavigationBarPlugin received:"+ action);

        if("backgroundColorByHexString".equals(action)) {
                cordova.getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                        try {
                                                setNavigationBarBackgroundColor(args.getString(0));
                                        } catch (JSONException ignore) {
                                                Log.e(TAG, "Invalid hexString argument, use f.i. '#777777'");
                                        }
                                }
                        });
        }
        return true;
}

private void setNavigationBarBackgroundColor(final String colorPref) {
        if (Build.VERSION.SDK_INT >= 21) {
                if (colorPref != null && !colorPref.isEmpty()) {
                        final Window window = cordova.getActivity().getWindow();
                        // Method and constants not available on all SDKs but we want to be able to compile this code with any SDK
                        window.clearFlags(0x04000000); // SDK 19: WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.addFlags(0x80000000); // SDK 21: WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        try {
                                // Using reflection makes sure any 5.0+ device will work without having to compile with SDK level 21
                                window.getClass().getDeclaredMethod("setNavigationBarColor", int.class).invoke(window, Color.parseColor(colorPref));
                        } catch (IllegalArgumentException ignore) {
                                Log.e(TAG, "Invalid hexString argument, use f.i. '#999999'");
                        } catch (Exception ignore) {
                                // this should not happen, only in case Android removes this method in a version > 21
                                Log.w(TAG, "Method window.setNavigationBarColor not found for SDK level " + Build.VERSION.SDK_INT);
                        }
                }
        }
}

}
