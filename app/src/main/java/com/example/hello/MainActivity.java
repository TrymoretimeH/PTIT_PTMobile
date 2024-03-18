package com.example.hello;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello.adapter.ViewPagerAdapter;
import com.example.hello.model.Account;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

//    private EditText usernameEditText, passwordEditText;
//    private Button loginButton;
//
//    private EditText num1, num2;
//    private Button handleButton;
//    private TextView result;
//    private Spinner choice_menu;
//    private String itemSelected;
//
//    private Button showDatePickerButton;
//
//    private ListView listView;
//    private Integer img_ids[] = {
//            R.drawable.meo,
//            R.drawable.xe1
//    };

//    imgs for kt2
//    private Integer img_ids_kt2[] = {
//            R.drawable.motorbike,
//            R.drawable.car
//    };
//    private DatePicker startDatePicker, endDatePicker;
//    private ListView listViewKt2;

//    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
//        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//            parent.getItemAtPosition(pos);
//        }
//
//        public void onNothingSelected(AdapterView<?> parent) {}
//
//    }

//    Intent in Android
//    private TextView txt;

//    Sqlite
    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_main);
//        Practice Demo "DE.txt" - kt2
//        String[] lts = {"Hà Nội - Sapa", "Hà Nội - Đà Nẵng"};
//        String[] time_starts = {"26-02-2024", "27-02-2024"};
//        String[] time_ends = {"28-02-2024", "04-04-2024"};


//        startDatePicker = findViewById(R.id.startDatePicker);
//        endDatePicker = findViewById(R.id.endDatePicker);
//
//        startDatePicker.init(startDatePicker.getYear(), startDatePicker.getMonth(), startDatePicker.getDayOfMonth(),
//                new DatePicker.OnDateChangedListener() {
//                    @Override
//                    public void onDateChanged(DatePicker view, int year, int month, int day) {
//
//                        showToast("Start Date: " + year + "/" + (month + 1) + "/" + day);
//                    }
//                });
//        endDatePicker.init(endDatePicker.getYear(), endDatePicker.getMonth(), endDatePicker.getDayOfMonth(),
//                new DatePicker.OnDateChangedListener() {
//                    @Override
//                    public void onDateChanged(DatePicker view, int year, int month, int day) {
//
//                        showToast("End Date: " + year + "/" + (month + 1) + "/" + day);
//                    }
//                });

//        listViewKt2 = (ListView) findViewById(R.id.list_view_kt2);
//        Item_KT2 adapter = new Item_KT2(this, lts, time_starts, time_ends, img_ids_kt2);
//        listViewKt2.setAdapter(adapter);

//        Recycle View
//        String[] items = {"Meo", "Xe"};
//        String[] subnames = {"Meo con lon ton", "Xe hoi cao cap"};
//
//        listView = (ListView) findViewById(R.id.list_view);
//        ItemAdapter adapter = new ItemAdapter(this, items, subnames, img_ids);
//        listView.setAdapter(adapter);


//        DatePicker -- Layout
//        showDatePickerButton = findViewById(R.id.showDatePickerButton);
//
//        showDatePickerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDatePickerDialog();
//            }
//        });

//        Login Page -- Layout
//        num1 = findViewById(R.id.num1);
//        num2 = findViewById(R.id.num2);
//        handleButton = findViewById(R.id.handleButton);
//        result = findViewById(R.id.txtKetqua);
//        choice_menu = findViewById(R.id.choiceSpinner);
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
//                this, R.array.choice_array,
//                android.R.layout.simple_spinner_dropdown_item);
//
//        choice_menu.setAdapter(adapter);
//
//        choice_menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parentView, View view, int pos, long id) {
//                itemSelected = parentView.getItemAtPosition(pos).toString();
//                Toast.makeText(MainActivity.this, "Selected: " + itemSelected, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

//        Intent
//        txt=findViewById(R.id.txtInfo);
//        Intent intent=getIntent();
//        if(intent.getSerializableExtra("account")!=null && intent.getSerializableExtra("user")!=null) {
//            Account log = (Account) intent.getSerializableExtra("account");
//            Account user = (Account) intent.getSerializableExtra("user");
//            if (log.getUsername().equalsIgnoreCase(user.getUsername())&&log.getPassword().equalsIgnoreCase(user.getPassword())) {
//                txt.setText("Dang nhap thanh cong!!!");
//            } else {
//                txt.setText("Tai khoan khong ton tai!!!");
//            }
//        }

//        SQLite
        navigationView=findViewById(R.id.bottom_nav);
        viewPager=findViewById(R.id.viewPager);
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navigationView.getMenu().findItem(R.id.mHome).setChecked(true);
                        break;
                    case 1:
                        navigationView.getMenu().findItem(R.id.mHistory).setChecked(true);
                        break;
                    case 2:
                        navigationView.getMenu().findItem(R.id.mSearch).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mHome:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.mHistory:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.mSearch:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }

//    Search Menu - search menu resource
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.search_menu, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                showToast(query);
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                updateSuggestions(newText);
//                return true;
//            }
//        });
//
//        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
//            @Override
//            public boolean onSuggestionSelect(int position) {
//                // Handle the suggestion item click (optional)
//                return true;
//            }
//
//            @Override
//            public boolean onSuggestionClick(int position) {
//                // Handle the suggestion item click
//                String suggestion = getSuggestion(position);
//                searchView.setQuery(suggestion, true); // Submit the selected suggestion
//                return true;
//            }
//        });
//
//        return true;
//    }

//    private void updateSuggestions(String query) {
//        Toast.makeText(this, "Query: " + query, Toast.LENGTH_SHORT).show();
//    }
//
//    private String getSuggestion(int position) {
//        // Fetch the suggestion at the given position (e.g., from a data source)
//        // Here, we'll return a sample suggestion for illustration
//        return "Suggestion " + (position + 1);
//    }

//    Menu -- menu resource
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_item1:
//                showToast("Option 1 selected!");
//                return true;
//            case R.id.menu_item2:
//                showToast("Option 2 selected!");
//                return true;
//            case R.id.submenu_item1:
//                showToast("Submenu option 1 selected!");
//                return true;
//            case R.id.submenu_item2:
//                showToast("Submenu option 2 selected!");
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

//    private void showToast(String msg) {
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//    }
//
//    private void showDatePickerDialog() {
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
//                (view, selectedYear, selectedMonth, selectedDay) -> {
//                    String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
//                    showSelectedDate(selectedDate);
//                }, year, month, day);
//
//        datePickerDialog.show();
//    }
//
//    private void showSelectedDate(String date) {
//        System.out.println("Selected Date: " + date);
//        Toast.makeText(this, "Selected Date: " + date, Toast.LENGTH_SHORT).show();
//    }


//    public void onLoginClick(View view) {
//        String username = usernameEditText.getText().toString().trim();
//        String password = passwordEditText.getText().toString().trim();
//
//        if (username.isEmpty() || password.isEmpty()) {
//            Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
//        }
//    }

//    private int sum(int n1, int n2) {
//        return n1 + n2;
//    }
//
//    private int min(int n1, int n2) {
//        return n1 - n2;
//    }
//
//    private long mul(int n1, int n2) {
//        return n1 * n2;
//    }
//
//    private float div(int n1, int n2) {
//        return (float)n1 / n2;
//    }

//    public void onHandleClicked(View view) {
//        String n1 = num1.getText().toString();
//        int number1 = Integer.parseInt(n1);
//        String n2 = num2.getText().toString();
//        int number2 = Integer.parseInt(n2);
//        double res = 0;
//        switch (itemSelected) {
//            case "+":
//                res = sum(number1, number2);
//                break;
//            case "-":
//                res = min(number1, number2);
//                break;
//            case "x":
//                res = mul(number1, number2);
//                break;
//            case "/":
//                res = div(number1, number2);
//                break;
//        }
//        String strRes = new StringBuilder().append(res).toString();
//        Toast.makeText(this, "Result : " + strRes, Toast.LENGTH_SHORT).show();
//        result.setText(strRes);
//    }


}