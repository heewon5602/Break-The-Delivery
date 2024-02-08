//data와 listview 사이를 연결해주는 역할
package com.example.breakthedelivery;

import android.content.Context;
import android.view.LayoutInflater;
import java.util.ArrayList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class CustomerParticipateStatusAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<String> arrayParticipateRoom;
    private ViewHolder viewHolder;

    public CustomerParticipateStatusAdapter(Context context, ArrayList<String> arrayParticipateRoom) {
        this.context = context;
        this.arrayParticipateRoom = arrayParticipateRoom;

    }

    @Override
    public int getCount() {
        return arrayParticipateRoom.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayParticipateRoom.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ViewHoldr 패턴
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.arrayParticipateRoom, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } 
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        
        // View에 Data 세팅
        viewHolder.txtStorename.setText(arrayParticipateRoom.get(position));
        viewHolder.txtOrderTime.setText(arrayParticipateRoom.get(position));
        viewHolder.txtNumber.setText(arrayParticipateRoom.get(position));
        viewHolder.txtTotalNumber.setText(arrayParticipateRoom.get(position));
        viewHolder.btnParticipatr
        return convertView;
    }
    
    public class ViewHolder {
        private TextView txtStorename; //가게 이름
        private TextView txtOrderTime; //주문 시간
        private TextView txtNumber; //참여 인원
        private TextView txtTotalNumber; //생성자가 설정한 총 참여 가능 인원 수
        private Button btnParticipate; //참여 버튼
        public ViewHolder(View convertView) {
            txtStorename = (TextView) convertView.findViewById(R.id.txtStorename); //가게 이름
            txtOrderTime = (TextView)convertView.findViewById(R.id.OrderTime); //주문할 시간
            txtNumber = (TextView)convertView.findViewById(R.id.Number); //현재 참여된 인원 수
            txtTotalNumber = (TextView)convertView.findViewById(R.id.TotalNumber); //모집할 인원 수
            btnParticipate = (Button)convertView.findViewById(R.id.btnParticipate); //참여 버튼

        }

    }

}
