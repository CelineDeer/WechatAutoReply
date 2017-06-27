package com.hxl.accessibilityservice;

/**
 * Created by hp_laptop on 2017/5/26.
 */

public class AutoManager {

    private static AutoManager uniqueInstance = null;
    private ReplyKeywordsChangeListenner replyListener = null;

    public static AutoManager getInstance(){
        Object obj = new Object();
        synchronized (obj){
            if (uniqueInstance == null){
                uniqueInstance = new AutoManager();
            }
        }
        return uniqueInstance;
    }
    public interface ReplyKeywordsChangeListenner{
        String getReplyWords();
    }

    public ReplyKeywordsChangeListenner getReplyListener() {
        return replyListener;
    }

    public void setReplyListener(ReplyKeywordsChangeListenner replyListener) {
        this.replyListener = replyListener;
    }
}
