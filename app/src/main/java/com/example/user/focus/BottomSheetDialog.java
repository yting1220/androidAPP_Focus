package com.example.user.focus;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BottomSheetDialog extends BottomSheetDialogFragment{
    private BottomSheetListener mListener;
    private Button b1,b2,b3,b4,b5,b6;
    static int starN = 0;
    int c=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        //判斷碎片數量>星球價格，並依據選擇的星球button傳送對應編號至p5
        b1 = v.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(starN >= 5){
                    c=1;
                    starN-=5;
                    page5_universe.starSub(starN);
                    page5_universe.getChoose(c);
                    startActivity(new Intent(getActivity(),page5_universe.class));
                }
                else {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("!!")
                            .setMessage("碎片數量不足!!")
                            .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
            }
        });

        b2 = v.findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(starN >= 10) {
                    c=2;
                    starN-=10;
                    page5_universe.starSub(starN);
                    page5_universe.getChoose(c);
                    startActivity(new Intent(getActivity(),page5_universe.class));
                }
                else {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("!!")
                            .setMessage("碎片數量不足!!")
                            .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
            }
        });

        b3 = v.findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(starN >= 20) {
                    c=3;
                    starN-=20;
                    page5_universe.starSub(starN);
                    page5_universe.getChoose(c);
                    startActivity(new Intent(getActivity(),page5_universe.class));
                }
                else {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("!!")
                            .setMessage("碎片數量不足!!")
                            .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
            }
        });

        b4 = v.findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(starN >= 30) {
                    c=4;
                    starN-=30;
                    page5_universe.starSub(starN);
                    page5_universe.getChoose(c);
                    startActivity(new Intent(getActivity(),page5_universe.class));
                }
                else {
                        new AlertDialog.Builder(getActivity())
                                .setTitle("!!")
                                .setMessage("碎片數量不足!!")
                                .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                })
                                .show();
                    }
            }
        });

        b5 = v.findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(starN >= 40) {
                    c=5;
                    starN-=40;
                    page5_universe.starSub(starN);
                    page5_universe.getChoose(c);
                    startActivity(new Intent(getActivity(),page5_universe.class));
                }
                else {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("!!")
                            .setMessage("碎片數量不足!!")
                            .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
            }
        });

        b6 = v.findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(starN >= 50) {
                    c=6;
                    starN-=50;
                    page5_universe.starSub(starN);
                    page5_universe.getChoose(c);
                    startActivity(new Intent(getActivity(),page5_universe.class));
                }
                else {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("!!")
                            .setMessage("碎片數量不足!!")
                            .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
            }
        });
        return v;
    }

    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (BottomSheetListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement BottomSheetListener");
        }
    }

    //從p5_universe取得目前碎片數量
    public static void getStarCount(int star_p5) {
        starN = star_p5;
    }
}
