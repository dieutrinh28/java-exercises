package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ActionMode actionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_popup_menu = findViewById(R.id.btn_popup_menu);
        btn_popup_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });

        Button btn_context_menu = findViewById(R.id.btn_context_menu);
        registerForContextMenu(btn_context_menu);

        TextView textView = findViewById(R.id.text_view);
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (actionMode != null) return false;
                actionMode = MainActivity.this.startActionMode(actionModeCallBack);
                view.setSelected(true);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String message = item.toString();
        switch (item.getItemId()) {
            case R.id.option_settings:
            case R.id.option_favourites:
            case R.id.sub_option_email:
            case R.id.sub_option_phone:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message", "You clicked menu item " + message);
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }


    private void showPopupMenu(View v) {
        PopupMenu popup_menu = new PopupMenu(MainActivity.this, v);
        popup_menu.getMenuInflater().inflate(R.menu.menu_popup, popup_menu.getMenu());
        popup_menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                String message = menuItem.toString();
                switch (menuItem.getItemId()) {
                    case R.id.popup_reply:
                    case R.id.popup_forward:
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("message", "You clicked menu item " + message);
                        startActivity(intent);
                        return true;
                    default:
                        return false;
                }

            }

        });
        popup_menu.show();
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contextual, menu);
        menu.setHeaderTitle("Contextual menu");


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String message = item.toString();
        switch (item.getItemId()) {
            case R.id.context_add:
            case R.id.context_edit:
            case R.id.context_delete:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message", "You clicked menu item " + message);
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    public ActionMode.Callback actionModeCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            getMenuInflater().inflate(R.menu.contextual_action_bar, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            String message = menuItem.getTitle().toString();
            switch (menuItem.getItemId()) {
                case R.id.action_bar_delete:
                case R.id.action_bar_share:
                case R.id.action_bar_edit:
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("message", "You clicked menu item " + message);
                    startActivity(intent);
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
                actionMode = null;
        }
    };
}