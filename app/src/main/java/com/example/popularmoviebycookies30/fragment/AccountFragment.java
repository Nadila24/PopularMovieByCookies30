package com.example.popularmoviebycookies30.fragment;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.popularmoviebycookies30.R;
import com.example.popularmoviebycookies30.SqliteHelper;
import com.example.popularmoviebycookies30.activity.DetailAkunActivity;
import com.example.popularmoviebycookies30.activity.LoginActivity;
import com.example.popularmoviebycookies30.adapter.SqliteAdapter;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class AccountFragment extends Fragment {
    Button btnLogout;
    Button btnProf;

    SQLiteDatabase SQLITEDATABASE;
    SqliteHelper SQLITEHELPER;
    SqliteAdapter ListAdapter;

    Cursor cursor;
    Button rv_klik;

    ArrayList<String> ID_ArrayList = new ArrayList<>();
    ArrayList<String> USERNAME_ArrayList = new ArrayList<>();
    ArrayList<String> EMAIL_ArrayList = new ArrayList<>();

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container, false);
        initView(v);

        SQLITEHELPER = new SqliteHelper(getActivity());

//        btnProf.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), DetailAkunActivity.class);
//                startActivity(intent);
//            }
//        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MyDB.Logout();
//
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return v;
    }
    private void initView(View v) {
        btnLogout = (Button) v.findViewById(R.id.buttonLogout);
//        btnProf  = (Button) v.findViewById(R.id.txtProf);
        listView = (ListView) v.findViewById(R.id.list);
    }

    @Override
    public void onResume() {

        TampilSQLiteDBData();
        super.onResume();
    }
    private void TampilSQLiteDBData() {
        SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();
        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM USERS", null);

        ID_ArrayList.clear();
        USERNAME_ArrayList.clear();
        EMAIL_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do {
                ID_ArrayList.add(cursor.getString(cursor.getColumnIndex(SqliteHelper.KEY_ID)));
                USERNAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(SqliteHelper.KEY_USER_NAME)));
                EMAIL_ArrayList.add(cursor.getString(cursor.getColumnIndex(SqliteHelper.KEY_EMAIL)));
            } while (cursor.moveToNext());
        }

        ListAdapter = new SqliteAdapter(getActivity(), ID_ArrayList, USERNAME_ArrayList, EMAIL_ArrayList);

        listView.setAdapter(ListAdapter);
        cursor.close();
    }
}



