class FileSystem {
    
    File root;
    public FileSystem() {
        root = new File("");
    }
    
    public List<String> ls(String path) {
        File cur = root;
        String[] pathData = path.split("/");
        for (int i = 1; i < pathData.length; i++) {
            cur = cur.children.get(pathData[i]);
        }
        if (cur.isFile) {
            return List.of(cur.name);
        } else {
            List<String> res = new ArrayList<>(cur.children.keySet());
            Collections.sort(res);
            return res;
        }
    }
    
    public void mkdir(String path) {
        String[] pathData = path.split("/");
        File cur = root;
        for (int i = 1; i < pathData.length; i++) {
            cur.children.putIfAbsent(pathData[i], new File(pathData[i]));
            cur = cur.children.get(pathData[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
         String[] pathData = filePath.split("/");
         File cur = root;
        for (int i = 1; i < pathData.length; i++) {
            cur.children.putIfAbsent(pathData[i], new File(pathData[i]));
            cur = cur.children.get(pathData[i]);
        }
        cur.content = cur.content + content;
        //因为可能是新的文件，所以必须设置isFile
        cur.isFile = true;
    }
    
    public String readContentFromFile(String filePath) {
        String[] pathData = filePath.split("/");
         File cur = root;
        for (int i = 1; i < pathData.length; i++) {
            cur = cur.children.get(pathData[i]);
        }
        return cur.content;
    }
    
    class File {
        Map<String, File> children = new HashMap<>();
        String name;
        String content = "";
        boolean isFile;
        File (String name) {
            this.name = name;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */