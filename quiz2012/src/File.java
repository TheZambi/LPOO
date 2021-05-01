import java.util.Objects;

public class File extends Node {
    Folder parent;
    String name;
    int size = 0;
    char separator = '/';

    public void setSeparator(char separator) {
        this.separator = separator;
    }

    public File(Folder parent, String name) throws DuplicateNameException {
        if(parent.checkDuplicate(name))
            throw new DuplicateNameException();
        this.parent = parent;
        this.name = name;
        parent.addChild(this);
    }

    public File(Folder parent, String name, int size) throws DuplicateNameException {
        if(parent.checkDuplicate(name))
            throw new DuplicateNameException();
        this.parent = parent;
        this.name = name;
        parent.addChild(this);
        this.size=size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public Folder getParent() {
        return parent;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPath() {
        return parent.getPath() + separator + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return size == file.size &&
                Objects.equals(name, file.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
}
