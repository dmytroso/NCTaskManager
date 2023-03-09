package task.manager;

import java.time.LocalDateTime;

public class Task {
   private String title;
   private LocalDateTime time;
   private LocalDateTime start;
   private LocalDateTime end;
   private int interval;
   private boolean active;
   private boolean repeated;

   public Task(String title, LocalDateTime start, LocalDateTime end, int interval) throws IllegalArgumentException{
      if (interval < 0) {
         throw new IllegalArgumentException("Interval must be more then 0");
      }
      this.title = title;
      this.start = start;
      this.end = end;
      this.interval = interval;
      this.repeated = true;
   }

   public Task(String title, LocalDateTime time) throws IllegalArgumentException {
      if (time == null) {
         throw new IllegalArgumentException("Time cannot be null");
      }
      this.title = title;
      this.time = time;
      this.repeated = false;
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

   public LocalDateTime getTime() {
      if(repeated) {
         return start;
      }
      return time;
   }

   public void setTime(LocalDateTime time) {
      this.time = time;
   }
   
   public boolean isRepeated() {
      return repeated;
   }

   public LocalDateTime getStartTime() {
      if(repeated) {
         return start;
      }
      return time;
   }

   public LocalDateTime getEndTime() {
      if(repeated) {
         return end;
      }
      return time;
   }
   
   public int getRepeatInterval() {
      if(repeated) {
         return interval;
      }
      return 0;
   }

   public void setTime(LocalDateTime start, LocalDateTime end, int interval) throws IllegalArgumentException {
      if (interval < 0) {
         throw new IllegalArgumentException("interval must be > 0 ");
      }
      if (!repeated) {
         this.repeated = true;
      }
      this.start = start;
      this.end = end;
      this.interval = interval;
   }

   public LocalDateTime nextTimeAfter(LocalDateTime current) {

      if (!active) {
         return null;
      } else {
         if (!repeated) {
            if (current.isAfter(time) || current.isEqual(time)) {
               return null;
            }
            return time;
         } else {
            for (LocalDateTime i = start; i.isBefore(end) || i.isEqual(end); i = i.plusSeconds(interval)) {
               if (current.isBefore(i)) {
                  return i;
               }
            }
            return null;
         }
      }
   }
}