package app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dhw.com.rikao07_retrofitrxjavamvpxrecyviewfresco.R;

/**
 * 购物车Fragment
 */
public class Cart_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_fragment, container, false);
        return view;
    }
}
