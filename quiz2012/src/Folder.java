import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Folder extends Node{
    Folder parent = null;
    String name = "";
    List<Node>  childs = new ArrayList<>();
    int size = 0;
    char separator = '/';

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }

    public Folder(){}

    public Folder(Folder parent, String name) {
        super();
        this.parent = parent;
        this.name = name;
        parent.addChild(this);
    }

    public Folder(Folder parent, String name, int size) {
        super();
        this.parent = parent;
        this.name = name;
        parent.addChild(this);
        this.size = size;
    }

    public int getSize() {
        int total = size;
        for(Node chl : childs)
            total += chl.getSize();
        return total;
    }

    @Override
    public int getNumber() {
        return thisNumber;
    }

    public Folder getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public void addChild(Node child) {
        this.childs.add(child);
    }

    public Object[] getChild() {
        return childs.toArray();
    }

    public Object getChildByName(String bin) {
        for(Node nd : childs){
            if(nd.getName().equals(bin))
                return nd;
        }
        return null;
    }

    public boolean checkDuplicate(String name)
    {
        for(Node nd : childs){
            if(nd.getName().equals(name))
                return true;
        }
        return false;
    }

    public void setSeparator(char separator) {
        this.separator = separator;
        for(Node nd : childs)
            nd.setSeparator(separator);
    }


    public String getPath() {
        if(parent!=null)
            return parent.getPath() + separator + this.getName();
        return this.getName();
    }

    protected Folder clone(Folder folder, String name) throws DuplicateNameException {
        Folder cloned = new Folder(folder,name);
        for(Node chl : childs){
            if(chl instanceof File)
                new File(cloned,chl.getName(), chl.getSize());
            else if(chl instanceof Folder)
                new Folder(cloned,chl.getName());
        }
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folder folder = (Folder) o;
        return Objects.equals(name, folder.name) &&
                Objects.equals(childs, folder.childs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, childs);
    }
}
