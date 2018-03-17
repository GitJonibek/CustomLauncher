package com.example.jonib.customlauncher.adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonib.customlauncher.R;
import com.example.jonib.customlauncher.model.AppInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonib on 3/17/2018.
 */

public class RViewAdapter extends RecyclerView.Adapter<RViewAdapter.ViewHolder> {

    private List<AppInfo> appsList;

    public void addApp(AppInfo app) {
        appsList.add(app);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title, package_name;
        public ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_of_app);
            package_name = itemView.findViewById(R.id.package_name);
            img = itemView.findViewById(R.id.img_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick (View v) {
            int pos = getAdapterPosition();
            Context context = v.getContext();

            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(appsList.get(pos).package_name.toString());
            context.startActivity(launchIntent);
            Toast.makeText(v.getContext(), appsList.get(pos).label.toString(), Toast.LENGTH_LONG).show();

        }
    }

    public RViewAdapter(Context c) {
        appsList = new ArrayList<AppInfo>();
    }

    @Override
    public int getItemCount() {
        return appsList.size();
    }


    @Override
    public RViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.raw_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        String appLabel = appsList.get(i).label.toString();
        String appPackage = appsList.get(i).package_name.toString();
        Drawable appIcon = appsList.get(i).icon;

        TextView title = holder.title;
        TextView package_name = holder.package_name;
        ImageView imageView = holder.img;

        title.setText(appLabel);
        package_name.setText(appPackage);
        imageView.setImageDrawable(appIcon);

    }

}
