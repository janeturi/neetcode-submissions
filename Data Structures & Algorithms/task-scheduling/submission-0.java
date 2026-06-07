class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        // given an array of cpu tasks tasks, where tasks[i]
        // is an uppercase english character from A to Z
        // cpu cycles allow the completion of a single task, and
        // tasks can be completed in any order
        // identical tasks hwoever, must be seprated by 
        // at least n CPU cycles to cooldown th ecpu

        // return minimum number of cpu cycles required to complete all
        // tasks

        // task w highest freq determines min needed structure of the schedule
        // if a task appears maxf times, copies msut be at least n apart
        // so (maxf - 1) gaps w each gap having a length of (n+1) slots
        // which includes the task itself + n cooldownds

        // if multipliple tasks share this max freq, maxCount tasks,
        // they're all in the final row

        // so min time ends up being time = (maxf - 1) * (n+1) + maxCount
        // if num of tasks is larger than the time, then we'll return
        // max(len(tasks), time)

        int[] count = new int[26];
        for(char task : tasks){
            // increase count of appearance
            count[task - 'A']++;  
        }

        int maxf = Arrays.stream(count).max().getAsInt();
        // initialize maxF, which returns highest task freq
        // (made as stream just bc it's easier to get max htat way)
        int maxCount = 0;
        for(int i : count){
            if (i == maxf) maxCount++; // count how many tasks
            // have the highest freq
        }

        int time = (maxf - 1) * (n + 1) + maxCount; // time
        return Math.max(tasks.length, time); //return either 
        // assuming that they all like appear once
        // so they all have constant time and it wouldn't 
        // make sense otherwise
    } 
}
