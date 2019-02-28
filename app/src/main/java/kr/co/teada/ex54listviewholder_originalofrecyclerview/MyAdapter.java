package kr.co.teada.ex54listviewholder_originalofrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<String> items;
    LayoutInflater inflater;

    public MyAdapter(ArrayList<String> items, LayoutInflater inflater) {
        this.items = items;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //최고 중요
        //1. create View
        if(convertView==null){ //재활용할 뷰가 없으면 만들어
            convertView=inflater.inflate(R.layout.list_item, parent,false);

            ViewHolder holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        //2. bind View
        String data=items.get(position);

        ViewHolder holder=(ViewHolder)convertView.getTag();
        holder.tv.setText(data);


        return convertView;
    }//end of getView method

    //3. inner class ------------------------------------------중요! 리사이클러 뷰
    class ViewHolder{

        TextView tv; //참조변수

        public  ViewHolder(View itemView){
            tv=itemView.findViewById(R.id.tv);

        }
    }

}//end of MyAdapter
