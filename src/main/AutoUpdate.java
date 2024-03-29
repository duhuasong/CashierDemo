package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * @Date: 2019/8/25
 * @Description:
 * @Modified By:
 */
public class AutoUpdate {
    public static void main(String[] args) {
        Properties properties = new Properties();
        String localVersion;
        String serverVision;
        String ServerURL;
        String jarName;
        char i = 'a';
        JarURLConnection jarConnection = null;
        String configFile = "./config/config.properties";
        try {
            properties.load(
                    new InputStreamReader(new FileInputStream(new File(configFile).getAbsolutePath()), "UTF-8"));
            ServerURL = properties.getProperty("url");
            jarName = properties.getProperty("jarname");
        } catch (IOException e) {
            System.out.println("读取更新配置文件失败");
            return;
        }
 
 
        System.out.println("正在检查更新……");
        try {
            //检查本地文件的版本信息
            JarFile localJarFile = new JarFile("./lib/"+jarName);
            localVersion = localJarFile.getManifest().getMainAttributes().getValue("Manifest-Version");
            localJarFile.close();
            System.out.println("当前版本："+localVersion);
        } catch (IOException e) {
            System.out.println("【警告】获取不到本地文件信息，正在创建新的本地文件……");
            localVersion = "";
        }
 
        try {
            // 检查服务器上的文件信息，查看是否有更新
            URL url = new URL("jar:"+ServerURL+"!/");
            jarConnection = (JarURLConnection)url.openConnection();
            Manifest manifest = jarConnection.getManifest();
            serverVision = manifest.getMainAttributes().getValue("Manifest-Version");
            System.out.println("最新版本："+serverVision);
        } catch (IOException e) {
            System.out.println("加载更新失败……请检查网络后再试!");
            System.out.println("url:"+e.getMessage());
            return;
        }
 
        if (!localVersion.equals("")){
            if(localVersion.equals(serverVision)){
                System.out.println("当前版本已是最新！");
                return;
            }else if (Double.parseDouble(localVersion)>Double.parseDouble(serverVision)){
                System.out.println("发现旧的版本，是否还原？(y/n)");
                while (true){
                    try {
                        i = (char)System.in.read();
                    } catch (IOException e) {
                        System.out.println("请输入正确格式！");
                    }
                    if(i=='y'){
                        break;
                    }else if(i=='n')
                        return;
                }
            }
        }
 
        System.out.println("下载中……请稍后……");
        FileTool.downloadByNIO2(ServerURL,"./lib", jarName);
        System.out.println("更新成功...");
    }
}
