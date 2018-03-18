package com.example.jonib.customlauncher.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jonib.customlauncher.MainActivity;
import com.example.jonib.customlauncher.R;

public class Homescreen extends Fragment implements View.OnClickListener{

    public Homescreen() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_homescreen, container, false);
        ImageView icon = v.findViewById(R.id.icon);
        icon.setImageDrawable(MainActivity.getActivityIcon(this.getContext(),
                "com.android.chrome", "com.google.android.apps.chrome.Main"));
        icon.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.icon:
                Intent launchIntent = MainActivity.baseContext.
                        getPackageManager().
                        getLaunchIntentForPackage("com.android.chrome");
                startActivity(launchIntent);
                break;
        }

    }

}
