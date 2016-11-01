/**
 * (C) 2016. Darren Kong [All rights reserved]. This product and related documentation are protected by
 * copyright restricting its use, copying, distribution, and decompilation. No part of this product or related
 * documentation may be reproduced in any form by any means without prior written authorization of Darren Kong
 * . Unless otherwise arranged, third parties may not have access to this product or related documents.
 */

package au.com.darrenkong.earthquakes.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import au.com.darrenkong.earthquakes.adapter.EarthquakesAdapter.EarthquakeViewHolder;
import au.com.darrenkong.earthquakes.model.Earthquakes.Earthquake;
import au.com.darrenkong.earthquakes.R;
import butterknife.BindView;

import static butterknife.ButterKnife.bind;

/**
 * Created by dkong on 1/11/2016.
 */
public class EarthquakesAdapter
        extends RecyclerView.Adapter<EarthquakeViewHolder> {

    private List<Earthquake> mEarthquakes = new ArrayList<>();
    private LayoutInflater mInflater;

    public EarthquakesAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_earthquake, parent, false);
        return new EarthquakeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EarthquakeViewHolder holder, int position) {

        Earthquake eq = mEarthquakes.get(position);

        holder.source.setText(eq.src);
        holder.eqid.setText(eq.eqid);
        holder.timedate.setText(eq.timedate);
        holder.lat.setText(eq.lat);
        holder.lon.setText(eq.lon);
        holder.magnitude.setText(eq.magnitude);
        holder.depth.setText(eq.depth);
        holder.region.setText(eq.region);
    }

    @Override
    public int getItemCount() {
        return mEarthquakes.size();
    }

    public void setItems(List<Earthquake> items) {
        mEarthquakes = items;
        notifyDataSetChanged();
    }

    public class EarthquakeViewHolder
            extends RecyclerView.ViewHolder {

        @BindView(R.id.source)
        TextView source;

        @BindView(R.id.eqid)
        TextView eqid;

        @BindView(R.id.timedate)
        TextView timedate;

        @BindView(R.id.lat)
        TextView lat;

        @BindView(R.id.lon)
        TextView lon;

        @BindView(R.id.magnitude)
        TextView magnitude;

        @BindView(R.id.depth)
        TextView depth;

        @BindView(R.id.region)
        TextView region;

        public EarthquakeViewHolder(View itemView) {
            super(itemView);
            bind(this, itemView);
        }
    }
}
