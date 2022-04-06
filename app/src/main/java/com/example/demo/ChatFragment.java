package com.example.demo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {
    ImageView img1, calander, clock;

    String[] name = {"jay", "Namis", "Ketan", "Monil", "Piyush", "Mayank", "Ajay", "Dhruvik", "Ronak", "Arshil", "harsh", "Abhishek", "Rohit", "Raj", "Nirav"};
    String[] surname = {"Khunt", "Sorathiya", "Malviya", "Khunt", "Rudani", "Rathod", "Rakholiya", "Rajpra", "Vasoya", "Talaviya", "Khunt", "Meghani", "Kothiya", "Desai", "Nathi"};
    int[] img = {R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4, R.drawable.i5, R.drawable.i6, R.drawable.i7, R.drawable.i8, R.drawable.i9, R.drawable.i10, R.drawable.i11, R.drawable.i12, R.drawable.i13, R.drawable.i14, R.drawable.i15};


    List<data> modelList = new ArrayList<>();
    private static final String TAG = "DataFragment";
    RecyclerView lists;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_chat, container, false);

        lists=view.findViewById(R.id.lists);




        for (int i=0 ; i< name.length; i++){

            data model = new data(name[i],surname[i],img[i]);
            modelList.add(model);
        }


        GridLayoutManager manager=new GridLayoutManager(getActivity(),1,GridLayoutManager.VERTICAL,false);
        RecycleAdapter adapter=new RecycleAdapter(getActivity(),modelList);
        lists.setLayoutManager(manager);
        lists.setAdapter(adapter);
        return view;

    }
}