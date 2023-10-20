package com.android.gitapi.data.repository;

import com.android.gitapi.data.model.TimePeriod;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RepositorySearchQuery {
    private String created;

    public RepositorySearchQuery(String created) {
        this.created = created;
    }

    public String getCreated() {
        return created;
    }

    public static String getDateRange(TimePeriod period) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Calendar calendar = Calendar.getInstance();

        switch (period) {
            case LAST_DAY:
                calendar.add(Calendar.DAY_OF_MONTH, -1);
                break;
            case LAST_WEEK:
                calendar.add(Calendar.WEEK_OF_YEAR, -1);
                break;
            case LAST_MONTH:
                calendar.add(Calendar.MONTH, -1);
                break;
        }

        Date endDate = calendar.getTime();
        String endDateString = dateFormat.format(endDate);
        String currentDate = dateFormat.format(new Date());

        return endDateString + ".." + currentDate;
    }
}
