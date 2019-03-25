package com.fatec.maiara.objectloandapp.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.fatec.maiara.objectloandapp.R;
import com.fatec.maiara.objectloandapp.models.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ItemDialogFragment  extends DialogFragment{

    public interface NoticeDialogListener{
        void onDialogPositiveClick(Item item, int position);

    }

    private NoticeDialogListener listener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (NoticeDialogListener) context;
    }

    public static final String EXTRA_TITLE = "TITLE";
    public static final String EXTRA_POSITIVE_BUTTON = "POSITIVE_BUTTON";
    public static final String EXTRA_ITEM = "ITEM";
    public static final String EXTRA_POSITION = "POSITION";

    public static final String TAG_CREATE = "CREAT";
    public static final String TAG_EDIT = "EDIT";


    public EditText nameEditText;
    public EditText descriptionEditText;
    public EditText dateEditText;

    private Item currentItem;


    public static ItemDialogFragment newInstance( String title, String positiveButton,Item item,int position){

        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TITLE, title);
        bundle.putString(EXTRA_POSITIVE_BUTTON, positiveButton);
        bundle.putSerializable(EXTRA_ITEM, item);
        bundle.putInt(EXTRA_POSITION, position);


        ItemDialogFragment dialog =new ItemDialogFragment();
        dialog.setArguments(bundle);
        return null;
    }

     @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Context context =  getActivity();
        final Bundle bundle = getArguments();

         AlertDialog.Builder builder = new AlertDialog.Builder(context);

         builder.setTitle(bundle.getString(EXTRA_TITLE));
         builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 dismiss();
             }
         });
        builder.setPositiveButton(bundle.getString(EXTRA_POSITIVE_BUTTON), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                currentItem.setName(nameEditText.getText().toString());
                currentItem.setDescription(descriptionEditText.getText().toString());
                currentItem.setDate(dateEditText.getText().toString());

                int position = bundle.getInt(EXTRA_POSITION);
                listener.onDialogPositiveClick(currentItem, position);
            }
        });

         LayoutInflater inflater = LayoutInflater.from(context);
         View view = inflater.inflate(R.layout.card_item, null, false);
         builder.setView(view);

         nameEditText = view.findViewById(R.id.name);
         descriptionEditText = view.findViewById(R.id.description);
         dateEditText = view.findViewById(R.id.date);

         if(getTag().equals(TAG_CREATE)){
             currentItem = new Item("","","");
         }else{
             currentItem= (Item) bundle.getSerializable(EXTRA_ITEM);
             nameEditText.setText(currentItem.getName());
             descriptionEditText.setText(currentItem.getDescription());
             dateEditText.setText(currentItem.getName());
         }

         dateEditText.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 final Calendar calendar = Calendar.getInstance();


                 if(getTag().equals(TAG_EDIT)){
                     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                     try {
                         Date currentDate = sdf.parse(dateEditText.getText().toString());
                         calendar.setTime(currentDate);
                     } catch (ParseException e) {
                         e.printStackTrace();
                     }
                 }

                 int day = calendar.get(Calendar.DAY_OF_MONTH);
                 int month = calendar.get(Calendar.MONTH);
                 int year = calendar.get(Calendar.YEAR);

                 DatePickerDialog picker = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                     @Override
                     public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                         dateEditText.setText(String.format("%02d/%02d/%04d", dayOfMonth, month, year));
                     }
                 }, year, month + 1, day);

                 picker.show();
             }
         });

        return builder.create();
    }
}
