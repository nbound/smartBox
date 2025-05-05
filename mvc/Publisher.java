package mvc;

/*
Edits:
    Fadrigon 3/13/25: created file, imported code from previous project
 */

import java.util.HashSet;

public class Publisher {
    private HashSet<Subscriber> subscribers;
    public Publisher(){
        subscribers = new HashSet<Subscriber>();
    }

    public void subscribe(Subscriber s){
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s){
        subscribers.remove(s);
    }

    public void notifySubscribers(){
        for(Subscriber s:subscribers){
            s.update();
        }
    }
}