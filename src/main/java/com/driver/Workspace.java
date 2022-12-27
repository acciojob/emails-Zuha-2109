package com.driver;

import org.apache.commons.lang3.tuple.Pair;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class Sorting implements Comparator<Meeting>{
    @Override

    //sort meetings based on finish timings
    public int compare(Meeting o1, Meeting o2)
    {

       // m1 start < m2 start
        if(o1.getEndTime().isBefore(o2.getEndTime())){
            return -1;

        }

        //m1 end > m2.end
        else if(o1.getEndTime().isAfter(o2.getEndTime())){
            return 1;

        }

        return 0;

    }
}

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.

        super(emailId,Integer.MAX_VALUE);
        calendar=new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar

        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        int count = 1;

        Sorting so = new Sorting();

        //sort meeting with finish time
        Collections.sort(calendar, so);

        //first meeting  default first

        LocalTime previous_end = calendar.get(0).getEndTime();

        //checking for meeting availablity

        for(int i=1;i<calendar.size();i++){
            if(calendar.get(i).getStartTime().isAfter(previous_end)){

                previous_end = calendar.get(i).getEndTime();
                count++;
            }
        }
        return count;

    }
}
