package com.example.lab4milestone1;

import static android.content.ContentValues.TAG;

public class ExampleRunnable implements Runnable {
    int seconds;
    ExampleRunnable(int seconds){
        this.seconds = seconds;
    }

    @Override
    public void run(){
       for(int i = 0; i < seconds; i++){
           if(stopThread){
               funOnUiThread(new Runnable(){
                   @Override
                   public void run(){
                       buttonStartThread.setText("Start");
                   }
               });
               return;
           }

           if(i == 5){
               runOnUiThread(new Runnable(){
                   @Override
                   public void run(){
                       buttonStartThread.setText("50%");
                   }
               });
           }
           Log.d(TAG, "startThread: " + i);
           try{
               Thread.sleep(1000);

           }catch(InterruptedException e){
               e.printStackTrace();
           }
       }
       runOnUiThread(new Runnable(){
           @Override
           public void run(){
               buttonStartThread.setText("Start");
           }
       });
    }


}
