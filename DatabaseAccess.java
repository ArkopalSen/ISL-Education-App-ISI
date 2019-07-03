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
        else if (typeOfList == 17){
            columnNnumber = cursor.getColumnIndex("benAntExa");
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
    public List<String> getWordPair(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        if ( typeOfList == 998)
            cursor = database.rawQuery("SELECT * FROM DictionaryWordAntoPairs", null);
        else cursor = database.rawQuery("SELECT * FROM DictionaryMathPair", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("word");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getAntoPair(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        if ( typeOfList == 998)
            cursor = database.rawQuery("SELECT * FROM DictionaryWordAntoPairs", null);
        else cursor = database.rawQuery("SELECT * FROM DictionaryMathPair", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("antonym");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getPair(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        if ( typeOfList == 998)
            cursor = database.rawQuery("SELECT * FROM DictionaryWordAntoPairs", null);
        else cursor = database.rawQuery("SELECT * FROM DictionaryMathPair", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("pair");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getBodyPart(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryBody", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("bodyPart");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getNumber( int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryNumbers", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("numbers");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getColors( int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryColours", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("colours");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getAnimal(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryAnimals", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("aniBirIns");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getDays(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryDays", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("calendarDays");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getMonths(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryMonths", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("months");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getFestivals(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryFestiHoli", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("festiHolidays");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getFood(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryFood", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("foodBev");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getVehicles(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryVehicles", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("vehicles");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getSports(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionarySports", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("sportsGames");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getCricketTerms(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryCricketTerms", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("cricTerms");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getcCCommonTerms(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryCalendarCommonTerms", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("commonT");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getIndiaOtherCities(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryCalendarOtherCities", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("otherC");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getIndiaStatesCaps(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryIndiaStatesCaps", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("statesCaps");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getSomeFamousPlaces(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryFamousPlaces", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("famousPlaces");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getWorldCountriesCities(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryWorldCountriesCities", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("worldCountCities");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getJobs(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryJob", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("profJobTraDesig");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getRelationships(int typeOList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryRelationships", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("famKinRelation");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getFamousPeople(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryPersonalities", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("famPeople");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getBrands(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryBrands", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("brands");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getClothes(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryClothes", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("clothesAcc");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getBasicPhrases(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryBasicPhr", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("basicPhr");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getEnglishIdioms(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryEnglishIdioms", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("engIdioms");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getMath()
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryMath", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("mathWord");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getScience()
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryScience", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("scienceWord");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getGeography()
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryGeography", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("geoWord");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getHistory()
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryHistory", null);
        cursor.moveToFirst();
        int columnNumber=0;
        columnNumber=cursor.getColumnIndex("historyWord");
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(columnNumber))
                list.add(cursor.getString(columnNumber));
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
    public List<String> videoWord(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        if ( typeOfList == 998)
            cursor = database.rawQuery("SELECT * FROM DictionaryWordAntoPairs", null);
        else cursor = database.rawQuery("SELECT * FROM DictionaryMathPair", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(3))
                list.add(cursor.getString(3));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoAnto(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor;
        if ( typeOfList == 998)
            cursor = database.rawQuery("SELECT * FROM DictionaryWordAntoPairs", null);
        else cursor = database.rawQuery("SELECT * FROM DictionaryMathPair", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(4))
                list.add(cursor.getString(4));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoBodyPart(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryBody", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoDays(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryDays", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoMonths(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryMonths", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoFestivals(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryFestiHoli", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoNumber(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryNumbers", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoColours(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryColours", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoAnimals(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryAnimals", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoFood(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryFood", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoVehicles(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryVehicles", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoSports(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionarySports", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoCricketTerms(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryCricketTerms", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoCCommonTerms(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryCalendarCommonTerms", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoCOtherCities(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryCalendarOtherCities", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoIndiaStatesCaps(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryIndiaStatesCaps", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoSomeFamousPlaces(int typeOflist)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryFamousPlaces", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoWorldCountries(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryWorldCountriesCities", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoJobs(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryJob", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoRelationships(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryRelationships", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoFamousPeople(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryPersonalities", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoBrands(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryBrands", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoClothes(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryClothes", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoBasicPhrases(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryBasicPhr", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoEnglishIdioms(int typeOfList)
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryEnglishIdioms", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoMath()
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryMath", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoScience()
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryScience", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoGeography()
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryGeography", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> videoHistory()
    {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DictionaryHistory", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (!cursor.isNull(2))
                list.add(cursor.getString(2));
            else
                list.add(" ");
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
