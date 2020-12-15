package com.example.cpw252_todoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisplayToDoItemListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayToDoItemListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DisplayToDoItemListFragment() {
        // Required empty public constructor
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DisplayToDoItemListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DisplayToDoItemListFragment newInstance(String param1, String param2) {
        DisplayToDoItemListFragment fragment = new DisplayToDoItemListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ListView listView;
    private ArrayList<ToDoItem> toDoList = new ArrayList<>();
    private ArrayAdapter adapter;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_to_do_item_list, container, false);

        listView = (ListView) view.findViewById(R.id.to_do_list_view);

        adapter = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, toDoList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toDoList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    public void clearToDoList(){
        toDoList.clear();
        adapter.notifyDataSetChanged();
    }

    public void addToDoItemToList(ToDoItem item){
        toDoList.add(item);
        adapter.notifyDataSetChanged();
    }
}