package Day_3_PaintBrick;

import java.util.List;

public class Brick {
    private int id ;
    private boolean invisible;
    private List<String> comments;
    private List<String> contents;

    public Brick(){

    }
    public Brick(int id){
        this.id = id;
        this.invisible = false;
    }

    public int getId(){
        return this.id;
    }
    
    public void setInvisible(){
        this.invisible = true;
    }

    public void addComments(String comment){
        comments.add(comment);
    }

    public void addContents(String content){
        contents.add(content);
    }

    public boolean showInvisibility(){
        return this.invisible;
    }

    public List<String> showComments(){
        return comments;
    }
    
    public List<String> showContents(){
        return contents;
    }
}
