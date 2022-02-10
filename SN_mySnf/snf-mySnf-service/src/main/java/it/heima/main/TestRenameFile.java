package it.heima.main;

import java.io.File;

public class TestRenameFile {
    public static void main(String[] args) throws Exception{
        fileList();
    }

    public static void fileList() throws Exception{
        File file=new File("C:\\Users\\20013129\\Desktop\\rowmapper_validate\\rowmapper_zqt_rowmapper\\");
        String rename_file_dir="C:\\Users\\20013129\\Desktop\\rowmapper_validate\\rowmapper_zqt_rowmapper_delete_wf\\";
        File[] files = file.listFiles();
        String source_file;
        String target_file;
        File target;
        boolean result;
        if (files != null) {
            for (File f : files) {
                System.out.println(f.getName());
                if(f.getName().startsWith("Wf")){
                    target=new File(rename_file_dir+f.getName().substring(2));
                    result=f.renameTo(target);
                    if(!result){
                        throw new Exception("文件转移失败");
                    }
                }else{
                    target=new File(rename_file_dir+f.getName());
                    result=f.renameTo(target);
                    if(!result){
                        throw new Exception("文件转移失败");
                    }
                }
            }
        }
    }
}
