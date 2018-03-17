package com.example.jonib.customlauncher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jonib.customlauncher.adapter.RViewAdapter;
import com.example.jonib.customlauncher.model.AppInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RViewAdapter r_adapter;
    List<AppInfo> appsList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.r_view);
        r_adapter = new RViewAdapter(this);
        recyclerView.setAdapter(r_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new MyThread().execute();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public class MyThread extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... Params) {

            PackageManager pm = getPackageManager();
            appsList = new ArrayList<>();

            Intent i = new Intent(Intent.ACTION_MAIN, null);
            i.addCategory(Intent.CATEGORY_LAUNCHER);

            List<ResolveInfo> allApps = pm.queryIntentActivities(i, 0);
            for(ResolveInfo ri:allApps) {
                AppInfo app = new AppInfo();
                app.label = (String) ri.loadLabel(pm);
                app.package_name = ri.activityInfo.packageName;
                app.icon = ri.activityInfo.loadIcon(pm);
                r_adapter.addApp(app);
            }
            return "Success";

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            updateStuff();
        }

        public void updateStuff() {
            r_adapter.notifyItemInserted(r_adapter.getItemCount()-1);
        }

    }

}
