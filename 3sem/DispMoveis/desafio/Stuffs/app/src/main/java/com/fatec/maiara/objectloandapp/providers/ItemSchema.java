package com.fatec.maiara.objectloandapp.providers;

public class ItemSchema {

    private ItemSchema(){}


    public static final String TABLE_ITEM = "item";

    public static final String COLUMN_ID = "_id"; // sempre colocazr o _ no ID
    public static final String COLUMN_NAME = "";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DATE = "date";


    public static final String CREATE_TABLE_ITEM =
            "CREAT TABLE" + TABLE_ITEM  + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    COLUMN_NAME + " TEXT NOT NULL, " +
                    COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                    COLUMN_DATE + " TEXT NOT NULL )";

    public  static final String DROP_TABLE_ITEM =
            " DROP TABLE IF EXISTS " + TABLE_ITEM;



}
