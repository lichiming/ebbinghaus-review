package com.ebbinghaus.review.util;


import java.io.*;
import java.util.List;

public class HtmlPublic {


    public static void createHtmlFile(List<String> mapHtmlString) {

        // 待处理的流
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        FileOutputStream fos;
        try {
            File file;
            if (System.getProperty("os.name").toUpperCase().contains("MAC")) {
                file = new File("/Users/lichiming/Desktop/html/mainpage.html");
            }else{
                file = new File("D:\\nginx-1.21.6\\html\\mainpage.html");

            }

            //如果路径(无论多少层路径)不存在
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fos = new FileOutputStream(file);

            PrintWriter pw = new PrintWriter(fos);

            for (String lineStr : mapHtmlString) {
                pw.println(lineStr);
            }
            pw.close();
            bao.writeTo(fos);
            fos.flush();
            fos.close();
            bao.flush();
            bao.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public static String getMapHtmlFirstString() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>艾宾浩斯记忆遗忘曲线复习器</title>\n" +
                "\t<script type=\"text/javascript\" src=\"./jquery-3.6.0.min.js\"></script>\n" +
                "\n" +
                "\t<script type=\"text/javascript\">\n" +
                "\n" +
                "\t\t$(document).ready(function(){\n" +
                "            $(\"#refresh\").click(function(){\n" +
                "                refresh();\n" +
                "            });\n" +
                "\t\t\t\n" +
                "\n" +
                "\t\t\t$(\"#contentButton\").click(function(){\n" +
                "\t\t\t\n" +
                "\t\t\t\tvar content = $(\"#contentInput\").val();\n" +
                "\n" +
                "\t\t\t\t$.ajax({\n" +
                "\t\t\t\t\ttype:'post',\n" +
                "\t\t\t\t\turl:'http://127.0.0.1:8852/html/add',\n" +
                "\t\t\t\t\tdata:JSON.stringify({\n" +
                "\t\t\t\t\t\t\"content\": content\n" +
                "\t\t\t\t\t}),\n" +
                "\t\t\t\t\tcontentType: \"application/json\",\n" +
                "\t\t\t\t\tsuccess: function (data) {\n" +
                "\t\t\t\t\t\tlocation.reload();\n" +
                "\t\t\t\t\t\t}\t\n" +
                "\t\t\t\t});\n" +
                "\t\t\t});\t\n" +
                "\n" +
                "\n" +
                "            \n" +
                "              \n" +
                "\t\t});\n" +
                "\t</script>\n" +
                "    <style>\n" +
                "\t\ttable tr td{\n" +
                "\t\t\tbackground: #cde8e5\n" +
                "\t\t}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "学习简要：<input id = \"contentInput\" size=\"25\"/>\n" +
                "<button type=\"button\" id=\"contentButton\" >新增任务</button>&nbsp; &nbsp; &nbsp; &nbsp;<br><br><br><br>\n" +
                "<table>" ;

    }

    public static String getMapHtmlLastString() {
        return "</table>\n" +
                "</body>\n" +
                "</html>\n";
    }


}
