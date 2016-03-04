package chrisjyoon.library;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by chris on 2016. 3. 4..
 *
 */
public class DeviceUtil {
    private Context mContext;
    private static DeviceUtil sDeviceUtil;

    public static DeviceUtil getInstance(Context context) {
        if (sDeviceUtil == null) {
            sDeviceUtil = new DeviceUtil(context);
        }
        return sDeviceUtil;
    }

    public DeviceUtil(Context context) {
        mContext = context;
    }

    public int getNavBarHeight() {
        Resources resources = mContext.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }
        return 0;
    }

}
