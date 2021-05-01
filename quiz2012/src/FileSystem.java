public class FileSystem {
    String type;
    Folder root = new Folder();
    NameFormatter nameFormatter = null;

    public FileSystem(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Folder getRoot() {
        return root;
    }

    public void setNameFormatter(NameFormatter unix) {
        this.nameFormatter = unix;
        root.setSeparator(unix.getSeparator());
    }
}
