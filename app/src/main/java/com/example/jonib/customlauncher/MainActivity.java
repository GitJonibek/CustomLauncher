package com.example.jonib.customlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.jonib.customlauncher.adapter.HomescreenAdapter;
import com.example.jonib.customlauncher.adapter.RViewAdapter;
import com.example.jonib.customlauncher.model.AppInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    public static Context baseContext;
    private ImageButton apps_btn;
    private ViewPager pager;
    private HomescreenAdapter homescreenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseContext = this.getBaseContext();
        pager = findViewById(R.id.home_screen_pager);
        homescreenAdapter = new HomescreenAdapter(getSupportFragmentManager());
        pager.setAdapter(homescreenAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void appsButtonClicked(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public static Drawable getActivityIcon(Context context, String packageName, String activityName) {
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, activityName));
        ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);

        return resolveInfo.loadIcon(pm);
    }

}
