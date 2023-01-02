import java.util.Scanner;
public class Task {
   private String content;
   private  String done;

    public void Task(String content){
        this.content = content;
        this.done = " ";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String isDone() {
        return done;
    }

    public void setDone(String done) {
        if(done.equals(" "))
            this.done="✔";
        else this.done=" ";
    }
}
