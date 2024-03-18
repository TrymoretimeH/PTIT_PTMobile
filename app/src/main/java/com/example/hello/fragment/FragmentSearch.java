package com.example.hello.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hello.AddActivity;
import com.example.hello.R;
import com.example.hello.adapter.RecycleViewAdapter;
import com.example.hello.dal.SQLiteHelper;
import com.example.hello.model.Item;

import java.util.Calendar;
import java.util.List;

public class FragmentSearch extends Fragment implements View.OnClickListener{
    private RecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private TextView tvTong;
    private Button btSearch;
    private SearchView searchView;
    private EditText eFrom, eTo;
    private Spinner spCategory;
    private SQLiteHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.sqlite_fragment_search,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        adapter = new RecycleViewAdapter();
        db = new SQLiteHelper(getContext());
        List<Item> list = db.getAll();
        adapter.setList(list);
        tvTong.setText("Tổng tiền: " + tong(list) + "K");
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                List<Item> list = db.searchByTitle(s);
                adapter.setList(list);
                tvTong.setText("Tổng tiền: " + tong(list) + "K");
                return true;
            }
        });
        eFrom.setOnClickListener(this);
        eTo.setOnClickListener(this);
        btSearch.setOnClickListener(this);
        spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int p, long l) {
                String cate = spCategory.getItemAtPosition(p).toString();
                List<Item> list;
                if (!cate.equalsIgnoreCase("All")) {
                    list = db.searchByCategory(cate);
                } else {
                    list = db.getAll();
                }
                adapter.setList(list);
                tvTong.setText("Tổng tiền: " + tong(list) + "K");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initView(View v) {
        recyclerView = v.findViewById(R.id.recycleView);
        tvTong = v.findViewById(R.id.tvTong);
        btSearch = v.findViewById(R.id.btSearch);
        searchView = v.findViewById(R.id.search);
        eFrom = v.findViewById(R.id.eFrom);
        eTo = v.findViewById(R.id.eTo);
        spCategory = v.findViewById(R.id.spCategory);
        String[] arr = getResources().getStringArray(R.array.category);
        String[] arr1 = new String[arr.length + 1];
        arr1[0] = "All";
        for (int i = 0; i < arr.length; i++) {
            arr1[i+1] = arr[i];
        }
        spCategory.setAdapter(new ArrayAdapter<String>(getContext(),
                R.layout.sqlite_item_spinner, arr1));

    }

    private int tong(List<Item> list) {
        int t = 0;
        for (Item i: list) {
            t += Integer.parseInt(i.getPrice());
        }
        return t;
    }

    @Override
    public void onClick(View view) {
        if (view == eFrom) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    String date = "";
                    if (m>8) {
                        date = d + "/" + (m+1) + "/" + y;
                    } else {
                        date = d + "/0" + (m+1) + "/" + y;
                    }
                    eFrom.setText(date);
                }
            }, year, month, day);
            dialog.show();
        }

        if (view == eTo) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    String date = "";
                    if (m>8) {
                        date = d + "/" + (m+1) + "/" + y;
                    } else {
                        date = d + "/0" + (m+1) + "/" + y;
                    }
                    eTo.setText(date);
                }
            }, year, month, day);
            dialog.show();
        }

        if (view == btSearch) {
            String from = eFrom.getText().toString();
            String to = eTo.getText().toString();
            if (!from.isEmpty() && !to.isEmpty()) {
                List<Item> list = db.searchByDateFromTo(from, to);
                adapter.setList(list);
                tvTong.setText("Tổng tiền: " + tong(list) + "K");
            }
        }
    }
}
