package com.example.kimdaehan.database_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListArrayAdapter extends ArrayAdapter<ContactData>
{
    private ViewHolder mViewHolder = null;
    private LayoutInflater mInflater	= null;

    class ViewHolder
    {
        public TextView name = null;
        public TextView make = null;
        public TextView buy	= null;
        public TextView open = null;
        public TextView store = null;
        public TextView num	= null;

    }

    public ListArrayAdapter(Context aContext, int aResource,
                            List<ContactData> aCData)
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
            v = mInflater.inflate(R.layout.list_item, null);
            mViewHolder.name = (TextView)
                    v.findViewById(R.id.name);
            mViewHolder.make = (TextView)
                    v.findViewById(R.id.make);
            mViewHolder.buy = (TextView)
                    v.findViewById(R.id.buy);
            mViewHolder.open = (TextView)
                    v.findViewById(R.id.open);
            mViewHolder.store = (TextView)
                    v.findViewById(R.id.store);
            mViewHolder.num = (TextView)
                    v.findViewById(R.id.num);

            v.setTag(mViewHolder);
        }
        else
        {
            mViewHolder = (ViewHolder)v.getTag();
        }

        mViewHolder.name.setText(getItem(position).getName());
        mViewHolder.make.setText(getItem(position).getMake());
        mViewHolder.buy.setText(getItem(position).getBuy());
        mViewHolder.open.setText(getItem(position).getOpen());
        mViewHolder.store.setText(getItem(position).getStore());
        mViewHolder.num.setText(getItem(position).getNum());

        return v;
    }

    @Override
    public int getCount()
    {
        return super.getCount();
    }

    @Override
    public ContactData getItem(int position)
    {
        return super.getItem(position);
    }
}