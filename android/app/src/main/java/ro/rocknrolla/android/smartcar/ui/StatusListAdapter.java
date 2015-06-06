package ro.rocknrolla.android.smartcar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

import ro.rocknrolla.android.smartcar.R;
import ro.rocknrolla.common.SensorActualDataDTO;

public class StatusListAdapter extends ArrayAdapter<SensorActualDataDTO> {

    private Activity mContext;
    private int resource;
    private ViewHolder holder;

    private Configuration configuration;

    public StatusListAdapter(Activity context, int resource, List<SensorActualDataDTO> items) {
        super(context, resource, items);
        this.mContext = context;
        this.resource = resource;

        configuration = context.getResources().getConfiguration();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            //inflate the layout for each item of listview
            LayoutInflater inflate = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflate.inflate(resource, null);

            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        // get the current menu object
        final SensorActualDataDTO entity = getItem(position);
        if(null != entity) {
            holder.nameView.setText(entity.getName());

            if(entity.getStatus().equalsIgnoreCase("ok")) {
                holder.status.setBackgroundResource(R.color.pocket_color_1);
            } else if(entity.getStatus().equalsIgnoreCase("warning")) {
                holder.status.setBackgroundResource(R.color.pocket_color_4);
            } else {
                holder.status.setBackgroundResource(R.color.pocket_color_3);
            }
        }

        return view;
    }

    class ViewHolder
    {
        TextView nameView;
        RelativeLayout status;

        public ViewHolder(View row){
            nameView = (TextView) row.findViewById(R.id.entity_title);
            status = (RelativeLayout) row.findViewById(R.id.status);
        }
    }

}
