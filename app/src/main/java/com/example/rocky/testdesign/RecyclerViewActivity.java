package com.example.rocky.testdesign;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements PersonAdapter.OnRecyclerViewItemClickListener {
    RecyclerView mRecyclerView = null;
    PersonAdapter personAdapter;
    List<String> data = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        //
        mRecyclerView = (RecyclerView)findViewById(R.id.id_recyclerView);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(RecyclerViewActivity.this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //GridLayoutManager layoutManager = new GridLayoutManager(RecyclerViewActivity.this,3);
        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);
        personAdapter = new PersonAdapter(getDummyDatas());
        personAdapter.setOnRecyclerViewItemClickListener(this);
        mRecyclerView.setAdapter(personAdapter);

        //
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);

    }

    @Override
    public void onItemClick(int position) {
        //Toast.makeText(RecyclerViewActivity.this,""+position,Toast.LENGTH_SHORT).show();
       personAdapter.notifyItemInserted(2);
       data.add(2,"wy");
       personAdapter.notifyItemRangeChanged(2,personAdapter.getItemCount());
    }

    @Override
    public boolean onItemLongClick(int position) {
        personAdapter.notifyItemRemoved(position);
        data.remove(position);
        personAdapter.notifyItemRangeChanged(position,personAdapter.getItemCount());

        return true;
    }

    private List<String> getDummyDatas(){
           //String[] data = {"First","Second","Third","Forth","Fifth","Sixth"};
        data = new ArrayList<>();
        data.add("First");
        data.add("Second");
        data.add("Third");
        data.add("Forth");
        data.add("Sixth");

        return data;
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpacesItemDecoration(int space) {
            this.space=space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left=space;
            outRect.right=space;
            outRect.bottom=space;
            if(parent.getChildAdapterPosition(view)==0){
                outRect.top=space;
            }
        }
    }
}
