package com.example.kimdaehan.database_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListArrayAdapter2 extends ArrayAdapter<ContactData2>
{
    private ViewHolder mViewHolder = null;
    private LayoutInflater mInflater	= null;

    class ViewHolder
    {
        public TextView name = null;
        public TextView fff = null;
        public TextView care	= null;

    }

    public ListArrayAdapter2(Context aContext, int aResource,
                            List<ContactData2> aCData)
    {
        super(aContext, aResource, aCData);

        this.mInflater = (LayoutInflater)
                aContext.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertview,
                        ViewGroup parent)
    {
        View v = convertview;

        if(v == null)
        {
            mViewHolder = new ViewHolder();

            v = mInflater.inflate(R.layout.item_status, null);
            mViewHolder.name = (TextView)
                    v.findViewById(R.id.name1);
            mViewHolder.fff = (TextView)
                    v.findViewById(R.id.fff);
            mViewHolder.care = (TextView)
                    v.findViewById(R.id.care);
            v.setTag(mViewHolder);
        }
        else
        {
            mViewHolder = (ViewHolder)v.getTag();
        }

        mViewHolder.name.setText(getItem(position).getName());
        mViewHolder.fff.setText(getItem(position).getFff());
        mViewHolder.care.setText(getItem(position).getCare());

        return v;
    }

    @Override
    public int getCount()
    {
        return super.getCount();
    }

    @Override
    public ContactData2 getItem(int position)
    {
        return super.getItem(position);
    }
}