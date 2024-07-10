package codechef.problemSet_1400_1500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Event {
    int time;
    boolean isArrival;

    public Event(int time, boolean isArrival) {
        this.time = time;
        this.isArrival = isArrival;
    }
}

class EventComparator implements Comparator<Event> {

    @Override
    public int compare(Event o1, Event o2) {
        if (o1.time == o2.time) {
            // Put the departure event first.
            if (o1.isArrival) {
                // 1 will swap.
                return 1;
            }
            return -1;
        }


        return Integer.compare(o1.time, o2.time);
    }
}

// Note that if one guest arrives at the same time another leaves, they are never considered to be at the hotel simultaneously (see the second example).
class HotelByteLandia {

    public static void getMaxNumberOfGuests(int[] arrivals, int[] departures) {
        List<Event> events = new ArrayList<>();

        for (int arrival : arrivals) {
            events.add(new Event(arrival, true));
        }

        for (int departure : departures) {
            events.add(new Event(departure, false));
        }

        events.sort(new EventComparator());
        int ans = 0;
        int mx = 0;
        for (Event event : events) {
            if (event.isArrival) {
                ans++;
                mx = Math.max(ans, mx);
            } else {
                ans--;
            }
        }

        System.out.println(mx);
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());

            String[] arrayStr = reader.readLine().trim().split(" ");
            int[] arrivals = new int[N];
            for (int i = 0; i < N; i++) {
                arrivals[i] = Integer.parseInt(arrayStr[i]);
            }

            arrayStr = reader.readLine().trim().split(" ");
            int[] departures = new int[N];
            for (int i = 0; i < N; i++) {
                departures[i] = Integer.parseInt(arrayStr[i]);
            }

            getMaxNumberOfGuests(arrivals, departures);
        }

    }

}

