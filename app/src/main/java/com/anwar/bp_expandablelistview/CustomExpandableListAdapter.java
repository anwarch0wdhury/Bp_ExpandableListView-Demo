package com.anwar.bp_expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listTotal;
    private HashMap<String, Information> expandableListDetails;

    public CustomExpandableListAdapter(Context context,
                                       List<String> listTotal,
                                       HashMap<String, Information> expandableListDetails) {
        this.context = context;
        this.listTotal = listTotal;
        this.expandableListDetails = expandableListDetails;
    }


    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final Information information = (Information) getChild(groupPosition, childPosition);

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.list_item, null);

        }



        TextView tvmodelname= convertView.findViewById( R.id.tvmodelname );
        TextView tvdate= convertView.findViewById( R.id.tvDate );
        TextView tvimei= convertView.findViewById( R.id.tvImei );

        tvmodelname.setText(  information.getModel() );
        tvdate.setText(  information.getDate() );
        tvimei.setText(  information.getImei() );

        return convertView;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        ImageView imageView;

        String name = (String) getGroup(groupPosition);
        Information information = (Information) getChild(groupPosition,0);

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.list_group, null);

        }
        imageView = convertView.findViewById(R.id.plusminus);
        if (isExpanded){

            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.minus));
        }
        else {
            imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.plus));
        }

        TextView txtName = convertView.findViewById(R.id.txtGroupName);
        TextView txtphonenumber = convertView.findViewById(R.id.txtGroupPhoneNumber);

        txtName.setText(name);
        txtphonenumber.setText(information.getNum());


        return convertView;
    }


    @Override
    public int getGroupCount() {
        return this.listTotal.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listTotal.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.expandableListDetails.get(this.listTotal.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
