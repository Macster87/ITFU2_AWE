public class Uhrzeit {

    //Attribute
    private int time;

    //Konstruktoren
    public Uhrzeit(int stunde, int minute, int sekunde) {
        time = toTime(stunde ,minute ,sekunde);
    }

    public Uhrzeit(int stunde, int minute) {
        time = toTime(stunde ,minute ,0);
    }

    public Uhrzeit() {
        time = 0;
    }

    //Methoden
    private int toTime(int stunde, int minute, int sekunde) {
        return sekunde + (minute*60) + (stunde*60*60);
    }

    public String toString() {
        String h = ""+getHours();
        String m = ""+getMinutes();
        String s = ""+getSeconds();
        if(getHours()< 10) {
            h = "0"+getHours();
        }
        if(getMinutes() < 10) {
            m = "0"+getMinutes();
        }
        if(getSeconds() < 10) {
            s = "0"+getSeconds();
        }
        return h+":"+m+":"+s;
    }

    public void addUhrzeit(Uhrzeit add) {
        time = time + add.getTime();
    }

    public void addHours(int hours) {
        time = time + (hours*60*60);
    }

    public void addMinutes(int minutes) {
        time = minutes*60;
    }

    public void addSeconds(int seconds) {
        time = time + seconds;
    }

    public boolean isBefore(Uhrzeit uhrzeit) {
        if(uhrzeit.getTime() < time) return true;
        return false;
    }

    public boolean isAfter(Uhrzeit uhrzeit) {
        if(uhrzeit.getTime() > time) return true;
        return false;
    }

    public boolean isEqual(Uhrzeit uhrzeit) {
        if(uhrzeit.getTime() == time) return true;
        return false;
    }

    public String timeDiff(Uhrzeit uhrzeit) {
        Uhrzeit result = new Uhrzeit();
        result.setTime(uhrzeit.getTime()-time);
        return result.toString();
    }

    public int secSinceMidnight() {
        return getTime();
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    private int getHours() {
        int result = time/(60*60);
        return result;
    }

    private int getMinutes() {
        int result = time - getHours()*60*60;
        result = result/60;
        return result;
    }

    private int getSeconds() {
        int result = time - (getHours()*60*60) - (getMinutes()*60);
        return result;
    }
}
