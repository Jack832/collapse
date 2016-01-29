package com.bridgelabz.com.appscreen;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cocosw.bottomsheet.BottomSheet;
import com.flipboard.bottomsheet.BottomSheetLayout;

import java.util.Collections;
import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;
import static android.support.v4.app.ActivityCompat.startActivityForResult;
import static android.support.v4.content.ContextCompat.startActivities;

/**
 * Created by bridgelabz3 on 22/1/16.
 */
public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<MyData> data = Collections.emptyList();
    Context context;
    BottomSheetLayout bottomSheet;

    public ViewAdapter(Context context, List<MyData> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final MyData current = data.get(position);
        holder.mainTitle.setText(current.mainTitle);
        holder.statusTitle.setText(current.statusTitle);
        holder.parttitle.setText(current.partTitle);
        holder.timeTitle.setText(current.timeTitle);
        holder.viewTitle.setText(current.viewTitle);

        holder.mainIcon.setImageResource(current.mainIcon);
        holder.shareIcon.setImageResource(current.shareIcon);

        holder.mainIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, demo.class);
                intent.putExtra("Bitmap", current.mainIcon);
                intent.putExtra("Title", current.mainTitle);
                v.getContext().startActivity(intent);
                //context.startActivity(new Intent(context, MediaDemo.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mainTitle, statusTitle, timeTitle, viewTitle, parttitle;
        ImageView mainIcon, shareIcon;

        public MyViewHolder(final View itemView) {
            super(itemView);

            mainTitle = (TextView) itemView.findViewById(R.id.mainTitle);
            statusTitle = (TextView) itemView.findViewById(R.id.statusTitle);
            timeTitle = (TextView) itemView.findViewById(R.id.timeTitle);
            viewTitle = (TextView) itemView.findViewById(R.id.viewTitle);
            parttitle = (TextView) itemView.findViewById(R.id.partTitle);

            mainIcon = (ImageView) itemView.findViewById(R.id.mainIcon);
            shareIcon = (ImageView) itemView.findViewById(R.id.shareIcon);

            bottomSheet = (BottomSheetLayout) itemView.findViewById(R.id.bottomSheet);

            shareIcon.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    new BottomSheet.Builder((Activity) context)
                            .sheet(R.menu.share)
                            .listener(new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which) {
                                        case R.id.Content_Info:
                                            Toast.makeText(context, "Info", Toast.LENGTH_SHORT).show();
                                            break;
                                    }
                                }
                            }).show();
                    return true;
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    new BottomSheet.Builder((Activity) context)
                            .sheet(R.menu.list)
                            .listener(new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which) {
                                        case R.id.Content_Info:
                                            Toast.makeText(context, "Info", Toast.LENGTH_SHORT).show();
                                            break;
                                    }
                                }
                            }).show();
                    return true;
                }
            });



//            mainTitle.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    context.startActivity(new Intent(context,AllMedia.class));
//                }
//            });
        }
    }
}