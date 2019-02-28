package kr.co.teada.ex54listviewholder_originalofrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items=new ArrayList<>();

    ListView listView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. 대량의 데이터 추가_원래는 DB,서버에서 불러오는거
        items.add(new String("aaa"));
        items.add(new String("bbb"));
        items.add(new String("ccc"));
        items.add(new String("ddd"));
        items.add(new String("eee"));
        items.add(new String("aaa"));
        items.add(new String("bbb"));
        items.add(new String("ccc"));
        items.add(new String("ddd"));
        items.add(new String("eee"));
        items.add(new String("aaa"));
        items.add(new String("bbb"));
        items.add(new String("ccc"));
        items.add(new String("ddd"));
        items.add(new String("eee"));

        //2. 대량의 데이터가 보일 xml 설계 :list_item(CardView 추가)
        //3. MyAdapter 자바 설계
        //4. 연결! 아래 코드드
        listView=findViewById(R.id.listview);
        adapter=new MyAdapter(items, getLayoutInflater());
        listView.setAdapter(adapter);

        //리스트뷰의 아이템 클릭 리스너 추가
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
