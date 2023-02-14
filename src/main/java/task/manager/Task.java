package task.manager;

public class Task {
   private String title;
   private int time;
   private int start;
   private int end;
   private int interval;
   private boolean active;

   public Task(String title, int start, int end, int interval) {
      this.title = title;
      this.start = start;
      this.end = end;
      this.interval = interval;
   }

   public Task(String title, int time) {
      this.title = title;
      this.time = time;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public boolean isActive() {
      return active;
   }

   public void setActive(boolean active) {
      this.active = active;
   }

   public int getTime() {
      if(isRepeated()) {
         return start;
      }
      return time;
   }

   public void setTime(int time) {
      this.time = time;
   }
   public boolean isRepeated() {
      if (time == 0) {
         return true;
      }
      return false;
   }
   public int getStartTime() {
      if(isRepeated()) {
         return start;
      }
      return time;
   }
   public int getEndTime() {
      if(isRepeated()) {
         return end;
      }
      return time;
   }
   public int getRepeatInterval() {
      if(!isRepeated()) {
         return 0;
      }
      return interval;
   }
   public void setTime(int start, int end, int interval) {
      if(!isRepeated()) {
         time = 0;
      }
      this.start = start;
      this.end = end;
      this.interval = interval;
   }
}
