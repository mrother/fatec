package com.fatec.maiara.objectloandapp.activies;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fatec.maiara.objectloandapp.R;
import com.fatec.maiara.objectloandapp.adapters.ItemAdapter;
import com.fatec.maiara.objectloandapp.fragments.ItemDialogFragment;
import com.fatec.maiara.objectloandapp.models.Item;
import com.fatec.maiara.objectloandapp.providers.ItemDAO;
import com.fatec.maiara.objectloandapp.providers.ObjectLoanSQLHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemDialogFragment.NoticeDialogListener, ItemAdapter.ItemAdapterListener{

    private RecyclerView recyclerView;

    private ItemDAO itemDAO;
    private ItemAdapter adapter;
    private FloatingActionButton addButton;

    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        initializeItemsInDatebase();

        itemDAO = new ItemDAO(this);

        try {
            items = itemDAO.searchAll();

        }catch (Exception e){
            Toast toast = Toast.makeText(this, "Erro", Toast.LENGTH_LONG);
            toast.show();
        }

        adapter = new ItemAdapter(items, this);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);

        addButton = findViewById(R.id.floatingAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                ItemDialogFragment dialog = ItemDialogFragment.newInstance(
                        "Novo Empréstimo", "Adicionar", null, -1);
            }
        });
    }


    private void initializeItemsInDatebase(){
        ItemDAO dao = new ItemDAO(this);
        try {
            dao.create(new Item("José", "Livro de Android", "27/08/2013"));
            dao.create(new Item("Veck", "Oculos", "27/08/2013"));
            dao.create(new Item("Veck", "Oculos", "27/08/2013"));
        }catch (Exception e){
            Toast toast = Toast.makeText(this, "Erro", Toast.LENGTH_LONG);
            toast.show();

            Log.e(ObjectLoanSQLHelper.DATABASE_NAME, "Erro inserir");
        }
    }

    @Override
    public void onDialogPositiveClick(Item item, int position) {
        if (item.getId() == 0){
            try {
                itemDAO.create(item);
                items.add(item);
                adapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(items.size() - 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                itemDAO.update(item);
                items.set(position, item);
                adapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onEditItemClick(View view, int position) {
        FragmentManager fm = getSupportFragmentManager();

        Item item = items.get(position);

        ItemDialogFragment dialog = ItemDialogFragment.newInstance(
                "Novo Empréstimo", "Adicionar", null, -1);
        dialog.setCancelable(false);
        dialog.show(fm,ItemDialogFragment.TAG_EDIT);
    }

    @Override
    public void onDeleteItemClick(View view, final int position) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Excluido");
        dialog.setMessage("Tem certeza que deseja excluir este objeto emprestado?");
        dialog.setNegativeButton("Cancelar", null);
        dialog.setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Item item = items.get(position);
                try {
                    itemDAO.delete(item);
                    items.remove(position);
                    adapter.notifyItemRemoved(position);
                    adapter.notifyItemRemoved(position);
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        dialog.create();
    }
}


