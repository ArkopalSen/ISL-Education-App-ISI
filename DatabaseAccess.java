package com.cscr.cscr.my;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @arpan context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> getWord() {
        return getWord();
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> getWord(int typeOfList) {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Dictionary501", null);
        cursor.moveToFirst();
        int columnNnumber = -1;
        if(typeOfList == 1){
            columnNnumber = cursor.getColumnIndex("englishWord");
        }
        else if(typeOfList == 2){
            columnNnumber = cursor.getColumnIndex("englishToHindi");
        }
        else if (typeOfList == 3){
            columnNnumber = cursor.getColumnIndex("englishToBengali");
        }
        else if (typeOfList == 4){
            columnNnumber = cursor.getColumnIndex("englishToNepali");
        }
        else if (typeOfList == 5){
            columnNnumber = cursor.getColumnIndex("englishToPunjabi");
        }
        else if (typeOfList == 6){
            columnNnumber = cursor.getColumnIndex("englishToGujaratii");
        }
        else if (typeOfList == 7){
            columnNnumber = cursor.getColumnIndex("englishToTamil");
        }
        else if (typeOfList == 8){
            columnNnumber = cursor.getColumnIndex("englishToTelegu");
        }
        else if (typeOfList == 9){
            columnNnumber = cursor.getColumnIndex("englishToUrdu");
        }
        else if (typeOfList == 10){
            columnNnumber = cursor.getColumnIndex("englishToMarathi");
        }
        else if (typeOfList == 11){
            columnNnumber = cursor.getColumnIndex("englishToMalayalam");
         }
        else if (typeOfList == 13){
            columnNnumber = cursor.getColumnIndex("benSyn");
        }
        else if (typeOfList == 14){
            columnNnumber = cursor.getColumnIndex("benAnt");
        }
        else if (typeOfList == 15){
            columnNnumber = cursor.getColumnIndex("benExa");
        }
        else if (typeOfList == 16){
            columnNnumber = cursor.getColumnIndex("benType");
        }

        while (!cursor.isAfterLast()) {
           if (!cursor.isNull(columnNnumber))
                list.add(cursor.getString(columnNnumber));
            else
               list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoall() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Dictionary501", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(12))
                list.add(cursor.getString(12));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
