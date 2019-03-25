package com.fatec.maiara.objectloandapp.providers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.fatec.maiara.objectloandapp.models.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements SQLiteGenericDAO<Item> {

    private ObjectLoanSQLHelper helper;

    public ItemDAO(Context context){
        this.helper = new ObjectLoanSQLHelper(context);
    }


    private ContentValues getContentValues(Item item){

        ContentValues cv = new ContentValues();

        if(item.getId() != 0)
            cv.put(ItemSchema.COLUMN_NAME, item.getName());

        cv.put(ItemSchema.COLUMN_NAME, item.getName());
        cv.put(ItemSchema.COLUMN_DESCRIPTION, item.getDescription());
        cv.put(ItemSchema.COLUMN_DATE, item.getDate());
        return cv;
    }

    private Item getItemFromCursor(Cursor cursor){
        long id = cursor.getLong(0);
        String name = cursor.getString(1);
        String description = cursor.getString(2);
        String date = cursor.getString(3);

        Item item = new Item(id, name, description, date);
        return item;
    }

    @Override
    public long create(Item item) throws Exception {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = getContentValues(item);

        long id = db.insert(ItemSchema.TABLE_ITEM, null, cv);
        if(id != -1){
            item.setId(id);}

        db.close();

        Log.e(ObjectLoanSQLHelper.DATABASE_NAME, "Erro ");
        return id;
    }

    @Override
    public void update(Item item) throws Exception {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = getContentValues(item);

        String where = ItemSchema.COLUMN_ID + " = ?";
        String[] args = {String.valueOf(item.getId())};

        db.update(ItemSchema.TABLE_ITEM, cv , where, args );

        db.close();
    }

    @Override
    public void delete(Item item) throws Exception {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = getContentValues(item);

        String where = ItemSchema.COLUMN_ID + " = ?";
        String[] args = {String.valueOf(item.getId())};

        db.delete(ItemSchema.TABLE_ITEM, where, args );

        db.close();

    }

    @Override
    public List<Item> searchAll() throws Exception {
        List<Item> list = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();

        String query = "Select * From " + ItemSchema.TABLE_ITEM;
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Item item = getItemFromCursor(cursor);
                list.add(item);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    @Override
    public Item searchById(long id) throws Exception {
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "Select * FROM " + ItemSchema.TABLE_ITEM + " WHERE " + ItemSchema.COLUMN_ID +  " = ?";

        String[] args = {String.valueOf(id)};
        Cursor cursor = db.rawQuery(query, args);

        if(cursor != null){
            cursor.moveToNext();
        }

        Item item = getItemFromCursor(cursor);
        cursor.close();
        db.close();


        return item;
    }
}
