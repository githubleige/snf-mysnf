package it.heima.main;

import java.io.File;

public class TestRenameFile_1 {

    private static final String source_file="C:\\Users\\20013129\\Desktop\\rowmapper_validate\\rowmapper_zqt_rowmapper";

    private static final String target_file="C:\\Users\\20013129\\Desktop\\rowmapper_validate\\rowmapper_zqt_rowmapper\\";

    public static void main(String[] args) throws Exception{
        fileList(new File(source_file));
    }

    public static void fileList(File file) throws Exception{
        File[] files = file.listFiles();
        boolean result;
        if (files != null){
            for (File f : files){
                System.out.println(f.getName());
                if(f.isFile()&&f.getName().endsWith("RowMapper.java")){
                    result=f.renameTo(new File(target_file+f.getName()));
                    if(!result){
                        throw new Exception("文件转移失败");
                    }
                }else if(f.isDirectory()){
                    fileList(f);
                }else if(f.isFile()){
                }
                else{
                    throw new Exception("特殊异常");
                }
            }
        }
    }
}
