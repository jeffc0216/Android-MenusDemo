package idv.ron.menusdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        registerForContextMenu(tvMessage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

//        menu.add("Yushan National Park");
//        menu.add("Taroko National Park");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String message;
        switch (item.getItemId()) {
            case R.id.yangmingshan:
                message = getString(R.string.yangmingshan);
                break;
            case R.id.guide:
                message = getString(R.string.yangmingshan) + " > "
                        + getString(R.string.guide);
                break;
            case R.id.traffic:
                message = getString(R.string.yangmingshan) + " > "
                        + getString(R.string.traffic);
                break;
            case R.id.yushan:
                message = getString(R.string.yushan);
                break;
            case R.id.taroko:
                message = getString(R.string.taroko);
                break;
            case R.id.myloc:
                message = getString(R.string.myloc);
                break;
            case R.id.exit:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
        tvMessage.setText(message);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear:
                tvMessage.setText("");
                break;
            case R.id.yellow:
                tvMessage.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.green:
                tvMessage.setBackgroundColor(Color.GREEN);
                break;
            case R.id.cyan:
                tvMessage.setBackgroundColor(Color.CYAN);
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }

    public void onDeleteClick(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                tvMessage.setText(item.getTitle());
                return true;
            }
        });
        popupMenu.show();
    }

}
