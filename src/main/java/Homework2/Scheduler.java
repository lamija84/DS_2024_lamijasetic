package Homework2;

import java.util.ArrayList;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue pq = new ProcessQueue();
        int t = 0;
        int itemsLeft = processes.size();
        float totalWaitTime = 0;
        while(true){

            String name = "no process";
            for(Process p : processes){
                if(p.getArrival()==t){
                    pq.addProcess(p);
                    itemsLeft--;
                }
            }
            if(!pq.isEmpty()){

                Process p = pq.peekNextProcess();
                int burst = p.getBurst();

                if(burst==1){
                    p = pq.runNextProcess();
                    p.setWaitTime(t+1);
                    totalWaitTime += p.getWaitTime();
                }

                p.setBurst(--burst);
                name = p.getName();
            }

            System.out.println("t: " + t + "   |   " + name);
            t++;

            if(pq.isEmpty() && itemsLeft==0){
                System.out.println("Total time: " + t);
                System.out.println("Average waiting time:" + (totalWaitTime/processes.size()));
                break;
            }
        }
    }
//Example 3
    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 3, 3, 0));
        processes.add(new Process("P2", 2, 4, 1));
        processes.add(new Process("P3", 4, 6, 2));
        processes.add(new Process("P4", 6, 4, 3));
        processes.add(new Process("P5", 10, 2, 5));
        scheduleAndRun(processes);
    }
}

