package jsondroid.android.com.demo2;

import android.support.v4.app.Fragment;

/**
 * Created by kingzhu on 16/11/8.
 * S/N 20161108102018518981171
 * Fragment之间通信接口
 */

public interface IFragmentNavigation {
    public void pushFragment(Fragment fragment);

    public void acswitchTab(int index);

    public void pop(Fragment fragment);
}
