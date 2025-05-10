package mvc;


import java.util.*;


public class Publisher {
    protected List<Subscriber> subscribers ;
    //default implementation is ArrayList
    public Publisher(){
        subscribers = new ArrayList<>();
    }

    //can choose what type of list of subscribers
    public Publisher(String x){
        if(x.equalsIgnoreCase("linked")) {
            subscribers = new LinkedList<>();
        } else if(x.equalsIgnoreCase("stack"))
            subscribers = new Stack<>();
        else if(x.equalsIgnoreCase("vector"))
            subscribers = new Vector<>();
        else
            subscribers = new ArrayList<>();
    }
    public void subscribe(Subscriber sb){
        subscribers.add(sb);
    }
    public void unsubscribe(Subscriber sb){
        subscribers.remove(sb);
    }
    //calls update method of all subscribers
    public void notifySubscribers(){
        for(Subscriber sb: subscribers){
            sb.update();
        }
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}