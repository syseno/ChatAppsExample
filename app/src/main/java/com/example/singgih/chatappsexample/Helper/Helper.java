package com.example.singgih.chatappsexample.Helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by singg on 1/18/2017.
 */

public class Helper {

    // Returns a string with only hour contained in the input
    public static final String convertTimeTZtoHour(final String time) throws ParseException {
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        DateFormat outputFormat = new SimpleDateFormat("hh:mm", Locale.ENGLISH);
        Date parsed = null;
        try {
            parsed = inputFormat.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String outputText = outputFormat.format(parsed);
        return outputText;
    }

    // Returns a string with only Date (ex: 2017, Jan 19) contained in the input
    public static final String convertTimeTZtoDate(final String time) throws ParseException {
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.US);
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        DateFormat outputFormat = new SimpleDateFormat("yyyy, MMM dd", Locale.ENGLISH);
        Date parsed = null;
        try {
            parsed = inputFormat.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String outputText = outputFormat.format(parsed);
        return outputText;
    }


    // Returns a string with links contained in the input
    public static String extractUrls(String text) {
        String containedUrl = "";
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find()) {
            containedUrl = (text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }

        return containedUrl;
    }

}
