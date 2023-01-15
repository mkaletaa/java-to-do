public class Task {
   private String content;
   private  boolean done;

    public Task(String content){
        this.content = content;
        this.done = false;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        System.out.println("done1"+this.done);
        if(done==true)
            this.done=false;
        else this.done=true;
        System.out.println("done2"+this.done);

    }
}
