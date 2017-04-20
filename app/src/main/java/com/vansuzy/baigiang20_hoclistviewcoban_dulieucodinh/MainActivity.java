package com.vansuzy.baigiang20_hoclistviewcoban_dulieucodinh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] arrThu;
    ArrayAdapter<String> adapterThu;
    ListView lvThu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        lvThu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)    // Đối số thứ 3 (int position) chính là vị trí của item mà chúng ta đang chọn trên giao diện.
            {
                Toast.makeText(MainActivity.this, "Bạn chọn [" + arrThu[position] + "]", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addControls() {
        arrThu = getResources().getStringArray(R.array.arrThu); // Tạo nguồn (lấy dữ liệu trong file strings.xml thông qua hàm getResources())
        // Bước 2: Tạo adapter có cùng kiểu dữ liệu với nguồn, sau đó gán nguồn cho adapter này.
        adapterThu = new ArrayAdapter<String>(
                MainActivity.this,  // màn hình đang sử dụng adapter này
                android.R.layout.simple_list_item_1,    // giao diện để vẽ từng dòng dữ liệu lên
                arrThu  // nguồn dữ liệu gán cho adapter
        );
        lvThu = (ListView) findViewById(R.id.lvThu);

        // Bước 3: gán adapter cho ListView thông qua hàm setAdapter
        lvThu.setAdapter(adapterThu);
    }
}
