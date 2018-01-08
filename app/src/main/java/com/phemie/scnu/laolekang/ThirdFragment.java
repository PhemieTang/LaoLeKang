package com.phemie.scnu.laolekang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.phemie.scnu.laolekang.Health.HeartRate.HeartRateActivity;
import com.phemie.scnu.laolekang.Health.Step.StepActivity;


public class ThirdFragment extends Fragment implements View.OnClickListener{

    //
    private ImageView home_medicine;
    private ImageView home_health;
    private ImageView home_heartbeat;
    private ImageView home_foot;
    private ImageView home_call;

    MainActivity  mainActivity;

    //

    private View view;
    private ImageButton imageButton;
    public static String color;
    public ThirdFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_third, container, false);
        // Inflate the layout for this fragment

        initial();
        setClick();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"打开",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),Setting_Main.class);
                startActivity(intent);
            }
        });
        if(MainActivity.counter==0) {
            color = "blue";
        }
        return view;
    }

    public void onResume() {
        if(color.equals("red")) {
            view.setBackgroundResource(R.drawable.six_redbackground);
        }else if(color.equals("gray")){
            view.setBackgroundResource(R.drawable.six_graybackground);
        } else
        {
            view.setBackgroundResource(R.drawable.background);
        }
        Log.i("color",color);
        super.onResume();
    }//当ThirdFrament重新回到当前页面是调用
    public void onPause() {
        super.onPause();
    }//ThirdFragemt进栈时调用

    public void initial(){
        imageButton=(ImageButton)view.findViewById(R.id.ssetting);
        home_medicine=(ImageView)view.findViewById(R.id.home_medicine);
        home_heartbeat=(ImageView)view.findViewById(R.id.home_heartbeat);
        home_health=(ImageView)view.findViewById(R.id.home_health);
        home_foot=(ImageView)view.findViewById(R.id.home_foot);
        home_call=(ImageView)view.findViewById(R.id.home_call);

        mainActivity = (MainActivity) getActivity();
    }

    public void setClick(){
        home_health.setOnClickListener(this);
        home_heartbeat.setOnClickListener(this);
        home_medicine.setOnClickListener(this);
        home_foot.setOnClickListener(this);
        home_call.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.home_medicine:
                //mainActivity. gotoSecondFragment ();
                break;
            case R.id.home_heartbeat:
                Intent intent2=new Intent(getActivity(),HeartRateActivity.class);
                startActivity(intent2);
                break;
            case R.id.home_health:
                //mainActivity.gotoFourthtFragment();
                break;
            case R.id.home_foot:
                Intent intent3=new Intent(getActivity(),StepActivity.class);
                startActivity(intent3);
                break;
            case R.id.home_call:
                //mainActivity.gotoFifthFragment();
            default:
                break;
        }
    }
}
