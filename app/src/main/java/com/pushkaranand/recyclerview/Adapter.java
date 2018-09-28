package com.pushkaranand.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v7.recyclerview.R.styleable.RecyclerView;


//import static com.pushkaranand.recyclerview.R.styleable.RecyclerView;

/**
 * Created by Pushkar on 15-Jun-17.
 */

public class Adapter extends RecyclerView.Adapter <Adapter.StudentViewHolder>{

    ArrayList<Data> dataArrayList;
    Context context;

    public Adapter(ArrayList<Data> dataArrayList, Context context) {
        this.dataArrayList = dataArrayList;
        this.context = context;
    }

    /** Used for multiple layouts*/
    @Override
    public int getItemViewType(int position) {

        Data thisData = dataArrayList.get(position);
        if(thisData.getCourse().equals("Pandora")){
            return 0;
        }
        else
            return 1;

    }

    // This function is called only when the activity is first created not when views are recycled
    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layoutType;
        if(viewType == 0){
            layoutType = R.layout.list_item_data;
        }
        else
            layoutType = R.layout.list_item_data_1;

        LayoutInflater l = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = l.inflate(layoutType,parent,false);
        StudentViewHolder studentViewHolder = new StudentViewHolder(itemView);

        return studentViewHolder;
    }

    // This function is called every time.
    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {

        Data thisData = dataArrayList.get(position);

        holder.tvName.setText(thisData.getName());
        holder.tvCourse.setText(thisData.getCourse());

    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvCourse;
        public StudentViewHolder(View itemView) {
            super(itemView);
            tvName =  (TextView)itemView.findViewById(R.id.tv_name);
            tvCourse =  (TextView)itemView.findViewById(R.id.tv_course);

        }
    }
}
